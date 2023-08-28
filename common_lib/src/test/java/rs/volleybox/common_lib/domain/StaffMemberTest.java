package rs.volleybox.common_lib.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StaffMemberTest {

	private StaffMember staffMember;

    @BeforeEach
    public void setUp() {
        Country nationality = new Country(1, "Serbia");
        staffMember = new StaffMember(1, "Luka", "Ratkovic", LocalDate.of(2003, 3, 31), nationality);
    }

    @Test
    public void testGetStaffMemberId() {
        assertEquals(1, staffMember.getStaffMemberId());
    }

    @Test
    public void testSetStaffMemberId() {
        staffMember.setStaffMemberId(2);
        assertEquals(2, staffMember.getStaffMemberId());
    }

    @Test
    public void testGetFirstname() {
        assertEquals("Luka", staffMember.getFirstname());
    }

    @Test
    public void testSetFirstname() {
        staffMember.setFirstname("Vladimir");
        assertEquals("Vladimir", staffMember.getFirstname());
    }

    @Test
    public void testSetFirstnameWithNull() {
        assertThrows(NullPointerException.class, () -> staffMember.setFirstname(null));
    }

    @Test
    public void testSetFirstnameWithEmptyString() {
        assertThrows(IllegalArgumentException.class, () -> staffMember.setFirstname(""));
    }

    @Test
    public void testGetLastname() {
        assertEquals("Ratkovic", staffMember.getLastname());
    }

    @Test
    public void testSetLastname() {
        staffMember.setLastname("Kozic");
        assertEquals("Kozic", staffMember.getLastname());
    }

    @Test
    public void testSetLastnameWithNull() {
        assertThrows(NullPointerException.class, () -> staffMember.setLastname(null));
    }

    @Test
    public void testSetLastnameWithEmptyString() {
        assertThrows(IllegalArgumentException.class, () -> staffMember.setLastname(""));
    }

    @Test
    public void testGetBirthdate() {
        assertEquals(LocalDate.of(2003, 3, 31), staffMember.getBirthdate());
    }

    @Test
    public void testSetBirthdate() {
        LocalDate newBirthdate = LocalDate.of(1994, 7, 14);
        staffMember.setBirthdate(newBirthdate);
        assertEquals(newBirthdate, staffMember.getBirthdate());
    }

    @Test
    public void testSetBirthdateWithNull() {
        assertThrows(NullPointerException.class, () -> staffMember.setBirthdate(null));
    }

    @Test
    public void testGetNationality() {
        Country nationality = new Country(1, "Serbia");
        assertEquals(nationality, staffMember.getNationality());
    }

    @Test
    public void testSetNationality() {
        Country newNationality = new Country(2, "Bosnia and Hercegovina");
        staffMember.setNationality(newNationality);
        assertEquals(newNationality, staffMember.getNationality());
    }

    @Test
    public void testSetNationalityWithNull() {
        assertThrows(NullPointerException.class, () -> staffMember.setNationality(null));
    }

    @Test
    public void testEquals() {
    	Country nationality = new Country(1, "Serbia");
        StaffMember sameStaffMember = new StaffMember(1, "Luka", "Ratkovic", LocalDate.of(2003, 3, 31), nationality);
        assertEquals(staffMember, sameStaffMember);
    }

    @Test
    public void testToString() {
        String expectedToString = "StaffMember{staffMemberId=1, firstname=Luka, lastname=Ratkovic, birthdate=2003-03-31, nationality=Country{countryId=1, name=Serbia}}";
        assertEquals(expectedToString, staffMember.toString());
    }

}
