package com.ct.qa.keywords

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.util.ArrayList

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import com.ct.qa.struct.UnmatchedItems

import internal.GlobalVariable
import io.appium.java_client.MobileElement
import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI
import com.ct.qa.constants.ProjectConstants
import com.ct.qa.struct.VisitedShopDataInfo
import com.ct.qa.struct.MissingCategoryData
import com.ct.qa.struct.MissingCategoryRemarkData
import com.ct.qa.struct.MissingShopDataInfo
import com.ct.qa.struct.Question
import com.ct.qa.struct.SDUnit
import com.ct.qa.struct.ShopProductsData
import com.ct.qa.struct.SubCategory
import com.ct.qa.struct.VisitedCategoryData
import com.ct.qa.struct.VisitedCategoryRemarkData

public class ShopVisitingScenariosKeywords{
	def findShop(String _shopname){
		int index = 0
		int totalshops = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<=totalshops; i++){
			MobileElement shop = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			String shopname = shop.getText()
			if(shopname.equalsIgnoreCase(_shopname)){
				shop.click()
				MobileBuiltInKeywords.verifyElementText(findTestObject("Object Repository/Validate_ShopOptionsScreen", [('package') : ProjectConstants.PACKAGENAME]), "Options")
				MobileBuiltInKeywords.tap(findTestObject("Object Repository/StartWorking", [('package') : ProjectConstants.PACKAGENAME]), 0)
				CommonKeywords.visitPopUpForOverwriting()
				Mobile.delay(15)
				Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_MapScreen", [('package') : ProjectConstants.PACKAGENAME]), 60)
				MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/Location_CheckIn", [('package') : ProjectConstants.PACKAGENAME]), 0)
				Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_InfoPopUP", [('package') : ProjectConstants.PACKAGENAME]), 0)
				MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/InfoPopUp_NoButton", [('package') : ProjectConstants.PACKAGENAME]), 0)
				break
			}
			else{
			}
		}
	}

	def static missingShopActionsList(){
		UnmatchedItems unmatcheditems = CompareDataKeywords.compareShopActionsList()
		if(unmatcheditems.getStatus() == 2){
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingshopactions(unmatcheditems.getItems())
					ProjectConstants.missingshopdatainfo.get(j).setMissingshopactions_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_NOTMATCH)
					break
				}
				else{
				}
			}
		}
		else if(unmatcheditems.getStatus() == 1){
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingshopactions(unmatcheditems.getItems())
					ProjectConstants.missingshopdatainfo.get(j).setMissingshopactions_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MORE)
					break
				}
				else{
				}
			}
		}
		else if(unmatcheditems.getStatus() == -1){
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingshopactions(unmatcheditems.getItems())
					ProjectConstants.missingshopdatainfo.get(j).setMissingshopactions_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MISSING)
					break
				}
				else{
				}
			}
		}
		else{
		}
	}
	def static missingShopRemarksList(){
		UnmatchedItems unmatcheditems = CompareDataKeywords.compareShopRemarksList()
		if(unmatcheditems.getStatus() == 2){
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingshopremarks(unmatcheditems.getItems())
					ProjectConstants.missingshopdatainfo.get(j).setMissingshopremarks_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_NOTMATCH)
					break
				}
				else{
				}
			}
		}
		else if(unmatcheditems.getStatus() == 1){
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingshopremarks(unmatcheditems.getItems())
					ProjectConstants.missingshopdatainfo.get(j).setMissingshopremarks_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MORE)
					break
				}
				else{
				}
			}
		}
		else if(unmatcheditems.getStatus() == -1){
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingshopremarks(unmatcheditems.getItems())
					ProjectConstants.missingshopdatainfo.get(j).setMissingshopremarks_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MISSING)
					break
				}
				else{
				}
			}
		}
		else{
		}
	}
	@Keyword
	def static visitSliderShops(String remark){
		int index = 0
		int totalshops = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<= 1; i++){
			MissingShopDataInfo missingshopdatainfo = new MissingShopDataInfo()
			VisitedShopDataInfo visitedshopdatainfo = new VisitedShopDataInfo()
			MobileElement shop = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")
			ProjectConstants.CURRENTVISITING_SHOPNAME = shop.getText()
			missingshopdatainfo.setShopname(shop.getText())
			visitedshopdatainfo.setShopname(shop.getText())
			missingshopdatainfo.setRemark(remark)
			visitedshopdatainfo.setRemark(remark)
			ProjectConstants.missingshopdatainfo.add(missingshopdatainfo)
			ProjectConstants.visitedshopdatainfo.add(visitedshopdatainfo)
			ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
			MobileBuiltInKeywords.verifyElementText(findTestObject("Object Repository/Validate_ShopOptionsScreen" , [('package') : ProjectConstants.PACKAGENAME]), "Options")
			//validate missing shop actions list e.g. start working / get routes etc...
			missingShopActionsList()
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/StartWorking" , [('package') : ProjectConstants.PACKAGENAME]), 0)
			Mobile.delay(15)
			Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_MapScreen" , [('package') : ProjectConstants.PACKAGENAME]), 60)
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/Location_CheckIn" , [('package') : ProjectConstants.PACKAGENAME]), 0)
			Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_InfoPopUP" , [('package') : ProjectConstants.PACKAGENAME]), 0)
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/InfoPopUp_NoButton" , [('package') : ProjectConstants.PACKAGENAME]), 0)
			//validate missing shop remarks list e.g. shop open, closed etc...
			missingShopRemarksList()
			Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopOpen"), null)
			ProjectConstants.SCENARIO = "first visit"
			Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitCategoryScenarios/VisitShopCategoriesWithDataVerification"), null)
			Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SaveShop"), null)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
					ProjectConstants.missingshopdatainfo.get(j).setScenario("Data Verification")
					break
				}
			}
			for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
				if(ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
					ProjectConstants.visitedshopdatainfo.get(j).setShop_scenario("Shop Open")
					String message = "(1) 'RTM visit frequency' with 'Once a week'\n"+
							String.format("%-44s%-100s","","'Pop Application' with 'No' remark")+"\n"+
							String.format("%-44s%-100s","","'Retailer Remarks' with 'OB not visiting' remark")+"\n"+
							String.format("%-44s%-100s","","'Hanger Availability' with 'Yes' remark")+"\n"+
							String.format("%-40s%-100s","","(2) 'RTM visit frequency' with 'Twice a week'")+"\n"+
							String.format("%-44s%-100s","","'Pop Application' with 'No' remark")+"\n"+
							String.format("%-44s%-100s","","'Retailer Remarks' with 'SM not visiting' remark")+"\n"+
							String.format("%-44s%-100s","","'Hanger Availability' with 'No' remark")
					ProjectConstants.visitedshopdatainfo.get(j).setOthercategories_scenarios(message)
					break
				}
			}
			Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen" , [('package') : ProjectConstants.PACKAGENAME]), 0)
		}
	}
	@Keyword
	def visitShopWithDataVerification(){
		int index = 0
		int totalshops = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<=3; i++){
			if(i == totalshops){
				Mobile.swipe(0, 250, 0, 200)
			}
			MissingShopDataInfo missingshopdatainfo = new MissingShopDataInfo()
			VisitedShopDataInfo visitedshopdatainfo = new VisitedShopDataInfo()
			MobileElement shop = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			ProjectConstants.CURRENTVISITING_SHOPNAME = shop.getText()
			missingshopdatainfo.setShopname(shop.getText())
			visitedshopdatainfo.setShopname(shop.getText())
			missingshopdatainfo.setRemark("Normal Shops")
			visitedshopdatainfo.setRemark("Normal Shops")
			ProjectConstants.missingshopdatainfo.add(missingshopdatainfo)
			ProjectConstants.visitedshopdatainfo.add(visitedshopdatainfo)
			ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
			MobileBuiltInKeywords.verifyElementText(findTestObject("Object Repository/Validate_ShopOptionsScreen", [('package') : ProjectConstants.PACKAGENAME]), "Options")
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/StartWorking", [('package') : ProjectConstants.PACKAGENAME]), 0)
			Mobile.delay(15)
			Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_MapScreen", [('package') : ProjectConstants.PACKAGENAME]), 60)
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/Location_CheckIn", [('package') : ProjectConstants.PACKAGENAME]), 0)
			Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_InfoPopUP", [('package') : ProjectConstants.PACKAGENAME]), 0)
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/InfoPopUp_NoButton", [('package') : ProjectConstants.PACKAGENAME]), 0)
			//validate missing shop remarks list e.g. shop open, closed etc...
			missingShopRemarksList()
			Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopOpen"), null)
			ProjectConstants.SCENARIO = "first visit"
			Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenarios/VisitShopCategoriesWithDataVerification"), null)
			Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SaveShop"), null)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
					ProjectConstants.missingshopdatainfo.get(j).setScenario("Data Verification")
					break
				}
			}
			for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
				if(ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
					ProjectConstants.visitedshopdatainfo.get(j).setShop_scenario("Shop Open")
					String message = "'Retailer Remarks' with 'SM not visiting' remark"
					ProjectConstants.visitedshopdatainfo.get(j).setOthercategories_scenarios(message)
					break
				}
			}
			Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
		}
		//				while(true){
		//					MissingShopDataInfo missingshopdatainfo = new MissingShopDataInfo()
		//					VisitedShopDataInfo visitedshopdatainfo = new VisitedShopDataInfo()
		//					index = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		//					MobileElement lastitembeforeswipe  = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]/android.widget.TextView[1]")
		//					String lastitemnamebeforeswipe = lastitembeforeswipe.getText()
		//					Mobile.swipe(0, 292, 0, 200)
		//					index = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		//					MobileElement lastitemafterswipe  = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]/android.widget.TextView[1]")
		//					String lastitemnameafterswipe = lastitemafterswipe.getText()
		//					if(lastitemnamebeforeswipe.equalsIgnoreCase(lastitemnameafterswipe)){
		//						break
		//					}
		//					else{
		//						ProjectConstants.CURRENTVISITING_SHOPNAME = lastitemnameafterswipe
		//						missingshopdatainfo.setShopname(lastitemnameafterswipe)
		//						visitedshopdatainfo.setShopname(lastitemnameafterswipe)
