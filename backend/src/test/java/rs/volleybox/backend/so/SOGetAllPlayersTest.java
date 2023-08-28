package rs.volleybox.backend.so;

import org.junit.jupiter.api.Test;
import rs.volleybox.backend.so.impl.SOGetAllHalls;
import rs.volleybox.backend.so.impl.SOGetAllPlayers;
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
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class SOGetAllPlayersTest extends SOClassTest {

    @Override
    protected void createSO() {
        so = new SOGetAllPlayers();
    }

    @Test
    void testExecuteSuccess() throws Exception {
        List<Player> players = new ArrayList<>();
        Player player1 = new Player(1, "Dimitrije", "Dobrijevic", LocalDate.of(2000,1,28), 193, 88, 330, 310, Hand.RIGHT, new Country(1, "Serbia"));
        Player player2 = new Player(2, "Filip", "Trifunovic", LocalDate.of(1999, 7, 14), 186, 68, 310, 300, Hand.RIGHT, new Country(1, "Serbia"));
        players.add(player1);
        players.add(player2);

        when(dbb.getAllPlayers()).thenReturn(players);

        Response response = so.execute(null);

        verify(dbb, times(1)).getAllPlayers();

        assertEquals(ServerResponse.OK, response.getServerResponse());
        assertEquals(players, (List<Player>) response.getObject());
    }

    @Test
    void testExecuteError() throws Exception {
        doThrow(new SQLException()).when(dbb).getAllPlayers();


        Response response = so.execute(null);

        verify(dbb, times(1)).getAllPlayers();

        assertEquals(ServerResponse.ERROR, response.getServerResponse());
        assertEquals("Cannot return all players", (String) response.getObject());
    }

}