import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CryptoJUnitTestPublic {
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testStringInBounds() {
		assertTrue(CryptoManager.stringInBounds("THIS TEST SHOULD SUCCEED"));
		assertFalse(CryptoManager.stringInBounds("TEST SHOULD FAIL BECAUSE ~ IS OUTSIDE THE RANGE"));
		assertFalse(CryptoManager.stringInBounds("This test should fail because of lowercase letters"));
	}

	@Test
	public void testEncryptCaesar() {
		assertEquals("IFMMP!XPSME", CryptoManager.encryptCaesar("HELLO WORLD", 1));
		assertEquals("WKLV#LV#DQRWKHU#WHVW",CryptoManager.encryptCaesar("THIS IS ANOTHER TEST", 3));
	}
	
	@Test
	public void testDecryptCaesar() {
		assertEquals("HELLO WORLD", CryptoManager.decryptCaesar("IFMMP!XPSME", 1));
		assertEquals("THIS IS ANOTHER TEST", CryptoManager.decryptCaesar("WKLV#LV#DQRWKHU#WHVW", 3));
	}
	
	@Test
	public void testEncryptBellaso() {
		assertEquals("WU\\VR9F#N!RF88U-'HED", CryptoManager.encryptBellaso("THIS IS ANOTHER TEST", "CMSC203"));
	}
	
	@Test
	public void testDecryptBellaso() {
		assertEquals("THIS IS ANOTHER TEST", CryptoManager.decryptBellaso("WU\\VR9F#N!RF88U-'HED", "CMSC203"));
	}
	
}
