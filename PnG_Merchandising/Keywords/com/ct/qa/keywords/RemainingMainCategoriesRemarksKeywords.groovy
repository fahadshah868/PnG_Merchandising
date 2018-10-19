package com.ct.qa.keywords

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.apache.poi.xssf.usermodel.XSSFSheet
import org.openqa.selenium.By
import com.ct.qa.constants.ProjectConstants
import com.ct.qa.struct.ChannelProduct
import com.ct.qa.struct.MissingCategoryRemarkData
import com.ct.qa.struct.MissingMainCategoryData
import com.ct.qa.struct.MissingSubCategoryData
import com.ct.qa.struct.ProductWithValue
import com.ct.qa.struct.Questions
import com.ct.qa.struct.UnmatchedItems
import com.ct.qa.struct.VisitedCategoryData
import com.ct.qa.struct.VisitedShopDataInfo
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement

public class RemainingMainCategoriesRemarksKeywords {

	AppiumDriver<MobileElement> driver = ProjectConstants.DRIVER;

	@Keyword
	def validateCategoryDetailActionScreen(){
		boolean flag = false
		Mobile.verifyElementExist(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/Validate_MainCategoryDetailActionScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
		int totalactions = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<= totalactions; i++){
			flag = false
			MobileElement action = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			String actionname = action.getText()
			if(actionname.equalsIgnoreCase("Availability")){
				flag = true
				break
			}
		}
		if(flag == false){
			KeywordUtil.markErrorAndStop("Main Category Detail Screen Could Not Found")
		}
		else{}
	}

