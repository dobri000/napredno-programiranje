/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.volleybox.backend.so;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;

import rs.volleybox.backend.database.DBBroker;
import rs.volleybox.common_lib.transfer.Response;

/**
 *
 * @author HOME
 */
public abstract class SOClass {
    
	protected DBBroker dbbroker;
	
    public abstract Response execute(Object object) throws IOException;

	public void setDbbroker(DBBroker dbbroker) {
		this.dbbroker = dbbroker;
	}
    
    
    
}
