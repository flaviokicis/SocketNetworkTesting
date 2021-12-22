package io.github.pennywise.betest.network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

import io.github.pennywise.betest.network.packets.Packet;

public class ClientSession {
	
	private InetAddress address;
	
	private Socket socket;
	
	private PacketHandler handler;
	
	private ConnectionInput conInput;
	
	private ConnectionOutput conOutput;
	
	public ClientSession(Socket socket) throws IOException {
		this.address = socket.getInetAddress();
		this.conInput = new ConnectionInput(this, new DataInputStream(socket.getInputStream()));
		this.conOutput = new ConnectionOutput(this, new DataOutputStream(socket.getOutputStream()));
		this.handler = new ServerSideHandler();
	}
	
	public void receive(Packet packet) {
		this.handler.handle(packet, this);
	}
	
	public void send(Packet packet, int priority) {
		this.conOutput.send(packet, priority);
	}
	
	public void send(Packet packet) {
		this.conOutput.send(packet);
	}
	
	public void kill() {
		this.conInput.kill();
		this.conOutput.kill();
		try {
			this.socket.close();
		} catch (IOException e) {
			System.out.println("Error closing the client > " + address.getHostAddress() + ".");
			e.printStackTrace();
		}
	}

}
