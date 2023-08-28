package rs.volleybox.backend.so;

import org.junit.jupiter.api.Test;
import rs.volleybox.backend.so.impl.SOSearchHalls;
import rs.volleybox.backend.so.impl.SOSearchPlayers;
import rs.volleybox.common_lib.domain.Country;
import rs.volleybox.common_lib.domain.Hall;
import rs.volleybox.common_lib.domain.Player;
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

class SOSearchPlayersTest extends SOClassTest {

    @Override
    protected void createSO() {
        so = new SOSearchPlayers();
    }

    @Test
    void testExecuteSuccess() throws Exception {
        List<Player> players = new ArrayList<>();
        Player player1 = new Player(1, "Aleksandar", "Gmitrovic", LocalDate.of(2000,1,28), 193, 88, 330, 310, Hand.RIGHT, new Country(1, "Serbia"));
        Player player2 = new Player(2, "Aleksandar", "Bosnjak", LocalDate.of(2000, 6, 20), 207, 68, 340, 320, Hand.RIGHT, new Country(1, "Serbia"));
        Player player3 = new Player(3, "Aleksandar", "Okolic", LocalDate.of(1999, 7, 14), 205, 68, 350, 320, Hand.RIGHT, new Country(1, "Serbia"));

        players.add(player1);
        players.add(player2);
        players.add(player3);

        when(dbb.getPlayersByFirstnameOrLastname(any(String.class))).thenReturn(players);

        Response response = so.execute("aleksandar");

        verify(dbb, times(1)).getPlayersByFirstnameOrLastname(any(String.class));

        assertEquals(ServerResponse.OK, response.getServerResponse());
        assertEquals(players, (List<Hall>) response.getObject());
    }

    @Test
    void testExecuteError() throws Exception {
        doThrow(new SQLException()).when(dbb).getPlayersByFirstnameOrLastname(any(String.class));

        Response response = so.execute("HS");

        verify(dbb, times(1)).getPlayersByFirstnameOrLastname(any(String.class));

        assertEquals(ServerResponse.ERROR, response.getServerResponse());
        assertEquals("Cannot return players for by given name", (String) response.getObject());
    }

}