	// for availability remark -----------------------------------------
	@Keyword
	def visitVisibilitySubCategories(int status){
		UnmatchedItems UnmatchedItems_status = CompareDataKeywords.compareShopRemainingCategoryAvailabilitySubCategories()
		if(UnmatchedItems_status.getStatus() == 2){
			ArrayList<MissingMainCategoryData> missingmaincategories = new ArrayList<MissingMainCategoryData>()
			ArrayList<MissingCategoryRemarkData> missingcategoryremarks = new ArrayList<MissingCategoryRemarkData>()
			ArrayList<MissingSubCategoryData> missingsubcategories = new ArrayList<MissingSubCategoryData>()
			for(int i=0; i< UnmatchedItems_status.getItems().size() ; i++){
				MissingSubCategoryData missingsubcategory = new MissingSubCategoryData()
				String missingcategory = UnmatchedItems_status.getItems().get(i)
				missingsubcategory.setSubcategory(missingcategory)
				missingsubcategories.add(missingsubcategory)
			}
			MissingMainCategoryData missingmaincategory = new MissingMainCategoryData()
			MissingCategoryRemarkData missingcategoryremark = new MissingCategoryRemarkData()
			missingcategoryremark.setCategoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
			missingcategoryremark.setMissingsubcategories(missingsubcategories)
			missingcategoryremark.setMissingsubcategories_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_NOTMATCH)
			missingcategoryremarks.add(missingcategoryremark)
			missingmaincategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingmaincategory.setMissingcategoryremarks(missingcategoryremarks)
			missingmaincategories.add(missingmaincategory)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ArrayList<MissingMainCategoryData> existingmissingmaincatergories = ProjectConstants.missingshopdatainfo.get(j).getMissingmaincategories()
					if(existingmissingmaincatergories != null){
						for(int m=0; m< existingmissingmaincatergories.size(); m++){
							if(existingmissingmaincatergories.get(m).getMaincategory().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_MAINCATEGORY)){
								existingmissingmaincatergories.get(m).setMissingcategoryremarks(missingcategoryremarks)
							}
							else{
								ProjectConstants.missingshopdatainfo.get(j).setMissingmaincategories(missingmaincategories)
								break
							}
						}
					}
					else{
						ProjectConstants.missingshopdatainfo.get(j).setMissingmaincategories(missingmaincategories)
					}
				}
				else{
				}
			}
		}
		else if(UnmatchedItems_status.getStatus() == 1){
			ArrayList<MissingMainCategoryData> missingmaincategories = new ArrayList<MissingMainCategoryData>()
			ArrayList<MissingCategoryRemarkData> missingcategoryremarks = new ArrayList<MissingCategoryRemarkData>()
			ArrayList<MissingSubCategoryData> missingsubcategories = new ArrayList<MissingSubCategoryData>()
			for(int i=0; i< UnmatchedItems_status.getItems().size() ; i++){
				MissingSubCategoryData missingsubcategory = new MissingSubCategoryData()
				String missingcategory = UnmatchedItems_status.getItems().get(i)
				missingsubcategory.setSubcategory(missingcategory)
				missingsubcategories.add(missingsubcategory)
			}
			MissingMainCategoryData missingmaincategory = new MissingMainCategoryData()
			MissingCategoryRemarkData missingcategoryremark = new MissingCategoryRemarkData()
			missingcategoryremark.setCategoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
			missingcategoryremark.setMissingsubcategories(missingsubcategories)
			missingcategoryremark.setMissingsubcategories_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MORE)
			missingcategoryremarks.add(missingcategoryremark)
			missingmaincategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingmaincategory.setMissingcategoryremarks(missingcategoryremarks)
			missingmaincategories.add(missingmaincategory)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ArrayList<MissingMainCategoryData> existingmissingmaincatergories = ProjectConstants.missingshopdatainfo.get(j).getMissingmaincategories()
					if(existingmissingmaincatergories != null){
						for(int m=0; m< existingmissingmaincatergories.size(); m++){
							if(existingmissingmaincatergories.get(m).getMaincategory().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_MAINCATEGORY)){
								existingmissingmaincatergories.get(m).setMissingcategoryremarks(missingcategoryremarks)
							}
							else{
								ProjectConstants.missingshopdatainfo.get(j).setMissingmaincategories(missingmaincategories)
								break
							}
						}
					}
					else{
						ProjectConstants.missingshopdatainfo.get(j).setMissingmaincategories(missingmaincategories)
					}
				}
				else{
				}
			}
		}
		else if(UnmatchedItems_status.getStatus() == -1){
			ArrayList<MissingMainCategoryData> missingmaincategories = new ArrayList<MissingMainCategoryData>()
			ArrayList<MissingCategoryRemarkData> missingcategoryremarks = new ArrayList<MissingCategoryRemarkData>()
			ArrayList<MissingSubCategoryData> missingsubcategories = new ArrayList<MissingSubCategoryData>()
			for(int i=0; i< UnmatchedItems_status.getItems().size() ; i++){
				MissingSubCategoryData missingsubcategory = new MissingSubCategoryData()
				String missingcategory = UnmatchedItems_status.getItems().get(i)
				missingsubcategory.setSubcategory(missingcategory)
				missingsubcategories.add(missingsubcategory)
			}
			MissingMainCategoryData missingmaincategory = new MissingMainCategoryData()
			MissingCategoryRemarkData missingcategoryremark = new MissingCategoryRemarkData()
			missingcategoryremark.setCategoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
			missingcategoryremark.setMissingsubcategories(missingsubcategories)
			missingcategoryremark.setMissingsubcategories_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MISSING)
			missingcategoryremarks.add(missingcategoryremark)
			missingmaincategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingmaincategory.setMissingcategoryremarks(missingcategoryremarks)
			missingmaincategories.add(missingmaincategory)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ArrayList<MissingMainCategoryData> existingmissingmaincatergories = ProjectConstants.missingshopdatainfo.get(j).getMissingmaincategories()
					if(existingmissingmaincatergories != null){
						for(int m=0; m< existingmissingmaincatergories.size(); m++){
							if(existingmissingmaincatergories.get(m).getMaincategory().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_MAINCATEGORY)){
								existingmissingmaincatergories.get(m).setMissingcategoryremarks(missingcategoryremarks)
							}
							else{
								ProjectConstants.missingshopdatainfo.get(j).setMissingmaincategories(missingmaincategories)
								break
							}
						}
					}
					else{
						ProjectConstants.missingshopdatainfo.get(j).setMissingmaincategories(missingmaincategories)
					}
				}
				else{
				}
			}
		}
		else{
		}
		int totalsubcategories = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<= totalsubcategories; i++){
			MobileElement category = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			String categoryname = category.getText()
			ProjectConstants.CURRENTVISITING_SUBCATEGORY = categoryname
			ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
			if(status == 1){
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/Availability/VisitSubCategories_WithYesRemarks"), null)
			}
			else{
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/Availability/VisitSubCategories_WithNoRemarks"), null)
			}
		}
	}
	@Keyword
	def visitProductsAvailabilityWithYesRemarks(){
		ArrayList<String> displayedproducts = new ArrayList<String>()
		ArrayList<ProductWithValue> productswithvalue = LoadDataKeywords.loadChannelWiseProductsList(LoadDataKeywords.loadChannelProductsSheet(), ProjectConstants.DISPLAYSPACEAVAILABLE)
		ArrayList<String> expectedproducts = new ArrayList<String>()
		for(int i=0; i< productswithvalue.size(); i++){
			expectedproducts.add(productswithvalue.get(i).getProduct())
		}
		int index = 0
		int totalproducts = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*").size()
		for(int i=1; i<= totalproducts; i=i+2){
			index = index + 1
			MobileElement product = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")
			String productname = product.getText()
			displayedproducts.add(productname)
			ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.RadioGroup[1]/android.widget.RadioButton[1]").click()
		}
		if(totalproducts >= 17){
			while(true){
				boolean flag = true
				MobileElement productbeforeswipe = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[9]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")
				String productnamebeforeswipe = productbeforeswipe.getText()
				Mobile.swipe(0, 275, 0, 200)
				MobileElement productafterswipe = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[9]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")
				String productnameafterswipe = productafterswipe.getText()
				if(productnamebeforeswipe.equals(productnameafterswipe)){
					flag = false
					break
				}
				else{
					MobileElement product = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[9]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")
					String productname = product.getText()
					displayedproducts.add(productname)
					ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[9]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.RadioGroup[1]/android.widget.RadioButton[1]").click()
				}
				if(flag == true){
					productbeforeswipe = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[9]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")
					productnamebeforeswipe = productbeforeswipe.getText()
					Mobile.swipe(0, 274, 0, 200)
					productafterswipe = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[9]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")
					productnameafterswipe = productafterswipe.getText()
					if(productnamebeforeswipe.equals(productnameafterswipe)){
						break
					}
					else{
						MobileElement product = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[9]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")
						String productname = product.getText()
						displayedproducts.add(productname)
						ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[9]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.RadioGroup[1]/android.widget.RadioButton[1]").click()
					}
				}
				else{

				}
			}
		}
		UnmatchedItems UnmatchedItems_status = CompareDataKeywords.compareLists(expectedproducts, displayedproducts)
		if(UnmatchedItems_status.getStatus() == 2){
			ArrayList<MissingMainCategoryData> missingmaincategories = new ArrayList<MissingMainCategoryData>()
			ArrayList<MissingCategoryRemarkData> missingcategoryremarks = new ArrayList<MissingCategoryRemarkData>()
			ArrayList<MissingSubCategoryData> missingsubcategories = new ArrayList<MissingSubCategoryData>()
			ArrayList<String> products = new ArrayList<String>()
			MissingMainCategoryData missingmaincategory = new MissingMainCategoryData()
			MissingCategoryRemarkData missingcategoryremark = new MissingCategoryRemarkData()
			MissingSubCategoryData missingsubcategory = new MissingSubCategoryData()
			missingsubcategory.setSubcategory(ProjectConstants.CURRENTVISITING_SUBCATEGORY)
			missingsubcategory.setProducts(UnmatchedItems_status.getItems())
			missingsubcategory.setProducts_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_NOTMATCH)
			missingsubcategories.add(missingsubcategory)
			missingcategoryremark.setCategoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
			missingcategoryremark.setMissingsubcategories(missingsubcategories)
			missingcategoryremarks.add(missingcategoryremark)
			missingmaincategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingmaincategory.setMissingcategoryremarks(missingcategoryremarks)
			missingmaincategories.add(missingmaincategory)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ArrayList<MissingMainCategoryData> existingmissingmaincatergories = ProjectConstants.missingshopdatainfo.get(j).getMissingmaincategories()
					if(existingmissingmaincatergories != null){
						for(int m=0; m< existingmissingmaincatergories.size(); m++){
							if(existingmissingmaincatergories.get(m).getMaincategory().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_MAINCATEGORY)){
								existingmissingmaincatergories.get(m).setMissingcategoryremarks(missingcategoryremarks)
							}
							else{
								ProjectConstants.missingshopdatainfo.get(j).setMissingmaincategories(missingmaincategories)
								break
							}
						}
					}
					else{
						ProjectConstants.missingshopdatainfo.get(j).setMissingmaincategories(missingmaincategories)
					}
				}
				else{
				}
			}
		}
		else if(UnmatchedItems_status.getStatus() == 1){
			ArrayList<MissingMainCategoryData> missingmaincategories = new ArrayList<MissingMainCategoryData>()
			ArrayList<MissingCategoryRemarkData> missingcategoryremarks = new ArrayList<MissingCategoryRemarkData>()
			ArrayList<MissingSubCategoryData> missingsubcategories = new ArrayList<MissingSubCategoryData>()
			ArrayList<String> products = new ArrayList<String>()
			MissingMainCategoryData missingmaincategory = new MissingMainCategoryData()
			MissingCategoryRemarkData missingcategoryremark = new MissingCategoryRemarkData()
			MissingSubCategoryData missingsubcategory = new MissingSubCategoryData()
			missingsubcategory.setSubcategory(ProjectConstants.CURRENTVISITING_SUBCATEGORY)
			missingsubcategory.setProducts(UnmatchedItems_status.getItems())
			missingsubcategory.setProducts_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MORE)
			missingsubcategories.add(missingsubcategory)
			missingcategoryremark.setCategoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
			missingcategoryremark.setMissingsubcategories(missingsubcategories)
			missingcategoryremarks.add(missingcategoryremark)
			missingmaincategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingmaincategory.setMissingcategoryremarks(missingcategoryremarks)
			missingmaincategories.add(missingmaincategory)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ArrayList<MissingMainCategoryData> existingmissingmaincatergories = ProjectConstants.missingshopdatainfo.get(j).getMissingmaincategories()
					if(existingmissingmaincatergories != null){
						for(int m=0; m< existingmissingmaincatergories.size(); m++){
							if(existingmissingmaincatergories.get(m).getMaincategory().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_MAINCATEGORY)){
								existingmissingmaincatergories.get(m).setMissingcategoryremarks(missingcategoryremarks)
							}
							else{
								ProjectConstants.missingshopdatainfo.get(j).setMissingmaincategories(missingmaincategories)
								break
							}
						}
					}
					else{
						ProjectConstants.missingshopdatainfo.get(j).setMissingmaincategories(missingmaincategories)
					}
				}
				else{
				}
			}
		}
		else if(UnmatchedItems_status.getStatus() == -1){
			ArrayList<MissingMainCategoryData> missingmaincategories = new ArrayList<MissingMainCategoryData>()
			ArrayList<MissingCategoryRemarkData> missingcategoryremarks = new ArrayList<MissingCategoryRemarkData>()
			ArrayList<MissingSubCategoryData> missingsubcategories = new ArrayList<MissingSubCategoryData>()
			ArrayList<String> products = new ArrayList<String>()
			MissingMainCategoryData missingmaincategory = new MissingMainCategoryData()
			MissingCategoryRemarkData missingcategoryremark = new MissingCategoryRemarkData()
			MissingSubCategoryData missingsubcategory = new MissingSubCategoryData()
			missingsubcategory.setSubcategory(ProjectConstants.CURRENTVISITING_SUBCATEGORY)
			missingsubcategory.setProducts(UnmatchedItems_status.getItems())
			missingsubcategory.setProducts_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MISSING)
			missingsubcategories.add(missingsubcategory)
			missingcategoryremark.setCategoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
			missingcategoryremark.setMissingsubcategories(missingsubcategories)
			missingcategoryremarks.add(missingcategoryremark)
			missingmaincategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingmaincategory.setMissingcategoryremarks(missingcategoryremarks)
			missingmaincategories.add(missingmaincategory)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ArrayList<MissingMainCategoryData> existingmissingmaincatergories = ProjectConstants.missingshopdatainfo.get(j).getMissingmaincategories()
					if(existingmissingmaincatergories != null){
						for(int m=0; m< existingmissingmaincatergories.size(); m++){
							if(existingmissingmaincatergories.get(m).getMaincategory().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_MAINCATEGORY)){
								existingmissingmaincatergories.get(m).setMissingcategoryremarks(missingcategoryremarks)
							}
							else{
								ProjectConstants.missingshopdatainfo.get(j).setMissingmaincategories(missingmaincategories)
								break
							}
						}
					}
					else{
						ProjectConstants.missingshopdatainfo.get(j).setMissingmaincategories(missingmaincategories)
					}
				}
				else{
				}
			}
		}
		else{
		}
	}
	@Keyword
	def visitProductsAvailabilityWithNoRemarks(){
		ArrayList<String> displayedproducts = new ArrayList<String>()
		ArrayList<ProductWithValue> productswithvalue = LoadDataKeywords.loadChannelWiseProductsList(LoadDataKeywords.loadChannelProductsSheet(), ProjectConstants.DISPLAYSPACEAVAILABLE)
		ArrayList<String> expectedproducts = new ArrayList<String>()
		for(int i=0; i< productswithvalue.size(); i++){
			expectedproducts.add(productswithvalue.get(i).getProduct())
		}
		int index = 0
		int totalproducts = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*").size()
		for(int i=1; i<= totalproducts; i=i+2){
			index = index + 1
			MobileElement product = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")
			String productname = product.getText()
			displayedproducts.add(productname)
			ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.RadioGroup[1]/android.widget.RadioButton[2]").click()
		}
		if(totalproducts >= 17){
			while(true){
				boolean flag = true
				MobileElement productbeforeswipe = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[9]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")
				String productnamebeforeswipe = productbeforeswipe.getText()
				Mobile.swipe(0, 275, 0, 200)
				MobileElement productafterswipe = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[9]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")
				String productnameafterswipe = productafterswipe.getText()
				if(productnamebeforeswipe.equals(productnameafterswipe)){
					flag = false
					break
				}
				else{
					MobileElement product = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[9]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")
					String productname = product.getText()
					displayedproducts.add(productname)
					ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[9]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.RadioGroup[1]/android.widget.RadioButton[2]").click()
				}
				if(flag == true){
					productbeforeswipe = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[9]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")
					productnamebeforeswipe = productbeforeswipe.getText()
					Mobile.swipe(0, 274, 0, 200)
					productafterswipe = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[9]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")
					productnameafterswipe = productafterswipe.getText()
					if(productnamebeforeswipe.equals(productnameafterswipe)){
						break
					}
					else{
						MobileElement product = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[9]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")
						String productname = product.getText()
						displayedproducts.add(productname)
						ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[9]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.RadioGroup[1]/android.widget.RadioButton[1]").click()
					}
				}
				else{

				}
			}
		}
		UnmatchedItems UnmatchedItems_status = CompareDataKeywords.compareLists(expectedproducts, displayedproducts)
		if(UnmatchedItems_status.getStatus() == 2){
			ArrayList<MissingMainCategoryData> missingmaincategories = new ArrayList<MissingMainCategoryData>()
			ArrayList<MissingCategoryRemarkData> missingcategoryremarks = new ArrayList<MissingCategoryRemarkData>()
			ArrayList<MissingSubCategoryData> missingsubcategories = new ArrayList<MissingSubCategoryData>()
			ArrayList<String> products = new ArrayList<String>()
			MissingMainCategoryData missingmaincategory = new MissingMainCategoryData()
			MissingCategoryRemarkData missingcategoryremark = new MissingCategoryRemarkData()
			MissingSubCategoryData missingsubcategory = new MissingSubCategoryData()
			missingsubcategory.setSubcategory(ProjectConstants.CURRENTVISITING_SUBCATEGORY)
			missingsubcategory.setProducts(UnmatchedItems_status.getItems())
			missingsubcategory.setProducts_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_NOTMATCH)
			missingsubcategories.add(missingsubcategory)
			missingcategoryremark.setCategoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
			missingcategoryremark.setMissingsubcategories(missingsubcategories)
			missingcategoryremarks.add(missingcategoryremark)
			missingmaincategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingmaincategory.setMissingcategoryremarks(missingcategoryremarks)
			missingmaincategories.add(missingmaincategory)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ArrayList<MissingMainCategoryData> existingmissingmaincatergories = ProjectConstants.missingshopdatainfo.get(j).getMissingmaincategories()
					if(existingmissingmaincatergories != null){
						for(int m=0; m< existingmissingmaincatergories.size(); m++){
							if(existingmissingmaincatergories.get(m).getMaincategory().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_MAINCATEGORY)){
								existingmissingmaincatergories.get(m).setMissingcategoryremarks(missingcategoryremarks)
							}
							else{
								ProjectConstants.missingshopdatainfo.get(j).setMissingmaincategories(missingmaincategories)
								break
							}
						}
					}
					else{
						ProjectConstants.missingshopdatainfo.get(j).setMissingmaincategories(missingmaincategories)
					}
				}
				else{
				}
			}
		}
		else if(UnmatchedItems_status.getStatus() == 1){
			ArrayList<MissingMainCategoryData> missingmaincategories = new ArrayList<MissingMainCategoryData>()
			ArrayList<MissingCategoryRemarkData> missingcategoryremarks = new ArrayList<MissingCategoryRemarkData>()
			ArrayList<MissingSubCategoryData> missingsubcategories = new ArrayList<MissingSubCategoryData>()
			ArrayList<String> products = new ArrayList<String>()
			MissingMainCategoryData missingmaincategory = new MissingMainCategoryData()
			MissingCategoryRemarkData missingcategoryremark = new MissingCategoryRemarkData()
			MissingSubCategoryData missingsubcategory = new MissingSubCategoryData()
			missingsubcategory.setSubcategory(ProjectConstants.CURRENTVISITING_SUBCATEGORY)
			missingsubcategory.setProducts(UnmatchedItems_status.getItems())
			missingsubcategory.setProducts_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MORE)
			missingsubcategories.add(missingsubcategory)
			missingcategoryremark.setCategoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
			missingcategoryremark.setMissingsubcategories(missingsubcategories)
			missingcategoryremarks.add(missingcategoryremark)
			missingmaincategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingmaincategory.setMissingcategoryremarks(missingcategoryremarks)
			missingmaincategories.add(missingmaincategory)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ArrayList<MissingMainCategoryData> existingmissingmaincatergories = ProjectConstants.missingshopdatainfo.get(j).getMissingmaincategories()
					if(existingmissingmaincatergories != null){
						for(int m=0; m< existingmissingmaincatergories.size(); m++){
							if(existingmissingmaincatergories.get(m).getMaincategory().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_MAINCATEGORY)){
								existingmissingmaincatergories.get(m).setMissingcategoryremarks(missingcategoryremarks)
							}
							else{
								ProjectConstants.missingshopdatainfo.get(j).setMissingmaincategories(missingmaincategories)
								break
							}
						}
					}
					else{
						ProjectConstants.missingshopdatainfo.get(j).setMissingmaincategories(missingmaincategories)
					}
				}
				else{
				}
			}
		}
		else if(UnmatchedItems_status.getStatus() == -1){
			ArrayList<MissingMainCategoryData> missingmaincategories = new ArrayList<MissingMainCategoryData>()
			ArrayList<MissingCategoryRemarkData> missingcategoryremarks = new ArrayList<MissingCategoryRemarkData>()
			ArrayList<MissingSubCategoryData> missingsubcategories = new ArrayList<MissingSubCategoryData>()
			ArrayList<String> products = new ArrayList<String>()
			MissingMainCategoryData missingmaincategory = new MissingMainCategoryData()
			MissingCategoryRemarkData missingcategoryremark = new MissingCategoryRemarkData()
			MissingSubCategoryData missingsubcategory = new MissingSubCategoryData()
			missingsubcategory.setSubcategory(ProjectConstants.CURRENTVISITING_SUBCATEGORY)
			missingsubcategory.setProducts(UnmatchedItems_status.getItems())
			missingsubcategory.setProducts_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MISSING)
			missingsubcategories.add(missingsubcategory)
			missingcategoryremark.setCategoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
			missingcategoryremark.setMissingsubcategories(missingsubcategories)
			missingcategoryremarks.add(missingcategoryremark)
			missingmaincategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingmaincategory.setMissingcategoryremarks(missingcategoryremarks)
			missingmaincategories.add(missingmaincategory)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ArrayList<MissingMainCategoryData> existingmissingmaincatergories = ProjectConstants.missingshopdatainfo.get(j).getMissingmaincategories()
					if(existingmissingmaincatergories != null){
						for(int m=0; m< existingmissingmaincatergories.size(); m++){
							if(existingmissingmaincatergories.get(m).getMaincategory().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_MAINCATEGORY)){
								existingmissingmaincatergories.get(m).setMissingcategoryremarks(missingcategoryremarks)
							}
							else{
								ProjectConstants.missingshopdatainfo.get(j).setMissingmaincategories(missingmaincategories)
								break
							}
						}
					}
					else{
						ProjectConstants.missingshopdatainfo.get(j).setMissingmaincategories(missingmaincategories)
					}
				}
				else{
				}
			}
		}
		else{
		}
	}

	// for primary display remark -----------------------------------------
	@Keyword
	def selectPrimaryDisplayRemark(String _remark){
		int totalremarks = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<= totalremarks; i++){
			MobileElement remark = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			String remarkname = remark.getText()
			if(remarkname.equalsIgnoreCase(_remark)){
				driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				break
			}
		}
	}
	@Keyword
	def visitPrimaryDisplay_WithDSASubCategories(int status){
		UnmatchedItems UnmatchedItems_status = CompareDataKeywords.compareShopRemainingCategoryDisplaySpaceAvailableSubCategories()
		if(UnmatchedItems_status.getStatus() == 2){
			ArrayList<MissingMainCategoryData> missingmaincategories = new ArrayList<MissingMainCategoryData>()
			ArrayList<MissingCategoryRemarkData> missingcategoryremarks = new ArrayList<MissingCategoryRemarkData>()
			ArrayList<MissingSubCategoryData> missingsubcategories = new ArrayList<MissingSubCategoryData>()
			for(int i=0; i< UnmatchedItems_status.getItems().size() ; i++){
				MissingSubCategoryData missingsubcategory = new MissingSubCategoryData()
				String missingcategory = UnmatchedItems_status.getItems().get(i)
				missingsubcategory.setSubcategory(missingcategory)
				missingsubcategories.add(missingsubcategory)
			}
			MissingMainCategoryData missingmaincategory = new MissingMainCategoryData()
			MissingCategoryRemarkData missingcategoryremark = new MissingCategoryRemarkData()
			missingcategoryremark.setCategoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
			missingcategoryremark.setMissingsubcategories(missingsubcategories)
			missingcategoryremark.setMissingsubcategories_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_NOTMATCH)
			missingcategoryremarks.add(missingcategoryremark)
			missingmaincategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingmaincategory.setMissingcategoryremarks(missingcategoryremarks)
			missingmaincategories.add(missingmaincategory)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ArrayList<MissingMainCategoryData> existingmissingmaincatergories = ProjectConstants.missingshopdatainfo.get(j).getMissingmaincategories()
					if(existingmissingmaincatergories != null){
						for(int m=0; m< existingmissingmaincatergories.size(); m++){
							if(existingmissingmaincatergories.get(m).getMaincategory().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_MAINCATEGORY)){
								existingmissingmaincatergories.get(m).setMissingcategoryremarks(missingcategoryremarks)
							}
							else{
								ProjectConstants.missingshopdatainfo.get(j).setMissingmaincategories(missingmaincategories)
								break
							}
						}
					}
					else{
						ProjectConstants.missingshopdatainfo.get(j).setMissingmaincategories(missingmaincategories)
					}
				}
				else{
				}
			}
		}
		else if(UnmatchedItems_status.getStatus() == 1){
			ArrayList<MissingMainCategoryData> missingmaincategories = new ArrayList<MissingMainCategoryData>()
			ArrayList<MissingCategoryRemarkData> missingcategoryremarks = new ArrayList<MissingCategoryRemarkData>()
			ArrayList<MissingSubCategoryData> missingsubcategories = new ArrayList<MissingSubCategoryData>()
			for(int i=0; i< UnmatchedItems_status.getItems().size() ; i++){
				MissingSubCategoryData missingsubcategory = new MissingSubCategoryData()
				String missingcategory = UnmatchedItems_status.getItems().get(i)
				missingsubcategory.setSubcategory(missingcategory)
				missingsubcategories.add(missingsubcategory)
			}
			MissingMainCategoryData missingmaincategory = new MissingMainCategoryData()
			MissingCategoryRemarkData missingcategoryremark = new MissingCategoryRemarkData()
			missingcategoryremark.setCategoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
			missingcategoryremark.setMissingsubcategories(missingsubcategories)
			missingcategoryremark.setMissingsubcategories_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MORE)
			missingcategoryremarks.add(missingcategoryremark)
			missingmaincategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingmaincategory.setMissingcategoryremarks(missingcategoryremarks)
			missingmaincategories.add(missingmaincategory)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ArrayList<MissingMainCategoryData> existingmissingmaincatergories = ProjectConstants.missingshopdatainfo.get(j).getMissingmaincategories()
					if(existingmissingmaincatergories != null){
						for(int m=0; m< existingmissingmaincatergories.size(); m++){
							if(existingmissingmaincatergories.get(m).getMaincategory().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_MAINCATEGORY)){
								existingmissingmaincatergories.get(m).setMissingcategoryremarks(missingcategoryremarks)
							}
							else{
								ProjectConstants.missingshopdatainfo.get(j).setMissingmaincategories(missingmaincategories)
								break
							}
						}
					}
					else{
						ProjectConstants.missingshopdatainfo.get(j).setMissingmaincategories(missingmaincategories)
					}
				}
				else{
				}
			}
		}
		else if(UnmatchedItems_status.getStatus() == -1){
			ArrayList<MissingMainCategoryData> missingmaincategories = new ArrayList<MissingMainCategoryData>()
			ArrayList<MissingCategoryRemarkData> missingcategoryremarks = new ArrayList<MissingCategoryRemarkData>()
			ArrayList<MissingSubCategoryData> missingsubcategories = new ArrayList<MissingSubCategoryData>()
			for(int i=0; i< UnmatchedItems_status.getItems().size() ; i++){
				MissingSubCategoryData missingsubcategory = new MissingSubCategoryData()
				String missingcategory = UnmatchedItems_status.getItems().get(i)
				missingsubcategory.setSubcategory(missingcategory)
				missingsubcategories.add(missingsubcategory)
			}
			MissingMainCategoryData missingmaincategory = new MissingMainCategoryData()
			MissingCategoryRemarkData missingcategoryremark = new MissingCategoryRemarkData()
			missingcategoryremark.setCategoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
			missingcategoryremark.setMissingsubcategories(missingsubcategories)
			missingcategoryremark.setMissingsubcategories_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MISSING)
			missingcategoryremarks.add(missingcategoryremark)
			missingmaincategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingmaincategory.setMissingcategoryremarks(missingcategoryremarks)
			missingmaincategories.add(missingmaincategory)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ArrayList<MissingMainCategoryData> existingmissingmaincatergories = ProjectConstants.missingshopdatainfo.get(j).getMissingmaincategories()
					if(existingmissingmaincatergories != null){
						for(int m=0; m< existingmissingmaincatergories.size(); m++){
							if(existingmissingmaincatergories.get(m).getMaincategory().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_MAINCATEGORY)){
								existingmissingmaincatergories.get(m).setMissingcategoryremarks(missingcategoryremarks)
							}
							else{
								ProjectConstants.missingshopdatainfo.get(j).setMissingmaincategories(missingmaincategories)
								break
							}
						}
					}
					else{
						ProjectConstants.missingshopdatainfo.get(j).setMissingmaincategories(missingmaincategories)
					}
				}
				else{
				}
			}
		}
		else{
		}
		int totalsubcategories = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<= totalsubcategories; i++){
			MobileElement productcategory = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			ProjectConstants.CURRENTVISITING_SUBCATEGORY = productcategory.getText()
			driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
			if(status == 1){
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/PrimaryDisplay/DisplaySpaceAvailable/VisitDSA_SubCategories"), null)
			}
			else{
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/PrimaryDisplay/DisplaySpaceAvailable/OverwriteDSA_SubCategories"), null)
			}
		}
	}
	@Keyword
	def visitDSA_Products(int columnindex){
		ArrayList<ChannelProduct> visitedchannelproducts = new ArrayList<ChannelProduct>()
		ArrayList<String> displayedproducts = new ArrayList<String>()
		ArrayList<String> expectedproducts = new ArrayList<String>()
		int index = 0
		XSSFSheet sheet = LoadDataKeywords.loadChannelProductsSheet()
		ArrayList<ProductWithValue> expectedchannelproducts = LoadDataKeywords.loadChannelWiseProductsList(sheet, columnindex)
		for(int i=0; i< expectedchannelproducts.size(); i++){
			expectedproducts.add(expectedchannelproducts.get(i).getProduct())
		}
		int totalproducts = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*").size()
		for(int i=1; i<= totalproducts; i=i+3){
			ChannelProduct channelproduct = new ChannelProduct()
			boolean flag = false
			index = index + 1
			MobileElement product = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.TextView["+index+"]")
			String productname = product.getText()
			channelproduct.setProduct(productname)
			for(int j=0; j< expectedchannelproducts.size(); j++){
				ProductWithValue expectedchannelproduct = expectedchannelproducts.get(j)
				if(expectedchannelproduct.getProduct().equalsIgnoreCase(productname)){
					flag = true
					MobileElement edittext = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.EditText[1]")
					edittext.setValue(expectedchannelproduct.getProduct_value())
					if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
						channelproduct.setDisplayspaceavailable(expectedchannelproduct.getProduct_value())
					}
					else{
						channelproduct.setOverwritedisplayspaceavailable(expectedchannelproduct.getProduct_value())
					}
					Mobile.hideKeyboard()
					break
				}
				else{}
			}
			if(flag == false){
				MobileElement edittext = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.EditText[1]")
				edittext.setValue("0000")
				if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
					channelproduct.setDisplayspaceavailable("0000")
				}
				else{
					channelproduct.setOverwritedisplayspaceavailable("0000")
				}
				Mobile.hideKeyboard()
			}
			else{}
			visitedchannelproducts.add(channelproduct)
		}
		totalproducts = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*").size()
		if(totalproducts >= 16){
			while(true){
				ChannelProduct channelproduct = new ChannelProduct()
				boolean flag = false
				int xlocation = ProjectConstants.getXPoint()
				MobileElement productbeforeswipe = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.TextView[5]")
				String productnamebeforeswipe = productbeforeswipe.getText()
				Mobile.swipe(xlocation, 359, xlocation, 250)
				MobileElement productafterswipe = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.TextView[5]")
				String productnameafterswipe = productafterswipe.getText()
				if(productnamebeforeswipe.equals(productnameafterswipe)){
					break
				}
				else{
					channelproduct.setProduct(productnameafterswipe)
					for(int j=0; j< expectedchannelproducts.size(); j++){
						ProductWithValue expectedchannelproduct = expectedchannelproducts.get(j)
						if(expectedchannelproduct.getProduct().equalsIgnoreCase(productnameafterswipe)){
							flag = true
							MobileElement edittext = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[6]/android.widget.EditText[1]")
							edittext.setValue(expectedchannelproduct.getProduct_value())
							if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
								channelproduct.setDisplayspaceavailable(expectedchannelproduct.getProduct_value())
							}
							else{
								channelproduct.setOverwritedisplayspaceavailable(expectedchannelproduct.getProduct_value())
							}
							Mobile.hideKeyboard()
							break
						}
						else{}
					}
					if(flag == false){
						MobileElement edittext = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[6]/android.widget.EditText[1]")
						edittext.setValue("0000")
						if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
							channelproduct.setDisplayspaceavailable("0000")
						}
						else{
							channelproduct.setOverwritedisplayspaceavailable("0000")
						}
						Mobile.hideKeyboard()
					}
					else{}
				}
				visitedchannelproducts.add(channelproduct)
			}
		}
		else{}
		for(int i=0; i< visitedchannelproducts.size(); i++){
			displayedproducts.add(visitedchannelproducts.get(i).getProduct())
		}
		UnmatchedItems UnmatchedItems_status = CompareDataKeywords.compareLists(expectedproducts, displayedproducts)
		if(UnmatchedItems_status.getStatus() == 2){
			ArrayList<MissingMainCategoryData> missingmaincategories = new ArrayList<MissingMainCategoryData>()
			ArrayList<MissingCategoryRemarkData> missingcategoryremarks = new ArrayList<MissingCategoryRemarkData>()
			ArrayList<MissingSubCategoryData> missingsubcategories = new ArrayList<MissingSubCategoryData>()
			ArrayList<String> products = new ArrayList<String>()
			MissingMainCategoryData missingmaincategory = new MissingMainCategoryData()
			MissingCategoryRemarkData missingcategoryremark = new MissingCategoryRemarkData()
			MissingSubCategoryData missingsubcategory = new MissingSubCategoryData()
			missingsubcategory.setSubcategory(ProjectConstants.CURRENTVISITING_SUBCATEGORY)
			missingsubcategory.setProducts(UnmatchedItems_status.getItems())
			missingsubcategory.setProducts_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_NOTMATCH)
			missingsubcategories.add(missingsubcategory)
			missingcategoryremark.setCategoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
			missingcategoryremark.setMissingsubcategories(missingsubcategories)
			missingcategoryremarks.add(missingcategoryremark)
			missingmaincategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingmaincategory.setMissingcategoryremarks(missingcategoryremarks)
			missingmaincategories.add(missingmaincategory)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ArrayList<MissingMainCategoryData> existingmissingmaincatergories = ProjectConstants.missingshopdatainfo.get(j).getMissingmaincategories()
					if(existingmissingmaincatergories != null){
						for(int m=0; m< existingmissingmaincatergories.size(); m++){
							if(existingmissingmaincatergories.get(m).getMaincategory().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_MAINCATEGORY)){
								existingmissingmaincatergories.get(m).setMissingcategoryremarks(missingcategoryremarks)
							}
							else{
								ProjectConstants.missingshopdatainfo.get(j).setMissingmaincategories(missingmaincategories)
								break
							}
						}
					}
					else{
						ProjectConstants.missingshopdatainfo.get(j).setMissingmaincategories(missingmaincategories)
					}
				}
				else{
				}
			}
		}
		else if(UnmatchedItems_status.getStatus() == 1){
			ArrayList<MissingMainCategoryData> missingmaincategories = new ArrayList<MissingMainCategoryData>()
			ArrayList<MissingCategoryRemarkData> missingcategoryremarks = new ArrayList<MissingCategoryRemarkData>()
			ArrayList<MissingSubCategoryData> missingsubcategories = new ArrayList<MissingSubCategoryData>()
			ArrayList<String> products = new ArrayList<String>()
			MissingMainCategoryData missingmaincategory = new MissingMainCategoryData()
			MissingCategoryRemarkData missingcategoryremark = new MissingCategoryRemarkData()
			MissingSubCategoryData missingsubcategory = new MissingSubCategoryData()
			missingsubcategory.setSubcategory(ProjectConstants.CURRENTVISITING_SUBCATEGORY)
			missingsubcategory.setProducts(UnmatchedItems_status.getItems())
			missingsubcategory.setProducts_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MORE)
			missingsubcategories.add(missingsubcategory)
			missingcategoryremark.setCategoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
			missingcategoryremark.setMissingsubcategories(missingsubcategories)
			missingcategoryremarks.add(missingcategoryremark)
			missingmaincategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingmaincategory.setMissingcategoryremarks(missingcategoryremarks)
			missingmaincategories.add(missingmaincategory)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ArrayList<MissingMainCategoryData> existingmissingmaincatergories = ProjectConstants.missingshopdatainfo.get(j).getMissingmaincategories()
					if(existingmissingmaincatergories != null){
						for(int m=0; m< existingmissingmaincatergories.size(); m++){
							if(existingmissingmaincatergories.get(m).getMaincategory().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_MAINCATEGORY)){
								existingmissingmaincatergories.get(m).setMissingcategoryremarks(missingcategoryremarks)
							}
							else{
								ProjectConstants.missingshopdatainfo.get(j).setMissingmaincategories(missingmaincategories)
								break
							}
						}
					}
					else{
						ProjectConstants.missingshopdatainfo.get(j).setMissingmaincategories(missingmaincategories)
					}
				}
				else{
				}
			}
		}
		else if(UnmatchedItems_status.getStatus() == -1){
			ArrayList<MissingMainCategoryData> missingmaincategories = new ArrayList<MissingMainCategoryData>()
			ArrayList<MissingCategoryRemarkData> missingcategoryremarks = new ArrayList<MissingCategoryRemarkData>()
			ArrayList<MissingSubCategoryData> missingsubcategories = new ArrayList<MissingSubCategoryData>()
			ArrayList<String> products = new ArrayList<String>()
			MissingMainCategoryData missingmaincategory = new MissingMainCategoryData()
			MissingCategoryRemarkData missingcategoryremark = new MissingCategoryRemarkData()
			MissingSubCategoryData missingsubcategory = new MissingSubCategoryData()
			missingsubcategory.setSubcategory(ProjectConstants.CURRENTVISITING_SUBCATEGORY)
			missingsubcategory.setProducts(UnmatchedItems_status.getItems())
			missingsubcategory.setProducts_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MISSING)
			missingsubcategories.add(missingsubcategory)
			missingcategoryremark.setCategoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
			missingcategoryremark.setMissingsubcategories(missingsubcategories)
			missingcategoryremarks.add(missingcategoryremark)
			missingmaincategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingmaincategory.setMissingcategoryremarks(missingcategoryremarks)
			missingmaincategories.add(missingmaincategory)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ArrayList<MissingMainCategoryData> existingmissingmaincatergories = ProjectConstants.missingshopdatainfo.get(j).getMissingmaincategories()
					if(existingmissingmaincatergories != null){
						for(int m=0; m< existingmissingmaincatergories.size(); m++){
							if(existingmissingmaincatergories.get(m).getMaincategory().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_MAINCATEGORY)){
								existingmissingmaincatergories.get(m).setMissingcategoryremarks(missingcategoryremarks)
							}
							else{
								ProjectConstants.missingshopdatainfo.get(j).setMissingmaincategories(missingmaincategories)
								break
							}
						}
					}
					else{
						ProjectConstants.missingshopdatainfo.get(j).setMissingmaincategories(missingmaincategories)
					}
				}
				else{
				}
			}
		}
		else{
		}

		//			VisitedCategoryData visitedcategorydata = new VisitedCategoryData()
		//			visitedcategorydata.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
		//			visitedcategorydata.setProductcategory(ProjectConstants.CURRENTVISITING_PRODUCTCATEGORY)
		//			visitedcategorydata.setChannelproducts(visitedchannelproducts)
		//			for(int i=0; i< ProjectConstants.visitedshopdatainfo.size(); i++){
		//				if(ProjectConstants.visitedshopdatainfo.get(i).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)){
		//					VisitedShopDataInfo visitedshopdata = ProjectConstants.visitedshopdatainfo.get(i)
		//					ArrayList<VisitedCategoryData> visitedcategoriesdata = visitedshopdata.getVisitedcategoriesdata()
		//					if(visitedcategoriesdata.size() != 0){
		//						boolean flag = false
		//						for(int k=0; k<visitedcategoriesdata.size(); k++){
		//							VisitedCategoryData visitedcategorydatainfo = visitedcategoriesdata.get(k)
		//							if(visitedcategorydatainfo.getMaincategory().equals(visitedcategorydata.getMaincategory()) && visitedcategorydatainfo.getProductcategory().equals(visitedcategorydata.getProductcategory())){
		//								flag = true
		//								for(int l=0; l< visitedcategorydatainfo.getChannelproducts().size(); l++){
		//									ChannelProduct existingproductsdata = visitedcategorydatainfo.getChannelproducts().get(l)
		//									for(int m=0; m< visitedchannelproducts.size(); m++){
		//										ProductWithValue displayedchannelproduct = visitedchannelproducts.get(m)
		//										if(existingproductsdata.getProduct().equals(displayedchannelproduct.getProduct())){
		//											if(ProjectConstants.SCENARIO.equals("first visit")){
		//												existingproductsdata.setDisplayspaceavailable(displayedchannelproduct.getProduct_value())
		//											}
		//											else{
		//												existingproductsdata.setOverwritedisplayspaceavailable(displayedchannelproduct.getProduct_value())
		//											}
		//										}
		//									}
		//								}
		//							}
		//						}
		//						if(flag == false){
		//							ProjectConstants.visitedshopdatainfo.get(i).setVisitedcategoriesdata(visitedcategorydata)
		//							break
		//						}
		//					}
		//					else{
		//						ProjectConstants.visitedshopdatainfo.get(i).setVisitedcategoriesdata(visitedcategorydata)
		//						break
		//					}
		//				}
		//			}
	}
	//	// for secondary display remarks
	@Keyword
	def selectSecondaryDisplayRemark(String _remark){
		int totalremarks = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<= totalremarks; i++){
			MobileElement remark = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			String remarkname = remark.getText()
			if(remarkname.equalsIgnoreCase(_remark)){
				driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				break
			}
		}
	}
	@Keyword
	def visitSecondaryDisplayUnitsList(){
		int totalunits = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<= totalunits; i++){
			ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
			if(i == 1){
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/SecondaryDisplay/Available/VisitAvailableWith_DisplayUnitNeedMaintenance"), null)
			}
			else if(i == 2){
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/SecondaryDisplay/Available/VisitAvailableWith_SKDNA"), null)
			}
			else if(i == 3){
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/SecondaryDisplay/Available/VisitAvailableWith_SKDNA"), null)
			}
			else if(i == 4){
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/SecondaryDisplay/Available/VisitAvailable_WithDisplayUnitIsInPerfectCondition"), null)
			}
			else{
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/SecondaryDisplay/Available/VisitAvailable_WithDisplayUnitIsInPerfectCondition"), null)
			}
		}
	}
	@Keyword
	def overwriteSecondaryDisplayUnitsList(){
		int totalunits = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<= totalunits; i++){
			ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
			if(i == 1){
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/SecondaryDisplay/Available/OverwriteAvailableWith_DisplayUnitNeedMaintenance"), null)
			}
			else if(i == 2){
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/SecondaryDisplay/Available/OverwriteAvailableWith_SKDNA"), null)
			}
			else if(i == 3){
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/SecondaryDisplay/Available/VisitAvailableWith_SKDNA"), null)
			}
			else if(i == 4){
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/SecondaryDisplay/Available/VisitAvailableWith_DisplayUnitNeedMaintenance"), null)
			}
			else{
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/SecondaryDisplay/Available/VisitAvailableWith_DisplayUnitNeedMaintenance"), null)
			}
		}
	}
	@Keyword
	def selectSecondaryDisplay_AvailableRemark(String _remark){
		int totalremarks = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<= totalremarks; i++){
			MobileElement remark = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			String remarkname = remark.getText()
			if(remarkname.equalsIgnoreCase(_remark)){
				driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				break
			}
		}
	}
	// for additional info remark
	@Keyword
	def visitAdditionalInfoQuestions(){
		int index = 0
		String itemtextbeforeswipe = ""
		String itemtextafterswipe = ""
		String tag = ""
		MobileElement surveyquestion = null
		ArrayList<String> visitedadditionalinfoquestions = new ArrayList<String>()
		//		ArrayList<Questions> expectedadditionalinfoquestions = LoadDataKeywords.loadAdditionalInfoQuestionsList(LoadDataKeywords.loadAdditionalInfoQuestionsSheet(), ProjectConstants.ADDITIONALINFOQUESTION_VALUE)
		ArrayList<MobileElement> surveyquestionslist = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
		for(int i=0; i< surveyquestionslist.size(); i++){
			surveyquestion = surveyquestionslist.get(i)
			tag = surveyquestion.getTagName()
			if(tag.equalsIgnoreCase("android.widget.Spinner")){
				String displayeddropdowntext = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
				visitedadditionalinfoquestions.add(displayeddropdowntext)
				surveyquestion.click()
				Mobile.verifyElementExist(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/Validate_QuestionRemarksPopupScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/QuestionRemarks_YesOption", [('package') : ProjectConstants.PACKAGENAME]), 0)
				try{
					Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_CameraScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
					Mobile.tap(findTestObject("Object Repository/CommonScreenElements/TakePictureButton", [('package') : ProjectConstants.PACKAGENAME]),0)
					Mobile.delay(5)
					Mobile.tap(findTestObject("Object Repository/CommonScreenElements/DoneButton", [('package') : ProjectConstants.PACKAGENAME]),0)
				}
				catch(Exception ex){
				}
				Mobile.verifyElementText(findTestObject('Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/Validate_QuestionsScreen', [('package') : ProjectConstants.PACKAGENAME]), 'Questions')
			}
			else{
				surveyquestion.setValue("0000")
				Mobile.hideKeyboard()
				//				String displayededitfieldtext = surveyquestion.getText()
				//				visitedadditionalinfoquestions.add(displayededitfieldtext)
				//				for(int j=0; j< expectedadditionalinfoquestions.size(); j++){
				//					String expectededitfieldtext = expectedadditionalinfoquestions.get(j).getQuestion()
				//					if(displayededitfieldtext.equalsIgnoreCase(expectededitfieldtext)){
				//						String questionvalue = expectedadditionalinfoquestions.get(j).getQuestion_value()
				//						surveyquestion.setValue(questionvalue)
				//						Mobile.hideKeyboard()
				//					}
				//					else{
				//						surveyquestion.setValue("0000")
				//						Mobile.hideKeyboard()
				//					}
				//				}
			}
		}
		while(true){
			surveyquestionslist = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
			index = (surveyquestionslist.size()-1)
			surveyquestion =  surveyquestionslist.get(index)
			tag = surveyquestion.getTagName()
			if(tag.equalsIgnoreCase("android.widget.Spinner")){
				itemtextbeforeswipe = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
			}
			else{
				itemtextbeforeswipe = surveyquestion.getText()
			}
			Mobile.swipe(20, 318, 20, 200)
			surveyquestionslist = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
			index = (surveyquestionslist.size()-1)
			surveyquestion =  surveyquestionslist.get(index)
			tag = surveyquestion.getTagName()
			if(tag.equalsIgnoreCase("android.widget.Spinner")){
				itemtextafterswipe = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
			}
			else{
				itemtextafterswipe = surveyquestion.getText()
			}
			if(itemtextbeforeswipe.equals(itemtextafterswipe)){
				break
			}
			else{
				if(tag.equalsIgnoreCase("android.widget.Spinner")){
					String displayeddropdowntext = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
					visitedadditionalinfoquestions.add(displayeddropdowntext)
					surveyquestion.click()
					Mobile.verifyElementExist(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/Validate_QuestionRemarksPopupScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
					Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/QuestionRemarks_YesOption", [('package') : ProjectConstants.PACKAGENAME]), 0)
					try{
						Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_CameraScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
						Mobile.tap(findTestObject("Object Repository/CommonScreenElements/TakePictureButton", [('package') : ProjectConstants.PACKAGENAME]),0)
						Mobile.delay(5)
						Mobile.tap(findTestObject("Object Repository/CommonScreenElements/DoneButton", [('package') : ProjectConstants.PACKAGENAME]),0)
					}
					catch(Exception ex){
					}
					Mobile.verifyElementText(findTestObject('Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/Validate_QuestionsScreen', [('package') : ProjectConstants.PACKAGENAME]), 'Questions')
				}
				else{
					surveyquestion.setValue("0000")
					Mobile.hideKeyboard()
					//					String displayededitfieldtext = surveyquestion.getText()
					//					visitedadditionalinfoquestions.add(displayededitfieldtext)
					//					for(int j=0; j< expectedadditionalinfoquestions.size(); j++){
					//						String expectededitfieldtext = expectedadditionalinfoquestions.get(j).getQuestion()
					//						if(displayededitfieldtext.equalsIgnoreCase(expectededitfieldtext)){
					//							String questionvalue = expectedadditionalinfoquestions.get(j).getQuestion_value()
					//							surveyquestion.setValue(questionvalue)
					//							Mobile.hideKeyboard()
					//						}
					//						else{
					//							surveyquestion.setValue("0000")
					//							Mobile.hideKeyboard()
					//						}
					//					}
				}
			}
		}
		//		if(expectedadditionalinfoquestions.size() == visitedadditionalinfoquestions.size()){
		//			ArrayList<String> questions = new ArrayList<String>()
		//			for(int i=0; i<visitedadditionalinfoquestions.size(); i++){
		//				boolean match = false
		//				for(int j=0; j<expectedadditionalinfoquestions.size(); j++){
		//					String dis = visitedadditionalinfoquestions.get(i)
		//					String exp = expectedadditionalinfoquestions.get(j).getQuestion()
		//					if(visitedadditionalinfoquestions.get(i).equalsIgnoreCase(expectedadditionalinfoquestions.get(j).getQuestion())){
		//						match = true
		//						break
		//					}
		//					else{}
		//				}
		//				if(match == false){
		//					questions.add(visitedadditionalinfoquestions.get(i))
		//				}
		//				else{
		//				}
		//			}
		//			if(!questions.isEmpty()){
		//				MissingCategoryData missingcategorydata = new MissingCategoryData()
		//				missingcategorydata.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
		//				missingcategorydata.setAdditionalinfoquestions(questions)
		//				missingcategorydata.setAdditionalinfoquestions_errormessage(ProjectConstants.MESSAGEFOR_SURVEYQUESTIONSARE_NOTMATCH)
		//				for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
		//					if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
		//						ProjectConstants.missingshopdatainfo.get(j).setMissingCategoriesData(missingcategorydata)
		//						break
		//					}
		//					else{
		//					}
		//				}
		//			}
		//			else{
		//			}
		//		}
		//		else if(expectedadditionalinfoquestions.size() < visitedadditionalinfoquestions.size()){
		//			ArrayList<String> questions = new ArrayList<String>()
		//			for(int i=0; i<visitedadditionalinfoquestions.size(); i++){
		//				boolean match = false
		//				for(int j=0; j<expectedadditionalinfoquestions.size(); j++){
		//					if(visitedadditionalinfoquestions.get(i).equalsIgnoreCase(expectedadditionalinfoquestions.get(j).getQuestion())){
		//						match = true
		//						break
		//					}
		//				}
		//				if(match == false){
		//					questions.add(visitedadditionalinfoquestions.get(i))
		//				}
		//				else{
		//				}
		//			}
		//			MissingCategoryData missingcategorydata = new MissingCategoryData()
		//			missingcategorydata.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
		//			missingcategorydata.setAdditionalinfoquestions(questions)
		//			missingcategorydata.setAdditionalinfoquestions_errormessage(ProjectConstants.MESSAGEFOR_SURVEYQUESTIONSARE_MORE)
		//			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
		//				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
		//					ProjectConstants.missingshopdatainfo.get(j).setMissingCategoriesData(missingcategorydata)
		//				}
		//				else{
		//				}
		//			}
		//		}
		//		else if(expectedadditionalinfoquestions.size() > visitedadditionalinfoquestions.size()){
		//			ArrayList<String> questions = new ArrayList<String>()
		//			for(int i=0; i<expectedadditionalinfoquestions.size(); i++){
		//				boolean match = false
		//				for(int j=0; j<visitedadditionalinfoquestions.size(); j++){
		//					if(expectedadditionalinfoquestions.get(i).getQuestion().equalsIgnoreCase(visitedadditionalinfoquestions.get(j))){
		//						match = true
		//						break
		//					}
		//				}
		//				if(match == false){
		//					questions.add(expectedadditionalinfoquestions.get(i).getQuestion())
		//				}
		//				else{
		//				}
		//			}
		//			MissingCategoryData missingcategorydata = new MissingCategoryData()
		//			missingcategorydata.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
		//			missingcategorydata.setAdditionalinfoquestions(questions)
		//			missingcategorydata.setAdditionalinfoquestions_errormessage(ProjectConstants.MESSAGEFOR_SURVEYQUESTIONSARE_MISSING)
		//			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
		//				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
		//					ProjectConstants.missingshopdatainfo.get(j).setMissingCategoriesData(missingcategorydata)
		//					break
		//				}
		//				else{
		//				}
		//			}
		//		}
		//		else{
		//
		//			String message = "Main Category: "+ProjectConstants.CURRENTVISITING_MAINCATEGORY+"\nProduct Category: "+ProjectConstants.CURRENTVISITING_PRODUCTCATEGORY+"\n"+ProjectConstants.MESSAGEFOR_DISPLAYEDPRODUCTSARE_EQUAL
		//			KeywordUtil.logInfo(message)
		//		}
	}
	//	@Keyword
	//	def overwriteAdditionalInfoQuestions(){
	//		int index = 0
	//		String itemtextbeforeswipe = ""
	//		String itemtextafterswipe = ""
	//		String tag = ""
	//		MobileElement surveyquestion = null
	//		ArrayList<String> visitedadditionalinfoquestions = new ArrayList<String>()
	//		ArrayList<Questions> expectedadditionalinfoquestions = LoadDataKeywords.loadAdditionalInfoQuestionsList(LoadDataKeywords.loadAdditionalInfoQuestionsSheet(), ProjectConstants.OVERWRITE_ADDITIONALINFOQUESTION_VALUE)
	//		ArrayList<MobileElement> surveyquestionslist = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
	//		for(int i=0; i< surveyquestionslist.size(); i++){
	//			surveyquestion = surveyquestionslist.get(i)
	//			tag = surveyquestion.getTagName()
	//			if(tag.equalsIgnoreCase("android.widget.Spinner")){
	//				String displayeddropdowntext = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
	//				visitedadditionalinfoquestions.add(displayeddropdowntext)
	//				surveyquestion.click()
	//				Mobile.verifyElementExist(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/Validate_QuestionRemarksPopupScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
	//				Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/QuestionRemarks_NoOption", [('package') : ProjectConstants.PACKAGENAME]), 0)
	//				Mobile.verifyElementText(findTestObject('Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/Validate_QuestionsScreen', [('package') : ProjectConstants.PACKAGENAME]), 'Questions')
	//			}
	//			else{
	//				String displayededitfieldtext = surveyquestion.getText()
	//				visitedadditionalinfoquestions.add(displayededitfieldtext)
	//				for(int j=0; j< expectedadditionalinfoquestions.size(); j++){
	//					String expectededitfieldtext = expectedadditionalinfoquestions.get(j).getQuestion()
	//					if(displayededitfieldtext.equalsIgnoreCase(expectededitfieldtext)){
	//						String questionvalue = expectedadditionalinfoquestions.get(j).getQuestion_value()
	//						surveyquestion.setValue(questionvalue)
	//						Mobile.hideKeyboard()
	//					}
	//					else{
	//						surveyquestion.setValue("0000")
	//						Mobile.hideKeyboard()
	//					}
	//				}
	//			}
	//		}
	//		while(true){
	//			surveyquestionslist = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
	//			index = (surveyquestionslist.size()-1)
	//			surveyquestion =  surveyquestionslist.get(index)
	//			tag = surveyquestion.getTagName()
	//			if(tag.equalsIgnoreCase("android.widget.Spinner")){
	//				itemtextbeforeswipe = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
	//			}
	//			else{
	//				itemtextbeforeswipe = surveyquestion.getText()
	//			}
	//			Mobile.swipe(20, 324, 20, 200)
	//			surveyquestionslist = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
	//			index = (surveyquestionslist.size()-1)
	//			surveyquestion =  surveyquestionslist.get(index)
	//			tag = surveyquestion.getTagName()
	//			if(tag.equalsIgnoreCase("android.widget.Spinner")){
	//				itemtextafterswipe = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
	//			}
	//			else{
	//				itemtextafterswipe = surveyquestion.getText()
	//			}
	//			if(itemtextbeforeswipe.equals(itemtextafterswipe)){
	//				break
	//			}
	//			else{
	//				if(tag.equalsIgnoreCase("android.widget.Spinner")){
	//					String displayeddropdowntext = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
	//					visitedadditionalinfoquestions.add(displayeddropdowntext)
	//					surveyquestion.click()
	//					Mobile.verifyElementExist(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/Validate_QuestionRemarksPopupScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
	//					Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/QuestionRemarks_NoOption", [('package') : ProjectConstants.PACKAGENAME]), 0)
	//					Mobile.verifyElementText(findTestObject('Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/Validate_QuestionsScreen', [('package') : ProjectConstants.PACKAGENAME]), 'Questions')
	//				}
	//				else{
	//					String displayededitfieldtext = surveyquestion.getText()
	//					visitedadditionalinfoquestions.add(displayededitfieldtext)
	//					for(int j=0; j< expectedadditionalinfoquestions.size(); j++){
	//						String expectededitfieldtext = expectedadditionalinfoquestions.get(j).getQuestion()
	//						if(displayededitfieldtext.equalsIgnoreCase(expectededitfieldtext)){
	//							String questionvalue = expectedadditionalinfoquestions.get(j).getQuestion_value()
	//							surveyquestion.setValue(questionvalue)
	//							Mobile.hideKeyboard()
	//						}
	//						else{
	//							surveyquestion.setValue("0000")
	//							Mobile.hideKeyboard()
	//						}
	//					}
	//				}
	//			}
	//		}
	//		if(expectedadditionalinfoquestions.size() == visitedadditionalinfoquestions.size()){
	//			ArrayList<String> questions = new ArrayList<String>()
	//			for(int i=0; i<visitedadditionalinfoquestions.size(); i++){
	//				boolean match = false
	//				for(int j=0; j<expectedadditionalinfoquestions.size(); j++){
	//					String dis = visitedadditionalinfoquestions.get(i)
	//					String exp = expectedadditionalinfoquestions.get(j).getQuestion()
	//					if(visitedadditionalinfoquestions.get(i).equalsIgnoreCase(expectedadditionalinfoquestions.get(j).getQuestion())){
	//						match = true
	//						break
	//					}
	//					else{}
	//				}
	//				if(match == false){
	//					questions.add(visitedadditionalinfoquestions.get(i))
	//				}
	//				else{
	//				}
	//			}
	//			if(!questions.isEmpty()){
	//				MissingCategoryData missingcategorydata = new MissingCategoryData()
	//				missingcategorydata.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
	//				missingcategorydata.setAdditionalinfoquestions(questions)
	//				missingcategorydata.setAdditionalinfoquestions_errormessage(ProjectConstants.MESSAGEFOR_SURVEYQUESTIONSARE_NOTMATCH)
	//				for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
	//					if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
	//						ProjectConstants.missingshopdatainfo.get(j).setMissingCategoriesData(missingcategorydata)
	//						break
	//					}
	//					else{
	//					}
	//				}
	//			}
	//			else{
	//			}
	//		}
	//		else if(expectedadditionalinfoquestions.size() < visitedadditionalinfoquestions.size()){
	//			ArrayList<String> questions = new ArrayList<String>()
	//			for(int i=0; i<visitedadditionalinfoquestions.size(); i++){
	//				boolean match = false
	//				for(int j=0; j<expectedadditionalinfoquestions.size(); j++){
	//					if(visitedadditionalinfoquestions.get(i).equalsIgnoreCase(expectedadditionalinfoquestions.get(j).getQuestion())){
	//						match = true
	//						break
	//					}
	//				}
	//				if(match == false){
	//					questions.add(visitedadditionalinfoquestions.get(i))
	//				}
	//				else{
	//				}
	//			}
	//			MissingCategoryData missingcategorydata = new MissingCategoryData()
	//			missingcategorydata.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
	//			missingcategorydata.setAdditionalinfoquestions(questions)
	//			missingcategorydata.setAdditionalinfoquestions_errormessage(ProjectConstants.MESSAGEFOR_SURVEYQUESTIONSARE_MORE)
	//			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
	//				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
	//					ProjectConstants.missingshopdatainfo.get(j).setMissingCategoriesData(missingcategorydata)
	//				}
	//				else{
	//				}
	//			}
	//		}
	//		else if(expectedadditionalinfoquestions.size() > visitedadditionalinfoquestions.size()){
	//			ArrayList<String> questions = new ArrayList<String>()
	//			for(int i=0; i<expectedadditionalinfoquestions.size(); i++){
	//				boolean match = false
	//				for(int j=0; j<visitedadditionalinfoquestions.size(); j++){
	//					if(expectedadditionalinfoquestions.get(i).getQuestion().equalsIgnoreCase(visitedadditionalinfoquestions.get(j))){
	//						match = true
	//						break
	//					}
	//				}
	//				if(match == false){
	//					questions.add(expectedadditionalinfoquestions.get(i).getQuestion())
	//				}
	//				else{
	//				}
	//			}
	//			MissingCategoryData missingcategorydata = new MissingCategoryData()
	//			missingcategorydata.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
	//			missingcategorydata.setAdditionalinfoquestions(questions)
	//			missingcategorydata.setAdditionalinfoquestions_errormessage(ProjectConstants.MESSAGEFOR_SURVEYQUESTIONSARE_MISSING)
	//			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
	//				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
	//					ProjectConstants.missingshopdatainfo.get(j).setMissingCategoriesData(missingcategorydata)
	//					break
	//				}
	//				else{
	//				}
	//			}
	//		}
	//		else{
	//			String message = "Main Category: "+ProjectConstants.CURRENTVISITING_MAINCATEGORY+"\nProduct Category: "+ProjectConstants.CURRENTVISITING_PRODUCTCATEGORY+"\n"+ProjectConstants.MESSAGEFOR_DISPLAYEDPRODUCTSARE_EQUAL
	//			KeywordUtil.logInfo(message)
	//		}
	//	}
	//	def validateCameraScreenAndTakePicture(){
	//		if(Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_CameraScreen", [('package') : ProjectConstants.PACKAGENAME]), 0, FailureHandling.OPTIONAL)){
	//			Mobile.tap(findTestObject("Object Repository/CommonScreenElements/TakePictureButton", [('package') : ProjectConstants.PACKAGENAME]), 0)
	//			Mobile.delay(5)
	//			Mobile.tap(findTestObject("Object Repository/CommonScreenElements/DoneButton", [('package') : ProjectConstants.PACKAGENAME]), 0)
	//		}
	//		else{
	//		}
	//	}
}
