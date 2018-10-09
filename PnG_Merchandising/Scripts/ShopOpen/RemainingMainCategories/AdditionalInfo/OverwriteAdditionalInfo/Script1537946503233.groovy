import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.ct.qa.constants.ProjectConstants
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

Mobile.verifyElementText(findTestObject('ShopOpen/RemainingMainCategories/AdditionalInfo/Validate_QuestionsScreen', [('package') : ProjectConstants.PACKAGENAME]), 'Questions')

CustomKeywords.'com.ct.qa.keywords.RemainingMainCategoriesRemarksKeywords.overwriteAdditionalInfoQuestions'()

Mobile.tap(findTestObject('ShopOpen/RemainingMainCategories/AdditionalInfo/Questions_SubmitButton', [('package') : ProjectConstants.PACKAGENAME]), 0)

Mobile.verifyElementText(findTestObject('ShopOpen/RemainingMainCategories/AdditionalInfo/Validate_UtilizationPopupScreen', [('package') : ProjectConstants.PACKAGENAME]), 
    'Utilization')

Mobile.setText(findTestObject('ShopOpen/RemainingMainCategories/AdditionalInfo/Utilization_EditTextField', [('package') : ProjectConstants.PACKAGENAME]), '100', 0)

Mobile.hideKeyboard()

Mobile.tap(findTestObject('ShopOpen/RemainingMainCategories/AdditionalInfo/Utilization_PopupSubmitButton', [('package') : ProjectConstants.PACKAGENAME]), 0)

CustomKeywords.'com.ct.qa.keywords.RemainingMainCategoriesRemarksKeywords.validateCategoryDetailActionScreen'()

