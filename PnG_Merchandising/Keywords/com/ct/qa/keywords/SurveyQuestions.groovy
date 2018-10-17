package com.ct.qa.keywords

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.By.ByTagName

import com.ct.qa.constants.ProjectConstants
import com.ct.qa.struct.MissingCategoryData
import com.ct.qa.struct.Questions
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
			missingcategorydata.setSurveyquestioncategories(UnmatchedItems_status.getItems())
			missingcategorydata.setSuveryquestioncategories_errormessage(ProjectConstants.MESSAGEFOR_SURVEYQUESTIONCATEGORIESARE_NOTMATCH)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingCategoriesData(missingcategorydata)
					break
				}
				else{
				}
			}
		}
		else if(UnmatchedItems_status.getStatus() == 1){
			MissingCategoryData missingcategorydata = new MissingCategoryData()
			missingcategorydata.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategorydata.setSurveyquestioncategories(UnmatchedItems_status.getItems())
			missingcategorydata.setSuveryquestioncategories_errormessage(ProjectConstants.MESSAGEFOR_SURVEYQUESTIONCATEGORIESARE_MORE)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingCategoriesData(missingcategorydata)
					break
				}
				else{
				}
			}
		}
		else if(UnmatchedItems_status.getStatus() == -1){
			MissingCategoryData missingcategorydata = new MissingCategoryData()
			missingcategorydata.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategorydata.setSurveyquestioncategories(UnmatchedItems_status.getItems())
			missingcategorydata.setSuveryquestioncategories_errormessage(ProjectConstants.MESSAGEFOR_SURVEYQUESTIONCATEGORIESARE_MISSING)
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
		Mobile.swipe(0, 200, 0, 750)
		Mobile.swipe(0, 200, 0, 750)
		int totalsurveyquestioncategories = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<= totalsurveyquestioncategories; i++){
			MobileElement questioncategory = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			ProjectConstants.CURRENTVISITING_SURVEYQUESTION_CATEGORY = questioncategory.getText()
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
	}
	@Keyword
	def visitSurveyQuestionsWithYesRemark(){
		int index = 0
		String itemtextbeforeswipe = ""
		String itemtextafterswipe = ""
		String tag = ""
		MobileElement surveyquestion = null
		ArrayList<String> visitedsurveyquestions = new ArrayList<String>()
		ArrayList<Questions> expectedsurveyquestions = LoadDataKeywords.loadSurveyQuestionsList(LoadDataKeywords.loadSurveyQuestionsSheet() , ProjectConstants.SURVEYQUESTIONVALUE)
		ArrayList<MobileElement> surveyquestionslist = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
		for(int i=0; i< surveyquestionslist.size(); i++){
			surveyquestion = surveyquestionslist.get(i)
			tag = surveyquestion.getTagName()
			if(tag.equalsIgnoreCase("android.widget.Spinner")){
				String displayeddropdowntext = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
				visitedsurveyquestions.add(displayeddropdowntext)
				surveyquestion.click()
				Mobile.verifyElementExist(findTestObject("Object Repository/ShopOpen/SurveyQuestions/Validate_QuestionRemarksPopup", [('package') : ProjectConstants.PACKAGENAME]), 0)
				Mobile.tap(findTestObject("ShopOpen/SurveyQuestions/QuestionRemark_Yes", [('package') : ProjectConstants.PACKAGENAME]), 0)
				Mobile.verifyElementText(findTestObject('ShopOpen/SurveyQuestions/Validate_QuestionsListScreen', [('package') : ProjectConstants.PACKAGENAME]), 'Questions')
			}
			else{
				String displayededitfieldtext = surveyquestion.getText()
				visitedsurveyquestions.add(displayededitfieldtext)
				for(int j=0; j< expectedsurveyquestions.size(); j++){
					String expectededitfieldtext = expectedsurveyquestions.get(j).getQuestion()
					if(displayededitfieldtext.equalsIgnoreCase(expectededitfieldtext)){
						String questionvalue = expectedsurveyquestions.get(j).getQuestion_value()
						surveyquestion.setValue(questionvalue)
						Mobile.hideKeyboard()
					}
					else{
						surveyquestion.setValue("0000")
						Mobile.hideKeyboard()
					}
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
			Mobile.swipe(20, 324, 20, 200)
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
					String displayeddropdowntext = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
					visitedsurveyquestions.add(displayeddropdowntext)
					surveyquestion.click()
					Mobile.verifyElementExist(findTestObject("Object Repository/ShopOpen/SurveyQuestions/Validate_QuestionRemarksPopup", [('package') : ProjectConstants.PACKAGENAME]), 0)
					Mobile.tap(findTestObject("ShopOpen/SurveyQuestions/QuestionRemark_Yes", [('package') : ProjectConstants.PACKAGENAME]), 0)
					Mobile.verifyElementText(findTestObject('ShopOpen/SurveyQuestions/Validate_QuestionsListScreen', [('package') : ProjectConstants.PACKAGENAME]), 'Questions')
				}
				else{
					String displayededitfieldtext = surveyquestion.getText()
					visitedsurveyquestions.add(displayededitfieldtext)
					for(int j=0; j< expectedsurveyquestions.size(); j++){
						String expectededitfieldtext = expectedsurveyquestions.get(j).getQuestion()
						if(displayededitfieldtext.equalsIgnoreCase(expectededitfieldtext)){
							String questionvalue = expectedsurveyquestions.get(j).getQuestion_value()
							surveyquestion.setValue(questionvalue)
							Mobile.hideKeyboard()
						}
						else{
							surveyquestion.setValue("0000")
							Mobile.hideKeyboard()
						}
					}
				}
			}
		}
		if(expectedsurveyquestions.size() == visitedsurveyquestions.size()){
			ArrayList<String> questions = new ArrayList<String>()
			for(int i=0; i<visitedsurveyquestions.size(); i++){
				boolean match = false
				for(int j=0; j<expectedsurveyquestions.size(); j++){
					String dis = visitedsurveyquestions.get(i)
					String exp = expectedsurveyquestions.get(j).getQuestion()
					if(visitedsurveyquestions.get(i).equalsIgnoreCase(expectedsurveyquestions.get(j).getQuestion())){
						match = true
						break
					}
					else{}
				}
				if(match == false){
					questions.add(visitedsurveyquestions.get(i))
				}
				else{
				}
			}
			if(!questions.isEmpty()){
				MissingCategoryData missingcategorydata = new MissingCategoryData()
				missingcategorydata.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
				missingcategorydata.setSurveyquestions(questions)
				missingcategorydata.setSurveyquestions_errormessage(ProjectConstants.MESSAGEFOR_SURVEYQUESTIONSARE_NOTMATCH)
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
		else if(expectedsurveyquestions.size() < visitedsurveyquestions.size()){
			ArrayList<String> questions = new ArrayList<String>()
			for(int i=0; i<visitedsurveyquestions.size(); i++){
				boolean match = false
				for(int j=0; j<expectedsurveyquestions.size(); j++){
					if(visitedsurveyquestions.get(i).equalsIgnoreCase(expectedsurveyquestions.get(j).getQuestion())){
						match = true
						break
					}
				}
				if(match == false){
					questions.add(visitedsurveyquestions.get(i))
				}
				else{
				}
			}
			MissingCategoryData missingcategorydata = new MissingCategoryData()
			missingcategorydata.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategorydata.setSurveyquestions(questions)
			missingcategorydata.setSurveyquestions_errormessage(ProjectConstants.MESSAGEFOR_SURVEYQUESTIONSARE_MORE)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingCategoriesData(missingcategorydata)
				}
				else{
				}
			}
		}
		else if(expectedsurveyquestions.size() > visitedsurveyquestions.size()){
			ArrayList<String> questions = new ArrayList<String>()
			for(int i=0; i<expectedsurveyquestions.size(); i++){
				boolean match = false
				for(int j=0; j<visitedsurveyquestions.size(); j++){
					if(expectedsurveyquestions.get(i).getQuestion().equalsIgnoreCase(visitedsurveyquestions.get(j))){
						match = true
						break
					}
				}
				if(match == false){
					questions.add(expectedsurveyquestions.get(i).getQuestion())
				}
				else{
				}
			}
			MissingCategoryData missingcategorydata = new MissingCategoryData()
			missingcategorydata.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategorydata.setSurveyquestions(questions)
			missingcategorydata.setSurveyquestions_errormessage(ProjectConstants.MESSAGEFOR_SURVEYQUESTIONSARE_MORE)
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
	}
	@Keyword
	def visitSurveyQuestionsWithNoRemark(){
		int index = 0
		String itemtextbeforeswipe = ""
		String itemtextafterswipe = ""
		String tag = ""
		MobileElement surveyquestion = null
		ArrayList<String> visitedsurveyquestions = new ArrayList<String>()
		ArrayList<Questions> expectedsurveyquestions = LoadDataKeywords.loadSurveyQuestionsList(LoadDataKeywords.loadSurveyQuestionsSheet() , ProjectConstants.OVERWRITE_SURVEYQUESTIONVALUE)
		ArrayList<MobileElement> surveyquestionslist = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
		for(int i=0; i< surveyquestionslist.size(); i++){
			surveyquestion = surveyquestionslist.get(i)
			tag = surveyquestion.getTagName()
			if(tag.equalsIgnoreCase("android.widget.Spinner")){
				String displayeddropdowntext = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
				visitedsurveyquestions.add(displayeddropdowntext)
				surveyquestion.click()
				Mobile.verifyElementExist(findTestObject("Object Repository/ShopOpen/SurveyQuestions/Validate_QuestionRemarksPopup", [('package') : ProjectConstants.PACKAGENAME]), 0)
				Mobile.tap(findTestObject("ShopOpen/SurveyQuestions/QuestionRemark_Yes", [('package') : ProjectConstants.PACKAGENAME]), 0)
				Mobile.verifyElementText(findTestObject('ShopOpen/SurveyQuestions/Validate_QuestionsListScreen', [('package') : ProjectConstants.PACKAGENAME]), 'Questions')
			}
			else{
				String displayededitfieldtext = surveyquestion.getText()
				visitedsurveyquestions.add(displayededitfieldtext)
				for(int j=0; j< expectedsurveyquestions.size(); j++){
					String expectededitfieldtext = expectedsurveyquestions.get(j).getQuestion()
					if(displayededitfieldtext.equalsIgnoreCase(expectededitfieldtext)){
						String questionvalue = expectedsurveyquestions.get(j).getQuestion_value()
						surveyquestion.setValue(questionvalue)
						Mobile.hideKeyboard()
					}
					else{
						surveyquestion.setValue("0000")
						Mobile.hideKeyboard()
					}
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
			Mobile.swipe(20, 324, 20, 200)
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
					String displayeddropdowntext = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
					visitedsurveyquestions.add(displayeddropdowntext)
					surveyquestion.click()
					Mobile.verifyElementExist(findTestObject("Object Repository/ShopOpen/SurveyQuestions/Validate_QuestionRemarksPopup", [('package') : ProjectConstants.PACKAGENAME]), 0)
					Mobile.tap(findTestObject("ShopOpen/SurveyQuestions/QuestionRemark_Yes", [('package') : ProjectConstants.PACKAGENAME]), 0)
					Mobile.verifyElementText(findTestObject('ShopOpen/SurveyQuestions/Validate_QuestionsListScreen', [('package') : ProjectConstants.PACKAGENAME]), 'Questions')
				}
				else{
					String displayededitfieldtext = surveyquestion.getText()
					visitedsurveyquestions.add(displayededitfieldtext)
					for(int j=0; j< expectedsurveyquestions.size(); j++){
						String expectededitfieldtext = expectedsurveyquestions.get(j).getQuestion()
						if(displayededitfieldtext.equalsIgnoreCase(expectededitfieldtext)){
							String questionvalue = expectedsurveyquestions.get(j).getQuestion_value()
							surveyquestion.setValue(questionvalue)
							Mobile.hideKeyboard()
						}
						else{
							surveyquestion.setValue("0000")
							Mobile.hideKeyboard()
						}
					}
				}
			}
		}
		if(expectedsurveyquestions.size() == visitedsurveyquestions.size()){
			ArrayList<String> questions = new ArrayList<String>()
			for(int i=0; i<visitedsurveyquestions.size(); i++){
				boolean match = false
				for(int j=0; j<expectedsurveyquestions.size(); j++){
					String dis = visitedsurveyquestions.get(i)
					String exp = expectedsurveyquestions.get(j).getQuestion()
					if(visitedsurveyquestions.get(i).equalsIgnoreCase(expectedsurveyquestions.get(j).getQuestion())){
						match = true
						break
					}
					else{}
				}
				if(match == false){
					questions.add(visitedsurveyquestions.get(i))
				}
				else{
				}
			}
			if(!questions.isEmpty()){
				MissingCategoryData missingcategorydata = new MissingCategoryData()
				missingcategorydata.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
				missingcategorydata.setSurveyquestions(questions)
				missingcategorydata.setSurveyquestions_errormessage(ProjectConstants.MESSAGEFOR_SURVEYQUESTIONSARE_NOTMATCH)
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
		else if(expectedsurveyquestions.size() < visitedsurveyquestions.size()){
			ArrayList<String> questions = new ArrayList<String>()
			for(int i=0; i<visitedsurveyquestions.size(); i++){
				boolean match = false
				for(int j=0; j<expectedsurveyquestions.size(); j++){
					if(visitedsurveyquestions.get(i).equalsIgnoreCase(expectedsurveyquestions.get(j).getQuestion())){
						match = true
						break
					}
				}
				if(match == false){
					questions.add(visitedsurveyquestions.get(i))
				}
				else{
				}
			}
			MissingCategoryData missingcategorydata = new MissingCategoryData()
			missingcategorydata.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategorydata.setSurveyquestions(questions)
			missingcategorydata.setSurveyquestions_errormessage(ProjectConstants.MESSAGEFOR_SURVEYQUESTIONSARE_MORE)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingCategoriesData(missingcategorydata)
				}
				else{
				}
			}
		}
		else if(expectedsurveyquestions.size() > visitedsurveyquestions.size()){
			ArrayList<String> questions = new ArrayList<String>()
			for(int i=0; i<expectedsurveyquestions.size(); i++){
				boolean match = false
				for(int j=0; j<visitedsurveyquestions.size(); j++){
					if(expectedsurveyquestions.get(i).getQuestion().equalsIgnoreCase(visitedsurveyquestions.get(j))){
						match = true
						break
					}
				}
				if(match == false){
					questions.add(expectedsurveyquestions.get(i).getQuestion())
				}
				else{
				}
			}
			MissingCategoryData missingcategorydata = new MissingCategoryData()
			missingcategorydata.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategorydata.setSurveyquestions(questions)
			missingcategorydata.setSurveyquestions_errormessage(ProjectConstants.MESSAGEFOR_SURVEYQUESTIONSARE_MORE)
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
	}
}
