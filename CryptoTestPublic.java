public class CryptoTestPublic {

	public static void main(String[] args) {

		String str1 = "\"THIS TEST SHOULD SUCCEED\"";
		String str2 = "\"THIS TEST THAT SHOULD FAIL BECAUSE { IS OUTSIDE THE RANGE\"";
		String str3 = "\"This test should fail because of lowercase letters\""; 
		String str4 = "HELLO WORLD"; 
		String str5 = "IFMMP!XPSME";
		String str6 = "THIS IS ANOTHER TEST";
		String str7 = "WKLV#LV#DQRWKHU#WHVW";
		String str8 = "WU\\VR9F#N!RF88U-'HED";


		boolean good = CryptoManager.stringInBounds(str1);
		boolean notGood = CryptoManager.stringInBounds(str2);
		
		System.out.println(str1+" Is it in bounds? "+good);
		System.out.println(str2+" Is it in bounds? "+notGood);
		notGood = CryptoManager.stringInBounds(str3);
		System.out.println("Caesar cipher of \""+str4+"\" should return \"IFMMP!XPSME\":   "+ CryptoManager.encryptCaesar(str4, 1));
		System.out.println("Caesar decryption of \""+str5+"\" should return \"HELLO WORLD\":    "+ CryptoManager.decryptCaesar(str5, 1));
		System.out.println("Caesar cipher of \""+str6+"\" should return \"WKLV#LV#DQRWKHU#WHVW\":   "+ CryptoManager.encryptCaesar(str6, 3));
		System.out.println("Caesar decryption of \""+str7+"\" should return \"THIS IS ANOTHER TEST\":    "+ CryptoManager.decryptCaesar(str7, 3));
		System.out.println("Bellaso cipher of \""+str6+"\" should return \"WU\\VR9F#N!RF88U-'HED\":    "+ CryptoManager.encryptBellaso(str6, "CMSC203"));
		System.out.println("Bellaso decryption of \""+str8+"\" should return \"THIS IS ANOTHER TEST\":    "+ CryptoManager.decryptBellaso(str8, "CMSC203"));
		
	}

}
