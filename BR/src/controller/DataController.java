package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import DBUtil.Util;
import model.domain.bus_serial;
import model.domain.customer;
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
	
	public static String rev_insert(String bus_serial_num) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = Util.getConnection();
			
			pstmt = conn.prepareStatement("insert into  reservation (bus_serial_num) values (?)");
//			pstmt.setInt(1, reservation_ID);
			pstmt.setString(1, bus_serial_num);
			
			int result = pstmt.executeUpdate();
			
			if(result == 1) {
				return "저장 성공";
			}	
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally { 
			Util.close(conn, pstmt);
		}
		
		return "저장 실패";
	}
	
	public static int rev_select(String bus_serial_num) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int rev_serial = 0 ;
		
		try {
			conn = Util.getConnection();
			pstmt = conn.prepareStatement("SELECT reservation_ID FROM bus.reservation WHERE bus_serial_num = ? ;");
			pstmt.setString(1, bus_serial_num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				rev_serial = rs.getInt("reservation_ID");
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		} finally { 
			Util.close(conn, pstmt, rs);
		}
		
		return rev_serial;
	}
	
	public static String cus_insert(String name, int age, int price,int rev_id) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = Util.getConnection();
			Statement pppp = conn.createStatement();
			
			//ResultSet result1 = pppp.executeQuery("select reservation.reservation_ID from reservation, customer where reservation.reservation_ID = customer.reservation_ID");
			
//			while(result1.next()) {
//				a1 = result1.getInt("reservation_ID");
//				System.out.println(a1);
//			}
			
			pstmt = conn.prepareStatement("insert into customer values (?, ?, ?, ?)");
			
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setInt(3, price);
			pstmt.setInt(4, rev_id);
			
			int result = pstmt.executeUpdate();
			
			if(result == 1) {
				return "저장 성공";
			}	
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(conn, pstmt);
		}
		
		return "저장 실패";
	}
	
	public static ArrayList<customer> cus_select(int rev_id) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<customer> cusList = new ArrayList<>();
		
		try {
			conn = Util.getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM bus.customer WHERE reservation_ID = ?;");
			pstmt.setInt(1, rev_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
			    cusList.add(new customer(
			        rs.getString("name"),
			        rs.getInt("age"),
			        rs.getInt("price"),
			        rs.getInt("reservation_ID")
			    ));
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		} finally { 
			Util.close(conn, pstmt, rs);
		}
		
		return cusList;
	}
}


