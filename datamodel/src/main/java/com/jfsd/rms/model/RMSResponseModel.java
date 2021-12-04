package com.jfsd.rms.model;

import java.util.List;
import java.util.Map;

public class RMSResponseModel {

	private String result;
	private boolean status;
	private List<String> errors;
	private Map<Object, List<Object>> responseDataMap;
	private Object responseObject; 
	private List<Object> responseList;

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	} 

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Map<Object, List<Object>> getResponseDataMap() {
		return responseDataMap;
	}

	public void setResponseDataMap(Map<Object, List<Object>> responseDataMap) {
		this.responseDataMap = responseDataMap;
	}

	public Object getResponseObject() {
		return responseObject;
	}

	public void setResponseObject(Object responseObject) {
		this.responseObject = responseObject;
	}

	public List<Object> getResponseList() {
		return responseList;
	}

	public void setResponseList(List<Object> responseList) {
		this.responseList = responseList;
	}

}
