package com.ct.qa.keywords

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.apache.poi.xssf.usermodel.XSSFSheet

import com.ct.qa.constants.ProjectConstants
import com.ct.qa.struct.GetClassWithIndex
import com.ct.qa.struct.MissingCategoryData
import com.ct.qa.struct.ProductWithValue
import com.ct.qa.struct.UnmatchedProducts
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
		Mobile.verifyElementExist(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/Validate_MainCategoryDetailActionScreen"), 0)
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
		int totalsubcategories = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<= totalsubcategories; i++){
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
		int index = 0
		int totalproducts = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*").size()
		for(int i=1; i<= totalproducts; i=i+2){
			index = index + 1
			ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.RadioGroup[1]/android.widget.RadioButton[1]").click()
		}
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
					ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[9]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.RadioGroup[1]/android.widget.RadioButton[1]").click()
				}
			}
			else{

			}
		}
	}
	@Keyword
	def visitProductsAvailabilityWithNoRemarks(){
		int index = 0
		int totalproducts = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*").size()
		for(int i=1; i<= totalproducts; i=i+2){
			index = index + 1
			ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.RadioGroup[1]/android.widget.RadioButton[2]").click()
		}
		while(true){
			MobileElement productbeforeswipe = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[9]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")
			String productnamebeforeswipe = productbeforeswipe.getText()
			Mobile.swipe(0, 273, 0, 200)
			MobileElement productafterswipe = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[9]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")
			String productnameafterswipe = productafterswipe.getText()
			if(productnamebeforeswipe.equals(productnameafterswipe)){
				break
			}
			else{
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[9]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.RadioGroup[1]/android.widget.RadioButton[2]").click()
			}
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
		UnmatchedProducts unmatchedproducts_status = CompareDataKeywords.compareChannelWiseProductsCategories()
		if(unmatchedproducts_status.getStatus() == 2){
			MissingCategoryData missingcategorydata = new MissingCategoryData()
			missingcategorydata.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategorydata.setProductcategories(unmatchedproducts_status.getProducts())
			missingcategorydata.setProductcategories_errormessage(ProjectConstants.MESSAGEFOR_PRODUCTSCATEGORIESARE_NOTMATCH)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingCategoriesData(missingcategorydata, "")
					break
				}
				else{
				}
			}
		}
		else if(unmatchedproducts_status.getStatus() == 1){
			MissingCategoryData missingcategorydata = new MissingCategoryData()
			missingcategorydata.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategorydata.setProductcategories(unmatchedproducts_status.getProducts())
			missingcategorydata.setProductcategories_errormessage(ProjectConstants.MESSAGEFOR_PRODUCTSCATEGORIESARE_MORE)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingCategoriesData(missingcategorydata, "")
					break
				}
				else{
				}
			}
		}
		else if(unmatchedproducts_status.getStatus() == -1){
			MissingCategoryData missingcategorydata = new MissingCategoryData()
			missingcategorydata.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategorydata.setProductcategories(unmatchedproducts_status.getProducts())
			missingcategorydata.setProductcategories_errormessage(ProjectConstants.MESSAGEFOR_PRODUCTSCATEGORIESARE_MISSING)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingCategoriesData(missingcategorydata, "")
					break
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
			ProjectConstants.CURRENTVISITING_PRODUCTCATEGORY = productcategory.getText()
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
		ArrayList<ProductWithValue> displayedchannelproducts = new ArrayList<ProductWithValue>()
		int index = 0
		XSSFSheet sheet = LoadDataKeywords.loadChannelProductsSheet()
		ArrayList<ProductWithValue> expectedchannelproducts = LoadDataKeywords.loadChannelWiseProductsList(sheet, columnindex)
		int totalproducts = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*").size()
		for(int i=1; i<= totalproducts; i=i+3){
			ProductWithValue channelproduct = new ProductWithValue()
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
					channelproduct.setProduct_value(expectedchannelproduct.getProduct_value())
					Mobile.hideKeyboard()
					break
				}
				else{}
			}
			if(flag == false){
				MobileElement edittext = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.EditText[1]")
				edittext.setValue("0000")
				channelproduct.setProduct_value("0000")
				Mobile.hideKeyboard()
			}
			else{}
			displayedchannelproducts.add(channelproduct)
		}
		totalproducts = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*").size()
		if(totalproducts >= 16){
			while(true){
				ProductWithValue channelproduct = new ProductWithValue()
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
							channelproduct.setProduct_value(expectedchannelproduct.getProduct_value())
							Mobile.hideKeyboard()
							break
						}
						else{}
					}
					if(flag == false){
						MobileElement edittext = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[6]/android.widget.EditText[1]")
						edittext.setValue("0000")
						channelproduct.setProduct_value("0000")
						Mobile.hideKeyboard()
					}
					else{}
				}
				displayedchannelproducts.add(channelproduct)
			}
		}
		else{}
		if(expectedchannelproducts.size() == displayedchannelproducts.size()){
			ArrayList<String> products = new ArrayList<String>()
			for(int i=0; i<displayedchannelproducts.size(); i++){
				boolean match = false
				for(int j=0; j<expectedchannelproducts.size(); j++){
					String dis = displayedchannelproducts.get(i).getProduct()
					String exp = expectedchannelproducts.get(j).getProduct()
					if(displayedchannelproducts.get(i).getProduct().equalsIgnoreCase(expectedchannelproducts.get(j).getProduct())){
						match = true
						break
					}
					else{}
				}
				if(match == false){
					products.add(displayedchannelproducts.get(i).getProduct())
				}
				else{
				}
			}
			if(!products.isEmpty()){
				MissingCategoryData missingcategorydata = new MissingCategoryData()
				missingcategorydata.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
				missingcategorydata.setProducts(products)
				missingcategorydata.setProductCategory(ProjectConstants.CURRENTVISITING_PRODUCTCATEGORY)
				missingcategorydata.setProducts_errormessage(ProjectConstants.MESSAGEFOR_PRODUCTSARE_NOTMATCH)
				for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
					if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.missingshopdatainfo.get(j).setMissingCategoriesData(missingcategorydata)
						break
					}
					else{
					}
				}
			}
			else{
			}
		}
		else if(expectedchannelproducts.size() < displayedchannelproducts.size()){
			ArrayList<String> products = new ArrayList<String>()
			for(int i=0; i<displayedchannelproducts.size(); i++){
				boolean match = false
				for(int j=0; j<expectedchannelproducts.size(); j++){
					if(displayedchannelproducts.get(i).getProduct().equalsIgnoreCase(expectedchannelproducts.get(j).getProduct())){
						match = true
						break
					}
				}
				if(match == false){
					products.add(displayedchannelproducts.get(i).getProduct())
				}
				else{
				}
			}
			MissingCategoryData missingcategorydata = new MissingCategoryData()
			missingcategorydata.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategorydata.setProducts(products)
			missingcategorydata.setProductCategory(ProjectConstants.CURRENTVISITING_PRODUCTCATEGORY)
			missingcategorydata.setProducts_errormessage(ProjectConstants.MESSAGEFOR_PRODUCTSARE_MORE)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingCategoriesData(missingcategorydata)
				}
				else{
				}
			}
		}
		else if(expectedchannelproducts.size() > displayedchannelproducts.size()){
			ArrayList<String> products = new ArrayList<String>()
			for(int i=0; i<expectedchannelproducts.size(); i++){
				boolean match = false
				for(int j=0; j<displayedchannelproducts.size(); j++){
					if(expectedchannelproducts.get(i).getProduct().equalsIgnoreCase(displayedchannelproducts.get(j).getProduct())){
						match = true
						break
					}
				}
				if(match == false){
					products.add(expectedchannelproducts.get(i).getProduct())
				}
				else{
				}
			}
			MissingCategoryData missingcategorydata = new MissingCategoryData()
			missingcategorydata.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategorydata.setProductCategory(ProjectConstants.CURRENTVISITING_PRODUCTCATEGORY)
			missingcategorydata.setProducts_errormessage(ProjectConstants.MESSAGEFOR_PRODUCTSARE_MISSING)
			missingcategorydata.setProducts(products)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingCategoriesData(missingcategorydata)
					break
				}
				else{
				}
			}
		}
		else{

			String message = "Main Category: "+ProjectConstants.CURRENTVISITING_MAINCATEGORY+"\nProduct Category: "+ProjectConstants.CURRENTVISITING_PRODUCTCATEGORY+"\n"+ProjectConstants.MESSAGEFOR_DISPLAYEDPRODUCTSARE_EQUAL
			KeywordUtil.logInfo(message)
		}
		VisitedCategoryData visitedcategorydata = new VisitedCategoryData()
		visitedcategorydata.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
		visitedcategorydata.setProductcategory(ProjectConstants.CURRENTVISITING_PRODUCTCATEGORY)
		visitedcategorydata.setShopProductsdata(displayedchannelproducts)
		for(int i=0; i< ProjectConstants.visitedshopdatainfo.size(); i++){
			if(ProjectConstants.visitedshopdatainfo.get(i).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)){
				VisitedShopDataInfo visitedshopdata = ProjectConstants.visitedshopdatainfo.get(i)
				ArrayList<VisitedCategoryData> visitedcategoriesdata = visitedshopdata.getVisitedcategoriesdata()
				if(visitedcategoriesdata.size() != 0){
					boolean flag = false
					for(int k=0; k<visitedcategoriesdata.size(); k++){
						VisitedCategoryData visitedcategorydatainfo = visitedcategoriesdata.get(k)
						if(visitedcategorydatainfo.getMaincategory().equals(visitedcategorydata.getMaincategory()) && visitedcategorydatainfo.getProductcategory().equals(visitedcategorydata.getProductcategory())){
							flag = true
							for(int l=0; l< visitedcategorydatainfo.getShopProductsdata().size(); l++){
								ProductWithValue existingproductsdata = visitedcategorydatainfo.getShopProductsdata().get(l)
								for(int m=0; m< displayedchannelproducts.size(); m++){
									ProductWithValue displayedchannelproduct = displayedchannelproducts.get(m)
									if(existingproductsdata.getProduct().equals(displayedchannelproduct.getProduct())){
										if(ProjectConstants.scenario.equals("first visit")){
											existingproductsdata.setProduct_value(displayedchannelproduct.getProduct_value())
										}
										else{
										}
									}
								}
							}
						}
					}
					if(flag == false){
						ProjectConstants.visitedshopdatainfo.get(i).setVisitedcategoriesdata(visitedcategorydata)
						break
					}
				}
				else{
					ProjectConstants.visitedshopdatainfo.get(i).setVisitedcategoriesdata(visitedcategorydata)
					break
				}
			}
		}
	}
	// for secondary display remarks
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
		int index = 1
		int totaleditfields = driver.findElementsByClassName("android.widget.EditText").size()
		int totaldropdowns = driver.findElementsByClassName("android.widget.Spinner").size()
		for(int i=1; i<= totaldropdowns; i++){
			driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.Spinner["+i+"]").click()
			Mobile.verifyElementExist(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/Validate_ConfirmPopupScreen"), 0)
			Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/ConfirmPopup_YesOption"), 0)
			validateCameraScreenAndTakePicture()
			Mobile.verifyElementText(findTestObject('ShopOpen/RemainingMainCategories/AdditionalInfo/Validate_QuestionsScreen'), 'Questions')
		}
		for(int i=1; i<= totaleditfields; i++){
			MobileElement edittextfield = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.EditText["+i+"]")
			edittextfield.setValue("100")
			Mobile.hideKeyboard()
		}
		while(true){
			int xlocation = ProjectConstants.getXPoint()
			totaleditfields = driver.findElementsByClassName("android.widget.EditText").size()
			totaldropdowns = driver.findElementsByClassName("android.widget.Spinner").size()
			String questionnamebeforeswipe_edittext = ""
			String questionnamebeforeswipe_dropdown = ""
			String questionnameafterswipe_edittext = ""
			String questionnameafterswipe_dropdown = ""
			if(totaldropdowns != 0){
				MobileElement questionbeforeswipe_dropdown = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.Spinner["+totaldropdowns+"]/android.widget.LinearLayout[1]/android.widget.TextView[1]")
				questionnamebeforeswipe_dropdown = questionbeforeswipe_dropdown.getText()
			}
			if(totaleditfields != 0){
				MobileElement questionbeforeswipe_edittext = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.EditText["+totaleditfields+"]")
				questionnamebeforeswipe_edittext = questionbeforeswipe_edittext.getText()
			}
			Mobile.swipe(xlocation, 580, xlocation, 300)
			Mobile.swipe(xlocation, 580, xlocation, 300)
			totaleditfields = driver.findElementsByClassName("android.widget.EditText").size()
			totaldropdowns = driver.findElementsByClassName("android.widget.Spinner").size()
			if(totaldropdowns != 0){
				MobileElement questionafterswipe_dropdown = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.Spinner["+totaldropdowns+"]/android.widget.LinearLayout[1]/android.widget.TextView[1]")
				questionnameafterswipe_dropdown = questionafterswipe_dropdown.getText()
			}
			if(totaleditfields != 0){
				MobileElement questionafterswipe_edittext = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.EditText["+totaleditfields+"]")
				questionnameafterswipe_edittext = questionafterswipe_edittext.getText()
			}
			if(questionnamebeforeswipe_edittext.equals(questionnameafterswipe_edittext) && questionnamebeforeswipe_dropdown.equals(questionnameafterswipe_dropdown)){
				break
			}
			else{
				for(int i=1; i<= totaldropdowns; i++){
					driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.Spinner["+i+"]").click()
					Mobile.verifyElementExist(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/Validate_ConfirmPopupScreen"), 0)
					Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/ConfirmPopup_YesOption"), 0)
					validateCameraScreenAndTakePicture()
					Mobile.verifyElementText(findTestObject('ShopOpen/RemainingMainCategories/AdditionalInfo/Validate_QuestionsScreen'), 'Questions')
				}
				for(int i=1; i<= totaleditfields; i++){
					MobileElement edittextfield = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.EditText["+i+"]")
					edittextfield.setValue("100")
					Mobile.hideKeyboard()
				}
			}
		}
	}
	@Keyword
	def overwriteAdditionalInfoQuestions(){
		int index = 1
		int totaleditfields = driver.findElementsByClassName("android.widget.EditText").size()
		int totaldropdowns = driver.findElementsByClassName("android.widget.Spinner").size()
		for(int i=1; i<= totaldropdowns; i++){
			driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.Spinner["+i+"]").click()
			Mobile.verifyElementExist(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/Validate_ConfirmPopupScreen"), 0)
			Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/ConfirmPopup_NoOption"), 0)
			validateCameraScreenAndTakePicture()
			Mobile.verifyElementText(findTestObject('ShopOpen/RemainingMainCategories/AdditionalInfo/Validate_QuestionsScreen'), 'Questions')
		}
		for(int i=1; i<= totaleditfields; i++){
			MobileElement edittextfield = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.EditText["+i+"]")
			edittextfield.setValue("200")
			Mobile.hideKeyboard()
		}
		while(true){
			int xlocation = ProjectConstants.getXPoint()
			totaleditfields = driver.findElementsByClassName("android.widget.EditText").size()
			totaldropdowns = driver.findElementsByClassName("android.widget.Spinner").size()
			String questionnamebeforeswipe_edittext = ""
			String questionnamebeforeswipe_dropdown = ""
			String questionnameafterswipe_edittext = ""
			String questionnameafterswipe_dropdown = ""
			if(totaldropdowns != 0){
				MobileElement questionbeforeswipe_dropdown = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.Spinner["+totaldropdowns+"]/android.widget.LinearLayout[1]/android.widget.TextView[1]")
				questionnamebeforeswipe_dropdown = questionbeforeswipe_dropdown.getText()
			}
			if(totaleditfields != 0){
				MobileElement questionbeforeswipe_edittext = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.EditText["+totaleditfields+"]")
				questionnamebeforeswipe_edittext = questionbeforeswipe_edittext.getText()
			}
			Mobile.swipe(xlocation, 580, xlocation, 300)
			Mobile.swipe(xlocation, 580, xlocation, 300)
			totaleditfields = driver.findElementsByClassName("android.widget.EditText").size()
			totaldropdowns = driver.findElementsByClassName("android.widget.Spinner").size()
			if(totaldropdowns != 0){
				MobileElement questionafterswipe_dropdown = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.Spinner["+totaldropdowns+"]/android.widget.LinearLayout[1]/android.widget.TextView[1]")
				questionnameafterswipe_dropdown = questionafterswipe_dropdown.getText()
			}
			if(totaleditfields != 0){
				MobileElement questionafterswipe_edittext = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.EditText["+totaleditfields+"]")
				questionnameafterswipe_edittext = questionafterswipe_edittext.getText()
			}
			if(questionnamebeforeswipe_edittext.equals(questionnameafterswipe_edittext) && questionnamebeforeswipe_dropdown.equals(questionnameafterswipe_dropdown)){
				break
			}
			else{
				for(int i=1; i<= totaldropdowns; i++){
					driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.Spinner["+i+"]").click()
					Mobile.verifyElementExist(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/Validate_ConfirmPopupScreen"), 0)
					Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/ConfirmPopup_NoOption"), 0)
					validateCameraScreenAndTakePicture()
					Mobile.verifyElementText(findTestObject('ShopOpen/RemainingMainCategories/AdditionalInfo/Validate_QuestionsScreen'), 'Questions')
				}
				for(int i=1; i<= totaleditfields; i++){
					MobileElement edittextfield = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.EditText["+i+"]")
					edittextfield.setValue("200")
					Mobile.hideKeyboard()
				}
			}
		}
	}
	def getAdditionalInfoClassName(){
		GetClassWithIndex classwithindex = new GetClassWithIndex()
		String classname = ""
		int spinnerindex = 0
		int edittextindex = 0
		ArrayList<MobileElement> totalquestions = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
		for(int i=1; i<= totalquestions.size(); i++){
			String question = totalquestions.get(i).getClass()
			classname = question
			if(question.equalsIgnoreCase("android.widget.EditText")){
				spinnerindex = spinnerindex + 1
			}
			else{
				edittextindex = edittextindex + 1
			}
		}
		classwithindex.setClassname(classname)
		classwithindex.setSpinnerindex(spinnerindex)
		classwithindex.setEdittextindex(edittextindex)
		return classwithindex
	}
	def validateCameraScreenAndTakePicture(){
		if(Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_CameraScreen"), 0, FailureHandling.OPTIONAL)){
			Mobile.tap(findTestObject("Object Repository/CommonScreenElements/TakePictureButton"), 0)
			Mobile.delay(5)
			Mobile.tap(findTestObject("Object Repository/CommonScreenElements/DoneButton"), 0)
		}
		else{
		}
	}
}
