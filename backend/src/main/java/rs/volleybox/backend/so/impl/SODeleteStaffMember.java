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
 * This class represents a system operation for deleting a staff member from the database.
 * The staff member to be deleted is specified in the input object, and the system operation
 * handles the process of removing the staff member from the database using the provided DBBroker.
 *
 * @author HOME
 */
public class SODeleteStaffMember extends SOClass {

    /**
     * Executes the system operation to delete a staff member from the database.
     *
     * @param object The input object specifying the staff member to be deleted.
     * @return A {@link Response} indicating the result of the operation.
     *         If the staff member is successfully deleted, the response will have status {@link ServerResponse#OK}.
     *         If an error occurs during the database operation, the response will have status {@link ServerResponse#ERROR}
     *         and the error message will provide more information.
     * @throws IOException If there is an issue with input/output during JSON conversion.
     */
    @Override
    public Response execute(Object object) throws IOException {
        try {
            StaffMember staff = JsonSerializationUtils.convertValue(object, new TypeReference<StaffMember>() {
            });
            dbbroker.deleteStaffMember(staff);
            return new Response(ServerResponse.OK, null);
        } catch (SQLException ex) {
            return new Response(ServerResponse.ERROR, "Staff member not successfully deleted");
        }
    }

}
