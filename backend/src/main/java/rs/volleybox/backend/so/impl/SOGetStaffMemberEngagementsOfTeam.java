package rs.volleybox.backend.so.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import rs.volleybox.backend.database.DBBroker;
import rs.volleybox.backend.so.SOClass;
import rs.volleybox.common_lib.domain.StaffMemberEngagement;
import rs.volleybox.common_lib.domain.Team;
import rs.volleybox.common_lib.enumeration.ServerResponse;
import rs.volleybox.common_lib.transfer.Response;
import rs.volleybox.common_lib.utils.JsonSerializationUtils;

/**
 * This class represents a system operation for retrieving a list of staff member engagements associated with a specific team from the database.
 * The system operation handles the process of fetching the engagements of staff members associated with a specific team using the provided DBBroker.
 *
 * @author HOME
 */
public class SOGetStaffMemberEngagementsOfTeam extends SOClass {

    /**
     * Executes the system operation to retrieve a list of staff member engagements associated with a specific team.
     *
     * @param object The team object for which to retrieve staff member engagements.
     * @return A {@link Response} containing the list of {@link StaffMemberEngagement} objects retrieved from the database.
     *         If the operation is successful, the response will have status {@link ServerResponse#OK} and the list of engagements.
     *         If an error occurs during the database operation, the response will have status {@link ServerResponse#ERROR}
     *         and the error message will provide more information.
     * @throws IOException If there is an issue with input/output during JSON conversion.
     */
    @Override
    public Response execute(Object object) throws IOException {
        try {
            Team team = JsonSerializationUtils.convertValue(object, new TypeReference<Team>() {});
            List<StaffMemberEngagement> engagements = dbbroker.getStaffMemberEngagementsOfTeam(team);
            return new Response(ServerResponse.OK, engagements);
        } catch (SQLException ex) {
            return new Response(ServerResponse.ERROR, "Cannot return staff member engagements");
        }
    }
}
