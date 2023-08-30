package rs.volleybox.backend.so;

import org.junit.jupiter.api.Test;
import rs.volleybox.backend.so.impl.SOSearchPlayers;
import rs.volleybox.backend.so.impl.SOSearchStaffMembers;
import rs.volleybox.common_lib.domain.Country;
import rs.volleybox.common_lib.domain.Hall;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class SOSearchStaffMembersTest extends SOClassTest {

    @Override
    protected void createSO() {
        so = new SOSearchStaffMembers();
    }

    @Test
    void testExecuteSuccess() throws Exception {
        List<StaffMember> staffMembers = new ArrayList<>();
        StaffMember s1 = new StaffMember(1, "Ivica", "Jevtic", LocalDate.of(2000,1,28), new Country(1, "Serbia"));
        StaffMember s2 = new StaffMember(2, "Bojan", "Janic", LocalDate.of(1999, 7, 14), new Country(1, "Serbia"));
        staffMembers.add(s1);
        staffMembers.add(s2);

        when(dbb.getStaffMembersByFirstnameOrLastname(any(String.class))).thenReturn(staffMembers);

        Response response = so.execute("j");

        verify(dbb, times(1)).getStaffMembersByFirstnameOrLastname(any(String.class));

        assertEquals(ServerResponse.OK, response.getServerResponse());
        assertEquals(staffMembers, (List<StaffMember>) response.getObject());
    }

    @Test
    void testExecuteError() throws Exception {
        doThrow(new SQLException()).when(dbb).getStaffMembersByFirstnameOrLastname(any(String.class));

        Response response = so.execute("j");

        verify(dbb, times(1)).getStaffMembersByFirstnameOrLastname(any(String.class));

        assertEquals(ServerResponse.ERROR, response.getServerResponse());
        assertEquals("Cannot return staff members by the given name", (String) response.getObject());
    }

}