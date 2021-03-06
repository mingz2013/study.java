package com.mingzz.xmpptest05;

import java.io.File;

import org.jivesoftware.smack.*;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smackx.filetransfer.*;

public class XMPPTest05 {
	/**
	 * 传送文件
	 * 必须是“域名和资源名”完全相同的两个用户才可以互发文件，否则永远都没反应，
	 * 一直不能发送呢。。？？？？？？？
	 * */

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		XMPPConnection.DEBUG_ENABLED = true;  
		AccountManager accountManager;  
		final ConnectionConfiguration connectionConfig = new ConnectionConfiguration(  
		        "localhost", Integer.parseInt("5222"), "localhost");  
		  
		// 允许自动连接  
		connectionConfig.setReconnectionAllowed(true);  
		connectionConfig.setSendPresence(true);  
		  
		Connection connection = new XMPPConnection(connectionConfig);  
		try {  
		    connection.connect();// 开启连接  
		    accountManager = connection.getAccountManager();// 获取账户管理类  
		} catch (XMPPException e) {  
		    throw new IllegalStateException(e);  
		}  
		  try {
			connection.login("admin", "admin","Spark");// 必须是“域名和资源名”完全相同的两个用户才可以互发文件，否则永远都没反应，
		} catch (XMPPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
		  Presence pre = connection.getRoster().getPresence("test@localhost");  
		    System.out.println("pre--->" + pre);  
		    if (pre.getType() != Presence.Type.unavailable) {  
		        // 创建文件传输管理器  
		        FileTransferManager manager = new FileTransferManager(connection);  
		        // 创建输出的文件传输  
		        OutgoingFileTransfer transfer = manager  
		                .createOutgoingFileTransfer(pre.getFrom());  
		        // 发送文件  
		        try {
					transfer.sendFile(new File("1.jpg"), "图片");
				} catch (XMPPException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
		        while (!transfer.isDone()) {  
		            if (transfer.getStatus() == FileTransfer.Status.in_progress) {  
		                // 可以调用transfer.getProgress();获得传输的进度　  
		                System.out.println(transfer.getStatus());  
		                System.out.println(transfer.getProgress());  
		                System.out.println(transfer.isDone());  
		            }  
		        }  
		    } 

	}

}
