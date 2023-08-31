package rs.volleybox.backend.so.impl;

import java.io.IOException;
import java.sql.SQLException;

import com.fasterxml.jackson.core.type.TypeReference;

import rs.volleybox.backend.database.DBBroker;
import rs.volleybox.backend.so.SOClass;
import rs.volleybox.common_lib.domain.StaffMember;
import rs.volleybox.common_lib.enumeration.ServerResponse;
import rs.volleybox.common_lib.transfer.Response;
import rs.volleybox.common_lib.utils.JsonSerializationUtils;

/**
 * This class represents a system operation for adding a new staff member to the database.
 * The staff member details are provided in the input object, and the system operation
 * handles the process of adding the staff member to the database using the provided DBBroker.
 *
 * @author Dimitrije
 */
public class SOAddStaffMember extends SOClass {

    /**
     * Executes the system operation to add a new staff member to the database.
     *
     * @param object The input object containing the details of the staff member to be added.
     * @return A {@link Response} indicating the result of the operation.
     *         If the staff member is successfully added, the response will have status {@link ServerResponse#OK}.
     *         If an error occurs during the database operation, the response will have status {@link ServerResponse#ERROR}
     *         and the error message will provide more information.
     * @throws IOException If there is an issue with input/output during JSON conversion.
     */
    @Override
    public Response execute(Object object) throws IOException {
        try {
            StaffMember staff = JsonSerializationUtils.convertValue(object, new TypeReference<StaffMember>() {
            });
            dbbroker.addStaffMember(staff);
            return new Response(ServerResponse.OK, null);
        } catch (SQLException ex) {
            return new Response(ServerResponse.ERROR, "Staff member not successfully added");
        }
    }

}
