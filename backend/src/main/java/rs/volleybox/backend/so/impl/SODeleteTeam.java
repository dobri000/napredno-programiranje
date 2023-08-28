/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.volleybox.backend.so.impl;

import java.io.IOException;
import java.sql.SQLException;

import com.fasterxml.jackson.core.type.TypeReference;

import rs.volleybox.backend.database.DBBroker;
import rs.volleybox.backend.so.SOClass;
import rs.volleybox.common_lib.domain.Player;
import rs.volleybox.common_lib.domain.Team;
import rs.volleybox.common_lib.enumeration.ServerResponse;
import rs.volleybox.common_lib.transfer.Response;
import rs.volleybox.common_lib.utils.JsonSerializationUtils;

/**
 *
 * @author HOME
 */
public class SODeleteTeam extends SOClass {

    @Override
    public Response execute(Object object) throws IOException{
        try {
            Team team = JsonSerializationUtils.convertValue(object, new TypeReference<Team>() {
			});
            dbbroker.deleteTeam(team);
            return new Response(ServerResponse.OK, null);
        } catch (SQLException ex) {
            return new Response(ServerResponse.ERROR, "Team not successfully deleted");
        }
    }
}
