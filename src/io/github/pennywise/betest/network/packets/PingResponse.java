package io.github.pennywise.betest.network.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class PingResponse extends Packet {

	@Override
	public void read(DataInputStream stream) throws IOException {
		// The client doesn't send a PING_RESPONSE in this case.
	}

	@Override
	public void write(DataOutputStream stream) throws IOException {
		stream.writeLong(System.currentTimeMillis());
		// Send the time in millisseconds
	}
	
	

}