//								missingshopdatainfo.setRemark("Normal Shops")
//								visitedshopdatainfo.setRemark("Normal Shops")
		//						ProjectConstants.missingshopdatainfo.add(missingshopdatainfo)
		//						ProjectConstants.visitedshopdatainfo.add(visitedshopdatainfo)
		//						lastitemafterswipe.click()
		//						MobileBuiltInKeywords.verifyElementText(findTestObject("Object Repository/Validate_ShopOptionsScreen", [('package') : ProjectConstants.PACKAGENAME]), "Options")
		//						MobileBuiltInKeywords.tap(findTestObject("Object Repository/StartWorking", [('package') : ProjectConstants.PACKAGENAME]), 0)
		//						Mobile.delay(15)
		//						Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_MapScreen", [('package') : ProjectConstants.PACKAGENAME]), 60)
		//						MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/Location_CheckIn", [('package') : ProjectConstants.PACKAGENAME]), 0)
		//						Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_InfoPopUP", [('package') : ProjectConstants.PACKAGENAME]), 0)
		//						MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/InfoPopUp_NoButton", [('package') : ProjectConstants.PACKAGENAME]), 0)
		//						//validate missing shop remarks list e.g. shop open, closed etc...
		//								missingShopRemarksList()
		//								Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopOpen"), null)
		//						ProjectConstants.SCENARIO = "first visit"
		//						Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenarios/VisitShopCategoriesWithDataVerification"), null)
		//						Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SaveShop"), null)
		//						for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
		//							if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
		//								ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
		//								ProjectConstants.missingshopdatainfo.get(j).setScenario("Data Verification")
		//								break
		//							}
		//						}
		//						for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
		//							if(ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
		//								ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
		//								ProjectConstants.visitedshopdatainfo.get(j).setShop_scenario("Shop Open")
		//								String message = "'Retailer Remarks' with 'SM not visiting' remark"
		//								ProjectConstants.visitedshopdatainfo.get(j).setOthercategories_scenarios(message)
		//								break
		//							}
		//						}
		//						Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
		//					}
		//				}
		DisplayReport.displayDataInReport()
	}

	/************************************************************
	 SHOP LEVEL OVERWRITE SCENARIOS
	 ***********************************************************/
	@Keyword
	def visitShopsWithShopLevel_OverwritingScenario(){
		int index = 0
		int totalshops = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<=6; i++){
			if(i == totalshops){
				Mobile.swipe(0, 250, 0, 200)
			}
			MissingShopDataInfo missingshopdatainfo = new MissingShopDataInfo()
			VisitedShopDataInfo visitedshopdatainfo = new VisitedShopDataInfo()
			MobileElement shop = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			ProjectConstants.CURRENTVISITING_SHOPNAME = shop.getText()
			missingshopdatainfo.setShopname(shop.getText())
			visitedshopdatainfo.setShopname(shop.getText())
			missingshopdatainfo.setRemark("Normal Shops")
			visitedshopdatainfo.setRemark("Normal Shops")
			ProjectConstants.missingshopdatainfo.add(missingshopdatainfo)
			ProjectConstants.visitedshopdatainfo.add(visitedshopdatainfo)
			ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
			MobileBuiltInKeywords.verifyElementText(findTestObject("Object Repository/Validate_ShopOptionsScreen", [('package') : ProjectConstants.PACKAGENAME]), "Options")
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/StartWorking", [('package') : ProjectConstants.PACKAGENAME]), 0)
			Mobile.delay(15)
			Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_MapScreen", [('package') : ProjectConstants.PACKAGENAME]), 60)
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/Location_CheckIn", [('package') : ProjectConstants.PACKAGENAME]), 0)
			Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_InfoPopUP", [('package') : ProjectConstants.PACKAGENAME]), 0)
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/InfoPopUp_NoButton", [('package') : ProjectConstants.PACKAGENAME]), 0)
			// shop closed to shop open
			if(i == 1){
				//validate missing shop remarks list e.g. shop open, closed etc...
				missingShopRemarksList()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopOpen"), null)
				ProjectConstants.SCENARIO = "overwrite"
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenarios/VisitShopCategoriesWithDataVerification"), null)
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SaveShop"), null)
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
					if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.missingshopdatainfo.get(j).setScenario("Overwrite's Scenario Before Overwrite The Shop")
						break
					}
				}
				for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
					if(ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.visitedshopdatainfo.get(j).setShop_scenario("Shop Closed ==> Shop Open")
						String message = "'Retailer Remarks' with 'SM not visiting' remark"+"\n"+
								String.format("%-30s%-100s", "","(2) 'HotSpot Available' for HotSpot With Different Values")
						ProjectConstants.visitedshopdatainfo.get(j).setOthercategories_scenarios(message)
						break
					}
				}
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			}
			//shop open to shop closed
			else if(i == 2){
				Mobile.callTestCase(findTestCase("Test Cases/ShopClosed/VisitShopClosed"), null)
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
					if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.missingshopdatainfo.get(j).setScenario("Overwrite's Scenario Before Overwrite The Shop")
						break
					}
				}
				for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
					if(ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.visitedshopdatainfo.get(j).setShop_scenario("Shop Open ==> Shop Closed")
						String message = "'Retailer Remarks' with 'SM not visiting' remark"+"\n"+
								String.format("%-30s%-100s", "","(2) 'HotSpot Available' for HotSpot With Different Values")
						ProjectConstants.visitedshopdatainfo.get(j).setOthercategories_scenarios(message)
						break
					}
				}
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			}
			//SKDNA to SKDNA
			else if(i == 3){
				Mobile.callTestCase(findTestCase("Test Cases/ShopKeeperDidNotAllow/OverwriteShopKeeperDidNotAllow"), null)
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
					if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.missingshopdatainfo.get(j).setScenario("Overwrite's Scenario Before Overwrite The Shop")
						break
					}
				}
				for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
					if(ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.visitedshopdatainfo.get(j).setShop_scenario("SKDNA with 'Expiry Issue' remark  ==>  SKDNA with 'Others' remark")
						String message = "'Retailer Remarks' with 'SM not visiting' remark"+"\n"+
								String.format("%-30s%-100s", "","(2) 'HotSpot Available' for HotSpot With Different Values")
						ProjectConstants.visitedshopdatainfo.get(j).setOthercategories_scenarios(message)
						break
					}
				}
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			}
			//shop permanently closed to shop not found
			else if(i == 4){
				Mobile.callTestCase(findTestCase("Test Cases/ShopNotFound/VisitShopNotFound"), null)
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
					if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.missingshopdatainfo.get(j).setScenario("Overwrite's Scenario Before Overwrite The Shop")
						break
					}
				}
				for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
					if(ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.visitedshopdatainfo.get(j).setShop_scenario("Shop Permanently Closed ==> Shop Not Found")
						String message = "'Retailer Remarks' with 'SM not visiting' remark"+"\n"+
								String.format("%-30s%-100s", "","(2) 'HotSpot Available' for HotSpot With Different Values")
						ProjectConstants.visitedshopdatainfo.get(j).setOthercategories_scenarios(message)
						break
					}
				}
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			}
			//shop closed to shop permanently closed
			else if(i == 5){
				Mobile.callTestCase(findTestCase("Test Cases/ShopPermanentlyClosed/VisitShopPermanentlyClosed"), null)
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
					if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.missingshopdatainfo.get(j).setScenario("Overwrite's Scenario Before Overwrite The Shop")
						break
					}
				}
				for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
					if(ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.visitedshopdatainfo.get(j).setShop_scenario("Shop Closed ==> Shop Permanently Closed")
						String message = "'Retailer Remarks' with 'SM not visiting' remark"+"\n"+
								String.format("%-30s%-100s", "","(2) 'HotSpot Available' for HotSpot With Different Values")
						ProjectConstants.visitedshopdatainfo.get(j).setOthercategories_scenarios(message)
						break
					}
				}
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			}
			//shop open to shop open
			else if(i == 6){
				//validate missing shop remarks list e.g. shop open, closed etc...
				missingShopRemarksList()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopOpen"), null)
				ProjectConstants.SCENARIO = "overwrite"
				ProjectConstants.SHOP_ATTEMPT = 1
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenarios/VisitShopCategoriesWithOverwritingScenarios"), null)
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SaveShop"), null)
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
					if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.missingshopdatainfo.get(j).setScenario("Overwrite's Scenario Before Overwrite The Shop")
						break
					}
				}
				for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
					if(ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.visitedshopdatainfo.get(j).setShop_scenario("Shop Open ==> Shop Open")
						String message = "'Retailer Remarks' with 'SM not visiting' remark"+"\n"+
								String.format("%-30s%-100s", "","(2) 'HotSpot Available' for HotSpot With Different Values")
						ProjectConstants.visitedshopdatainfo.get(j).setOthercategories_scenarios(message)
						break
					}
				}
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			}
			else{
				break
			}
		}
		DisplayReport.displayDataInReport()
	}
	@Keyword
	def visitShopsWithShopLevel_OverwriteScenarios(){
		int index = 0
		int totalshops = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<=6; i++){
			if(i == totalshops){
				Mobile.swipe(0, 250, 0, 200)
			}
			MissingShopDataInfo missingshopdatainfo = new MissingShopDataInfo()
			VisitedShopDataInfo visitedshopdatainfo = new VisitedShopDataInfo()
			MobileElement shop = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			ProjectConstants.CURRENTVISITING_SHOPNAME = shop.getText()
			missingshopdatainfo.setShopname(shop.getText())
			visitedshopdatainfo.setShopname(shop.getText())
			missingshopdatainfo.setRemark("Normal Shops")
			visitedshopdatainfo.setRemark("Normal Shops")
			ProjectConstants.missingshopdatainfo.add(missingshopdatainfo)
			ProjectConstants.visitedshopdatainfo.add(visitedshopdatainfo)
			ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
			MobileBuiltInKeywords.verifyElementText(findTestObject("Object Repository/Validate_ShopOptionsScreen", [('package') : ProjectConstants.PACKAGENAME]), "Options")
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/StartWorking", [('package') : ProjectConstants.PACKAGENAME]), 0)
			Mobile.delay(15)
			Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_MapScreen", [('package') : ProjectConstants.PACKAGENAME]), 60)
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/Location_CheckIn", [('package') : ProjectConstants.PACKAGENAME]), 0)
			Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_InfoPopUP", [('package') : ProjectConstants.PACKAGENAME]), 0)
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/InfoPopUp_NoButton", [('package') : ProjectConstants.PACKAGENAME]), 0)
			// shop closed to shop open
			if(i == 1){
				Mobile.callTestCase(findTestCase("Test Cases/ShopClosed/VisitShopClosed"), null)
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				findShop(ProjectConstants.CURRENTVISITING_SHOPNAME)
				//validate missing shop remarks list e.g. shop open, closed etc...
				missingShopRemarksList()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopOpen"), null)
				ProjectConstants.SCENARIO = "overwrite"
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenarios/VisitShopCategoriesWithDataVerification"), null)
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SaveShop"), null)
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
					if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.missingshopdatainfo.get(j).setScenario("Shop Level Overwriting")
						break
					}
				}
				for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
					if(ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.visitedshopdatainfo.get(j).setShop_scenario("Shop Closed ==> Shop Open")
						String message = "'Retailer Remarks' with 'SM not visiting' remark"+"\n"+
								String.format("%-30s%-100s", "","(2) 'HotSpot Available' for HotSpot With Different Values")
						ProjectConstants.visitedshopdatainfo.get(j).setOthercategories_scenarios(message)
						break
					}
				}
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			}
			//shop open to shop closed
			else if(i == 2){
				//validate missing shop remarks list e.g. shop open, closed etc...
				missingShopRemarksList()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopOpen"), null)
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenarios/VisitShopCategoriesWithDataVerification"), null)
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SaveShop"), null)
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				findShop(ProjectConstants.CURRENTVISITING_SHOPNAME)
				Mobile.callTestCase(findTestCase("Test Cases/ShopClosed/VisitShopClosed"), null)
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
					if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.missingshopdatainfo.get(j).setScenario("Shop Level Overwriting")
						break
					}
				}
				for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
					if(ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.visitedshopdatainfo.get(j).setShop_scenario("Shop Open ==> Shop Closed")
						String message = "'Retailer Remarks' with 'SM not visiting' remark"+"\n"+
								String.format("%-30s%-100s", "","(2) 'HotSpot Available' for HotSpot With Different Values")
						ProjectConstants.visitedshopdatainfo.get(j).setOthercategories_scenarios(message)
						break
					}
				}
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			}
			//SKDNA to SKDNA
			else if(i == 3){
				Mobile.callTestCase(findTestCase("Test Cases/ShopKeeperDidNotAllow/VisitShopKeeperDidNotAllow"), null)
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				findShop(ProjectConstants.CURRENTVISITING_SHOPNAME)
				Mobile.callTestCase(findTestCase("Test Cases/ShopKeeperDidNotAllow/OverwriteShopKeeperDidNotAllow"), null)
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
					if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.missingshopdatainfo.get(j).setScenario("Shop Level Overwriting")
						break
					}
				}
				for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
					if(ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.visitedshopdatainfo.get(j).setShop_scenario("SKDNA with 'Expiry Issue' remark  ==>  SKDNA with 'Others' remark")
						String message = "'Retailer Remarks' with 'SM not visiting' remark"+"\n"+
								String.format("%-30s%-100s", "","(2) 'HotSpot Available' for HotSpot With Different Values")
						ProjectConstants.visitedshopdatainfo.get(j).setOthercategories_scenarios(message)
						break
					}
				}
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			}
			//shop permanently closed to shop not found
			else if(i == 4){
				Mobile.callTestCase(findTestCase("Test Cases/ShopPermanentlyClosed/VisitShopPermanentlyClosed"), null)
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				findShop(ProjectConstants.CURRENTVISITING_SHOPNAME)
				Mobile.callTestCase(findTestCase("Test Cases/ShopNotFound/VisitShopNotFound"), null)
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
					if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.missingshopdatainfo.get(j).setScenario("Shop Level Overwriting")
						break
					}
				}
				for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
					if(ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.visitedshopdatainfo.get(j).setShop_scenario("Shop Permanently Closed ==> Shop Not Found")
						String message = "'Retailer Remarks' with 'SM not visiting' remark"+"\n"+
								String.format("%-30s%-100s", "","(2) 'HotSpot Available' for HotSpot With Different Values")
						ProjectConstants.visitedshopdatainfo.get(j).setOthercategories_scenarios(message)
						break
					}
				}
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			}
			//shop closed to shop permanently closed
			else if(i == 5){
				Mobile.callTestCase(findTestCase("Test Cases/ShopClosed/VisitShopClosed"), null)
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				findShop(ProjectConstants.CURRENTVISITING_SHOPNAME)
				Mobile.callTestCase(findTestCase("Test Cases/ShopPermanentlyClosed/VisitShopPermanentlyClosed"), null)
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
					if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.missingshopdatainfo.get(j).setScenario("Shop Level Overwriting")
						break
					}
				}
				for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
					if(ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.visitedshopdatainfo.get(j).setShop_scenario("Shop Closed ==> Shop Permanently Closed")
						String message = "'Retailer Remarks' with 'SM not visiting' remark"+"\n"+
								String.format("%-30s%-100s", "","(2) 'HotSpot Available' for HotSpot With Different Values")
						ProjectConstants.visitedshopdatainfo.get(j).setOthercategories_scenarios(message)
						break
					}
				}
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			}
			//shop open to shop open
			else if(i == 6){
				//validate missing shop remarks list e.g. shop open, closed etc...
				missingShopRemarksList()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopOpen"), null)
				ProjectConstants.SHOP_ATTEMPT = 1
				ProjectConstants.SCENARIO = "first visit"
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenarios/VisitShopCategoriesWithOverwriteScenarios"), null)
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SaveShop"), null)
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				findShop(ProjectConstants.CURRENTVISITING_SHOPNAME)
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopOpen"), null)
				ProjectConstants.SCENARIO = "overwrite"
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenariosWithOverwritePopup/VisitShopCategoriesWithOverwritingScenarios"), null)
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SaveShop"), null)
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
					if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.missingshopdatainfo.get(j).setScenario("Shop Level Overwriting")
						break
					}
				}
				for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
					if(ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.visitedshopdatainfo.get(j).setShop_scenario("Shop Open ==> Shop Open")
						String message = "'Retailer Remarks' with 'SM not visiting' remark"+"\n"+
								String.format("%-30s%-100s", "","(2) 'HotSpot Available' for HotSpot With Different Values")
						ProjectConstants.visitedshopdatainfo.get(j).setOthercategories_scenarios(message)
						break
					}
				}
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			}
			else{
				break
			}
		}
		DisplayReport.displayDataInReport()
	}

	/*************************************************
	 CATEGORY LEVEL OVERWRITE SCENARIOS
	 ************************************************/

	@Keyword
	def visitShopsWith_CategoryLevel_OverwritingScenarios(){
		int index = 0
		int _shop = 1
		int totalshops = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		for(_shop; _shop<= 1; _shop++){
			if(_shop == totalshops){
				Mobile.swipe(0, 250, 0, 200)
			}
			MissingShopDataInfo missingshopdatainfo = new MissingShopDataInfo()
			VisitedShopDataInfo visitedshopdatainfo = new VisitedShopDataInfo()
			MobileElement shop = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			ProjectConstants.CURRENTVISITING_SHOPNAME = shop.getText()
			missingshopdatainfo.setShopname(shop.getText())
			visitedshopdatainfo.setShopname(shop.getText())
			missingshopdatainfo.setRemark("Normal Shops")
			visitedshopdatainfo.setRemark("Normal Shops")
			ProjectConstants.missingshopdatainfo.add(missingshopdatainfo)
			ProjectConstants.visitedshopdatainfo.add(visitedshopdatainfo)
			ProjectConstants.SHOP_ATTEMPT = _shop;
			ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
			MobileBuiltInKeywords.verifyElementText(findTestObject("Object Repository/Validate_ShopOptionsScreen" , [('package') : ProjectConstants.PACKAGENAME]), "Options")
			//validate missing shop actions list e.g. start working / get routes etc...
			missingShopActionsList()
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/StartWorking" , [('package') : ProjectConstants.PACKAGENAME]), 0)
			Mobile.delay(15)
			Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_MapScreen" , [('package') : ProjectConstants.PACKAGENAME]), 60)
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/Location_CheckIn" , [('package') : ProjectConstants.PACKAGENAME]), 0)
			Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_InfoPopUP" , [('package') : ProjectConstants.PACKAGENAME]), 0)
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/InfoPopUp_NoButton" , [('package') : ProjectConstants.PACKAGENAME]), 0)
			//validate missing shop remarks list e.g. shop open, closed etc...
			missingShopRemarksList()
			Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopOpen"), null)
			ProjectConstants.SCENARIO = "Overwrite"
			Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenarios/VisitShopCategoriesWithOverwritingScenarios"), null)
			Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SaveShop"), null)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
					ProjectConstants.missingshopdatainfo.get(j).setScenario("Data Verification")
					break
				}
			}
			for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
				if(ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
					ProjectConstants.visitedshopdatainfo.get(j).setShop_scenario("Shop Open")
					String message = "'Retailer Remarks' with 'SM not visiting' remark"+"\n"+
							String.format("%-30s%-100s", "","(2) 'HotSpot Available' for HotSpot With Different Values")
					ProjectConstants.visitedshopdatainfo.get(j).setOthercategories_scenarios(message)
					break
				}
			}
			Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen" , [('package') : ProjectConstants.PACKAGENAME]), 0)
		}
		//				while(true){
		//					MissingShopDataInfo missingshopdatainfo = new MissingShopDataInfo()
		//					VisitedShopDataInfo visitedshopdatainfo = new VisitedShopDataInfo()
		//					index = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		//					MobileElement lastitembeforeswipe  = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]/android.widget.TextView[1]")
		//					String lastitemnamebeforeswipe = lastitembeforeswipe.getText()
		//					Mobile.swipe(0, 292, 0, 200)
		//					index = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		//					MobileElement lastitemafterswipe  = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]/android.widget.TextView[1]")
		//					String lastitemnameafterswipe = lastitemafterswipe.getText()
		//					if(lastitemnamebeforeswipe.equalsIgnoreCase(lastitemnameafterswipe)){
		//						break
		//					}
		//					else{
		//						_shop = _shop + 1
		//						ProjectConstants.CURRENTVISITING_SHOPNAME = lastitemnameafterswipe
		//						missingshopdatainfo.setShopname(lastitemnameafterswipe)
		//						visitedshopdatainfo.setShopname(lastitemnameafterswipe)
