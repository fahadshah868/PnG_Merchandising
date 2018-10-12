package com.ct.qa.keywords

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.ct.qa.constants.ProjectConstants
import com.ct.qa.struct.HotSpotProduct
import com.ct.qa.struct.MissingCategoryData
import com.ct.qa.struct.ProductWithValue
import com.ct.qa.struct.VisitedCategoryData
import com.ct.qa.struct.VisitedShopDataInfo
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
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
import org.apache.poi.xssf.usermodel.XSSFSheet

public class HotSpotKeywords {

	public static AppiumDriver<MobileElement> driver = ProjectConstants.DRIVER

	// for hotspot available
	@Keyword
	def selectHotSpotRemark(String _remark){
		int totalremarks = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<= totalremarks; i++){
			MobileElement remark = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			String remarkname = remark.getText()
			if(remarkname.equalsIgnoreCase(_remark)){
				driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				break
			}
			else{}
		}
	}
	@Keyword
	def visitHotSpotTypeForDataVerification(){
		int totalhotspottypes = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		if(ProjectConstants.HOTSPOTINDEX <= 9){
			ProjectConstants.HOTSPOTINDEX = ProjectConstants.HOTSPOTINDEX + 1
			MobileElement hotspot = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+ProjectConstants.HOTSPOTINDEX+"]/android.widget.TextView[1]")
			ProjectConstants.CURRENTVISITING_HOTSPOTTYPE = hotspot.getText()
			driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+ProjectConstants.HOTSPOTINDEX+"]").click()
			Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_CameraScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			Mobile.tap(findTestObject("Object Repository/CommonScreenElements/TakePictureButton", [('package') : ProjectConstants.PACKAGENAME]), 0)
			Mobile.delay(5)
			Mobile.tap(findTestObject("Object Repository/CommonScreenElements/DoneButton", [('package') : ProjectConstants.PACKAGENAME]), 0)
		}
		else{
			ProjectConstants.HOTSPOTINDEX = ProjectConstants.HOTSPOTINDEX + 1
			Mobile.swipe(0, 220, 0, 200)
			int index = ProjectConstants.HOTSPOTINDEX - totalhotspottypes
			for(int i=1; i<= index; i++){
				Mobile.swipe(0, 293, 0, 200)
			}
			MobileElement hotspot = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+totalhotspottypes+"]/android.widget.TextView[1]")
			ProjectConstants.CURRENTVISITING_HOTSPOTTYPE = hotspot.getText()
			driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+totalhotspottypes+"]").click()
			Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_CameraScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			Mobile.tap(findTestObject("Object Repository/CommonScreenElements/TakePictureButton", [('package') : ProjectConstants.PACKAGENAME]), 0)
			Mobile.delay(5)
			Mobile.tap(findTestObject("Object Repository/CommonScreenElements/DoneButton", [('package') : ProjectConstants.PACKAGENAME]), 0)
		}
	}
	@Keyword
	def visitHotSpotType(){
		int totalhotspottypes = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<= totalhotspottypes; i++){
			MobileElement hotspot = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			String hotspottext = hotspot.getText()
			ProjectConstants.CURRENTVISITING_HOTSPOTTYPE = hotspot.getText()
			if(hotspottext.equalsIgnoreCase("2 Shelfs")){
				driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_CameraScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				Mobile.tap(findTestObject("Object Repository/CommonScreenElements/TakePictureButton", [('package') : ProjectConstants.PACKAGENAME]), 0)
				Mobile.delay(5)
				Mobile.tap(findTestObject("Object Repository/CommonScreenElements/DoneButton", [('package') : ProjectConstants.PACKAGENAME]), 0)
				break
			}
			else{}
		}
	}
	@Keyword
	def visitHotSpotAvailableFacingProducts(int columnindex){
		ArrayList<HotSpotProduct> visitedhotspotproducts = new ArrayList<HotSpotProduct>()
		int index = 0
		XSSFSheet sheet = LoadDataKeywords.loadHotSpotProductsSheet()
		ArrayList<ProductWithValue> expectedhotspotproducts = LoadDataKeywords.loadHotSpotProductsList(sheet, columnindex)
		int totalproducts = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*").size()
		for(int i=1; i<= totalproducts; i=i+3){
			HotSpotProduct hotspotproduct = new HotSpotProduct()
			boolean flag = false
			index = index + 1
			MobileElement product = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.TextView["+index+"]")
			String productname = product.getText()
			hotspotproduct.setProduct(productname)
			for(int j=0; j< expectedhotspotproducts.size(); j++){
				ProductWithValue expectedhotspotproduct = expectedhotspotproducts.get(j)
				if(expectedhotspotproduct.getProduct().equalsIgnoreCase(productname)){
					flag = true
					MobileElement edittext = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.EditText[1]")
					edittext.setValue(expectedhotspotproduct.getProduct_value())
					if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
						hotspotproduct.setFacing(expectedhotspotproduct.getProduct_value())
					}
					else{
						hotspotproduct.setOverwritefacing(expectedhotspotproduct.getProduct_value())
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
					hotspotproduct.setFacing("0000")
				}
				else{
					hotspotproduct.setOverwritefacing("0000")
				}
				Mobile.hideKeyboard()
			}
			else{}
			visitedhotspotproducts.add(hotspotproduct)
		}
		totalproducts = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*").size()
		if(totalproducts >= 16){
			while(true){
				HotSpotProduct hotspotproduct = new HotSpotProduct()
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
					hotspotproduct.setProduct(productnameafterswipe)
					for(int j=0; j< expectedhotspotproducts.size(); j++){
						ProductWithValue expectedchannelproduct = expectedhotspotproducts.get(j)
						if(expectedchannelproduct.getProduct().equalsIgnoreCase(productnameafterswipe)){
							flag = true
							MobileElement edittext = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[6]/android.widget.EditText[1]")
							edittext.setValue(expectedchannelproduct.getProduct_value())
							if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
								hotspotproduct.setFacing(expectedchannelproduct.getProduct_value())
							}
							else{
								hotspotproduct.setOverwritefacing(expectedchannelproduct.getProduct_value())
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
							hotspotproduct.setFacing("0000")
						}
						else{
							hotspotproduct.setOverwritefacing("0000")
						}
						Mobile.hideKeyboard()
					}
					else{}
				}
				visitedhotspotproducts.add(hotspotproduct)
			}
		}
		else{}
		if(expectedhotspotproducts.size() == visitedhotspotproducts.size()){
			ArrayList<String> products = new ArrayList<String>()
			for(int i=0; i<visitedhotspotproducts.size(); i++){
				boolean match = false
				for(int j=0; j<expectedhotspotproducts.size(); j++){
					String dis = visitedhotspotproducts.get(i).getProduct()
					String exp = expectedhotspotproducts.get(j).getProduct()
					if(visitedhotspotproducts.get(i).getProduct().equalsIgnoreCase(expectedhotspotproducts.get(j).getProduct())){
						match = true
						break
					}
					else{}
				}
				if(match == false){
					products.add(visitedhotspotproducts.get(i).getProduct())
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
		else if(expectedhotspotproducts.size() < visitedhotspotproducts.size()){
			ArrayList<String> products = new ArrayList<String>()
			for(int i=0; i<visitedhotspotproducts.size(); i++){
				boolean match = false
				for(int j=0; j<expectedhotspotproducts.size(); j++){
					if(visitedhotspotproducts.get(i).getProduct().equalsIgnoreCase(expectedhotspotproducts.get(j).getProduct())){
						match = true
						break
					}
				}
				if(match == false){
					products.add(visitedhotspotproducts.get(i).getProduct())
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
		else if(expectedhotspotproducts.size() > visitedhotspotproducts.size()){
			ArrayList<String> products = new ArrayList<String>()
			for(int i=0; i<expectedhotspotproducts.size(); i++){
				boolean match = false
				for(int j=0; j<visitedhotspotproducts.size(); j++){
					if(expectedhotspotproducts.get(i).getProduct().equalsIgnoreCase(visitedhotspotproducts.get(j).getProduct())){
						match = true
						break
					}
				}
				if(match == false){
					products.add(expectedhotspotproducts.get(i).getProduct())
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
		visitedcategorydata.setHotspotproducts(visitedhotspotproducts)
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
							for(int l=0; l< visitedcategorydatainfo.getHotspotproducts().size(); l++){
								HotSpotProduct existingproductsdata = visitedcategorydatainfo.getHotspotproducts().get(l)
								for(int m=0; m< visitedhotspotproducts.size(); m++){
									ProductWithValue displayedhotspotproduct = visitedhotspotproducts.get(m)
									if(existingproductsdata.getProduct().equals(displayedhotspotproduct.getProduct())){
										if(ProjectConstants.SCENARIO.equals("first visit")){
											existingproductsdata.setFacing(displayedhotspotproduct.getProduct_value())
										}
										else{
											existingproductsdata.setOverwritefacing(displayedhotspotproduct.getProduct_value())
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
	@Keyword
	def findPOSMImageView(){
		int totalimageviews = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/*").size()
		for(int i=1; i<= totalimageviews; i++){
			MobileElement targetimageview = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			String targetimageviewtext = targetimageview.getText()
			if(targetimageviewtext.equalsIgnoreCase("POSM")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+i+"]/android.widget.ImageButton[1]").click()
				int totalposm = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
				for(int j=1; j<= totalposm; j++){
					driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+j+"]").click()
					Mobile.verifyElementText(findTestObject("Object Repository/ShopOpen/HotSpot/HotSpotAvailable/Validate_POSMRemarksScreen", [('package') : ProjectConstants.PACKAGENAME]), "Remarks")
					int totalremarks = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
					for(int k=1; k<= totalremarks; k++){
						MobileElement remark = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+k+"]/android.widget.TextView[1]")
						String remarktext = remark.getText()
						if(remarktext.equalsIgnoreCase("Fresh Deployment")){
							driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+k+"]").click()
							break
						}
					}
					Mobile.verifyElementText(findTestObject("Object Repository/ShopOpen/HotSpot/HotSpotAvailable/Validate_POSMScreen", [('package') : ProjectConstants.PACKAGENAME]), "POSM Deployment")
				}
				break
			}
			else{}
		}
	}
}
