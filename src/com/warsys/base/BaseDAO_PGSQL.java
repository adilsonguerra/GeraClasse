package com.warsys.base;

import java.sql.*;

public class BaseDAO_PGSQL {
  private static String DRIVER = "org.postgresql.Driver";    

  // Loading database driver
  private static boolean driverOk = false;

  static{
    loadDriver(DRIVER);
  }


  public void isDriverOk() throws SQLException {
    if (!driverOk)
      throw new SQLException("Driver nao carregado");
  }

  public Connection getConnection() throws SQLException {
    isDriverOk();
	//Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@10.202.25.42:9145:C3D1", "MKT_VENDAS", "cgdes03"); //Oracle
	//Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@10.202.25.42:9145:C2H1", "DWBUC", "cghom04");		//Oracle
	//Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@172.16.1.136:9145:C4P2", "ACTDES", "actdes");		//Oracle
	// Connection conn = DriverManager.getConnection("jdbc:odbc:CAPEXT","","");															//Access
    //Connection conn = DriverManager.getConnection("jdbc:odbc:chargeback","","");	
    // Connection conn = DriverManager.getConnection("jdbc:odbc:Lesap_OraXE","lesap","lesap");//Access
     Connection conn = DriverManager.getConnection("jdbc:postgresql:postgres", "postgres","ad1lson01");
   return conn;
  } // end getConnection

  
  private static void loadDriver(String driver) {
    try {
      System.out.println("Carregamento do driver :");
      Class.forName(DRIVER);
      System.out.println(DRIVER);
      driverOk = true;
    }
    catch (ClassNotFoundException e) {
      System.out.println("--------------------------");
      e.printStackTrace();
      System.out.println("--------------------------");
      driverOk = false;
    } // end catch
  } // end loadDriver

  public static void closeAll(Connection conn) {
    try {
      if (conn != null) {
        conn.close();
      }
    }
    catch (SQLException e) {
      System.out.println(e);
    }

  }

  public static void closeAll(Connection conn, Statement st) {
    try {
      if (st != null) {
        st.close();
      }
      if (conn != null) {
        conn.close();
      }
    }
    catch (SQLException e) {
      System.out.println(e);
    }

  }

  public static void closeAll(Connection conn, Statement st, ResultSet rs) {
    try {
      if (rs != null) {
        rs.close();
      }
      if (st != null) {
        st.close();
      }
      if (conn != null) {
        conn.close();
      }
    }
    catch (SQLException e) {
      System.out.println(e);
    }

  }
}
