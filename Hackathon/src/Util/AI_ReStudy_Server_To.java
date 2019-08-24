package Util;

import java.io.PrintWriter;
import java.net.Socket;

public class AI_ReStudy_Server_To {

	public static String setReStudy(String fileName) {
		String result = "0";

		try {
			Socket m_Socket = new Socket("127.0.0.1", 6666);

			PrintWriter sendWriter = new PrintWriter(m_Socket.getOutputStream());
			sendWriter.print(fileName);
			sendWriter.flush();

			sendWriter.close();
			m_Socket.close();
		} catch (Exception e) {
			System.out.println("*************************재학습쪽 오류");
		}

		return result;
	}
}
