/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.volleybox.backend.so.impl;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import rs.volleybox.backend.database.DBBroker;
import rs.volleybox.backend.so.SOInterface;
import rs.volleybox.common_lib.domain.Player;
import rs.volleybox.common_lib.enumeration.ServerResponse;
import rs.volleybox.common_lib.transfer.Response;



/**
 *
 * @author HOME
 */
public class SOAddPlayer implements SOInterface {

    @Override
    public Response execute(Object object) throws IOException {
        try {
            Player player = (Player) object;
            DBBroker.getInstance().addPlayer(player);
            return new Response(ServerResponse.OK, null);
        } catch (SQLException ex) {
            return new Response(ServerResponse.ERROR, "Player not successfully added");
        }
    }

}
