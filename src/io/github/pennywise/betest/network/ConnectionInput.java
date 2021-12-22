package io.github.pennywise.betest.network;

import java.io.DataInputStream;

import io.github.pennywise.betest.main.API;
import io.github.pennywise.betest.network.packets.Packet;

public class ConnectionInput {
	
	private DataInputStream stream;
	
	private Thread thread;
	
	private ClientSession client;
	
	public ConnectionInput(ClientSession client, DataInputStream stream) {
		this.client = client;
		this.stream = stream;
		this.thread = new ConnectionInputListener();
		this.thread.start();
	}
	
	public void kill() {
		this.thread.stop();
	}
	
	public ClientSession getSession() {
		return client;
	}
	
	private class ConnectionInputListener extends Thread {
		
		public void run() {
			while (true) {
				try {
				byte id = stream.readByte();
				Packet packet = API.getNewPacketForID(id);
				packet.read(stream);
				client.receive(packet);
				// Received the packets
				} catch (Exception ex) {
					// Exceptions are not important here...
				}
			}
		}
		
	}

}
