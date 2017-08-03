package com.warsys.geraclasse.classes;

import com.warsys.geraclasse.bean.Registros;
import javax.swing.*;


public class GeraArqDAO {
	
	boolean geracao_ok = false;
	
	public GeraArqDAO(String nomeClasse,String nomeEmpSist, Registros[] regConvertido){
		
			String aux = "";
   
         System.out.println("Estou na classe GeraArqDAO");
			
			try{
				java.text.SimpleDateFormat dfcnv = new java.text.SimpleDateFormat("dd/MM/yyyy"); 
				java.util.Date dateNow =new java.util.Date();
				String hoje =dfcnv.format(dateNow);
				
				System.out.println("Estou na classe GeraArqDAO -> Dentro do 'try' ");
				
				System.out.println("GeraClasse.nomeBean -> " + GeraClasse.nomeBean);
				System.out.println("nomeClasse -> "+nomeClasse);
				
				Arquivo a = new Arquivo(GeraClasse.nomeBean);
				a.criar(nomeClasse);
				//Inicio da classe

				a.escrever("package com.warsys."+nomeEmpSist+".dao;",0);

				a.escrever("",0);
				a.escrever("import java.sql.SQLException;",0);
				a.escrever("import com.warsys."+nomeEmpSist+".bean."+GeraClasse.nomeBean+";",0);
				a.escrever("",0);
				a.escrever("",0);
				a.escrever("public interface "+GeraClasse.nomeDAO+"{",0);
				a.escrever("",0);
				a.escrever("/*******************************/",0);
				a.escrever("/*Autor: Adilson Guerra        */",0);
				a.escrever("/*Data :"+hoje+"             */",0);
				a.escrever("/*******************************/",0);
				a.escrever("",0);

				a.escrever("public void insere("+GeraClasse.nomeBean+" b) throws SQLException;",0);
				a.escrever("public "+GeraClasse.nomeBean+"[] get"+GeraClasse.nomeBean+"s() throws SQLException;",0);
		      	a.escrever("public void excluir("+GeraClasse.nomeBean+" b) throws SQLException;",0);
            	a.escrever("public void atualizar("+GeraClasse.nomeBean+" b) throws SQLException;",0);
				a.escrever("public "+GeraClasse.nomeBean+" get"+GeraClasse.nomeBean+"ById(",1);
				
            
				for(int i=0;i<regConvertido.length;i++){
				  
               		//System.out.println("i:" +regConvertido[i].getChave());
               
               
               		if(regConvertido[i].getChave().equals("S")){
							if(aux !=""){
								a.escrever(aux,1);	
							}
							aux = regConvertido[i].getTipo()+" "+ regConvertido[i].getColuna() + ",";
					}
				}				
				
				if(aux ==""){
					 JOptionPane.showMessageDialog(null, "Arquivo DAO"+ GeraClasse.nomeBean +" NÃO foi gerado com sucesso! A tabela pode estar sem Primary Key  OU não há coluna selecionada.(Clique em Selecionar todos).", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
                }else{
                	a.escrever(aux.substring(0,aux.length()-1) +") throws SQLException;",0);
                }
                
				a.escrever("",0);
				a.escrever("}  // DAO class",0);
				a.fechar();
				geracao_ok = true;
            
			}
			catch (Exception e) {
            System.out.println("Erro no método criarDAO:" + e.getMessage());
            geracao_ok = false;
	      }	
	}//construtor
	
	public boolean arquivo_gerado(){
		return this.geracao_ok;
	}
	
}//classe
