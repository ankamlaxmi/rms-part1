/**
 * 
 */
package com.jfsd.rms.roommate;

import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

import com.jfsd.rms.controller.RoommateController;
import com.jfsd.rms.model.RMSResponseModel;
import com.jfsd.rms.model.Roommate;

/**
 * @author madan
 *
 */
public class UpdateRoommate {

	public void update(Scanner in) {
		try {
			System.out.println("Edit Existig Roommate Details");
			System.out.println();
			System.out.print("Enter Roommate ID to Edit: ");
			int no = in.nextInt();
			Roommate rmt = new Roommate();
			rmt.setNo(no);
			RoommateController rmtController = new RoommateController();
			RMSResponseModel response = rmtController.searchRoommate(no);
			if (response.isStatus()) {
				Roommate oldRmt = (Roommate) response.getResponseObject();
				Roommate rmtEdit = new Roommate();
				System.out.print("Enter Address: ");
				String ad = in.nextLine();
				in.nextLine();
				System.out.print("Enter Mobile: ");
				String mb = in.nextLine();

				rmtEdit.setNo(oldRmt.getNo());
				rmtEdit.setName(oldRmt.getName());
				rmtEdit.setDateOfJoining(oldRmt.getDateOfJoining());
				
				if (StringUtils.isNotBlank(ad)) {
					rmtEdit.setAddress(ad);
				} else {
					rmtEdit.setAddress(oldRmt.getAddress());
				}
				
				if (StringUtils.isNotBlank(mb)) {
					rmtEdit.setMobile(mb);
				} else {
					rmtEdit.setMobile(oldRmt.getMobile());
				}
				rmtEdit.validate();
				response = rmtController.editRoommate(rmtEdit);
			}
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
		UpdateRoommate ur = new UpdateRoommate();
		ur.update(new Scanner(System.in));
	}

}
