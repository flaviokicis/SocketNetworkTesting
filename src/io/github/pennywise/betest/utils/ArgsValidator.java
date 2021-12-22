package io.github.pennywise.betest.utils;

public class ArgsValidator {
	
	// Validate the args passed
	// This method is static to easily be called.
	public static boolean checkForInteger(String argument) {
		try {
			Integer.parseInt(argument);
			// If there is no errors, it's an integer.
			return true;
		} catch (NumberFormatException ex) {
			// There is an error, It's not an integer.
			return false;
		}
	}

}
