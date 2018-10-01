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

Mobile.verifyElementText(findTestObject('ShopOpen/Hanger/Validate_HangerRemarksScreen'), 'KPI: Hanger')

CustomKeywords.'com.ct.qa.keywords.HangerKeywords.selectHangerRemark'('Hanger Available')

Mobile.verifyElementExist(findTestObject('CommonScreenElements/Validate_CameraScreen'), 0)

Mobile.tap(findTestObject('CommonScreenElements/TakePictureButton'), 0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('CommonScreenElements/DoneButton'), 0)

Mobile.verifyElementText(findTestObject('ShopOpen/Hanger/HangerAvailable/Validate_HangerAvailabilityScreen'), 'Category:Hanger')

Mobile.tap(findTestObject('ShopOpen/Hanger/HangerAvailable/Availability'), 0)

Mobile.verifyElementText(findTestObject('ShopOpen/Hanger/HangerAvailable/Validate_ProductsAvailabilityScreen'), 'Availability')

CustomKeywords.'com.ct.qa.keywords.HangerKeywords.visitHangerProducts'(ProjectConstants.OVERWRITEHANGERNOTAVAILABLE, 'Overwrite Hanger Not Available')

Mobile.tap(findTestObject('ShopOpen/Hanger/HangerAvailable/SubmitButton'), 0)

Mobile.verifyElementText(findTestObject('ShopOpen/Hanger/HangerAvailable/Validate_HangerAvailabilityScreen'), 'Category:Hanger')

CustomKeywords.'com.ct.qa.keywords.CommonKeywords.findPlanogramImageView'()

Mobile.verifyElementText(findTestObject('ShopOpen/Hanger/HangerAvailable/Validate_HangerAvailabilityScreen'), 'Category:Hanger')

CustomKeywords.'com.ct.qa.keywords.CommonKeywords.findPictureImageView'()

Mobile.verifyElementText(findTestObject('ShopOpen/Hanger/HangerAvailable/Validate_HangerAvailabilityScreen'), 'Category:Hanger')

CustomKeywords.'com.ct.qa.keywords.CommonKeywords.findBackButtonImageView'()

Mobile.verifyElementText(findTestObject('ShopOpen/Hanger/Validate_HangerRemarksScreen'), 'KPI: Hanger')

Mobile.tap(findTestObject('ShopOpen/Hanger/Backbutton'), 0)

Mobile.verifyElementText(findTestObject('ShopOpen/Hanger/Validate_HangerListScreen'), 'Hanger List')

