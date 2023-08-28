package rs.volleybox.backend.so;

import org.junit.jupiter.api.Test;
import rs.volleybox.backend.so.impl.SOGetAllPlayers;
import rs.volleybox.backend.so.impl.SOGetAllSeasons;
import rs.volleybox.common_lib.domain.Country;
import rs.volleybox.common_lib.domain.Player;
import rs.volleybox.common_lib.domain.Season;
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

class SOGetAllSeasonsTest extends SOClassTest {

    @Override
    protected void createSO() {
        so = new SOGetAllSeasons();
    }

    @Test
    void testExecuteSuccess() throws Exception {
        List<Season> seasons = new ArrayList<>();
        Season s1 = new Season(1, 2022, 2023);
        Season s2 = new Season(2, 2023, 2024);
        seasons.add(s1);
        seasons.add(s2);

        when(dbb.getAllSeasons()).thenReturn(seasons);

        Response response = so.execute(null);

        verify(dbb, times(1)).getAllSeasons();

        assertEquals(ServerResponse.OK, response.getServerResponse());
        assertEquals(seasons, (List<Season>) response.getObject());
    }

    @Test
    void testExecuteError() throws Exception {
        doThrow(new SQLException()).when(dbb).getAllSeasons();


        Response response = so.execute(null);

        verify(dbb, times(1)).getAllSeasons();

        assertEquals(ServerResponse.ERROR, response.getServerResponse());
        assertEquals("Cannot return all seasons", (String) response.getObject());
    }

}