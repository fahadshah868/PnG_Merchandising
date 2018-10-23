package com.ct.qa.keywords

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.ct.qa.constants.ProjectConstants
import com.ct.qa.struct.MissingCategoryData
import com.ct.qa.struct.MissingCategoryRemarkData
import com.ct.qa.struct.UnmatchedItems
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import io.appium.java_client.MobileElement

public class RemainingMainCategoryRemarksVisitingScenariosKeywords {

	@Keyword
	def visitRemarksWith_DataVerification(){
		UnmatchedItems UnmatchedItems_status = CompareDataKeywords.compareShopRemainingCategoryRemarks()
		if(UnmatchedItems_status.getStatus() == 2){
			MissingCategoryData missingcategory = new MissingCategoryData()
			missingcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategory.setMissingcategoryremarksdata(UnmatchedItems_status.getItems())
			missingcategory.setMissingcategoryremarksdata_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_NOTMATCH)
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
			missingcategory.setMissingcategoryremarksdata(UnmatchedItems_status.getItems())
			missingcategory.setMissingcategoryremarksdata_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MORE)
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
			missingcategory.setMissingcategoryremarksdata(UnmatchedItems_status.getItems())
			missingcategory.setMissingcategoryremarksdata_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MISSING)
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
		int totalactions = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<= totalactions; i++){
			MobileElement action = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			String actionname = action.getText()
			ProjectConstants.CURRENTVISITING_REMAININGCATEOGRYREMARK = actionname
			if(actionname.equalsIgnoreCase("Availability")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/Availability/VisitAvailability_WithYesRemark"), null)
			}
			else if(actionname.equalsIgnoreCase("Primary Display")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/PrimaryDisplay/DisplaySpaceAvailable/VisitDSA"), null)
			}
			else if(actionname.equalsIgnoreCase("Secondary Display")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/SecondaryDisplay/SecondaryDisplayAvailable_VisitingScenarios/VisitSecondaryDisplayAvailable"), null)
			}
			else if(actionname.equalsIgnoreCase("Additional Info")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.callTestCase(findTestCase("ShopOpen/RemainingMainCategories/AdditionalInfo/VisitAdditionalInfoWith_YesRemark"), null)
			}
		}
	}
	@Keyword
	def visitRemarksWith_AN_DSA_NAvailable_AIY(){
		int totalactions = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<= totalactions; i++){
			MobileElement action = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			String actionname = action.getText()
			if(actionname.equalsIgnoreCase("Availability")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/Availability/VisitAvailability_WithNoRemark"), null)
			}
			else if(actionname.equalsIgnoreCase("Primary Display")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/PrimaryDisplay/DisplaySpaceAvailable/VisitDSA"), null)
			}
			else if(actionname.equalsIgnoreCase("Secondary Display")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/SecondaryDisplay/NotAvailable/VisitNotAvailable"), null)
			}
			else if(actionname.equalsIgnoreCase("Additional Info") && ProjectConstants.CURRENTVISITING_SHOPNAME.contains("MM")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.callTestCase(findTestCase("ShopOpen/RemainingMainCategories/AdditionalInfo/VisitAdditionalInfoWith_YesRemark"), null)
			}
		}
	}
	@Keyword
	def visitRemarksWith_AN_NR_NAvailable_AIN(){
		int totalactions = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<= totalactions; i++){
			MobileElement action = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			String actionname = action.getText()
			if(actionname.equalsIgnoreCase("Availability")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/Availability/VisitAvailability_WithNoRemark"), null)
			}
			else if(actionname.equalsIgnoreCase("Primary Display")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/PrimaryDisplay/NotRecommanded/VisitNotRecommended"), null)
			}
			else if(actionname.equalsIgnoreCase("Secondary Display")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/SecondaryDisplay/NotAvailable/VisitNotAvailable"), null)
			}
			else if(actionname.equalsIgnoreCase("Additional Info") && ProjectConstants.CURRENTVISITING_SHOPNAME.contains("MM")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.callTestCase(findTestCase("ShopOpen/RemainingMainCategories/AdditionalInfo/VisitAdditionalInfoWith_NoRemark"), null)
			}
		}
	}
	@Keyword
	def visitRemarksWith_AN_NSFD_Available_AIY(){
		int totalactions = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<= totalactions; i++){
			MobileElement action = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			String actionname = action.getText()
			if(actionname.equalsIgnoreCase("Availability")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/Availability/VisitAvailability_WithNoRemark"), null)
			}
			else if(actionname.equalsIgnoreCase("Primary Display")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/PrimaryDisplay/NoSpaceForDisplay/VisitNSFD"), null)
			}
			else if(actionname.equalsIgnoreCase("Secondary Display")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/SecondaryDisplay/SecondaryDisplayAvailable_VisitingScenarios/VisitSecondaryDisplayAvailable"), null)
			}
			else if(actionname.equalsIgnoreCase("Additional Info") && ProjectConstants.CURRENTVISITING_SHOPNAME.contains("MM")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.callTestCase(findTestCase("ShopOpen/RemainingMainCategories/AdditionalInfo/VisitAdditionalInfoWith_YesRemark"), null)
			}
		}
	}
	@Keyword
	def visitRemarksWith_AN_NSFD_NAvailable_AIN(){
		int totalactions = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<= totalactions; i++){
			MobileElement action = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			String actionname = action.getText()
			if(actionname.equalsIgnoreCase("Availability")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/Availability/VisitAvailability_WithNoRemark"), null)
			}
			else if(actionname.equalsIgnoreCase("Primary Display")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/PrimaryDisplay/NoSpaceForDisplay/VisitNSFD"), null)
			}
			else if(actionname.equalsIgnoreCase("Secondary Display")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/SecondaryDisplay/NotAvailable/VisitNotAvailable"), null)
			}
			else if(actionname.equalsIgnoreCase("Additional Info") && ProjectConstants.CURRENTVISITING_SHOPNAME.contains("MM")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.callTestCase(findTestCase("ShopOpen/RemainingMainCategories/AdditionalInfo/VisitAdditionalInfoWith_NoRemark"), null)
			}
		}
	}
	@Keyword
	def visitRemarksWith_AY_DSA_Available_AIY(){
		int totalactions = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<= totalactions; i++){
			MobileElement action = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			String actionname = action.getText()
			if(actionname.equalsIgnoreCase("Availability")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/Availability/VisitAvailability_WithYesRemark"), null)
			}
			else if(actionname.equalsIgnoreCase("Primary Display")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/PrimaryDisplay/DisplaySpaceAvailable/VisitDSA"), null)
			}
			else if(actionname.equalsIgnoreCase("Secondary Display")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/SecondaryDisplay/SecondaryDisplayAvailable_VisitingScenarios/VisitSecondaryDisplayAvailable"), null)
			}
			else if(actionname.equalsIgnoreCase("Additional Info") && ProjectConstants.CURRENTVISITING_SHOPNAME.contains("MM")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.callTestCase(findTestCase("ShopOpen/RemainingMainCategories/AdditionalInfo/VisitAdditionalInfoWith_YesRemark"), null)
			}
		}
	}
	@Keyword
	def visitRemarksWith_AY_SKDNA_Available_AIY(){
		int totalactions = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<= totalactions; i++){
			MobileElement action = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			String actionname = action.getText()
			if(actionname.equalsIgnoreCase("Availability")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/Availability/VisitAvailability_WithYesRemark"), null)
			}
			else if(actionname.equalsIgnoreCase("Primary Display")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/PrimaryDisplay/ShopKeeperDidnotAllow/VisitSKDNA"), null)
			}
			else if(actionname.equalsIgnoreCase("Secondary Display")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/SecondaryDisplay/SecondaryDisplayAvailable_VisitingScenarios/VisitSecondaryDisplayAvailable"), null)
			}
			else if(actionname.equalsIgnoreCase("Additional Info") && ProjectConstants.CURRENTVISITING_SHOPNAME.contains("MM")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.callTestCase(findTestCase("ShopOpen/RemainingMainCategories/AdditionalInfo/VisitAdditionalInfoWith_YesRemark"), null)
			}
		}
	}
	@Keyword
	def visitRemarksWith_AY_SKDNA_NR_AIN(){
		int totalactions = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<= totalactions; i++){
			MobileElement action = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			String actionname = action.getText()
			if(actionname.equalsIgnoreCase("Availability")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/Availability/VisitAvailability_WithYesRemark"), null)
			}
			else if(actionname.equalsIgnoreCase("Primary Display")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/PrimaryDisplay/ShopKeeperDidnotAllow/VisitSKDNA"), null)
			}
			else if(actionname.equalsIgnoreCase("Secondary Display")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/SecondaryDisplay/NotRecommended/VisitNotRecommended"), null)
			}
			else if(actionname.equalsIgnoreCase("Additional Info") && ProjectConstants.CURRENTVISITING_SHOPNAME.contains("MM")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.callTestCase(findTestCase("ShopOpen/RemainingMainCategories/AdditionalInfo/VisitAdditionalInfoWith_NoRemark"), null)
			}
		}
	}
	@Keyword
	def overwriteRemarksWith_AN_DSA_Available_AIN(){
		int totalactions = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<= totalactions; i++){
			MobileElement action = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			String actionname = action.getText()
			if(actionname.equalsIgnoreCase("Availability")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/Availability/VisitAvailability_WithNoRemark"), null)
			}
			else if(actionname.equalsIgnoreCase("Primary Display")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/PrimaryDisplay/DisplaySpaceAvailable/OverwriteDSA"), null)
			}
			else if(actionname.equalsIgnoreCase("Secondary Display")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/SecondaryDisplay/SecondaryDisplayAvailable_VisitingScenarios/OverwriteSecondaryDisplayAvailable"), null)
			}
			else if(actionname.equalsIgnoreCase("Additional Info") && ProjectConstants.CURRENTVISITING_SHOPNAME.contains("MM")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/AdditionalInfo/VisitAdditionalInfoWith_NoRemark"), null)
			}
		}
	}
	@Keyword
	def overwriteRemarksWith_AN_SKDNA_Available_AIN(){
		int totalactions = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<= totalactions; i++){
			MobileElement action = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			String actionname = action.getText()
			if(actionname.equalsIgnoreCase("Availability")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/Availability/VisitAvailability_WithNoRemark"), null)
			}
			else if(actionname.equalsIgnoreCase("Primary Display")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/PrimaryDisplay/ShopKeeperDidnotAllow/OverwriteSKDNA"), null)
			}
			else if(actionname.equalsIgnoreCase("Secondary Display")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/SecondaryDisplay/SecondaryDisplayAvailable_VisitingScenarios/OverwriteSecondaryDisplayAvailable"), null)
			}
			else if(actionname.equalsIgnoreCase("Additional Info") && ProjectConstants.CURRENTVISITING_SHOPNAME.contains("MM")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/AdditionalInfo/VisitAdditionalInfoWith_NoRemark"), null)
			}
		}
	}
}
