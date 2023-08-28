package rs.volleybox.common_lib.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rs.volleybox.common_lib.domain.Country;

class CountryTest {

	private Country country;
	
	@BeforeEach
	void setUp() throws Exception {
		country = new Country(1, "Serbia");
	}

	@AfterEach
	void tearDown() throws Exception {
		country = null;
	}

	@Test
    public void testGetCountryId() {
        assertEquals(1, country.getCountryId());
    }

    @Test
    public void testSetCountryId() {
        country.setCountryId(2);
        assertEquals(2, country.getCountryId());
    }

    @Test
    public void testGetCountryName() {
        assertEquals("Serbia", country.getCountryName());
    }

    @Test
    public void testSetCountryName() {
        country.setCountryName("Montenegro");
        assertEquals("Montenegro", country.getCountryName());
    }

    @Test
    public void testSetCountryNameWithNull() {
        assertThrows(NullPointerException.class, () -> country.setCountryName(null));
    }

    @Test
    public void testSetCountryNameWithEmptyString() {
        assertThrows(IllegalArgumentException.class, () -> country.setCountryName(""));
    }

    @Test
    public void testEquals() {
        Country sameCountry = new Country(1, "Serbia");
        assertEquals(country, sameCountry);
    }


    @Test
    public void testToString() {
        String expectedToString = "Country{countryId=1, name=Serbia}";
        assertEquals(expectedToString, country.toString());
    }

}
