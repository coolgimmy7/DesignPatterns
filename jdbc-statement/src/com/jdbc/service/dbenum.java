package com.jdbc.service;

public class dbenum {

	private static final String path = "jdbc:mysql://localhost:3306/students"; // path of database(students)
	private static final String user = "root"; // database user-name
	private static final String pass = ""; // database password
	public static final String isconnected = "connected Successfully...."; // connection confirmed message
	public static final String iserror = "connection error...!"; // connection error

	public static String getqueryOpration(querytype type) { // query selection
		System.out.println("Enter table name: ");
		String tableName = Utility.stringInput();
		switch (type) {
		case create:
			return "CREATE TABLE IF NOT EXISTS " + tableName
					+ "(id INTEGER not null, first VARCHAR(100), age INTEGER, PRIMARY KEY (id))";

		case drop:
			return "delete table " + tableName;

		default:
			return "wrong query";
		}

	}

	public static String getdatabaseOpration(database type) { // database operation
		System.out.println("enter dtabase name");
		String dbname = Utility.stringInput();
		switch (type) {
		case create:
			return "CREATE DATABASE IF NOT EXISTS " + dbname;
		case drop:

			return "DROP DATABASE " + dbname;
		default:
			return "wrong choice";
		}
	}

	public static String getPath() {
		return path;
	}

	public static String getUser() {
		return user;
	}

	public static String getPass() {
		return pass;
	}

	public enum querytype {
		create, drop;
	}

	public enum database {
		create, drop;
	}

}