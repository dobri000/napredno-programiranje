/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.volleybox.backend.so.impl;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.core.type.TypeReference;

import rs.volleybox.backend.database.DBBroker;
import rs.volleybox.backend.so.SOClass;
import rs.volleybox.common_lib.domain.Hall;
import rs.volleybox.common_lib.enumeration.ServerResponse;
import rs.volleybox.common_lib.transfer.Response;
import rs.volleybox.common_lib.utils.JsonSerializationUtils;


/**
 * System operation (SO) class to add a new hall to the database.
 * Implements the {@link SOClass} abstract class and defines the behavior for adding a new hall.
 * The {@link #execute(Object)} method is overridden to perform the hall addition operation.
 *
 * @author HOME
 */
public class SOAddHall extends SOClass {

    /**
     * Executes the hall addition operation with the provided hall object.
     * Converts the input object to a {@link Hall} instance and adds it to the database.
     *
     * @param object The hall object to be added.
     * @return A {@link Response} indicating the result of the operation.
     *         If the hall is successfully added, the response will have status {@link ServerResponse#OK}.
     *         If an error occurs during the database operation, the response will have status {@link ServerResponse#ERROR}
     *         and the error message will provide more information.
     * @throws IOException If an I/O error occurs during execution.
     */
    @Override
    public Response execute(Object object) throws IOException {
        try {
            Hall hall = JsonSerializationUtils.convertValue(object, new TypeReference<Hall>() {
            });
            dbbroker.addHall(hall);
            return new Response(ServerResponse.OK, null);
        } catch (SQLException ex) {
            return new Response(ServerResponse.ERROR, "Hall not successfully added");
        }
    }
}

