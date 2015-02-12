package org.usfirst.frc3620;
import java.io.*;
import java.math.BigInteger;
import java.net.*;
import java.util.*;


import com.google.gson.Gson;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
 
public class UDPReciever extends Thread {
	public static String lastDataReceived = "";
	public static VisionData visionData;
	Gson gson = new Gson();
	
    protected DatagramSocket socket = null;
    protected BufferedReader in = null;
    protected boolean moreQuotes = true;
    public UDPReciever() throws IOException {
    this("udpReciever");
    }
 
    public UDPReciever(String name) throws IOException {
        super(name);
        socket = new DatagramSocket(3620);
    }
    
    public void run() {
    	System.out.println("thread start");
    	byte[] buf = new byte[256];
    	 DatagramPacket packet = new DatagramPacket(buf, buf.length);
        while (moreQuotes) {
            try {
 
                // receive request
            	packet.setLength(buf.length);
                socket.receive(packet);
                byte[] data = packet.getData();
                lastDataReceived = new String(data, 0, packet.getLength());
                //SmartDashboard.putString("last Data Received", lastDataReceived);
                System.out.println ("'" + lastDataReceived + "'");
                // figure out response
                visionData = gson.fromJson(lastDataReceived, VisionData.class);
                visionData.whenRecieved = System.currentTimeMillis();
        		System.out.println(visionData);
            } catch (IOException e) {
                e.printStackTrace();
        moreQuotes = false;
            }
        }
        socket.close();
    }
    
    public String toHex(String arg) {
        return String.format("%040x", new BigInteger(1, arg.getBytes()));
    }
 
}