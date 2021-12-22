package io.github.pennywise.betest.main;

import io.github.pennywise.betest.network.ClientManager;
import io.github.pennywise.betest.network.PacketHandler;
import io.github.pennywise.betest.network.PacketRegistry;
import io.github.pennywise.betest.network.packets.Packet;

public class API {
	
	// This is an API.
	
	private static MasterServer defaultServer;
	
    static void setDefaultServer(MasterServer server) {
    	API.defaultServer = server;
    }
    
    public static PacketRegistry getRegistry() {
    	return defaultServer.getRegistry();
    }
    
    public static byte getId(Packet packet) {
    	return getRegistry().getID(packet.getClass());
    }
    
    public static Packet getNewPacketForID(byte id) {
        try {
        	Class<? extends Packet> packet = getRegistry().getPACKET(id);
        	return packet.newInstance();
        } catch (Exception ex) {
        	System.out.println("We tried to create a new class with the ID =" + id + ", although the error " + ex.getClass().getSimpleName() + " has been trown.");
        	return null;
        }
    }
    
    public static PacketHandler getHandler() {
    	return defaultServer.getPacketHandler();
    }
    
    public static ClientManager getClientManager() {
    	return defaultServer.getClientManager();
    }

}
