package com.ct.qa.struct

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class ShopProductsData {
	public String product
	public String pd_displayspaceavailable
	public String pd_overwrite_displayspaceavailable
	public String hangeravailable
	public String hangernotavailable
	public String overwrite_hangeravailable
	public String overwrite_hangernotavailable
	public String hs_facing
	public String overwrite_hs_facing
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getPd_displayspaceavailable() {
		return pd_displayspaceavailable;
	}
	public void setPd_displayspaceavailable(String pd_displayspaceavailable) {
		this.pd_displayspaceavailable = pd_displayspaceavailable;
	}
	public String getPd_overwrite_displayspaceavailable() {
		return pd_overwrite_displayspaceavailable;
	}
	public void setPd_overwrite_displayspaceavailable(String pd_overwrite_displayspaceavailable) {
		this.pd_overwrite_displayspaceavailable = pd_overwrite_displayspaceavailable;
	}
	public String getHangeravailable() {
		return hangeravailable;
	}
	public void setHangeravailable(String hangeravailable) {
		this.hangeravailable = hangeravailable;
	}
	public String getHangernotavailable() {
		return hangernotavailable;
	}
	public void setHangernotavailable(String hangernotavailable) {
		this.hangernotavailable = hangernotavailable;
	}
	public String getOverwrite_hangeravailable() {
		return overwrite_hangeravailable;
	}
	public void setOverwrite_hangeravailable(String overwrite_hangeravailable) {
		this.overwrite_hangeravailable = overwrite_hangeravailable;
	}
	public String getOverwrite_hangernotavailable() {
		return overwrite_hangernotavailable;
	}
	public void setOverwrite_hangernotavailable(String overwrite_hangernotavailable) {
		this.overwrite_hangernotavailable = overwrite_hangernotavailable;
	}
	public String getHs_facing() {
		return hs_facing;
	}
	public void setHs_facing(String hs_facing) {
		this.hs_facing = hs_facing;
	}
	public String getOverwrite_hs_facing() {
		return overwrite_hs_facing;
	}
	public void setOverwrite_hs_facing(String overwrite_hs_facing) {
		this.overwrite_hs_facing = overwrite_hs_facing;
	}
}