//								missingshopdatainfo.setRemark("Normal Shops")
//								visitedshopdatainfo.setRemark("Normal Shops")
		//						ProjectConstants.missingshopdatainfo.add(missingshopdatainfo)
		//						ProjectConstants.visitedshopdatainfo.add(visitedshopdatainfo)
		//						ProjectConstants.SHOP_ATTEMPT = _shop
		//						lastitemafterswipe.click()
		//						MobileBuiltInKeywords.verifyElementText(findTestObject("Object Repository/Validate_ShopOptionsScreen" , [('package') : ProjectConstants.PACKAGENAME]), "Options")
		//						//validate missing shop actions list e.g. start working / get routes etc...
		//						missingShopActionsList()
		//						MobileBuiltInKeywords.tap(findTestObject("Object Repository/StartWorking" , [('package') : ProjectConstants.PACKAGENAME]), 0)
		//						Mobile.delay(15)
		//						Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_MapScreen" , [('package') : ProjectConstants.PACKAGENAME]), 60)
		//						MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/Location_CheckIn" , [('package') : ProjectConstants.PACKAGENAME]), 0)
		//						Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_InfoPopUP" , [('package') : ProjectConstants.PACKAGENAME]), 0)
		//						MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/InfoPopUp_NoButton" , [('package') : ProjectConstants.PACKAGENAME]), 0)
		//						//validate missing shop remarks list e.g. shop open, closed etc...
		//								missingShopRemarksList()
		//								Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopOpen"), null)
		//						ProjectConstants.SCENARIO = "Overwrite"
		//						Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenarios/VisitShopCategoriesWithOverwritingScenarios"), null)
		//						Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SaveShop"), null)
		//						for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
		//							if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
		//								ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
		//								ProjectConstants.missingshopdatainfo.get(j).setScenario("Data Verification")
		//								break
		//							}
		//						}
		//						for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
		//							if(ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
		//								ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
		//								ProjectConstants.visitedshopdatainfo.get(j).setShop_scenario("Shop Open ==> Shop Open")
		//								String message = "'Retailer Remarks' with 'SM not visiting' remark"+"\n"+
		//								String.format("%-30s%-100s", "","(2) 'HotSpot Available' for HotSpot With Different Values")
		//								ProjectConstants.visitedshopdatainfo.get(j).setOthercategories_scenarios(message)
		//								break
		//							}
		//						}
		//						Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen" , [('package') : ProjectConstants.PACKAGENAME]), 0)
		//					}
		//				}
		DisplayReport.displayDataInReport()
	}
	@Keyword
	def visitShopsWith_CategoryLevel_OverwriteScenarios(){
		int index = 0
		int _shop = 1
		int totalshops = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		for(_shop; _shop<= 1; _shop++){
			if(_shop == totalshops){
				Mobile.swipe(0, 250, 0, 200)
			}
			MissingShopDataInfo missingshopdatainfo = new MissingShopDataInfo()
			VisitedShopDataInfo visitedshopdatainfo = new VisitedShopDataInfo()
			MobileElement shop = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			ProjectConstants.CURRENTVISITING_SHOPNAME = shop.getText()
			missingshopdatainfo.setShopname(shop.getText())
			visitedshopdatainfo.setShopname(shop.getText())
			missingshopdatainfo.setRemark("Normal Shops")
			visitedshopdatainfo.setRemark("Normal Shops")
			ProjectConstants.missingshopdatainfo.add(missingshopdatainfo)
			ProjectConstants.visitedshopdatainfo.add(visitedshopdatainfo)
			ProjectConstants.SHOP_ATTEMPT = _shop;
			ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
			MobileBuiltInKeywords.verifyElementText(findTestObject("Object Repository/Validate_ShopOptionsScreen" , [('package') : ProjectConstants.PACKAGENAME]), "Options")
			//validate missing shop actions list e.g. start working / get routes etc...
			missingShopActionsList()
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/StartWorking" , [('package') : ProjectConstants.PACKAGENAME]), 0)
			Mobile.delay(15)
			Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_MapScreen" , [('package') : ProjectConstants.PACKAGENAME]), 60)
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/Location_CheckIn" , [('package') : ProjectConstants.PACKAGENAME]), 0)
			Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_InfoPopUP" , [('package') : ProjectConstants.PACKAGENAME]), 0)
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/InfoPopUp_NoButton" , [('package') : ProjectConstants.PACKAGENAME]), 0)
			//validate missing shop remarks list e.g. shop open, closed etc...
			missingShopRemarksList()
			Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopOpen"), null)
			ProjectConstants.SCENARIO = "first visit"
			Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenarios/VisitShopCategoriesWithOverwriteScenarios"), null)
			ProjectConstants.SCENARIO = "Overwrite"
			Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenariosWithOverwritePopup/VisitShopCategoriesWithOverwritingScenarios"), null)
			Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SaveShop"), null)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
					ProjectConstants.missingshopdatainfo.get(j).setScenario("Data Verification")
					break
				}
			}
			for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
				if(ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
					ProjectConstants.visitedshopdatainfo.get(j).setShop_scenario("Shop Open ==> Shop Open")
					String message = "'Retailer Remarks' with 'SM not visiting' remark"+"\n"+
							String.format("%-30s%-100s", "","(2) 'HotSpot Available' for HotSpot With Different Values")
					ProjectConstants.visitedshopdatainfo.get(j).setOthercategories_scenarios(message)
					break
				}
			}
			Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen" , [('package') : ProjectConstants.PACKAGENAME]), 0)
		}
		//				while(true){
		//					MissingShopDataInfo missingshopdatainfo = new MissingShopDataInfo()
		//					VisitedShopDataInfo visitedshopdatainfo = new VisitedShopDataInfo()
		//					index = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		//					MobileElement lastitembeforeswipe  = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]/android.widget.TextView[1]")
		//					String lastitemnamebeforeswipe = lastitembeforeswipe.getText()
		//					Mobile.swipe(0, 292, 0, 200)
		//					index = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		//					MobileElement lastitemafterswipe  = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]/android.widget.TextView[1]")
		//					String lastitemnameafterswipe = lastitemafterswipe.getText()
		//					if(lastitemnamebeforeswipe.equalsIgnoreCase(lastitemnameafterswipe)){
		//						break
		//					}
		//					else{
		//						_shop = _shop + 1
		//						ProjectConstants.CURRENTVISITING_SHOPNAME = lastitemnameafterswipe
		//						missingshopdatainfo.setShopname(lastitemnameafterswipe)
		//						visitedshopdatainfo.setShopname(lastitemnameafterswipe)
