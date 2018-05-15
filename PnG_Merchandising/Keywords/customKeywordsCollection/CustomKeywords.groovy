package customKeywordsCollection

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

public class CustomKeywords {

	public static AppiumDriver<?> driver = MobileDriverFactory.getDriver()

	@Keyword
	def selectCurrentDay(){
		Calendar calendar = Calendar.getInstance()
		int day = calendar.get(Calendar.DAY_OF_WEEK)
		MobileElement selectedday = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[3]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.Spinner[1]/android.widget.TextView[1]")
		String selecteddayname = selectedday.getText()
		if(day == 1 && !selecteddayname.contains("Sunday")){
			Mobile.tap(findTestObject("Object Repository/DashboardScreenElements/DaysDropDownMenu"), 0)
			Mobile.delay(1)
			driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.TextView[7]").click()
			Mobile.delay(1)
		}
		else if(day == 2 && !selecteddayname.contains("Monday")){
			Mobile.tap(findTestObject("Object Repository/DashboardScreenElements/DaysDropDownMenu"), 0)
			Mobile.delay(1)
			driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.TextView[1]").click()
			Mobile.delay(1)
		}
		else if(day == 3 && !selecteddayname.contains("Tuesday")){
			Mobile.tap(findTestObject("Object Repository/DashboardScreenElements/DaysDropDownMenu"), 0)
			Mobile.delay(1)
			driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.TextView[2]").click()
			Mobile.delay(1)
		}
		else if(day == 4 && !selecteddayname.contains("Wednesday")){
			Mobile.tap(findTestObject("Object Repository/DashboardScreenElements/DaysDropDownMenu"), 0)
			Mobile.delay(1)
			driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.TextView[3]").click()
			Mobile.delay(1)
		}
		else if(day == 5 && !selecteddayname.contains("Thursday")){
			Mobile.tap(findTestObject("Object Repository/DashboardScreenElements/DaysDropDownMenu"), 0)
			Mobile.delay(1)
			driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.TextView[4]").click()
			Mobile.delay(1)
		}
		else if(day == 6 && !selecteddayname.contains("Friday")){
			Mobile.tap(findTestObject("Object Repository/DashboardScreenElements/DaysDropDownMenu"), 0)
			Mobile.delay(1)
			driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.TextView[5]").click()
			Mobile.delay(1)
		}
		else if(day == 7 && !selecteddayname.contains("Saturday")){
			Mobile.tap(findTestObject("Object Repository/DashboardScreenElements/DaysDropDownMenu"), 0)
			Mobile.delay(1)
			driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.TextView[6]").click()
			Mobile.delay(1)
		}
	}
	@Keyword
	def selectHFSShop(){
		boolean flag = false;
		ArrayList<MobileElement> shops = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*")
		for(int i=1 ; i<= shops.size() ; i++){
			MobileElement shop = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			String shopname = shop.getText()
			if(shopname.contains("HFS")){
				flag = true
				driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.delay(1)
				break
			}
			shops = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*")
		}
		if(flag == false){
			while(true){
				ArrayList<MobileElement> countshops = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*")
				int index = countshops.size()
				MobileElement lastshopbeforeswipe = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]//android.widget.TextView[1]")
				String lastshopnamebeforeswipe = lastshopbeforeswipe.getText()
				Mobile.swipe(0, 193, 0, 100)
				Mobile.delay(2)
				MobileElement lastshopafterswipe = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]//android.widget.TextView[1]")
				String lastshopnameafterswipe = lastshopafterswipe.getText()
				if(lastshopnamebeforeswipe.equals(lastshopnameafterswipe)){
					break
				}
				else if(lastshopname.contains("HFS")){
					driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]").click()
					Mobile.delay(1)
					break
				}
			}
		}
	}
	@Keyword
	def visitShopProducts(){
		int flag = 0
		ArrayList<MobileElement> products = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*")
		for(int i=1 ; i<=products.size(); i++ ){
			MobileElement product = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			String productname = product.getText()
			if(productname.contains("HotSpot")){
				flag =+ 1
				driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.delay(1)
				Mobile.callTestCase(findTestCase("ChooseHFSShop/ShopOpen/ShopProducts/HotSpot/VisitHotSpot"), null)
			}
			else if(productname.contains("Retailer Remarks")){
				flag =+ 1
				driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.delay(1)
				Mobile.callTestCase(findTestCase("ChooseHFSShop/ShopOpen/ShopProducts/RetailerRemarks/VisitRetailerRemarks"), null)
			}
			else if(productname.contains("Market Intelligence")){
				flag =+ 1
				driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.delay(1)
				Mobile.callTestCase(findTestCase("ChooseHFSShop/ShopOpen/ShopProducts/MarketIntelligence/VisitMarketIntelligence"), null)
			}
			else if(productname.contains("Hanger")){
				flag =+ 1
				driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.delay(1)
				Mobile.callTestCase(findTestCase("ChooseHFSShop/ShopOpen/ShopProducts/Hanger/VisitHanger"), null)
			}
			else if(productname.contains("Additional Picture")){
				flag =+ 1
				driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.delay(1)
				Mobile.callTestCase(findTestCase("ChooseHFSShop/ShopOpen/ShopProducts/AdditionalPicture/VisitAdditionalPicture"), null)
			}
			else if(productname.contains("Diapers")){
				flag =+ 1
				driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.delay(1)
				Mobile.callTestCase(findTestCase("ChooseHFSShop/ShopOpen/ShopProducts/Diapers/VisitDiaper"), null)
			}
			products = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*")
		}
		if(flag < 6){
			while(true){
				ArrayList<MobileElement> countproducts = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*")
				int index = countproducts.size()
				MobileElement lastproductbeforeswipe = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]/android.widget.TextView[1]")
				String lastproductnamebeforeswipe = lastproductbeforeswipe.getText()
				Mobile.swipe(0, 193, 0, 100)
				Mobile.delay(2)
				MobileElement lastproductafterswipe = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]/android.widget.TextView[1]")
				String lastproductnameafterswipe = lastproductafterswipe.getText()
				if(lastproductnamebeforeswipe.equals(lastproductnameafterswipe)){
					break
				}
				else if(lastproductnameafterswipe.contains("HotSpot")){
					driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]").click()
					Mobile.delay(1)
					Mobile.callTestCase(findTestCase("ChooseHFSShop/ShopOpen/ShopProducts/HotSpot/VisitHotSpot"), null)
				}
				else if(lastproductnameafterswipe.contains("Retailer Remarks")){
					driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]").click()
					Mobile.delay(1)
					Mobile.callTestCase(findTestCase("ChooseHFSShop/ShopOpen/ShopProducts/RetailerRemarks/VisitRetailerRemarks"), null)
				}
				else if(lastproductnameafterswipe.contains("Market Intelligence")){
					driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]").click()
					Mobile.delay(1)
					Mobile.callTestCase(findTestCase("ChooseHFSShop/ShopOpen/ShopProducts/MarketIntelligence/VisitMarketIntelligence"), null)
				}
				else if(lastproductnameafterswipe.contains("Hanger")){
					driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]").click()
					Mobile.delay(1)
					Mobile.callTestCase(findTestCase("ChooseHFSShop/ShopOpen/ShopProducts/Hanger/VisitHanger"), null)
				}
				else if(lastproductnameafterswipe.contains("Additional Picture")){
					driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]").click()
					Mobile.delay(1)
					Mobile.callTestCase(findTestCase("ChooseHFSShop/ShopOpen/ShopProducts/AdditionalPicture/VisitAdditionalPicture"), null)
				}
				else if(lastproductnameafterswipe.contains("Diapers")){
					driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]").click()
					Mobile.delay(1)
					Mobile.callTestCase(findTestCase("Test Cases/VisitShopOpen/VisitShopProducts/VisitShopProduct/ShopProduct"), null)
				}
			}
		}
	}
	@Keyword
	def findProductFromProductsList(String _productname){
		int flag = 0
		ArrayList<MobileElement> products = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*")
		for(int i=1 ; i<=products.size(); i++ ){
			MobileElement product = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			String productname = product.getText()
			if(productname.contains(_productname)){
				flag =+ 1
				driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.delay(1)
			}
			products = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*")
		}
		if(flag < 6){
			while(true){
				ArrayList<MobileElement> countproducts = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*")
				int index = countproducts.size()
				MobileElement lastproductbeforeswipe = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]/android.widget.TextView[1]")
				String lastproductnamebeforeswipe = lastproductbeforeswipe.getText()
				Mobile.swipe(0, 193, 0, 100)
				Mobile.delay(2)
				MobileElement lastproductafterswipe = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]/android.widget.TextView[1]")
				String lastproductnameafterswipe = lastproductafterswipe.getText()
				if(lastproductnamebeforeswipe.equals(lastproductnameafterswipe)){
					break
				}
				else if(lastproductnameafterswipe.contains("HotSpot")){
					driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]").click()
					Mobile.delay(1)
				}
			}
		}
	}
	@Keyword
	def selectHotSpotAppropriateType(){
		ArrayList<MobileElement> hotspottypes = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*")
		for(int i=1; i<=hotspottypes.size(); i++){
			MobileElement hotspottype = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			String hotspottypename = hotspottype.getText()
			if(hotspottypename.contains("Small I (2 Shelfs)")){
				driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.delay(1)
				break
			}
		}
	}
	@Keyword
	def selectPOSM(){
		driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]").click()
		Mobile.delay(1)
	}
	@Keyword
	def selectPOSMRemarks(){
		driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]").click()
		Mobile.delay(1)
	}
	@Keyword
	def visitPampersAvailability(){
		int index = 1
		ArrayList<MobileElement> pampersavailabilitylist = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
		for(int i=1; i<=pampersavailabilitylist.size(); i=i+2){
			driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+i+"]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.RadioGroup[1]/android.widget.RadioButton[1]").click()
			Mobile.delay(1)
			index = index+1
			pampersavailabilitylist = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
		}
		while(true){
			MobileElement lastoptionbeforeswipe = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")
			String lastoptionnamebeforeswipe = lastoptionbeforeswipe.getText()
			Mobile.swipe(0, 164, 0, 100)
			Mobile.delay(2)
			MobileElement lastoptionafterswipe = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")
			String lastoptionnameafterswipe = lastoptionafterswipe.getText()
			if(lastoptionnamebeforeswipe.equals(lastoptionnameafterswipe)){
				break
			}
			else{
				driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.RadioGroup[1]/android.widget.RadioButton[1]").click()
				Mobile.delay(1)
			}
		}
	}
	@Keyword
	def visitShareOfShelfFields(){
		int index = 1
		ArrayList<MobileElement> shareofshelffieldslist = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
		for(int i=2; i<=shareofshelffieldslist.size(); i=i+3){
			Mobile.setText(driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.EditText[1]"), "1", 0)
			index = index+1
			shareofshelffieldslist = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
		}
		while(true){
			MobileElement lastfieldbeforeswipe = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.TextView["+index+"]")
			String lastfieldnamebeforeswipe = lastfieldbeforeswipe.getText()
			Mobile.swipe(0, 200, 0, 100)
			Mobile.delay(1)
			MobileElement lastfieldafterswipe = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.TextView["+index+"]")
			String lastfieldnameafterswipe = lastfieldafterswipe.getText()
			if(lastfieldnamebeforeswipe.equals(lastfieldnameafterswipe)){
				break
			}
			else{
				Mobile.setText(driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.EditText[1]"), "1", 0)
			}
		}
	}
}