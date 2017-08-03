package com.warsys.geraclasse.classes;

import com.warsys.geraclasse.bean.Registros;
import javax.swing.*;

public class GeraArqDB {
		
		boolean geracao_ok = false;
			
		public GeraArqDB(String nomeClasse,String nomeEmpSist,String tabelaSelecionada,Registros[] regConvertido){
		
	   String tabela = tabelaSelecionada;//ls.getSelectedItem();
		String aux = "";
		String aux2 = "";
		int j = 0;
		
		System.out.println("Inicio da geração... GeraArqDB");
		
		try{
			
			java.text.SimpleDateFormat dfcnv = new java.text.SimpleDateFormat("dd/MM/yyyy"); 
			java.util.Date dateNow =new java.util.Date();
			String hoje =dfcnv.format(dateNow);
	
			Arquivo a = new Arquivo(GeraClasse.nomeBean);
			a.criar(nomeClasse);
			//Inicio da classe
			a.escrever("package com.warsys."+nomeEmpSist+".db;",0);
			
			a.escrever("",0);
			a.escrever("import java.sql.*;",0);
			a.escrever("import java.util.*;",0);
			a.escrever("import com.warsys."+nomeEmpSist+".dao."+GeraClasse.nomeDAO+";",0);
			a.escrever("import com.warsys."+nomeEmpSist+".bean."+GeraClasse.nomeBean+";",0);
			a.escrever("import com.warsys.base.BaseDAO_"+ GeraClasse.nomeBanco +";",0);
			a.escrever("import com.warsys.util.TrataChrEspecial;",0);
			a.escrever("",0);
	
			a.escrever("public class "+GeraClasse.nomeDB+" extends BaseDAO_"+GeraClasse.nomeBanco+" implements " + GeraClasse.nomeDAO + "{",0);
			a.escrever("",0);
			a.escrever("/*******************************/",0);
			a.escrever("/*Autor: Adilson Guerra        */",0);
			a.escrever("/*Data :"+hoje+"             */",0);
			a.escrever("/*******************************/",0);
			a.escrever("",0);
	
			a.escrever("private final String TODOS_REGISTROS = "+ '\"' + " SELECT "+'\"'+"+",0);
	                                  
			for(int i=0;i<regConvertido.length;i++){
				if(i==regConvertido.length -1){
					a.escrever("                                       " + '\"'+"      "+regConvertido[i].getColuna() + " "+'\"'+"+",0);
				}else{
					a.escrever("                                       " + '\"'+"      "+regConvertido[i].getColuna() + ","+'\"'+"+",0);
				}
			}
			a.escrever("                                       " + '\"'+" FROM "+ tabela +'\"'+";",0);
			a.escrever("",0);
	
			a.escrever("private final String REGISTRO_ID = "+ '\"' + " SELECT "+'\"'+"+",0);
	                                  
			for(int i=0;i<regConvertido.length;i++){
				if(i==regConvertido.length -1){
					a.escrever("                                       " + '\"'+"      "+regConvertido[i].getColuna() + " "+'\"'+"+",0);
				}else{
					a.escrever("                                       " + '\"'+"      "+regConvertido[i].getColuna() + ","+'\"'+"+",0);
				}
			}
			a.escrever("                                       " + '\"'+"  FROM "+ tabela +'\"'+"+ ",0);
			a.escrever("                                       " + '\"'+" WHERE "+'\"'+"+ ",0);
			for(int i=0;i<regConvertido.length;i++){
				if(regConvertido[i].getChave().equals("S")){
						if(aux !=""){
							a.escrever(aux,0);	
						}
						aux = "                             				" + '\"'+"       "+ regConvertido[i].getColuna() + "= ? AND "+'\"'+" + ";			
				}
			}
			
			
			if(aux ==""){
				 JOptionPane.showMessageDialog(null, "Arquivo DB"+ GeraClasse.nomeBean +" NÃO foi gerado com sucesso! A tabela pode estar sem Primary Key OU não há coluna selecionada.(Clique em Selecionar todos)", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
            }else{
				 a.escrever(aux.substring(1,aux.length()-8) + '\"'+";",0);
	        }
	        
			a.escrever("",0);
	
			a.escrever("private final String EXCLUIR_REGISTRO = "+ '\"'+" DELETE FROM "+ tabela +'\"'+"+",0);
			a.escrever("                                       " + '\"'+" WHERE "+'\"'+"+ ",0);
			aux = "";
			for(int i=0;i<regConvertido.length;i++){
				if(regConvertido[i].getChave().equals("S")){
						if(aux !=""){
							a.escrever(aux,0);	
						}
						aux = "                             				" + '\"'+"       "+ regConvertido[i].getColuna() + "= ? AND "+'\"'+" + ";			
				}
			}
			a.escrever(aux.substring(1,aux.length()-8) + '\"'+";",0);
			a.escrever("",0);
	
			a.escrever("private final String INSERE_REGISTRO = "+ '\"' + " INSERT INTO "+ tabela + " (" + '\"'+"+",0);
	                                  
			for(int i=0;i<regConvertido.length;i++){
				if(i==regConvertido.length -1){
					a.escrever("                                       " + '\"'+"      "+regConvertido[i].getColuna() + ") "+'\"'+"+",0);
				}else{
					a.escrever("                                       " + '\"'+"      "+regConvertido[i].getColuna() + ","+'\"'+"+",0);
				}
			}
			a.escrever("                                       " + '\"'+"  VALUES (",1);
	
				for(int i=0;i<regConvertido.length;i++){
					if(i==regConvertido.length -1){
						a.escrever("?)" + '\"'+";",0);
					}else{
						a.escrever("?,",1);
					}
				}
	
			a.escrever("",0);
			a.escrever("private final String ATUALIZA_REGISTRO = "+ '\"' + " UPDATE "+ tabela +" SET "+'\"'+"+",0);
	                                  
			for(int i=0;i<regConvertido.length;i++){
				if(i==regConvertido.length -1){
					a.escrever("                                       " + '\"'+"      "+regConvertido[i].getColuna() + " = ? "+'\"'+"+",0);
				}else{
					a.escrever("                                       " + '\"'+"      "+regConvertido[i].getColuna() + " = ?,"+'\"'+"+",0);
				}
			}
			a.escrever("                                       " + '\"'+" WHERE "+'\"'+"+ ",0);
			aux="";
			for(int i=0;i<regConvertido.length;i++){
				if(regConvertido[i].getChave().equals("S")){
						if(aux !=""){
							a.escrever(aux,0);	
						}
						aux = "                             				" + '\"'+"       "+ regConvertido[i].getColuna() + "= ? AND "+'\"' +"+";			
				}
			}
			a.escrever(aux.substring(1,aux.length()-7) +'\"'+";",0);
	
			a.escrever("",0);
			a.escrever("public void insere("+ GeraClasse.nomeBean +" b) throws SQLException {",0);
			a.escrever("",0);
			a.escrever("   TrataChrEspecial tce=new TrataChrEspecial();",0);
			a.escrever("   Connection conn = null;",0);
			a.escrever("   ResultSet rs = null;",0);
			a.escrever("   PreparedStatement prepStmt = null;",0);
			a.escrever("   try {",0);
			a.escrever("      conn = getConnection();",0);
			a.escrever("      prepStmt = conn.prepareStatement(INSERE_REGISTRO);",0);
	
			for(int i=0;i<regConvertido.length;i++){
				if(regConvertido[i].getTipo()=="String"){	
					a.escrever("      prepStmt.set"+GeraClasse.ctipo(regConvertido[i].getTipo())+"("+ (i+1) +", tce.trataTodos(b.get"+plm(regConvertido[i].getColuna())+"()));",0);
			   }else{
					a.escrever("      prepStmt.set"+GeraClasse.ctipo(regConvertido[i].getTipo())+"("+ (i+1) +", b.get"+plm(regConvertido[i].getColuna())+"());",0);
				}
			}
			a.escrever("      prepStmt.execute();",0);
			a.escrever("   }",0);
			a.escrever("   catch (SQLException e) {",0);
			a.escrever("      System.out.println("+'\"'+"Throwing SQLException" +'\"'+"+  e.getMessage());",0);
			a.escrever("      throw e;",0);
			a.escrever("   }",0);
			a.escrever("   finally {",0);
			a.escrever("      closeAll(conn, prepStmt, rs);",0);
			a.escrever("   }",0);
		    a.escrever("}",0);
			a.escrever("",0);
	
	        a.escrever("//Obtém um array de beans",0);
		    a.escrever("public "+ GeraClasse.nomeBean +"[] get"+ GeraClasse.nomeBean +"s() throws SQLException {",0);
			a.escrever(" Connection conn = null;",0);
			a.escrever(" Statement stmt = null;",0);
			a.escrever(" ResultSet rs = null;",0);
	
			a.escrever(" try {",0);
			a.escrever("	Vector v"+ GeraClasse.nomeBean +"s = new Vector();",0);
			a.escrever("	conn = getConnection();",0);
			a.escrever("	stmt = conn.createStatement();",0);
			a.escrever("	rs = stmt.executeQuery(TODOS_REGISTROS);",0);
	
			a.escrever("	while (rs.next()) {",0);
	
			for(int i=0;i<regConvertido.length;i++){
					a.escrever("	  "+regConvertido[i].getTipo()+" "+ regConvertido[i].getColuna() +"= rs.get"+GeraClasse.ctipo(regConvertido[i].getTipo())+"("+'\"'+regConvertido[i].getColuna()+'\"'+");",0);
			}		
						
			a.escrever("	  "+GeraClasse.nomeBean+" b = new "+GeraClasse.nomeBean+"(",1);
			for(int i=0;i<regConvertido.length;i++){
				
				if(i==regConvertido.length -1){
					a.escrever(regConvertido[i].getColuna()+");",0);
				}else{
					a.escrever(regConvertido[i].getColuna()+",",1);
				}		
			}		
	
			a.escrever("	  v"+GeraClasse.nomeBean+"s.add(b);",0);
			a.escrever("	}",0);
			a.escrever("	"+GeraClasse.nomeBean+" "+GeraClasse.plmi(GeraClasse.nomeBean)+"s[] = new "+GeraClasse.nomeBean+"[v"+GeraClasse.nomeBean+"s.size()];",0);
			a.escrever("	v"+GeraClasse.nomeBean+"s.copyInto("+GeraClasse.plmi(GeraClasse.nomeBean)+"s);",0);
			a.escrever("	return "+GeraClasse.plmi(GeraClasse.nomeBean)+"s;",0);
			a.escrever(" }",0);
			a.escrever(" catch (SQLException e) {",0);
			a.escrever("   System.out.println("+'\"'+"Throwing SQLException" +'\"'+"+ e.getMessage());",0);
			a.escrever("	throw e;",0);
			a.escrever(" }",0);
			a.escrever(" finally {",0);
			a.escrever("	closeAll(conn, stmt, rs);",0);
			a.escrever(" }",0);
		    a.escrever("}",0);
	
	        a.escrever("",0);
			a.escrever("//Deleta o bean",0);
			a.escrever("public void excluir("+GeraClasse.nomeBean+" b) throws SQLException {",0);
	
		    a.escrever("   Connection conn = null;",0);
			a.escrever("   ResultSet rs = null;",0);
			a.escrever("   PreparedStatement prepStmt = null;",0);
			a.escrever("   try {",0);
			a.escrever("      conn = getConnection();",0);
			a.escrever("      prepStmt = conn.prepareStatement(EXCLUIR_REGISTRO);",0);
			      		
			aux="";
			int ii = 1;
			for(int i=0;i<regConvertido.length;i++){
				if(regConvertido[i].getChave().equals("S")){
						if(aux !=""){
							a.escrever(aux,0);	
						}
				      aux = "      prepStmt.set"+GeraClasse.ctipo(regConvertido[i].getTipo())+"("+ ii +", b.get"+plm(regConvertido[i].getColuna())+"());";
				      ii++;
				}
			}
			a.escrever(aux,0);			
			a.escrever("      prepStmt.execute();",0);
			a.escrever("   }",0);
			a.escrever("   catch (SQLException e) {",0);
			a.escrever("   System.out.println("+'\"'+"Erro ao excluir registro" +'\"'+"+ e.getMessage());",0);
			a.escrever("      throw e;",0);
		    a.escrever("   }",0);
			a.escrever("   finally {",0);
			a.escrever("      closeAll(conn, prepStmt, rs);",0);
			a.escrever("   }",0);
			a.escrever("}",0);
	
	        a.escrever("",0);
			a.escrever("//Atualiza o registro",0);
			a.escrever("public void atualizar("+GeraClasse.nomeBean+" b) throws SQLException {",0);
			a.escrever("   TrataChrEspecial tce=new TrataChrEspecial();",0);
		    a.escrever("   Connection conn = null;",0);
			a.escrever("   ResultSet rs = null;",0);
			a.escrever("   PreparedStatement prepStmt = null;",0);
			a.escrever("   try {",0);
			a.escrever("      conn = getConnection();",0);
			a.escrever("      prepStmt = conn.prepareStatement(ATUALIZA_REGISTRO);",0);
	
	      j = 0;
	
			for(int i=0;i<regConvertido.length;i++){
					
					if(regConvertido[i].getTipo()=="String"){	
						a.escrever("      prepStmt.set"+GeraClasse.ctipo(regConvertido[i].getTipo())+"("+ (i+1) +", tce.trataTodos(b.get"+plm(regConvertido[i].getColuna())+"()));",0);
					}else{
						a.escrever("      prepStmt.set"+GeraClasse.ctipo(regConvertido[i].getTipo())+"("+ (i+1) +", b.get"+plm(regConvertido[i].getColuna())+"());",0);
					}
		      
					j=i+1;
			}
	       aux2="";
			for(int k=0;k<regConvertido.length;k++){
				System.out.println("chave->"+regConvertido[k].getChave()+" "+regConvertido[k].getColuna());
				if(regConvertido[k].getChave().equals("S")){
						if(aux2 !="" && aux2 !=null){
							a.escrever(aux2,0);
						}
						j=j+1;
				      aux2 = "      prepStmt.set"+GeraClasse.ctipo(regConvertido[k].getTipo())+"("+ j +", b.get"+plm(regConvertido[k].getColuna())+"());";		
				}
			}
			a.escrever(aux2,0);
			a.escrever("      prepStmt.execute();",0);
			a.escrever("   }",0);
			a.escrever("   catch (SQLException e) {",0);
			a.escrever("   System.out.println("+'\"'+"Erro ao atualizar registro" +'\"'+"+ e.getMessage());",0);
			a.escrever("      throw e;",0);
		    a.escrever("   }",0);
			a.escrever("   finally {",0);
			a.escrever("      closeAll(conn, prepStmt, rs);",0);
			a.escrever("   }",0);
			a.escrever("}",0);								
			
			
			a.escrever("//Obtém um registro",0);
			
			a.escrever("  public "+GeraClasse.nomeBean+" get"+GeraClasse.nomeBean+"ById(",1);
					
			aux ="";
			for(int i=0;i<regConvertido.length;i++){
				if(regConvertido[i].getChave().equals("S")){
						if(aux !=""){
							a.escrever(aux,1);	
						}
						aux = regConvertido[i].getTipo()+" "+ regConvertido[i].getColuna() + "_Id,";
				}
			}				
			
			if(aux ==""){
				 JOptionPane.showMessageDialog(null, "Arquivo DB"+ GeraClasse.nomeBean +" NÃO foi gerado com sucesso! A tabela pode estar sem Primary Key OU não há coluna selecionada.(Clique em Selecionar todos)", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
            }else{
				  a.escrever(aux.substring(0,aux.length()-1) +") throws SQLException{",0);
	        }
			  
	
			a.escrever("",0);
			a.escrever("    Connection conn = null;",0);
			a.escrever("    PreparedStatement prepStmt = null;",0);
			a.escrever("    ResultSet rs = null;",0);
			a.escrever("	 "+GeraClasse.nomeBean+" b = null;",0);
			a.escrever("	 try {",0);
			a.escrever("      conn = getConnection();",0);
			a.escrever("      prepStmt = conn.prepareStatement(REGISTRO_ID);",0);
	
			aux="";
			for(int i=0;i<regConvertido.length;i++){
				if(regConvertido[i].getChave().equals("S")){
						if(aux !=""){
							a.escrever(aux,0);	
						}
				      aux = "      prepStmt.set"+GeraClasse.ctipo(regConvertido[i].getTipo())+"("+ (i+1) +","+GeraClasse.plmi(regConvertido[i].getColuna())+"_Id);";
				}
			}
	      a.escrever(aux,0);
			a.escrever("      rs = prepStmt.executeQuery();",0);
			a.escrever("",0);
			a.escrever("      if (rs.next()) {",0);
	
			for(int i=0;i<regConvertido.length;i++){
					a.escrever("	      "+regConvertido[i].getTipo()+" "+ regConvertido[i].getColuna() +"= rs.get"+GeraClasse.ctipo(regConvertido[i].getTipo())+"("+'\"'+regConvertido[i].getColuna()+'\"'+");",0);
			}		
						
			a.escrever("	      b = new "+GeraClasse.nomeBean+"(",1);
			for(int i=0;i<regConvertido.length;i++){
				
				if(i==regConvertido.length -1){
					a.escrever(regConvertido[i].getColuna()+");",0);
				}else{
					a.escrever(regConvertido[i].getColuna()+",",1);
				}		
			}		
	
			a.escrever("		}",0);
			a.escrever("		return b;",0);
			a.escrever("    }",0);
			a.escrever("",0);
			a.escrever("    catch (SQLException e) {",0);
			a.escrever("      System.out.println(" +'\"'+"Erro ao obter dados " +'\"'+" + e.getMessage());",0);
			a.escrever("      throw e;",0);
			a.escrever("    }",0);
			a.escrever("    finally {",0);
			a.escrever("      closeAll(conn, prepStmt, rs);",0);
			a.escrever("    }",0);
			a.escrever("",0);
			a.escrever("  }",0);
			
			a.escrever("}  // class",0);
			a.fechar();
			geracao_ok = true;
		}//try
		catch (Exception e) {
			System.out.println("Erro:" + e.getMessage());
			geracao_ok = false;
		}
		
		}//construtor
		
	public boolean arquivo_gerado(){
		return this.geracao_ok;
	}
	
	private String plm(String s){
	   return  s.substring(0,1).toUpperCase() + s.substring(1).toLowerCase();
	}

}//classe
