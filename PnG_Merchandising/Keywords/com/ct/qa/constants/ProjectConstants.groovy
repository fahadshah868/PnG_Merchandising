package com.ct.qa.constants

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.ct.qa.keywords.LoadDataKeywords
import com.ct.qa.struct.MissingShopDataInfo
import com.ct.qa.struct.MissingSliderOptions
import com.ct.qa.struct.UnmatchedProducts
import com.ct.qa.struct.VisitedShopDataInfo
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
import org.apache.poi.ss.usermodel.DataFormatter
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.openqa.selenium.Point
import org.openqa.selenium.remote.server.handler.AcceptAlert

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

public class ProjectConstants {

	//variables for excel file and sheets
	public static final String EXCEL_FILEPATH = "G:\\PnG_Merchandising.xlsx"
	public static final String CHANNEL_PRODUCTSSHEET = "Channel Products"
	public static final String HOTSPOT_PRODUCTSSHEET = "Hotspot Products"
	public static final String DISTRIBUTION_SHEET = "Distribution Point"
	public static final String SLIDEROPTIONSSHEET = "Slider Options"

	public static final AppiumDriver<MobileElement> DRIVER = MobileDriverFactory.getDriver()


	//variables for display messages
	//products comparison messages
	public static final String MESSAGEFOR_PRODUCTSARE_MORE = "above products are displaying on device more than to expected products..."
	public static final String MESSAGEFOR_PRODUCTSARE_MISSING = "above products are missing on device..."
	public static final String MESSAGEFOR_PRODUCTSARE_NOTMATCH = "above products are display on device not match with expected products..."

	public static final String MESSAGEFOR_DISPLAYEDPRODUCTSARE_EQUAL = "displayed products are equals to expected products..."

	//products categories comparison messages
	public static final String MESSAGEFOR_PRODUCTSCATEGORIESARE_MORE = "above products categories are displaying on device more than to expected products..."
	public static final String MESSAGEFOR_PRODUCTSCATEGORIESARE_MISSING = "above products categories are missing on device"
	public static final String MESSAGEFOR_PRODUCTSCATEGORIESARE_NOTMATCH = "above products categories are displaying on device not matching with expected products..."

	//shop categories comparison messages
	public static final String MESSAGEFOR_SHOPCATEGORIESARE_MORE = "above shop categories are displaying on device more than to expected shop categories"
	public static final String MESSAGEFOR_SHOPCATEGORIESARE_MISSING = "above shop categories are missing on device"
	public static final String MESSAGEFOR_SHOPCATEGORIESARE_NOTMATCH = "above shop categories are displaying on device not matching with expected shop categories"

	//slider options comparison messages
	public static final String MESSAGEFOR_SLIDEROPTIONSARE_MORE = "above slider options are displaying on device more than to expected slider options"
	public static final String MESSAGEFOR_SLIDEROPTIONSARE_MISSING = "above slider options are missing on device"
	public static final String MESSAGEFOR_SLIDEROPTIONSARE_NOTMATCH = "above slider options are displaying on device not matching with expected slider options"

	//package name for objects
	public static final String PACKAGENAME = "com.concavetech.bloc"

	//variables for excel sheet columns index
	//channel wise product columns
	public static final int CHANNEL
	public static final int MAINCATEGORY
	public static final int PRODUCTCATEGORY
	public static final int CHANNELPRODUCT
	public static final int DISPLAYSPACEAVAILABLE
	public static final int OVERWRITEDISPLAYSPACEAVAILABLE

	//hotspot product columns
	public static final int HOTSPOTTYPE
	public static final int HOTSPOTPRODUCT
	public static final int HOTSPOTFACING
	public static final int OVERWRITEHOTSPOTFACING

	//hanger products columns
	public static final int HANGERAVAILABLE
	public static final int HANGERNOTAVAILABLE
	public static final int OVERWRITEHANGERAVAILABLE
	public static final int OVERWRITEHANGERNOTAVAILABLE


	//slider options columns
	public static final int SLIDEROPTIONS

	//variables for current visiting shop channels, chiller and categories
	public static String CURRENTVISITING_SHOPNAME = ""
	public static String CURRENTVISITING_SHOPCHANNEL = ""
	public static String CURRENTVISITING_MAINCATEGORY = ""
	public static String CURRENTVISITING_PRODUCTCATEGORY = ""
	public static String CURRENTVISITING_HOTSPOTTYPE = ""
	public static String CURRENTVISITING_HANGER = ""
	public static String SCENARIO = ""
	public static int HOTSPOTINDEX = 0

