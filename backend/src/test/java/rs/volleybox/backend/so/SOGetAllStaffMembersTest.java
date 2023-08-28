package rs.volleybox.backend.so;

import org.junit.jupiter.api.Test;
import rs.volleybox.backend.so.impl.SOGetAllPlayers;
import rs.volleybox.backend.so.impl.SOGetAllStaffMembers;
import rs.volleybox.common_lib.domain.Country;
import rs.volleybox.common_lib.domain.Player;
import rs.volleybox.common_lib.domain.StaffMember;
import rs.volleybox.common_lib.enumeration.Hand;
import rs.volleybox.common_lib.enumeration.ServerResponse;
import rs.volleybox.common_lib.transfer.Response;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class SOGetAllStaffMembersTest extends SOClassTest {

    @Override
    protected void createSO() {
        so = new SOGetAllStaffMembers();
    }

    @Test
    void testExecuteSuccess() throws Exception {
        List<StaffMember> staffMembers = new ArrayList<>();
        StaffMember s1 = new StaffMember(1, "Dimitrije", "Dobrijevic", LocalDate.of(2000,1,28), new Country(1, "Serbia"));
        StaffMember s2 = new StaffMember(2, "Filip", "Trifunovic", LocalDate.of(1999, 7, 14), new Country(1, "Serbia"));
        staffMembers.add(s1);
        staffMembers.add(s2);

        when(dbb.getAllStaffMembers()).thenReturn(staffMembers);

        Response response = so.execute(null);

        verify(dbb, times(1)).getAllStaffMembers();

        assertEquals(ServerResponse.OK, response.getServerResponse());
        assertEquals(staffMembers, (List<Player>) response.getObject());
    }

    @Test
    void testExecuteError() throws Exception {
        doThrow(new SQLException()).when(dbb).getAllStaffMembers();


        Response response = so.execute(null);

        verify(dbb, times(1)).getAllStaffMembers();

        assertEquals(ServerResponse.ERROR, response.getServerResponse());
        assertEquals("Cannot return all staff members", (String) response.getObject());
    }

}