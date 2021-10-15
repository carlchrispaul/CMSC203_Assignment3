public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;
	
	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	//Description: To check whether the string input is able to be encrypted
	//Programmer: Carl Christian Paul Hipolito
	public static boolean stringInBounds (String plainText) {
		boolean valid = true;
		char c;
		
		for(int a = 0; a < plainText.length(); a++) {
			c = plainText.charAt(a);
			//check if the string is out of bounds
			if(c < LOWER_BOUND || c > UPPER_BOUND) {
				//turn boolean false
				valid = false;
			}
		}
		//return boolean
		return valid;
	}
	
	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	//Description: Encrypts the string input according to the Caesar Cipher.
	//Programmer: Carl Christian Paul Hipolito
	public static String encryptCaesar(String plainText, int key) {
		String eText = "";
		int b;
		char c;
		
		if(stringInBounds(plainText)) {
			for(int a = 0; a < plainText.length(); a++) {
				c = plainText.charAt(a);
				b = (int)c + key;
				
				while(b > UPPER_BOUND) {
					b -= RANGE;
				}
				
				eText += (char)b;
			}
		}
		//return String
		return eText;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	//Description: Encrypts the string input according to the Bellaso Cipher
	//Programmer: Carl Christian Paul Hipolito
	public static String encryptBellaso(String plainText, String bellasoStr) {
		String eText = "";
		int b;
		char c;
		
		for(int a = 0; a < plainText.length(); a++) {
			c = plainText.charAt(a);
			b = (int)c + (int)bellasoStr.charAt(a % (int)bellasoStr.length());
			
			while(b > (int)UPPER_BOUND) {
				b -= RANGE;
			}
			
			eText += (char)b;
		}
		//return String
		return eText;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	//Description: Decrypts the string input according to the Caesar Cipher
	//Programmer: Carl Christian Paul Hipolito
	public static String decryptCaesar(String encryptedText, int key) {
		String dText = "";
		int b;
		char c;
		
		for(int a = 0; a < encryptedText.length(); a++) {
			c = encryptedText.charAt(a);
			b = (int)c - key;
			
			while(b < LOWER_BOUND) {
				b += RANGE;
			}
			
			dText += (char)b;
		}
		//return String
		return dText;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	//Description: Decrypts the string input according to the Bellaso Cipher
	//Programmer: Carl Christian Paul Hipolito
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		String dText = "";
		int b;
		char c;
		
		for(int a = 0; a < encryptedText.length(); a++) {
			c = encryptedText.charAt(a);
			b = (int)c - (int)bellasoStr.charAt(a % (int)bellasoStr.length());
			
			while(b < (int)LOWER_BOUND) {
				b += RANGE;
			}
			
			dText += (char)b;
		}
		//return String
		return dText;
	}
}