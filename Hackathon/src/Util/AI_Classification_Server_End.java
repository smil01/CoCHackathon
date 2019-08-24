package Util;

import java.io.PrintWriter;
import java.net.Socket;

public class AI_Classification_Server_End {

	public static void main(String[] args) {
		try {
			Socket m_Socket = new Socket("127.0.0.1", 5555);
			
			PrintWriter sendWriter = new PrintWriter(m_Socket.getOutputStream());
			sendWriter.print("end");
			sendWriter.flush();
			
			sendWriter.close();
			m_Socket.close();
			
			System.out.println("AI Classification" + "서버 종료됨");
		} catch (Exception e) {
			System.out.println("AI Classification" + "이미 종료됨");
		}
	}

}
