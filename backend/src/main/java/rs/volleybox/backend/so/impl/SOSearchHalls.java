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
import rs.volleybox.common_lib.domain.Hall;
import rs.volleybox.common_lib.domain.Player;
import rs.volleybox.common_lib.enumeration.ServerResponse;
import rs.volleybox.common_lib.transfer.Response;
import rs.volleybox.common_lib.utils.JsonSerializationUtils;

/**
 * This class represents a system operation for searching halls based on a search term.
 * The system operation searches for halls that match the provided search term and returns a list of matching halls.
 *
 * The search term is used to find halls with names that starts with the search text.
 *
 * @author HOME
 */
public class SOSearchHalls extends SOClass {

    /**
     * Executes the system operation to search for halls based on the provided search term.
     *
     * @param object The search term (as a String) used to search for halls.
     * @return A {@link Response} containing the list of {@link Hall} objects retrieved from the database.
     *         If the operation is successful, the response will have status {@link ServerResponse#OK} and the list of halls.
     *         If an error occurs during the database operation, the response will have status {@link ServerResponse#ERROR}
     *         and the error message will provide more information.
     * @throws IOException If there is an issue with input/output during JSON conversion.
     */
    @Override
    public Response execute(Object object) throws IOException {
        try {
            String search = JsonSerializationUtils.convertValue(object, new TypeReference<String>() {});
            List<Hall> halls = dbbroker.findHallsSearch(search);
            return new Response(ServerResponse.OK, halls);
        } catch (SQLException ex) {
            return new Response(ServerResponse.ERROR, "Cannot return halls by the given name");
        }
    }
}
