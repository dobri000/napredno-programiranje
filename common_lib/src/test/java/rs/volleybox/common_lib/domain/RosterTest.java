package rs.volleybox.common_lib.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RosterTest {

	private Roster roster;
    private Team team;
    private Season season;

    @BeforeEach
    public void setUp() {
        team = new Team(1, "Crvena Zvezda Belgrade", 1945, new Country(1, "Serbia"), new Hall(1, "USC Vozdovac", "Crvnotravska 4, Beograd"));
        season = new Season(1, 2022, 2023);
        roster = new Roster(team, 1, season);
    }

    @AfterEach
    public void tearDown() {
        roster = null;
    }

    @Test
    public void testGetTeam() {
        assertEquals(team, roster.getTeam());
    }

    @Test
    public void testSetTeam() {
        Team newTeam = new Team(2, "Mladi Radnik Pozarevac", 1946, new Country(2, "Serbia"), new Hall(2, "SC Pozarevac", "Partizanska 1, Pozarevac"));
        roster.setTeam(newTeam);
        assertEquals(newTeam, roster.getTeam());
    }

    @Test
    public void testSetTeamWithNull() {
        assertThrows(NullPointerException.class, () -> roster.setTeam(null));
    }

    @Test
    public void testGetRosterId() {
        assertEquals(1, roster.getRosterId());
    }

    @Test
    public void testSetRosterId() {
        roster.setRosterId(2);
        assertEquals(2, roster.getRosterId());
    }

    @Test
    public void testGetSeason() {
        assertEquals(season, roster.getSeason());
    }

    @Test
    public void testSetSeason() {
        Season newSeason = new Season(2, 2023, 2024);
        roster.setSeason(newSeason);
        assertEquals(newSeason, roster.getSeason());
    }

    @Test
    public void testSetSeasonWithNull() {
        assertThrows(NullPointerException.class, () -> roster.setSeason(null));
    }

    @Test
    public void testEquals() {
        Roster sameRoster = new Roster(team, 1, season);
        assertEquals(roster, sameRoster);
    }

    

}
