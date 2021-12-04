/**
 * 
 */
package com.jfsd.rms.roommate;

import java.util.Scanner;

import com.fsjd.rms.utils.MenuOptions;

/**
 * @author madan
 *
 */
public class RoommateModule {

	private static final String DISPLAY_LINE = "------------------------------------------------------------------------------------------------------------";
	private static final String MENU = "1) Add Roommate 2) Edit Roommate 3) Delete Roommate 4) Search Roommate 5) Display Roommate Details 6) Exit Module";

	public void roommateMenu(Scanner in) {
		boolean flag = true;
		while (flag) {
			System.out.println(":: ROOMMATE MENU ::");
			System.out.println(DISPLAY_LINE);
			System.out.println(MENU);
			System.out.println(DISPLAY_LINE);
			System.out.println();
			System.out.print("Enter Menu Option: ");
			int menuNo = in.nextInt();
			MenuOptions choice = MenuOptions.valueOfMenuNumber(menuNo);
			in.nextLine();
			switch (choice) {
			case CREATE:
				String s = null;
				do {
					CreateRoommate cr = new CreateRoommate();
					cr.create(in);
					System.out.println("Do u want to continue(y to proceed): ");
					s = in.nextLine();
				} while (s.equalsIgnoreCase("y"));
				break;

			case UPDATE:
				do {
					UpdateRoommate ur = new UpdateRoommate();
					ur.update(in);
					in.nextLine();
					System.out.println("Do u want to continue(y to proceed): ");
					s = in.nextLine();
				} while (s.equalsIgnoreCase("y"));
				break;

			case DELETE:
				do {
					DeleteRoommate dr = new DeleteRoommate();
					dr.delete(in);
					in.nextLine();
					System.out.println("Do u want to continue(y to proceed): ");
					s = in.nextLine();
				} while (s.equalsIgnoreCase("y"));
				break;

			case SEARCH:
				do {
					SearchRoommate sr = new SearchRoommate();
					sr.search(in);
					in.nextLine();
					System.out.println("Do u want to continue (y to proceed): ");
					s = in.nextLine();
				} while (s.equalsIgnoreCase("y"));
				break;

			case RETRIVE_ALL:
				RetriveAllRoommate rar = new RetriveAllRoommate();
				rar.retrive();
				break;
			case EXIT:
				System.out.println("#### THANK YOU. VISIT AGAIN ####");
				flag = false;
				break;
			default:
				System.out.println("Invalid Option.Try Again");
			}
		}
	}

	public static void main(String[] args) {
		RoommateModule rm = new RoommateModule();
		rm.roommateMenu(new Scanner(System.in));
	}

}
