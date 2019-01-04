package com.ct.qa.keywords

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

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
import com.ct.qa.struct.ShopProductsData
import com.ct.qa.struct.VisitedCategoryData
import com.ct.qa.struct.VisitedCategoryRemarkData

public class ShopVisitingScenariosKeywords{
	def displayDataInReport(){
		String message = "\n\n---------------------------------------------Missing Shop Data-----------------------------------------------------------------------------------------------------\n\n"+
				"<-------------------------------------------------------------------------------------------------------------------------------------->"
		for(int i=0; i<ProjectConstants.missingshopdatainfo.size(); i++){
			boolean flag = false
			MissingShopDataInfo missingshopdatainfo = ProjectConstants.missingshopdatainfo.get(i)
			//shop categories
			if(missingshopdatainfo != null){
				if(missingshopdatainfo.getMissingshopcategories() != null){
					if(flag == false){
						message = message+"\n\n"+
								String.format("%-11s%-60s%-60s","Shop Name:",missingshopdatainfo.getShopname(),missingshopdatainfo.getShopchannel())+"\n\n"+
								String.format("%-30s%-100s", "Visiting Scenarios:",missingshopdatainfo.getScenario())+
								"\n\n" + String.format("%-30s", "Shop Categories:")
						for(int j=0; j<missingshopdatainfo.getMissingshopcategories().size(); j++){
							message = message+missingshopdatainfo.getMissingshopcategories().get(j)+",   "
						}
						message = message+"\n"+missingshopdatainfo.getMissingshopcategories_errormessage() + "\n\n"
						flag = true
					}
					else{
					}
				}
				//category remarks
				if(missingshopdatainfo.getMissingcategoriesdata() != null){
					for(int j=0; j<missingshopdatainfo.getMissingcategoriesdata().size(); j++){
						MissingCategoryData missingcategorydata = missingshopdatainfo.getMissingcategoriesdata().get(j)
						if(missingcategorydata != null){
							ArrayList<String> categoryremarks = missingcategorydata.getMissingcategoryremarksdata()
							if(categoryremarks != null){
								if(flag == false){
									message = message+"\n\n"+
											String.format("%-11s%-60s%-60s","Shop Name:",missingshopdatainfo.getShopname(),missingshopdatainfo.getShopchannel())+"\n\n"+
											String.format("%-30s%-100s", "Visiting Scenarios:",missingshopdatainfo.getScenario())+
											"\n\nCategory Remarks:\n\n" +
											String.format("%-30s%-60s","Main Category:",missingcategorydata.getMaincategory()) + "\n" +
											String.format("%-30s","Category Remarks:")
									for(int n=0; n< categoryremarks.size() ; n++){
										message = message + categoryremarks.get(n) + ",   "
									}
									message = message + "\n" + missingcategorydata.getMissingcategoryremarksdata_errormessage() + "\n\n"
									flag = true
								}
								else{
									message = message +
											"\n\nCategory Remarks:\n\n" +
											String.format("%-30s%-60s","Main Category:",missingcategorydata.getMaincategory()) + "\n" +
											String.format("%-30s","Category Remarks:")
									for(int n=0; n< categoryremarks.size() ; n++){
										message = message + categoryremarks.get(n) + ",   "
									}
									message = message + "\n" + missingcategorydata.getMissingcategoryremarksdata_errormessage() + "\n\n"
								}
							}
						}
					}
				}
				//sub categories
				if(missingshopdatainfo.getMissingcategoriesdata() != null){
					for(int j=0; j<missingshopdatainfo.getMissingcategoriesdata().size(); j++){
						MissingCategoryData missingcategorydata = missingshopdatainfo.getMissingcategoriesdata().get(j)
						if(missingcategorydata != null){
							if(missingcategorydata.getMaincategory().equalsIgnoreCase("HotSpot")){
								ArrayList<String> subcategories = missingcategorydata.getSubcategories()
								if(subcategories != null){
									if(flag == false){
										message = message+"\n\n"+
												String.format("%-11s%-60s%-60s","Shop Name:",missingshopdatainfo.getShopname(),missingshopdatainfo.getShopchannel())+"\n\n"+
												String.format("%-30s%-100s", "Visiting Scenarios:",missingshopdatainfo.getScenario())+
												"\n\nSub Categories:\n\n" +
												String.format("%-30s%-60s","Main Category:",missingcategorydata.getMaincategory()) + "\n" +
												String.format("%-30s","HotSpot Type:")
										for(int n=0; n< subcategories.size() ; n++){
											message = message + subcategories.get(n) + ",   "
										}
										message = message + "\n" + missingcategorydata.getSubcategories_errormessage() + "\n\n"
										flag = true
									}
									else{
										message = message +
												"\n\nSub Categories:\n\n" +
												String.format("%-30s%-60s","Main Category:",missingcategorydata.getMaincategory()) + "\n" +
												String.format("%-30s","HotSpot Type:")
										for(int n=0; n< subcategories.size() ; n++){
											message = message + subcategories.get(n) + ",   "
										}
										message = message + "\n" + missingcategorydata.getSubcategories_errormessage() + "\n\n"
									}
								}
							}
							else if(missingcategorydata.getMaincategory().equalsIgnoreCase("Hanger")){
								ArrayList<String> subcategories = missingcategorydata.getSubcategories()
								if(subcategories != null){
									if(flag == false){
										message = message+"\n\n"+
												String.format("%-11s%-60s%-60s","Shop Name:",missingshopdatainfo.getShopname(),missingshopdatainfo.getShopchannel())+"\n\n"+
												String.format("%-30s%-100s", "Visiting Scenarios:",missingshopdatainfo.getScenario())+
												"\n\nSub Categories:\n\n" +
												String.format("%-30s%-60s","Main Category:",missingcategorydata.getMaincategory()) + "\n" +
												String.format("%-30s","Sub Categories:")
										for(int n=0; n< subcategories.size() ; n++){
											message = message + subcategories.get(n) + ",   "
										}
										message = message + "\n" + missingcategorydata.getSubcategories_errormessage() + "\n\n"
										flag = true
									}
									else{
										message = message +
												"\n\nSub Categories:\n\n" +
												String.format("%-30s%-60s","Main Category:",missingcategorydata.getMaincategory()) + "\n" +
												String.format("%-30s","Sub Categories:")
										for(int n=0; n< subcategories.size() ; n++){
											message = message + subcategories.get(n) + ",   "
										}
										message = message + "\n" + missingcategorydata.getSubcategories_errormessage() + "\n\n"
									}
								}
							}
							else if(missingcategorydata.getMaincategory().equalsIgnoreCase("Survey")){
								ArrayList<String> subcategories = missingcategorydata.getSubcategories()
								if(subcategories != null){
									if(flag == false){
										message = message+"\n\n"+
												String.format("%-11s%-60s%-60s","Shop Name:",missingshopdatainfo.getShopname(),missingshopdatainfo.getShopchannel())+"\n\n"+
												String.format("%-30s%-100s", "Visiting Scenarios:",missingshopdatainfo.getScenario())+
												"\n\nSub Categories:\n\n" +
												String.format("%-30s%-60s","Main Category:",missingcategorydata.getMaincategory()) + "\n" +
												String.format("%-30s","Question Categories:")
										for(int n=0; n< subcategories.size() ; n++){
											message = message + subcategories.get(n) + ",   "
										}
										message = message + "\n" + missingcategorydata.getSubcategories_errormessage() + "\n\n"
										flag = true
									}
									else{
										message = message +
												"\n\nSub Categories:\n\n" +
												String.format("%-30s%-60s","Main Category:",missingcategorydata.getMaincategory()) + "\n" +
												String.format("%-30s","Question Categories:")
										for(int n=0; n< subcategories.size() ; n++){
											message = message + subcategories.get(n) + ",   "
										}
										message = message + "\n" + missingcategorydata.getSubcategories_errormessage() + "\n\n"
									}
								}
							}
							else{
								ArrayList<MissingCategoryRemarkData> missingcategoryremarks = missingcategorydata.getMissingcategoryremarks()
								if(missingcategoryremarks != null){
									for(int n=0; n< missingcategoryremarks.size(); n++){
										MissingCategoryRemarkData missingcategoryremark = missingcategoryremarks.get(n)
										ArrayList<String> missingsubcategories = missingcategoryremark.getSubcategories()
										if(missingsubcategories != null)
										{
											if(flag == false){
												message = message+"\n\n"+
														String.format("%-11s%-60s%-60s","Shop Name:",missingshopdatainfo.getShopname(),missingshopdatainfo.getShopchannel())+"\n\n"+
														String.format("%-30s%-100s", "Visiting Scenarios:",missingshopdatainfo.getScenario())+
														"\n\nSub Categories:\n\n" +
														String.format("%-30s%-60s","Main Category:",missingcategorydata.getMaincategory()) + "\n" +
														String.format("%-30s%-60s","Category Remark:",missingcategoryremark.getCategoryremark()) + "\n" +
														String.format("%-30s","Sub Categories:")
												for(int b=0; b< missingsubcategories.size() ; b++){
													message = message + missingsubcategories.get(b) + ",   "
												}
												message = message + "\n" + missingcategoryremark.getSubcategories_errormessage() + "\n\n"
												flag = true
											}
											else{
												message = message +
														"\n\nSub Categories:\n\n" +
														String.format("%-30s%-60s","Main Category:",missingcategorydata.getMaincategory()) + "\n" +
														String.format("%-30s%-60s","Category Remark:",missingcategoryremark.getCategoryremark()) + "\n" +
														String.format("%-30s","Sub Categories:")
												for(int b=0; b< missingsubcategories.size() ; b++){
													message = message + missingsubcategories.get(b) + ",   "
												}
												message = message + "\n" + missingcategoryremark.getSubcategories_errormessage() + "\n\n"
											}
										}
									}
								}
							}
						}
					}
				}
				//products
				if(missingshopdatainfo.getMissingcategoriesdata() != null){
					for(int j=0; j<missingshopdatainfo.getMissingcategoriesdata().size(); j++){
						MissingCategoryData missingcategorydata = missingshopdatainfo.getMissingcategoriesdata().get(j)
						if(missingcategorydata != null){
							if(missingcategorydata.getMaincategory().equalsIgnoreCase("HotSpot")){
								ArrayList<String> products = missingcategorydata.getProducts()
								if(products != null){
									if(flag == false){
										message = message+"\n\n"+
												String.format("%-11s%-60s%-60s","Shop Name:",missingshopdatainfo.getShopname(),missingshopdatainfo.getShopchannel())+"\n\n"+
												String.format("%-30s%-100s", "Visiting Scenarios:",missingshopdatainfo.getScenario())+
												"\n\nProducts:\n\n" +
												String.format("%-30s%-60s","Main Category:",missingcategorydata.getMaincategory()) + "\n" +
												String.format("%-30s%-60s","HotSpot Type:",missingcategorydata.getSubcategory()) + "\n" +
												String.format("%-30s","HotSpot Products:")
										for(int n=0; n< products.size() ; n++){
											message = message + products.get(n) + ",   "
										}
										message = message + "\n" + missingcategorydata.getProducts_errormessage() + "\n\n"
										flag = true
									}
									else{
										message = message +
												"\n\nProducts:\n\n" +
												String.format("%-30s%-60s","Main Category:",missingcategorydata.getMaincategory()) + "\n" +
												String.format("%-30s%-60s","HotSpot Type:",missingcategorydata.getSubcategory()) + "\n" +
												String.format("%-30s","HotSpot Products:")
										for(int n=0; n< products.size() ; n++){
											message = message + products.get(n) + ",   "
										}
										message = message + "\n" + missingcategorydata.getProducts_errormessage() + "\n\n"
									}
								}
							}
							else if(missingcategorydata.getMaincategory().equalsIgnoreCase("Hanger")){
								ArrayList<String> products = missingcategorydata.getProducts()
								if(products != null){
									if(flag == false){
										message = message+"\n\n"+
												String.format("%-11s%-60s%-60s","Shop Name:",missingshopdatainfo.getShopname(),missingshopdatainfo.getShopchannel())+"\n\n"+
												String.format("%-30s%-100s", "Visiting Scenarios:",missingshopdatainfo.getScenario())+
												"\n\nProducts:\n\n" +
												String.format("%-30s%-60s","Main Category:",missingcategorydata.getMaincategory()) + "\n" +
												String.format("%-30s%-60s","Sub Category:",missingcategorydata.getSubcategory()) + "\n" +
												String.format("%-30s","Products:")
										for(int n=0; n< products.size() ; n++){
											message = message + products.get(n) + ",   "
										}
										message = message + "\n" + missingcategorydata.getProducts_errormessage() + "\n\n"
										flag = true
									}
									else{
										message = message +
												"\n\nProducts:\n\n" +
												String.format("%-30s%-60s","Main Category:",missingcategorydata.getMaincategory()) + "\n" +
												String.format("%-30s%-60s","Sub Category:",missingcategorydata.getSubcategory()) + "\n" +
												String.format("%-30s","Products:")
										for(int n=0; n< products.size() ; n++){
											message = message + products.get(n) + ",   "
										}
										message = message + "\n" + missingcategorydata.getProducts_errormessage() + "\n\n"
									}
								}
							}
							else if(missingcategorydata.getMaincategory().equalsIgnoreCase("Survey")){
								ArrayList<String> products = missingcategorydata.getProducts()
								if(products != null){
									if(flag == false){
										message = message+"\n\n"+
												String.format("%-11s%-60s%-60s","Shop Name:",missingshopdatainfo.getShopname(),missingshopdatainfo.getShopchannel())+"\n\n"+
												String.format("%-30s%-100s", "Visiting Scenarios:",missingshopdatainfo.getScenario())+
												"\n\nProducts:\n\n" +
												String.format("%-30s%-60s","Main Category:",missingcategorydata.getMaincategory()) + "\n" +
												String.format("%-30s%-60s","Question Category:",missingcategorydata.getSubcategory()) + "\n" +
												String.format("%-30s","Questions:")
										for(int n=0; n< products.size() ; n++){
											message = message + products.get(n) + ",   "
										}
										message = message + "\n" + missingcategorydata.getProducts_errormessage() + "\n\n"
										flag = true
									}
									else{
										message = message +
												"\n\nProducts:\n\n" +
												String.format("%-30s%-60s","Main Category:",missingcategorydata.getMaincategory()) + "\n" +
												String.format("%-30s%-60s","Question Category:",missingcategorydata.getSubcategory()) + "\n" +
												String.format("%-30s","Questions:")
										for(int n=0; n< products.size() ; n++){
											message = message + products.get(n) + ",   "
										}
										message = message + "\n" + missingcategorydata.getProducts_errormessage() + "\n\n"
									}
								}
							}
							else{
								ArrayList<MissingCategoryRemarkData> missingcategoryremarks = missingcategorydata.getMissingcategoryremarks()
								if(missingcategoryremarks != null){
									for(int n=0; n< missingcategoryremarks.size(); n++){
										MissingCategoryRemarkData missingcategoryremark = missingcategoryremarks.get(n)
										ArrayList<String> products = missingcategoryremark.getProducts()
										if(products != null){
											if(flag == false){
												message = message+"\n\n"+
														String.format("%-11s%-60s%-60s","Shop Name:",missingshopdatainfo.getShopname(),missingshopdatainfo.getShopchannel())+"\n\n"+
														String.format("%-30s%-100s", "Visiting Scenarios:",missingshopdatainfo.getScenario())+
														"\n\nProducts:\n\n" +
														String.format("%-30s%-60s","Main Category:",missingcategorydata.getMaincategory()) + "\n" +
														String.format("%-30s%-60s","Category Remark:",missingcategoryremark.getCategoryremark()) + "\n" +
														String.format("%-30s%-60s","Sub Category:",missingcategoryremark.getSubcategory()) + "\n" +
														String.format("%-30s","Products:")
												for(int b=0; b< products.size() ; b++){
													message = message + products.get(b) + ",   "
												}
												message = message + "\n" + missingcategoryremark.getProducts_errormessage() + "\n\n"
												flag = true
											}
											else{
												message = message +
														"\n\nProducts:\n\n" +
														String.format("%-30s%-60s","Main Category:",missingcategorydata.getMaincategory()) + "\n" +
														String.format("%-30s%-60s","Category Remark:",missingcategoryremark.getCategoryremark()) + "\n" +
														String.format("%-30s%-60s","Sub Category:",missingcategoryremark.getSubcategory()) + "\n" +
														String.format("%-30s","Products:")
												for(int b=0; b< products.size() ; b++){
													message = message + products.get(b) + ",   "
												}
												message = message + "\n" + missingcategoryremark.getProducts_errormessage() + "\n\n"
											}
										}
									}
								}
							}
						}
					}
				}
				if(flag != false){
					message = message+"\n\n<-------------------------------------------------------------------------------------------------------------------------------------->\n\n"
					KeywordUtil.logInfo(message)
					message = ""
				}
				else{
				}
			}
		}
		message = "\n\n\n---------------------------------------------Visited Shop Data-----------------------------------------------------------------------------------------------------\n\n"+
				"<-------------------------------------------------------------------------------------------------------------------------------------->"
		for(int i=0; i<ProjectConstants.visitedshopdatainfo.size(); i++){
			VisitedShopDataInfo visitedshopdatainfo = ProjectConstants.visitedshopdatainfo.get(i)
			if(visitedshopdatainfo != null){
				message = message+"\n\n"+
						String.format("%-11s%-60s%-60s","Shop Name:",visitedshopdatainfo.getShopname(),visitedshopdatainfo.getShopchannel())+"\n\n"+
						String.format("%-30s%-100s", "Visiting Scenarios:",visitedshopdatainfo.getScenario())
				if(visitedshopdatainfo.getVisitedcategoriesdata() != null){
					for(int j=0; j< visitedshopdatainfo.getVisitedcategoriesdata().size(); j++){
						VisitedCategoryData visitedcategorydata = visitedshopdatainfo.getVisitedcategoriesdata().get(j)
						if(visitedcategorydata.getMaincategory().equalsIgnoreCase("HotSpot")){
							message = message + "\n\n" +
									String.format("%-30s%-60s", "Main Category:",visitedcategorydata.getMaincategory()) + "\n" +
									String.format("%-30s%-60s", "HotSpot Remark With Type:",visitedcategorydata.getFirstvisit_categoryremark()+"  ==>  "+visitedcategorydata.getOverwrite_categoryremark()) + "\n"
							ArrayList<ShopProductsData> shopproductsdata = visitedcategorydata.getShopproductsdata()
							if(shopproductsdata != null){
								message = message +	String.format("%-50s%-30s%-30s", "Products","Facing","Overwrite Facing")+"\n"
								for(int n=0; n< shopproductsdata.size() ; n++){
									ShopProductsData _shopproductsdata = shopproductsdata.get(n)
									message = message + String.format("%-50s%-30s%-30s", _shopproductsdata.getProduct(),_shopproductsdata.getHs_facing(), _shopproductsdata.getOverwrite_hs_facing())+"\n"
								}
								message = message + "\n"
							}
						}
						else if(visitedcategorydata.getMaincategory().equalsIgnoreCase("Hanger")){
							ArrayList<ShopProductsData> shopproductsdata = visitedcategorydata.getShopproductsdata()
							if(shopproductsdata != null){
								message = message + "\n\n" +
										String.format("%-30s%-60s", "Main Category:",visitedcategorydata.getMaincategory()) + "\n" +
										String.format("%-30s%-60s", "Sub Category:",visitedcategorydata.getSubcategory()) + "\n" +
										String.format("%-40s%-22s%-32s%-26s%-36s", "Products","Hanger Available","Overwrite Hanger Available","Hanger Not Available","Overwrite Hanger Not Available")+"\n"
								for(int n=0; n< shopproductsdata.size() ; n++){
									ShopProductsData _shopproductsdata = shopproductsdata.get(n)
									message = message + String.format("%-40s%-22s%-32s%-26s%-36s", _shopproductsdata.getProduct(),_shopproductsdata.getHangeravailable(), _shopproductsdata.getOverwrite_hangeravailable(), _shopproductsdata.getHangernotavailable(), _shopproductsdata.getOverwrite_hangernotavailable())+"\n"
								}
								message = message + "\n"
							}
						}
						else{
							ArrayList<VisitedCategoryRemarkData> visitedcatgoryremarks = visitedcategorydata.getVisitedcategoryremarks()
							if(visitedcatgoryremarks != null){
								for(int b=0; b< visitedcatgoryremarks.size(); b++){
									VisitedCategoryRemarkData visitedcategoryremark = visitedcatgoryremarks.get(b)
									ArrayList<ShopProductsData> shopproductsdata = visitedcategoryremark.getShopproductsdata()
									if(shopproductsdata != null){
										message = message + "\n\n" +
												String.format("%-30s%-60s", "Main Category:",visitedcategorydata.getMaincategory()) + "\n" +
												String.format("%-30s%-60s", "Category Remark:",visitedcategoryremark.getCategoryremark()) + "\n" +
												String.format("%-30s%-60s", "Sub Category:",visitedcategoryremark.getSubcategory()) + "\n" +
												String.format("%-50s%-40s%-40s", "Products","Display Space Available","Overwrite Display Space Available")+"\n"
										for(int n=0; n< shopproductsdata.size() ; n++){
											ShopProductsData _shopproductsdata = shopproductsdata.get(n)
											message = message + String.format("%-50s%-40s%-40s", _shopproductsdata.getProduct(),_shopproductsdata.getPd_displayspaceavailable(), _shopproductsdata.getPd_overwrite_displayspaceavailable())+"\n"
										}
										message = message + "\n"
									}
								}
							}
						}
					}
				}
				message = message + "\n\n<-------------------------------------------------------------------------------------------------------------------------------------->\n\n"
				KeywordUtil.logInfo(message)
				message = ""
			}
		}
	}

