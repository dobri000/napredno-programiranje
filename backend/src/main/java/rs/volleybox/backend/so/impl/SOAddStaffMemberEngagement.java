package rs.volleybox.backend.so.impl;

import java.io.IOException;
import java.sql.SQLException;

import com.fasterxml.jackson.core.type.TypeReference;

import rs.volleybox.backend.database.DBBroker;
import rs.volleybox.backend.so.SOClass;
import rs.volleybox.common_lib.domain.StaffMemberEngagement;
import rs.volleybox.common_lib.enumeration.ServerResponse;
import rs.volleybox.common_lib.transfer.Response;
import rs.volleybox.common_lib.utils.JsonSerializationUtils;

/**
 * This class represents a system operation for adding a new staff member engagement to the database.
 * The staff member engagement details are provided in the input object, and the system operation
 * handles the process of adding the engagement to the database using the provided DBBroker.
 *
 * A staff member engagement typically includes information about the staff member, roster, and position.
 *
 * @author Dimitrije
 */
public class SOAddStaffMemberEngagement extends SOClass {

    /**
     * Executes the system operation to add a new staff member engagement to the database.
     *
     * @param object The input object containing the details of the staff member engagement to be added.
     * @return A {@link Response} indicating the result of the operation.
     *         If the staff member engagement is successfully added, the response will have status {@link ServerResponse#OK}.
     *         If an error occurs during the database operation, the response will have status {@link ServerResponse#ERROR}
     *         and the error message will provide more information.
     * @throws IOException If there is an issue with input/output during JSON conversion.
     */
    @Override
    public Response execute(Object object) throws IOException {
        try {
            StaffMemberEngagement engagement = JsonSerializationUtils.convertValue(object, new TypeReference<StaffMemberEngagement>() {
            });
            dbbroker.addStaffMemberEngagement(engagement);
            return new Response(ServerResponse.OK, null);
        } catch (SQLException ex) {
            return new Response(ServerResponse.ERROR, "Staff member engagement not successfully added");
        }
    }

}
