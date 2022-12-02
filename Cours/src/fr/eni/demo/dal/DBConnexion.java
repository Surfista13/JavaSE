package fr.eni.demo.dal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnexion {

	//declaration des constantes
	//********* avant *********
	//private static final String URL="jdbc:sqlserver://localhost:1433;databaseName=Ecole";
	//private static final String URL="jdbc:sqlserver://localhost:1433;databaseName=Ecole;"
	//		+ "integratedSecurity=false;encrypt=false;trustServerCertificate=false";
	//private static final String USER="sa";
	//private static final String PWD = "Pa$$w0rd";

	
	
	
	public static Connection seConnecter() throws SQLException {
		Connection cnx = null;
		String url,user,pwd;

		url = Settings.getProperty("URL");
		user = Settings.getProperty("USER");
		pwd = Settings.getProperty("PWD");

		cnx=DriverManager.getConnection(url,user,pwd);
		return cnx;
	}
	
	public static void seDeconnecter(Connection cnx) throws SQLException {
		if (cnx != null) {
			cnx.close();
		}
	}
	
	public static void seDeconnecter(Statement stmt,Connection cnx) throws SQLException {
		if (stmt != null) {
			stmt.close();
		}
		seDeconnecter(cnx);
	}
	
	public static void seDeconnecter(PreparedStatement pstmt,Connection cnx) throws SQLException {
		if (pstmt != null) {
			pstmt.close();
		}
		seDeconnecter(cnx);
	}

	public static void seDeconnecter(CallableStatement callStmt,Connection cnx) throws SQLException {
		if (callStmt != null) {
			callStmt.close();
		}
		seDeconnecter(cnx);
	}
}
