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

TestData dataforoverwritediapers = findTestData('Data Files/Diapers/OverwriteDiapers')

MobileBuiltInKeywords.verifyElementExist(findTestObject('CommonScreenElements/Validate_InfoPopUpDialog'), 0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('CommonScreenElements/InfoPopUp_YesButton'), 0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementText(findTestObject('ShopProductsScreenElements/Diapers/Validate_DiapersScreen'), 'KPI: Diapers')

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/Diapers/VisitAvailability/Availability'), 0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementText(findTestObject('ShopProductsScreenElements/Diapers/VisitAvailability/Validate_AvailabilityScreen'), 
    'Category:Diapers')

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/Diapers/VisitAvailability/Pampers'), 0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementExist(findTestObject('ShopProductsScreenElements/Diapers/VisitAvailability/PampersAvailability'), 
    0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/Diapers/VisitAvailability/PampersAvailability'), 0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementText(findTestObject('ShopProductsScreenElements/Diapers/VisitAvailability/Validate_PampersAvailabilityScreen'), 
    'Availability')

MobileBuiltInKeywords.delay(1)

CustomKeywords.'customKeywordsCollection.CustomKeywords.overwritePampersAvailability'()

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/Diapers/VisitAvailability/PampersAvailability_SubmitButton'), 
    0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementExist(findTestObject('ShopProductsScreenElements/Diapers/VisitAvailability/PampersAvailability'), 
    0)

MobileBuiltInKeywords.delay(1)

Mobile.pressBack()

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementText(findTestObject('ShopProductsScreenElements/Diapers/VisitAvailability/Validate_AvailabilityScreen'), 
    'Category:Diapers')

MobileBuiltInKeywords.delay(1)

Mobile.pressBack()

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementText(findTestObject('ShopProductsScreenElements/Diapers/Validate_DiapersScreen'), 'KPI: Diapers')

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/Diapers/VisitPrimaryDisplay/PrimaryDisplay'), 0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementText(findTestObject('ShopProductsScreenElements/Diapers/VisitPrimaryDisplay/Validate_PrimaryDisplayScreen'), 
    'KPI: Diapers')

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/Diapers/VisitPrimaryDisplay/DisplaySpaceAvailable'), 
    0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementExist(findTestObject('CommonScreenElements/Validate_CameraScreen'), 0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('CommonScreenElements/TakePictureButton'), 0)

MobileBuiltInKeywords.delay(5)

MobileBuiltInKeywords.tap(findTestObject('CommonScreenElements/DoneButton'), 0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementText(findTestObject('ShopProductsScreenElements/Diapers/VisitPrimaryDisplay/Validate_DisplaySpaceAvailableScreen'), 
    'Category:Diapers')

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/Diapers/VisitPrimaryDisplay/Pampers'), 0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementText(findTestObject('ShopProductsScreenElements/Diapers/VisitPrimaryDisplay/Validate_DisplaySpaceAvailableForPampersScreen'), 
    'Channel: HFS Medium')

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/Diapers/VisitPrimaryDisplay/ShareOfShelf'), 0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementText(findTestObject('ShopProductsScreenElements/Diapers/VisitPrimaryDisplay/Validate_ShareOfShelfScreen'), 
    'Share of shelf')

MobileBuiltInKeywords.delay(1)

