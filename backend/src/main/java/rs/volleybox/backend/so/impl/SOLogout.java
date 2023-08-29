/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.volleybox.backend.so.impl;

import java.io.IOException;

import com.fasterxml.jackson.core.type.TypeReference;

import rs.volleybox.backend.database.DBBroker;
import rs.volleybox.backend.so.SOClass;
import rs.volleybox.common_lib.domain.Admin;
import rs.volleybox.common_lib.domain.Player;
import rs.volleybox.common_lib.enumeration.ServerResponse;
import rs.volleybox.common_lib.transfer.Response;
import rs.volleybox.common_lib.utils.JsonSerializationUtils;

/**
 * This class represents a system operation for logging out an admin user from the system.
 * The system operation handles the process of ending an admin user's session and invalidating their authentication.
 *
 * @author HOME
 */
public class SOLogout extends SOClass {

    /**
     * Executes the system operation to log out an admin user from the system.
     *
     * @param object The admin object for which the logout is requested.
     * @return A {@link Response} indicating the result of the logout attempt.
     *         If the logout is successful, the response will have status {@link ServerResponse#OK} and a success message.
     *         If the logout fails, the response will have status {@link ServerResponse#ERROR} and an error message.
     * @throws IOException If there is an issue with input/output during JSON conversion.
     */
    @Override
    public Response execute(Object object) throws IOException {
        Admin admin = JsonSerializationUtils.convertValue(object, new TypeReference<Admin>() {});
        boolean success = dbbroker.logout(admin);
        if (success) {
            return new Response(ServerResponse.OK, "Successfully logged out");
        } else {
            return new Response(ServerResponse.ERROR, "Admin cannot log out");
        }
    }
}

