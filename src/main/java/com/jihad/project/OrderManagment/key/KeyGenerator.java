package com.jihad.project.OrderManagment.key;

import java.security.SecureRandom;
import java.util.Base64;

/**
 * Utility class to generate a random secret key.
 */
public class KeyGenerator {

	/**
	 * Main method to generate a random secret key.
	 *
	 * @param args the command line arguments (not used)
	 */
	public static void main(String[] args) {
		// Generate a random byte array for the secret key
		byte[] keyBytes = new byte[32];
		SecureRandom secureRandom = new SecureRandom();
		secureRandom.nextBytes(keyBytes);

		// Encode the secret key as a Base64 string
		String encodedKey = Base64.getEncoder().encodeToString(keyBytes);

		// Remove the trailing "=" characters from the Base64 encoding
		encodedKey = encodedKey.replaceAll("=+$", "");

		// Print the encoded secret key
		System.out.println(encodedKey);
	}
}
