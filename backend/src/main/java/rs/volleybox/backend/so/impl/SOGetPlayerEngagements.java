package rs.volleybox.backend.so.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import rs.volleybox.backend.database.DBBroker;
import rs.volleybox.backend.so.SOClass;
import rs.volleybox.common_lib.domain.Player;
import rs.volleybox.common_lib.domain.PlayerEngagement;
import rs.volleybox.common_lib.enumeration.ServerResponse;
import rs.volleybox.common_lib.transfer.Response;
import rs.volleybox.common_lib.utils.JsonSerializationUtils;

/**
 * This class represents a system operation for retrieving a list of player engagements from the database.
 * The system operation handles the process of fetching the engagements associated with a specific player using the provided DBBroker.
 *
 * @author Dimitrije
 */
public class SOGetPlayerEngagements extends SOClass {

    /**
     * Executes the system operation to retrieve a list of player engagements associated with a specific player.
     *
     * @param object The player object for which to retrieve engagements.
     * @return A {@link Response} containing the list of {@link PlayerEngagement} objects retrieved from the database.
     *         If the operation is successful, the response will have status {@link ServerResponse#OK} and the list of engagements.
     *         If an error occurs during the database operation, the response will have status {@link ServerResponse#ERROR}
     *         and the error message will provide more information.
     * @throws IOException If there is an issue with input/output during JSON conversion.
     */
    @Override
    public Response execute(Object object) throws IOException {
        try {
            Player player = JsonSerializationUtils.convertValue(object, new TypeReference<Player>() {});
            List<PlayerEngagement> engagements = dbbroker.getPlayerEngagements(player);
            return new Response(ServerResponse.OK, engagements);
        } catch (SQLException ex) {
            return new Response(ServerResponse.ERROR, "Cannot return player engagements");
        }
    }

}
