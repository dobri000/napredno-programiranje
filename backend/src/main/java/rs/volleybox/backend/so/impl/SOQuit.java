/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.volleybox.backend.so.impl;

import java.io.IOException;

import com.fasterxml.jackson.core.type.TypeReference;

import rs.volleybox.backend.database.DBBroker;
import rs.volleybox.backend.so.SOClass;
import rs.volleybox.common_lib.domain.Admin;
import rs.volleybox.common_lib.domain.Player;
import rs.volleybox.common_lib.transfer.Response;
import rs.volleybox.common_lib.utils.JsonSerializationUtils;

/**
 *
 * @author HOME
 */
public class SOQuit extends SOClass {

    @Override
    public Response execute(Object object) throws IOException {
        Admin admin = JsonSerializationUtils.convertValue(object, new TypeReference<Admin>() {
		});
        dbbroker.logout(admin);
        return null;
    }
    
    
    
}
