/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.volleybox.backend.so.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import rs.volleybox.backend.database.DBBroker;
import rs.volleybox.backend.so.SOClass;
import rs.volleybox.common_lib.domain.Player;
import rs.volleybox.common_lib.enumeration.ServerResponse;
import rs.volleybox.common_lib.transfer.Response;
import rs.volleybox.common_lib.utils.JsonSerializationUtils;

/**
 * This class represents a system operation for searching players based on a search term.
 * The system operation searches for players whose first names or last names contain or closely match the provided search term.
 *
 * The search term is used to find players with first names or last names that contain or closely match the search text.
 *
 * @author HOME
 */
public class SOSearchPlayers extends SOClass {

    /**
     * Executes the system operation to search for players based on the provided search term.
     *
     * @param object The search term (as a String) used to search for players.
     * @return A {@link Response} containing the list of {@link Player} objects retrieved from the database.
     *         If the operation is successful, the response will have status {@link ServerResponse#OK} and the list of players.
     *         If an error occurs during the database operation, the response will have status {@link ServerResponse#ERROR}
     *         and the error message will provide more information.
     * @throws IOException If there is an issue with input/output during JSON conversion.
     */
    @Override
    public Response execute(Object object) throws IOException {
        try {
            String search = JsonSerializationUtils.convertValue(object, new TypeReference<String>() {});
            List<Player> players = dbbroker.getPlayersByFirstnameOrLastname(search);
            return new Response(ServerResponse.OK, players);
        } catch (SQLException ex) {
            return new Response(ServerResponse.ERROR, "Cannot return players by the given name");
        }
    }
}
