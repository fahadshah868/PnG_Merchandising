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

MobileBuiltInKeywords.verifyElementText(findTestObject('ShopProductsScreenElements/Hanger/Validate_HangerScreen'), 'Hanger List')

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/Hanger/CorporateHanger'), 0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementText(findTestObject('ShopProductsScreenElements/Hanger/Corporate Hanger/Validate_CorporateHangerScreen'), 
    'KPI: Hanger')

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/Hanger/Corporate Hanger/SKDNA/SKDNA'), 0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementText(findTestObject('ShopProductsScreenElements/Hanger/Corporate Hanger/SKDNA/Validate_CategoryRemarksScreen'), 
    'CATEGORY REMARKS')

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/Hanger/Corporate Hanger/SKDNA/CategoryRemarks_Others'), 
    0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/Hanger/Corporate Hanger/SKDNA/CategoryRemarks_BackButton'), 
    0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementText(findTestObject('ShopProductsScreenElements/Hanger/Validate_HangerScreen'), 'Hanger List')

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/Hanger/CorporateHanger'), 0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementText(findTestObject('ShopProductsScreenElements/Hanger/Corporate Hanger/Validate_CorporateHangerScreen'), 
    'KPI: Hanger')

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/Hanger/Corporate Hanger/HangerAvailable_And_HangerNotAvailable/HangerNotAvailable'), 
    0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementExist(findTestObject('CommonScreenElements/Validate_CameraScreen'), 0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('CommonScreenElements/TakePictureButton'), 0)

MobileBuiltInKeywords.delay(5)

