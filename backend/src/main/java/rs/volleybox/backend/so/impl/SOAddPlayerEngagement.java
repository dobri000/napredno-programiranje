package rs.volleybox.backend.so.impl;

import java.io.IOException;
import java.sql.SQLException;

import com.fasterxml.jackson.core.type.TypeReference;

import rs.volleybox.backend.database.DBBroker;
import rs.volleybox.backend.so.SOClass;
import rs.volleybox.common_lib.domain.PlayerEngagement;
import rs.volleybox.common_lib.enumeration.ServerResponse;
import rs.volleybox.common_lib.transfer.Response;
import rs.volleybox.common_lib.utils.JsonSerializationUtils;

/**
 * This class represents a system operation for adding a new player engagement to the database.
 * The player engagement details are provided in the input object, and the system operation
 * handles the process of adding the engagement to the database using the provided DBBroker.
 *
 * A player engagement typically includes information about the player, roster, position, and number.
 *
 * @author Dimitrije
 */
public class SOAddPlayerEngagement extends SOClass {

    /**
     * Executes the system operation to add a new player engagement to the database.
     *
     * @param object The input object containing the details of the player engagement to be added.
     * @return A {@link Response} indicating the result of the operation.
     *         If the player engagement is successfully added, the response will have status {@link ServerResponse#OK}.
     *         If an error occurs during the database operation, the response will have status {@link ServerResponse#ERROR}
     *         and the error message will provide more information.
     * @throws IOException If there is an issue with input/output during JSON conversion.
     */
    @Override
    public Response execute(Object object) throws IOException {
        try {
            PlayerEngagement engagement = JsonSerializationUtils.convertValue(object, new TypeReference<PlayerEngagement>() {
            });
            dbbroker.addPlayerEngagement(engagement);
            return new Response(ServerResponse.OK, null);
        } catch (SQLException ex) {
            return new Response(ServerResponse.ERROR, "Player engagement not successfully added");
        }
    }

}
