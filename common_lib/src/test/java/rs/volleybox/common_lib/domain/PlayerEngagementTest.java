package rs.volleybox.common_lib.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rs.volleybox.common_lib.enumeration.Hand;
import rs.volleybox.common_lib.enumeration.PlayerPosition;

class PlayerEngagementTest {

	private PlayerEngagement playerEngagement;
    private Player player;
    private Roster roster;

    @BeforeEach
    public void setUp() {
        player = new Player(1, "Dimitrije", "Dobrijevic", LocalDate.of(2000, 1, 28), 193, 88, 330, 310, Hand.RIGHT, new Country(1, "Serbia"));
        roster = new Roster(new Team(1, "Crvena Zvezda Belgrade", 1945, new Country(1, "Serbia"), new Hall(1, "USC Vozdovac", "Crnotravska 4, Beograd")), 1, new Season(1, 2022, 2023));
        playerEngagement = new PlayerEngagement(player, roster, PlayerPosition.MIDDLE_BLOCKER, 14);
    }

    @AfterEach
    public void tearDown() {
        playerEngagement = null;
    }

    @Test
    public void testGetPlayer() {
        assertEquals(player, playerEngagement.getPlayer());
    }

    @Test
    public void testSetPlayer() {
        Player newPlayer = new Player(2, "Filip", "Trifunovic", LocalDate.of(1999, 7, 14), 186, 68, 310, 300, Hand.LEFT, new Country(1, "Serbia"));
        playerEngagement.setPlayer(newPlayer);
        assertEquals(newPlayer, playerEngagement.getPlayer());
    }

    @Test
    public void testSetPlayerWithNull() {
        assertThrows(NullPointerException.class, () -> playerEngagement.setPlayer(null));
    }

    @Test
    public void testGetRoster() {
        assertEquals(roster, playerEngagement.getRoster());
    }

    @Test
    public void testSetRoster() {
        Roster newRoster = new Roster(new Team(2, "Mladi Radnik Pozarevac", 1946, new Country(1, "Serbia"), new Hall(2, "SC Pozarevac", "Partizanska 1, Pozarevac")), 2, new Season(2, 2023, 2024));
        playerEngagement.setRoster(newRoster);
        assertEquals(newRoster, playerEngagement.getRoster());
    }

    @Test
    public void testSetRosterWithNull() {
        assertThrows(NullPointerException.class, () -> playerEngagement.setRoster(null));
    }

    @Test
    public void testGetPosition() {
        assertEquals(PlayerPosition.MIDDLE_BLOCKER, playerEngagement.getPosition());
    }

    @Test
    public void testSetPosition() {
        playerEngagement.setPosition(PlayerPosition.LIBERO);
        assertEquals(PlayerPosition.LIBERO, playerEngagement.getPosition());
    }

    @Test
    public void testSetPositionWithNull() {
        assertThrows(NullPointerException.class, () -> playerEngagement.setPosition(null));
    }

    @Test
    public void testGetNumber() {
        assertEquals(14, playerEngagement.getNumber());
    }

    @Test
    public void testSetNumber() {
        playerEngagement.setNumber(4);
        assertEquals(4, playerEngagement.getNumber());
    }

    @Test
    public void testSetNumberWithNegativeValue() {
        assertThrows(IllegalArgumentException.class, () -> playerEngagement.setNumber(-5));
    }

    @Test
    public void testEquals() {
        PlayerEngagement samePlayerEngagement = new PlayerEngagement(player, roster, PlayerPosition.MIDDLE_BLOCKER, 14);
        assertEquals(playerEngagement, samePlayerEngagement);
    }

    

}
