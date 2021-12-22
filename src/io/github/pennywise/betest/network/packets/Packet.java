package io.github.pennywise.betest.network.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import io.github.pennywise.betest.main.API;

public abstract class Packet {
	
    private int priority = 0;
    
    public void setPriority(int priority) {
    	this.priority = priority;
    }
    
    public int getPriority() {
    	return this.priority;
    }
	
	public abstract void read(DataInputStream stream) throws IOException;
	
	public abstract void write(DataOutputStream stream) throws IOException;
	
    public byte ID() {
    	return API.getId(this);
    }

}
