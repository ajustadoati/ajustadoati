package com.aati.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
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

@ServerEndpoint(value="/openfire")
public class OFEndpoint {
	private final Logger log = Logger.getLogger(getClass().getName());
	private Connection connection;
	public OFEndpoint(){
		this.connection=new XMPPConnection("ajustadoati.com");
		
		try{
			log.info("conectando a server openfire");
			this.connection.connect();
			this.connection.login("admin@ajustadoati.com", "Dexter876.");
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
            user=user+"@ajustadoati.com";
            log.info("User: "+user);
           
            Chat newChat = chatmanager.createChat(user, new MessageListener() {   			
    		    public void processMessage(Chat chat, Message message) {
    		    	
    		    	log.info("Received message: " + message.getBody());
    		    	String arr[]=message.getFrom().split("@");
    		    	String from=arr[0];
    		    	Response response= new Response(from, message.getBody());
    		    	log.info("Received from: " + from);
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
