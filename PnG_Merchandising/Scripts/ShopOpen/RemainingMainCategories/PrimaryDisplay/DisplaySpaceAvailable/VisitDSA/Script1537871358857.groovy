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

Mobile.verifyElementExist(findTestObject('ShopOpen/RemainingMainCategories/PrimaryDisplay/Validate_PrimaryDisplayRemarksScreen'), 
    0)

CustomKeywords.'com.ct.qa.keywords.RemainingMainCategoriesRemarksKeywords.selectPrimaryDisplayRemark'('Display Space Available')

Mobile.verifyElementExist(findTestObject('CommonScreenElements/Validate_CameraScreen'), 0)

Mobile.tap(findTestObject('CommonScreenElements/TakePictureButton'), 0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('CommonScreenElements/DoneButton'), 0)

Mobile.verifyElementExist(findTestObject('ShopOpen/RemainingMainCategories/PrimaryDisplay/DisplaySpaceAvailable/Validate_SubCategoriesScreen'), 
    0)

CustomKeywords.'com.ct.qa.keywords.RemainingMainCategoriesRemarksKeywords.visitPrimaryDisplay_WithDSASubCategories'(1)

CustomKeywords.'com.ct.qa.keywords.CommonKeywords.findPlanogramImageView'()

Mobile.verifyElementExist(findTestObject('ShopOpen/RemainingMainCategories/PrimaryDisplay/DisplaySpaceAvailable/Validate_SubCategoriesScreen'), 
    0)

CustomKeywords.'com.ct.qa.keywords.CommonKeywords.findPictureImageView'()

Mobile.verifyElementExist(findTestObject('ShopOpen/RemainingMainCategories/PrimaryDisplay/DisplaySpaceAvailable/Validate_SubCategoriesScreen'), 
    0)

CustomKeywords.'com.ct.qa.keywords.CommonKeywords.findBackButtonImageView'()

CustomKeywords.'com.ct.qa.keywords.RemainingMainCategoriesRemarksKeywords.validateCategoryDetailActionScreen'()

