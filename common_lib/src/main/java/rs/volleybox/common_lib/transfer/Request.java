package rs.volleybox.common_lib.transfer;

import rs.volleybox.common_lib.enumeration.Operation;
import java.io.Serializable;

/**
 * Represents a request to perform an operation on an object. This class contains an operation type and an object on which the operation should be performed.
 * Used for communication between client and server components.
 *
 * @author HOME
 */
public class Request implements Serializable {

    /**
     * The type of operation to be performed.
     */
    private Operation operation;

    /**
     * The object on which the operation should be performed.
     */
    private Object object;

    /**
     * Creates an empty Request object.
     */
    public Request() {

    }

    /**
     * Creates a Request object with the specified operation and object.
     *
     * @param operation The operation type to be performed.
     * @param object The object on which the operation should be performed.
     */
    public Request(Operation operation, Object object) {
        this.operation = operation;
        this.object = object;
    }

    /**
     * Retrieves the operation type of the request.
     *
     * @return The operation type.
     */
    public Operation getOperation() {
        return operation;
    }

    /**
     * Sets the operation type of the request.
     *
     * @param operation The operation type to set.
     */
    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    /**
     * Retrieves the object associated with the request.
     *
     * @return The object associated with the request.
     */
    public Object getObject() {
        return object;
    }

    /**
     * Sets the object associated with the request.
     *
     * @param object The object to set.
     */
    public void setObject(Object object) {
        this.object = object;
    }
}
