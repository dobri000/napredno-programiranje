package rs.volleybox.backend.so.impl;

import java.io.IOException;
import java.sql.SQLException;

import com.fasterxml.jackson.core.type.TypeReference;

import rs.volleybox.backend.database.DBBroker;
import rs.volleybox.backend.so.SOClass;
import rs.volleybox.common_lib.domain.Team;
import rs.volleybox.common_lib.enumeration.ServerResponse;
import rs.volleybox.common_lib.transfer.Response;
import rs.volleybox.common_lib.utils.JsonSerializationUtils;

/**
 * This class represents a system operation for deleting a team from the database.
 * The team to be deleted is specified in the input object, and the system operation
 * handles the process of removing the team from the database using the provided DBBroker.
 *
 * @author Dimitrije
 */
public class SODeleteTeam extends SOClass {

    /**
     * Executes the system operation to delete a team from the database.
     *
     * @param object The input object specifying the team to be deleted.
     * @return A {@link Response} indicating the result of the operation.
     *         If the team is successfully deleted, the response will have status {@link ServerResponse#OK}.
     *         If an error occurs during the database operation, the response will have status {@link ServerResponse#ERROR}
     *         and the error message will provide more information.
     * @throws IOException If there is an issue with input/output during JSON conversion.
     */
    @Override
    public Response execute(Object object) throws IOException {
        try {
            Team team = JsonSerializationUtils.convertValue(object, new TypeReference<Team>() {
            });
            dbbroker.deleteTeam(team);
            return new Response(ServerResponse.OK, null);
        } catch (SQLException ex) {
            return new Response(ServerResponse.ERROR, "Team not successfully deleted");
        }
    }

}
