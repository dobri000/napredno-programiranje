/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
 * This class represents a system operation for updating player information in the database.
 * The system operation updates the information of the provided player object in the database.
 *
 * @author HOME
 */
public class SOUpdatePlayer extends SOClass {

    /**
     * Executes the system operation to update player information in the database.
     *
     * @param object The player object with updated information.
     * @return A response indicating the outcome of the update operation.
     *         If the operation is successful, the response will have status {@link ServerResponse#OK}.
     *         If an error occurs during the database operation, the response will have status {@link ServerResponse#ERROR}
     *         and the error message will provide more information.
     * @throws IOException If there is an issue with input/output during JSON conversion.
     */
    @Override
    public Response execute(Object object) throws IOException {
        try {
            Player player = JsonSerializationUtils.convertValue(object, new TypeReference<Player>() {});
            dbbroker.updatePlayer(player);
            return new Response(ServerResponse.OK, null);
        } catch (SQLException ex) {
            return new Response(ServerResponse.ERROR, "Cannot update player information");
        }
    }

}
