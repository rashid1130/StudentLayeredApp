package com.nt.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.bo.*;
public class StudentDAO {
private static final String querys="INSERT INTO STD_PCS VALUES(S1.NEXTVAL,?,?,?,?,?)";


	//helper method
	/*private Connection getPooledJdbcConnection() throws Exception {
		InitialContext ic=null;
		DataSource ds=null;
		Connection con=null;
		//Create Initial Object
		ic=new InitialContext();
		//get DataSource Object
		ds=(DataSource) ic.lookup("java:/comp/env/DsJndi");
		// get Pooled Jdbc Connection
		con=ds.getConnection();
		return con;


	}*/


	public int insert(StudentBO bo) throws Exception{
		PreparedStatement ps=null;
		Connection con=null;
		int count=0;
		
		/*get Pooled JDBC Connection Object
		con=getPooledJdbcConnection();*/
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Create Connection Object
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","System","khan");
		
		
		
		//create Prepared Statement Object
		ps=con.prepareStatement(querys);
		//set value to query param
		ps.setString(1,bo.getName());
		ps.setString(2,bo.getCourse());
		ps.setFloat(3,bo.getTotal_marks());
		ps.setFloat(4,bo.getAvg_marks());
		ps.setString(5,bo.getGrade());
		count=ps.executeUpdate();

		return count;

	}


}
