package io.github.pennywise.betest.network;

import io.github.pennywise.betest.network.packets.Packet;

public abstract class PacketHandler {
	
	// Receive a packet
	
	public abstract void handle(Packet packet, ClientSession session);
	

}
