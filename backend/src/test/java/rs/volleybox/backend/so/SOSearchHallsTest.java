package rs.volleybox.backend.so;

import org.junit.jupiter.api.Test;
import rs.volleybox.backend.so.impl.SOGetAllHalls;
import rs.volleybox.backend.so.impl.SOSearchHalls;
import rs.volleybox.common_lib.domain.Hall;
import rs.volleybox.common_lib.enumeration.ServerResponse;
import rs.volleybox.common_lib.transfer.Response;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class SOSearchHallsTest extends SOClassTest {

    @Override
    protected void createSO() {
        so = new SOSearchHalls();
    }

    @Test
    void testExecuteSuccess() throws Exception {
        List<Hall> halls = new ArrayList<>();
        Hall h1 = new Hall(5, "HS Kraljevo", "Kraljevo");
        Hall h2 = new Hall(7, "HS Dudova Suma", "Ferenca Sepa 3, Subotica");
        halls.add(h1);
        halls.add(h2);

        when(dbb.findHallsSearch(any(String.class))).thenReturn(halls);

        Response response = so.execute("HS");

        verify(dbb, times(1)).findHallsSearch(any(String.class));

        assertEquals(ServerResponse.OK, response.getServerResponse());
        assertEquals(halls, (List<Hall>) response.getObject());
    }

    @Test
    void testExecuteError() throws Exception {
        doThrow(new SQLException()).when(dbb).findHallsSearch(any(String.class));

        Response response = so.execute("HS");

        verify(dbb, times(1)).findHallsSearch(any(String.class));

        assertEquals(ServerResponse.ERROR, response.getServerResponse());
        assertEquals("Cannot return halls for by given name", (String) response.getObject());
    }

}