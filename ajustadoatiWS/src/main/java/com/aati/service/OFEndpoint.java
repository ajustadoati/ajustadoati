package com.aati.service;

import java.io.IOException;
import java.util.logging.Logger;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.ChatManager;
import org.jivesoftware.smack.Connection;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;

import com.aati.model.Mensaje;
import com.aati.model.Response;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@ServerEndpoint(value="/openfire")
public class OFEndpoint {
	private final Logger log = Logger.getLogger(getClass().getName());
	private Connection connection;
	public OFEndpoint(){
		this.connection=new XMPPConnection("ajustadoati.sytes.net");
		
		try{
			log.info("conectando a server openfire");
			this.connection.connect();
			this.connection.login("admin@ajustadoati.sytes.net", "Dexter876.");
			log.info("Conectado");
		}catch(XMPPException e){
			System.out.println("Error Conectando "+e.getMessage());
		}
	}
	
	@OnOpen
	public void open(final Session session) {
		
		
		log.info("Abriendo Websocket"+session);
			
		//session.getUserProperties().put("room", se);
		
		
		
	}
	@OnMessage
	public void message(String mensaje, final Session session) throws IOException{
		log.info("recibiendo mensaje: "+ mensaje);
		ChatManager chatmanager = this.connection.getChatManager();
		log.info("enviando mensaje");
		try{
		JSONObject obj = new JSONObject(mensaje);
		Mensaje msj= new Mensaje();
		msj.setMensaje(obj.getString("mensaje"));
		msj.setUsers(obj.getString("users"));	
		String[] result = msj.getUsers().split("&&");
		
		
		//Se recorre la lista de usuarios
		
        for(String user : result){
        	log.info(">"+user+"<");
            user=user+"@ajustadoati.sytes.net";
            log.info("User: "+user);
           
            Chat newChat = chatmanager.createChat(user, new MessageListener() {   			
    		    public void processMessage(Chat chat, Message message) {
    		    	
    		    	log.info("Received message: " + message.getBody());
    		    	String arr[]=message.getFrom().split("@");
    		    	String from=arr[0];
    		    	Client client = Client.create();

        			WebResource webResource = client
        			   .resource("http://ajustadoati.com:9000/ajustadoati/usuario/"+from);

        			ClientResponse resp = webResource.accept("application/json")
        	                   .get(ClientResponse.class);

        			if (resp.getStatus() != 200) {
        			   throw new RuntimeException("Failed : HTTP error code : "
        				+ resp.getStatus());
        			}

        			String output = resp.getEntity(String.class);
        			JSONObject obj=null;
        			Response response=null;
					try {
						obj = new JSONObject(output);
						log.info("response:"+ obj);
						log.info("latitud: "+obj.getDouble("latitud"));
						response = new Response(from, message.getBody(), obj.getDouble("latitud"), obj.getDouble("longitud"));
	    		    	
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        			
        			
    		    	log.info("Received from: " + response.getLatitud());
    		    	Gson gson = new Gson();
    		         String json = gson.toJson(response); 
    		    	try {
						session.getBasicRemote().sendText(json);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
    		    	
    		    	
    		    }
    		});
    		try {
    		    newChat.sendMessage(msj.getMensaje());
    		}catch (XMPPException e) {
    			log.info("Error Delivering block");
    		}
    	
        }
		} catch (JSONException e) {
            e.printStackTrace();
        }
		
		/*	for (Session peer : peers){
			System.out.println("UN PEER CONTIENE: "+ peer);
			peer.getBasicRemote().sendText(message);
		}*/
		
	}
	
	@OnClose
	public void onClose(Session session){
		try {
			log.info("Cerrando websocket");
			this.connection.disconnect();
			session.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
