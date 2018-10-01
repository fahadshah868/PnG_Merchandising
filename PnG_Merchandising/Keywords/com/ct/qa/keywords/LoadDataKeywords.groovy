package com.ct.qa.keywords

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.ct.qa.constants.ProjectConstants
import com.ct.qa.struct.ProductWithValue
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
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
import org.apache.poi.ss.usermodel.DataFormatter
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

public class LoadDataKeywords {
	//load channel wise products sheet
	def static loadChannelProductsSheet(){
		try{
			FileInputStream inputStream = new FileInputStream(new File(ProjectConstants.EXCEL_FILEPATH))
			XSSFWorkbook wb = new XSSFWorkbook(inputStream)
			XSSFSheet sheet = wb.getSheet(ProjectConstants.CHANNEL_PRODUCTSSHEET)
			return sheet
		}
		catch(Exception ex){
		}
	}
	//load distribution point sheet
	def static loadDistributionPointSheet(){
		try{
			FileInputStream inputStream = new FileInputStream(new File(ProjectConstants.EXCEL_FILEPATH))
			XSSFWorkbook wb = new XSSFWorkbook(inputStream)
			XSSFSheet sheet = wb.getSheet(ProjectConstants.DISTRIBUTION_SHEET)
			return sheet
		}
		catch(Exception ex){
		}
	}
	//load HotSopt sheet
	def static loadHotSpotProductsSheet(){
		try{
			FileInputStream inputStream = new FileInputStream(new File(ProjectConstants.EXCEL_FILEPATH))
			XSSFWorkbook wb = new XSSFWorkbook(inputStream)
			XSSFSheet sheet = wb.getSheet(ProjectConstants.HOTSPOT_PRODUCTSSHEET)
			return sheet
		}
		catch(Exception ex){
		}
	}
	//load Slider Options sheet
	def static loadSliderOptionsSheet(){
		try{
			FileInputStream inputStream = new FileInputStream(new File(ProjectConstants.EXCEL_FILEPATH))
			XSSFWorkbook wb = new XSSFWorkbook(inputStream)
			XSSFSheet sheet = wb.getSheet(ProjectConstants.SLIDEROPTIONSSHEET)
			return sheet
		}
		catch(Exception ex){
		}
	}
	//load shop categories
	def static loadShopCategories(){
		DataFormatter dataformatter = new DataFormatter()
		ArrayList<String> expectedshopcategories = new ArrayList<String>()
		XSSFSheet sheet = loadChannelProductsSheet()
		int totalrows = sheet.getLastRowNum()
		for(int i=1; i<=totalrows; i++){
			Row row = sheet.getRow(i)
			String channel = dataformatter.formatCellValue(row.getCell(ProjectConstants.CHANNEL))
			String channelname = "Channel: "+channel
			if(ProjectConstants.CURRENTVISITING_SHOPCHANNEL.equalsIgnoreCase(channelname)){
				String category = dataformatter.formatCellValue(row.getCell(ProjectConstants.MAINCATEGORY))
				expectedshopcategories.add(category)
			}
		}
		return expectedshopcategories
	}
	//load channel wise products and quantity
	def static loadChannelWiseProductsList(XSSFSheet sheet, int column){
		DataFormatter dataformatter = new DataFormatter()
		ArrayList<ProductWithValue> productswithvalue = new ArrayList<ProductWithValue>()
		int totalrows = sheet.getLastRowNum()
		for(int i=1; i<=totalrows; i++){
			Row row = sheet.getRow(i)
			String channel = dataformatter.formatCellValue(row.getCell(ProjectConstants.CHANNEL))
			String channelname = "Channel: "+channel
			String maincategory = dataformatter.formatCellValue(row.getCell(ProjectConstants.MAINCATEGORY))
			String productcategory = dataformatter.formatCellValue(row.getCell(ProjectConstants.PRODUCTCATEGORY))
			
			String chann = ProjectConstants.CURRENTVISITING_SHOPCHANNEL
			String maincat = ProjectConstants.CURRENTVISITING_MAINCATEGORY
			String procat = ProjectConstants.CURRENTVISITING_PRODUCTCATEGORY
			
			if((ProjectConstants.CURRENTVISITING_SHOPCHANNEL.equalsIgnoreCase(channelname) && ProjectConstants.CURRENTVISITING_MAINCATEGORY.equalsIgnoreCase(maincategory)) && ProjectConstants.CURRENTVISITING_PRODUCTCATEGORY.equalsIgnoreCase(productcategory)){
				ProductWithValue productwithvalue = new ProductWithValue()
				String product = dataformatter.formatCellValue(row.getCell(ProjectConstants.CHANNELPRODUCT))
				String columndata = dataformatter.formatCellValue(row.getCell(column))
				productwithvalue.setProduct(product)
				productwithvalue.setProduct_value(columndata)
				productswithvalue.add(productwithvalue)
			}
			else{
			}
		}
		return productswithvalue
	}
	//load hotspot products and quantity
	def static loadHotSpotProductsList(XSSFSheet sheet, int column){
		DataFormatter dataformatter = new DataFormatter()
		ArrayList<ProductWithValue> productswithvalue = new ArrayList<ProductWithValue>()
		int totalrows = sheet.getLastRowNum()
		for(int i=1; i<=totalrows; i++){
			Row row = sheet.getRow(i)
			String hotspottype = dataformatter.formatCellValue(row.getCell(ProjectConstants.HOTSPOTTYPE))
			if(ProjectConstants.CURRENTVISITING_HOTSPOTTYPE.equalsIgnoreCase(hotspottype)){
				ProductWithValue productwithvalue = new ProductWithValue()
				String product = dataformatter.formatCellValue(row.getCell(ProjectConstants.HOTSPOTPRODUCT))
				String columndata = dataformatter.formatCellValue(row.getCell(column))
				productwithvalue.setProduct(product)
				productwithvalue.setProduct_value(columndata)
				productswithvalue.add(productwithvalue)
			}
			else{
			}
		}
		return productswithvalue
	}
	def static loadSliderOptions(){
		DataFormatter dataformatter = new DataFormatter()
		XSSFSheet sheet = loadSliderOptionsSheet()
		int totalrows = sheet.getLastRowNum()
		ArrayList<String> slideroptions = new ArrayList<String>()
		for(int i=1; i<=totalrows; i++){
			Row row = sheet.getRow(i)
			slideroptions.add(dataformatter.formatCellValue(row.getCell(ProjectConstants.SLIDEROPTIONS)))
		}
		return slideroptions
	}
}
