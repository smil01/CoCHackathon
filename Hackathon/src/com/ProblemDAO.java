package com;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

public class ProblemDAO {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	private static ProblemDAO dao;

	public static ProblemDAO getDao() {
		if (dao == null) {
			dao = new ProblemDAO();
		}
		return dao;
	}

	private void getCon() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String user = "hr";
			String password = "hr";

			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void close() {
		try {
			if (rs != null) {
				rs.close();
			}

			if (pst != null) {
				pst.close();
			}

			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean insert(ProblemDTO dto) {
		try {
			getCon();

			String sql = "INSERT INTO problem VALUES(PROBLEM_SEQUENCE.nextval, ?, ?, ?, ?, ?, ?, ?, 0)";

			pst = conn.prepareStatement(sql);

			pst.setString(1, dto.getContent());
			pst.setString(2, dto.getWriter());
			pst.setString(3, dto.getMachine());
			pst.setString(4, dto.getGps());
			pst.setString(5, dto.getAddr());
			pst.setString(6, dto.getTime());
			pst.setString(7, dto.getSrc());

			int cnt = pst.executeUpdate();

			if (cnt > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return false;
	}

	public ArrayList<ProblemDTO> selectAll() {
		ArrayList<ProblemDTO> list = new ArrayList<ProblemDTO>();
		try {
			getCon();

			String sql = "SELECT * FROM problem ORDER BY num DESC";

			pst = conn.prepareStatement(sql);

			rs = pst.executeQuery();

			while (rs.next()) {
				list.add(new ProblemDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list;
	}

	public ProblemDTO select(int num) {
		try {
			getCon();

			String sql = "SELECT * FROM problem WHERE num = ? ORDER BY num DESC";

			pst = conn.prepareStatement(sql);
			pst.setInt(1, num);

			rs = pst.executeQuery();

			if (rs.next()) {
				return new ProblemDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return null;
	}
	
	public boolean update(int num, int state) {
		try {
			getCon();

			String sql = "UPDATE problem SET state = ? WHERE num = ?";

			pst = conn.prepareStatement(sql);

			pst.setInt(1, state);
			pst.setInt(2, num);
			
			int cnt = pst.executeUpdate();

			if (cnt > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return false;
	}

	public int top() {
		ArrayList<ProblemDTO> list = new ArrayList<ProblemDTO>();
		try {
			getCon();

			String sql = "SELECT num FROM problem ORDER BY num DESC";

			pst = conn.prepareStatement(sql);

			rs = pst.executeQuery();

			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return 0;
	}
}
