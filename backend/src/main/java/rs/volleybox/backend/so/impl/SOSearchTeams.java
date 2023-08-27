/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.volleybox.backend.so.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import rs.volleybox.backend.database.DBBroker;
import rs.volleybox.backend.so.SOClass;
import rs.volleybox.common_lib.domain.Team;
import rs.volleybox.common_lib.enumeration.ServerResponse;
import rs.volleybox.common_lib.transfer.Response;
import rs.volleybox.common_lib.utils.JsonSerializationUtils;

/**
 *
 * @author HOME
 */
public class SOSearchTeams extends SOClass {

    @Override
    public Response execute(Object object) throws IOException {
        try {
            String search = JsonSerializationUtils.convertValue(object, new TypeReference<String>() {
			});
            List<Team> teams = dbbroker.searchTeam(search);
            return new Response(ServerResponse.OK, teams);
        } catch (SQLException ex) {
            return new Response(ServerResponse.ERROR, "Cannot return teams for by given name");
        }
    }
    
    
    
}
