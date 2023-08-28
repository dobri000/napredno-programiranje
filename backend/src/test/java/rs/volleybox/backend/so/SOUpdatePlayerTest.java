package rs.volleybox.backend.so;

import org.junit.jupiter.api.Test;
import rs.volleybox.backend.so.impl.SOAddPlayer;
import rs.volleybox.backend.so.impl.SOUpdatePlayer;
import rs.volleybox.common_lib.domain.Country;
import rs.volleybox.common_lib.domain.Player;
import rs.volleybox.common_lib.enumeration.Hand;
import rs.volleybox.common_lib.enumeration.ServerResponse;
import rs.volleybox.common_lib.transfer.Response;

import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class SOUpdatePlayerTest extends SOClassTest {

    @Override
    protected void createSO() {
        so = new SOUpdatePlayer();
    }

    @Test
    void testExecuteSuccess() throws Exception {
        doNothing().when(dbb).updatePlayer(any(Player.class));

        Player player = new Player(1, "Dimitrije", "Dobrijevic", LocalDate.of(2000,1,28), 193, 88, 330, 310, Hand.RIGHT, new Country(1, "Serbia"));
        Response response = so.execute(player);

        verify(dbb, times(1)).updatePlayer(any(Player.class));

        assertEquals(ServerResponse.OK, response.getServerResponse());
        assertNull(response.getObject());
    }

    @Test
    void testExecuteError() throws Exception {
        doThrow(new SQLException()).when(dbb).updatePlayer(any(Player.class));

        Player player = new Player(1, "Dimitrije", "Dobrijevic", LocalDate.of(2000,1,28), 193, 88, 330, 310, Hand.RIGHT, new Country(1, "Serbia"));
        Response response = so.execute(player);

        verify(dbb, times(1)).updatePlayer(any(Player.class));

        assertEquals(ServerResponse.ERROR, response.getServerResponse());
        assertEquals("Cannot update player", (String) response.getObject());
    }

}