MobileBuiltInKeywords.tap(findTestObject('CommonScreenElements/DoneButton'), 0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementText(findTestObject('ShopProductsScreenElements/Hanger/Corporate Hanger/HangerAvailable_And_HangerNotAvailable/Validate_HangerAvailableAndNotAvailableScreen'), 
    'Category:Hanger')

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/Hanger/Corporate Hanger/HangerAvailable_And_HangerNotAvailable/Availability'), 
    0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementText(findTestObject('ShopProductsScreenElements/Hanger/Corporate Hanger/HangerAvailable_And_HangerNotAvailable/Validate_AvailabilityScreen'), 
    'Availability')

MobileBuiltInKeywords.delay(1)

CustomKeywords.'customKeywordsCollection.CustomKeywords.visitHangerProducts'()

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/Hanger/Corporate Hanger/HangerAvailable_And_HangerNotAvailable/SubmitButton'), 
    0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementText(findTestObject('ShopProductsScreenElements/Hanger/Corporate Hanger/HangerAvailable_And_HangerNotAvailable/Validate_HangerAvailableAndNotAvailableScreen'), 
    'Category:Hanger')

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/Hanger/Corporate Hanger/HangerAvailable_And_HangerNotAvailable/Planogram_ImageView'), 
    0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementExist(findTestObject('ShopProductsScreenElements/Hanger/Corporate Hanger/HangerAvailable_And_HangerNotAvailable/Planogram_CloseButton'), 
    0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/Hanger/Corporate Hanger/HangerAvailable_And_HangerNotAvailable/Planogram_CloseButton'), 
    0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementText(findTestObject('ShopProductsScreenElements/Hanger/Corporate Hanger/HangerAvailable_And_HangerNotAvailable/Validate_HangerAvailableAndNotAvailableScreen'), 
    'Category:Hanger')

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/Hanger/Corporate Hanger/HangerAvailable_And_HangerNotAvailable/Picture_ImageView'), 
    0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementExist(findTestObject('CommonScreenElements/Validate_CameraScreen'), 0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('CommonScreenElements/TakePictureButton'), 0)

MobileBuiltInKeywords.delay(5)

MobileBuiltInKeywords.tap(findTestObject('CommonScreenElements/DoneButton'), 0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementText(findTestObject('ShopProductsScreenElements/Hanger/Corporate Hanger/HangerAvailable_And_HangerNotAvailable/Validate_HangerAvailableAndNotAvailableScreen'), 
    'Category:Hanger')

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/Hanger/Corporate Hanger/HangerAvailable_And_HangerNotAvailable/BackButton'), 
    0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementText(findTestObject('ShopProductsScreenElements/Hanger/Corporate Hanger/Validate_CorporateHangerScreen'), 
    'KPI: Hanger')

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/Hanger/Corporate Hanger/HangerAvailable_And_HangerNotAvailable/HangerAvailable'), 
    0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementExist(findTestObject('CommonScreenElements/Validate_CameraScreen'), 0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('CommonScreenElements/TakePictureButton'), 0)

MobileBuiltInKeywords.delay(5)

MobileBuiltInKeywords.tap(findTestObject('CommonScreenElements/DoneButton'), 0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementText(findTestObject('ShopProductsScreenElements/Hanger/Corporate Hanger/HangerAvailable_And_HangerNotAvailable/Validate_HangerAvailableAndNotAvailableScreen'), 
    'Category:Hanger')

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/Hanger/Corporate Hanger/HangerAvailable_And_HangerNotAvailable/Availability'), 
    0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementText(findTestObject('ShopProductsScreenElements/Hanger/Corporate Hanger/HangerAvailable_And_HangerNotAvailable/Validate_AvailabilityScreen'), 
    'Availability')

MobileBuiltInKeywords.delay(1)

CustomKeywords.'customKeywordsCollection.CustomKeywords.visitHangerProducts'()

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/Hanger/Corporate Hanger/HangerAvailable_And_HangerNotAvailable/SubmitButton'), 
    0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementText(findTestObject('ShopProductsScreenElements/Hanger/Corporate Hanger/HangerAvailable_And_HangerNotAvailable/Validate_HangerAvailableAndNotAvailableScreen'), 
    'Category:Hanger')

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/Hanger/Corporate Hanger/HangerAvailable_And_HangerNotAvailable/Planogram_ImageView'), 
    0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementExist(findTestObject('ShopProductsScreenElements/Hanger/Corporate Hanger/HangerAvailable_And_HangerNotAvailable/Planogram_CloseButton'), 
    0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/Hanger/Corporate Hanger/HangerAvailable_And_HangerNotAvailable/Planogram_CloseButton'), 
    0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementText(findTestObject('ShopProductsScreenElements/Hanger/Corporate Hanger/HangerAvailable_And_HangerNotAvailable/Validate_HangerAvailableAndNotAvailableScreen'), 
    'Category:Hanger')

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/Hanger/Corporate Hanger/HangerAvailable_And_HangerNotAvailable/Picture_ImageView'), 
    0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementExist(findTestObject('CommonScreenElements/Validate_CameraScreen'), 0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('CommonScreenElements/TakePictureButton'), 0)

MobileBuiltInKeywords.delay(5)

MobileBuiltInKeywords.tap(findTestObject('CommonScreenElements/DoneButton'), 0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementText(findTestObject('ShopProductsScreenElements/Hanger/Corporate Hanger/HangerAvailable_And_HangerNotAvailable/Validate_HangerAvailableAndNotAvailableScreen'), 
    'Category:Hanger')

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/Hanger/Corporate Hanger/HangerAvailable_And_HangerNotAvailable/BackButton'), 
    0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementText(findTestObject('ShopProductsScreenElements/Hanger/Corporate Hanger/Validate_CorporateHangerScreen'), 
    'KPI: Hanger')

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/Hanger/Corporate Hanger/CorporateHanger_BackButton'), 
    0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementText(findTestObject('ShopProductsScreenElements/Hanger/Validate_HangerScreen'), 'Hanger List')

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.pressBack()

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementExist(findTestObject('ShopProductsScreenElements/Validate_ShopProductsScreen'), 0)

MobileBuiltInKeywords.delay(1)

