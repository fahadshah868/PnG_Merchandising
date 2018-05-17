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



RunConfiguration.setExecutionSettingFile("D:\\(Katalon studio) GitProject\\PnG_Merchandising\\PnG_Merchandising\\Reports\\PnG Merchandising Scripts With Overwrite Scenarios\\20180517_041720\\execution.properties")

TestCaseMain.beforeStart()

TestCaseMain.startTestSuite('Test Suites/PnG Merchandising Scripts With Overwrite Scenarios', suiteProperties, [new TestCaseBinding('Test Cases/LaunchingApp/LaunchApp', 'Test Cases/LaunchingApp/LaunchApp',  null), new TestCaseBinding('Test Cases/DistributionRegion/VisitDistributionRegion', 'Test Cases/DistributionRegion/VisitDistributionRegion',  [ 'varValueMessage' : '103' , 'varPoster' : '100' , 'varCorporationMessage' : '102' , 'varBrandMessage' : '101' ,  ]), new TestCaseBinding('Test Cases/ChooseHFSShop/SelectAndStartYourDay', 'Test Cases/ChooseHFSShop/SelectAndStartYourDay',  null), new TestCaseBinding('Test Cases/ChooseHFSShop/ChooseShopForShopClosed', 'Test Cases/ChooseHFSShop/ChooseShopForShopClosed',  null), new TestCaseBinding('Test Cases/ChooseHFSShop/ShopClosed/VisitShopClosed', 'Test Cases/ChooseHFSShop/ShopClosed/VisitShopClosed',  null), new TestCaseBinding('Test Cases/ChooseHFSShop/ChooseShopForShopPermanentlyClosed', 'Test Cases/ChooseHFSShop/ChooseShopForShopPermanentlyClosed',  null), new TestCaseBinding('Test Cases/ChooseHFSShop/ShopPermanentlyClosed/VisitShopPermanentlyClosed', 'Test Cases/ChooseHFSShop/ShopPermanentlyClosed/VisitShopPermanentlyClosed',  null), new TestCaseBinding('Test Cases/ChooseHFSShop/ChooseShopForShopNotFound', 'Test Cases/ChooseHFSShop/ChooseShopForShopNotFound',  null), new TestCaseBinding('Test Cases/ChooseHFSShop/ShopNotFound/VisitShopNotFound', 'Test Cases/ChooseHFSShop/ShopNotFound/VisitShopNotFound',  null), new TestCaseBinding('Test Cases/ChooseHFSShop/ChooseShopForShopToBeRemoved', 'Test Cases/ChooseHFSShop/ChooseShopForShopToBeRemoved',  null), new TestCaseBinding('Test Cases/ChooseHFSShop/ShopToBeRemoved/VisitShopToBeRemoved', 'Test Cases/ChooseHFSShop/ShopToBeRemoved/VisitShopToBeRemoved',  null), new TestCaseBinding('Test Cases/ChooseHFSShop/ChooseShopForAreaClosed', 'Test Cases/ChooseHFSShop/ChooseShopForAreaClosed',  null), new TestCaseBinding('Test Cases/ChooseHFSShop/AreaClosed/VisitAreaClosed', 'Test Cases/ChooseHFSShop/AreaClosed/VisitAreaClosed',  null), new TestCaseBinding('Test Cases/ChooseHFSShop/ChooseShopForRetailerDidNotAllow', 'Test Cases/ChooseHFSShop/ChooseShopForRetailerDidNotAllow',  null), new TestCaseBinding('Test Cases/ChooseHFSShop/RetailerDidNotAllow/VisitRetailerDidNotAllow', 'Test Cases/ChooseHFSShop/RetailerDidNotAllow/VisitRetailerDidNotAllow',  null), new TestCaseBinding('Test Cases/ChooseHFSShop/ChooseShopForShopOpen', 'Test Cases/ChooseHFSShop/ChooseShopForShopOpen',  null), new TestCaseBinding('Test Cases/ChooseHFSShop/ShopOpen/VisitShopOpen', 'Test Cases/ChooseHFSShop/ShopOpen/VisitShopOpen',  null), new TestCaseBinding('Test Cases/ChooseHFSShop/ShopOpen/ShopProducts/VisitShopProducts', 'Test Cases/ChooseHFSShop/ShopOpen/ShopProducts/VisitShopProducts',  null), new TestCaseBinding('Test Cases/ChooseHFSShop/ShopOpen/ShopProducts/OverwriteShopProducts', 'Test Cases/ChooseHFSShop/ShopOpen/ShopProducts/OverwriteShopProducts',  null), new TestCaseBinding('Test Cases/ChooseHFSShop/ShopOpen/SaveShop', 'Test Cases/ChooseHFSShop/ShopOpen/SaveShop',  null)])
