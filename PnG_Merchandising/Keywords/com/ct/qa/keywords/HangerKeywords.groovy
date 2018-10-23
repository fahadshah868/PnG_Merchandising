package com.ct.qa.keywords

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.ct.qa.constants.ProjectConstants
import com.ct.qa.struct.MissingCategoryData
import com.ct.qa.struct.ProductWithValue
import com.ct.qa.struct.ShopProductsData
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

public class HangerKeywords {

	@Keyword
	def visitHangerList(String hangertype){
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
			else if(hangertype.equalsIgnoreCase("Overwrite Hanger Available")){
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/Hanger/HangerAvailable/OverwriteHangerAvailable"), null)
			}
			else if(hangertype.equalsIgnoreCase("Overwrite Hanger Not Available")){
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/Hanger/HangerNotAvailable/OverwriteHangerNotAvailable"), null)
			}
			else if(hangertype.equalsIgnoreCase("Overwrite SKDNA")){
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/Hanger/SKDNA/OverwriteSKDNA"), null)
			}
		}
	}
	@Keyword
	def selectHangerRemark(String _remark){
		int hangerremarks = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<= hangerremarks; i++){
			MobileElement hangerremark = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			String hangerremarktext = hangerremark.getText()
			if(hangerremarktext.equalsIgnoreCase(_remark)){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				break
			}
		}
	}
	@Keyword
	def visitHangerProducts(int columnindex, String assettype){
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
					if(assettype.equalsIgnoreCase("Hanger Available")){
						if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
							shopproductdata.setHangeravailable(expectedhotspotproduct.getProduct_value())
						}
						else{
							shopproductdata.setOverwrite_hangeravailable(expectedhotspotproduct.getProduct_value())
						}
					}
					else{
						if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
							shopproductdata.setHangernotavailable(expectedhotspotproduct.getProduct_value())
						}
						else{
							shopproductdata.setOverwrite_hangernotavailable(expectedhotspotproduct.getProduct_value())
						}
					}
					Mobile.hideKeyboard()
					break
				}
				else{}
			}
			if(flag == false){
				MobileElement edittext = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.EditText[1]")
				edittext.setValue("0000")
				if(assettype.equalsIgnoreCase("Hanger Available")){
					if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
						shopproductdata.setHangeravailable("0000")
					}
					else{
						shopproductdata.setOverwrite_hangeravailable("0000")
					}
				}
				else{
					if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
						shopproductdata.setHangernotavailable("0000")
					}
					else{
						shopproductdata.setOverwrite_hangernotavailable("0000")
					}
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
							if(assettype.equalsIgnoreCase("Hanger Available")){
								if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
									hangerproduct.setHangeravailable(expectedchannelproduct.getProduct_value())
								}
								else{
									hangerproduct.setOverwrite_hangeravailable(expectedchannelproduct.getProduct_value())
								}
							}
							else{
								if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
									hangerproduct.setHangernotavailable(expectedchannelproduct.getProduct_value())
								}
								else{
									hangerproduct.setOverwrite_hangernotavailable(expectedchannelproduct.getProduct_value())
								}
							}
							Mobile.hideKeyboard()
							break
						}
						else{}
					}
					if(flag == false){
						MobileElement edittext = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[6]/android.widget.EditText[1]")
						edittext.setValue("0000")
						if(assettype.equalsIgnoreCase("Hanger Available")){
							if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
								hangerproduct.setHangeravailable("0000")
							}
							else{
								hangerproduct.setOverwrite_hangeravailable("0000")
							}
						}
						else{
							if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
								hangerproduct.setHangernotavailable("0000")
							}
							else{
								hangerproduct.setOverwrite_hangernotavailable("0000")
							}
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
		VisitedCategoryData visitedcategory = new VisitedCategoryData()
		visitedcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
		visitedcategory.setSubcategory(ProjectConstants.CURRENTVISITING_SUBCATEGORY)
		visitedcategory.setShopproductsdata(visitedshopproductsdata)
		for(int i=0; i< ProjectConstants.visitedshopdatainfo.size(); i++){
			if(ProjectConstants.visitedshopdatainfo.get(i).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)){
				VisitedShopDataInfo visitedshopdata = ProjectConstants.visitedshopdatainfo.get(i)
				ArrayList<VisitedCategoryData> visitedcategoriesdata = visitedshopdata.getVisitedcategoriesdata()
				if(visitedcategoriesdata != null){
					boolean flag = false
					for(int k=0; k<visitedcategoriesdata.size(); k++){
						VisitedCategoryData visitedcategorydata = visitedcategoriesdata.get(k)
						if(visitedcategorydata.getMaincategory().equals(visitedcategory.getMaincategory()) && visitedcategorydata.getSubcategory().equalsIgnoreCase(visitedcategory.getSubcategory())){
							ArrayList<ShopProductsData> shopproductsdata = visitedcategorydata.getShopproductsdata()
							flag = true
							for(int n=0; n< shopproductsdata.size(); n++){
								ShopProductsData existingshopproductsdata = shopproductsdata.get(n)
								for(int b=0; b< visitedshopproductsdata.size(); b++){
									ShopProductsData displayedshopproductsdata = visitedshopproductsdata.get(b)
									if(existingshopproductsdata.getProduct().equalsIgnoreCase(displayedshopproductsdata.getProduct())){
										if(assettype.equalsIgnoreCase("Hanger Available")){
											if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
												existingshopproductsdata.setHangeravailable(displayedshopproductsdata.getHangeravailable())
											}
											else{
												existingshopproductsdata.setOverwrite_hangeravailable(displayedshopproductsdata.getOverwrite_hangeravailable())
											}
										}
										else{
											if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
												existingshopproductsdata.setHangernotavailable(displayedshopproductsdata.getHangernotavailable())
											}
											else{
												existingshopproductsdata.setOverwrite_hangernotavailable(displayedshopproductsdata.getOverwrite_hangernotavailable())
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
}
