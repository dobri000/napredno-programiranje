/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.volleybox.backend.so.impl;

import java.io.IOException;
import java.sql.SQLException;

import rs.volleybox.backend.database.DBBroker;
import rs.volleybox.backend.so.SOInterface;
import rs.volleybox.common_lib.domain.Admin;
import rs.volleybox.common_lib.enumeration.ServerResponse;
import rs.volleybox.common_lib.transfer.Response;

/**
 *
 * @author HOME
 */
public class SOLogin implements SOInterface {

    @Override
    public Response execute(Object object) throws IOException {
        try {
            Admin admin = (Admin) object;
            String success = DBBroker.getInstance().login(admin);
            if(success.equals("Correct credentials")){
                return new Response(ServerResponse.OK, success);
            } else {
                return new Response(ServerResponse.ERROR, success);
            }
            
        } catch (SQLException ex) {
            return new Response(ServerResponse.ERROR, "Cannot login");
        }
    }
    
    
    
}
