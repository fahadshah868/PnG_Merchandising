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

Mobile.verifyElementText(findTestObject('ShopOpen/RemainingMainCategories/_Availability/Validate_SubCategoryDetailScreen'), 
    'Availability')

Mobile.tap(findTestObject('ShopOpen/RemainingMainCategories/_Availability/Availability'), 0)

Mobile.verifyElementText(findTestObject('ShopOpen/RemainingMainCategories/_Availability/Validate_ProductAvailabilityScreen'), 
    'Availability')

CustomKeywords.'com.ct.qa.keywords.RemainingMainCategoriesRemarksKeywords.visitProductsAvailabilityWithYesRemarks'()

Mobile.tap(findTestObject('ShopOpen/RemainingMainCategories/_Availability/ProductAvailability_SubmitButton'), 0)

Mobile.verifyElementText(findTestObject('ShopOpen/RemainingMainCategories/_Availability/Validate_SubCategoryDetailScreen'), 
    'Availability')

Mobile.pressBack()

Mobile.verifyElementExist(findTestObject('ShopOpen/RemainingMainCategories/_Availability/Validate_SubCategoriesScreen'), 
    0)