//								missingshopdatainfo.setRemark("Normal Shops")
//								visitedshopdatainfo.setRemark("Normal Shops")
		//						ProjectConstants.missingshopdatainfo.add(missingshopdatainfo)
		//						ProjectConstants.visitedshopdatainfo.add(visitedshopdatainfo)
		//						ProjectConstants.SHOP_ATTEMPT = _shop
		//						lastitemafterswipe.click()
		//						MobileBuiltInKeywords.verifyElementText(findTestObject("Object Repository/Validate_ShopOptionsScreen" , [('package') : ProjectConstants.PACKAGENAME]), "Options")
		//						//validate missing shop actions list e.g. start working / get routes etc...
		//						missingShopActionsList()
		//						MobileBuiltInKeywords.tap(findTestObject("Object Repository/StartWorking" , [('package') : ProjectConstants.PACKAGENAME]), 0)
		//						Mobile.delay(15)
		//						Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_MapScreen" , [('package') : ProjectConstants.PACKAGENAME]), 60)
		//						MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/Location_CheckIn" , [('package') : ProjectConstants.PACKAGENAME]), 0)
		//						Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_InfoPopUP" , [('package') : ProjectConstants.PACKAGENAME]), 0)
		//						MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/InfoPopUp_NoButton" , [('package') : ProjectConstants.PACKAGENAME]), 0)
		//						//validate missing shop remarks list e.g. shop open, closed etc...
		//								missingShopRemarksList()
		//								Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopOpen"), null)
		//						ProjectConstants.SCENARIO = "first visit"
		//						Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenarios/VisitShopCategoriesWithOverwriteScenarios"), null)
		//						ProjectConstants.SCENARIO = "Overwrite"
		//						Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenariosWithOverwritePopup/VisitShopCategoriesWithOverwritingScenarios"), null)
		//						Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SaveShop"), null)
		//						for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
		//							if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
		//								ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
		//								ProjectConstants.missingshopdatainfo.get(j).setScenario("Data Verification")
		//								break
		//							}
		//						}
		//						for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
		//							if(ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
		//								ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
		//								ProjectConstants.visitedshopdatainfo.get(j).setShop_scenario("Shop Open ==> Shop Open")
		//								String message = "'Retailer Remarks' with 'SM not visiting' remark"+"\n"+
		//								String.format("%-30s%-100s", "","(2) 'HotSpot Available' for HotSpot With Different Values")
		//								ProjectConstants.visitedshopdatainfo.get(j).setOthercategories_scenarios(message)
		//								break
		//							}
		//						}
		//						Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen" , [('package') : ProjectConstants.PACKAGENAME]), 0)
		//					}
		//				}
		DisplayReport.displayDataInReport()
	}
}
