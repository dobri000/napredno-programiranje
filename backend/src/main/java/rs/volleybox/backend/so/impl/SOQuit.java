/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.volleybox.backend.so.impl;

import java.io.IOException;

import rs.volleybox.backend.database.DBBroker;
import rs.volleybox.backend.so.SOInterface;
import rs.volleybox.common_lib.domain.Admin;
import rs.volleybox.common_lib.transfer.Response;

/**
 *
 * @author HOME
 */
public class SOQuit implements SOInterface {

    @Override
    public Response execute(Object object) throws IOException {
        Admin admin = (Admin) object;
        DBBroker.getInstance().logout(admin);
        return null;
    }
    
    
    
}