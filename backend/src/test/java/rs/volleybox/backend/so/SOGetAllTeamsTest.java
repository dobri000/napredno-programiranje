package rs.volleybox.backend.so;

import org.junit.jupiter.api.Test;
import rs.volleybox.backend.so.impl.SOGetAllHalls;
import rs.volleybox.backend.so.impl.SOGetAllTeams;
import rs.volleybox.common_lib.domain.Country;
import rs.volleybox.common_lib.domain.Hall;
import rs.volleybox.common_lib.domain.Team;
import rs.volleybox.common_lib.enumeration.ServerResponse;
import rs.volleybox.common_lib.transfer.Response;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class SOGetAllTeamsTest extends SOClassTest {

    @Override
    protected void createSO() {
        so = new SOGetAllTeams();
    }

    @Test
    void testExecuteSuccess() throws Exception {
        List<Team> teams = new ArrayList<>();
        Hall h1 = new Hall(1, "USC Vozdovac", "Crnotravska 4, Beograd");
        Hall h2 = new Hall(2, "SC Pozarevac", "Partizanska 1, Pozarevac");
        Country country = new Country(1, "Serbia");
        Team t1 = new Team(1, "Crvena Zvezda Belgrade", 1945, country, h1);
        Team t2 = new Team(2, "Mladi Radnik Pozarevac", 1946, country, h2);
        teams.add(t1);
        teams.add(t2);

        when(dbb.getAllTeams()).thenReturn(teams);

        Response response = so.execute(null);

        verify(dbb, times(1)).getAllTeams();

        assertEquals(ServerResponse.OK, response.getServerResponse());
        assertEquals(teams, (List<Hall>) response.getObject());
    }

    @Test
    void testExecuteError() throws Exception {
        doThrow(new SQLException()).when(dbb).getAllTeams();

        Response response = so.execute(null);

        verify(dbb, times(1)).getAllTeams();

        assertEquals(ServerResponse.ERROR, response.getServerResponse());
        assertEquals("Cannot return all teams", (String) response.getObject());
    }

}