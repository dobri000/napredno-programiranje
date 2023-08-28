package rs.volleybox.common_lib.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rs.volleybox.common_lib.domain.Admin;

class AdminTest {

	private Admin admin;
	
	@BeforeEach
	void setUp() throws Exception {
		admin = new Admin("admin", "admin");
	}

	@AfterEach
	void tearDown() throws Exception {
		admin = null;
	}

	@Test
    public void testGetUsername() {
        assertEquals("admin", admin.getUsername());
    }

    @Test
    public void testSetUsername() {
        admin.setUsername("newAdmin");
        assertEquals("newAdmin", admin.getUsername());
    }

    @Test
    public void testSetUsernameWithNull() {
        assertThrows(NullPointerException.class, () -> admin.setUsername(null));
    }

    @Test
    public void testSetUsernameWithEmptyString() {
        assertThrows(IllegalArgumentException.class, () -> admin.setUsername(""));
    }

    @Test
    public void testGetPassword() {
        assertEquals("admin", admin.getPassword());
    }

    @Test
    public void testSetPassword() {
        admin.setPassword("newPassword");
        assertEquals("newPassword", admin.getPassword());
    }

    @Test
    public void testSetPasswordWithNull() {
        assertThrows(NullPointerException.class, () -> admin.setPassword(null));
    }

    @Test
    public void testSetPasswordWithEmptyString() {
        assertThrows(IllegalArgumentException.class, () -> admin.setPassword(""));
    }

    @Test
    public void testToString() {
        String expectedToString = "Admin{username=admin, password=admin}";
        assertEquals(expectedToString, admin.toString());
    }
    
    @Test
    public void testEquals() {
        Admin sameAdmin = new Admin("admin", "admin");
        assertEquals(admin, sameAdmin);
    }

    

}
