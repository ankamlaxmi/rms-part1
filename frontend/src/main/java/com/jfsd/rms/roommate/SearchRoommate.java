/**
 * 
 */
package com.jfsd.rms.roommate;

import java.util.Scanner;

import com.jfsd.rms.controller.RoommateController;
import com.jfsd.rms.model.RMSResponseModel;

/**
 * @author madan
 *
 */
public class SearchRoommate {

	public void search(Scanner in) {
		System.out.println("Searching Roommate Details");
		System.out.println();
		System.out.print("Enter Roommate ID number: ");
		int no = in.nextInt();
		RoommateController rmtController = new RoommateController();
		RMSResponseModel response = rmtController.searchRoommate(no);
		if (response.isStatus()) {
			System.out.println(response.getResponseObject());
			System.out.println();
		} else {
			System.out.println(response.getResult());
			System.out.println();
		}
	}

	public static void main(String[] args) {
		SearchRoommate sr = new SearchRoommate();
		sr.search(new Scanner(System.in));
	}

}
