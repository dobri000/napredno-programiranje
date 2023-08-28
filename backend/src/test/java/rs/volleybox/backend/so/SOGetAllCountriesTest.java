package rs.volleybox.backend.so;

import org.junit.jupiter.api.Test;
import rs.volleybox.backend.so.impl.SOGetAllCountries;
import rs.volleybox.common_lib.domain.Country;
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

class SOGetAllCountriesTest extends SOClassTest {

    @Override
    protected void createSO() {
        so = new SOGetAllCountries();
    }

    @Test
    void testExecuteSuccess() throws Exception {
        List<Country> counries = new ArrayList<>();
        Country country1 = new Country(1, "Serbia");
        Country country2 = new Country(2, "Bosnia and Hercegovina");
        Country country3 = new Country(3, "Montenegro");
        counries.add(country1);
        counries.add(country2);
        counries.add(country3);
        when(dbb.getAllCountries()).thenReturn(counries);

        Response response = so.execute(null);

        verify(dbb, times(1)).getAllCountries();

        assertEquals(ServerResponse.OK, response.getServerResponse());
        assertEquals(counries, (List<Country>) response.getObject());
    }

    @Test
    void testExecuteError() throws Exception {
        doThrow(new SQLException()).when(dbb).getAllCountries();

        Response response = so.execute(null);

        verify(dbb, times(1)).getAllCountries();

        assertEquals(ServerResponse.ERROR, response.getServerResponse());
        assertEquals("Cannot return all countries", (String) response.getObject());
    }
}