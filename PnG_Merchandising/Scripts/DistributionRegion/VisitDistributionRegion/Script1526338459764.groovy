import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

Mobile.verifyElementExist(findTestObject('DashboardScreenElements/StartYourDayButton'), 0)

MobileBuiltInKeywords.delay(1)

CustomKeywords.'customKeywordsCollection.CustomKeywords.selectCurrentDay'()

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('DashboardScreenElements/StartYourDayButton'), 0)

MobileBuiltInKeywords.delay(18)

MobileBuiltInKeywords.verifyElementExist(findTestObject('CommonScreenElements/Validate_MapScreen'), 0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('CommonScreenElements/CheckInButton'), 0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementExist(findTestObject('CommonScreenElements/Validate_InfoPopUpDialog'), 0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('CommonScreenElements/InfoPopUp_YesButton'), 0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementText(findTestObject('DistributionRegionScreenElements/Validate_RouteScreen'), 'Route Info')

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('DistributionRegionScreenElements/Route_NextButton'), 0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementExist(findTestObject('DistributionRegionScreenElements/Validate_FieldsScreen'), 0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.setText(findTestObject('DistributionRegionScreenElements/BrandMessage_TextField'), varBrandMessage, 
    0)

MobileBuiltInKeywords.setText(findTestObject('DistributionRegionScreenElements/CorporationMessage_TextField'), varCorporationMessage, 
    0)

MobileBuiltInKeywords.setText(findTestObject('DistributionRegionScreenElements/ValueMessage_TextField'), varValueMessage, 
    0)

MobileBuiltInKeywords.setText(findTestObject('DistributionRegionScreenElements/Poster_TextField'), varPoster, 0)

Mobile.hideKeyboard()

MobileBuiltInKeywords.tap(findTestObject('DistributionRegionScreenElements/Fields_SubmitButton'), 0)

MobileBuiltInKeywords.delay(1)

