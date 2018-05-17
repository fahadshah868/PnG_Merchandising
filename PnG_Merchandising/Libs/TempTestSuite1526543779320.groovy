import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.reporting.ReportUtil
import com.kms.katalon.core.main.TestCaseMain
import com.kms.katalon.core.testdata.TestDataColumn
import groovy.lang.MissingPropertyException
import com.kms.katalon.core.testcase.TestCaseBinding
import com.kms.katalon.core.driver.internal.DriverCleanerCollector
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.configuration.RunConfiguration
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData

Map<String, String> suiteProperties = new HashMap<String, String>();


suiteProperties.put('id', 'Test Suites/PnG Merchandising Scripts With Overwrite Scenarios')

suiteProperties.put('name', 'PnG Merchandising Scripts With Overwrite Scenarios')

suiteProperties.put('description', '')
 

DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.webui.contribution.WebUiDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.mobile.contribution.MobileDriverCleaner())



RunConfiguration.setExecutionSettingFile("D:\\(Katalon studio) GitProject\\PnG_Merchandising\\PnG_Merchandising\\Reports\\PnG Merchandising Scripts With Overwrite Scenarios\\20180517_005619\\execution.properties")

TestCaseMain.beforeStart()

TestCaseMain.startTestSuite('Test Suites/PnG Merchandising Scripts With Overwrite Scenarios', suiteProperties, [new TestCaseBinding('Test Cases/LaunchingApp/LaunchApp', 'Test Cases/LaunchingApp/LaunchApp',  null), new TestCaseBinding('Test Cases/ChooseHFSShop/SelectAndStartYourDay', 'Test Cases/ChooseHFSShop/SelectAndStartYourDay',  null), new TestCaseBinding('Test Cases/ChooseHFSShop/ChooseShopForShopOpen', 'Test Cases/ChooseHFSShop/ChooseShopForShopOpen',  null), new TestCaseBinding('Test Cases/ChooseHFSShop/ShopOpen/VisitShopOpen', 'Test Cases/ChooseHFSShop/ShopOpen/VisitShopOpen',  null), new TestCaseBinding('Test Cases/ChooseHFSShop/ShopOpen/ShopProducts/VisitShopProducts', 'Test Cases/ChooseHFSShop/ShopOpen/ShopProducts/VisitShopProducts',  null), new TestCaseBinding('Test Cases/ChooseHFSShop/ShopOpen/ShopProducts/OverwriteShopProducts', 'Test Cases/ChooseHFSShop/ShopOpen/ShopProducts/OverwriteShopProducts',  null), new TestCaseBinding('Test Cases/ChooseHFSShop/ShopOpen/SaveShop', 'Test Cases/ChooseHFSShop/ShopOpen/SaveShop',  null)])
