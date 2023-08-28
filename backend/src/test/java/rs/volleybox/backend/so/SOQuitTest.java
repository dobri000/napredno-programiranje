package rs.volleybox.backend.so;

import org.junit.jupiter.api.Test;
import rs.volleybox.backend.so.impl.SOQuit;
import rs.volleybox.common_lib.domain.Admin;
import rs.volleybox.common_lib.transfer.Response;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class SOQuitTest extends SOClassTest {

    @Override
    protected void createSO() {
        so = new SOQuit();
    }

    @Test
    void testExecuteSucces() throws Exception {
        Admin admin = new Admin("admin", "admin");
        when(dbb.logout(any(Admin.class))).thenReturn(true);

        Response response = so.execute(admin);

        verify(dbb, times(1)).logout(any(Admin.class));

        assertEquals(null ,response);
    }
}