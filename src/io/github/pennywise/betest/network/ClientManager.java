package io.github.pennywise.betest.network;

import java.util.HashSet;

public class ClientManager {
	
	private final HashSet<ClientSession> clientsConnected = new HashSet<>();
	
	public void addClient(ClientSession client) {
		this.clientsConnected.add(client);
	}
	
	public void remClient(ClientSession client) {
		this.clientsConnected.remove(client);
	}
	
	public boolean isConnected(ClientSession client) {
		return this.clientsConnected.contains(client);
	}
	
	public ClientSession[] getSession() {
		return new HashSet<>(clientsConnected).toArray(new ClientSession[0]);
	}
	
	public void closeAll() {
		for (ClientSession session : clientsConnected) {
			session.kill();
		}
	}

}
