/**
 * 
 */
package com.jfsd.rms.roommate;

import java.time.LocalDate;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

import com.jfsd.rms.controller.RoommateController;
import com.jfsd.rms.model.RMSResponseModel;
import com.jfsd.rms.model.Roommate;
import com.jfsd.rms.util.RMSUtil;

/**
 * @author madan
 *
 */
public class CreateRoommate {

	public void create(Scanner in) {
		try {
			System.out.println("Please Enter Details to Create New Roommate");
			System.out.println();
			System.out.print("Name: ");
			String name = in.nextLine();
			System.out.print("Address: ");
			String address = in.nextLine();
			System.out.print("Mobile: ");
			String mobile = in.nextLine();
			System.out.print("Date Of Joining (in day-month-year): ");
			LocalDate date = null;
			String tdate = in.nextLine();
			System.out.print("Vegiterian Yes/NO?: ");
			String vegiterian = in.nextLine();
			System.out.print("Email Address ");
			String email = in.nextLine();
			System.out.println("------------------");
		
			
			
			if (StringUtils.isNotBlank(tdate)) {
				date = RMSUtil.validateAndParseDate(tdate);
			} else {
				date = LocalDate.now();
			}
			
			
			
			Roommate rmt = new Roommate(name, address, mobile, date,vegiterian,email);
			RoommateController rmtController = new RoommateController();
			RMSResponseModel response = rmtController.addRoommate(rmt);
			
			System.out.println(response.getResult());
			System.out.println();
			
		} catch (Exception e) {
			if (e.getSuppressed() != null && e.getSuppressed().length > 0) {
				Throwable[] validations = e.getSuppressed();
				System.out.println();
				System.out.println("Validation Errors -");
				for (int i = 0; i < e.getSuppressed().length; i++) {
					System.err.println(validations[i].getMessage());
				}
				System.out.println();
			} else {
				System.err.println("Exception: " + e.getMessage() + ", please try again with proper inputs.");
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		CreateRoommate cr = new CreateRoommate();
		cr.create(new Scanner(System.in));
	}

}
