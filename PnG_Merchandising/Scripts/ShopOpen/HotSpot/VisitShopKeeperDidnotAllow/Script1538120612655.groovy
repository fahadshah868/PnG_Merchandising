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

Mobile.verifyElementExist(findTestObject('ShopOpen/HotSpot/Validate_HotSpotRemarksScreen', [('package') : ProjectConstants.PACKAGENAME]), 0)

CustomKeywords.'com.ct.qa.keywords.HotSpotKeywords.selectHotSpotRemark'('Shopkeeper did not allow')

Mobile.verifyElementText(findTestObject('ShopOpen/HotSpot/ShopKeeperDidnotAllow/Validate_CategoryRemarksScreen', [('package') : ProjectConstants.PACKAGENAME]), 'CATEGORY REMARKS')

Mobile.tap(findTestObject('ShopOpen/HotSpot/ShopKeeperDidnotAllow/CategoryRemarks_Return', [('package') : ProjectConstants.PACKAGENAME]), 0)

Mobile.tap(findTestObject('ShopOpen/HotSpot/ShopKeeperDidnotAllow/CategoryRemarks_BackButton', [('package') : ProjectConstants.PACKAGENAME]), 0)

Mobile.verifyElementExist(findTestObject('ShopOpen/Validate_ShopCategoriesListScreen', [('package') : ProjectConstants.PACKAGENAME]), 0)

