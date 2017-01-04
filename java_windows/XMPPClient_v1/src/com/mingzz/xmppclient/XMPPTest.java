package com.mingzz.xmppclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.ChatManagerListener;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.Roster;
import org.jivesoftware.smack.RosterEntry;
import org.jivesoftware.smack.RosterGroup;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;

public class XMPPTest {
	public final static String DEFAULT_DOMAIN = "localhost";
	public final static int DEFAULT_PORT = 5222;
	private String domain;
	private int port;
	private XMPPConnection connection ;
	private Roster roster; 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		XMPPTest xmppTest = new XMPPTest();
		xmppTest.Init();

	}// main
	public void Init(){
		System.out.println("*****************************XMPPClient************************************");
		System.out.println("...........................................................................");
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		while(true){
			domain = null;
			port = 0;
			System.out.print("Server domain:");
			try {
				domain = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print("Server port:");
			try {
				port = Integer.parseInt(reader.readLine());
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print("write again?(Y/N):");
			String strAgain = null;
			try {
				strAgain = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(strAgain.equals("Y") || strAgain.equals("y")) continue;
			
			if(domain == null){
				domain = DEFAULT_DOMAIN;
				System.out.println("use default domain: " + domain);
			}else{System.out.println("use domain: " + domain);}
			if(port == 0){
				port = DEFAULT_PORT;
				System.out.println("use default port: " + port);
			}else{System.out.println("use port: " + port);}
			System.out.println("try to connection...");
			try {
				connection = XMPPClient.getConnection(domain, port);
			} catch (XMPPException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Invalid port or domain specification; please write again!");
				continue;
			}
			break;
		}// while
		
		Start();
		connection.disconnect();// 断开连接
	}// Init
	private void Start(){
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		int cmd ;
		System.out.println("connect to server by " + domain + ":" + port);
		System.out.println(".....................................................");
		while(true){
			cmd = -1;
			System.out.println("............................CMD LIST....................");
			System.out.println("1.Register");
			System.out.println("2.Login");
			System.out.println("3.Exit");
			System.out.print("write the number of CMD:");
			try {
				cmd = Integer.parseInt(reader.readLine());
			} catch (Exception e) {
				System.out.println("Invalid CMD");
				continue;
			}
			switch (cmd) {
			case 1:
				Register();
				//System.out.println("this part is not open, try others");
				continue;
			case 2:
				Login();
				//System.out.println("this part is not open, try others");
				continue;
			case 3:
				System.out.println("System exit!");
				break;
			default:
				System.out.println("Invalid CMD");
				continue;
			}// switch
		}// while
	}// start
	private void Register(){
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		String regUserName;
		String regUserPwd;
		String regUserPwd2;
		System.out.println(".....................................................");
		System.out.println("............................Register.................");
		while(true){
			regUserName = null;
			regUserPwd = null;
			regUserPwd2 = null;
			System.out.print("register username:");
			try {
				regUserName = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print("register password:");
			try {
				regUserPwd = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print("register password again:");
			try {
				regUserPwd2 = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print("write again?(Y/N):");
			String strAgain = null;
			try {
				strAgain = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(strAgain.equals("Y") || strAgain.equals("y")) continue;
			if(regUserName == null){
				System.out.println("username is null");
				break;
			}
			if(!regUserPwd.equals(regUserPwd2)){
				System.out.println("password1 is not equal password2");
				break;
			}
			System.out.println("try to register...");
			boolean isSuccess = XMPPClient.createAccount(connection, regUserName, regUserPwd);
			if(isSuccess){
				System.out.println("register success! ");
				System.out.println("new user: " + regUserName);
			}else{
				System.out.println("register wrong");
			}
			break;
		}// while
		
	}// Register
	private void Login(){
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		String UserName;
		String UserPwd;
		System.out.println(".....................................................");
		System.out.println("............................Login....................");
		while(true){
			UserName = null;
			UserPwd = null;
			System.out.print("login username:");
			try {
				UserName = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print("login password:");
			try {
				UserPwd = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print("write again?(Y/N):");
			String strAgain = null;
			try {
				strAgain = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(strAgain.equals("Y") || strAgain.equals("y")) continue;
			if(UserName == null){
				System.out.println("username is null");
				break;
			}
			System.out.println("try to login...");
			boolean isSuccess = XMPPClient.Login(connection, UserName, UserPwd);
			if(!isSuccess){
				System.out.println("Login wrong");
				break;
			}
			System.out.println("login success! ");
			//System.out.println("login user: " + UserName);
			// 获取roster
			roster = XMPPClient.getRoster(connection);
			// 绑定chatmessagelistener
			XMPPClient.addChatManagerListener(connection, new ChatManagerListener() {
				
				@Override
				public void chatCreated(Chat arg0, boolean arg1) {
					// TODO Auto-generated method stub
					  //若是聊天窗口已存在，将消息转往目前窗口  
                    //若是窗口不存在，开新的窗口并注册  
				}
			});
			User(UserName);
			break;
		}// while
	}// Login
	private void User(String UserName){
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		int cmd ;
		System.out.println(".....................................................");
		System.out.println(".............Login.user:." + UserName + "................");
		System.out.println(".....................................................");
		while(true){
			cmd = -1;
			System.out.println("............................CMD.LIST....................");
			System.out.println("1.getGroups");
			System.out.println("2.getEntriesByGroup");
			System.out.println("3.getAllEntries");
			System.out.println("4.Chat");
			System.out.println("5.addUser");
			System.out.println("6.removeUser");
			System.out.println("7.addGroup");
			System.out.println("8.removeGroup");
			System.out.println("9.searchUsers");
			System.out.println("10.deleteAccount");
			System.out.println("11.Logout");
			
			System.out.print("write the number of CMD:");
			try {
				cmd = Integer.parseInt(reader.readLine());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Invalid CMD");
				continue;
			}
			switch (cmd) {
			case 1:
				GetGroups();
				//System.out.println("this part is not open, try others");
				continue;
			case 2:
				GetEntriesByGroup();
				//System.out.println("this part is not open, try others");
				continue;
			case 3:
				System.out.println("this part is not open, try others");
				continue;
			case 4:
				Chat();
				//System.out.println("this part is not open, try others");
				continue;
			case 5:
				System.out.println("this part is not open, try others");
				continue;
			case 6:
				System.out.println("this part is not open, try others");
				continue;
			case 7:
				System.out.println("this part is not open, try others");
				continue;
			case 8:
				System.out.println("this part is not open, try others");
				continue;
			case 9:
				System.out.println("this part is not open, try others");
				continue;
			case 10:
				System.out.println("this part is not open, try others");
				continue;
			case 11:
				System.out.println("this part is not open, try others");
				continue;
			default:
				System.out.println("Invalid CMD");
				continue;
			}// switch
		}// while
		
	}// User
	private void GetGroups(){
		List<RosterGroup> groupsList = XMPPClient.getGroups(roster);
		System.out.println("Group Total: " + groupsList.size());
		Iterator<RosterGroup> i = groupsList.iterator();
		int num = 1;
        while (i.hasNext()){  
            System.out.println(num + " . " + i.next().getName());
            num++;
        }
	}//GetGroups
	private void GetEntriesByGroup(){
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("write the Group you want to get:");
		String groupName;
		try {
			groupName = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		List<RosterEntry> EntriesList = XMPPClient.getEntriesByGroup(roster, groupName);
		System.out.println("Entry Total: " + EntriesList.size());
		Iterator<RosterEntry> i = EntriesList.iterator();  
		int num = 1;
        while (i.hasNext()){  
            System.out.println(num + " . " + i.next().getName());
            num++;
        } 
	        
	}//GetEntriesByGroup
	private void Chat(){
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("who you want to chat:");
		String userName = null;
		try {
			userName = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		//  建立一个会话
		Chat newChat = XMPPClient.ceateChat(connection, userName,  new MessageListener() {
			
			@Override
			public void processMessage(Chat arg0, Message arg1) {
				// TODO Auto-generated method stub
				if (arg1 != null && arg1.getBody() != null)  
                {  
                    System.out.println("from " + arg0.getParticipant() + ":" + arg1.getBody());  
                    // 可以在这进行针对这个用户消息的处理，但是这里我没做操作，看后边聊天窗口的控制  
                }  
			}
		}); 
		System.out.println("..............................................................");
		System.out.println("..............Chating.with." + userName + "...................");
		System.out.println(".............':ZZZ'.to.quit.chat..............................");
		Scanner input = new Scanner(System.in);  
		String message = null;
		while (true) {  
		    message = input.nextLine();
		    if(":ZZZ".equals(message)) break;
		    try {
				XMPPClient.sendMessage(newChat, message);
			} catch (XMPPException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}  // while
	}	// Chat
	
	
	

}//XMPPTest
