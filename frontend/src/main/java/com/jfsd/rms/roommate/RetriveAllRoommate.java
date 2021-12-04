/**
 * 
 */
package com.jfsd.rms.roommate;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.jfsd.rms.controller.RoommateController;
import com.jfsd.rms.model.RMSResponseModel;
import com.jfsd.rms.model.Roommate;

/**
 * @author madan
 *
 */
public class RetriveAllRoommate {
	
	public void retrive() {
		try {
			System.out.println("Displaying All Roommate Details");
			System.out.println();
			RoommateController rmtController = new RoommateController();
			RMSResponseModel response = rmtController.getAllRoommates();
			if(response.isStatus()) {
				List<Roommate> rmtList = (List<Roommate>) response.getResponseObject();
				if(rmtList == null || rmtList.isEmpty()) {
					System.out.println("No Data Available");
				} else {
					for (Roommate rmt : rmtList) {
						System.out.println(rmt.toString());
					}
				}
				System.out.println();
			}
			else {
				System.out.println("No Roommate data available to display.");
				if(StringUtils.isNotBlank(response.getResult())) {
					System.out.println(response.getResult());
				}
				System.out.println();
			}
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage() + ", please try again later.");
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		RetriveAllRoommate rar = new RetriveAllRoommate();
		rar.retrive();
	}

}
