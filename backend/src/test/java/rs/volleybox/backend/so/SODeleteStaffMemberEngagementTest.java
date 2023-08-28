package rs.volleybox.backend.so;

import org.junit.jupiter.api.Test;
import rs.volleybox.backend.so.impl.SOAddStaffMemberEngagement;
import rs.volleybox.backend.so.impl.SODeleteStaffMemberEngagement;
import rs.volleybox.common_lib.domain.*;
import rs.volleybox.common_lib.enumeration.ServerResponse;
import rs.volleybox.common_lib.enumeration.StaffMemberPosition;
import rs.volleybox.common_lib.transfer.Response;

import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class SODeleteStaffMemberEngagementTest extends SOClassTest {

    @Override
    protected void createSO() {
        so = new SODeleteStaffMemberEngagement();
    }

    @Test
    void testExecuteSuccess() throws Exception {
        doNothing().when(dbb).deleteStaffMemberEngagement(any(StaffMemberEngagement.class));

        StaffMember staffMember = new StaffMember(1, "Luka", "Ratkovic", LocalDate.of(2003, 3, 31), new Country(1, "Serbia"));
        Roster roster = new Roster(new Team(1, "Crvena Zvezda Belgrade", 1945, new Country(1, "Serbia"), new Hall(1, "USC Vozdovac", "Crnotravska 4, Beograd")), 1, new Season(1, 2022, 2023));
        StaffMemberEngagement staffMemberEngagement = new StaffMemberEngagement(staffMember, roster, StaffMemberPosition.STATISTICIAN);
        Response response = so.execute(staffMemberEngagement);

        verify(dbb, times(1)).deleteStaffMemberEngagement(any(StaffMemberEngagement.class));

        assertEquals(ServerResponse.OK, response.getServerResponse());
        assertNull(response.getObject());
    }

    @Test
    void testExecuteError() throws Exception {
        doThrow(new SQLException()).when(dbb).deleteStaffMemberEngagement(any(StaffMemberEngagement.class));

        StaffMember staffMember = new StaffMember(1, "Luka", "Ratkovic", LocalDate.of(2003, 3, 31), new Country(1, "Serbia"));
        Roster roster = new Roster(new Team(1, "Crvena Zvezda Belgrade", 1945, new Country(1, "Serbia"), new Hall(1, "USC Vozdovac", "Crnotravska 4, Beograd")), 1, new Season(1, 2022, 2023));
        StaffMemberEngagement staffMemberEngagement = new StaffMemberEngagement(staffMember, roster, StaffMemberPosition.STATISTICIAN);
        Response response = so.execute(staffMemberEngagement);

        verify(dbb, times(1)).deleteStaffMemberEngagement(any(StaffMemberEngagement.class));

        assertEquals(ServerResponse.ERROR, response.getServerResponse());
        assertEquals("Staff member engagement not successfully deleted", (String) response.getObject());
    }

}