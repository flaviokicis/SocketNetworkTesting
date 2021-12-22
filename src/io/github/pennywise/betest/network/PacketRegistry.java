package io.github.pennywise.betest.network;

import java.util.HashMap;
import java.util.Map;

import io.github.pennywise.betest.network.packets.Packet;
import io.github.pennywise.betest.network.packets.PingRequest;
import io.github.pennywise.betest.network.packets.PingResponse;

public class PacketRegistry {
	
	private Map<Byte, Class<? extends Packet>> byID = new HashMap<>();
	
	private Map<Class<? extends Packet>, Byte> byPACKET = new HashMap<>();
	
	public PacketRegistry() {
		register(new PingRequest(), 0);
		register(new PingResponse(), 1);
		/* This is the basics...
		 * You can create any packet you want...
		*/
	}
	
	// Registra...
	private void register(Packet packet, int id) {
		byID.put((byte) id, packet.getClass());
		byPACKET.put(packet.getClass(), (byte) id);
	}
	
	public Class<? extends Packet> getPACKET(byte id) {
		return byID.get(id);
	}
	
	public byte getID(Class<? extends Packet> packet) {
		return byPACKET.get(packet);
	}

}
