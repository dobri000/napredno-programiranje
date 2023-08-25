/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.volleybox.backend.so.impl;

import java.io.IOException;
import java.sql.SQLException;

import rs.volleybox.backend.database.DBBroker;
import rs.volleybox.backend.so.SOInterface;
import rs.volleybox.common_lib.domain.Team;
import rs.volleybox.common_lib.enumeration.ServerResponse;
import rs.volleybox.common_lib.transfer.Response;

/**
 *
 * @author HOME
 */
public class SOUpdateTeam implements SOInterface {

    @Override
    public Response execute(Object object) throws IOException {
        try {
            Team team = (Team) object;
            DBBroker.getInstance().updateTeam(team);
            return new Response(ServerResponse.OK, null);
        } catch (SQLException ex) {
            return new Response(ServerResponse.ERROR, "Cannot update team");
        }
    }
    
}