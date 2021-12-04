package com.jfsd.rms.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RMSUtil {

	private static final String dateFormat = "d-M-uuuu";

	public static LocalDate validateAndParseDate(String dateStr) throws DateTimeParseException {
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(dateFormat)
				.withResolverStyle(ResolverStyle.STRICT);
		return LocalDate.parse(dateStr, dateFormatter);
	}

	// function to check if the mobile number is valid or not
	public static boolean isValidMobileNo(String str) {
		// (0/91): number starts with (0/91)
		// [7-9]: starting of the number may contain a digit between 0 to 9
		// [0-9]: then contains digits 0 to 9
		Pattern ptrn = Pattern.compile("(0/91)?[7-9][0-9]{9}");
		// the matcher() method creates a matcher that will match the given input against this pattern
		Matcher match = ptrn.matcher(str);
		// returns a boolean value
		return (match.find() && match.group().equals(str));
	}
	
	/** Returns true only if the field passes the test, and is NOT null. */
	public static boolean ensureNotNull(Object field, String errorMsg, List<String> errors) {
		boolean result = true;
		if (field == null) {
			errors.add(errorMsg);
			result = false;
		}
		return result;
	}

	public static boolean hasContent(String string) {
		return (string != null && string.trim().length() > 0);
	}

}
