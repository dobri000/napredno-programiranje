package rs.volleybox.backend.so;

import org.junit.jupiter.api.Test;
import rs.volleybox.backend.so.impl.SOAddTeam;
import rs.volleybox.backend.so.impl.SODeleteTeam;
import rs.volleybox.common_lib.domain.Country;
import rs.volleybox.common_lib.domain.Hall;
import rs.volleybox.common_lib.domain.Team;
import rs.volleybox.common_lib.enumeration.ServerResponse;
import rs.volleybox.common_lib.transfer.Response;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class SODeleteTeamTest extends SOClassTest {

    @Override
    protected void createSO() {
        so = new SODeleteTeam();
    }

    @Test
    void testExecuteSuccess() throws Exception {
        doNothing().when(dbb).deleteTeam(any(Team.class));

        Team team = new Team(1, "Crvena Zvezda Belgrade", 1945, new Country(1, "Serbia"), new Hall(1, "USC Vozdovac", "Crnotravska 4, Beograd"));
        Response response = so.execute(team);

        verify(dbb, times(1)).deleteTeam(any(Team.class));

        assertEquals(ServerResponse.OK, response.getServerResponse());
        assertNull(response.getObject());
    }

    @Test
    void testExecuteError() throws Exception {
        doThrow(new SQLException()).when(dbb).deleteTeam(any(Team.class));

        Team team = new Team(1, "Crvena Zvezda Belgrade", 1945, new Country(1, "Serbia"), new Hall(1, "USC Vozdovac", "Crnotravska 4, Beograd"));
        Response response = so.execute(team);

        verify(dbb, times(1)).deleteTeam(any(Team.class));

        assertEquals(ServerResponse.ERROR, response.getServerResponse());
        assertEquals("Team not successfully deleted", (String) response.getObject());
    }

}