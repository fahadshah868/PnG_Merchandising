package com.ct.qa.keywords

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.ct.qa.constants.ProjectConstants
import com.ct.qa.struct.HangerProduct
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
import io.appium.java_client.MobileElement
import org.apache.poi.xssf.usermodel.XSSFSheet

public class HangerKeywords {

	@Keyword
	def visitHangerList(String hangertype){
		int totalhangers = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<= totalhangers; i++){
			MobileElement hangercategory = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			ProjectConstants.CURRENTVISITING_PRODUCTCATEGORY = hangercategory.getText()
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
		ArrayList<HangerProduct> visitedhangerproducts = new ArrayList<HangerProduct>()
		int index = 0
		XSSFSheet sheet = LoadDataKeywords.loadChannelProductsSheet()
		ArrayList<ProductWithValue> expectedhangerproducts = LoadDataKeywords.loadChannelWiseProductsList(sheet, columnindex)
		int totalproducts = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*").size()
		for(int i=1; i<= totalproducts; i=i+3){
			HangerProduct hangerproduct = new HangerProduct()
			boolean flag = false
			index = index + 1
			MobileElement product = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.TextView["+index+"]")
			String productname = product.getText()
			hangerproduct.setProduct(productname)
			for(int j=0; j< expectedhangerproducts.size(); j++){
				ProductWithValue expectedhotspotproduct = expectedhangerproducts.get(j)
				if(expectedhotspotproduct.getProduct().equalsIgnoreCase(productname)){
					flag = true
					MobileElement edittext = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.EditText[1]")
					edittext.setValue(expectedhotspotproduct.getProduct_value())
					if(assettype.equalsIgnoreCase("Hanger Available")){
						if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
							hangerproduct.setHangeravailable(expectedhotspotproduct.getProduct_value())
						}
						else{
							hangerproduct.setOverwrite_hangeravailable(expectedhotspotproduct.getProduct_value())
						}
					}
					else{
						if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
							hangerproduct.setHangernotavailable(expectedhotspotproduct.getProduct_value())
						}
						else{
							hangerproduct.setOverwrite_hangernotavailable(expectedhotspotproduct.getProduct_value())
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
			visitedhangerproducts.add(hangerproduct)
		}
		totalproducts = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*").size()
		if(totalproducts >= 16){
			while(true){
				HangerProduct hangerproduct = new HangerProduct()
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
				visitedhangerproducts.add(hangerproduct)
			}
		}
		else{}
		if(expectedhangerproducts.size() == visitedhangerproducts.size()){
			ArrayList<String> products = new ArrayList<String>()
			for(int i=0; i<visitedhangerproducts.size(); i++){
				boolean match = false
				for(int j=0; j<expectedhangerproducts.size(); j++){
					if(visitedhangerproducts.get(i).getProduct().equalsIgnoreCase(expectedhangerproducts.get(j).getProduct())){
						match = true
						break
					}
					else{}
				}
				if(match == false){
					products.add(visitedhangerproducts.get(i).getProduct())
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
		else if(expectedhangerproducts.size() < visitedhangerproducts.size()){
			ArrayList<String> products = new ArrayList<String>()
			for(int i=0; i<visitedhangerproducts.size(); i++){
				boolean match = false
				for(int j=0; j<expectedhangerproducts.size(); j++){
					if(visitedhangerproducts.get(i).getProduct().equalsIgnoreCase(expectedhangerproducts.get(j).getProduct())){
						match = true
						break
					}
				}
				if(match == false){
					products.add(visitedhangerproducts.get(i).getProduct())
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
		else if(expectedhangerproducts.size() > visitedhangerproducts.size()){
			ArrayList<String> products = new ArrayList<String>()
			for(int i=0; i<expectedhangerproducts.size(); i++){
				boolean match = false
				for(int j=0; j<visitedhangerproducts.size(); j++){
					if(expectedhangerproducts.get(i).getProduct().equalsIgnoreCase(visitedhangerproducts.get(j).getProduct())){
						match = true
						break
					}
				}
				if(match == false){
					products.add(expectedhangerproducts.get(i).getProduct())
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
		visitedcategorydata.setHangerproducts(visitedhangerproducts)
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
								HangerProduct existingproductsdata = visitedcategorydatainfo.getHangerproducts().get(l)
								for(int m=0; m< visitedhangerproducts.size(); m++){
									ProductWithValue displayedhotspotproduct = visitedhangerproducts.get(m)
									if(existingproductsdata.getProduct().equals(displayedhotspotproduct.getProduct())){
										if(assettype.equalsIgnoreCase("Hanger Available")){
											if(ProjectConstants.SCENARIO.equals("first visit")){
												existingproductsdata.setHangeravailable(displayedhotspotproduct.getProduct_value())
											}
											else{
												existingproductsdata.setOverwrite_hangeravailable(displayedhotspotproduct.getProduct_value())
											}
										}
										else{
											if(ProjectConstants.SCENARIO.equals("first visit")){
												existingproductsdata.setHangernotavailable(displayedhotspotproduct.getProduct_value())
											}
											else{
												existingproductsdata.setOverwrite_hangernotavailable(displayedhotspotproduct.getProduct_value())
											}
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
}