	def findShop(String _shopname){
		int index = 0
		int totalshops = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<=totalshops; i++){
			MobileElement shop = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			String shopname = shop.getText()
			if(shopname.equalsIgnoreCase(_shopname)){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				MobileBuiltInKeywords.verifyElementText(findTestObject("Object Repository/Validate_ShopOptionsScreen", [('package') : ProjectConstants.PACKAGENAME]), "Options")
				MobileBuiltInKeywords.tap(findTestObject("Object Repository/StartWorking", [('package') : ProjectConstants.PACKAGENAME]), 0)
				ProjectConstants.visitPopUpForOverwriting()
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
	@Keyword
	def visitShopWithDataVerification(){
		int index = 0
		int totalshops = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<=totalshops; i++){
			MissingShopDataInfo missingshopdatainfo = new MissingShopDataInfo()
			VisitedShopDataInfo visitedshopdatainfo = new VisitedShopDataInfo()
			MobileElement shop = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			ProjectConstants.CURRENTVISITING_SHOPNAME = shop.getText()
			missingshopdatainfo.setShopname(shop.getText())
			visitedshopdatainfo.setShopname(shop.getText())
			ProjectConstants.missingshopdatainfo.add(missingshopdatainfo)
			ProjectConstants.visitedshopdatainfo.add(visitedshopdatainfo)
			ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
			MobileBuiltInKeywords.verifyElementText(findTestObject("Object Repository/Validate_ShopOptionsScreen", [('package') : ProjectConstants.PACKAGENAME]), "Options")
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/StartWorking", [('package') : ProjectConstants.PACKAGENAME]), 0)
			Mobile.delay(15)
			Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_MapScreen", [('package') : ProjectConstants.PACKAGENAME]), 60)
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/Location_CheckIn", [('package') : ProjectConstants.PACKAGENAME]), 0)
			Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_InfoPopUP", [('package') : ProjectConstants.PACKAGENAME]), 0)
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/InfoPopUp_NoButton", [('package') : ProjectConstants.PACKAGENAME]), 0)
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
					String message = "'Scenario given bellow' for chiller utilization\n"+
							String.format("%-30s%-100s","","'Display Space Available' for remaining categories")+"\n"+
							String.format("%-30s%-100s","","'RTM visit frequency' with 'Once a week'")+"\n"+
							String.format("%-30s%-100s","","'Pop Application' with 'No' remark")+"\n"+
							String.format("%-30s%-100s","","'Retailer Remarks' with 'OB not visiting' remark")+"\n"+
							String.format("%-30s%-100s","","'Hanger Availability' with 'Yes' remark")
					ProjectConstants.visitedshopdatainfo.get(j).setScenario(message)
					break
				}
			}
			Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
		}
		//		while(true){
		//			MissingShopDataInfo missingshopdatainfo = new MissingShopDataInfo()
		//			VisitedShopDataInfo visitedshopdatainfo = new VisitedShopDataInfo()
		//			index = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		//			MobileElement lastitembeforeswipe  = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]/android.widget.TextView[1]")
		//			String lastitemnamebeforeswipe = lastitembeforeswipe.getText()
		//			Mobile.swipe(0, 292, 0, 200)
		//			index = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		//			MobileElement lastitemafterswipe = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]/android.widget.TextView[1]")
		//			String lastitemnameafterswipe = lastitemafterswipe.getText()
		//			if(lastitemnamebeforeswipe.equalsIgnoreCase(lastitemnameafterswipe)){
		//				break
		//			}
		//			else{
		//				MobileElement shop = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]/android.widget.TextView[1]")
		//				ProjectConstants.CURRENTVISITING_SHOPNAME = shop.getText()
		//				missingshopdatainfo.setShopname(shop.getText())
		//				visitedshopdatainfo.setShopname(shop.getText())
		//				ProjectConstants.missingshopdatainfo.add(missingshopdatainfo)
		//				ProjectConstants.visitedshopdatainfo.add(visitedshopdatainfo)
		//				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]").click()
		//				MobileBuiltInKeywords.verifyElementText(findTestObject("Object Repository/Validate_ShopOptionsScreen", [('package') : ProjectConstants.PACKAGENAME]), "Options")
		//				MobileBuiltInKeywords.tap(findTestObject("Object Repository/StartWorking", [('package') : ProjectConstants.PACKAGENAME]), 0)
		//				Mobile.delay(15)
		//				Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_MapScreen", [('package') : ProjectConstants.PACKAGENAME]), 60)
		//				MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/Location_CheckIn", [('package') : ProjectConstants.PACKAGENAME]), 0)
		//				Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_InfoPopUP", [('package') : ProjectConstants.PACKAGENAME]), 0)
		//				MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/InfoPopUp_NoButton", [('package') : ProjectConstants.PACKAGENAME]), 0)
		//				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopOpen"), null)
		//				ProjectConstants.SCENARIO = "first visit"
		//				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenarios/VisitShopCategoriesWithDataVerification"), null)
		//				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SaveShop"), null)
		//				for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
		//					if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
		//						ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
		//						ProjectConstants.missingshopdatainfo.get(j).setScenario("Data Verification")
		//						break
		//					}
		//				}
		//				for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
		//					if(ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
		//						ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
		//						String message = "'Scenario given bellow' for chiller utilization\n"+
		//								String.format("%-30s%-100s","","'Display Space Available' for remaining categories")+"\n"+
		//								String.format("%-30s%-100s","","'RTM visit frequency' with 'Once a week'")+"\n"+
		//								String.format("%-30s%-100s","","'Pop Application' with 'No' remark")+"\n"+
		//								String.format("%-30s%-100s","","'Retailer Remarks' with 'OB not visiting' remark")+"\n"+
		//								String.format("%-30s%-100s","","'Hanger Availability' with 'Yes' remark")
		//						ProjectConstants.visitedshopdatainfo.get(j).setScenario(message)
		//						break
		//					}
		//				}
		//				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
		//			}
		//		}
		displayDataInReport()
	}
	@Keyword
	def visitShopsWithShopLevel_OverwriteScenario(){
		int index = 0
		int totalshops = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<=6; i++){
			MissingShopDataInfo missingshopdatainfo = new MissingShopDataInfo()
			VisitedShopDataInfo visitedshopdatainfo = new VisitedShopDataInfo()
			MobileElement shop = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			ProjectConstants.CURRENTVISITING_SHOPNAME = shop.getText()
			missingshopdatainfo.setShopname(shop.getText())
			visitedshopdatainfo.setShopname(shop.getText())
			ProjectConstants.missingshopdatainfo.add(missingshopdatainfo)
			ProjectConstants.visitedshopdatainfo.add(visitedshopdatainfo)
			ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
			MobileBuiltInKeywords.verifyElementText(findTestObject("Object Repository/Validate_ShopOptionsScreen", [('package') : ProjectConstants.PACKAGENAME]), "Options")
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/StartWorking", [('package') : ProjectConstants.PACKAGENAME]), 0)
			Mobile.delay(15)
			Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_MapScreen", [('package') : ProjectConstants.PACKAGENAME]), 60)
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/Location_CheckIn", [('package') : ProjectConstants.PACKAGENAME]), 0)
			Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_InfoPopUP", [('package') : ProjectConstants.PACKAGENAME]), 0)
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/InfoPopUp_NoButton", [('package') : ProjectConstants.PACKAGENAME]), 0)
			// shop closed to shop open
			if(i == 1){
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopOpen"), null)
				ProjectConstants.SCENARIO = "overwrite"
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenarios/VisitShopCategoriesWith_HA_AY_DSA_Available_AIY"), null)
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
						String message = "'HotSpot Available' for HotSpot"+
								String.format("%-30s%-100s", "","'Availability Yes' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Primary Display(Display Space Available)' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available)' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit1:' BROKEN HEADER remark With 50% Utilization for Display Unit Need Maintenance")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit2:' RETURN remark With 50% Utilization for Shopkeeper did not allow")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit3:' RETURN remark With 50% Utilization for Shopkeeper did not allow")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit4:' Display Unit Is In Perfect Condition With 50% Utilization")+"\n"+
								String.format("%-30s%-100s", "","'Additional Info Yes' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Retailer Remarks' with 'OB not visiting' remark")+"\n"+
								String.format("%-30s%-100s", "","'Hanger Availabe' for Hanger")+"\n\n"+
								String.format("%-30s%-100s", "","'No Remark' for Market Intelligence")
						ProjectConstants.visitedshopdatainfo.get(j).setScenario(message)
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
						String message = "visit shop with 'Shop Closed'"
						ProjectConstants.visitedshopdatainfo.get(j).setScenario(message)
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
						String message = "(2) visit shop with 'Shopkeeper did not allow' with 'Others' remark"
						ProjectConstants.visitedshopdatainfo.get(j).setScenario(message)
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
						String message = "(2) visit shop with 'Shop not found'"
						ProjectConstants.visitedshopdatainfo.get(j).setScenario(message)
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
						String message = "(2) visit shop with 'Shop permanently closed'"
						ProjectConstants.visitedshopdatainfo.get(j).setScenario(message)
						break
					}
				}
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			}
			//shop open to shop open
			else if(i == 6){
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopOpen"), null)
				ProjectConstants.SCENARIO = "overwrite"
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenarios/OverwriteShopCategoriesWith_HA_AN_DSA_Available_AIN"), null)
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
						String message = "Overwrite 'HotSpot Available' for HotSpot\n"+
								String.format("%-30s%-100s", "","'Availability No' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","Overwrite 'Primary Display(Display Space Available)' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available)' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit1:' OLD BRAND remark With 100% Utilization for Display Unit Need Maintenance")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit2:' OTHRES remark With 100% Utilization for Shopkeeper did not allow")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit3:' OTHERS remark With 100% Utilization for Shopkeeper did not allow")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit4:' Display Unit Is In Perfect Condition With 100% Utilization")+"\n"+
								String.format("%-30s%-100s", "","'Additional Info No' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Retailer Remarks' with 'SR not visiting' remark")+"\n"+
								String.format("%-30s%-100s", "","Overwrite 'Hanger Availabe' for Hanger")+"\n\n"+
								String.format("%-30s%-100s", "","'Yes Remark' for Market Intelligence")
						ProjectConstants.visitedshopdatainfo.get(j).setScenario(message)
						break
					}
				}
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			}
			else{
				break
			}
		}
		displayDataInReport()
	}
	@Keyword
	def visitShopsWithShopLevel_Overwriting(){
		int index = 0
		int totalshops = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<=6; i++){
			MissingShopDataInfo missingshopdatainfo = new MissingShopDataInfo()
			VisitedShopDataInfo visitedshopdatainfo = new VisitedShopDataInfo()
			MobileElement shop = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			ProjectConstants.CURRENTVISITING_SHOPNAME = shop.getText()
			missingshopdatainfo.setShopname(shop.getText())
			visitedshopdatainfo.setShopname(shop.getText())
			ProjectConstants.missingshopdatainfo.add(missingshopdatainfo)
			ProjectConstants.visitedshopdatainfo.add(visitedshopdatainfo)
			ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
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
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopOpen"), null)
				ProjectConstants.SCENARIO = "overwrite"
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenarios/VisitShopCategoriesWith_HA_AY_DSA_Available_AIY"), null)
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
						String message = "(1) visit shop with 'Shop Closed'\n\n"+
								String.format("%-30s%-100s", "","(2) 'HotSpot Available' for HotSpot")+
								String.format("%-30s%-100s", "","'Availability Yes' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Primary Display(Display Space Available)' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available)' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit1:' BROKEN HEADER remark With 50% Utilization for Display Unit Need Maintenance")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit2:' RETURN remark With 50% Utilization for Shopkeeper did not allow")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit3:' RETURN remark With 50% Utilization for Shopkeeper did not allow")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit4:' Display Unit Is In Perfect Condition With 50% Utilization")+"\n"+
								String.format("%-30s%-100s", "","'Additional Info Yes' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Retailer Remarks' with 'OB not visiting' remark")+"\n"+
								String.format("%-30s%-100s", "","'Hanger Availabe' for Hanger")+"\n\n"+
								String.format("%-30s%-100s", "","'No Remark' for Market Intelligence")
						ProjectConstants.visitedshopdatainfo.get(j).setScenario(message)
						break
					}
				}
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			}
			//shop open to shop closed
			else if(i == 2){
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopOpen"), null)
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenarios/VisitShopCategoriesWith_HA_AY_DSA_Available_AIY"), null)
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
						String message = "(1) 'HotSpot Available' for HotSpot\n\n"+
								String.format("%-30s%-100s", "","'Availability Yes' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Primary Display(Display Space Available)' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available)' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit1:' BROKEN HEADER remark With 50% Utilization for Display Unit Need Maintenance")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit2:' RETURN remark With 50% Utilization for Shopkeeper did not allow")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit3:' RETURN remark With 50% Utilization for Shopkeeper did not allow")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit4:' Display Unit Is In Perfect Condition With 50% Utilization")+"\n"+
								String.format("%-30s%-100s", "","'Additional Info Yes' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Retailer Remarks' with 'OB not visiting' remark")+"\n"+
								String.format("%-30s%-100s", "","'Hanger Availabe' for Hanger")+"\n\n"+
								String.format("%-30s%-100s", "","'No' Remark for Market Intelligence")+"\n\n"+
								String.format("%-30s%-100s","","(2) visit shop with 'Shop Closed'")
						ProjectConstants.visitedshopdatainfo.get(j).setScenario(message)
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
						String message = "(1) visit shop with 'Shop Keeper did not allow' with 'Expiry Issue' remark\n"+
								String.format("%-30s%-100s","","(2) visit shop with 'Shopkeeper did not allow' with 'Others' remark")
						ProjectConstants.visitedshopdatainfo.get(j).setScenario(message)
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
						String message = "(1) visit shop with 'Shop permanently closed'\n"+
								String.format("%-30s%-100s", "","(2) visit shop with 'Shop not found'")
						ProjectConstants.visitedshopdatainfo.get(j).setScenario(message)
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
						String message = "(1) visit shop with 'Shop Closed'\n"+
								String.format("%-30s%-100s", "","(2) visit shop with 'Shop permanently closed'")
						ProjectConstants.visitedshopdatainfo.get(j).setScenario(message)
						break
					}
				}
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			}
			//shop open to shop open
			else if(i == 6){
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopOpen"), null)
				ProjectConstants.SCENARIO = "first visit"
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenarios/VisitShopCategoriesWith_HA_AY_DSA_Available_AIY"), null)
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SaveShop"), null)
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				findShop(ProjectConstants.CURRENTVISITING_SHOPNAME)
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopOpen"), null)
				ProjectConstants.SCENARIO = "overwrite"
				Mobile.callTestCase(findTestCase("ShopOpen/CategoryVisitingScenarios/OverwriteShopCategoriesWith_HA_AN_DSA_Available_AIN"), null)
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
						String message = "(1) 'HotSpot Available' for HotSpot\n"+
								String.format("%-30s%-100s", "","'Availability Yes' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Primary Display(Display Space Available)' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available)' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit1:' BROKEN HEADER remark With 50% Utilization for Display Unit Need Maintenance")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit2:' RETURN remark With 50% Utilization for Shopkeeper did not allow")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit3:' RETURN remark With 50% Utilization for Shopkeeper did not allow")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit4:' Display Unit Is In Perfect Condition With 50% Utilization")+"\n"+
								String.format("%-30s%-100s", "","'Additional Info Yes' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Retailer Remarks' with 'OB not visiting' remark")+"\n"+
								String.format("%-30s%-100s", "","'Hanger Availabe' for Hanger")+"\n\n"+
								String.format("%-30s%-100s", "","'No' Remark for Market Intelligence")+"\n\n"+
								String.format("%-30s%-100s", "","(2) 'HotSpot Available' for HotSpot With Different Values")+"\n"+
								String.format("%-30s%-100s", "","'Availability No' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Primary Display(Display Space Available)' for remaining categories With Different Values")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available)' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit1:' OLD BRAND remark With 100% Utilization for Display Unit Need Maintenance")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit2:' OTHRES remark With 100% Utilization for Shopkeeper did not allow")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit3:' OTHERS remark With 100% Utilization for Shopkeeper did not allow")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit4:' Display Unit Is In Perfect Condition With 100% Utilization")+"\n"+
								String.format("%-30s%-100s", "","'Additional Info No' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Retailer Remarks' with 'SR not visiting' remark")+"\n"+
								String.format("%-30s%-100s", "","'Hanger Availabe' for Hanger With Different Values")+"\n\n"+
								String.format("%-30s%-100s", "","'Yes' Remark for Market Intelligence")
						ProjectConstants.visitedshopdatainfo.get(j).setScenario(message)
						break
					}
				}
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			}
			else{
				break
			}
		}
		displayDataInReport()
	}
	@Keyword
	def visitShopsWithCategoryLevel_OverwriteScenario(){
		int index = 0
		int totalshops = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<=7; i++){
			MissingShopDataInfo missingshopdatainfo = new MissingShopDataInfo()
			VisitedShopDataInfo visitedshopdatainfo = new VisitedShopDataInfo()
			MobileElement shop = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			ProjectConstants.CURRENTVISITING_SHOPNAME = shop.getText()
			missingshopdatainfo.setShopname(shop.getText())
			visitedshopdatainfo.setShopname(shop.getText())
			ProjectConstants.missingshopdatainfo.add(missingshopdatainfo)
			ProjectConstants.visitedshopdatainfo.add(visitedshopdatainfo)
			ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
			MobileBuiltInKeywords.verifyElementText(findTestObject("Object Repository/Validate_ShopOptionsScreen", [('package') : ProjectConstants.PACKAGENAME]), "Options")
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/StartWorking", [('package') : ProjectConstants.PACKAGENAME]), 0)
			Mobile.delay(15)
			Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_MapScreen", [('package') : ProjectConstants.PACKAGENAME]), 60)
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/Location_CheckIn", [('package') : ProjectConstants.PACKAGENAME]), 0)
			Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_InfoPopUP", [('package') : ProjectConstants.PACKAGENAME]), 0)
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/InfoPopUp_NoButton", [('package') : ProjectConstants.PACKAGENAME]), 0)
			//HA_AY_DSA_Available_AIY => HNA_AN_NSFD_NAvailable_AIN
			if(i == 1){
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopOpen"), null)
				ProjectConstants.SCENARIO = "overwrite"
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenarios/VisitShopCategoriesWith_HNA_AN_NSFD_NAvailable_AIN"), null)
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SaveShop"), null)
				for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
					if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.missingshopdatainfo.get(j).setScenario("Overwrite's Scenario Before Overwrite The Category")
						break
					}
				}
				for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
					if(ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						String message = "'HotSpot Not Available' for HotSpot\n"+
								String.format("%-30s%-100s", "","'Availability No' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Primary Display(No Space For Display)' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Not Available)' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Additional Info No' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Retailer Remarks' with 'SR not visiting' remark")+"\n"+
								String.format("%-30s%-100s", "","'Hanger Availabe' for Hanger With Different Values")+"\n\n"+
								String.format("%-30s%-100s", "","'Yes' Remark for Market Intelligence")
						ProjectConstants.visitedshopdatainfo.get(j).setScenario(message)
						break
					}
				}
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			}
			//visit HA_AY_DSA_Available_AIY => overwrite HA_AN_DSA_Available_AIN
			else if(i == 2){
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopOpen"), null)
				ProjectConstants.SCENARIO = "overwrite"
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenarios/OverwriteShopCategoriesWith_HA_AN_DSA_Available_AIN"), null)
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SaveShop"), null)
				for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
					if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.missingshopdatainfo.get(j).setScenario("Overwrite's Scenario Before Overwrite The Category")
						break
					}
				}
				for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
					if(ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						String message = "'HotSpot Available' for HotSpot With Different Values\n"+
								String.format("%-30s%-100s", "","'Availability No' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Primary Display(Display Space Available)' for remaining categories With Different Values")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available)' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit1:' OLD BRAND remark With 100% Utilization for Display Unit Need Maintenance")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit2:' OTHRES remark With 100% Utilization for Shopkeeper did not allow")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit3:' OTHERS remark With 100% Utilization for Shopkeeper did not allow")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit4:' Display Unit Is In Perfect Condition With 100% Utilization")+"\n"+
								String.format("%-30s%-100s", "","'Additional Info No' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Retailer Remarks' with 'SR not visiting' remark")+"\n"+
								String.format("%-30s%-100s", "","'Hanger Availabe' for Hanger With Different Values")+"\n\n"+
								String.format("%-30s%-100s", "","'Yes' Remark for Market Intelligence")
						ProjectConstants.visitedshopdatainfo.get(j).setScenario(message)
						break
					}
				}
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			}
			//visit SKDNA_AY_SKDNA_Available_AIY => overwrite SKDNA_AN_SKDNA_Available_AIN
			else if(i == 3){
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopOpen"), null)
				ProjectConstants.SCENARIO = "overwrite"
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenarios/OverwriteShopCategoriesWith_SKDNA_AN_SKDNA_Available_AIN"), null)
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SaveShop"), null)
				for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
					if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.missingshopdatainfo.get(j).setScenario("Overwrite's Scenario Before Overwrite The Category")
						break
					}
				}
				for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
					if(ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						String message = "'SKDNA' for HotSpot With 'Others' Remark\n"+
								String.format("%-30s%-100s", "","'Availability No' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Primary Display(SKDNA)' for remaining categories With 'Others' Remark")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available)' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit1:' OLD BRAND remark With 100% Utilization for Display Unit Need Maintenance")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit2:' OTHRES remark With 100% Utilization for Shopkeeper did not allow")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit3:' OTHERS remark With 100% Utilization for Shopkeeper did not allow")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit4:' Display Unit Is In Perfect Condition With 100% Utilization")+"\n"+
								String.format("%-30s%-100s", "","'Additional Info No' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Retailer Remarks' with 'SR not visiting' remark")+"\n"+
								String.format("%-30s%-100s", "","'SKDNA' for Hanger With 'Others' Remark")+"\n\n"+
								String.format("%-30s%-100s", "","'Yes' Remark for Market Intelligence")
						ProjectConstants.visitedshopdatainfo.get(j).setScenario(message)
						break
					}
				}
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			}
			//SKDNA_AY_SKDNA_NR_AIN => HA_AN_DSA_NAvailable_AIY
			else if(i == 4){
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopOpen"), null)
				ProjectConstants.SCENARIO = "overwrite"
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenarios/VisitShopCategoriesWith_HA_AN_DSA_NAvailable_AIY"), null)
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SaveShop"), null)
				for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
					if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.missingshopdatainfo.get(j).setScenario("Overwrite's Scenario Before Overwrite The Category")
						break
					}
				}
				for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
					if(ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						//SKDNA_AY_SKDNA_NR_AIN => HA_AN_DSA_NAvailable_AIY
						String message = "'HotSpot Available' for HotSpot\n"+
								String.format("%-30s%-100s", "","'Availability No' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Primary Display(Display Space Available)' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Not Available)' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Additional Info Yes' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Retailer Remarks' with 'SR not visiting' remark")+"\n"+
								String.format("%-30s%-100s", "","'Hanger Availabe' for Hanger")+"\n\n"+
								String.format("%-30s%-100s", "","'Yes' Remark for Market Intelligence")
						ProjectConstants.visitedshopdatainfo.get(j).setScenario(message)
						break
					}
				}
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			}
			//SKDNA_AY_SKDNA_NR_AIN => HNA_AN_NSFD_Available_AIY
			else if(i == 5){
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopOpen"), null)
				ProjectConstants.SCENARIO = "overwrite"
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenarios/VisitShopCategoriesWith_HNA_AN_NSFD_Available_AIY"), null)
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SaveShop"), null)
				for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
					if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.missingshopdatainfo.get(j).setScenario("Overwrite's Scenario Before Overwrite The Category")
						break
					}
				}
				for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
					if(ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						String message = "'HotSpot Not Available' for HotSpot\n"+
								String.format("%-30s%-100s", "","'Availability No' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Primary Display(No Space For Display)' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available)' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit1:' OLD BRAND remark With 100% Utilization for Display Unit Need Maintenance")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit2:' OTHRES remark With 100% Utilization for Shopkeeper did not allow")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit3:' OTHERS remark With 100% Utilization for Shopkeeper did not allow")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit4:' Display Unit Is In Perfect Condition With 100% Utilization")+"\n"+
								String.format("%-30s%-100s", "","'Additional Info Yes' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Retailer Remarks' with 'SR not visiting' remark")+"\n"+
								String.format("%-30s%-100s", "","'Hanger Not Availabe' for Hanger")+"\n\n"+
								String.format("%-30s%-100s", "","'Yes' Remark for Market Intelligence")
						ProjectConstants.visitedshopdatainfo.get(j).setScenario(message)
						break
					}
				}
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			}
			//HNA_AN_NSFD_NAvailable_AIN => HA_AY_DSA_Available_AIY
			else if(i == 6){
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopOpen"), null)
				ProjectConstants.SCENARIO = "overwrite"
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenarios/VisitShopCategoriesWith_HA_AY_DSA_Available_AIY"), null)
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SaveShop"), null)
				for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
					if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.missingshopdatainfo.get(j).setScenario("Overwrite's Scenario Before Overwrite The Category")
						break
					}
				}
				for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
					if(ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						String message = "'HotSpot Available' for HotSpot\n"+
								String.format("%-30s%-100s", "","'Availability Yes' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Primary Display(Display Space Available)' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available)' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit1:' OLD BRAND remark With 100% Utilization for Display Unit Need Maintenance")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit2:' OTHRES remark With 100% Utilization for Shopkeeper did not allow")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit3:' OTHERS remark With 100% Utilization for Shopkeeper did not allow")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit4:' Display Unit Is In Perfect Condition With 100% Utilization")+"\n"+
								String.format("%-30s%-100s", "","'Additional Info Yes' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Retailer Remarks' with 'SR not visiting' remark")+"\n"+
								String.format("%-30s%-100s", "","'Hanger Availabe' for Hanger")+"\n\n"+
								String.format("%-30s%-100s", "","'Yes' Remark for Market Intelligence")
						ProjectConstants.visitedshopdatainfo.get(j).setScenario(message)
						break
					}
				}
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			}
			//HNA_AN_NR_NAvailable_AIN => HA_AY_SKDNA_Available_AIY
			else if(i == 7){
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopOpen"), null)
				ProjectConstants.SCENARIO = "overwrite"
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenarios/VisitShopCategoriesWith_HA_AY_SKDNA_Available_AIY"), null)
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SaveShop"), null)
				for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
					if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.missingshopdatainfo.get(j).setScenario("Overwrite's Scenario Before Overwrite The Category")
						break
					}
				}
				for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
					if(ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						//HNA_AN_NR_NAvailable_AIN => HA_AY_SKDNA_Available_AIY
						String message = "'HotSpot Available' for HotSpot With Different Values\n"+
								String.format("%-30s%-100s", "","'Availability Yes' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Primary Display(SKDNA)' for remaining categories With 'Return' Remark")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available)' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit1:' OLD BRAND remark With 100% Utilization for Display Unit Need Maintenance")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit2:' OTHRES remark With 100% Utilization for Shopkeeper did not allow")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit3:' OTHERS remark With 100% Utilization for Shopkeeper did not allow")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit4:' Display Unit Is In Perfect Condition With 100% Utilization")+"\n"+
								String.format("%-30s%-100s", "","'Additional Info Yes' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Retailer Remarks' with 'SR not visiting' remark")+"\n"+
								String.format("%-30s%-100s", "","'Hanger Availabe' for Hanger")+"\n\n"+
								String.format("%-30s%-100s", "","'Yes' Remark for Market Intelligence")
						ProjectConstants.visitedshopdatainfo.get(j).setScenario(message)
						break
					}
				}
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			}
			else{
				break
			}
		}
		displayDataInReport()
	}
	@Keyword
	def visitShopsWithCategoryLevel_Overwriting(){
		int index = 0
		int totalshops = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<=7; i++){
			MissingShopDataInfo missingshopdatainfo = new MissingShopDataInfo()
			VisitedShopDataInfo visitedshopdatainfo = new VisitedShopDataInfo()
			MobileElement shop = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			ProjectConstants.CURRENTVISITING_SHOPNAME = shop.getText()
			missingshopdatainfo.setShopname(shop.getText())
			visitedshopdatainfo.setShopname(shop.getText())
			ProjectConstants.missingshopdatainfo.add(missingshopdatainfo)
			ProjectConstants.visitedshopdatainfo.add(visitedshopdatainfo)
			ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
			MobileBuiltInKeywords.verifyElementText(findTestObject("Object Repository/Validate_ShopOptionsScreen", [('package') : ProjectConstants.PACKAGENAME]), "Options")
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/StartWorking", [('package') : ProjectConstants.PACKAGENAME]), 0)
			Mobile.delay(15)
			Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_MapScreen", [('package') : ProjectConstants.PACKAGENAME]), 60)
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/Location_CheckIn", [('package') : ProjectConstants.PACKAGENAME]), 0)
			Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_InfoPopUP", [('package') : ProjectConstants.PACKAGENAME]), 0)
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/InfoPopUp_NoButton", [('package') : ProjectConstants.PACKAGENAME]), 0)
			//HA_AY_DSA_Available_AIY => HNA_AN_NSFD_NAvailable_AIN
			if(i == 1){
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopOpen"), null)
				ProjectConstants.SCENARIO = "first visit"
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenarios/VisitShopCategoriesWith_HA_AY_DSA_Available_AIY"), null)
				ProjectConstants.SCENARIO = "overwrite"
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenariosWithOverwritePopup/VisitShopCategoriesWith_HNA_AN_NSFD_NAvailable_AIN"), null)
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SaveShop"), null)
				for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
					if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						String message = "Category Level Overwriting"
						ProjectConstants.missingshopdatainfo.get(j).setScenario(message)
						break
					}
				}
				for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
					if(ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						String message = "(1) 'HotSpot Available' for HotSpot\n"+
								String.format("%-30s%-100s", "","'Availability Yes' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Primary Display(Display Space Available)' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available)' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit1:' BROKEN HEADER remark With 50% Utilization for Display Unit Need Maintenance")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit2:' RETURN remark With 50% Utilization for Shopkeeper did not allow")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit3:' RETURN remark With 50% Utilization for Shopkeeper did not allow")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit4:' Display Unit Is In Perfect Condition With 50% Utilization")+"\n"+
								String.format("%-30s%-100s", "","'Additional Info Yes' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Retailer Remarks' with 'OB not visiting' remark")+"\n"+
								String.format("%-30s%-100s", "","'Hanger Availabe' for Hanger")+"\n\n"+
								String.format("%-30s%-100s", "","'No' Remark for Market Intelligence")+"\n\n"+
								String.format("%-30s%-100s", "","(2) 'HotSpot Not Available' for HotSpot")+"\n"+
								String.format("%-30s%-100s", "","'Availability No' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Primary Display(No Space For Display)' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Not Available)' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Additional Info No' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Retailer Remarks' with 'SR not visiting' remark")+"\n"+
								String.format("%-30s%-100s", "","'Hanger Availabe' for Hanger With Different Values")+"\n\n"+
								String.format("%-30s%-100s", "","'Yes' Remark for Market Intelligence")
						ProjectConstants.visitedshopdatainfo.get(j).setScenario(message)
						break
					}
				}
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			}
			//visit HA_AY_DSA_Available_AIY => overwrite HA_AN_DSA_Available_AIN
			else if(i == 2){
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopOpen"), null)
				ProjectConstants.SCENARIO = "first visit"
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenarios/VisitShopCategoriesWith_HA_AY_DSA_Available_AIY"), null)
				ProjectConstants.SCENARIO = "overwrite"
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenariosWithOverwritePopup/OverwriteShopCategoriesWith_HA_AN_DSA_Available_AIN"), null)
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SaveShop"), null)
				for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
					if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						String message = "Category Level Overwriting"
						ProjectConstants.missingshopdatainfo.get(j).setScenario(message)
						break
					}
				}
				for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
					if(ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						String message = "(1) 'HotSpot Available' for HotSpot\n"+
								String.format("%-30s%-100s", "","'Availability Yes' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Primary Display(Display Space Available)' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available)' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit1:' BROKEN HEADER remark With 50% Utilization for Display Unit Need Maintenance")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit2:' RETURN remark With 50% Utilization for Shopkeeper did not allow")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit3:' RETURN remark With 50% Utilization for Shopkeeper did not allow")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit4:' Display Unit Is In Perfect Condition With 50% Utilization")+"\n"+
								String.format("%-30s%-100s", "","'Additional Info Yes' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Retailer Remarks' with 'OB not visiting' remark")+"\n"+
								String.format("%-30s%-100s", "","'Hanger Availabe' for Hanger")+"\n\n"+
								String.format("%-30s%-100s", "","'No' Remark for Market Intelligence")+"\n\n"+
								String.format("%-30s%-100s", "","(2) 'HotSpot Available' for HotSpot With Different Values")+"\n"+
								String.format("%-30s%-100s", "","'Availability No' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Primary Display(Display Space Available)' for remaining categories With Different Values")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available)' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit1:' OLD BRAND remark With 100% Utilization for Display Unit Need Maintenance")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit2:' OTHRES remark With 100% Utilization for Shopkeeper did not allow")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit3:' OTHERS remark With 100% Utilization for Shopkeeper did not allow")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit4:' Display Unit Is In Perfect Condition With 100% Utilization")+"\n"+
								String.format("%-30s%-100s", "","'Additional Info No' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Retailer Remarks' with 'SR not visiting' remark")+"\n"+
								String.format("%-30s%-100s", "","'Hanger Availabe' for Hanger With Different Values")+"\n\n"+
								String.format("%-30s%-100s", "","'Yes' Remark for Market Intelligence")
						ProjectConstants.visitedshopdatainfo.get(j).setScenario(message)
						break
					}
				}
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			}
			//visit SKDNA_AY_SKDNA_Available_AIY => overwrite SKDNA_AN_SKDNA_Available_AIN
			else if(i == 3){
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopOpen"), null)
				ProjectConstants.SCENARIO = "first visit"
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenarios/VisitShopCategoriesWith_SKDNA_AY_SKDNA_Available_AIY"), null)
				ProjectConstants.SCENARIO = "overwrite"
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenariosWithOverwritePopup/OverwriteShopCategoriesWith_SKDNA_AN_SKDNA_Available_AIN"), null)
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SaveShop"), null)
				for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
					if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						String message = "Category Level Overwriting"
						ProjectConstants.missingshopdatainfo.get(j).setScenario(message)
						break
					}
				}
				for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
					if(ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						String message = "(1) 'SKDNA' for HotSpot With 'Return' Remark\n"+
								String.format("%-30s%-100s", "","'Availability Yes' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Primary Display(SKDNA)' for remaining categories With 'Return' Remark")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available)' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit1:' BROKEN HEADER remark With 50% Utilization for Display Unit Need Maintenance")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit2:' RETURN remark With 50% Utilization for Shopkeeper did not allow")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit3:' RETURN remark With 50% Utilization for Shopkeeper did not allow")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit4:' Display Unit Is In Perfect Condition With 50% Utilization")+"\n"+
								String.format("%-30s%-100s", "","'Additional Info Yes' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Retailer Remarks' with 'OB not visiting' remark")+"\n"+
								String.format("%-30s%-100s", "","'SKDNA' for Hanger With 'Return' Remark")+"\n\n"+
								String.format("%-30s%-100s", "","'No' Remark for Market Intelligence")+"\n\n"+
								String.format("%-30s%-100s", "","(2) 'SKDNA' for HotSpot With 'Others' Remark")+"\n"+
								String.format("%-30s%-100s", "","'Availability No' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Primary Display(SKDNA)' for remaining categories With 'Others' Remark")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available)' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit1:' OLD BRAND remark With 100% Utilization for Display Unit Need Maintenance")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit2:' OTHRES remark With 100% Utilization for Shopkeeper did not allow")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit3:' OTHERS remark With 100% Utilization for Shopkeeper did not allow")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit4:' Display Unit Is In Perfect Condition With 100% Utilization")+"\n"+
								String.format("%-30s%-100s", "","'Additional Info No' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Retailer Remarks' with 'SR not visiting' remark")+"\n"+
								String.format("%-30s%-100s", "","'SKDNA' for Hanger With 'Others' Remark")+"\n\n"+
								String.format("%-30s%-100s", "","'Yes' Remark for Market Intelligence")
						ProjectConstants.visitedshopdatainfo.get(j).setScenario(message)
						break
					}
				}
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			}
			//SKDNA_AY_SKDNA_NR_AIN => HA_AN_DSA_NAvailable_AIY
			else if(i == 4){
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopOpen"), null)
				ProjectConstants.SCENARIO = "first visit"
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenarios/VisitShopCategoriesWith_SKDNA_AY_SKDNA_NR_AIN"), null)
				ProjectConstants.SCENARIO = "overwrite"
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenariosWithOverwritePopup/VisitShopCategoriesWith_HA_AN_DSA_NAvailable_AIY"), null)
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SaveShop"), null)
				for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
					if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						String message = "Category Level Overwriting"
						ProjectConstants.missingshopdatainfo.get(j).setScenario(message)
						break
					}
				}
				for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
					if(ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						//SKDNA_AY_SKDNA_NR_AIN => HA_AN_DSA_NAvailable_AIY
						String message = "(1) 'SKDNA' for HotSpot With 'Return' Remark\n"+
								String.format("%-30s%-100s", "","'Availability Yes' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Primary Display(SKDNA)' for remaining categories With 'Return' Remark")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Not Available)' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Additional Info No' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Retailer Remarks' with 'OB not visiting' remark")+"\n"+
								String.format("%-30s%-100s", "","'SKDNA' for Hanger With 'Return' Remark")+"\n\n"+
								String.format("%-30s%-100s", "","'No' Remark for Market Intelligence")+"\n\n"+
								String.format("%-30s%-100s", "","(2) 'HotSpot Available' for HotSpot")+"\n"+
								String.format("%-30s%-100s", "","'Availability No' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Primary Display(Display Space Available)' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Not Available)' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Additional Info Yes' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Retailer Remarks' with 'SR not visiting' remark")+"\n"+
								String.format("%-30s%-100s", "","'Hanger Availabe' for Hanger")+"\n\n"+
								String.format("%-30s%-100s", "","'Yes' Remark for Market Intelligence")
						ProjectConstants.visitedshopdatainfo.get(j).setScenario(message)
						break
					}
				}
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			}
			//SKDNA_AY_SKDNA_NR_AIN => HNA_AN_NSFD_Available_AIY
			else if(i == 5){
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopOpen"), null)
				ProjectConstants.SCENARIO = "first visit"
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenarios/VisitShopCategoriesWith_SKDNA_AY_SKDNA_NR_AIN"), null)
				ProjectConstants.SCENARIO = "overwrite"
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenariosWithOverwritePopup/VisitShopCategoriesWith_HNA_AN_NSFD_Available_AIY"), null)
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SaveShop"), null)
				for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
					if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						String message = "Category Level Overwriting"
						ProjectConstants.missingshopdatainfo.get(j).setScenario(message)
						break
					}
				}
				for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
					if(ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						String message = "(1) 'SKDNA' for HotSpot With 'Return' Remark\n"+
								String.format("%-30s%-100s", "","'Availability Yes' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Primary Display(SKDNA)' for remaining categories With 'Return' Remark")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Not Available)' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Additional Info No' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Retailer Remarks' with 'OB not visiting' remark")+"\n"+
								String.format("%-30s%-100s", "","'SKDNA' for Hanger With 'Return' Remark")+"\n\n"+
								String.format("%-30s%-100s", "","'No' Remark for Market Intelligence")+"\n\n"+
								String.format("%-30s%-100s", "","(2) 'HotSpot Not Available' for HotSpot")+"\n"+
								String.format("%-30s%-100s", "","'Availability No' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Primary Display(No Space For Display)' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available)' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit1:' OLD BRAND remark With 100% Utilization for Display Unit Need Maintenance")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit2:' OTHRES remark With 100% Utilization for Shopkeeper did not allow")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit3:' OTHERS remark With 100% Utilization for Shopkeeper did not allow")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit4:' Display Unit Is In Perfect Condition With 100% Utilization")+"\n"+
								String.format("%-30s%-100s", "","'Additional Info Yes' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Retailer Remarks' with 'SR not visiting' remark")+"\n"+
								String.format("%-30s%-100s", "","'Hanger Not Availabe' for Hanger")+"\n\n"+
								String.format("%-30s%-100s", "","'Yes' Remark for Market Intelligence")
						ProjectConstants.visitedshopdatainfo.get(j).setScenario(message)
						break
					}
				}
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			}
			//HNA_AN_NSFD_NAvailable_AIN => HA_AY_DSA_Available_AIY
			else if(i == 6){
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopOpen"), null)
				ProjectConstants.SCENARIO = "first visit"
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenarios/VisitShopCategoriesWith_HNA_AN_NSFD_NAvailable_AIN"), null)
				ProjectConstants.SCENARIO = "overwrite"
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenariosWithOverwritePopup/VisitShopCategoriesWith_HA_AY_DSA_Available_AIY"), null)
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SaveShop"), null)
				for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
					if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						String message = "Category Level Overwriting"
						ProjectConstants.missingshopdatainfo.get(j).setScenario(message)
						break
					}
				}
				for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
					if(ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						String message = "(1) 'HotSpot Not Available' for HotSpot\n"+
								String.format("%-30s%-100s", "","'Availability No' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Primary Display(No Space For Display)' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Not Available)' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Additional Info No' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Retailer Remarks' with 'OB not visiting' remark")+"\n"+
								String.format("%-30s%-100s", "","'Hanger Not Availabe' for Hanger")+"\n\n"+
								String.format("%-30s%-100s", "","'No' Remark for Market Intelligence")+"\n\n"+
								String.format("%-30s%-100s", "","(2) 'HotSpot Available' for HotSpot")+"\n"+
								String.format("%-30s%-100s", "","'Availability Yes' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Primary Display(Display Space Available)' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available)' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit1:' OLD BRAND remark With 100% Utilization for Display Unit Need Maintenance")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit2:' OTHRES remark With 100% Utilization for Shopkeeper did not allow")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit3:' OTHERS remark With 100% Utilization for Shopkeeper did not allow")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit4:' Display Unit Is In Perfect Condition With 100% Utilization")+"\n"+
								String.format("%-30s%-100s", "","'Additional Info Yes' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Retailer Remarks' with 'SR not visiting' remark")+"\n"+
								String.format("%-30s%-100s", "","'Hanger Availabe' for Hanger")+"\n\n"+
								String.format("%-30s%-100s", "","'Yes' Remark for Market Intelligence")
						ProjectConstants.visitedshopdatainfo.get(j).setScenario(message)
						break
					}
				}
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			}
			//HNA_AN_NR_NAvailable_AIN => HA_AY_SKDNA_Available_AIY
			else if(i == 7){
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopOpen"), null)
				ProjectConstants.SCENARIO = "first visit"
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenarios/VisitShopCategoriesWith_HNA_AN_NR_NAvailable_AIN"), null)
				ProjectConstants.SCENARIO = "overwrite"
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenariosWithOverwritePopup/VisitShopCategoriesWith_HA_AY_SKDNA_Available_AIY"), null)
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SaveShop"), null)
				for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
					if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						String message = "Category Level Overwriting"
						ProjectConstants.missingshopdatainfo.get(j).setScenario(message)
						break
					}
				}
				for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
					if(ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						//HNA_AN_NR_NAvailable_AIN => HA_AY_SKDNA_Available_AIY
						String message = "(1) 'HotSpot Not Available' for HotSpot\n"+
								String.format("%-30s%-100s", "","'Availability No' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Primary Display(Not Recommended)' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Not Available)' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Additional Info No' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Retailer Remarks' with 'OB not visiting' remark")+"\n"+
								String.format("%-30s%-100s", "","'Hanger Not Availabe' for Hanger")+"\n\n"+
								String.format("%-30s%-100s", "","'No' Remark for Market Intelligence")+"\n\n"+
								String.format("%-30s%-100s", "","(2) 'HotSpot Available' for HotSpot With Different Values")+"\n"+
								String.format("%-30s%-100s", "","'Availability Yes' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Primary Display(SKDNA)' for remaining categories With 'Return' Remark")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available)' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit1:' OLD BRAND remark With 100% Utilization for Display Unit Need Maintenance")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit2:' OTHRES remark With 100% Utilization for Shopkeeper did not allow")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit3:' OTHERS remark With 100% Utilization for Shopkeeper did not allow")+"\n"+
								String.format("%-30s%-100s", "","'Secondary Display(Available) Unit4:' Display Unit Is In Perfect Condition With 100% Utilization")+"\n"+
								String.format("%-30s%-100s", "","'Additional Info Yes' for remaining categories")+"\n"+
								String.format("%-30s%-100s", "","'Retailer Remarks' with 'SR not visiting' remark")+"\n"+
								String.format("%-30s%-100s", "","'Hanger Availabe' for Hanger")+"\n\n"+
								String.format("%-30s%-100s", "","'Yes' Remark for Market Intelligence")
						ProjectConstants.visitedshopdatainfo.get(j).setScenario(message)
						break
					}
				}
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			}
			else{
				break
			}
		}
		displayDataInReport()
	}
}
