package rs.volleybox.backend.so.impl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;

import com.fasterxml.jackson.core.type.TypeReference;

import rs.volleybox.backend.database.DBBroker;
import rs.volleybox.backend.so.SOClass;
import rs.volleybox.common_lib.domain.Player;
import rs.volleybox.common_lib.enumeration.ServerResponse;
import rs.volleybox.common_lib.transfer.Response;
import rs.volleybox.common_lib.utils.JsonSerializationUtils;

/**
 * This class represents a system operation for adding a new player to the database.
 * The player details are provided in the input object, and the system operation
 * handles the process of adding the player to the database using the provided DBBroker.
 *
 * @author Dimitrije
 */
public class SOAddPlayer extends SOClass {

    /**
     * Executes the system operation to add a new player to the database.
     *
     * @param object The input object containing the details of the player to be added.
     * @return A {@link Response} indicating the result of the operation.
     *         If the player is successfully added, the response will have status {@link ServerResponse#OK}.
     *         If an error occurs during the database operation, the response will have status {@link ServerResponse#ERROR}
     *         and the error message will provide more information.
     * @throws IOException If there is an issue with input/output during JSON conversion.
     */
    @Override
    public Response execute(Object object) throws IOException {
        try {
            Player player = JsonSerializationUtils.convertValue(object, new TypeReference<Player>() {
            });
            dbbroker.addPlayer(player);
            return new Response(ServerResponse.OK, null);
        } catch (SQLException ex) {
            return new Response(ServerResponse.ERROR, "Player not successfully added");
        }
    }

}
