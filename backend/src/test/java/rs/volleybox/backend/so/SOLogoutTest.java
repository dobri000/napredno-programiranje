package rs.volleybox.backend.so;

import org.junit.jupiter.api.Test;
import rs.volleybox.backend.so.impl.SOAddHall;
import rs.volleybox.backend.so.impl.SOLogout;
import rs.volleybox.common_lib.domain.Admin;
import rs.volleybox.common_lib.domain.Hall;
import rs.volleybox.common_lib.enumeration.ServerResponse;
import rs.volleybox.common_lib.transfer.Response;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class SOLogoutTest extends SOClassTest {

    @Override
    protected void createSO() {
        so = new SOLogout();
    }

    @Test
    void testExecuteSuccess() throws Exception {
        Admin admin = new Admin("admin", "admin");
        when(dbb.logout(any(Admin.class))).thenReturn(true);

        Response response = so.execute(admin);

        verify(dbb, times(1)).logout(any(Admin.class));

        assertEquals(ServerResponse.OK, response.getServerResponse());
        assertEquals("Successfully logged out", (String) response.getObject());
    }

    @Test
    void testExecuteError() throws Exception {
        Admin admin = new Admin("admin", "admin");
        when(dbb.logout(any(Admin.class))).thenReturn(false);

        Response response = so.execute(admin);

        verify(dbb, times(1)).logout(any(Admin.class));

        assertEquals(ServerResponse.ERROR, response.getServerResponse());
        assertEquals("Admin cannot log out", (String) response.getObject());
    }

}