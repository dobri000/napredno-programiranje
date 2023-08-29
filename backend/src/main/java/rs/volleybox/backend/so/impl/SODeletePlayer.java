package rs.volleybox.backend.so.impl;

import java.io.IOException;
import java.sql.SQLException;

import com.fasterxml.jackson.core.type.TypeReference;

import rs.volleybox.backend.database.DBBroker;
import rs.volleybox.backend.so.SOClass;
import rs.volleybox.common_lib.domain.Player;
import rs.volleybox.common_lib.enumeration.ServerResponse;
import rs.volleybox.common_lib.transfer.Response;
import rs.volleybox.common_lib.utils.JsonSerializationUtils;

/**
 * This class represents a system operation for deleting a player from the database.
 * The player to be deleted is specified in the input object, and the system operation
 * handles the process of removing the player from the database using the provided DBBroker.
 *
 * @author HOME
 */
public class SODeletePlayer extends SOClass {

    /**
     * Executes the system operation to delete a player from the database.
     *
     * @param object The input object specifying the player to be deleted.
     * @return A {@link Response} indicating the result of the operation.
     *         If the player is successfully deleted, the response will have status {@link ServerResponse#OK}.
     *         If an error occurs during the database operation, the response will have status {@link ServerResponse#ERROR}
     *         and the error message will provide more information.
     * @throws IOException If there is an issue with input/output during JSON conversion.
     */
    @Override
    public Response execute(Object object) throws IOException {
        try {
            Player player = JsonSerializationUtils.convertValue(object, new TypeReference<Player>() {
            });
            dbbroker.deletePlayer(player);
            return new Response(ServerResponse.OK, null);
        } catch (SQLException ex) {
            return new Response(ServerResponse.ERROR, "Player not successfully deleted");
        }
    }


}
