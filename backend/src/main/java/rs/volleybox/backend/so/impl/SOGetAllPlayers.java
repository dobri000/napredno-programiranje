package rs.volleybox.backend.so.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import rs.volleybox.backend.database.DBBroker;
import rs.volleybox.backend.so.SOClass;
import rs.volleybox.common_lib.domain.Player;
import rs.volleybox.common_lib.enumeration.ServerResponse;
import rs.volleybox.common_lib.transfer.Response;

/**
 * This class represents a system operation for retrieving a list of all players from the database.
 * The system operation handles the process of fetching the list of players using the provided DBBroker.
 *
 * @author HOME
 */
public class SOGetAllPlayers extends SOClass {

    /**
     * Executes the system operation to retrieve a list of all players from the database.
     *
     * @param object This parameter is not used in this operation.
     * @return A {@link Response} containing the list of {@link Player} objects retrieved from the database.
     *         If the operation is successful, the response will have status {@link ServerResponse#OK} and the list of players.
     *         If an error occurs during the database operation, the response will have status {@link ServerResponse#ERROR}
     *         and the error message will provide more information.
     * @throws IOException If there is an issue with input/output during JSON conversion.
     */
    @Override
    public Response execute(Object object) throws IOException {
        try {
            List<Player> players = dbbroker.getAllPlayers();
            return new Response(ServerResponse.OK, players);
        } catch (SQLException ex) {
            return new Response(ServerResponse.ERROR, "Cannot return all players");
        }
    }

}
