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

TestData dataforhotspot = findTestData("Data Files/Hotspot/OverwriteHotspot")

MobileBuiltInKeywords.verifyElementText(findTestObject('ShopProductsScreenElements/HotSpot/Validate_HotSpotScreen'), 'KPI: HotSpot')

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/HotSpot/VisitHotSpotAvailable/HotSpotAvailable'), 0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementText(findTestObject('ShopProductsScreenElements/HotSpot/VisitHotSpotAvailable/Validate_SelectAppropriateTypeScreen'), 
    'Select appropriate type')

MobileBuiltInKeywords.delay(1)

CustomKeywords.'customKeywordsCollection.CustomKeywords.selectHotSpotAppropriateType'()

MobileBuiltInKeywords.verifyElementExist(findTestObject('CommonScreenElements/Validate_CameraScreen'), 0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('CommonScreenElements/TakePictureButton'), 0)

MobileBuiltInKeywords.delay(5)

MobileBuiltInKeywords.tap(findTestObject('CommonScreenElements/DoneButton'), 0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementText(findTestObject('ShopProductsScreenElements/HotSpot/VisitHotSpotAvailable/Validate_HotSpotAvailableScreen'), 
    'Category:HotSpot')

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/HotSpot/VisitHotSpotAvailable/Facing'), 0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementText(findTestObject('ShopProductsScreenElements/HotSpot/VisitHotSpotAvailable/Validate_FacingScreen'), 
    'Facing')

MobileBuiltInKeywords.delay(1)

Mobile.setText(findTestObject('ShopProductsScreenElements/HotSpot/VisitHotSpotAvailable/AlwaysMaxiThicksExtraLong_TextField'), 
   dataforhotspot.getObjectValue("Always Maxi Thicks Extra Long", 1), 0)

Mobile.hideKeyboard()

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/HotSpot/VisitHotSpotAvailable/SubmitButton'), 0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementExist(findTestObject('CommonScreenElements/Validate_InfoPopUpDialog'), 0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('CommonScreenElements/InfoPopUp_OKButton'), 0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementText(findTestObject('ShopProductsScreenElements/HotSpot/VisitHotSpotAvailable/Validate_HotSpotAvailableScreen'), 
    'Category:HotSpot')

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/HotSpot/VisitHotSpotAvailable/POSMImageView'), 0)

MobileBuiltInKeywords.delay(1)

CustomKeywords.'customKeywordsCollection.CustomKeywords.selectPOSM'()

MobileBuiltInKeywords.verifyElementText(findTestObject('ShopProductsScreenElements/HotSpot/VisitHotSpotAvailable/Validate_POSMRemarksScreen'), 
    'Remarks')

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/HotSpot/VisitHotSpotAvailable/POSMRemarks_AlreadyDeployed'), 
    0)

MobileBuiltInKeywords.delay(1)

Mobile.pressBack()

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementText(findTestObject('ShopProductsScreenElements/HotSpot/VisitHotSpotAvailable/Validate_HotSpotAvailableScreen'), 
    'Category:HotSpot')

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/HotSpot/VisitHotSpotAvailable/PlanogramImageView'), 
    0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementExist(findTestObject('ShopProductsScreenElements/HotSpot/VisitHotSpotAvailable/Planogram_CloseButton'), 
    0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/HotSpot/VisitHotSpotAvailable/Planogram_CloseButton'), 
    0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementText(findTestObject('ShopProductsScreenElements/HotSpot/VisitHotSpotAvailable/Validate_HotSpotAvailableScreen'), 
    'Category:HotSpot')

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/HotSpot/VisitHotSpotAvailable/PictureImageView'), 0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementExist(findTestObject('CommonScreenElements/Validate_CameraScreen'), 0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('CommonScreenElements/TakePictureButton'), 0)

MobileBuiltInKeywords.delay(5)

MobileBuiltInKeywords.tap(findTestObject('CommonScreenElements/DoneButton'), 0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementText(findTestObject('ShopProductsScreenElements/HotSpot/VisitHotSpotAvailable/Validate_HotSpotAvailableScreen'), 
    'Category:HotSpot')

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/HotSpot/VisitHotSpotAvailable/HotSpotAvailable_BackButton'), 
    0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementText(findTestObject('ShopProductsScreenElements/HotSpot/VisitHotSpotAvailable/Validate_HotSpotUtilizationScreen'), 
    'Utilization')

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/HotSpot/VisitHotSpotAvailable/HotSpotUtilization_NoRadioButton'), 
    0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.setText(findTestObject('ShopProductsScreenElements/HotSpot/VisitHotSpotAvailable/HotSpotUtilization_TextField'), 
    dataforhotspot.getObjectValue("Hotspot Utilization (%)", 1), 0)

Mobile.hideKeyboard()

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/HotSpot/VisitHotSpotAvailable/HotSpotUtilization_SubmitButton'), 
    0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementText(findTestObject('ShopProductsScreenElements/HotSpot/Validate_HotSpotScreen'), 'KPI: HotSpot')

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/HotSpot/HotSpot_BackButton'), 0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementExist(findTestObject('ShopProductsScreenElements/Validate_ShopProductsScreen'), 0)

MobileBuiltInKeywords.delay(1)

