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

MobileBuiltInKeywords.verifyElementText(findTestObject('ShopActionsScreenElements/Validate_ShopOptionsScreen'), 'Options')

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('ShopActionsScreenElements/StartWorking'), 0)

MobileBuiltInKeywords.delay(18)

MobileBuiltInKeywords.verifyElementExist(findTestObject('CommonScreenElements/Validate_MapScreen'), 0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('CommonScreenElements/CheckInButton'), 0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementExist(findTestObject('CommonScreenElements/Validate_InfoPopUpDialog'), 0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('CommonScreenElements/InfoPopUp_YesButton'), 0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementExist(findTestObject('ShopActionsScreenElements/ShopClosed'), 0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('ShopActionsScreenElements/ShopClosed'), 0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementExist(findTestObject('CommonScreenElements/Validate_CameraScreen'), 0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('CommonScreenElements/TakePictureButton'), 0)

MobileBuiltInKeywords.delay(5)

MobileBuiltInKeywords.tap(findTestObject('CommonScreenElements/DoneButton'), 0)

MobileBuiltInKeywords.delay(1)

