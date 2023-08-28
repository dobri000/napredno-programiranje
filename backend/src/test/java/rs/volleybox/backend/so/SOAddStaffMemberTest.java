package rs.volleybox.backend.so;

import org.junit.jupiter.api.Test;
import rs.volleybox.backend.so.SOClassTest;
import rs.volleybox.backend.so.impl.SOAddStaffMember;
import rs.volleybox.common_lib.domain.Country;
import rs.volleybox.common_lib.domain.Player;
import rs.volleybox.common_lib.domain.StaffMember;
import rs.volleybox.common_lib.enumeration.Hand;
import rs.volleybox.common_lib.enumeration.ServerResponse;
import rs.volleybox.common_lib.transfer.Response;

import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class SOAddStaffMemberTest extends SOClassTest {

    @Override
    protected void createSO() {
        so = new SOAddStaffMember();
    }

    @Test
    void testExecuteSuccess() throws Exception {
        doNothing().when(dbb).addStaffMember(any(StaffMember.class));

        StaffMember staffMember = new StaffMember(1, "Luka", "Ratkovic", LocalDate.of(2003, 3, 31), new Country(1, "Serbia"));
        Response response = so.execute(staffMember);

        verify(dbb, times(1)).addStaffMember(any(StaffMember.class));

        assertEquals(ServerResponse.OK, response.getServerResponse());
        assertNull(response.getObject());
    }

    @Test
    void testExecuteError() throws Exception {
        doThrow(new SQLException()).when(dbb).addStaffMember(any(StaffMember.class));

        StaffMember staffMember = new StaffMember(1, "Luka", "Ratkovic", LocalDate.of(2003, 3, 31), new Country(1, "Serbia"));
        Response response = so.execute(staffMember);

        verify(dbb, times(1)).addStaffMember(any(StaffMember.class));

        assertEquals(ServerResponse.ERROR, response.getServerResponse());
        assertEquals("Staff member not successfully added", (String) response.getObject());
    }

}