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

public class VisitedCategoryRemarkData {
	public String categoryremark
	public String subremark
	public String subcategory
	public ArrayList<ShopProductsData> shopproductsdata
	public String getCategoryremark() {
		return categoryremark;
	}
	public void setCategoryremark(String categoryremark) {
		this.categoryremark = categoryremark;
	}
	public String getSubremark() {
		return subremark;
	}
	public void setSubremark(String subremark) {
		this.subremark = subremark;
	}
	public String getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
	public ArrayList<ShopProductsData> getShopproductsdata() {
		return shopproductsdata;
	}
	public void setShopproductsdata(ArrayList<ShopProductsData> shopproductsdata) {
		this.shopproductsdata = shopproductsdata;
	}
}
