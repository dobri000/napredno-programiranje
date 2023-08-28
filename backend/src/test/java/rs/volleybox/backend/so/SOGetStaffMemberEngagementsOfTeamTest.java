package rs.volleybox.backend.so;

import org.junit.jupiter.api.Test;
import rs.volleybox.backend.so.impl.SOGetStaffMemberEngagements;
import rs.volleybox.backend.so.impl.SOGetStaffMemberEngagementsOfTeam;
import rs.volleybox.common_lib.domain.*;
import rs.volleybox.common_lib.enumeration.ServerResponse;
import rs.volleybox.common_lib.enumeration.StaffMemberPosition;
import rs.volleybox.common_lib.transfer.Response;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class SOGetStaffMemberEngagementsOfTeamTest extends SOClassTest {

    @Override
    protected void createSO() {
        so = new SOGetStaffMemberEngagementsOfTeam();
    }

    @Test
    void testExecuteSuccess() throws Exception {
        List<StaffMemberEngagement> pl1 = new ArrayList<>();
        List<StaffMemberEngagement> pl2 = new ArrayList<>();
        StaffMember sm1 = new StaffMember(1, "Dimitrije", "Dobrijevic", LocalDate.of(2000,1,28), new Country(1, "Serbia"));
        StaffMember sm2 = new StaffMember(2, "Filip", "Trifunovic", LocalDate.of(1999, 7, 14), new Country(1, "Serbia"));
        Hall h1 = new Hall(1, "USC Vozdovac", "Crnotravska 4, Beograd");
        Hall h2 = new Hall(2, "SC Pozarevac", "Partizanska 1, Pozarevac");
        Country country = new Country(1, "Serbia");
        Team t1 = new Team(1, "Crvena Zvezda Belgrade", 1945, country, h1);
        Team t2 = new Team(2, "Mladi Radnik Pozarevac", 1946, country, h2);
        Season s1 = new Season(1, 2022, 2023);
        Season s2 = new Season(2, 2023, 2024);
        Roster r11 = new Roster(t1, 1, s1);
        Roster r12 = new Roster(t1, 2, s2);
        Roster r21 = new Roster(t2, 1, s1);
        Roster r22 = new Roster(t2, 2, s2);
        StaffMemberEngagement sme1 = new StaffMemberEngagement(sm1, r11, StaffMemberPosition.STATISTICIAN);
        StaffMemberEngagement sme2 = new StaffMemberEngagement(sm1, r12, StaffMemberPosition.STATISTICIAN);
        StaffMemberEngagement sme3 = new StaffMemberEngagement(sm2, r21, StaffMemberPosition.PHYSICAL_PREPARATION_COACH);
        StaffMemberEngagement sme4 = new StaffMemberEngagement(sm2, r22, StaffMemberPosition.PHYSICAL_PREPARATION_COACH);

        pl1.add(sme1);
        pl1.add(sme2);
        pl1.add(sme3);
        pl1.add(sme4);
        pl2.add(sme1);
        pl2.add(sme1);



        when(dbb.getStaffMemberEngagementsOfTeam(t1)).thenReturn(pl2);

        Response response = so.execute(t1);

        verify(dbb, times(1)).getStaffMemberEngagementsOfTeam(t1);

        assertEquals(ServerResponse.OK, response.getServerResponse());
        assertEquals(pl2, (List<StaffMemberEngagement>) response.getObject());
    }

    @Test
    void testExecuteError() throws Exception {
        Hall h1 = new Hall(1, "USC Vozdovac", "Crnotravska 4, Beograd");
        Country country = new Country(1, "Serbia");
        Team t1 = new Team(1, "Crvena Zvezda Belgrade", 1945, country, h1);
        doThrow(new SQLException()).when(dbb).getStaffMemberEngagementsOfTeam(t1);


        Response response = so.execute(t1);

        verify(dbb, times(1)).getStaffMemberEngagementsOfTeam(t1);

        assertEquals(ServerResponse.ERROR, response.getServerResponse());
        assertEquals("Cannot return staff member engagements", (String) response.getObject());
    }

}