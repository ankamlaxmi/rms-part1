package com.jfsd.rms.validator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.jfsd.rms.model.Roommate;

public class RoommateValidator {
	
	public List<String> validateAddRoommate(Roommate rmt) {
		List<String> result = new ArrayList<String>();
		if(StringUtils.isBlank(rmt.getName())) {
			result.add("Roomate Name is Mandatory");
		}
		return result;
	}

}
