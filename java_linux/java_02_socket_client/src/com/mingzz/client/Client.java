package com.mingzz.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.nio.Buffer;
import java.nio.ByteBuffer;


public class Client {
	public void Init(){
		Socket socket;
		ObjectOutputStream objectOutputStream;
		ObjectInputStream objectInputStream;
		/*
		try {
			socket = new Socket("127.0.0.1", 6666);
			objectInputStream = new ObjectInputStream(socket.getInputStream());
			objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
			socket.connect(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("connect wrong....");
			return;
		} 
		*/
		Message message = new Message();
		message.setName("xiaozhang");
		message.setAge(12);
		/*
		try {
			objectOutputStream.writeObject(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		System.out.println("message:" + message);
		System.out.println("message to string:" + message.toString());
		ByteBuffer byteBuffer;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client client = new Client();
		client.Init();

	}

}
