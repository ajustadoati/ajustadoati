package com.aati.service;

import javax.json.Json;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;
 
public class ChatMessageEncoder implements Encoder.Text<ChatMessage> {
	public void init(final EndpointConfig config) {
	}
 
	public void destroy() {
	}
 
	public String encode(final ChatMessage chatMessage) throws EncodeException {
		return Json.createObjectBuilder()
				.add("message", chatMessage.getMessage())
				.add("sender", chatMessage.getSender())
				.add("received", chatMessage.getReceived().toString()).build()
				.toString();
	}
}