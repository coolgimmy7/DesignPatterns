package com.jdbc.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

import com.jdbc.reporsitory.connection;
import com.jdbc.service.Utility;
import com.jdbc.service.dbenum;

public class databasedemo {
	static Savepoint save = null;

	public static void main(String[] args) throws SQLException {

		Connection con = connection.getJdbcConnection();
		Statement stmt = con.createStatement(); // creating statement
		int ch;
		do {
			System.out.println("*****welcome to database*****");
			System.out.println("1.Database creation\n2.Database deletion\n3.Create table\n4.Delete table\n5.Exit");
			System.out.println("please enter your choice: ");
			ch = Utility.integerInput();
			switch (ch) {
			case 1:
				stmt.execute(dbenum.getdatabaseOpration(dbenum.database.create)); // creating new database
				System.out.println("Database created");
				break;
			case 2:
				stmt.execute(dbenum.getdatabaseOpration(dbenum.database.drop)); // create new// table
				System.out.println(" database drop");
				break;
			case 3:
				stmt.execute(dbenum.getqueryOpration(dbenum.querytype.create)); // create new table
				System.out.println(" Table created");
				break;

			case 4:
				stmt.execute(dbenum.getqueryOpration(dbenum.querytype.drop)); // delete table
				System.out.println(" Table deleted");
				break;

			case 5:
				System.out.println("Bye....!");
				break;

			default:
				System.out.println("invalid choice!!");
				break;
			}
		} while (ch != 5);

	}

}