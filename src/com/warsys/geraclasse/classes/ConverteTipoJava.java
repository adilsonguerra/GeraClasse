package com.warsys.geraclasse.classes;

import com.warsys.geraclasse.bean.Registros;
import java.util.Vector;


public class ConverteTipoJava {
	
	private Registros[] registros= null;
	
	public ConverteTipoJava(Registros[] r){
		
		Vector v1 = new Vector();
		String coluna;
		String tipo;
		String tamanho;
		String precisao;
		String obrigatorio;
		String chave;
		String ini;
		String nomeColuna;
		String repositorio;
		String tabRepos;
		String chaveRepos;


		for(int i=0;i<r.length;i++){
			
			coluna = r[i].getColuna().toLowerCase();

			tipo = "String";
			ini = "\""+"\"";
            
			// =================== Tipos ORACLE =============
			
			//Relaciona VARCHAR a String
			if(r[i].getTipo().equalsIgnoreCase("VARCHAR")){
				tipo = "String";
				ini = "\""+"\"";
			}

			//Relaciona VARCHAR2 a String
			if(r[i].getTipo().equalsIgnoreCase("VARCHAR2")){
				tipo = "String";
				ini = "\""+"\"";
			}
			
			//Relaciona CHAR a String
			if(r[i].getTipo().equalsIgnoreCase("CHAR")){
				tipo = "String";
            ini = "\""+"\"";
			}

			//Relaciona LONGVARCHAR a String
			if(r[i].getTipo().equalsIgnoreCase("LONGVARCHAR")){
				tipo = "String";
				ini = "\""+"\"";
			}

			//Relaciona NUMBER a int
			if(r[i].getTipo().equalsIgnoreCase("NUMBER")){
				if (r[i].getPrecisao().equals("0")){
					tipo = "int";
         		ini = "0";
				} else{
					tipo = "float";
					ini =  "0";
				}
			}
			
			//Relaciona INTEGER a int
			if(r[i].getTipo().equalsIgnoreCase("INTEGER")){
				tipo = "int";
				ini = "0";
			}

			//Relaciona DOUBLE a double
			if(r[i].getTipo().equalsIgnoreCase("DOUBLE")){
				tipo = "double";
				ini =  "0";
			}

			//Relaciona FLOAT a double
			if(r[i].getTipo().equalsIgnoreCase("FLOAT")){
				tipo = "double";
				ini =  "0";
			}
			
			//Relaciona FLOAT a double
			if(r[i].getTipo().equalsIgnoreCase("BIT")){
				tipo = "boolean";
            ini = "false"; 
			}

			if(r[i].getTipo().equalsIgnoreCase("DATE")){
				tipo = "java.sql.Date";
				ini = "null";
			}
			
			if(r[i].getTipo().equalsIgnoreCase("TIME")){
				tipo = "java.sql.Time";
            ini = "null";
			}

			if(r[i].getTipo().equalsIgnoreCase("TIMESTAMP")){
				tipo = "java.sql.Timestamp";
            ini = "null";
			}

			if(r[i].getTipo().equalsIgnoreCase("NUMERIC")){
				tipo = "java.math.BigDecimal";
            ini ="0";
			}

			if(r[i].getTipo().equalsIgnoreCase("DECIMAL")){
				tipo = "java.math.BigDecimal";
            ini = "0";
			}

			if(r[i].getTipo().equalsIgnoreCase("REAL")){
				tipo = "float";
            ini =  "0";
			}

			if(r[i].getTipo().equalsIgnoreCase("TINYINT")){
				tipo = "byte";
				ini ="0";
			}
			if(r[i].getTipo().equalsIgnoreCase("SMALLINT")){
				tipo = "short";
            ini =  "0";
			}

			if(r[i].getTipo().equalsIgnoreCase("BIGINT")){
				tipo = "long";
            ini = "0";
			}
			if(r[i].getTipo().equalsIgnoreCase("BINARY")){
				tipo = "byte[]";
            ini = "null";
			}
			
			
			// =================== Tipos ACCESSS =============
			
			
			if(r[i].getTipo().equalsIgnoreCase("dbText")){
				tipo = "String";
				ini = "\""+"\"";
			}

			
			if(r[i].getTipo().equalsIgnoreCase("dbMemo")){
				tipo = "String";
				ini = "\""+"\"";
			}

			if(r[i].getTipo().equalsIgnoreCase("dbSingle")){
				if (r[i].getPrecisao().equals("0")){
					tipo = "int";
         		ini = "0";
				} else{
					tipo = "float";
					ini =  "0";
				}
			}
			

			if(r[i].getTipo().equalsIgnoreCase("dbDouble")){
				tipo = "double";
				ini =  "0";
			}

			if(r[i].getTipo().equalsIgnoreCase("dbBoolean")){
				tipo = "boolean";
            ini = "false"; 
			}

			if(r[i].getTipo().equalsIgnoreCase("dbDate")){
				tipo = "java.sql.Date";
				ini = "null";
			}
			

	/*		if(r[i].getTipo().equalsIgnoreCase("dbLong")){
				tipo = "java.math.BigDecimal";
            ini ="0";
			}
  

			if(r[i].getTipo().equalsIgnoreCase("REAL")){
				tipo = "float";
            ini =  "0";
			}
   */
			if(r[i].getTipo().equalsIgnoreCase("dbInteger")){
				tipo = "short";
            ini =  "0";
			}

			if(r[i].getTipo().equalsIgnoreCase("dbLong")){
				tipo = "long";
            ini = "0";
			}
			
			if(r[i].getTipo().equalsIgnoreCase("dbByte")){
				tipo = "byte[]";
            ini = "null";
			}
			
			
			// =================== Tipos POSGRES - (Tipos iguais o Oracle estão acima) =============
			
			
			
			if(r[i].getTipo().equalsIgnoreCase("INT4")){
				tipo = "int";
            ini = "0";
			}
			
			if(r[i].getTipo().equalsIgnoreCase("INT8")){
				tipo = "long";
            ini = "0";
			}
			
			
			if(r[i].getTipo().equalsIgnoreCase("bpchar")){
				tipo = "String";
				ini = "\""+"\"";
			}
			
			if(r[i].getTipo().equalsIgnoreCase("text")){
				tipo = "String";
				ini = "\""+"\"";
			}			

			if(r[i].getTipo().equalsIgnoreCase("FLOAT8")){
				tipo = "double";
            ini = "0";
			}


			// ===================
			
			
          
			tamanho =  r[i].getTamanho();
			precisao =  r[i].getPrecisao();
			obrigatorio =  r[i].getObrigatorio();
			chave =  r[i].getChave();
			nomeColuna =  r[i].getNomeColuna();
			repositorio =  r[i].getRepositorio();
			tabRepos =  r[i].getTabRepos();
			chaveRepos =  r[i].getChaveRepos();
         
         if (tamanho==null){
            tamanho="null";
			}
			
         if (precisao==null){
            precisao="null";
         }
         
         if (obrigatorio==null){
            obrigatorio="null";
         }
         
         if (chave==null){
            chave="null";
         }

         if (nomeColuna==null){
            nomeColuna="null";
         }
         
         if (repositorio==null){
            repositorio="null";
         }
         
         if (tabRepos==null){
            tabRepos="null";
         }

         if (chaveRepos==null){
            chaveRepos="null";
         }

			Registros rgs= new Registros(coluna,tipo,tamanho,precisao,obrigatorio,chave,ini,nomeColuna,repositorio,tabRepos,chaveRepos);
			v1.add(rgs);			
		}//for

		Registros regs[] = new Registros[v1.size()];
		v1.copyInto(regs);

		this.registros = regs;
   }//construtor
   
	public Registros[] getRegConvertidos(){
		return this.registros;
	}

}//class
