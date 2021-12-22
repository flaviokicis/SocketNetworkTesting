package io.github.pennywise.betest.network;

import io.github.pennywise.betest.network.packets.Packet;
import io.github.pennywise.betest.network.packets.PingRequest;
import io.github.pennywise.betest.network.packets.PingResponse;

public class ServerSideHandler extends PacketHandler {

	@Override
	public void handle(Packet packet, ClientSession session) {
		// Received PING_REQUEST, send back PING_RESPONSE
		if (packet instanceof PingRequest) {
			session.send(new PingResponse());
		}
	}

}
