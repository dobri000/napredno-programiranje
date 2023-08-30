package rs.volleybox.backend.so;

import org.junit.jupiter.api.Test;
import rs.volleybox.backend.so.impl.SOSearchTeams;
import rs.volleybox.common_lib.domain.Country;
import rs.volleybox.common_lib.domain.Hall;
import rs.volleybox.common_lib.domain.Team;
import rs.volleybox.common_lib.enumeration.ServerResponse;
import rs.volleybox.common_lib.transfer.Response;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class SOSearchTeamsTest extends SOClassTest {

    @Override
    protected void createSO() {
        so = new SOSearchTeams();
    }

    @Test
    void testExecuteSuccess() throws Exception {
        List<Team> teams = new ArrayList<>();
        Hall h1 = new Hall(5, "HS Kraljevo", "Kraljevo");
        Hall h2 = new Hall(7, "HS Dudova Suma", "Ferenca Sepa 3, Subotica");
        Country country = new Country(1, "Serbia");
        Team t1 = new Team(1, "OK Metalac Takovo", 1945, country, h1);
        Team t2 = new Team(2, "OK Karadjordje Topola", 1946, country, h2);

        when(dbb.searchTeam(any(String.class))).thenReturn(teams);

        Response response = so.execute("ok");

        verify(dbb, times(1)).searchTeam(any(String.class));

        assertEquals(ServerResponse.OK, response.getServerResponse());
        assertEquals(teams, (List<Team>) response.getObject());
    }

    @Test
    void testExecuteError() throws Exception {
        doThrow(new SQLException()).when(dbb).searchTeam(any(String.class));

        Response response = so.execute("ok");

        verify(dbb, times(1)).searchTeam(any(String.class));

        assertEquals(ServerResponse.ERROR, response.getServerResponse());
        assertEquals("Cannot return teams by the given name", (String) response.getObject());
    }

}