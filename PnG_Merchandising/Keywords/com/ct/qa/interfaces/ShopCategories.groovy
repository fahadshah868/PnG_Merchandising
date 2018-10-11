package com.ct.qa.interfaces

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

public interface ShopCategories {

	/* format for method prototype
	 _Hanger/HotSpot_Availability_Primary Display_Secondary Display_Addtitional Info
	 */

	/*  visit secondary display available ** create 4 units
	 unit1 => Display unit need maintenance
	 unit2 => SKDNA
	 unit3 => SKDNA
	 unit4 => Display Unit Is In Perfect condition
	 overwrite secondary display available ** create 4 units
	 unit1 => Display unit need maintenance(different remarks)
	 unit2 => SKDNA(different remarks)
	 unit3 => Display Unit Need Maintenance
	 unit4 => Display Unit Need Maintenance 	
	 */

	// for data verification
	def visitShopCategoriesWithDataVerification()

	// for overwrite scenarios
	def visitShopCategoriesWith_HA_AY_DSA_Available_AIY()
	def visitShopCategoriesWith_HNA_AN_NSFD_NAvailable_AIN()

	//	def visitShopCategoriesWith_HA_AY_DSA_Available_AIY()
	def overwriteShopCategoriesWith_HA_AY_DSA_Available_AIY()

	def visitShopCategoriesWith_SKDNA_AY_SKDNA_Available_AIY()
	def overwriteShopCategoriesWith_SKDNA_AY_SKDNA_Available_AIY()

	def visitShopCategoriesWith_SKDNA_AY_SKDNA_NR_AIN()
	def visitShopCategoriesWith_HA_AN_DSA_NAvailable_AIY()

	//	def visitShopCategoriesWith_SKDNA_AY_SKDNA_NR_AIN()
	def visitShopCategoriesWith_HNA_AN_NSFD_Available_AIY()

	//	def visitShopCategoriesWith_HNA_AN_NSFD_NAvailable_AIN()
	//	def visitShopCategoriesWith_HA_AY_DSA_Available_AIY()

	def visitShopCategoriesWith_HNA_AN_NR_NAvailable_AIN()
	def visitShopCategoriesWith_HA_AY_SKDNA_Available_AIY()
}
