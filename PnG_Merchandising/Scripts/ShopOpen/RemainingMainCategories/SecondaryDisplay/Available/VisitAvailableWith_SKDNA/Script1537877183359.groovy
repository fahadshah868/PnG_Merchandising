import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
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

Mobile.verifyElementExist(findTestObject('ShopOpen/RemainingMainCategories/SecondaryDisplay/Validate_SecondaryDisplayRemarksScreen'), 
    0)

CustomKeywords.'com.ct.qa.keywords.RemainingMainCategoriesRemarksKeywords.selectSecondaryDisplayRemark'('Available')

Mobile.verifyElementText(findTestObject('ShopOpen/RemainingMainCategories/SecondaryDisplay/Available/Validate_UnitsScreen'), 
    'Units')

Mobile.setText(findTestObject('ShopOpen/RemainingMainCategories/SecondaryDisplay/Available/Units_FirstEditField'), '1', 
    0)

Mobile.hideKeyboard()

Mobile.setText(findTestObject('ShopOpen/RemainingMainCategories/SecondaryDisplay/Available/Unit_SecondEditField'), '1', 
    0)

Mobile.hideKeyboard()

Mobile.tap(findTestObject('ShopOpen/RemainingMainCategories/SecondaryDisplay/Available/Units_SubmitButton'), 0)

Mobile.verifyElementExist(findTestObject('ShopOpen/RemainingMainCategories/SecondaryDisplay/Available/Validate_UnitsListScreen'), 
    0)

Mobile.tap(findTestObject('ShopOpen/RemainingMainCategories/SecondaryDisplay/Available/Unit1'), 0)

Mobile.verifyElementExist(findTestObject('CommonScreenElements/Validate_CameraScreen'), 0)

Mobile.tap(findTestObject('CommonScreenElements/TakePictureButton'), 0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('CommonScreenElements/DoneButton'), 0)

Mobile.verifyElementExist(findTestObject('ShopOpen/RemainingMainCategories/SecondaryDisplay/Available/Validate_AvailableRemarksScreen'), 
    0)

CustomKeywords.'com.ct.qa.keywords.RemainingMainCategoriesRemarksKeywords.selectSecondaryDisplay_AvailableRemark'('Shopkeeper did not allow')

Mobile.verifyElementText(findTestObject('ShopOpen/RemainingMainCategories/SecondaryDisplay/Available/Validate_SKDNA_CategoryRemarksScreen'), 
    'CATEGORY REMARKS')

Mobile.tap(findTestObject('ShopOpen/RemainingMainCategories/SecondaryDisplay/Available/SKDNA_CategoryRemark_Return'), 0)

Mobile.tap(findTestObject('ShopOpen/RemainingMainCategories/SecondaryDisplay/Available/SKDNA_CategoryRemark_BackButton'), 
    0)

Mobile.verifyElementExist(findTestObject('ShopOpen/RemainingMainCategories/SecondaryDisplay/Available/Validate_AvailableRemarksScreen'), 
    0)

Mobile.tap(findTestObject('ShopOpen/RemainingMainCategories/SecondaryDisplay/Available/AvailableRemarks_BackButton'), 0)

Mobile.verifyElementText(findTestObject('ShopOpen/RemainingMainCategories/SecondaryDisplay/Available/Validate_UtilizationPopUpScreen'), 
    'Utilization')

Mobile.setText(findTestObject('ShopOpen/RemainingMainCategories/SecondaryDisplay/Available/Utilization_EditField'), '50', 
    0)

Mobile.hideKeyboard()

Mobile.tap(findTestObject('ShopOpen/RemainingMainCategories/SecondaryDisplay/Available/Utilization_SubmitButton'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('ShopOpen/RemainingMainCategories/SecondaryDisplay/Available/Validate_UnitsListScreen'), 
    0)

Mobile.tap(findTestObject('ShopOpen/RemainingMainCategories/SecondaryDisplay/Available/UnitsList_BackButton'), 0)

CustomKeywords.'com.ct.qa.keywords.RemainingMainCategoriesRemarksKeywords.validateCategoryDetailActionScreen'()

