package com.warsys.base;

import java.sql.*;

public class BaseDAO_Oracle {
  private static String DRIVER = "oracle.jdbc.driver.OracleDriver";
  
  
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
	 //Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@10.202.25.69:9145:C3D1", "MKT_VENDAS", "cgdes04");
	 //Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@10.202.25.69:9145:C2D1", "DWBUC", "cgdes04");
     //Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@127.0.0.1:1521:XE","LESAP", "LESAP");
     Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@127.0.0.1:1521:XE","guerra", "guerra");
    //Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@10.145.0.132:1527:C2P1", "DWBUC", "aspr01o225");//Oracle
	 //Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@172.16.1.136:9145:C4P2", "ACTDES", "actdes");
	 // Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@172.16.1.136:9145:C4H2", "chargeback", "cghom02");//Oracle
   //Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@10.145.0.132:1527:C2P1", "DWBUC", "aspr01o135");//Oracle
   //Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@10.145.0.132:1527:C2P1", "DWIND", "aspr01o90");//Oracle
   //Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@10.145.0.132:1527:C2P1", "CONSULTA_DW", "cgprod02");//Oracle   
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
