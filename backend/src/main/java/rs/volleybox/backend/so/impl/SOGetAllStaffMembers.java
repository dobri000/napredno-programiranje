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
import rs.volleybox.common_lib.domain.StaffMember;
import rs.volleybox.common_lib.enumeration.ServerResponse;
import rs.volleybox.common_lib.transfer.Response;

/**
 *
 * @author HOME
 */
public class SOGetAllStaffMembers implements SOInterface {

    @Override
    public Response execute(Object object) throws IOException {
        try {
            List<StaffMember> staffMembers = DBBroker.getInstance().getAllStaffMembers();
            return new Response(ServerResponse.OK, staffMembers);
        } catch (SQLException ex) {
            return new Response(ServerResponse.ERROR, "Cannot return all staff members");
        }
    }

}
