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
import rs.volleybox.common_lib.transfer.Response;
import rs.volleybox.common_lib.utils.JsonSerializationUtils;

/**
 * This class represents a system operation for quitting the system, effectively logging out an admin user.
 * The system operation handles the process of ending an admin user's session and invalidating their authentication.
 *
 * @author Dimitrije
 */
public class SOQuit extends SOClass {

    /**
     * Executes the system operation to quit the system and log out an admin user.
     *
     * @param object The admin object for which the quit operation is requested.
     * @return This operation does not return any response. It simply logs out the admin user.
     * @throws IOException If there is an issue with input/output during JSON conversion.
     */
    @Override
    public Response execute(Object object) throws IOException {
        Admin admin = JsonSerializationUtils.convertValue(object, new TypeReference<Admin>() {});
        dbbroker.logout(admin);
        return null;
    }
}

