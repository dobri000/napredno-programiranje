package rs.volleybox.common_lib.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rs.volleybox.common_lib.enumeration.StaffMemberPosition;

class StaffMemberEngagementTest {

	private StaffMemberEngagement staffMemberEngagement;
    private StaffMember staffMember;
    private Roster roster;

    @BeforeEach
    public void setUp() {
        staffMember = new StaffMember(1, "Luka", "Ratkovic", LocalDate.of(2003, 3, 31), new Country(1, "Serbia"));
        roster = new Roster(new Team(1, "Crvena Zvezda Belgrade", 1945, new Country(1, "Serbia"), new Hall(1, "USC Vozdovac", "Crnotravska 4, Beograd")), 1, new Season(1, 2022, 2023));
        staffMemberEngagement = new StaffMemberEngagement(staffMember, roster, StaffMemberPosition.STATISTICIAN);
    }

    @AfterEach
    public void tearDown() {
        staffMemberEngagement = null;
    }

    @Test
    public void testGetStaffMember() {
        assertEquals(staffMember, staffMemberEngagement.getStaffMember());
    }

    @Test
    public void testSetStaffMember() {
        StaffMember newStaffMember = new StaffMember(2, "Vladimir", "Kozic", LocalDate.of(1994, 7, 14), new Country(2, "Bosnia and Hercegovina"));
        staffMemberEngagement.setStaffMember(newStaffMember);
        assertEquals(newStaffMember, staffMemberEngagement.getStaffMember());
    }

    @Test
    public void testSetStaffMemberWithNull() {
        assertThrows(NullPointerException.class, () -> staffMemberEngagement.setStaffMember(null));
    }

    @Test
    public void testGetRoster() {
        assertEquals(roster, staffMemberEngagement.getRoster());
    }

    @Test
    public void testSetRoster() {
        Roster newRoster = new Roster(new Team(2, "Mladi Radnik Pozarevac", 1946, new Country(1, "Serbia"), new Hall(2, "SC Pozarevac", "Partizanska 1, Pozarevac")), 2, new Season(2, 2023, 2024));
        staffMemberEngagement.setRoster(newRoster);
        assertEquals(newRoster, staffMemberEngagement.getRoster());
    }

    @Test
    public void testSetRosterWithNull() {
        assertThrows(NullPointerException.class, () -> staffMemberEngagement.setRoster(null));
    }

    @Test
    public void testGetPosition() {
        assertEquals(StaffMemberPosition.STATISTICIAN, staffMemberEngagement.getPosition());
    }

    @Test
    public void testSetPosition() {
        staffMemberEngagement.setPosition(StaffMemberPosition.COACH_ASSISTANT);
        assertEquals(StaffMemberPosition.COACH_ASSISTANT, staffMemberEngagement.getPosition());
    }

    @Test
    public void testSetPositionWithNull() {
        assertThrows(NullPointerException.class, () -> staffMemberEngagement.setPosition(null));
    }

    @Test
    public void testEquals() {
        StaffMemberEngagement sameStaffMemberEngagement = new StaffMemberEngagement(staffMember, roster, StaffMemberPosition.STATISTICIAN);
        assertEquals(staffMemberEngagement, sameStaffMemberEngagement);
    }

}
