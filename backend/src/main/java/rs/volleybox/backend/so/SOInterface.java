/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.volleybox.backend.so;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import rs.volleybox.common_lib.transfer.Response;

/**
 *
 * @author HOME
 */
public interface SOInterface {
    
    public Response execute(Object object) throws IOException;
    
}
