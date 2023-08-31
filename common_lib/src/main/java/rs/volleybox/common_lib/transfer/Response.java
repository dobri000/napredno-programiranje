package rs.volleybox.common_lib.transfer;

import rs.volleybox.common_lib.enumeration.ServerResponse;
import java.io.Serializable;

/**
 * Represents a response sent from the server to the client.
 * Contains information about the server response and an associated object.
 *
 * @author Dimitrije
 */
public class Response implements Serializable{

    /**
     * The server response status.
     */
    private ServerResponse serverResponse;

    /**
     * The object associated with the response.
     */
    private Object object;

    /**
     * Creates a Response object with the specified server response and associated object.
     *
     * @param serverResponse The server response status.
     * @param object The object associated with the response.
     */
    public Response(ServerResponse serverResponse, Object object) {
        this.serverResponse = serverResponse;
        this.object = object;
    }

    /**
     * Default constructor.
     */
    public Response() {
    }

    /**
     * Gets the server response status.
     *
     * @return The server response status.
     */
    public ServerResponse getServerResponse() {
        return serverResponse;
    }

    /**
     * Sets the server response status.
     *
     * @param serverResponse The server response status to set.
     */
    public void setServerResponse(ServerResponse serverResponse) {
        this.serverResponse = serverResponse;
    }

    /**
     * Gets the object associated with the response.
     *
     * @return The associated object.
     */
    public Object getObject() {
        return object;
    }

    /**
     * Sets the object associated with the response.
     *
     * @param object The object to associate with the response.
     */
    public void setObject(Object object) {
        this.object = object;
    }

}
