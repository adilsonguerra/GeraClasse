
package com.warsys.geraclasse.db;

import java.sql.*;
import java.util.*;
//import java.util.StringTokenizer.*;
import com.warsys.base.BaseDAO_PGSQL;
import com.warsys.geraclasse.bean.Registros;

public class GeraClassePgsqlDB extends BaseDAO_PGSQL {
	
  //Variavel usada para montar os arquivos gerados automaticamente
  public static String nomeBanco="PGSQL";
  
  private final String SELECT_TODAS_TABELAS = "SELECT tablename as Tabela FROM " + 
  	                                           "pg_tables Where tableowner = 'postgres' and schemaname='public'";
 

  //private final String SELECT_CAMPOS = "select * from Def_TbUsuario " ;
  //private final String SELECT_CAMPOS = "select * from Def_TbUsuAparelho " ;
  //private final String SELECT_CAMPOS = "select * from Def_TbAparelho " ;
  
  //private final String SELECT_CAMPOS = "SELECT c.column_name, c.data_type,c.ordinal_position, c.numeric_precision, c.is_nullable, c.is_identity,c.udt_name FROM information_schema.columns c WHERE table_name = ? ";

  private final String SELECT_CAMPOS =  " select  a.attname coluna,t.typname tipo, " + 
                                        " case when t.typname='date' then 10 " + 
                                        "     when t.typname='int4' then 10 " +
                                        "     when t.typname='int8' then 20 " +
                                        "     when t.typname='float8' then 20 " +
                                        "     when t.typname='text' then 100 " +
                                        "     when t.typname='numeric' then 20 " +
                                        " else a.atttypmod-4 end tam, " + 
                                        " case when t.typname='date' then 0 " + 
                                        "     when t.typname='int4' then 0 " +
                                        "     when t.typname='int8' then 0 " +
                                        "     when t.typname='float8' then 0 " +
                                        "     when t.typname='numeric' then 2 " +
                                        "     when t.typname='text' then 0 " + 
                                        "     when t.typname='bpchar' then 0 " +
                                        "     when t.typname='varchar' then 0 end precisao, " +
                                        " case when a.attnotnull is true then 'S' else 'N' end obrigatorio, " +
                                        " case when k.chave_pk is null then 'N' else 'S' end chave " +
                                        " from pg_attribute a " +
                                        " JOIN pg_class AS c ON c.oid=a.attrelid " +
                                        " JOIN pg_type AS t ON t.oid=a.atttypid " +
                                        " LEFT JOIN (SELECT a.attname chave_pk, c.relname tab FROM pg_class c " +
                                        "      INNER JOIN pg_attribute a ON (c.oid = a.attrelid) " +
                                        "      INNER JOIN pg_index i ON (c.oid = i.indrelid) " +
                                        "      WHERE " +
                                        "      i.indkey[0] = a.attnum AND " +
                                        "      i.indisprimary = 't' ) as k on k.tab = c.relname and k.chave_pk= a.attname " +
                                        " where c.relname = ? " +
                                        " and a.attstattarget =-1 " ;
  
  public String[] getTabelas(String cond) throws SQLException {
    Connection conn = null;
    PreparedStatement prepStmt = null;
    ResultSet rs = null;
    try {
	  Vector vTabelas = new Vector();
      conn = getConnection();
      prepStmt = conn.prepareStatement(SELECT_TODAS_TABELAS);
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
		prepStmt.setString(1, tb);
		System.out.println("Entrou no get campos=>"+SELECT_CAMPOS + " " + tb);
      rs = prepStmt.executeQuery();
		
		while (rs.next()) {	
		 Registros reg = new Registros(rs. getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),"");
		  vCampos.add(reg);
		}
		 
		Registros [] campos = new Registros[vCampos.size()];
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

/*   // String ownr = "DWBUC";
	//String ownr = "ACTDES";
	System.out.println("Entrou no get campos");
	 int i =0;
	 Connection conn = null;
    PreparedStatement prepStmt = null;
    ResultSet rs = null;
	 try {
		Vector vCampos = new Vector();
      conn = getConnection();
		//while (i>=0){
		//	System.out.println("Entrou no while");
			prepStmt = conn.prepareStatement(SELECT_CAMPOS);
		//	System.out.println("leu a SELECT_CAMPOS="+SELECT_CAMPOS);
			//prepStmt.setString(1, tb);
		//	System.out.println("leu a tb="+tb);
			//prepStmt.setString(2, ""+i );
		//	System.out.println("Vai executar a query");
			rs = prepStmt.executeQuery();
			System.out.println("Excetutou a query!->" + rs.getString(1));
			
			if(rs.getString(1).trim()!=""){
				System.out.println("Entrou no if->"+ rs.getString(1));
				
				StringTokenizer st = new StringTokenizer(rs.getString(1),",");

				//Cria um array para acomodar os colunas que serão estraidas da linha
				String[] campo= new String[st.countTokens()];

				for(int j=0;st.hasMoreTokens();i++){
					campo[j]=st.nextToken();
				}				
				
				Registros reg = new Registros(campo[0],campo[1],campo[2],campo[3],campo[4],campo[5],"");
				System.out.println("adicionou ao registro");
				vCampos.add(reg);
				i++;
			}else{
			  System.out.println("Entrou no Else");
				i=-1;
			}//if 
      //}//while
      System.out.println("Saiu do while");
		Registros[] campos = new Registros[vCampos.size()];
      vCampos.copyInto(campos);
		return campos;
    }//try

    catch (SQLException e) {
      System.out.println("Throwing SQLException " + e.getMessage());
      throw e;
    }//catch
    finally {
      closeAll(conn, prepStmt, rs);
    }//finally
  }
}*/

