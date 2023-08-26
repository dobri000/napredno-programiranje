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
import rs.volleybox.backend.so.SOInterface;
import rs.volleybox.common_lib.domain.Player;
import rs.volleybox.common_lib.domain.StaffMember;
import rs.volleybox.common_lib.domain.StaffMemberEngagement;
import rs.volleybox.common_lib.enumeration.ServerResponse;
import rs.volleybox.common_lib.transfer.Response;
import rs.volleybox.common_lib.utils.JsonSerializationUtils;

/**
 *
 * @author HOME
 */
public class SOGetStaffMemberEngagements implements SOInterface {

    @Override
    public Response execute(Object object) throws IOException {
        try {
            StaffMember staff = JsonSerializationUtils.convertValue(object, new TypeReference<StaffMember>() {
			});
            List<StaffMemberEngagement> engagements = DBBroker.getInstance().getStaffMemberEngagements(staff);
            return new Response(ServerResponse.OK, engagements);
        } catch (SQLException ex) {
            return new Response(ServerResponse.ERROR, "Cannot return staff member engagements");
        }
    }

}
