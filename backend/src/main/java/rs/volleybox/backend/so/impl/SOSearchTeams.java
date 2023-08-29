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
import rs.volleybox.common_lib.domain.Team;
import rs.volleybox.common_lib.enumeration.ServerResponse;
import rs.volleybox.common_lib.transfer.Response;
import rs.volleybox.common_lib.utils.JsonSerializationUtils;

/**
 * This class represents a system operation for searching teams based on a search term.
 * The system operation searches for teams whose names or codes contain or closely match the provided search term.
 *
 * The search term is used to find teams with names or codes that contain or closely match the search text.
 *
 * @author HOME
 */
public class SOSearchTeams extends SOClass {

    /**
     * Executes the system operation to search for teams based on the provided search term.
     *
     * @param object The search term (as a String) used to search for teams.
     * @return A {@link Response} containing the list of {@link Team} objects retrieved from the database.
     *         If the operation is successful, the response will have status {@link ServerResponse#OK} and the list of teams.
     *         If an error occurs during the database operation, the response will have status {@link ServerResponse#ERROR}
     *         and the error message will provide more information.
     * @throws IOException If there is an issue with input/output during JSON conversion.
     */
    @Override
    public Response execute(Object object) throws IOException {
        try {
            String search = JsonSerializationUtils.convertValue(object, new TypeReference<String>() {});
            List<Team> teams = dbbroker.searchTeam(search);
            return new Response(ServerResponse.OK, teams);
        } catch (SQLException ex) {
            return new Response(ServerResponse.ERROR, "Cannot return teams by the given name");
        }
    }
}

