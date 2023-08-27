package rs.volleybox.common_lib.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HallTest {

	private Hall hall;

    @BeforeEach
    public void setUp() {
        hall = new Hall(1, "USC Vozdovac", "Crnotravska 4, Beograd");
    }
    
    @AfterEach
    public void tearDown() {
    	hall = null;
    }

    @Test
    public void testGetHallId() {
        assertEquals(1, hall.getHallId());
    }

    @Test
    public void testSetHallId() {
        hall.setHallId(2);
        assertEquals(2, hall.getHallId());
    }

    @Test
    public void testGetHallName() {
        assertEquals("USC Vozdovac", hall.getHallName());
    }

    @Test
    public void testSetHallName() {
        hall.setHallName("SC Pozarevac");
        assertEquals("SC Pozarevac", hall.getHallName());
    }

    @Test
    public void testSetHallNameWithNull() {
        assertThrows(NullPointerException.class, () -> hall.setHallName(null));
    }

    @Test
    public void testSetHallNameWithEmptyString() {
        assertThrows(IllegalArgumentException.class, () -> hall.setHallName(""));
    }

    @Test
    public void testGetAddress() {
        assertEquals("Crnotravska 4, Beograd", hall.getAddress());
    }

    @Test
    public void testSetAddress() {
        hall.setAddress("Partizanska 1, Pozarevac");
        assertEquals("Partizanska 1, Pozarevac", hall.getAddress());
    }

    @Test
    public void testSetAddressWithNull() {
        assertThrows(NullPointerException.class, () -> hall.setAddress(null));
    }

    @Test
    public void testSetAddressWithEmptyString() {
        assertThrows(IllegalArgumentException.class, () -> hall.setAddress(""));
    }

    @Test
    public void testEquals() {
        Hall sameHall = new Hall(1, "USC Vozdovac", "Crnotravska 4, Beograd");
        assertEquals(hall, sameHall);
    }

    @Test
    public void testHashCode() {
        Hall sameHall = new Hall(1, "USC Vozdovac", "Crnotravska 4, Beograd");
        assertEquals(hall.hashCode(), sameHall.hashCode());
    }

    @Test
    public void testToString() {
        String expectedToString = "Hall{hallId=1, name=USC Vozdovac, address=Crnotravska 4, Beograd}";
        assertEquals(expectedToString, hall.toString());
    }

}
