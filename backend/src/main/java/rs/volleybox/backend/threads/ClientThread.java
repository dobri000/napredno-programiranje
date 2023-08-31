/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.volleybox.backend.threads;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.core.type.TypeReference;

import rs.volleybox.backend.database.DBBroker;
import rs.volleybox.backend.server.Server;
import rs.volleybox.backend.so.SOClass;
import rs.volleybox.backend.so.impl.SOAddHall;
import rs.volleybox.backend.so.impl.SOAddPlayer;
import rs.volleybox.backend.so.impl.SOAddPlayerEngagement;
import rs.volleybox.backend.so.impl.SOAddStaffMember;
import rs.volleybox.backend.so.impl.SOAddStaffMemberEngagement;
import rs.volleybox.backend.so.impl.SOAddTeam;
import rs.volleybox.backend.so.impl.SODeletePlayer;
import rs.volleybox.backend.so.impl.SODeletePlayerEngagement;
import rs.volleybox.backend.so.impl.SODeleteStaffMember;
import rs.volleybox.backend.so.impl.SODeleteStaffMemberEngagement;
import rs.volleybox.backend.so.impl.SODeleteTeam;
import rs.volleybox.backend.so.impl.SOGetAllCountries;
import rs.volleybox.backend.so.impl.SOGetAllHalls;
import rs.volleybox.backend.so.impl.SOGetAllPlayers;
import rs.volleybox.backend.so.impl.SOGetAllSeasons;
import rs.volleybox.backend.so.impl.SOGetAllStaffMembers;
import rs.volleybox.backend.so.impl.SOGetAllTeams;
import rs.volleybox.backend.so.impl.SOGetPlayerEngagements;
import rs.volleybox.backend.so.impl.SOGetPlayerEngagementsOfTeam;
import rs.volleybox.backend.so.impl.SOGetStaffMemberEngagements;
import rs.volleybox.backend.so.impl.SOGetStaffMemberEngagementsOfTeam;
import rs.volleybox.backend.so.impl.SOLogin;
import rs.volleybox.backend.so.impl.SOLogout;
import rs.volleybox.backend.so.impl.SOQuit;
import rs.volleybox.backend.so.impl.SOSearchHalls;
import rs.volleybox.backend.so.impl.SOSearchPlayers;
import rs.volleybox.backend.so.impl.SOSearchStaffMembers;
import rs.volleybox.backend.so.impl.SOSearchTeams;
import rs.volleybox.backend.so.impl.SOUpdatePlayer;
import rs.volleybox.backend.so.impl.SOUpdateStaffMember;
import rs.volleybox.backend.so.impl.SOUpdateTeam;
import rs.volleybox.common_lib.transfer.Request;
import rs.volleybox.common_lib.transfer.Response;
import rs.volleybox.common_lib.utils.JsonSerializationUtils;
import rs.volleybox.common_lib.enumeration.Operation;

/**
 *
 * @author Dimitrije
 */
public class ClientThread extends Thread {

    private Socket socket;
    private boolean status = true;
    private ObjectInputStream in;
    private ObjectOutputStream out;

    public ClientThread(Socket socket) throws IOException {
        this.socket = socket;
        out = new ObjectOutputStream(socket.getOutputStream());
        in = new ObjectInputStream(socket.getInputStream());
    }

    @Override
    public void run() {
        while (status) {
            try {
            	String jsonRequest = (String) in.readObject();
            	System.out.println(jsonRequest);
                Request request = JsonSerializationUtils.deserializeFromJson(jsonRequest, new TypeReference<Request>() {
				});
                Operation operation = request.getOperation();
                SOClass so = null;
                switch (operation) {
                    case LOGIN:
                        so = new SOLogin();
                        break;
                    case GET_ALL_COUNTRIES:
                        so = new SOGetAllCountries();
                        break;
                    case ADD_PLAYER:
                        so = new SOAddPlayer();
                        break;
                    case ADD_TEAM:
                        so = new SOAddTeam();
                        break;
                    case DELETE_TEAM:
                        so = new SODeleteTeam();
                        break;
                    case SEARCH_HALLS:
                        so = new SOSearchHalls();
                        break;
                    case SEARCH_PLAYERS:
                        so = new SOSearchPlayers();
                        break;
                    case UPDATE_PLAYER:
                        so = new SOUpdatePlayer();
                        break;
                    case ADD_HALL:
                        so = new SOAddHall();
                        break;
                    case SEARCH_TEAMS:
                        so = new SOSearchTeams();
                        break;
                    case GET_ALL_PLAYERS:
                        so = new SOGetAllPlayers();
                        break;
                    case GET_ALL_TEAMS:
                        so = new SOGetAllTeams();
                        break;
                    case ADD_PLAYER_ENGAGEMENT:
                        so = new SOAddPlayerEngagement();
                        break;
                    case GET_ALL_SEASONS:
                        so = new SOGetAllSeasons();
                        break;
                    case GET_PLAYER_ENGAGEMENTS:
                        so = new SOGetPlayerEngagements();
                        break;
                    case DELETE_PLAYER_ENGAGEMENT:
                        so = new SODeletePlayerEngagement();
                        break;
                    case GET_PLAYER_ENGAGEMENTS_OF_TEAM:
                        so = new SOGetPlayerEngagementsOfTeam();
                        break;
                    case ADD_STAFF_MEMBER:
                        so = new SOAddStaffMember();
                        break;
                    case UPDATE_STAFF_MEMBER:
                        so = new SOUpdateStaffMember();
                        break;
                    case DELETE_STAFF_MEMBER_ENGAGEMENT:
                        so = new SODeleteStaffMemberEngagement();
                        break;
                    case GET_STAFF_MEMBER_ENGAGEMENTS:
                        so = new SOGetStaffMemberEngagements();
                        break;
                    case ADD_STAFF_MEMBER_ENGAGEMENT:
                        so = new SOAddStaffMemberEngagement();
                        break;
                    case GET_ALL_STAFF_MEMBERS:
                        so = new SOGetAllStaffMembers();
                        break;
                    case SEARCH_STAFF_MEMBERS:
                        so = new SOSearchStaffMembers();
                        break;
                    case GET_STAFF_MEMBER_ENGAGEMENTS_OF_TEAM:
                        so = new SOGetStaffMemberEngagementsOfTeam();
                        break;
                    case GET_ALL_HALLS:
                        so = new SOGetAllHalls();
                        break;
                    case DELETE_PLAYER:
                        so = new SODeletePlayer();
                        break;
                    case DELETE_STAFF_MEMBER:
                        so = new SODeleteStaffMember();
                        break;
                    case UPDATE_TEAM:
                        so = new SOUpdateTeam();
                        break;
                    case LOGOUT:
                        so = new SOLogout();
                        break;
                    case QUIT:
                        so = new SOQuit();
                        status = false;
                        terminate();
                        break;
                }
                so.setDbbroker(DBBroker.getInstance());
                Response response = so.execute(request.getObject());
                if(status) {
                	String jsonResponse = JsonSerializationUtils.serializeToJson(response, new TypeReference<Response>() {
					});
                    System.out.println(jsonResponse);
                	out.writeObject(jsonResponse);
                }
                    
            } catch (IOException ex) {
                status = false;
                terminate();
                interrupt();
                Server.removeClient(this);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void terminate() {
        try {
            in.close();
            out.close();
            socket.close();
            Server.removeClient(this);
        } catch (IOException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void serverStop() {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
