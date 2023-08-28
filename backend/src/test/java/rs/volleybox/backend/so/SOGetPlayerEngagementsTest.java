package rs.volleybox.backend.so;

import org.junit.jupiter.api.Test;
import rs.volleybox.backend.so.impl.SOGetAllPlayers;
import rs.volleybox.backend.so.impl.SOGetPlayerEngagements;
import rs.volleybox.common_lib.domain.*;
import rs.volleybox.common_lib.enumeration.Hand;
import rs.volleybox.common_lib.enumeration.PlayerPosition;
import rs.volleybox.common_lib.enumeration.ServerResponse;
import rs.volleybox.common_lib.transfer.Response;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class SOGetPlayerEngagementsTest extends SOClassTest {

    @Override
    protected void createSO() {
        so = new SOGetPlayerEngagements();
    }

    @Test
    void testExecuteSuccess() throws Exception {
        List<PlayerEngagement> pl1 = new ArrayList<>();
        List<PlayerEngagement> pl2 = new ArrayList<>();
        Player player1 = new Player(1, "Dimitrije", "Dobrijevic", LocalDate.of(2000,1,28), 193, 88, 330, 310, Hand.RIGHT, new Country(1, "Serbia"));
        Player player2 = new Player(2, "Filip", "Trifunovic", LocalDate.of(1999, 7, 14), 186, 68, 310, 300, Hand.RIGHT, new Country(1, "Serbia"));
        Hall h1 = new Hall(1, "USC Vozdovac", "Crnotravska 4, Beograd");
        Hall h2 = new Hall(2, "SC Pozarevac", "Partizanska 1, Pozarevac");
        Country country = new Country(1, "Serbia");
        Team t1 = new Team(1, "Crvena Zvezda Belgrade", 1945, country, h1);
        Team t2 = new Team(2, "Mladi Radnik Pozarevac", 1946, country, h2);
        Season s1 = new Season(1, 2022, 2023);
        Season s2 = new Season(2, 2023, 2024);
        Roster r11 = new Roster(t1, 1, s1);
        Roster r12 = new Roster(t1, 2, s2);
        Roster r21 = new Roster(t2, 1, s1);
        Roster r22 = new Roster(t2, 2, s2);
        PlayerEngagement pe1 = new PlayerEngagement(player1, r11, PlayerPosition.MIDDLE_BLOCKER, 14);
        PlayerEngagement pe2 = new PlayerEngagement(player1, r12, PlayerPosition.MIDDLE_BLOCKER, 14);
        PlayerEngagement pe3 = new PlayerEngagement(player2, r21, PlayerPosition.LIBERO, 4);
        PlayerEngagement pe4 = new PlayerEngagement(player2, r22, PlayerPosition.LIBERO, 4);
        pl1.add(pe1);
        pl1.add(pe2);
        pl1.add(pe3);
        pl1.add(pe4);
        pl2.add(pe1);
        pl2.add(pe1);



        when(dbb.getPlayerEngagements(player1)).thenReturn(pl2);

        Response response = so.execute(player1);

        verify(dbb, times(1)).getPlayerEngagements(player1);

        assertEquals(ServerResponse.OK, response.getServerResponse());
        assertEquals(pl2, (List<PlayerEngagement>) response.getObject());
    }

    @Test
    void testExecuteError() throws Exception {
        Player player1 = new Player(1, "Dimitrije", "Dobrijevic", LocalDate.of(2000,1,28), 193, 88, 330, 310, Hand.RIGHT, new Country(1, "Serbia"));

        doThrow(new SQLException()).when(dbb).getPlayerEngagements(player1);


        Response response = so.execute(player1);

        verify(dbb, times(1)).getPlayerEngagements(player1);

        assertEquals(ServerResponse.ERROR, response.getServerResponse());
        assertEquals("Cannot return player engagements", (String) response.getObject());
    }

}