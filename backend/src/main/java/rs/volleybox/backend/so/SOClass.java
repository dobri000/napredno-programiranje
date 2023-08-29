package rs.volleybox.backend.so;

import java.io.IOException;
import java.sql.SQLException;

import rs.volleybox.backend.database.DBBroker;
import rs.volleybox.common_lib.transfer.Response;

/**
 * Abstract class defining the basic structure for all system operation classes.
 *
 * All concrete classes that inherit from this class must implement the execute method,
 * which represents the execution of a specific system operation.
 *
 * Additionally, this class allows setting instances of the DBBroker to be used
 * in the execution of system operations.
 *
 * @author HOME
 */
public abstract class SOClass {

	/**
	 * Reference to the DBBroker instance to be used during system operation execution.
	 */
	protected DBBroker dbbroker;

	/**
	 * Abstract method defining the execution of a specific system operation.
	 *
	 * @param object The object used for executing the operation.
	 * @return The result of the operation execution as a Response object.
	 * @throws IOException In case of communication errors.
	 */
	public abstract Response execute(Object object) throws IOException;

	/**
	 * Sets the DBBroker instance to be used during system operation execution.
	 *
	 * @param dbbroker A reference to the DBBroker instance.
	 */
	public void setDbbroker(DBBroker dbbroker) {
		this.dbbroker = dbbroker;
	}
}
