package com.ct.qa.keywords

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.util.ArrayList

import com.ct.qa.constants.ProjectConstants
import com.ct.qa.struct.MissingCategoryData
import com.ct.qa.struct.ProductWithValue
import com.ct.qa.struct.ShopProductsData
import com.ct.qa.struct.SubCategory
import com.ct.qa.struct.UnmatchedItems
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
import io.appium.java_client.MobileElement
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.eclipse.persistence.internal.sessions.factories.model.project.ProjectConfig

public class HangerKeywords {

	@Keyword
	def visitHangerListWithDataVerification(String hangertype){
		UnmatchedItems UnmatchedItems_status = CompareDataKeywords.compareHangerSubCategories()
		if(UnmatchedItems_status.getStatus() == 2){
			MissingCategoryData missingcategorydata = new MissingCategoryData()
			missingcategorydata.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategorydata.setSubcategories(UnmatchedItems_status.getItems())
			missingcategorydata.setSubcategories_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_NOTMATCH)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingcategoriesdata(missingcategorydata)
					break
				}
				else{
				}
			}
		}
		else if(UnmatchedItems_status.getStatus() == 1){
			MissingCategoryData missingcategorydata = new MissingCategoryData()
			missingcategorydata.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategorydata.setSubcategories(UnmatchedItems_status.getItems())
			missingcategorydata.setSubcategories_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MORE)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingcategoriesdata(missingcategorydata)
					break
				}
				else{
				}
			}
		}
		else if(UnmatchedItems_status.getStatus() == -1){
			MissingCategoryData missingcategorydata = new MissingCategoryData()
			missingcategorydata.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategorydata.setSubcategories(UnmatchedItems_status.getItems())
			missingcategorydata.setSubcategories_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MISSING)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingcategoriesdata(missingcategorydata)
					break
				}
				else{
				}
			}
		}
		else{
		}
		int totalhangers = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<= totalhangers; i++){
			MobileElement hangercategory = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			ProjectConstants.CURRENTVISITING_SUBCATEGORY = hangercategory.getText()
			ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
			if(hangertype.equalsIgnoreCase("Hanger Available")){
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/Hanger/HangerAvailable/VisitHangerAvailable"), null)
			}
			else if(hangertype.equalsIgnoreCase("Hanger Not Available")){
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/Hanger/HangerNotAvailable/VisitHangerNotAvailable"), null)
			}
			else if(hangertype.equalsIgnoreCase("SKDNA")){
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/Hanger/SKDNA/VisitSKDNA"), null)
			}
		}
	}
	@Keyword
	def visitHangerWithOverwriteScenarios(){
		//todo
	}
	@Keyword
	def selectHangerRemark(String _remark){
		int hangerremarks = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<= hangerremarks; i++){
			MobileElement hangerremark = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			String hangerremarktext = hangerremark.getText()
			ProjectConstants.CURRENTVISITING_CATEGORYREMARK = hangerremarktext
			if(hangerremarktext.equalsIgnoreCase(_remark)){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				break
			}
		}
	}
	@Keyword
	def visitHangerProducts(int columnindex){
		ArrayList<ShopProductsData> visitedshopproductsdata = new ArrayList<ShopProductsData>()
		ArrayList<String> expectedproducts = new ArrayList<String>()
		ArrayList<String> displayedproducts = new ArrayList<String>()
		int index = 0
		XSSFSheet sheet = LoadDataKeywords.loadChannelProductsSheet()
		ArrayList<ProductWithValue> expectedhangerproducts = LoadDataKeywords.loadChannelWiseProductsList(sheet, columnindex)
		for(int i=0; i< expectedhangerproducts.size(); i++){
			expectedproducts.add(expectedhangerproducts.get(i).getProduct())
		}
		int totalproducts = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*").size()
		for(int i=1; i<= totalproducts; i=i+3){
			ShopProductsData shopproductdata = new ShopProductsData()
			boolean flag = false
			index = index + 1
			MobileElement product = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.TextView["+index+"]")
			String productname = product.getText()
			shopproductdata.setProduct(productname)
			for(int j=0; j< expectedhangerproducts.size(); j++){
				ProductWithValue expectedhotspotproduct = expectedhangerproducts.get(j)
				if(expectedhotspotproduct.getProduct().equalsIgnoreCase(productname)){
					flag = true
					MobileElement edittext = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.EditText[1]")
					edittext.setValue(expectedhotspotproduct.getProduct_value())
					if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
						shopproductdata.setHanger_availability(expectedhotspotproduct.getProduct_value())
					}
					else{
						shopproductdata.setOverwrite_hanger_availability(expectedhotspotproduct.getProduct_value())
					}
					Mobile.hideKeyboard()
					break
				}
				else{}
			}
			if(flag == false){
				MobileElement edittext = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.EditText[1]")
				edittext.setValue("0000")
				if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
					shopproductdata.setHanger_availability("0000")
				}
				else{
					shopproductdata.setOverwrite_hanger_availability("0000")
				}
				Mobile.hideKeyboard()
			}
			else{}
			visitedshopproductsdata.add(shopproductdata)
		}
		totalproducts = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*").size()
		if(totalproducts >= 16){
			while(true){
				ShopProductsData hangerproduct = new ShopProductsData()
				boolean flag = false
				int xlocation = ProjectConstants.getXPoint()
				MobileElement productbeforeswipe = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.TextView[5]")
				String productnamebeforeswipe = productbeforeswipe.getText()
				Mobile.swipe(xlocation, 359, xlocation, 250)
				MobileElement productafterswipe = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.TextView[5]")
				String productnameafterswipe = productafterswipe.getText()
				if(productnamebeforeswipe.equals(productnameafterswipe)){
					break
				}
				else{
					hangerproduct.setProduct(productnameafterswipe)
					for(int j=0; j< expectedhangerproducts.size(); j++){
						ProductWithValue expectedchannelproduct = expectedhangerproducts.get(j)
						if(expectedchannelproduct.getProduct().equalsIgnoreCase(productnameafterswipe)){
							flag = true
							MobileElement edittext = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[6]/android.widget.EditText[1]")
							edittext.setValue(expectedchannelproduct.getProduct_value())
							if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
								hangerproduct.setHanger_availability(expectedchannelproduct.getProduct_value())
							}
							else{
								hangerproduct.setOverwrite_hanger_availability(expectedchannelproduct.getProduct_value())
							}
							Mobile.hideKeyboard()
							break
						}
						else{}
					}
					if(flag == false){
						MobileElement edittext = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[6]/android.widget.EditText[1]")
						edittext.setValue("0000")
						if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
							hangerproduct.setHanger_availability("0000")
						}
						else{
							hangerproduct.setOverwrite_hanger_availability("0000")
						}
						Mobile.hideKeyboard()
					}
					else{}
				}
				visitedshopproductsdata.add(hangerproduct)
			}
		}
		else{}
		for(int i=0; i< visitedshopproductsdata.size(); i++){
			displayedproducts.add(visitedshopproductsdata.get(i).getProduct())
		}
		UnmatchedItems UnmatchedItems_status = CompareDataKeywords.compareLists(expectedproducts, displayedproducts)
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
		SubCategory subcategory = new SubCategory()
		VisitedCategoryData visitedcategory = new VisitedCategoryData()
		visitedcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
		subcategory.setSubcategory(ProjectConstants.CURRENTVISITING_SUBCATEGORY)
		if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
			subcategory.setFirstvisit_remark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
		}
		else{
			subcategory.setOverwrite_remark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
		}
		subcategory.setShopproductsdata(visitedshopproductsdata)
		visitedcategory.setSubcategories(subcategory)
		for(int i=0; i< ProjectConstants.visitedshopdatainfo.size(); i++){
			if(ProjectConstants.visitedshopdatainfo.get(i).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)){
				VisitedShopDataInfo visitedshopdata = ProjectConstants.visitedshopdatainfo.get(i)
				ArrayList<VisitedCategoryData> visitedcategoriesdata = visitedshopdata.getVisitedcategoriesdata()
				if(visitedcategoriesdata != null){
					boolean maincategory_flag = false
					for(int k=0; k<visitedcategoriesdata.size(); k++){
						VisitedCategoryData visitedcategorydata = visitedcategoriesdata.get(k)
						if(visitedcategorydata.getMaincategory().equals(visitedcategory.getMaincategory())){
							maincategory_flag = true
							ArrayList<SubCategory> subcategories = visitedcategorydata.getSubcategories()
							if(subcategories != null){
								boolean subcategory_flag = false
								for(int l=0; l< subcategories.size(); l++){
									SubCategory subcategorydata = subcategories.get(l)
									if(subcategorydata.getSubcategory().equals(subcategory.getSubcategory())){
										subcategory_flag = true
										ArrayList<ShopProductsData> existingshopproductsdata = subcategorydata.getShopproductsdata()
										for(int ex=0; ex< existingshopproductsdata.size(); ex++){
											ShopProductsData existingshopproductdata = existingshopproductsdata.get(ex)
											for(int ds=0; ds< visitedshopproductsdata.size(); ds++){
												ShopProductsData displayedshopproductdata = visitedshopproductsdata.get(ds)
												if(existingshopproductdata.getProduct().equals(displayedshopproductdata.getProduct())){
													if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
														subcategorydata.setFirstvisit_remark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
														existingshopproductdata.setHanger_availability(displayedshopproductdata.getHanger_availability())
													}
													else{
														subcategorydata.setOverwrite_remark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
														existingshopproductdata.setOverwrite_hanger_availability(displayedshopproductdata.getOverwrite_hanger_availability())
													}
												}
											}
										}
									}
								}
								if(subcategory_flag == false){
									visitedcategorydata.setSubcategories(subcategory)
									break
								}
							}
						}
					}
					if(maincategory_flag == false){
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
}
