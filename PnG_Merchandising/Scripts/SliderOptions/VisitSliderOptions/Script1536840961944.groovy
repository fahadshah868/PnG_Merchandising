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

Mobile.verifyElementText(findTestObject('DashboardScreenElements/Validate_DashboardScreen', [('package') : ProjectConstants.PACKAGENAME]), 'Dashboard')

Mobile.swipe(2, 250, 400, 250)

Mobile.swipe(2, 250, 400, 250)

CustomKeywords.'com.ct.qa.keywords.SliderOptionsKeywords.valideSliderOptions'()

Mobile.swipe(5, 200, 5, 500)

Mobile.swipe(5, 200, 5, 500)

CustomKeywords.'com.ct.qa.keywords.SliderOptionsKeywords.findSliderOption'('Update Profile')

Mobile.verifyElementText(findTestObject('SliderOptions/UpdateProfile_EnterEmail', [('package') : ProjectConstants.PACKAGENAME]), 'Enter email')

Mobile.verifyElementText(findTestObject('SliderOptions/UpdateProfile_EnterPhone', [('package') : ProjectConstants.PACKAGENAME]), 'Enter Phone')

Mobile.verifyElementText(findTestObject('SliderOptions/UpdateProfile_EnterCNIC', [('package') : ProjectConstants.PACKAGENAME]), 'Enter CNIC')

Mobile.verifyElementText(findTestObject('SliderOptions/UpdateProfile_SubmitButton', [('package') : ProjectConstants.PACKAGENAME]), 'Update Profile')

Mobile.pressBack()

CustomKeywords.'com.ct.qa.keywords.SliderOptionsKeywords.findSliderOption'('Setting')

Mobile.verifyElementText(findTestObject('SliderOptions/Validate_Setting_ShopsonRouteScreen', [('package') : ProjectConstants.PACKAGENAME]), 'Shops on Route')

Mobile.tap(findTestObject('SliderOptions/BackButton', [('package') : ProjectConstants.PACKAGENAME]), 0)

CustomKeywords.'com.ct.qa.keywords.SliderOptionsKeywords.findSliderOption'('Out of Route')

Mobile.verifyElementText(findTestObject('SliderOptions/Validate_OutOfRoute_RouteListScreen', [('package') : ProjectConstants.PACKAGENAME]), 'Route LIST')

CustomKeywords.'com.ct.qa.keywords.SliderOptionsKeywords.findRoute'()

Mobile.verifyElementText(findTestObject('SliderOptions/Validate_OutOfRoute_ShopOnRouteScreen', [('package') : ProjectConstants.PACKAGENAME]), 'Shops on Route')

Mobile.pressBack()

Mobile.verifyElementText(findTestObject('SliderOptions/Validate_OutOfRoute_RouteListScreen', [('package') : ProjectConstants.PACKAGENAME]), 'Route LIST')

Mobile.pressBack()

CustomKeywords.'com.ct.qa.keywords.SliderOptionsKeywords.findSliderOption'('Info')

Mobile.verifyElementText(findTestObject('SliderOptions/Validate_LoginCode', [('package') : ProjectConstants.PACKAGENAME]), 'Login Code')

Mobile.verifyElementText(findTestObject('SliderOptions/Validate_LoginTime', [('package') : ProjectConstants.PACKAGENAME]), 'Login Time')

Mobile.verifyElementText(findTestObject('SliderOptions/Validate_SyncAttempted', [('package') : ProjectConstants.PACKAGENAME]), 'Sync Attempted')

Mobile.verifyElementText(findTestObject('SliderOptions/Validate_SyncSuccessful', [('package') : ProjectConstants.PACKAGENAME]), 'Sync Successful')

Mobile.verifyElementText(findTestObject('SliderOptions/Validate_RefreshRoutes', [('package') : ProjectConstants.PACKAGENAME]), 'Refresh Routes')

Mobile.verifyElementText(findTestObject('SliderOptions/Validate_BuildVersion', [('package') : ProjectConstants.PACKAGENAME]), 'Build Version')

Mobile.pressBack()

Mobile.swipe(320, 5, 2, 5)

Mobile.swipe(320, 5, 2, 5)

CustomKeywords.'com.ct.qa.keywords.SliderOptionsKeywords.displayMissingSliderOptionsInReport'()

