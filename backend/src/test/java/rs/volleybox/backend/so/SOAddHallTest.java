package rs.volleybox.backend.so;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import rs.volleybox.backend.so.impl.SOAddHall;
import rs.volleybox.common_lib.domain.Hall;
import rs.volleybox.common_lib.enumeration.ServerResponse;
import rs.volleybox.common_lib.transfer.Response;

import java.sql.SQLException;

class SOAddHallTest extends SOClassTest {

    @Override
    protected void createSO() {
        so = new SOAddHall();
    }

    @Test
    void testExecuteSuccess() throws Exception {
        doNothing().when(dbb).addHall(any(Hall.class));

        Hall hall = new Hall(1, "USC Vozdovac", "Crnotravska 4, Beograd");
        Response response = so.execute(hall);

        verify(dbb, times(1)).addHall(any(Hall.class));

        assertEquals(ServerResponse.OK, response.getServerResponse());
        assertNull(response.getObject());
    }

    @Test
    void testExecuteError() throws Exception {
        doThrow(new SQLException()).when(dbb).addHall(any(Hall.class));

        Hall hall = new Hall(1, "USC Vozdovac", "Crnotravska 4, Beograd");
        Response response = so.execute(hall);

        verify(dbb, times(1)).addHall(any(Hall.class));

        assertEquals(ServerResponse.ERROR, response.getServerResponse());
        assertEquals("Hall not successfully added", (String) response.getObject());
    }

}
