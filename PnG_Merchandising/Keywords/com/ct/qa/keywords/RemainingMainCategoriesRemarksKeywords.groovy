package com.ct.qa.keywords

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.apache.poi.xssf.usermodel.XSSFSheet
import org.openqa.selenium.By
import com.ct.qa.constants.ProjectConstants
import com.ct.qa.struct.MissingCategoryData
import com.ct.qa.struct.MissingCategoryRemarkData
import com.ct.qa.struct.ProductWithValue
import com.ct.qa.struct.ShopProductsData
import com.ct.qa.struct.UnmatchedItems
import com.ct.qa.struct.VisitedCategoryData
import com.ct.qa.struct.VisitedCategoryRemarkData
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
			ArrayList<MissingCategoryRemarkData> missingcategoryremarks = new ArrayList<MissingCategoryRemarkData>()
			MissingCategoryRemarkData missingcategoryremark = new MissingCategoryRemarkData()
			missingcategoryremark.setCategoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
			missingcategoryremark.setSubcategories(UnmatchedItems_status.getItems())
			missingcategoryremark.setSubcategories_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_NOTMATCH)
			missingcategoryremarks.add(missingcategoryremark)
			MissingCategoryData missingcategory = new MissingCategoryData()
			missingcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategory.setMissingcategoryremarks(missingcategoryremarks)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingcategoriesdata(missingcategory)
				}
				else{
				}
			}
		}
		else if(UnmatchedItems_status.getStatus() == 1){
			ArrayList<MissingCategoryRemarkData> missingcategoryremarks = new ArrayList<MissingCategoryRemarkData>()
			MissingCategoryRemarkData missingcategoryremark = new MissingCategoryRemarkData()
			missingcategoryremark.setCategoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
			missingcategoryremark.setSubcategories(UnmatchedItems_status.getItems())
			missingcategoryremark.setSubcategories_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MORE)
			missingcategoryremarks.add(missingcategoryremark)
			MissingCategoryData missingcategory = new MissingCategoryData()
			missingcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategory.setMissingcategoryremarks(missingcategoryremarks)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingcategoriesdata(missingcategory)
				}
				else{
				}
			}
		}
		else if(UnmatchedItems_status.getStatus() == -1){
			ArrayList<MissingCategoryRemarkData> missingcategoryremarks = new ArrayList<MissingCategoryRemarkData>()
			MissingCategoryRemarkData missingcategoryremark = new MissingCategoryRemarkData()
			missingcategoryremark.setCategoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
			missingcategoryremark.setSubcategories(UnmatchedItems_status.getItems())
			missingcategoryremark.setSubcategories_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MISSING)
			missingcategoryremarks.add(missingcategoryremark)
			MissingCategoryData missingcategory = new MissingCategoryData()
			missingcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategory.setMissingcategoryremarks(missingcategoryremarks)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingcategoriesdata(missingcategory)
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
			ArrayList<MissingCategoryRemarkData> missingcategoryremarks = new ArrayList<MissingCategoryRemarkData>()
			MissingCategoryRemarkData missingcategoryremark = new MissingCategoryRemarkData()
			missingcategoryremark.setCategoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
			missingcategoryremark.setSubcategory(ProjectConstants.CURRENTVISITING_SUBCATEGORY)
			missingcategoryremark.setProducts(UnmatchedItems_status.getItems())
			missingcategoryremark.setProducts_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_NOTMATCH)
			missingcategoryremarks.add(missingcategoryremark)
			MissingCategoryData missingcategory = new MissingCategoryData()
			missingcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategory.setMissingcategoryremarks(missingcategoryremarks)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingcategoriesdata(missingcategory)
				}
				else{
				}
			}
		}
		else if(UnmatchedItems_status.getStatus() == 1){
			ArrayList<MissingCategoryRemarkData> missingcategoryremarks = new ArrayList<MissingCategoryRemarkData>()
			MissingCategoryRemarkData missingcategoryremark = new MissingCategoryRemarkData()
			missingcategoryremark.setCategoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
			missingcategoryremark.setSubcategory(ProjectConstants.CURRENTVISITING_SUBCATEGORY)
			missingcategoryremark.setProducts(UnmatchedItems_status.getItems())
			missingcategoryremark.setProducts_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MORE)
			missingcategoryremarks.add(missingcategoryremark)
			MissingCategoryData missingcategory = new MissingCategoryData()
			missingcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategory.setMissingcategoryremarks(missingcategoryremarks)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingcategoriesdata(missingcategory)
				}
				else{
				}
			}
		}
		else if(UnmatchedItems_status.getStatus() == -1){
			ArrayList<MissingCategoryRemarkData> missingcategoryremarks = new ArrayList<MissingCategoryRemarkData>()
			MissingCategoryRemarkData missingcategoryremark = new MissingCategoryRemarkData()
			missingcategoryremark.setCategoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
			missingcategoryremark.setSubcategory(ProjectConstants.CURRENTVISITING_SUBCATEGORY)
			missingcategoryremark.setProducts(UnmatchedItems_status.getItems())
			missingcategoryremark.setProducts_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MISSING)
			missingcategoryremarks.add(missingcategoryremark)
			MissingCategoryData missingcategory = new MissingCategoryData()
			missingcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategory.setMissingcategoryremarks(missingcategoryremarks)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingcategoriesdata(missingcategory)
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
			ArrayList<MissingCategoryRemarkData> missingcategoryremarks = new ArrayList<MissingCategoryRemarkData>()
			MissingCategoryRemarkData missingcategoryremark = new MissingCategoryRemarkData()
			missingcategoryremark.setCategoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
			missingcategoryremark.setSubcategory(ProjectConstants.CURRENTVISITING_SUBCATEGORY)
			missingcategoryremark.setProducts(UnmatchedItems_status.getItems())
			missingcategoryremark.setProducts_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_NOTMATCH)
			missingcategoryremarks.add(missingcategoryremark)
			MissingCategoryData missingcategory = new MissingCategoryData()
			missingcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategory.setMissingcategoryremarks(missingcategoryremarks)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingcategoriesdata(missingcategory)
				}
				else{
				}
			}
		}
		else if(UnmatchedItems_status.getStatus() == 1){
			ArrayList<MissingCategoryRemarkData> missingcategoryremarks = new ArrayList<MissingCategoryRemarkData>()
			MissingCategoryRemarkData missingcategoryremark = new MissingCategoryRemarkData()
			missingcategoryremark.setCategoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
			missingcategoryremark.setSubcategory(ProjectConstants.CURRENTVISITING_SUBCATEGORY)
			missingcategoryremark.setProducts(UnmatchedItems_status.getItems())
			missingcategoryremark.setProducts_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MORE)
			missingcategoryremarks.add(missingcategoryremark)
			MissingCategoryData missingcategory = new MissingCategoryData()
			missingcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategory.setMissingcategoryremarks(missingcategoryremarks)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingcategoriesdata(missingcategory)
				}
				else{
				}
			}
		}
		else if(UnmatchedItems_status.getStatus() == -1){
			ArrayList<MissingCategoryRemarkData> missingcategoryremarks = new ArrayList<MissingCategoryRemarkData>()
			MissingCategoryRemarkData missingcategoryremark = new MissingCategoryRemarkData()
			missingcategoryremark.setCategoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
			missingcategoryremark.setSubcategory(ProjectConstants.CURRENTVISITING_SUBCATEGORY)
			missingcategoryremark.setProducts(UnmatchedItems_status.getItems())
			missingcategoryremark.setProducts_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MISSING)
			missingcategoryremarks.add(missingcategoryremark)
			MissingCategoryData missingcategory = new MissingCategoryData()
			missingcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategory.setMissingcategoryremarks(missingcategoryremarks)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingcategoriesdata(missingcategory)
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
			ArrayList<MissingCategoryRemarkData> missingcategoryremarks = new ArrayList<MissingCategoryRemarkData>()
			MissingCategoryRemarkData missingcategoryremark = new MissingCategoryRemarkData()
			missingcategoryremark.setCategoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
			missingcategoryremark.setSubcategories(UnmatchedItems_status.getItems())
			missingcategoryremark.setSubcategories_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_NOTMATCH)
			missingcategoryremarks.add(missingcategoryremark)
			MissingCategoryData missingcategory = new MissingCategoryData()
			missingcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategory.setMissingcategoryremarks(missingcategoryremarks)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingcategoriesdata(missingcategory)
				}
				else{
				}
			}
		}
		else if(UnmatchedItems_status.getStatus() == 1){
			ArrayList<MissingCategoryRemarkData> missingcategoryremarks = new ArrayList<MissingCategoryRemarkData>()
			MissingCategoryRemarkData missingcategoryremark = new MissingCategoryRemarkData()
			missingcategoryremark.setCategoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
			missingcategoryremark.setSubcategories(UnmatchedItems_status.getItems())
			missingcategoryremark.setSubcategories_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MORE)
			missingcategoryremarks.add(missingcategoryremark)
			MissingCategoryData missingcategory = new MissingCategoryData()
			missingcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategory.setMissingcategoryremarks(missingcategoryremarks)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingcategoriesdata(missingcategory)
				}
				else{
				}
			}
		}
		else if(UnmatchedItems_status.getStatus() == -1){
			ArrayList<MissingCategoryRemarkData> missingcategoryremarks = new ArrayList<MissingCategoryRemarkData>()
			MissingCategoryRemarkData missingcategoryremark = new MissingCategoryRemarkData()
			missingcategoryremark.setCategoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
			missingcategoryremark.setSubcategories(UnmatchedItems_status.getItems())
			missingcategoryremark.setSubcategories_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MISSING)
			missingcategoryremarks.add(missingcategoryremark)
			MissingCategoryData missingcategory = new MissingCategoryData()
			missingcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategory.setMissingcategoryremarks(missingcategoryremarks)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingcategoriesdata(missingcategory)
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
		ArrayList<ShopProductsData> visitedshopproducts = new ArrayList<ShopProductsData>()
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
			ShopProductsData shopproduct = new ShopProductsData()
			boolean flag = false
			index = index + 1
			MobileElement product = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.TextView["+index+"]")
			String productname = product.getText()
			shopproduct.setProduct(productname)
			for(int j=0; j< expectedchannelproducts.size(); j++){
				ProductWithValue expectedchannelproduct = expectedchannelproducts.get(j)
				if(expectedchannelproduct.getProduct().equalsIgnoreCase(productname)){
					flag = true
					MobileElement edittext = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.EditText[1]")
					edittext.setValue(expectedchannelproduct.getProduct_value())
					if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
						shopproduct.setPd_displayspaceavailable(expectedchannelproduct.getProduct_value())
					}
					else{
						shopproduct.setPd_overwrite_displayspaceavailable(expectedchannelproduct.getProduct_value())
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
					shopproduct.setPd_displayspaceavailable("0000")
				}
				else{
					shopproduct.setPd_overwrite_displayspaceavailable("0000")
				}
				Mobile.hideKeyboard()
			}
			else{}
			visitedshopproducts.add(shopproduct)
		}
		totalproducts = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*").size()
		if(totalproducts >= 16){
			while(true){
				ShopProductsData shopproduct = new ShopProductsData()
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
					shopproduct.setProduct(productnameafterswipe)
					for(int j=0; j< expectedchannelproducts.size(); j++){
						ProductWithValue expectedchannelproduct = expectedchannelproducts.get(j)
						if(expectedchannelproduct.getProduct().equalsIgnoreCase(productnameafterswipe)){
							flag = true
							MobileElement edittext = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[6]/android.widget.EditText[1]")
							edittext.setValue(expectedchannelproduct.getProduct_value())
							if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
								shopproduct.setPd_displayspaceavailable(expectedchannelproduct.getProduct_value())
							}
							else{
								shopproduct.setPd_overwrite_displayspaceavailable(expectedchannelproduct.getProduct_value())
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
							shopproduct.setPd_displayspaceavailable("0000")
						}
						else{
							shopproduct.setPd_overwrite_displayspaceavailable("0000")
						}
						Mobile.hideKeyboard()
					}
					else{}
				}
				visitedshopproducts.add(shopproduct)
			}
		}
		else{}
		for(int i=0; i< visitedshopproducts.size(); i++){
			displayedproducts.add(visitedshopproducts.get(i).getProduct())
		}
		UnmatchedItems UnmatchedItems_status = CompareDataKeywords.compareLists(expectedproducts, displayedproducts)
		if(UnmatchedItems_status.getStatus() == 2){
			ArrayList<MissingCategoryRemarkData> missingcategoryremarks = new ArrayList<MissingCategoryRemarkData>()
			MissingCategoryRemarkData missingcategoryremark = new MissingCategoryRemarkData()
			missingcategoryremark.setCategoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
			missingcategoryremark.setSubcategory(ProjectConstants.CURRENTVISITING_SUBCATEGORY)
			missingcategoryremark.setProducts(UnmatchedItems_status.getItems())
			missingcategoryremark.setProducts_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_NOTMATCH)
			missingcategoryremarks.add(missingcategoryremark)
			MissingCategoryData missingcategory = new MissingCategoryData()
			missingcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategory.setMissingcategoryremarks(missingcategoryremarks)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingcategoriesdata(missingcategory)
				}
				else{
				}
			}
		}
		else if(UnmatchedItems_status.getStatus() == 1){
			ArrayList<MissingCategoryRemarkData> missingcategoryremarks = new ArrayList<MissingCategoryRemarkData>()
			MissingCategoryRemarkData missingcategoryremark = new MissingCategoryRemarkData()
			missingcategoryremark.setCategoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
			missingcategoryremark.setSubcategory(ProjectConstants.CURRENTVISITING_SUBCATEGORY)
			missingcategoryremark.setProducts(UnmatchedItems_status.getItems())
			missingcategoryremark.setProducts_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MORE)
			missingcategoryremarks.add(missingcategoryremark)
			MissingCategoryData missingcategory = new MissingCategoryData()
			missingcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategory.setMissingcategoryremarks(missingcategoryremarks)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingcategoriesdata(missingcategory)
				}
				else{
				}
			}
		}
		else if(UnmatchedItems_status.getStatus() == -1){
			ArrayList<MissingCategoryRemarkData> missingcategoryremarks = new ArrayList<MissingCategoryRemarkData>()
			MissingCategoryRemarkData missingcategoryremark = new MissingCategoryRemarkData()
			missingcategoryremark.setCategoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
			missingcategoryremark.setSubcategory(ProjectConstants.CURRENTVISITING_SUBCATEGORY)
			missingcategoryremark.setProducts(UnmatchedItems_status.getItems())
			missingcategoryremark.setProducts_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MISSING)
			missingcategoryremarks.add(missingcategoryremark)
			MissingCategoryData missingcategory = new MissingCategoryData()
			missingcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategory.setMissingcategoryremarks(missingcategoryremarks)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingcategoriesdata(missingcategory)
				}
				else{
				}
			}
		}
		else{
		}
		ArrayList<VisitedCategoryRemarkData> visitedcategoryremarks = new ArrayList<VisitedCategoryRemarkData>()
		VisitedCategoryRemarkData visitedcategoryremark = new VisitedCategoryRemarkData()

		String remark = ProjectConstants.CURRENTVISITING_CATEGORYREMARK


		visitedcategoryremark.setCategoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
		visitedcategoryremark.setSubcategory(ProjectConstants.CURRENTVISITING_SUBCATEGORY)
		visitedcategoryremark.setShopproductsdata(visitedshopproducts)
		visitedcategoryremarks.add(visitedcategoryremark)
		VisitedCategoryData visitedcategory = new VisitedCategoryData()
		visitedcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
		visitedcategory.setVisitedcategoryremarks(visitedcategoryremarks)

		for(int i=0; i< ProjectConstants.visitedshopdatainfo.size(); i++){
			if(ProjectConstants.visitedshopdatainfo.get(i).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)){
				VisitedShopDataInfo visitedshopdata = ProjectConstants.visitedshopdatainfo.get(i)
				ArrayList<VisitedCategoryData> visitedcategoriesdata = visitedshopdata.getVisitedcategoriesdata()
				if(visitedcategoriesdata != null){
					boolean flag = false
					for(int k=0; k<visitedcategoriesdata.size(); k++){
						VisitedCategoryData visitedcategorydata = visitedcategoriesdata.get(k)
						if(visitedcategorydata.getMaincategory().equals(visitedcategory.getMaincategory())){
							ArrayList<VisitedCategoryRemarkData> visitedcategoryremarksdata = visitedcategorydata.getVisitedcategoryremarks()
							if(visitedcategoryremarksdata != null){
								for(int m=0; m< visitedcategoryremarksdata.size(); m++){
									VisitedCategoryRemarkData visitedcategoryremarkdata = visitedcategoryremarksdata.get(m)
									if(visitedcategoryremarkdata != null && (visitedcategoryremarkdata.getCategoryremark().equalsIgnoreCase(visitedcategoryremark.getCategoryremark()) && visitedcategoryremarkdata.getSubcategory().equalsIgnoreCase(visitedcategoryremark.getSubcategory()))){
										flag = true
										ArrayList<ShopProductsData> shopproductsdata = visitedcategoryremarkdata.getShopproductsdata()
										for(int n=0; n< shopproductsdata.size(); n++){
											ShopProductsData existingshopproductsdata = shopproductsdata.get(n)
											for(int b=0; b< visitedshopproducts.size(); b++){
												ShopProductsData displayedshopproductsdata = visitedshopproducts.get(b)
												if(ProjectConstants.SCENARIO.equals("first visit")){
													if(existingshopproductsdata.getProduct().equalsIgnoreCase(displayedshopproductsdata.getProduct())){
														existingshopproductsdata.setPd_displayspaceavailable(displayedshopproductsdata.getPd_displayspaceavailable())
														break
													}
													else{}
												}
												else{
													if(existingshopproductsdata.getProduct().equalsIgnoreCase(displayedshopproductsdata.getProduct())){
														existingshopproductsdata.setPd_overwrite_displayspaceavailable(displayedshopproductsdata.getPd_overwrite_displayspaceavailable())
														break
													}
													else{}
												}
											}
										}
									}
								}
							}
						}
					}
					if(flag == false){
						ProjectConstants.visitedshopdatainfo.get(i).setVisitedcategoriesdata(visitedcategory)
						break
					}
				}
				else{
					ProjectConstants.visitedshopdatainfo.get(i).setVisitedcategoriesdata(visitedcategory)
					break
				}
			}
		}
	}
	// for secondary display remarks
	@Keyword
	def enterUnitsForSecondaryDisplay(){
		MobileElement editfield1 = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.EditText[1]")
		MobileElement editfield2 = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.EditText[1]")
		editfield1.setValue("4")
		Mobile.hideKeyboard()
		editfield2.setValue("4")
		Mobile.hideKeyboard()
	}
	@Keyword
	def enterUtilizationForSecondaryDisplay(int status){
		MobileElement editfield = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.EditText[1]")
		if(status == 1){
			editfield.setValue("50")
		}
		else{
			editfield.setValue("100")
		}
	}
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
	def enterUtilizationForAdditionalInfo(int status){
		MobileElement editfield = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.EditText[1]")
		if(status == 1){
			editfield.setValue("50")
		}
		else{
			editfield.setValue("100")
		}
	}
	@Keyword
	def visitAdditionalInfoQuestions(){
		int index = 0
		String itemtextbeforeswipe = ""
		String itemtextafterswipe = ""
		String tag = ""
		MobileElement surveyquestion = null
		ArrayList<String> visitedsurveyquestions = new ArrayList<String>()
		ArrayList<String> expectedsurveyquestionslist = new ArrayList<String>()
		ArrayList<ProductWithValue> expectedsurveyquestions = LoadDataKeywords.loadAdditionalInfoQuestionsList(LoadDataKeywords.loadAdditionalInfoQuestionsSheet() , ProjectConstants.ADDITIONALINFOQUESTION_VALUE)
		for(int i=0; i< expectedsurveyquestions.size(); i++){
			expectedsurveyquestionslist.add(expectedsurveyquestions.get(i).getProduct())
		}
		ArrayList<MobileElement> surveyquestionslist = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
		for(int i=0; i< surveyquestionslist.size(); i++){
			surveyquestion = surveyquestionslist.get(i)
			tag = surveyquestion.getTagName()
			if(tag.equalsIgnoreCase("android.widget.Spinner")){
				boolean flag = false
				String displayeddropdowntext = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
				visitedsurveyquestions.add(displayeddropdowntext)
				surveyquestion.click()
				Mobile.verifyElementExist(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/Validate_QuestionRemarksPopupScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				for(int j=0; j< expectedsurveyquestions.size(); j++){
					if(expectedsurveyquestions.get(j).getProduct().equalsIgnoreCase(displayeddropdowntext)){
						flag = true
						String status = expectedsurveyquestions.get(j).getStatus()
						String options = expectedsurveyquestions.get(j).getOptions()
						if(options.equalsIgnoreCase("Y/N")){
							Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/QuestionRemarks_YesOption", [('package') : ProjectConstants.PACKAGENAME]), 0)
						}
						else{
							Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/QuestionRemarks_YesOption", [('package') : ProjectConstants.PACKAGENAME]), 0)

						}
						if(status.equalsIgnoreCase("Y")){
							validateCameraScreenAndTakePicture()
							break
						}
						else{}
					}
					else{}
				}
				if(flag == false){
					Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/QuestionRemarks_YesOption", [('package') : ProjectConstants.PACKAGENAME]), 0)
					validateCameraScreenAndTakePicture()
				}
				else{}
				Mobile.verifyElementText(findTestObject('Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/Validate_QuestionsScreen', [('package') : ProjectConstants.PACKAGENAME]), 'Questions')
			}
			else{
				boolean flag = false
				String displayededitfieldtext = surveyquestion.getText()
				visitedsurveyquestions.add(displayededitfieldtext)
				for(int j=0; j< expectedsurveyquestions.size(); j++){
					String expectededitfieldtext = expectedsurveyquestions.get(j).getProduct()
					if(displayededitfieldtext.equalsIgnoreCase(expectededitfieldtext)){
						flag = true
						String questionvalue = expectedsurveyquestions.get(j).getProduct_value()
						surveyquestion.setValue(questionvalue)
						Mobile.hideKeyboard()
					}
					else{
					}
				}
				if(flag == false){
					surveyquestion.setValue("0000")
					Mobile.hideKeyboard()
				}
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
			Mobile.swipe(20, 315, 20, 200)
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
					boolean flag = false
					String displayeddropdowntext = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
					visitedsurveyquestions.add(displayeddropdowntext)
					surveyquestion.click()
					Mobile.verifyElementExist(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/Validate_QuestionRemarksPopupScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
					for(int j=0; j< expectedsurveyquestions.size(); j++){
						if(expectedsurveyquestions.get(j).getProduct().equalsIgnoreCase(displayeddropdowntext)){
							flag = true
							String status = expectedsurveyquestions.get(j).getStatus()
							String options = expectedsurveyquestions.get(j).getOptions()
							if(options.equalsIgnoreCase("Y/N")){
								Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/QuestionRemarks_YesOption", [('package') : ProjectConstants.PACKAGENAME]), 0)
							}
							else{
								Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/QuestionRemarks_YesOption", [('package') : ProjectConstants.PACKAGENAME]), 0)

							}
							if(status.equalsIgnoreCase("Y")){
								validateCameraScreenAndTakePicture()
								break
							}
							else{}
						}
						else{}
					}
					if(flag == false){
						Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/QuestionRemarks_YesOption", [('package') : ProjectConstants.PACKAGENAME]), 0)
						validateCameraScreenAndTakePicture()
					}
					else{}
					Mobile.verifyElementText(findTestObject('Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/Validate_QuestionsScreen', [('package') : ProjectConstants.PACKAGENAME]), 'Questions')
				}
				else{
					boolean flag = false
					String displayededitfieldtext = surveyquestion.getText()
					visitedsurveyquestions.add(displayededitfieldtext)
					for(int j=0; j< expectedsurveyquestions.size(); j++){
						String expectededitfieldtext = expectedsurveyquestions.get(j).getProduct()
						if(displayededitfieldtext.equalsIgnoreCase(expectededitfieldtext)){
							flag = true
							String questionvalue = expectedsurveyquestions.get(j).getProduct_value()
							surveyquestion.setValue(questionvalue)
							Mobile.hideKeyboard()
						}
						else{
						}
					}
					if(flag == false){
						surveyquestion.setValue("0000")
						Mobile.hideKeyboard()
					}
				}
			}
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
			Mobile.swipe(20, 314, 20, 200)
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
					boolean flag = false
					String displayeddropdowntext = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
					visitedsurveyquestions.add(displayeddropdowntext)
					surveyquestion.click()
					Mobile.verifyElementExist(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/Validate_QuestionRemarksPopupScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
					for(int j=0; j< expectedsurveyquestions.size(); j++){
						if(expectedsurveyquestions.get(j).getProduct().equalsIgnoreCase(displayeddropdowntext)){
							flag = true
							String status = expectedsurveyquestions.get(j).getStatus()
							String options = expectedsurveyquestions.get(j).getOptions()
							if(options.equalsIgnoreCase("Y/N")){
								Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/QuestionRemarks_YesOption", [('package') : ProjectConstants.PACKAGENAME]), 0)
							}
							else{
								Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/QuestionRemarks_YesOption", [('package') : ProjectConstants.PACKAGENAME]), 0)

							}
							if(status.equalsIgnoreCase("Y")){
								validateCameraScreenAndTakePicture()
								break
							}
							else{}
						}
						else{}
					}
					if(flag == false){
						Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/QuestionRemarks_YesOption", [('package') : ProjectConstants.PACKAGENAME]), 0)
						validateCameraScreenAndTakePicture()
					}
					else{}
					Mobile.verifyElementText(findTestObject('Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/Validate_QuestionsScreen', [('package') : ProjectConstants.PACKAGENAME]), 'Questions')
				}
				else{
					boolean flag = false
					String displayededitfieldtext = surveyquestion.getText()
					visitedsurveyquestions.add(displayededitfieldtext)
					for(int j=0; j< expectedsurveyquestions.size(); j++){
						String expectededitfieldtext = expectedsurveyquestions.get(j).getProduct()
						if(displayededitfieldtext.equalsIgnoreCase(expectededitfieldtext)){
							flag = true
							String questionvalue = expectedsurveyquestions.get(j).getProduct_value()
							surveyquestion.setValue(questionvalue)
							Mobile.hideKeyboard()
						}
						else{
						}
					}
					if(flag == false){
						surveyquestion.setValue("0000")
						Mobile.hideKeyboard()
					}
				}
			}
		}
		UnmatchedItems UnmatchedItems_status = CompareDataKeywords.compareLists(expectedsurveyquestionslist, visitedsurveyquestions)
		if(UnmatchedItems_status.getStatus() == 2){
			MissingCategoryData missingcategory = new MissingCategoryData()
			missingcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategory.setSubcategory(ProjectConstants.CURRENTVISITING_SUBCATEGORY)
			missingcategory.setProducts(UnmatchedItems_status.getItems())
			missingcategory.setProducts_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_NOTMATCH)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingcategoriesdata(missingcategory)
				}
				else{
				}
			}
		}
		else if(UnmatchedItems_status.getStatus() == 1){
			MissingCategoryData missingcategory = new MissingCategoryData()
			missingcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategory.setSubcategory(ProjectConstants.CURRENTVISITING_SUBCATEGORY)
			missingcategory.setProducts(UnmatchedItems_status.getItems())
			missingcategory.setProducts_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MORE)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingcategoriesdata(missingcategory)
				}
				else{
				}
			}
		}
		else if(UnmatchedItems_status.getStatus() == -1){
			MissingCategoryData missingcategory = new MissingCategoryData()
			missingcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategory.setSubcategory(ProjectConstants.CURRENTVISITING_SUBCATEGORY)
			missingcategory.setProducts(UnmatchedItems_status.getItems())
			missingcategory.setProducts_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MISSING)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingcategoriesdata(missingcategory)
				}
				else{
				}
			}
		}
		else{
		}
	}
	@Keyword
	def overwriteAdditionalInfoQuestions(){
		int index = 0
		String itemtextbeforeswipe = ""
		String itemtextafterswipe = ""
		String tag = ""
		MobileElement surveyquestion = null
		ArrayList<String> visitedsurveyquestions = new ArrayList<String>()
		ArrayList<String> expectedsurveyquestionslist = new ArrayList<String>()
		ArrayList<ProductWithValue> expectedsurveyquestions = LoadDataKeywords.loadAdditionalInfoQuestionsList(LoadDataKeywords.loadAdditionalInfoQuestionsSheet() , ProjectConstants.OVERWRITE_ADDITIONALINFOQUESTION_VALUE)
		for(int i=0; i< expectedsurveyquestions.size(); i++){
			expectedsurveyquestionslist.add(expectedsurveyquestions.get(i).getProduct())
		}
		ArrayList<MobileElement> surveyquestionslist = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
		for(int i=0; i< surveyquestionslist.size(); i++){
			surveyquestion = surveyquestionslist.get(i)
			tag = surveyquestion.getTagName()
			if(tag.equalsIgnoreCase("android.widget.Spinner")){
				boolean flag = false
				String displayeddropdowntext = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
				visitedsurveyquestions.add(displayeddropdowntext)
				surveyquestion.click()
				Mobile.verifyElementExist(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/Validate_QuestionRemarksPopupScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				for(int j=0; j< expectedsurveyquestions.size(); j++){
					if(expectedsurveyquestions.get(j).getProduct().equalsIgnoreCase(displayeddropdowntext)){
						flag = true
						String status = expectedsurveyquestions.get(j).getStatus()
						String options = expectedsurveyquestions.get(j).getOptions()
						if(options.equalsIgnoreCase("Y/N")){
							Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/QuestionRemarks_NoOption", [('package') : ProjectConstants.PACKAGENAME]), 0)
						}
						else{
							Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/QuestionRemarks_YesOption", [('package') : ProjectConstants.PACKAGENAME]), 0)

						}
						if(status.equalsIgnoreCase("Y")){
							validateCameraScreenAndTakePicture()
							break
						}
						else{}
					}
					else{}
				}
				if(flag == false){
					Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/QuestionRemarks_YesOption", [('package') : ProjectConstants.PACKAGENAME]), 0)
					validateCameraScreenAndTakePicture()
				}
				else{}
				Mobile.verifyElementText(findTestObject('Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/Validate_QuestionsScreen', [('package') : ProjectConstants.PACKAGENAME]), 'Questions')
			}
			else{
				boolean flag = false
				String displayededitfieldtext = surveyquestion.getText()
				visitedsurveyquestions.add(displayededitfieldtext)
				for(int j=0; j< expectedsurveyquestions.size(); j++){
					String expectededitfieldtext = expectedsurveyquestions.get(j).getProduct()
					if(displayededitfieldtext.equalsIgnoreCase(expectededitfieldtext)){
						flag = true
						String questionvalue = expectedsurveyquestions.get(j).getProduct_value()
						surveyquestion.setValue(questionvalue)
						Mobile.hideKeyboard()
					}
					else{
					}
				}
				if(flag == false){
					surveyquestion.setValue("0000")
					Mobile.hideKeyboard()
				}
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
			Mobile.swipe(20, 315, 20, 200)
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
					boolean flag = false
					String displayeddropdowntext = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
					visitedsurveyquestions.add(displayeddropdowntext)
					surveyquestion.click()
					Mobile.verifyElementExist(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/Validate_QuestionRemarksPopupScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
					for(int j=0; j< expectedsurveyquestions.size(); j++){
						if(expectedsurveyquestions.get(j).getProduct().equalsIgnoreCase(displayeddropdowntext)){
							flag = true
							String status = expectedsurveyquestions.get(j).getStatus()
							String options = expectedsurveyquestions.get(j).getOptions()
							if(options.equalsIgnoreCase("Y/N")){
								Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/QuestionRemarks_NoOption", [('package') : ProjectConstants.PACKAGENAME]), 0)
							}
							else{
								Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/QuestionRemarks_YesOption", [('package') : ProjectConstants.PACKAGENAME]), 0)

							}
							if(status.equalsIgnoreCase("Y")){
								validateCameraScreenAndTakePicture()
								break
							}
							else{}
						}
						else{}
					}
					if(flag == false){
						Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/QuestionRemarks_YesOption", [('package') : ProjectConstants.PACKAGENAME]), 0)
						validateCameraScreenAndTakePicture()
					}
					else{}
					Mobile.verifyElementText(findTestObject('Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/Validate_QuestionsScreen', [('package') : ProjectConstants.PACKAGENAME]), 'Questions')
				}
				else{
					boolean flag = false
					String displayededitfieldtext = surveyquestion.getText()
					visitedsurveyquestions.add(displayededitfieldtext)
					for(int j=0; j< expectedsurveyquestions.size(); j++){
						String expectededitfieldtext = expectedsurveyquestions.get(j).getProduct()
						if(displayededitfieldtext.equalsIgnoreCase(expectededitfieldtext)){
							flag = true
							String questionvalue = expectedsurveyquestions.get(j).getProduct_value()
							surveyquestion.setValue(questionvalue)
							Mobile.hideKeyboard()
						}
						else{
						}
					}
					if(flag == false){
						surveyquestion.setValue("0000")
						Mobile.hideKeyboard()
					}
				}
			}
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
			Mobile.swipe(20, 314, 20, 200)
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
					boolean flag = false
					String displayeddropdowntext = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
					visitedsurveyquestions.add(displayeddropdowntext)
					surveyquestion.click()
					Mobile.verifyElementExist(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/Validate_QuestionRemarksPopupScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
					for(int j=0; j< expectedsurveyquestions.size(); j++){
						if(expectedsurveyquestions.get(j).getProduct().equalsIgnoreCase(displayeddropdowntext)){
							flag = true
							String status = expectedsurveyquestions.get(j).getStatus()
							String options = expectedsurveyquestions.get(j).getOptions()
							if(options.equalsIgnoreCase("Y/N")){
								Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/QuestionRemarks_NoOption", [('package') : ProjectConstants.PACKAGENAME]), 0)
							}
							else{
								Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/QuestionRemarks_YesOption", [('package') : ProjectConstants.PACKAGENAME]), 0)

							}
							if(status.equalsIgnoreCase("Y")){
								validateCameraScreenAndTakePicture()
								break
							}
							else{}
						}
						else{}
					}
					if(flag == false){
						Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/QuestionRemarks_YesOption", [('package') : ProjectConstants.PACKAGENAME]), 0)
						validateCameraScreenAndTakePicture()
					}
					else{}
					Mobile.verifyElementText(findTestObject('Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/Validate_QuestionsScreen', [('package') : ProjectConstants.PACKAGENAME]), 'Questions')
				}
				else{
					boolean flag = false
					String displayededitfieldtext = surveyquestion.getText()
					visitedsurveyquestions.add(displayededitfieldtext)
					for(int j=0; j< expectedsurveyquestions.size(); j++){
						String expectededitfieldtext = expectedsurveyquestions.get(j).getProduct()
						if(displayededitfieldtext.equalsIgnoreCase(expectededitfieldtext)){
							flag = true
							String questionvalue = expectedsurveyquestions.get(j).getProduct_value()
							surveyquestion.setValue(questionvalue)
							Mobile.hideKeyboard()
						}
						else{
						}
					}
					if(flag == false){
						surveyquestion.setValue("0000")
						Mobile.hideKeyboard()
					}
				}
			}
		}
		UnmatchedItems UnmatchedItems_status = CompareDataKeywords.compareLists(expectedsurveyquestionslist, visitedsurveyquestions)
		if(UnmatchedItems_status.getStatus() == 2){
			MissingCategoryData missingcategory = new MissingCategoryData()
			missingcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategory.setSubcategory(ProjectConstants.CURRENTVISITING_SUBCATEGORY)
			missingcategory.setProducts(UnmatchedItems_status.getItems())
			missingcategory.setProducts_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_NOTMATCH)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingcategoriesdata(missingcategory)
				}
				else{
				}
			}
		}
		else if(UnmatchedItems_status.getStatus() == 1){
			MissingCategoryData missingcategory = new MissingCategoryData()
			missingcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategory.setSubcategory(ProjectConstants.CURRENTVISITING_SUBCATEGORY)
			missingcategory.setProducts(UnmatchedItems_status.getItems())
			missingcategory.setProducts_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MORE)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingcategoriesdata(missingcategory)
				}
				else{
				}
			}
		}
		else if(UnmatchedItems_status.getStatus() == -1){
			MissingCategoryData missingcategory = new MissingCategoryData()
			missingcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategory.setSubcategory(ProjectConstants.CURRENTVISITING_SUBCATEGORY)
			missingcategory.setProducts(UnmatchedItems_status.getItems())
			missingcategory.setProducts_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MISSING)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingcategoriesdata(missingcategory)
				}
				else{
				}
			}
		}
		else{
		}
	}
	def validateCameraScreenAndTakePicture(){
		try{
			Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_CameraScreen", [('package') : ProjectConstants.PACKAGENAME]), 0, FailureHandling.OPTIONAL)
			Mobile.tap(findTestObject("Object Repository/CommonScreenElements/TakePictureButton", [('package') : ProjectConstants.PACKAGENAME]), 0)
			Mobile.delay(5)
			Mobile.tap(findTestObject("Object Repository/CommonScreenElements/DoneButton", [('package') : ProjectConstants.PACKAGENAME]), 0)
		}
		catch(Exception ex){

		}
	}
}
