package rs.volleybox.common_lib.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rs.volleybox.common_lib.enumeration.Hand;

class PlayerTest {

	private Player player;

    @BeforeEach
    public void setUp() {
        Country nationality = new Country(1, "Serbia");
        player = new Player(2, "Filip", "Trifunovic", LocalDate.of(1999, 7, 11), 186, 69, 305, 300, Hand.RIGHT, nationality);
    }
    
    @AfterEach
    public void tearDown() {
    	player = null;
    }

    @Test
    public void testGetPlayerId() {
        assertEquals(2, player.getPlayerId());
    }

    @Test
    public void testGetFirstname() {
        assertEquals("Filip", player.getFirstname());
    }

    @Test
    public void testGetLastname() {
        assertEquals("Trifunovic", player.getLastname());
    }

    @Test
    public void testGetBirthdate() {
        assertEquals(LocalDate.of(1999, 7, 11), player.getBirthdate());
    }

    @Test
    public void testGetHeight() {
        assertEquals(186, player.getHeight());
    }

    @Test
    public void testGetWeight() {
        assertEquals(69, player.getWeight());
    }

    @Test
    public void testGetSpike() {
        assertEquals(305, player.getSpike());
    }

    @Test
    public void testGetBlock() {
        assertEquals(300, player.getBlock());
    }

    @Test
    public void testGetDominantHand() {
        assertEquals(Hand.RIGHT, player.getDominantHand());
    }

    @Test
    public void testGetNationality() {
        assertEquals(new Country(1, "Serbia"), player.getNationality());
    }
    
    @Test
    public void testSetPlayerId() {
        player.setPlayerId(3);
        assertEquals(3, player.getPlayerId());
    }

    @Test
    public void testSetFirstname() {
        player.setFirstname("Dimitrije");
        assertEquals("Dimitrije", player.getFirstname());
    }

    @Test
    public void testSetFirstnameWithNull() {
        assertThrows(NullPointerException.class, () -> player.setFirstname(null));
    }

    @Test
    public void testSetFirstnameWithEmptyString() {
        assertThrows(IllegalArgumentException.class, () -> player.setFirstname(""));
    }

    @Test
    public void testSetLastname() {
        player.setLastname("Dobrijevic");
        assertEquals("Dobrijevic", player.getLastname());
    }

    @Test
    public void testSetLastnameWithNull() {
        assertThrows(NullPointerException.class, () -> player.setLastname(null));
    }

    @Test
    public void testSetLastnameWithEmptyString() {
        assertThrows(IllegalArgumentException.class, () -> player.setLastname(""));
    }

    @Test
    public void testSetBirthdate() {
        LocalDate newBirthdate = LocalDate.of(2000, 1, 28);
        player.setBirthdate(newBirthdate);
        assertEquals(newBirthdate, player.getBirthdate());
    }

    @Test
    public void testSetBirthdateWithNull() {
        assertThrows(NullPointerException.class, () -> player.setBirthdate(null));
    }

    @Test
    public void testSetHeight() {
        player.setHeight(193);
        assertEquals(193, player.getHeight());
    }

    @Test
    public void testSetHeightWithNegativeValue() {
        assertThrows(IllegalArgumentException.class, () -> player.setHeight(-10));
    }

    @Test
    public void testSetWeight() {
        player.setWeight(88);
        assertEquals(88, player.getWeight());
    }

    @Test
    public void testSetWeightWithNegativeValue() {
        assertThrows(IllegalArgumentException.class, () -> player.setWeight(-10));
    }

    @Test
    public void testSetSpike() {
        player.setSpike(330);
        assertEquals(330, player.getSpike());
    }

    @Test
    public void testSetSpikeWithNegativeValue() {
        assertThrows(IllegalArgumentException.class, () -> player.setSpike(-10));
    }

    @Test
    public void testSetBlock() {
        player.setBlock(310);
        assertEquals(310, player.getBlock());
    }

    @Test
    public void testSetBlockWithNegativeValue() {
        assertThrows(IllegalArgumentException.class, () -> player.setBlock(-10));
    }

    @Test
    public void testSetDominantHand() {
        player.setDominantHand(Hand.LEFT);
        assertEquals(Hand.LEFT, player.getDominantHand());
    }

    @Test
    public void testSetDominantHandWithNull() {
        assertThrows(NullPointerException.class, () -> player.setDominantHand(null));
    }

    @Test
    public void testSetNationality() {
        Country newNationality = new Country(2, "Montenegro");
        player.setNationality(newNationality);
        assertEquals(newNationality, player.getNationality());
    }

    @Test
    public void testSetNationalityWithNull() {
        assertThrows(NullPointerException.class, () -> player.setNationality(null));
    }

    @Test
    public void testEquals() {
        Player samePlayer = new Player(2, "Filip", "Trifunovic", LocalDate.of(1999, 7, 11), 186, 69, 305, 300, Hand.RIGHT, new Country(1, "Serbia"));
        assertEquals(player, samePlayer);
    }


    @Test
    public void testToString() {
        String expectedToString = "Player{playerId=2, firstname=Filip, lastname=Trifunovic, birthdate=1999-07-11, height=186, weight=69, spike=305, block=300, dominantHand=RIGHT, nationality=Country{countryId=1, name=Serbia}}";
        assertEquals(expectedToString, player.toString());
    }

}
