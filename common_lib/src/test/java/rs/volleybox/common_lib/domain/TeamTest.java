package rs.volleybox.common_lib.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TeamTest {

	private Team team;

    @BeforeEach
    public void setUp() {
        Country country = new Country(1, "Serbia");
        Hall hall = new Hall(1, "USC Vozdovac", "Crnotravska 4, Beograd");
        team = new Team(1, "Crvena Zvezda Belgrade", 1945, country, hall);
    }

    @AfterEach
    public void tearDown() {
        team = null;
    }

    @Test
    public void testGetTeamId() {
        assertEquals(1, team.getTeamId());
    }

    @Test
    public void testSetTeamId() {
        team.setTeamId(2);
        assertEquals(2, team.getTeamId());
    }

    @Test
    public void testGetTeamName() {
        assertEquals("Crvena Zvezda Belgrade", team.getTeamName());
    }

    @Test
    public void testSetTeamName() {
        team.setTeamName("Mladi Radnik Pozarevac");
        assertEquals("Mladi Radnik Pozarevac", team.getTeamName());
    }

    @Test
    public void testSetTeamNameWithNull() {
        assertThrows(NullPointerException.class, () -> team.setTeamName(null));
    }

    @Test
    public void testSetTeamNameWithEmptyString() {
        assertThrows(IllegalArgumentException.class, () -> team.setTeamName(""));
    }

    @Test
    public void testGetFounded() {
        assertEquals(1945, team.getFounded());
    }

    @Test
    public void testSetFounded() {
        team.setFounded(1946);
        assertEquals(1946, team.getFounded());
    }

    @Test
    public void testSetFoundedWithNegativeValue() {
        assertThrows(IllegalArgumentException.class, () -> team.setFounded(-1));
    }

    @Test
    public void testGetCountry() {
        Country expectedCountry = new Country(1, "Serbia");
        assertEquals(expectedCountry, team.getCountry());
    }

    @Test
    public void testSetCountry() {
        Country newCountry = new Country(3, "Montenegro");
        team.setCountry(newCountry);
        assertEquals(newCountry, team.getCountry());
    }

    @Test
    public void testSetCountryWithNull() {
        assertThrows(NullPointerException.class, () -> team.setCountry(null));
    }

    @Test
    public void testGetHall() {
        Hall expectedHall = new Hall(1, "USC Vozdovac", "Crnotravska 4, Beograd");
        assertEquals(expectedHall, team.getHall());
    }

    @Test
    public void testSetHall() {
        Hall newHall = new Hall(2, "SC Pozarevac", "Partizanska 1, Pozarevac");
        team.setHall(newHall);
        assertEquals(newHall, team.getHall());
    }

    @Test
    public void testSetHallWithNull() {
        assertThrows(NullPointerException.class, () -> team.setHall(null));
    }

    @Test
    public void testEquals() {
    	Country country = new Country(1, "Serbia");
        Hall hall = new Hall(1, "USC Vozdovac", "Crnotravska 4, Beograd");
        Team sameTeam = new Team(1, "Crvena Zvezda Belgrade", 1945, country, hall);
        assertEquals(team, sameTeam);
    }

    

    @Test
    public void testToString() {
        String expectedToString = "Team{teamId=1, name=Crvena Zvezda Belgrade, founded=1945, country=Country{countryId=1, name=Serbia}, hall=Hall{hallId=1, name=USC Vozdovac, address=Crnotravska 4, Beograd}}";
        assertEquals(expectedToString, team.toString());
    }

}
