/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.volleybox.backend.so.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import rs.volleybox.backend.database.DBBroker;
import rs.volleybox.backend.so.SOInterface;
import rs.volleybox.common_lib.domain.Hall;
import rs.volleybox.common_lib.enumeration.ServerResponse;
import rs.volleybox.common_lib.transfer.Response;

/**
 *
 * @author HOME
 */
public class SOSearchHalls implements SOInterface {

    @Override
    public Response execute(Object object) throws IOException {
        try {
            String search = (String) object;
            List<Hall> halls = DBBroker.getInstance().findHallsSearch(search);
            return new Response(ServerResponse.OK, halls);
        } catch (SQLException ex) {
            return new Response(ServerResponse.ERROR, "Cannot return halls for by given name");
        }
    }
    
}