CustomKeywords.'customKeywordsCollection.CustomKeywords.overwriteShareOfShelfFields'()

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/Diapers/VisitPrimaryDisplay/ShareOfShelf_SubmitButton'), 
    0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementExist(findTestObject('CommonScreenElements/Alert_PopUpDialog'), 0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('CommonScreenElements/AlertPopup_SaveButton'), 0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementText(findTestObject('ShopProductsScreenElements/Diapers/VisitPrimaryDisplay/Validate_DisplaySpaceAvailableForPampersScreen'), 
    'Channel: HFS Medium')

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/Diapers/VisitPrimaryDisplay/DisplaySpaceAvailableForPampers_BackButton'), 
    0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementText(findTestObject('ShopProductsScreenElements/Diapers/VisitPrimaryDisplay/Validate_DisplaySpaceAvailableScreen'), 
    'Category:Diapers')

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/Diapers/VisitPrimaryDisplay/Planogram_ImageView'), 
    0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementExist(findTestObject('ShopProductsScreenElements/Diapers/VisitPrimaryDisplay/Planogram_CloseButton'), 
    0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/Diapers/VisitPrimaryDisplay/Planogram_CloseButton'), 
    0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementText(findTestObject('ShopProductsScreenElements/Diapers/VisitPrimaryDisplay/Validate_DisplaySpaceAvailableScreen'), 
    'Category:Diapers')

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/Diapers/VisitPrimaryDisplay/Picture_ImageView'), 0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementExist(findTestObject('CommonScreenElements/Validate_CameraScreen'), 0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('CommonScreenElements/TakePictureButton'), 0)

MobileBuiltInKeywords.delay(5)

MobileBuiltInKeywords.tap(findTestObject('CommonScreenElements/DoneButton'), 0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementText(findTestObject('ShopProductsScreenElements/Diapers/VisitPrimaryDisplay/Validate_DisplaySpaceAvailableScreen'), 
    'Category:Diapers')

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/Diapers/VisitPrimaryDisplay/DisplaySpaceAvailable_BackButton'), 
    0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementText(findTestObject('ShopProductsScreenElements/Diapers/Validate_DiapersScreen'), 'KPI: Diapers')

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/Diapers/VisitSecondaryDisplay/SecondaryDisplay'), 0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementText(findTestObject('ShopProductsScreenElements/Diapers/VisitSecondaryDisplay/Validate_SecondaryDisplayScreen'), 
    'KPI: Diapers')

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/Diapers/VisitSecondaryDisplay/Available'), 0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementText(findTestObject('ShopProductsScreenElements/Diapers/VisitSecondaryDisplay/Validate_SecondaryDisplayAvailableScreen'), 
    'P&G (Diapers)')

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.setText(findTestObject('ShopProductsScreenElements/Diapers/VisitSecondaryDisplay/UnitsForPG(Diapers)'), 
    '1', 0)

MobileBuiltInKeywords.setText(findTestObject('ShopProductsScreenElements/Diapers/VisitSecondaryDisplay/UnitsForCompetition(Diapers)'), 
    '1', 0)

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/Diapers/VisitSecondaryDisplay/SecondaryDisplayavailable_SubmitButton'), 
    0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementText(findTestObject('ShopProductsScreenElements/Diapers/VisitSecondaryDisplay/Validate_UnitScreen'), 
    'KPI: Diapers')

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/Diapers/VisitSecondaryDisplay/Unit1'), 0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementExist(findTestObject('CommonScreenElements/Validate_CameraScreen'), 0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('CommonScreenElements/TakePictureButton'), 0)

MobileBuiltInKeywords.delay(5)

MobileBuiltInKeywords.tap(findTestObject('CommonScreenElements/DoneButton'), 0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementText(findTestObject('ShopProductsScreenElements/Diapers/VisitSecondaryDisplay/Validate_UnitsDetailScreen'), 
    'KPI: Diapers')

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/Diapers/VisitSecondaryDisplay/ShopKeeperDidNotAllow'), 
    0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementText(findTestObject('ShopProductsScreenElements/Diapers/VisitSecondaryDisplay/Validate_CategoryRemarksScreenForShopKeeper'), 
    'CATEGORY REMARKS')

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/Diapers/VisitSecondaryDisplay/CategoryRemarksForShopKeeper_Return'), 
    0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/Diapers/VisitSecondaryDisplay/CategoryRemarksForShopKeeper_BackButton'), 
    0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementText(findTestObject('ShopProductsScreenElements/Diapers/VisitSecondaryDisplay/Validate_UnitsDetailScreen'), 
    'KPI: Diapers')

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/Diapers/VisitSecondaryDisplay/DisplayUnitNeedMaintenance'), 
    0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementText(findTestObject('ShopProductsScreenElements/Diapers/VisitSecondaryDisplay/Validate_CategoryRemarksScreenForDisplayUnit'), 
    'CATEGORY REMARKS')

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/Diapers/VisitSecondaryDisplay/CategoryRemarksForDisplayUnit_BrokenHeader'), 
    0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/Diapers/VisitSecondaryDisplay/CategoryRemarksForDisplayUnit_BackButton'), 
    0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementText(findTestObject('ShopProductsScreenElements/Diapers/VisitSecondaryDisplay/Validate_UnitsDetailScreen'), 
    'KPI: Diapers')

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/Diapers/VisitSecondaryDisplay/DisplayUnitIsInPerfectCondition'), 
    0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementText(findTestObject('ShopProductsScreenElements/Diapers/VisitSecondaryDisplay/Validate_DisplayUnitUtilizationScreen'), 
    'Utilization')

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.setText(findTestObject('ShopProductsScreenElements/Diapers/VisitSecondaryDisplay/DisplayUnitUtilization_TextField'), 
    dataforoverwritediapers.getObjectValue('Utilization (%)', 1), 0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/Diapers/VisitSecondaryDisplay/DisplayUnitUtilization_SubmitButton'), 
    0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementText(findTestObject('ShopProductsScreenElements/Diapers/VisitSecondaryDisplay/Validate_UnitScreen'), 
    'KPI: Diapers')

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/Diapers/VisitSecondaryDisplay/Unit_BackButton'), 0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementText(findTestObject('ShopProductsScreenElements/Diapers/VisitSecondaryDisplay/Validate_SecondaryDisplayScreen'), 
    'KPI: Diapers')

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.tap(findTestObject('ShopProductsScreenElements/Diapers/VisitSecondaryDisplay/SecondaryDisplay_BackButton'), 
    0)

MobileBuiltInKeywords.delay(1)

MobileBuiltInKeywords.verifyElementExist(findTestObject('ShopProductsScreenElements/Validate_ShopProductsScreen'), 0)

MobileBuiltInKeywords.delay(1)

