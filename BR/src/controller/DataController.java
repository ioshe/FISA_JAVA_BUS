package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DBUtil.Util;
import model.domain.bus_serial;
public class DataController {
	public static ArrayList<bus_serial> bus_select(String start_loc,String end_loc) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<bus_serial> busList = new ArrayList<>();
		
		try {
			conn = Util.getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM bus_serial WHERE start_loc = ? AND end_loc = ? ORDER BY bus_time ASC;");
			pstmt.setString(1, start_loc); //SQL 쿼리의 물음표(?) 위치에 값을 바인딩하여 SQL 문을 실행할 때 해당 위치에 값을 대체
			pstmt.setString(2, end_loc); 
			rs = pstmt.executeQuery();
			while (rs.next()) {
			    busList.add(new bus_serial(
			        rs.getString("bus_serial_num"),
			        rs.getString("start_loc"),
			        rs.getString("end_loc"),
			        rs.getString("bus_time"),
			        rs.getString("bus_type")
			    ));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally { 
			Util.close(conn, pstmt, rs);
		}
		
		return busList;
	}
}
