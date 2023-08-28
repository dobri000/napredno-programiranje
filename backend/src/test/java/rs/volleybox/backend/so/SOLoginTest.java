package rs.volleybox.backend.so;

import org.junit.jupiter.api.Test;
import rs.volleybox.backend.so.impl.SOAddHall;
import rs.volleybox.backend.so.impl.SOLogin;
import rs.volleybox.common_lib.domain.Admin;
import rs.volleybox.common_lib.domain.Hall;
import rs.volleybox.common_lib.enumeration.ServerResponse;
import rs.volleybox.common_lib.transfer.Response;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class SOLoginTest extends SOClassTest {

    @Override
    protected void createSO() {
        so = new SOLogin();
    }

    @Test
    void testExecuteSuccess() throws Exception {
        Admin admin = new Admin("admin", "admin");
        when(dbb.login(any(Admin.class))).thenReturn("Correct credentials");

        Response response = so.execute(admin);

        verify(dbb, times(1)).login(any(Admin.class));

        assertEquals(ServerResponse.OK, response.getServerResponse());
        assertEquals("Correct credentials", (String) response.getObject());
    }

    @Test
    void testExecuteLoggedIn() throws Exception {
        Admin admin = new Admin("admin", "admin");
        when(dbb.login(any(Admin.class))).thenReturn("Admin allready logged");

        Response response = so.execute(admin);

        verify(dbb, times(1)).login(any(Admin.class));

        assertEquals(ServerResponse.ERROR, response.getServerResponse());
        assertEquals("Admin allready logged", (String) response.getObject());
    }

    @Test
    void testExecuteWrongCredentials() throws Exception {
        Admin admin = new Admin("admin", "admin");
        when(dbb.login(any(Admin.class))).thenReturn("Invalid username or password");

        Response response = so.execute(admin);

        verify(dbb, times(1)).login(any(Admin.class));

        assertEquals(ServerResponse.ERROR, response.getServerResponse());
        assertEquals("Invalid username or password", (String) response.getObject());
    }

    @Test
    void testExecuteError() throws Exception {
        Admin admin = new Admin("admin", "admin");
        doThrow(new SQLException()).when(dbb).login(any(Admin.class));

        Response response = so.execute(admin);

        verify(dbb, times(1)).login(any(Admin.class));

        assertEquals(ServerResponse.ERROR, response.getServerResponse());
        assertEquals("Cannot login", (String) response.getObject());
    }

}