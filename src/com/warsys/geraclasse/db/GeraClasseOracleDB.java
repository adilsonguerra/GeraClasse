package com.warsys.geraclasse.db;

import java.sql.*;
import java.util.*;
//import com.warsys.geraclasse.dao.BaseDAO_JDBC;
import com.warsys.base.BaseDAO_Oracle;
import com.warsys.geraclasse.bean.Registros;

  public class GeraClasseOracleDB extends BaseDAO_Oracle {
  //public class GeraClasseOracleDB extends BaseDAO_JDBC {
 
  public static String ownerDB="GUERRA";
  //public static String ownerDB="LESAP"  
  //public static String ownerDB="DWIND";
  //public static String ownerDB="CHARGEBACK";
  //public static String ownerDB="CONSULTA_DW";
  public static String nomeBanco="Oracle";
  
  
  private final String SELECT_TODAS_TABELAS = "SELECT DISTINCT A.TABLE_NAME as Tabela FROM " + 
	                                           "ALL_TAB_COLUMNS A WHERE A.OWNER = ? ";

  private final String SELECT_CAMPOS = "SELECT A.COLUMN_NAME as Coluna, " +
													"       A.DATA_TYPE as Tipo , " +
											     	"       A.DATA_LENGTH as Tam, " +
													"       nvl(A.DATA_PRECISION,0) as Precisao, " +
													"       DECODE(A.NULLABLE,'Y','N','N','S') as Obrigatorio, " +
	                                    "       'S' Chave " +
													"  FROM ALL_TAB_COLUMNS  A," +
													"       ALL_IND_COLUMNS  X, " +
	  												"       ALL_INDEXES  I " +
													" WHERE A.OWNER = ? and " +
	  											   "       A.OWNER= X.TABLE_OWNER and " +
													"       A.TABLE_NAME = X.TABLE_NAME and " +
													"       A.COLUMN_NAME = X.COLUMN_NAME and "+
													"       A.TABLE_NAME = ? and " +
													"       I.TABLE_NAME = A.TABLE_NAME and " +
													"       I.OWNER=A.OWNER and " +
													"       I.UNIQUENESS = 'UNIQUE' and " +
													"       I.INDEX_NAME =X.INDEX_NAME " +
                                       " UNION ALL "+
													"SELECT A.COLUMN_NAME as Coluna, " +
													"       A.DATA_TYPE as Tipo , " +
													"       A.DATA_LENGTH as Tam, " +
													"       nvl(A.DATA_PRECISION,0) as Precisao, " +
													"       DECODE(A.NULLABLE,'Y','N','N','S') as Obrigatorio, " +
	                                    "       'N' Chave " +
													"  FROM ALL_TAB_COLUMNS A " +
													" WHERE A.OWNER = ? and " +
													"	     A.TABLE_NAME = ? and " +
													"       A.COLUMN_NAME not in (SELECT A.COLUMN_NAME as Coluna " +
													"  FROM ALL_TAB_COLUMNS  A," +
													"       ALL_IND_COLUMNS  X, " +
	  												"       ALL_INDEXES  I " +
													" WHERE A.OWNER = ? and " +
	  											   "       A.OWNER= X.TABLE_OWNER and " +
													"       A.TABLE_NAME = X.TABLE_NAME and " +
													"       A.COLUMN_NAME = X.COLUMN_NAME and "+
													"       A.TABLE_NAME = ? and " +
													"       I.TABLE_NAME = A.TABLE_NAME and " +
													"       I.OWNER=A.OWNER and " +
													"       I.UNIQUENESS = 'UNIQUE' and " +
													"       I.INDEX_NAME =X.INDEX_NAME) ";


  public String [] getTabelas(String cond) throws SQLException {
    Connection conn = null;
    PreparedStatement prepStmt = null;
    ResultSet rs = null;
    
    System.out.println ("owner->"+ownerDB);
    System.out.println ("SQL->"+SELECT_TODAS_TABELAS);
    
    try {
	  Vector vTabelas = new Vector();
	  
      conn = getConnection();
      prepStmt = conn.prepareStatement(SELECT_TODAS_TABELAS);
      prepStmt.setString(1,ownerDB);
      rs = prepStmt.executeQuery();

      while (rs.next()) {
        vTabelas.add(rs.getString(1));
      }
		String[] tabelas = new String[vTabelas.size()];
      vTabelas.copyInto(tabelas);
      return tabelas;
    }

    catch (SQLException e) {
      System.out.println("Throwing SQLException " + e.getMessage());
      throw e;
    }
    finally {
      closeAll(conn, prepStmt, rs);
    }

  }

    public Registros [] getCampos(String tb) throws SQLException {

	 Connection conn = null;
    PreparedStatement prepStmt = null;
    ResultSet rs = null;
    try {
		Vector vCampos = new Vector();
      conn = getConnection();
      prepStmt = conn.prepareStatement(SELECT_CAMPOS);
      prepStmt.setString(1, ownerDB);
		prepStmt.setString(2, tb);
      prepStmt.setString(3, ownerDB);
		prepStmt.setString(4, tb);
      prepStmt.setString(5, ownerDB);
		prepStmt.setString(6, tb);
      rs = prepStmt.executeQuery();

      while (rs.next()) {
		  Registros reg = new Registros(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),"");
		  vCampos.add(reg);
      }

		Registros[] campos = new Registros[vCampos.size()];
      vCampos.copyInto(campos);
      return campos;
    }

    catch (SQLException e) {
      System.out.println("Throwing SQLException " + e.getMessage());
      throw e;
    }
    finally {
      closeAll(conn, prepStmt, rs);
    }

  }
  
  public String getBanco(){
  	return this.nomeBanco;
  }
}
