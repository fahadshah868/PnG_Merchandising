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

public class VisitedCategoryData {
	public String maincategory
	public ArrayList<TaggedChillersRemark> taggedchillersremark
	public String productcategory
	public ArrayList<ChannelProduct> channelproducts

	public VisitedCategoryData(){
		this.taggedchillersremark = new ArrayList<TaggedChillersRemark>()
	}

	public String getMaincategory() {
		return maincategory;
	}
	public void setMaincategory(String maincategory) {
		this.maincategory = maincategory;
	}
	public ArrayList<TaggedChillersRemark> getTaggedchillersremark() {
		return taggedchillersremark;
	}
	public void setTaggedchillersremark(TaggedChillersRemark taggedchillersremark) {
		this.taggedchillersremark.add(taggedchillersremark);
	}
	public String getProductcategory() {
		return productcategory;
	}
	public void setProductcategory(String productcategory) {
		this.productcategory = productcategory;
	}
	public ArrayList<ChannelProduct> getChannelproducts() {
		return channelproducts;
	}
	public void setChannelproducts(ArrayList<ChannelProduct> _channelproducts) {
		this.channelproducts = _channelproducts;
	}
}
