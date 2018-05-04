package com.revature.main;

import java.util.List;

import com.revature.dao.BearDao;
import com.revature.dao.BearDaoImpl;
import com.revature.dao.CaveDao;
import com.revature.dao.CaveDaoImpl;
import com.revature.domain.Cave;

public class Driver {

	public static void main(String[] args) {
		
		/*	
		try {
			Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");
			System.out.println(con.toString());
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		
		CaveDao cd = new CaveDaoImpl();
		
		List<Cave> caves = cd.getCaves();
		
		for (Cave c : caves) {
			System.out.println(c.toString());
		}
		
		Cave c = cd.getCaveById(2);
		System.out.println(c.toString());
		
		BearDao bd = new BearDaoImpl();
		
		int amtFed = bd.feedBear(10, 1, 5);

		System.out.println(amtFed);
	}

}
