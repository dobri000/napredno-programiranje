package rs.volleybox.backend.so;

import org.junit.jupiter.api.Test;
import rs.volleybox.backend.so.impl.SOAddStaffMember;
import rs.volleybox.backend.so.impl.SODeleteStaffMember;
import rs.volleybox.common_lib.domain.Country;
import rs.volleybox.common_lib.domain.StaffMember;
import rs.volleybox.common_lib.enumeration.ServerResponse;
import rs.volleybox.common_lib.transfer.Response;

import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class SODeleteStaffMemberTest extends SOClassTest {

    @Override
    protected void createSO() {
        so = new SODeleteStaffMember();
    }

    @Test
    void testExecuteSuccess() throws Exception {
        doNothing().when(dbb).deleteStaffMember(any(StaffMember.class));

        StaffMember staffMember = new StaffMember(1, "Luka", "Ratkovic", LocalDate.of(2003, 3, 31), new Country(1, "Serbia"));
        Response response = so.execute(staffMember);

        verify(dbb, times(1)).deleteStaffMember(any(StaffMember.class));

        assertEquals(ServerResponse.OK, response.getServerResponse());
        assertNull(response.getObject());
    }

    @Test
    void testExecuteError() throws Exception {
        doThrow(new SQLException()).when(dbb).deleteStaffMember(any(StaffMember.class));

        StaffMember staffMember = new StaffMember(1, "Luka", "Ratkovic", LocalDate.of(2003, 3, 31), new Country(1, "Serbia"));
        Response response = so.execute(staffMember);

        verify(dbb, times(1)).deleteStaffMember(any(StaffMember.class));

        assertEquals(ServerResponse.ERROR, response.getServerResponse());
        assertEquals("Staff member not successfully deleted", (String) response.getObject());
    }

}