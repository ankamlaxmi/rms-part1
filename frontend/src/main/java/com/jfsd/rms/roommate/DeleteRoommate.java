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
public class DeleteRoommate {

	public void delete(Scanner in) {
		System.out.println("Deleteing Roommate Details");
		System.out.println();
		System.out.print("Enter Roommate ID: ");
		int no = in.nextInt();
		RoommateController rmtController = new RoommateController();
		RMSResponseModel response = rmtController.deleteRoommate(no);
		System.out.println(response.getResult());
		System.out.println();
	}

	public static void main(String[] args) {
		DeleteRoommate dr = new DeleteRoommate();
		dr.delete(new Scanner(System.in));
	}

}