	//list for containing shop info
	public static ArrayList<MissingShopDataInfo> missingshopdatainfo = new ArrayList<MissingShopDataInfo>()
	public static ArrayList<VisitedShopDataInfo> visitedshopdatainfo = new ArrayList<MissingShopDataInfo>()
	public static MissingSliderOptions missingslideroptions = new MissingSliderOptions()

	//initialization of sheet columns index
	static{
		XSSFSheet channelproductssheet = LoadDataKeywords.loadChannelProductsSheet()
		XSSFSheet hotspotproductssheet = LoadDataKeywords.loadHotSpotProductsSheet()
		XSSFSheet slideroptionssheet = LoadDataKeywords.loadSliderOptionsSheet()
		Row channelproductssheetheaderrow = channelproductssheet.getRow(0)
		Row hotspotproductssheetheaderrow = hotspotproductssheet.getRow(0)
		Row slideroptionssheetheaderrow = slideroptionssheet.getRow(0)
		int channelproductssheettotalcolumns = channelproductssheetheaderrow.getLastCellNum()
		int hotspotproductssheettotalcolumns = hotspotproductssheetheaderrow.getLastCellNum()
		int slideroptionssheettotalcolumns = slideroptionssheetheaderrow.getLastCellNum()
		for(int cellnumber=0; cellnumber<channelproductssheettotalcolumns; cellnumber++){
			String columnname = channelproductssheetheaderrow.getCell(cellnumber)
			if(columnname.equalsIgnoreCase("Channel")){
				CHANNEL = cellnumber
			}
			else if(columnname.equalsIgnoreCase("Main Category")){
				MAINCATEGORY = cellnumber
			}
			else if(columnname.equalsIgnoreCase("Product Category")){
				PRODUCTCATEGORY = cellnumber
			}
			else if(columnname.equalsIgnoreCase("Product")){
				CHANNELPRODUCT = cellnumber
			}
			else if(columnname.equalsIgnoreCase("Display Space Available")){
				DISPLAYSPACEAVAILABLE = cellnumber
			}
			else if(columnname.equalsIgnoreCase("Overwrite Display Space Available")){
				OVERWRITEDISPLAYSPACEAVAILABLE = cellnumber
			}
			else if(columnname.equalsIgnoreCase("Hanger Available")){
				HANGERAVAILABLE = cellnumber
			}
			else if(columnname.equalsIgnoreCase("Hanger Not Available")){
				HANGERNOTAVAILABLE = cellnumber
			}
			else if(columnname.equalsIgnoreCase("Overwrite Hanger Available")){
				OVERWRITEHANGERAVAILABLE = cellnumber
			}
			else if(columnname.equalsIgnoreCase("Overwrite Hanger Not Available")){
				OVERWRITEHANGERNOTAVAILABLE = cellnumber
			}
		}
		for(int cellnumber=0; cellnumber<hotspotproductssheettotalcolumns; cellnumber++){
			String columnname = hotspotproductssheetheaderrow.getCell(cellnumber)
			if(columnname.equalsIgnoreCase("Hotspot Type")){
				HOTSPOTTYPE = cellnumber
			}
			else if(columnname.equalsIgnoreCase("Product")){
				HOTSPOTPRODUCT = cellnumber
			}
			else if(columnname.equalsIgnoreCase("Facing")){
				HOTSPOTFACING = cellnumber
			}
			else if(columnname.equalsIgnoreCase("Overwrite Facing")){
				OVERWRITEHOTSPOTFACING = cellnumber
			}
		}
		for(int cellnumber=0; cellnumber<slideroptionssheettotalcolumns; cellnumber++ ){
			String columnname = slideroptionssheetheaderrow.getCell(cellnumber)
			if(columnname.equalsIgnoreCase("Slider Options")){
				SLIDEROPTIONS = cellnumber
			}
			else{
			}
		}
	}
	def static getXPoint(){
		Point point = DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]").getLocation()
		int xlocation = point.getX()
		return xlocation+1
	}
	def static visitPopUpForOverwriting(){
		Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_InfoPopUP"), 0, FailureHandling.OPTIONAL)
		Mobile.tap(findTestObject("Object Repository/CommonScreenElements/InfoPopUp_YesButton"), 0, FailureHandling.OPTIONAL)
	}
}
