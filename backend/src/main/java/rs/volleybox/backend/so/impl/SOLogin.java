package rs.volleybox.backend.so.impl;

import java.io.IOException;
import java.sql.SQLException;

import com.fasterxml.jackson.core.type.TypeReference;

import rs.volleybox.backend.database.DBBroker;
import rs.volleybox.backend.so.SOClass;
import rs.volleybox.common_lib.domain.Admin;
import rs.volleybox.common_lib.enumeration.ServerResponse;
import rs.volleybox.common_lib.transfer.Response;
import rs.volleybox.common_lib.utils.JsonSerializationUtils;

/**
 * This class represents a system operation for authenticating an admin user's login credentials.
 * The system operation handles the process of validating the provided admin credentials using the provided DBBroker.
 *
 * @author HOME
 */
public class SOLogin extends SOClass {

    /**
     * Executes the system operation to authenticate an admin user's login credentials.
     *
     * @param object The admin object containing the login credentials to be validated.
     * @return A {@link Response} indicating the result of the login attempt.
     *         If the provided credentials are correct, the response will have status {@link ServerResponse#OK} and a success message.
     *         If the provided credentials are incorrect or user is already logged in, the response will have status {@link ServerResponse#ERROR} and an error message.
     *         If an error occurs during the database operation, the response will have status {@link ServerResponse#ERROR}
     *         and the error message will provide more information.
     * @throws IOException If there is an issue with input/output during JSON conversion.
     */
    @Override
    public Response execute(Object object) throws IOException {
        try {
            Admin admin = JsonSerializationUtils.convertValue(object, new TypeReference<Admin>() {});
            String success = dbbroker.login(admin);
            if (success.equals("Correct credentials")) {
                return new Response(ServerResponse.OK, success);
            } else {
                return new Response(ServerResponse.ERROR, success);
            }
        } catch (SQLException ex) {
            return new Response(ServerResponse.ERROR, "Cannot login");
        }
    }
}
