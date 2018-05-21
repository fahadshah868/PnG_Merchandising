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
import com.kms.katalon.core.testdata.TestDataColumn
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

	public static TestData dataforvisitdiapers = findTestData("Data Files/Diapers/VisitDiapers")
	public static TestData dataforoverwritediapers = findTestData("Data Files/Diapers/OverwriteDiapers")
	public static TestData dataforvisithanger = findTestData("Data Files/Hanger/VisitHanger")
	public static TestData dataforoverwritehanger = findTestData("Data Files/Hanger/OverwriteHanger")
	public static TestData datafordistributionregion = findTestData("Data Files/DistributionRegion/DistributionRegion")


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
	def visitDistributionRegion(){
		int index = 0;
		ArrayList<MobileElement> distributionfields = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/*")
		for(int i=2; i<=(distributionfields.size()-1); i++){
			index = index+1
			MobileElement distributionfield = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.TextView[1]")
			String distributionfieldname = distributionfield.getText()
			if(distributionfieldname.contains("Brand Message")){
				MobileElement textfield = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.EditText[1]")
				textfield.setValue(datafordistributionregion.getObjectValue("Brand Message", 1))
				Mobile.hideKeyboard()
			}
			else if(distributionfieldname.contains("Corporate Message")){
				MobileElement textfield = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.EditText[1]")
				textfield.setValue(datafordistributionregion.getObjectValue("Corporation Message", 1))
				Mobile.hideKeyboard()
			}
			else if(distributionfieldname.contains("Value Message")){
				MobileElement textfield = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.EditText[1]")
				textfield.setValue(datafordistributionregion.getObjectValue("Value Message", 1))
				Mobile.hideKeyboard()
			}
			else if(distributionfieldname.contains("Poster")){
				MobileElement textfield = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.EditText[1]")
				textfield.setValue(datafordistributionregion.getObjectValue("Poster", 1))
				Mobile.hideKeyboard()
			}
		}
	}
	@Keyword
	def selectHFSShop(){
		boolean flag = false;
		ArrayList<MobileElement> shops = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*")
		for(int i=1 ; i<= shops.size() ; i++){
			MobileElement shop = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			String shopname = shop.getText()
			if(shopname.contains("HFS Medium")){
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
				else if(lastshopname.contains("HFS Medium")){
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
		int index = 0
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
				index = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*").size()
				String lastvisitedproduct = ""
				boolean _flag = false
				MobileElement lastproductbeforeswipe = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]/android.widget.TextView[1]")
				String lastproductnamebeforeswipe = lastproductbeforeswipe.getText()
				Mobile.swipe(0, 293, 0, 200)
				Mobile.delay(2)
				index = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*").size()
				MobileElement lastproductafterswipe = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]/android.widget.TextView[1]")
				String lastproductnameafterswipe = lastproductafterswipe.getText()
				if(lastproductnamebeforeswipe.equals(lastproductnameafterswipe)){
					break
				}
				else if(lastproductnameafterswipe.contains("HotSpot")){
					lastvisitedproduct = "HotSpot"
					_flag = true
					driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]").click()
					Mobile.delay(1)
					Mobile.callTestCase(findTestCase("ChooseHFSShop/ShopOpen/ShopProducts/HotSpot/VisitHotSpot"), null)
				}
				else if(lastproductnameafterswipe.contains("Retailer Remarks")){
					lastvisitedproduct = "Retailer Remarks"
					_flag = true
					driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]").click()
					Mobile.delay(1)
					Mobile.callTestCase(findTestCase("ChooseHFSShop/ShopOpen/ShopProducts/RetailerRemarks/VisitRetailerRemarks"), null)
				}
				else if(lastproductnameafterswipe.contains("Market Intelligence")){
					lastvisitedproduct = "Market Intelligence"
					_flag = false
					driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]").click()
					Mobile.delay(1)
					Mobile.callTestCase(findTestCase("ChooseHFSShop/ShopOpen/ShopProducts/MarketIntelligence/VisitMarketIntelligence"), null)
				}
				else if(lastproductnameafterswipe.contains("Hanger")){
					lastvisitedproduct = "Hanger"
					_flag = true
					driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]").click()
					Mobile.delay(1)
					Mobile.callTestCase(findTestCase("ChooseHFSShop/ShopOpen/ShopProducts/Hanger/VisitHanger"), null)
				}
				else if(lastproductnameafterswipe.contains("Additional Picture")){
					lastvisitedproduct = "Additional Picture"
					_flag = true
					driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]").click()
					Mobile.delay(1)
					Mobile.callTestCase(findTestCase("ChooseHFSShop/ShopOpen/ShopProducts/AdditionalPicture/VisitAdditionalPicture"), null)
				}
				else if(lastproductnameafterswipe.contains("Diapers")){
					lastvisitedproduct = "Diapers"
					_flag = true
					driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]").click()
					Mobile.delay(1)
					Mobile.callTestCase(findTestCase("Test Cases/VisitShopOpen/VisitShopProducts/VisitShopProduct/ShopProduct"), null)
				}
				if(_flag == true){
					while(true){
						index = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*").size()
						Mobile.swipe(0, 293, 0, 200)
						Mobile.delay(2)
						MobileElement product = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]/android.widget.TextView[1]")
						String productname = product.getText()
						if(productname.contains(lastvisitedproduct)){
							_flag = false
							break
						}
					}
				}
			}
		}
	}
	@Keyword
	def overwriteShopProducts(){
		int flag = 0
		int index = 0
		ArrayList<MobileElement> products = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*")
		for(int i=1 ; i<=products.size(); i++ ){
			MobileElement product = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			String productname = product.getText()
			if(productname.contains("HotSpot")){
				flag =+ 1
				driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.delay(1)
				Mobile.callTestCase(findTestCase("ChooseHFSShop/ShopOpen/ShopProducts/HotSpot/OverwriteHotSpot"), null)
			}
			else if(productname.contains("Retailer Remarks")){
				flag =+ 1
				driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.delay(1)
				Mobile.callTestCase(findTestCase("ChooseHFSShop/ShopOpen/ShopProducts/RetailerRemarks/OverwriteRetailerRemarks"), null)
			}
			else if(productname.contains("Market Intelligence")){
				flag =+ 1
				driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.delay(1)
				Mobile.callTestCase(findTestCase("ChooseHFSShop/ShopOpen/ShopProducts/MarketIntelligence/OverwriteMarketIntelligence"), null)
			}
			else if(productname.contains("Hanger")){
				flag =+ 1
				driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.delay(1)
				Mobile.callTestCase(findTestCase("ChooseHFSShop/ShopOpen/ShopProducts/Hanger/OverwriteHanger"), null)
			}
			else if(productname.contains("Additional Picture")){
				flag =+ 1
				driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.delay(1)
				Mobile.callTestCase(findTestCase("ChooseHFSShop/ShopOpen/ShopProducts/AdditionalPicture/OverwriteAdditionalPicture"), null)
			}
			else if(productname.contains("Diapers")){
				flag =+ 1
				driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.delay(1)
				Mobile.callTestCase(findTestCase("ChooseHFSShop/ShopOpen/ShopProducts/Diapers/OverwriteDiaper"), null)
			}
			products = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*")
		}
		if(flag < 6){
			while(true){
				index = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*").size()
				String lastvisitedproduct = ""
				boolean _flag = false
				MobileElement lastproductbeforeswipe = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]/android.widget.TextView[1]")
				String lastproductnamebeforeswipe = lastproductbeforeswipe.getText()
				Mobile.swipe(0, 293, 0, 200)
				Mobile.delay(2)
				index = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*").size()
				MobileElement lastproductafterswipe = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]/android.widget.TextView[1]")
				String lastproductnameafterswipe = lastproductafterswipe.getText()
				if(lastproductnamebeforeswipe.equals(lastproductnameafterswipe)){
					break
				}
				else if(lastproductnameafterswipe.contains("HotSpot")){
					driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]").click()
					Mobile.delay(1)
					Mobile.callTestCase(findTestCase("ChooseHFSShop/ShopOpen/ShopProducts/HotSpot/OverwriteHotSpot"), null)
				}
				else if(lastproductnameafterswipe.contains("Retailer Remarks")){
					driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]").click()
					Mobile.delay(1)
					Mobile.callTestCase(findTestCase("ChooseHFSShop/ShopOpen/ShopProducts/RetailerRemarks/OverwriteRetailerRemarks"), null)
				}
				else if(lastproductnameafterswipe.contains("Market Intelligence")){
					driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]").click()
					Mobile.delay(1)
					Mobile.callTestCase(findTestCase("ChooseHFSShop/ShopOpen/ShopProducts/MarketIntelligence/OverwriteMarketIntelligence"), null)
				}
				else if(lastproductnameafterswipe.contains("Hanger")){
					driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]").click()
					Mobile.delay(1)
					Mobile.callTestCase(findTestCase("ChooseHFSShop/ShopOpen/ShopProducts/Hanger/OverwriteHanger"), null)
				}
				else if(lastproductnameafterswipe.contains("Additional Picture")){
					driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]").click()
					Mobile.delay(1)
					Mobile.callTestCase(findTestCase("ChooseHFSShop/ShopOpen/ShopProducts/AdditionalPicture/OverwriteAdditionalPicture"), null)
				}
				else if(lastproductnameafterswipe.contains("Diapers")){
					driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]").click()
					Mobile.delay(1)
					Mobile.callTestCase(findTestCase("ChooseHFSShop/ShopOpen/ShopProducts/Diapers/OverwriteDiaper"), null)
				}
				if(_flag == true){
					while(true){
						index = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*").size()
						Mobile.swipe(0, 293, 0, 200)
						Mobile.delay(2)
						MobileElement product = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]/android.widget.TextView[1]")
						String productname = product.getText()
						if(productname.contains(lastvisitedproduct)){
							_flag = false
							break
						}
					}
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
	def visitPampersAvailability(){
		int index = 0
		ArrayList<MobileElement> pampersavailabilitylist = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
		for(int i=1; i<=pampersavailabilitylist.size(); i=i+2){
			index = index+1
			driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.RadioGroup[1]/android.widget.RadioButton[1]").click()
			Mobile.delay(1)
			pampersavailabilitylist = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
		}
		while(true){
			MobileElement lastoptionbeforeswipe = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")
			String lastoptionnamebeforeswipe = lastoptionbeforeswipe.getText()
			Mobile.swipe(0, 274, 0, 200)
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
	def overwritePampersAvailability(){
		int index = 0
		ArrayList<MobileElement> pampersavailabilitylist = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
		for(int i=1; i<=pampersavailabilitylist.size(); i=i+2){
			index = index+1
			driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.RadioGroup[1]/android.widget.RadioButton[2]").click()
			Mobile.delay(1)
			pampersavailabilitylist = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
		}
		while(true){
			index = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*").size()
			MobileElement lastoptionbeforeswipe = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")
			String lastoptionnamebeforeswipe = lastoptionbeforeswipe.getText()
			Mobile.swipe(0, 274, 0, 200)
			Mobile.delay(2)
			index = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*").size()
			MobileElement lastoptionafterswipe = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")
			String lastoptionnameafterswipe = lastoptionafterswipe.getText()
			if(lastoptionnamebeforeswipe.equals(lastoptionnameafterswipe)){
				break
			}
			else{
				driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.RadioGroup[1]/android.widget.RadioButton[2]").click()
				Mobile.delay(1)
			}
		}
	}
	@Keyword
	def visitShareOfShelfFields(){
		int index = 0
		ArrayList<MobileElement> shareofshelffieldslist = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
		for(int i=2; i<=shareofshelffieldslist.size(); i=i+3){
			index = index+1
			MobileElement product = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.TextView["+index+"]")
			String productname = product.getText()
			MobileElement textfield = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.EditText[1]")
			if(productname.contains("Mini ML JP (2)")){
				textfield.setValue(dataforvisitdiapers.getObjectValue("Mini ML JP (2)", 1))
				Mobile.hideKeyboard()
			}
			else if(productname.contains("Mini ML MP (2)")){
				textfield.setValue(dataforvisitdiapers.getObjectValue("Mini ML MP (2)", 1))
				Mobile.hideKeyboard()
			}
			else if(productname.contains("Midi ML JP (3)")){
				textfield.setValue(dataforvisitdiapers.getObjectValue("Midi ML JP (3)", 1))
				Mobile.hideKeyboard()
			}
			else if(productname.contains("Midi ML MP (3)")){
				textfield.setValue(dataforvisitdiapers.getObjectValue("Midi ML MP (3)", 1))
				Mobile.hideKeyboard()
			}
			else if(productname.contains("Midi Pants JP (3)")){
				textfield.setValue(dataforvisitdiapers.getObjectValue("Midi Pants JP (3)", 1))
				Mobile.hideKeyboard()
			}
			else if(productname.contains("Midi Pants MP (3)")){
				textfield.setValue(dataforvisitdiapers.getObjectValue("Midi Pants MP (3)", 1))
				Mobile.hideKeyboard()
			}
			else if(productname.contains("Maxi ML JP (4)")){
				textfield.setValue(dataforvisitdiapers.getObjectValue("Maxi ML JP (4)", 1))
				Mobile.hideKeyboard()
			}
			else if(productname.contains("Maxi ML MP (4)")){
				textfield.setValue(dataforvisitdiapers.getObjectValue("Maxi ML MP (4)", 1))
				Mobile.hideKeyboard()
			}
			else if(productname.contains("Maxi Pants JP (4)")){
				textfield.setValue(dataforvisitdiapers.getObjectValue("Maxi Pants JP (4)", 1))
				Mobile.hideKeyboard()
			}
			else if(productname.contains("Maxi Pants MP (4)")){
				textfield.setValue(dataforvisitdiapers.getObjectValue("Maxi Pants MP (4)", 1))
				Mobile.hideKeyboard()
			}
			else if(productname.contains("Junior ML JP (5)")){
				textfield.setValue(dataforvisitdiapers.getObjectValue("Junior ML JP (5)", 1))
				Mobile.hideKeyboard()
			}
			else if(productname.contains("Junior ML MP (5)")){
				textfield.setValue(dataforvisitdiapers.getObjectValue("Junior ML MP (5)", 1))
				Mobile.hideKeyboard()
			}
			else if(productname.contains("P&G Others")){
				textfield.setValue(dataforvisitdiapers.getObjectValue("P&G Others", 1))
				Mobile.hideKeyboard()
			}
			else if(productname.contains("Canbabe")){
				textfield.setValue(dataforvisitdiapers.getObjectValue("Canbabe", 1))
				Mobile.hideKeyboard()
			}
			else if(productname.contains("Baby Master")){
				textfield.setValue(dataforvisitdiapers.getObjectValue("Baby Master", 1))
				Mobile.hideKeyboard()
			}
			else if(productname.contains("P&G imported")){
				textfield.setValue(dataforvisitdiapers.getObjectValue("P&G imported", 1))
				Mobile.hideKeyboard()
			}
			else if(productname.contains("Others")){
				textfield.setValue(dataforvisitdiapers.getObjectValue("Others", 1))
				Mobile.hideKeyboard()
			}
			shareofshelffieldslist = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
		}
		while(true){
			MobileElement lastproductbeforeswipe = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.TextView[5]")
			String lastproductnamebeforeswipe = lastproductbeforeswipe.getText()
			Mobile.swipe(0, 330, 0, 220)
			Mobile.delay(1)
			MobileElement lastproductafterswipe = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.TextView[5]")
			String lastproductnameafterswipe = lastproductafterswipe.getText()
			if(lastproductnamebeforeswipe.equals(lastproductnameafterswipe)){
				break
			}
			else{
				MobileElement textfield = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.EditText[1]")
				if(lastproductnameafterswipe.contains("Mini ML JP (2)")){
					textfield.setValue(dataforvisitdiapers.getObjectValue("Mini ML JP (2)", 1))
					Mobile.hideKeyboard()
				}
				else if(lastproductnameafterswipe.contains("Mini ML MP (2)")){
					textfield.setValue(dataforvisitdiapers.getObjectValue("Mini ML MP (2)", 1))
					Mobile.hideKeyboard()
				}
				else if(lastproductnameafterswipe.contains("Midi ML JP (3)")){
					textfield.setValue(dataforvisitdiapers.getObjectValue("Midi ML JP (3)", 1))
					Mobile.hideKeyboard()
				}
				else if(lastproductnameafterswipe.contains("Midi ML MP (3)")){
					textfield.setValue(dataforvisitdiapers.getObjectValue("Midi ML MP (3)", 1))
					Mobile.hideKeyboard()
				}
				else if(lastproductnameafterswipe.contains("Midi Pants JP (3)")){
					textfield.setValue(dataforvisitdiapers.getObjectValue("Midi Pants JP (3)", 1))
					Mobile.hideKeyboard()
				}
				else if(lastproductnameafterswipe.contains("Midi Pants MP (3)")){
					textfield.setValue(dataforvisitdiapers.getObjectValue("Midi Pants MP (3)", 1))
					Mobile.hideKeyboard()
				}
				else if(lastproductnameafterswipe.contains("Maxi ML JP (4)")){
					textfield.setValue(dataforvisitdiapers.getObjectValue("Maxi ML JP (4)", 1))
					Mobile.hideKeyboard()
				}
				else if(lastproductnameafterswipe.contains("Maxi ML MP (4)")){
					textfield.setValue(dataforvisitdiapers.getObjectValue("Maxi ML MP (4)", 1))
					Mobile.hideKeyboard()
				}
				else if(lastproductnameafterswipe.contains("Maxi Pants JP (4)")){
					textfield.setValue(dataforvisitdiapers.getObjectValue("Maxi Pants JP (4)", 1))
					Mobile.hideKeyboard()
				}
				else if(lastproductnameafterswipe.contains("Maxi Pants MP (4)")){
					textfield.setValue(dataforvisitdiapers.getObjectValue("Maxi Pants MP (4)", 1))
					Mobile.hideKeyboard()
				}
				else if(lastproductnameafterswipe.contains("Junior ML JP (5)")){
					textfield.setValue(dataforvisitdiapers.getObjectValue("Junior ML JP (5)", 1))
					Mobile.hideKeyboard()
				}
				else if(lastproductnameafterswipe.contains("Junior ML MP (5)")){
					textfield.setValue(dataforvisitdiapers.getObjectValue("Junior ML MP (5)", 1))
					Mobile.hideKeyboard()
				}
				else if(lastproductnameafterswipe.contains("P&G Others")){
					textfield.setValue(dataforvisitdiapers.getObjectValue("P&G Others", 1))
					Mobile.hideKeyboard()
				}
				else if(lastproductnameafterswipe.contains("Canbabe")){
					textfield.setValue(dataforvisitdiapers.getObjectValue("Canbabe", 1))
					Mobile.hideKeyboard()
				}
				else if(lastproductnameafterswipe.contains("Baby Master")){
					textfield.setValue(dataforvisitdiapers.getObjectValue("Baby Master", 1))
					Mobile.hideKeyboard()
				}
				else if(lastproductnameafterswipe.contains("P&G imported")){
					textfield.setValue(dataforvisitdiapers.getObjectValue("P&G imported", 1))
					Mobile.hideKeyboard()
				}
				else if(lastproductnameafterswipe.contains("Others")){
					textfield.setValue(dataforvisitdiapers.getObjectValue("Others", 1))
					Mobile.hideKeyboard()
				}
			}
		}
	}
	@Keyword
	def overwriteShareOfShelfFields(){
		int index = 0
		ArrayList<MobileElement> shareofshelffieldslist = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
		for(int i=2; i<=shareofshelffieldslist.size(); i=i+3){
			index = index+1
			MobileElement product = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.TextView["+index+"]")
			String productname = product.getText()
			MobileElement textfield = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.EditText[1]")
			if(productname.contains("Mini ML JP (2)")){
				textfield.setValue(dataforoverwritediapers.getObjectValue("Mini ML JP (2)", 1))
				Mobile.hideKeyboard()
			}
			else if(productname.contains("Mini ML MP (2)")){
				textfield.setValue(dataforoverwritediapers.getObjectValue("Mini ML MP (2)", 1))
				Mobile.hideKeyboard()
			}
			else if(productname.contains("Midi ML JP (3)")){
				textfield.setValue(dataforoverwritediapers.getObjectValue("Midi ML JP (3)", 1))
				Mobile.hideKeyboard()
			}
			else if(productname.contains("Midi ML MP (3)")){
				textfield.setValue(dataforoverwritediapers.getObjectValue("Midi ML MP (3)", 1))
				Mobile.hideKeyboard()
			}
			else if(productname.contains("Midi Pants JP (3)")){
				textfield.setValue(dataforoverwritediapers.getObjectValue("Midi Pants JP (3)", 1))
				Mobile.hideKeyboard()
			}
			else if(productname.contains("Midi Pants MP (3)")){
				textfield.setValue(dataforoverwritediapers.getObjectValue("Midi Pants MP (3)", 1))
				Mobile.hideKeyboard()
			}
			else if(productname.contains("Maxi ML JP (4)")){
				textfield.setValue(dataforoverwritediapers.getObjectValue("Maxi ML JP (4)", 1))
				Mobile.hideKeyboard()
			}
			else if(productname.contains("Maxi ML MP (4)")){
				textfield.setValue(dataforoverwritediapers.getObjectValue("Maxi ML MP (4)", 1))
				Mobile.hideKeyboard()
			}
			else if(productname.contains("Maxi Pants JP (4)")){
				textfield.setValue(dataforoverwritediapers.getObjectValue("Maxi Pants JP (4)", 1))
				Mobile.hideKeyboard()
			}
			else if(productname.contains("Maxi Pants MP (4)")){
				textfield.setValue(dataforoverwritediapers.getObjectValue("Maxi Pants MP (4)", 1))
				Mobile.hideKeyboard()
			}
			else if(productname.contains("Junior ML JP (5)")){
				textfield.setValue(dataforoverwritediapers.getObjectValue("Junior ML JP (5)", 1))
				Mobile.hideKeyboard()
			}
			else if(productname.contains("Junior ML MP (5)")){
				textfield.setValue(dataforoverwritediapers.getObjectValue("Junior ML MP (5)", 1))
				Mobile.hideKeyboard()
			}
			else if(productname.contains("P&G Others")){
				textfield.setValue(dataforoverwritediapers.getObjectValue("P&G Others", 1))
				Mobile.hideKeyboard()
			}
			else if(productname.contains("Canbabe")){
				textfield.setValue(dataforoverwritediapers.getObjectValue("Canbabe", 1))
				Mobile.hideKeyboard()
			}
			else if(productname.contains("Baby Master")){
				textfield.setValue(dataforoverwritediapers.getObjectValue("Baby Master", 1))
				Mobile.hideKeyboard()
			}
			else if(productname.contains("P&G imported")){
				textfield.setValue(dataforoverwritediapers.getObjectValue("P&G imported", 1))
				Mobile.hideKeyboard()
			}
			else if(productname.contains("Others")){
				textfield.setValue(dataforoverwritediapers.getObjectValue("Others", 1))
				Mobile.hideKeyboard()
			}
			shareofshelffieldslist = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
		}
		while(true){
			MobileElement lastproductbeforeswipe = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.TextView[5]")
			String lastproductnamebeforeswipe = lastproductbeforeswipe.getText()
			Mobile.swipe(0, 330, 0, 220)
			Mobile.delay(1)
			MobileElement lastproductafterswipe = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.TextView[5]")
			String lastproductnameafterswipe = lastproductafterswipe.getText()
			if(lastproductnamebeforeswipe.equals(lastproductnameafterswipe)){
				break
			}
			else{
				MobileElement textfield = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.EditText[1]")
				if(lastproductnameafterswipe.contains("Mini ML JP (2)")){
					textfield.setValue(dataforoverwritediapers.getObjectValue("Mini ML JP (2)", 1))
					Mobile.hideKeyboard()
				}
				else if(lastproductnameafterswipe.contains("Mini ML MP (2)")){
					textfield.setValue(dataforoverwritediapers.getObjectValue("Mini ML MP (2)", 1))
					Mobile.hideKeyboard()
				}
				else if(lastproductnameafterswipe.contains("Midi ML JP (3)")){
					textfield.setValue(dataforoverwritediapers.getObjectValue("Midi ML JP (3)", 1))
					Mobile.hideKeyboard()
				}
				else if(lastproductnameafterswipe.contains("Midi ML MP (3)")){
					textfield.setValue(dataforoverwritediapers.getObjectValue("Midi ML MP (3)", 1))
					Mobile.hideKeyboard()
				}
				else if(lastproductnameafterswipe.contains("Midi Pants JP (3)")){
					textfield.setValue(dataforoverwritediapers.getObjectValue("Midi Pants JP (3)", 1))
					Mobile.hideKeyboard()
				}
				else if(lastproductnameafterswipe.contains("Midi Pants MP (3)")){
					textfield.setValue(dataforoverwritediapers.getObjectValue("Midi Pants MP (3)", 1))
					Mobile.hideKeyboard()
				}
				else if(lastproductnameafterswipe.contains("Maxi ML JP (4)")){
					textfield.setValue(dataforoverwritediapers.getObjectValue("Maxi ML JP (4)", 1))
					Mobile.hideKeyboard()
				}
				else if(lastproductnameafterswipe.contains("Maxi ML MP (4)")){
					textfield.setValue(dataforoverwritediapers.getObjectValue("Maxi ML MP (4)", 1))
					Mobile.hideKeyboard()
				}
				else if(lastproductnameafterswipe.contains("Maxi Pants JP (4)")){
					textfield.setValue(dataforoverwritediapers.getObjectValue("Maxi Pants JP (4)", 1))
					Mobile.hideKeyboard()
				}
				else if(lastproductnameafterswipe.contains("Maxi Pants MP (4)")){
					textfield.setValue(dataforoverwritediapers.getObjectValue("Maxi Pants MP (4)", 1))
					Mobile.hideKeyboard()
				}
				else if(lastproductnameafterswipe.contains("Junior ML JP (5)")){
					textfield.setValue(dataforoverwritediapers.getObjectValue("Junior ML JP (5)", 1))
					Mobile.hideKeyboard()
				}
				else if(lastproductnameafterswipe.contains("Junior ML MP (5)")){
					textfield.setValue(dataforoverwritediapers.getObjectValue("Junior ML MP (5)", 1))
					Mobile.hideKeyboard()
				}
				else if(lastproductnameafterswipe.contains("P&G Others")){
					textfield.setValue(dataforoverwritediapers.getObjectValue("P&G Others", 1))
					Mobile.hideKeyboard()
				}
				else if(lastproductnameafterswipe.contains("Canbabe")){
					textfield.setValue(dataforoverwritediapers.getObjectValue("Canbabe", 1))
					Mobile.hideKeyboard()
				}
				else if(lastproductnameafterswipe.contains("Baby Master")){
					textfield.setValue(dataforoverwritediapers.getObjectValue("Baby Master", 1))
					Mobile.hideKeyboard()
				}
				else if(lastproductnameafterswipe.contains("P&G imported")){
					textfield.setValue(dataforoverwritediapers.getObjectValue("P&G imported", 1))
					Mobile.hideKeyboard()
				}
				else if(lastproductnameafterswipe.contains("Others")){
					textfield.setValue(dataforoverwritediapers.getObjectValue("Others", 1))
					Mobile.hideKeyboard()
				}
			}
		}
	}
	@Keyword
	def visitHangerProducts(){
		ArrayList<MobileElement> hangerproductslist = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
		int index = 0
		for(int i=2; i<=hangerproductslist.size(); i=i+3){
			index = index+1
			MobileElement product = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.TextView["+index+"]")
			String productname = product.getText()
			MobileElement textfield = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.EditText[1]")
			if(productname.contains("Ariel Ariel 45gm")){
				textfield.setValue(dataforvisithanger.getObjectValue("Ariel Ariel 45gm", 1))
				Mobile.hideKeyboard()
			}
			else if(productname.contains("Ariel Ariel 95gm")){
				textfield.setValue(dataforvisithanger.getObjectValue("Ariel Ariel 95gm", 1))
				Mobile.hideKeyboard()
			}
			else if(productname.contains("H&S Classic Clean   5ml")){
				textfield.setValue(dataforvisithanger.getObjectValue("H&S Classic Clean 5ml", 1))
				Mobile.hideKeyboard()
			}
			else if(productname.contains("H&S Silky Black 5ml")){
				textfield.setValue(dataforvisithanger.getObjectValue("H&S Silky Black 5ml", 1))
				Mobile.hideKeyboard()
			}
			else if(productname.contains("H&S Anti Hair Fall 5ml")){
				textfield.setValue(dataforvisithanger.getObjectValue("H&S Anti Hair Fall 5ml", 1))
				Mobile.hideKeyboard()
			}
			else if(productname.contains("H&S Refreshing 5ml")){
				textfield.setValue(dataforvisithanger.getObjectValue("H&S Refreshing 5ml", 1))
				Mobile.hideKeyboard()
			}
			else if(productname.contains("Pantene Anti Hairfall 5ml")){
				textfield.setValue(dataforvisithanger.getObjectValue("Pantene Anti Hairfall 5ml", 1))
				Mobile.hideKeyboard()
			}
			else if(productname.contains("Pantene Smooth & Strong 5ml - Sachet")){
				textfield.setValue(dataforvisithanger.getObjectValue("Pantene Smooth & Strong 5ml - Sachet", 1))
				Mobile.hideKeyboard()
			}
			else if(productname.contains("Pantene Milky Extra Treatment 5ml")){
				textfield.setValue(dataforvisithanger.getObjectValue("Pantene Milky Extra Treatment 5ml", 1))
				Mobile.hideKeyboard()
			}
			hangerproductslist = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
		}
		while(true){
			MobileElement lastproductbeforeswipe = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.TextView[5]")
			String lastproductnamebeforeswipe = lastproductbeforeswipe.getText()
			Mobile.swipe(0, 330, 0, 220)
			Mobile.delay(1)
			MobileElement lastproductafterswipe = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.TextView[5]")
			String lastproductnameafterswipe = lastproductafterswipe.getText()
			MobileElement textfield = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.EditText[1]")
			if(lastproductnamebeforeswipe.equals(lastproductnameafterswipe)){
				break
			}
			else{
				if(lastproductnameafterswipe.contains("Ariel Ariel 45gm")){
					textfield.setValue(dataforvisithanger.getObjectValue("Ariel Ariel 45gm", 1))
					Mobile.hideKeyboard()
				}
				else if(lastproductnameafterswipe.contains("Ariel Ariel 95gm")){
					textfield.setValue(dataforvisithanger.getObjectValue("Ariel Ariel 95gm", 1))
					Mobile.hideKeyboard()
				}
				else if(lastproductnameafterswipe.contains("H&S Classic Clean   5ml")){
					textfield.setValue(dataforvisithanger.getObjectValue("H&S Classic Clean 5ml", 1))
					Mobile.hideKeyboard()
				}
				else if(lastproductnameafterswipe.contains("H&S Silky Black 5ml")){
					textfield.setValue(dataforvisithanger.getObjectValue("H&S Silky Black 5ml", 1))
					Mobile.hideKeyboard()
				}
				else if(lastproductnameafterswipe.contains("H&S Anti Hair Fall 5ml")){
					textfield.setValue(dataforvisithanger.getObjectValue("H&S Anti Hair Fall 5ml", 1))
					Mobile.hideKeyboard()
				}
				else if(lastproductnameafterswipe.contains("Pantene Smooth & Strong 5ml - Sachet")){
					textfield.setValue(dataforvisithanger.getObjectValue("Pantene Smooth & Strong 5ml - Sachet", 1))
					Mobile.hideKeyboard()
				}
				else if(lastproductnameafterswipe.contains("Pantene Milky Extra Treatment 5ml")){
					textfield.setValue(dataforvisithanger.getObjectValue("Pantene Milky Extra Treatment 5ml", 1))
					Mobile.hideKeyboard()
				}
				else if(lastproductnameafterswipe.contains("H&S Refreshing 5ml")){
					textfield.setValue(dataforvisithanger.getObjectValue("H&S Refreshing 5ml", 1))
					Mobile.hideKeyboard()
				}
				else if(lastproductnameafterswipe.contains("Pantene Anti Hairfall 5ml")){
					textfield.setValue(dataforvisithanger.getObjectValue("Pantene Anti Hairfall 5ml", 1))
					Mobile.hideKeyboard()
				}
			}
		}
	}
	@Keyword
	def overwriteHangerProducts(){
		ArrayList<MobileElement> hangerproductslist = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
		int index = 0
		for(int i=2; i<=hangerproductslist.size(); i=i+3){
			index = index+1
			MobileElement product = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.TextView["+index+"]")
			String productname = product.getText()
			MobileElement textfield = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.EditText[1]")
			if(productname.contains("Ariel Ariel 45gm")){
				textfield.setValue(dataforoverwritehanger.getObjectValue("Ariel Ariel 45gm", 1))
				Mobile.hideKeyboard()
			}
			else if(productname.contains("Ariel Ariel 95gm")){
				textfield.setValue(dataforoverwritehanger.getObjectValue("Ariel Ariel 95gm", 1))
				Mobile.hideKeyboard()
			}
			else if(productname.contains("H&S Classic Clean   5ml")){
				textfield.setValue(dataforoverwritehanger.getObjectValue("H&S Classic Clean 5ml", 1))
				Mobile.hideKeyboard()
			}
			else if(productname.contains("H&S Silky Black 5ml")){
				textfield.setValue(dataforoverwritehanger.getObjectValue("H&S Silky Black 5ml", 1))
				Mobile.hideKeyboard()
			}
			else if(productname.contains("H&S Anti Hair Fall 5ml")){
				textfield.setValue(dataforoverwritehanger.getObjectValue("H&S Anti Hair Fall 5ml", 1))
				Mobile.hideKeyboard()
			}
			else if(productname.contains("Pantene Smooth & Strong 5ml - Sachet")){
				textfield.setValue(dataforoverwritehanger.getObjectValue("Pantene Smooth & Strong 5ml - Sachet", 1))
				Mobile.hideKeyboard()
			}
			else if(productname.contains("Pantene Milky Extra Treatment 5ml")){
				textfield.setValue(dataforoverwritehanger.getObjectValue("Pantene Milky Extra Treatment 5ml", 1))
				Mobile.hideKeyboard()
			}
			else if(productname.contains("H&S Refreshing 5ml")){
				textfield.setValue(dataforvisithanger.getObjectValue("H&S Refreshing 5ml", 1))
				Mobile.hideKeyboard()
			}
			else if(productname.contains("Pantene Anti Hairfall 5ml")){
				textfield.setValue(dataforvisithanger.getObjectValue("Pantene Anti Hairfall 5ml", 1))
				Mobile.hideKeyboard()
			}
			hangerproductslist = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
		}
		while(true){
			MobileElement lastproductbeforeswipe = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.TextView[5]")
			String lastproductnamebeforeswipe = lastproductbeforeswipe.getText()
			Mobile.swipe(0, 330, 0, 220)
			Mobile.delay(1)
			MobileElement lastproductafterswipe = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.TextView[5]")
			String lastproductnameafterswipe = lastproductafterswipe.getText()
			MobileElement textfield = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.EditText[1]")
			if(lastproductnamebeforeswipe.equals(lastproductnameafterswipe)){
				break
			}
			else{
				if(lastproductnameafterswipe.contains("Ariel Ariel 45gm")){
					textfield.setValue(dataforoverwritehanger.getObjectValue("Ariel Ariel 45gm", 1))
					Mobile.hideKeyboard()
				}
				else if(lastproductnameafterswipe.contains("Ariel Ariel 95gm")){
					textfield.setValue(dataforoverwritehanger.getObjectValue("Ariel Ariel 95gm", 1))
					Mobile.hideKeyboard()
				}
				else if(lastproductnameafterswipe.contains("H&S Classic Clean   5ml")){
					textfield.setValue(dataforoverwritehanger.getObjectValue("H&S Classic Clean 5ml", 1))
					Mobile.hideKeyboard()
				}
				else if(lastproductnameafterswipe.contains("H&S Silky Black 5ml")){
					textfield.setValue(dataforoverwritehanger.getObjectValue("H&S Silky Black 5ml", 1))
					Mobile.hideKeyboard()
				}
				else if(lastproductnameafterswipe.contains("H&S Anti Hair Fall 5ml")){
					textfield.setValue(dataforoverwritehanger.getObjectValue("H&S Anti Hair Fall 5ml", 1))
					Mobile.hideKeyboard()
				}
				else if(lastproductnameafterswipe.contains("Pantene Smooth & Strong 5ml - Sachet")){
					textfield.setValue(dataforoverwritehanger.getObjectValue("Pantene Smooth & Strong 5ml - Sachet", 1))
					Mobile.hideKeyboard()
				}
				else if(lastproductnameafterswipe.contains("Pantene Milky Extra Treatment 5ml")){
					textfield.setValue(dataforoverwritehanger.getObjectValue("Pantene Milky Extra Treatment 5ml", 1))
					Mobile.hideKeyboard()
				}
				else if(lastproductnameafterswipe.contains("H&S Refreshing 5ml")){
					textfield.setValue(dataforvisithanger.getObjectValue("H&S Refreshing 5ml", 1))
					Mobile.hideKeyboard()
				}
				else if(lastproductnameafterswipe.contains("Pantene Anti Hairfall 5ml")){
					textfield.setValue(dataforvisithanger.getObjectValue("Pantene Anti Hairfall 5ml", 1))
					Mobile.hideKeyboard()
				}
			}
		}
	}
	@Keyword
	def takeProductPictureForMarketIntelligence(){
		driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]").click()
		Mobile.delay(1)
	}
}