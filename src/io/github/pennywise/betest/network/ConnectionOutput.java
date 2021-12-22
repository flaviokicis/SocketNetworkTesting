package io.github.pennywise.betest.network;

import java.io.DataOutputStream;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

import io.github.pennywise.betest.network.packets.Packet;

public class ConnectionOutput {
	
	private ClientSession session;
	
	private DataOutputStream stream;
	
	private Thread thread;
	
	private BlockingQueue<Packet> queue = new PriorityBlockingQueue<>();
	
	public ConnectionOutput(ClientSession session, DataOutputStream stream) {
		this.session = session;
		this.stream = stream;
		this.thread = new ConnectionOutputSender();
		this.thread.start();
	}
	
	public void kill() {
		this.thread.stop();
	}
	
	public ClientSession getSession() {
		return this.session;
	}
	
	private class ConnectionOutputSender extends Thread {
		
		public void run() {
			try {
			Packet packet = queue.poll();
			stream.writeByte(packet.ID());
			packet.write(stream);
			} catch (Exception ex) {
				// Exceptions here are not important at all
			}
		}
		
	}
	
	// Add in the packet queue
	public void send(Packet packet, int priority) {
		packet.setPriority(priority);
		this.queue.add(packet);
	}
	
	// Same thing
	public void send(Packet packet) {
		this.queue.add(packet);
	}

}
