package com.ct.qa.keywords

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.By.ByTagName

import com.ct.qa.constants.ProjectConstants
import com.ct.qa.struct.MissingCategoryData
import com.ct.qa.struct.ProductWithValue
import com.ct.qa.struct.UnmatchedItems
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
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

public class SurveyQuestions {
	@Keyword
	def visitSurveyQuestionCategories(int flag){
		UnmatchedItems UnmatchedItems_status = CompareDataKeywords.compareSurveyQuestionCategories()
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
		Mobile.swipe(0, 200, 0, 750)
		Mobile.swipe(0, 200, 0, 750)
		int index = 0
		int totalsurveyquestioncategories = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<= totalsurveyquestioncategories; i++){
			MobileElement questioncategory = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			ProjectConstants.CURRENTVISITING_SUBCATEGORY = questioncategory.getText()
			ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
			if(flag == 1){
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SurveyQuestions/VisitQuestionsWithYesRemark"), null)
			}
			else{
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SurveyQuestions/VisitQuestionsWithNoRemark"), null)
			}
			Mobile.verifyElementText(findTestObject('ShopOpen/SurveyQuestions/Validate_QuestionCategoryScreen', [('package') : ProjectConstants.PACKAGENAME]),
			'Question Category')
		}
		while(true){
			index = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
			MobileElement itembeforeswipe = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]/android.widget.TextView[1]")
			String itemnamebeforeswipe = itembeforeswipe.getText()
			Mobile.swipe(0, 293, 0, 200)
			index = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
			MobileElement itemafterswipe = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]/android.widget.TextView[1]")
			String itemnameafterswipe = itembeforeswipe.getText()
			if(itemnamebeforeswipe.equals(itemnameafterswipe)){
				break
			}
			else{
				ProjectConstants.CURRENTVISITING_SUBCATEGORY = itemnameafterswipe
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]").click()
				if(flag == 1){
					Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SurveyQuestions/VisitQuestionsWithYesRemark"), null)
				}
				else{
					Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SurveyQuestions/VisitQuestionsWithNoRemark"), null)
				}
				Mobile.verifyElementText(findTestObject('ShopOpen/SurveyQuestions/Validate_QuestionCategoryScreen', [('package') : ProjectConstants.PACKAGENAME]),
				'Question Category')
			}
		}
	}
	@Keyword
	def visitSurveyQuestionsWithYesRemark(){
		int index = 0
		String itemtextbeforeswipe = ""
		String itemtextafterswipe = ""
		String tag = ""
		MobileElement surveyquestion = null
		ArrayList<String> visitedsurveyquestions = new ArrayList<String>()
		ArrayList<String> expectedsurveyquestionslist = new ArrayList<String>()
		ArrayList<ProductWithValue> expectedsurveyquestions = LoadDataKeywords.loadSurveyQuestionsList(LoadDataKeywords.loadSurveyQuestionsSheet() , ProjectConstants.SURVEYQUESTIONVALUE)
		for(int i=0; i< expectedsurveyquestions.size(); i++){
			expectedsurveyquestionslist.add(expectedsurveyquestions.get(i).getProduct())
		}
		ArrayList<MobileElement> surveyquestionslist = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
		for(int i=0; i< surveyquestionslist.size(); i++){
			surveyquestion = surveyquestionslist.get(i)
			tag = surveyquestion.getTagName()
			if(tag.equalsIgnoreCase("android.widget.Spinner")){
				Question _surveyquestion = new Question()
				boolean flag = false
				String displayeddropdowntext = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
				visitedsurveyquestions.add(displayeddropdowntext)
				_surveyquestion.s
				surveyquestion.click()
				Mobile.verifyElementExist(findTestObject("Object Repository/ShopOpen/SurveyQuestions/Validate_QuestionRemarksPopup", [('package') : ProjectConstants.PACKAGENAME]), 0)
				for(int j=0; j< expectedsurveyquestions.size(); j++){
					if(expectedsurveyquestions.get(j).getProduct().equalsIgnoreCase(displayeddropdowntext)){
						flag = true
						String status = expectedsurveyquestions.get(j).getStatus()
						String options = expectedsurveyquestions.get(j).getOptions()
						if(options.equalsIgnoreCase("Y/N")){
							Mobile.tap(findTestObject("ShopOpen/SurveyQuestions/QuestionRemark_Yes", [('package') : ProjectConstants.PACKAGENAME]), 0)
						}
						else{
							Mobile.tap(findTestObject("ShopOpen/SurveyQuestions/QuestionRemark_Yes", [('package') : ProjectConstants.PACKAGENAME]), 0)
						}
						if(status.equalsIgnoreCase("Y")){
							validateCameraScreenAndTakePicture()
							break
						}
						else{}
					}
					else{}
				}
				if(flag == false){
					Mobile.tap(findTestObject("ShopOpen/SurveyQuestions/QuestionRemark_Yes", [('package') : ProjectConstants.PACKAGENAME]), 0)
					validateCameraScreenAndTakePicture()
				}
				else{}
				Mobile.verifyElementText(findTestObject('ShopOpen/SurveyQuestions/Validate_QuestionsListScreen', [('package') : ProjectConstants.PACKAGENAME]), 'Questions')
			}
			else{
				boolean flag = false
				String displayededitfieldtext = surveyquestion.getText()
				visitedsurveyquestions.add(displayededitfieldtext)
				for(int j=0; j< expectedsurveyquestions.size(); j++){
					String expectededitfieldtext = expectedsurveyquestions.get(j).getProduct()
					if(displayededitfieldtext.equalsIgnoreCase(expectededitfieldtext)){
						flag = true
						String questionvalue = expectedsurveyquestions.get(j).getProduct_value()
						surveyquestion.setValue(questionvalue)
						Mobile.hideKeyboard()
					}
					else{
					}
				}
				if(flag == false){
					surveyquestion.setValue("0000")
					Mobile.hideKeyboard()
				}
			}
		}
		while(true){
			surveyquestionslist = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
			index = (surveyquestionslist.size()-1)
			surveyquestion =  surveyquestionslist.get(index)
			tag = surveyquestion.getTagName()
			if(tag.equalsIgnoreCase("android.widget.Spinner")){
				itemtextbeforeswipe = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
			}
			else{
				itemtextbeforeswipe = surveyquestion.getText()
			}
			Mobile.swipe(20, 315, 20, 200)
			surveyquestionslist = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
			index = (surveyquestionslist.size()-1)
			surveyquestion =  surveyquestionslist.get(index)
			tag = surveyquestion.getTagName()
			if(tag.equalsIgnoreCase("android.widget.Spinner")){
				itemtextafterswipe = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
			}
			else{
				itemtextafterswipe = surveyquestion.getText()
			}
			if(itemtextbeforeswipe.equals(itemtextafterswipe)){
				break
			}
			else{
				if(tag.equalsIgnoreCase("android.widget.Spinner")){
					boolean flag = false
					String displayeddropdowntext = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
					visitedsurveyquestions.add(displayeddropdowntext)
					surveyquestion.click()
					Mobile.verifyElementExist(findTestObject("Object Repository/ShopOpen/SurveyQuestions/Validate_QuestionRemarksPopup", [('package') : ProjectConstants.PACKAGENAME]), 0)
					for(int j=0; j< expectedsurveyquestions.size(); j++){
						if(expectedsurveyquestions.get(j).getProduct().equalsIgnoreCase(displayeddropdowntext)){
							flag = true
							String status = expectedsurveyquestions.get(j).getStatus()
							String options = expectedsurveyquestions.get(j).getOptions()
							if(options.equalsIgnoreCase("Y/N")){
								Mobile.tap(findTestObject("ShopOpen/SurveyQuestions/QuestionRemark_Yes", [('package') : ProjectConstants.PACKAGENAME]), 0)
							}
							else{
								Mobile.tap(findTestObject("ShopOpen/SurveyQuestions/QuestionRemark_Yes", [('package') : ProjectConstants.PACKAGENAME]), 0)
							}
							if(status.equalsIgnoreCase("Y")){
								validateCameraScreenAndTakePicture()
								break
							}
							else{}
						}
						else{}
					}
					if(flag == false){
						Mobile.tap(findTestObject("ShopOpen/SurveyQuestions/QuestionRemark_Yes", [('package') : ProjectConstants.PACKAGENAME]), 0)
						validateCameraScreenAndTakePicture()
					}
					else{}
					Mobile.verifyElementText(findTestObject('ShopOpen/SurveyQuestions/Validate_QuestionsListScreen', [('package') : ProjectConstants.PACKAGENAME]), 'Questions')
				}
				else{
					boolean flag = false
					String displayededitfieldtext = surveyquestion.getText()
					visitedsurveyquestions.add(displayededitfieldtext)
					for(int j=0; j< expectedsurveyquestions.size(); j++){
						String expectededitfieldtext = expectedsurveyquestions.get(j).getProduct()
						if(displayededitfieldtext.equalsIgnoreCase(expectededitfieldtext)){
							flag = true
							String questionvalue = expectedsurveyquestions.get(j).getProduct_value()
							surveyquestion.setValue(questionvalue)
							Mobile.hideKeyboard()
						}
						else{
						}
					}
					if(flag == false){
						surveyquestion.setValue("0000")
						Mobile.hideKeyboard()
					}
				}
			}
			// swipe with different values
			surveyquestionslist = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
			index = (surveyquestionslist.size()-1)
			surveyquestion =  surveyquestionslist.get(index)
			tag = surveyquestion.getTagName()
			if(tag.equalsIgnoreCase("android.widget.Spinner")){
				itemtextbeforeswipe = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
			}
			else{
				itemtextbeforeswipe = surveyquestion.getText()
			}
			Mobile.swipe(20, 314, 20, 200)
			surveyquestionslist = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
			index = (surveyquestionslist.size()-1)
			surveyquestion =  surveyquestionslist.get(index)
			tag = surveyquestion.getTagName()
			if(tag.equalsIgnoreCase("android.widget.Spinner")){
				itemtextafterswipe = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
			}
			else{
				itemtextafterswipe = surveyquestion.getText()
			}
			if(itemtextbeforeswipe.equals(itemtextafterswipe)){
				break
			}
			else{
				if(tag.equalsIgnoreCase("android.widget.Spinner")){
					boolean flag = false
					String displayeddropdowntext = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
					visitedsurveyquestions.add(displayeddropdowntext)
					surveyquestion.click()
					Mobile.verifyElementExist(findTestObject("Object Repository/ShopOpen/SurveyQuestions/Validate_QuestionRemarksPopup", [('package') : ProjectConstants.PACKAGENAME]), 0)
					for(int j=0; j< expectedsurveyquestions.size(); j++){
						if(expectedsurveyquestions.get(j).getProduct().equalsIgnoreCase(displayeddropdowntext)){
							flag = true
							String status = expectedsurveyquestions.get(j).getStatus()
							String options = expectedsurveyquestions.get(j).getOptions()
							if(options.equalsIgnoreCase("Y/N")){
								Mobile.tap(findTestObject("ShopOpen/SurveyQuestions/QuestionRemark_Yes", [('package') : ProjectConstants.PACKAGENAME]), 0)
							}
							else{
								Mobile.tap(findTestObject("ShopOpen/SurveyQuestions/QuestionRemark_Yes", [('package') : ProjectConstants.PACKAGENAME]), 0)
							}
							if(status.equalsIgnoreCase("Y")){
								validateCameraScreenAndTakePicture()
								break
							}
							else{}
						}
						else{}
					}
					if(flag == false){
						Mobile.tap(findTestObject("ShopOpen/SurveyQuestions/QuestionRemark_Yes", [('package') : ProjectConstants.PACKAGENAME]), 0)
						validateCameraScreenAndTakePicture()
					}
					else{}
					Mobile.verifyElementText(findTestObject('ShopOpen/SurveyQuestions/Validate_QuestionsListScreen', [('package') : ProjectConstants.PACKAGENAME]), 'Questions')
				}
				else{
					boolean flag = false
					String displayededitfieldtext = surveyquestion.getText()
					visitedsurveyquestions.add(displayededitfieldtext)
					for(int j=0; j< expectedsurveyquestions.size(); j++){
						String expectededitfieldtext = expectedsurveyquestions.get(j).getProduct()
						if(displayededitfieldtext.equalsIgnoreCase(expectededitfieldtext)){
							flag = true
							String questionvalue = expectedsurveyquestions.get(j).getProduct_value()
							surveyquestion.setValue(questionvalue)
							Mobile.hideKeyboard()
						}
						else{
						}
					}
					if(flag == false){
						surveyquestion.setValue("0000")
						Mobile.hideKeyboard()
					}
				}
			}
		}
		UnmatchedItems UnmatchedItems_status = CompareDataKeywords.compareLists(expectedsurveyquestionslist, visitedsurveyquestions)
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
	}
	@Keyword
	def visitSurveyQuestionsWithNoRemark(){
		int index = 0
		String itemtextbeforeswipe = ""
		String itemtextafterswipe = ""
		String tag = ""
		MobileElement surveyquestion = null
		ArrayList<String> visitedsurveyquestions = new ArrayList<String>()
		ArrayList<String> expectedsurveyquestionslist = new ArrayList<String>()
		ArrayList<ProductWithValue> expectedsurveyquestions = LoadDataKeywords.loadSurveyQuestionsList(LoadDataKeywords.loadSurveyQuestionsSheet() , ProjectConstants.OVERWRITE_SURVEYQUESTIONVALUE)
		for(int i=0; i< expectedsurveyquestions.size(); i++){
			expectedsurveyquestionslist.add(expectedsurveyquestions.get(i).getProduct())
		}
		ArrayList<MobileElement> surveyquestionslist = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
		for(int i=0; i< surveyquestionslist.size(); i++){
			surveyquestion = surveyquestionslist.get(i)
			tag = surveyquestion.getTagName()
			if(tag.equalsIgnoreCase("android.widget.Spinner")){
				boolean flag = false
				String displayeddropdowntext = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
				visitedsurveyquestions.add(displayeddropdowntext)
				surveyquestion.click()
				Mobile.verifyElementExist(findTestObject("Object Repository/ShopOpen/SurveyQuestions/Validate_QuestionRemarksPopup", [('package') : ProjectConstants.PACKAGENAME]), 0)
				for(int j=0; j< expectedsurveyquestions.size(); j++){
					if(expectedsurveyquestions.get(j).getProduct().equalsIgnoreCase(displayeddropdowntext)){
						flag = true
						String status = expectedsurveyquestions.get(j).getStatus()
						String options = expectedsurveyquestions.get(j).getOptions()
						if(options.equalsIgnoreCase("Y/N")){
							Mobile.tap(findTestObject("Object Repository/ShopOpen/SurveyQuestions/QuestionRemark_No", [('package') : ProjectConstants.PACKAGENAME]), 0)
						}
						else{
							Mobile.tap(findTestObject("ShopOpen/SurveyQuestions/QuestionRemark_Yes", [('package') : ProjectConstants.PACKAGENAME]), 0)
						}
						if(status.equalsIgnoreCase("Y")){
							validateCameraScreenAndTakePicture()
							break
						}
						else{}
					}
					else{}
				}
				if(flag == false){
					Mobile.tap(findTestObject("ShopOpen/SurveyQuestions/QuestionRemark_Yes", [('package') : ProjectConstants.PACKAGENAME]), 0)
					validateCameraScreenAndTakePicture()
				}
				else{}
				Mobile.verifyElementText(findTestObject('ShopOpen/SurveyQuestions/Validate_QuestionsListScreen', [('package') : ProjectConstants.PACKAGENAME]), 'Questions')
			}
			else{
				boolean flag = false
				String displayededitfieldtext = surveyquestion.getText()
				visitedsurveyquestions.add(displayededitfieldtext)
				for(int j=0; j< expectedsurveyquestions.size(); j++){
					String expectededitfieldtext = expectedsurveyquestions.get(j).getProduct()
					if(displayededitfieldtext.equalsIgnoreCase(expectededitfieldtext)){
						flag = true
						String questionvalue = expectedsurveyquestions.get(j).getProduct_value()
						surveyquestion.setValue(questionvalue)
						Mobile.hideKeyboard()
					}
					else{
					}
				}
				if(flag == false){
					surveyquestion.setValue("0000")
					Mobile.hideKeyboard()
				}
			}
		}
		while(true){
			surveyquestionslist = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
			index = (surveyquestionslist.size()-1)
			surveyquestion =  surveyquestionslist.get(index)
			tag = surveyquestion.getTagName()
			if(tag.equalsIgnoreCase("android.widget.Spinner")){
				itemtextbeforeswipe = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
			}
			else{
				itemtextbeforeswipe = surveyquestion.getText()
			}
			Mobile.swipe(20, 315, 20, 200)
			surveyquestionslist = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
			index = (surveyquestionslist.size()-1)
			surveyquestion =  surveyquestionslist.get(index)
			tag = surveyquestion.getTagName()
			if(tag.equalsIgnoreCase("android.widget.Spinner")){
				itemtextafterswipe = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
			}
			else{
				itemtextafterswipe = surveyquestion.getText()
			}
			if(itemtextbeforeswipe.equals(itemtextafterswipe)){
				break
			}
			else{
				if(tag.equalsIgnoreCase("android.widget.Spinner")){
					boolean flag = false
					String displayeddropdowntext = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
					visitedsurveyquestions.add(displayeddropdowntext)
					surveyquestion.click()
					Mobile.verifyElementExist(findTestObject("Object Repository/ShopOpen/SurveyQuestions/Validate_QuestionRemarksPopup", [('package') : ProjectConstants.PACKAGENAME]), 0)
					for(int j=0; j< expectedsurveyquestions.size(); j++){
						if(expectedsurveyquestions.get(j).getProduct().equalsIgnoreCase(displayeddropdowntext)){
							flag = true
							String status = expectedsurveyquestions.get(j).getStatus()
							String options = expectedsurveyquestions.get(j).getOptions()
							if(options.equalsIgnoreCase("Y/N")){
								Mobile.tap(findTestObject("Object Repository/ShopOpen/SurveyQuestions/QuestionRemark_No", [('package') : ProjectConstants.PACKAGENAME]), 0)
							}
							else{
								Mobile.tap(findTestObject("ShopOpen/SurveyQuestions/QuestionRemark_Yes", [('package') : ProjectConstants.PACKAGENAME]), 0)
							}
							if(status.equalsIgnoreCase("Y")){
								validateCameraScreenAndTakePicture()
								break
							}
							else{}
						}
						else{}
					}
					if(flag == false){
						Mobile.tap(findTestObject("ShopOpen/SurveyQuestions/QuestionRemark_Yes", [('package') : ProjectConstants.PACKAGENAME]), 0)
						validateCameraScreenAndTakePicture()
					}
					else{}
					Mobile.verifyElementText(findTestObject('ShopOpen/SurveyQuestions/Validate_QuestionsListScreen', [('package') : ProjectConstants.PACKAGENAME]), 'Questions')
				}
				else{
					boolean flag = false
					String displayededitfieldtext = surveyquestion.getText()
					visitedsurveyquestions.add(displayededitfieldtext)
					for(int j=0; j< expectedsurveyquestions.size(); j++){
						String expectededitfieldtext = expectedsurveyquestions.get(j).getProduct()
						if(displayededitfieldtext.equalsIgnoreCase(expectededitfieldtext)){
							flag = true
							String questionvalue = expectedsurveyquestions.get(j).getProduct_value()
							surveyquestion.setValue(questionvalue)
							Mobile.hideKeyboard()
						}
						else{
						}
					}
					if(flag == false){
						surveyquestion.setValue("0000")
						Mobile.hideKeyboard()
					}
				}
			}
			surveyquestionslist = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
			index = (surveyquestionslist.size()-1)
			surveyquestion =  surveyquestionslist.get(index)
			tag = surveyquestion.getTagName()
			if(tag.equalsIgnoreCase("android.widget.Spinner")){
				itemtextbeforeswipe = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
			}
			else{
				itemtextbeforeswipe = surveyquestion.getText()
			}
			Mobile.swipe(20, 314, 20, 200)
			surveyquestionslist = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
			index = (surveyquestionslist.size()-1)
			surveyquestion =  surveyquestionslist.get(index)
			tag = surveyquestion.getTagName()
			if(tag.equalsIgnoreCase("android.widget.Spinner")){
				itemtextafterswipe = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
			}
			else{
				itemtextafterswipe = surveyquestion.getText()
			}
			if(itemtextbeforeswipe.equals(itemtextafterswipe)){
				break
			}
			else{
				if(tag.equalsIgnoreCase("android.widget.Spinner")){
					boolean flag = false
					String displayeddropdowntext = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
					visitedsurveyquestions.add(displayeddropdowntext)
					surveyquestion.click()
					Mobile.verifyElementExist(findTestObject("Object Repository/ShopOpen/SurveyQuestions/Validate_QuestionRemarksPopup", [('package') : ProjectConstants.PACKAGENAME]), 0)
					for(int j=0; j< expectedsurveyquestions.size(); j++){
						if(expectedsurveyquestions.get(j).getProduct().equalsIgnoreCase(displayeddropdowntext)){
							flag = true
							String status = expectedsurveyquestions.get(j).getStatus()
							String options = expectedsurveyquestions.get(j).getOptions()
							if(options.equalsIgnoreCase("Y/N")){
								Mobile.tap(findTestObject("Object Repository/ShopOpen/SurveyQuestions/QuestionRemark_No", [('package') : ProjectConstants.PACKAGENAME]), 0)
							}
							else{
								Mobile.tap(findTestObject("ShopOpen/SurveyQuestions/QuestionRemark_Yes", [('package') : ProjectConstants.PACKAGENAME]), 0)
							}
							if(status.equalsIgnoreCase("Y")){
								validateCameraScreenAndTakePicture()
								break
							}
							else{}
						}
						else{}
					}
					if(flag == false){
						Mobile.tap(findTestObject("ShopOpen/SurveyQuestions/QuestionRemark_Yes", [('package') : ProjectConstants.PACKAGENAME]), 0)
						validateCameraScreenAndTakePicture()
					}
					else{}
					Mobile.verifyElementText(findTestObject('ShopOpen/SurveyQuestions/Validate_QuestionsListScreen', [('package') : ProjectConstants.PACKAGENAME]), 'Questions')
				}
				else{
					boolean flag = false
					String displayededitfieldtext = surveyquestion.getText()
					visitedsurveyquestions.add(displayededitfieldtext)
					for(int j=0; j< expectedsurveyquestions.size(); j++){
						String expectededitfieldtext = expectedsurveyquestions.get(j).getProduct()
						if(displayededitfieldtext.equalsIgnoreCase(expectededitfieldtext)){
							flag = true
							String questionvalue = expectedsurveyquestions.get(j).getProduct_value()
							surveyquestion.setValue(questionvalue)
							Mobile.hideKeyboard()
						}
						else{
						}
					}
					if(flag == false){
						surveyquestion.setValue("0000")
						Mobile.hideKeyboard()
					}
				}
			}
		}
		UnmatchedItems UnmatchedItems_status = CompareDataKeywords.compareLists(expectedsurveyquestionslist, visitedsurveyquestions)
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
	}
	def validateCameraScreenAndTakePicture(){
		try{
			Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_CameraScreen", [('package') : ProjectConstants.PACKAGENAME]), 0, FailureHandling.OPTIONAL)
			Mobile.tap(findTestObject("Object Repository/CommonScreenElements/TakePictureButton", [('package') : ProjectConstants.PACKAGENAME]), 0)
			Mobile.delay(5)
			Mobile.tap(findTestObject("Object Repository/CommonScreenElements/DoneButton", [('package') : ProjectConstants.PACKAGENAME]), 0)
		}
		catch(Exception ex){
		}
	}
}
