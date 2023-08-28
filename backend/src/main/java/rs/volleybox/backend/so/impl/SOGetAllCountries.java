/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.volleybox.backend.so.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import rs.volleybox.backend.database.DBBroker;
import rs.volleybox.backend.so.SOClass;
import rs.volleybox.common_lib.domain.Country;
import rs.volleybox.common_lib.enumeration.ServerResponse;
import rs.volleybox.common_lib.transfer.Response;

/**
 *
 * @author HOME
 */
public class SOGetAllCountries extends SOClass {

    @Override
    public Response execute(Object object) throws IOException {
        try {
            List<Country> countries = dbbroker.getAllCountries();
            return new Response(ServerResponse.OK, countries);
        } catch (SQLException ex) {
            return new Response(ServerResponse.ERROR, "Cannot return all countries");
        }
    }

}
