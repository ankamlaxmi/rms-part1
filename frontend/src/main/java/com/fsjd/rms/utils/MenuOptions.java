/**
 * 
 */
package com.fsjd.rms.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author madan
 *
 */
public enum MenuOptions {
	CREATE(1), UPDATE(2), DELETE(3), SEARCH(4), RETRIVE_ALL(5), EXIT(6);

	private static final Map<Integer, MenuOptions> BY_MENU_NUMBER = new HashMap<>();

	public final int menuNo;

	private MenuOptions(int menuNo) {
		this.menuNo = menuNo;
	}

	static {
		for (MenuOptions e : values()) {
			BY_MENU_NUMBER.put(e.menuNo, e);
		}
	}

	public static MenuOptions valueOfMenuNumber(int menuNo) {
		return BY_MENU_NUMBER.get(menuNo);
	}

	public static void main(String[] args) {
		System.out.println(valueOfMenuNumber(1));
	}
}
