package rs.volleybox.backend.so;

import org.junit.jupiter.api.Test;
import rs.volleybox.backend.so.impl.SOAddPlayer;
import rs.volleybox.backend.so.impl.SOAddPlayerEngagement;
import rs.volleybox.common_lib.domain.*;
import rs.volleybox.common_lib.enumeration.Hand;
import rs.volleybox.common_lib.enumeration.PlayerPosition;
import rs.volleybox.common_lib.enumeration.ServerResponse;
import rs.volleybox.common_lib.transfer.Response;

import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class SOAddPlayerEngagementTest extends SOClassTest{

    @Override
    protected void createSO() {
        so = new SOAddPlayerEngagement();
    }

    @Test
    void testExecuteSuccess() throws Exception {
        doNothing().when(dbb).addPlayerEngagement(any(PlayerEngagement.class));

        Player player = new Player(1, "Dimitrije", "Dobrijevic", LocalDate.of(2000,1,28), 193, 88, 330, 310, Hand.RIGHT, new Country(1, "Serbia"));
        Roster roster = new Roster(new Team(1, "Crvena Zvezda Belgrade", 1945, new Country(1, "Serbia"), new Hall(1, "USC Vozdovac", "Crnotravska 4, Beograd")), 1, new Season(1, 2022, 2023));
        PlayerEngagement playerEngagement = new PlayerEngagement(player, roster, PlayerPosition.MIDDLE_BLOCKER, 14);
        Response response = so.execute(playerEngagement);

        verify(dbb, times(1)).addPlayerEngagement(any(PlayerEngagement.class));

        assertEquals(ServerResponse.OK, response.getServerResponse());
        assertNull(response.getObject());
    }

    @Test
    void testExecuteError() throws Exception {
        doThrow(new SQLException()).when(dbb).addPlayerEngagement(any(PlayerEngagement.class));

        Player player = new Player(1, "Dimitrije", "Dobrijevic", LocalDate.of(2000,1,28), 193, 88, 330, 310, Hand.RIGHT, new Country(1, "Serbia"));
        Roster roster = new Roster(new Team(1, "Crvena Zvezda Belgrade", 1945, new Country(1, "Serbia"), new Hall(1, "USC Vozdovac", "Crnotravska 4, Beograd")), 1, new Season(1, 2022, 2023));
        PlayerEngagement playerEngagement = new PlayerEngagement(player, roster, PlayerPosition.MIDDLE_BLOCKER, 14);
        Response response = so.execute(playerEngagement);

        verify(dbb, times(1)).addPlayerEngagement(any(PlayerEngagement.class));

        assertEquals(ServerResponse.ERROR, response.getServerResponse());
        assertEquals("Player engagement not successfully added", (String) response.getObject());
    }

}