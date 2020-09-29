package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Faculty;
import com.util.DatabaseUtil;

public class EmpFaDao {
	
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	public ArrayList<Faculty> searchfac(String name){
		ArrayList<Faculty> fac = new ArrayList<>();
		con = DatabaseUtil.getConnection();
		try {
			String query ="select F.EMPID,A.ASSNAME,F.STREAMNAME from FACULTY_1437686 F,ASSOICATE_1437686 A where F.EMPNAME=?";
			pst = con.prepareStatement(query);
			pst.setString(1, name);
			rs=pst.executeQuery();
			while(rs.next()){
				int empid = rs.getInt(2);
				String ename = rs.getString(3);
				String estream = rs.getString(4);
				
				Faculty f = new Faculty();
				f.setEmpID(empid);
				f.setEmpName(ename);
				f.setStreamName(estream);
				
				fac.add(f);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DatabaseUtil.closeConnection(con);
			DatabaseUtil.closeStatement(pst);
		}
		return fac;
		
	}

}
