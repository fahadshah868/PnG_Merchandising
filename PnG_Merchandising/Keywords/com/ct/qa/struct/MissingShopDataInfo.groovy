package com.ct.qa.struct

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

public class MissingShopDataInfo {
	public String shopname
	public String shopchannel
	public String scenario
	public ArrayList<MissingMainCategoryData> missingmaincategories
	public String missingmaincategories_errormessage
	public String getShopname() {
		return shopname;
	}
	public void setShopname(String shopname) {
		this.shopname = shopname;
	}
	public String getShopchannel() {
		return shopchannel;
	}
	public void setShopchannel(String shopchannel) {
		this.shopchannel = shopchannel;
	}
	public String getScenario() {
		return scenario;
	}
	public void setScenario(String scenario) {
		this.scenario = scenario;
	}
	public ArrayList<MissingMainCategoryData> getMissingmaincategories() {
		return missingmaincategories;
	}
	public void setMissingmaincategories(ArrayList<MissingMainCategoryData> missingmaincategories) {
		this.missingmaincategories = missingmaincategories;
	}
	public String getMissingmaincategories_errormessage() {
		return missingmaincategories_errormessage;
	}
	public void setMissingmaincategories_errormessage(String missingmaincategories_errormessage) {
		this.missingmaincategories_errormessage = missingmaincategories_errormessage;
	}
	
}
