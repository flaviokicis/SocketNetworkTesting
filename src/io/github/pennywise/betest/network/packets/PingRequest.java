package io.github.pennywise.betest.network.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class PingRequest extends Packet {
	
	private long l;

	@Override
	public void read(DataInputStream stream) throws IOException {
		this.l = stream.readLong();
	}

	@Override
	public void write(DataOutputStream stream) throws IOException {
		// The server doesn't send a PING_REQUEST in this case.
	}

}
