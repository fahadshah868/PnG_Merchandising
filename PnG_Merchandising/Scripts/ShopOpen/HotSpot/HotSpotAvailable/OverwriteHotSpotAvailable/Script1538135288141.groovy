import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import qa.constants.ProjectConstants as ProjectConstants
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

Mobile.verifyElementText(findTestObject('ShopOpen/HotSpot/HotSpotAvailable/Hotspot_SelectType', [('package') : ProjectConstants.PACKAGENAME]), 
    'Select appropriate type')

CustomKeywords.'qa.keywords.HotSpotKeywords.visitHotSpotType'(2)

Mobile.verifyElementText(findTestObject('ShopOpen/HotSpot/HotSpotAvailable/Validate_HotSpotProductCategories_Screen', [('package') : ProjectConstants.PACKAGENAME]), 
    'Category:HotSpot')

CustomKeywords.'qa.keywords.HotSpotKeywords.visitHotSpotProductCategories'(2)

Mobile.tap(findTestObject('ShopOpen/HotSpot/HotSpotAvailable/POSM_ImageView', [('package') : ProjectConstants.PACKAGENAME]), 
    0)

Mobile.verifyElementText(findTestObject('ShopOpen/HotSpot/HotSpotAvailable/Validate_POSMScreen', [('package') : ProjectConstants.PACKAGENAME]), 
    'POSM Deployment')

CustomKeywords.'qa.keywords.HotSpotKeywords.findPOSMImageView'()

Mobile.pressBack()

Mobile.verifyElementText(findTestObject('ShopOpen/HotSpot/HotSpotAvailable/Validate_HotSpotProductCategories_Screen', [('package') : ProjectConstants.PACKAGENAME]), 
    'Category:HotSpot')

CustomKeywords.'qa.keywords.CommonKeywords.findPlanogramImageView'()

Mobile.verifyElementText(findTestObject('ShopOpen/HotSpot/HotSpotAvailable/Validate_HotSpotProductCategories_Screen', [('package') : ProjectConstants.PACKAGENAME]), 
    'Category:HotSpot')

CustomKeywords.'qa.keywords.CommonKeywords.findPictureImageView'()

Mobile.verifyElementText(findTestObject('ShopOpen/HotSpot/HotSpotAvailable/Validate_HotSpotProductCategories_Screen', [('package') : ProjectConstants.PACKAGENAME]), 
    'Category:HotSpot')

CustomKeywords.'qa.keywords.CommonKeywords.findBackButtonImageView'()

Mobile.verifyElementText(findTestObject('ShopOpen/HotSpot/HotSpotAvailable/ValidateUtilization_Popup', [('package') : ProjectConstants.PACKAGENAME]), 
    'Utilization')

Mobile.tap(findTestObject('ShopOpen/HotSpot/HotSpotAvailable/HotSpotIsAvailableOnTheRightLocation_Yes', [('package') : ProjectConstants.PACKAGENAME]), 
    0)

CustomKeywords.'qa.keywords.HotSpotKeywords.enterUtilization'(2)

Mobile.hideKeyboard()

Mobile.tap(findTestObject('ShopOpen/HotSpot/HotSpotAvailable/Utilization_popupSubmitButton', [('package') : ProjectConstants.PACKAGENAME]), 
    0)

Mobile.verifyElementExist(findTestObject('ShopOpen/Validate_ShopCategoriesListScreen', [('package') : ProjectConstants.PACKAGENAME]), 
    0)

