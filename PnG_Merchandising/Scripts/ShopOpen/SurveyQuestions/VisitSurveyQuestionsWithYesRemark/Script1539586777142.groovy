import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.ct.qa.constants.ProjectConstants as ProjectConstants
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

Mobile.verifyElementText(findTestObject('ShopOpen/SurveyQuestions/Validate_QuestionCategoryScreen', [('package') : ProjectConstants.PACKAGENAME]), 
    'Question Category')

CustomKeywords.'com.ct.qa.keywords.__SurveyQuestions.visitSurveyQuestionCategories'(1)

Mobile.verifyElementText(findTestObject('ShopOpen/SurveyQuestions/Validate_QuestionCategoryScreen', [('package') : ProjectConstants.PACKAGENAME]), 
    'Question Category')

Mobile.pressBack()

Mobile.verifyElementExist(findTestObject('ShopOpen/Validate_ShopCategoriesListScreen' , [('package') : ProjectConstants.PACKAGENAME]), 0)

