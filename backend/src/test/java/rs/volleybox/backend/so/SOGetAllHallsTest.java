package rs.volleybox.backend.so;

import org.junit.jupiter.api.Test;
import rs.volleybox.backend.so.impl.SOGetAllCountries;
import rs.volleybox.backend.so.impl.SOGetAllHalls;
import rs.volleybox.common_lib.domain.Country;
import rs.volleybox.common_lib.domain.Hall;
import rs.volleybox.common_lib.enumeration.ServerResponse;
import rs.volleybox.common_lib.transfer.Response;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class SOGetAllHallsTest extends SOClassTest {

    @Override
    protected void createSO() {
        so = new SOGetAllHalls();
    }

    @Test
    void testExecuteSuccess() throws Exception {
        List<Hall> halls = new ArrayList<>();
        Hall h1 = new Hall(1, "USC Vozdovac", "Crnotravska 4, Beograd");
        Hall h2 = new Hall(2, "SC Pozarevac", "Partizanska 1, Pozarevac");
        halls.add(h1);
        halls.add(h2);

        when(dbb.getAllHalls()).thenReturn(halls);

        Response response = so.execute(null);

        verify(dbb, times(1)).getAllHalls();

        assertEquals(ServerResponse.OK, response.getServerResponse());
        assertEquals(halls, (List<Hall>) response.getObject());
    }

    @Test
    void testExecuteError() throws Exception {
        doThrow(new SQLException()).when(dbb).getAllHalls();

        Response response = so.execute(null);

        verify(dbb, times(1)).getAllHalls();

        assertEquals(ServerResponse.ERROR, response.getServerResponse());
        assertEquals("Cannot return all halls", (String) response.getObject());
    }

}