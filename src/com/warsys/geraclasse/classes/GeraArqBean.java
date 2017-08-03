package com.warsys.geraclasse.classes;

import com.warsys.geraclasse.bean.Registros;

public class GeraArqBean {
	
	boolean geracao_ok = false;
	
	public GeraArqBean(String nomeClasse,String nomeEmpSis, Registros[] regConvertido){
		
		try{
			java.text.SimpleDateFormat dfcnv = new java.text.SimpleDateFormat("dd/MM/yyyy"); 
			java.util.Date dateNow =new java.util.Date();
			String hoje =dfcnv.format(dateNow);

			Arquivo a = new Arquivo(GeraClasse.nomeBean);
			a.criar(nomeClasse);

			a.escrever("package com.warsys."+nomeEmpSis+".bean;",0);
			a.escrever("",0);
			//Inicio da classe
			a.escrever("public class "+GeraClasse.nomeBean+"{",0);
			a.escrever("",0);
			a.escrever("/*******************************/",0);
			a.escrever("/*Autor: Adilson Guerra        */",0);
			a.escrever("/*Data :"+hoje+"             */",0);
			a.escrever("/*******************************/",0);
			a.escrever("",0);

			for(int i=0;i<regConvertido.length;i++){
				a.escrever("   private "+ regConvertido[i].getTipo() +" "+ regConvertido[i].getColuna() + ";",0);
			}
			a.escrever("",0);
			//Construtor
			a.escrever("   public "+GeraClasse.nomeBean+"(",1);  
				for(int i=0;i<regConvertido.length;i++){
					if(i==regConvertido.length -1){
						a.escrever(regConvertido[i].getTipo() +" "+ regConvertido[i].getColuna(),1);
					}else{
						a.escrever(regConvertido[i].getTipo() +" "+ regConvertido[i].getColuna() + ",",1);
					}
				}
			a.escrever(") {",0);

				for(int i=0;i<regConvertido.length;i++){
				a.escrever("      this."+ regConvertido[i].getColuna() + " = "+ regConvertido[i].getColuna() + ";",0);
				}

			a.escrever("   }  //Construtor",0);

			a.escrever("",0);
			for(int i=0;i<regConvertido.length;i++){
				a.escrever("   //"+regConvertido[i].getColuna().toLowerCase(),0);
				//Getters 
				a.escrever("   public "+ regConvertido[i].getTipo() +" get"+GeraClasse.plm(regConvertido[i].getColuna())+"(){",0);
				a.escrever("      return this."+regConvertido[i].getColuna()+ ";",0);
				a.escrever("   }",0);
				//Setters
				a.escrever("   public void set"+GeraClasse.plm(regConvertido[i].getColuna())+"("+regConvertido[i].getTipo()+" "+regConvertido[i].getColuna()+"){",0);   
				a.escrever("     this."+regConvertido[i].getColuna()+"="+regConvertido[i].getColuna()+";",0);
				a.escrever("   }",0);
			}

			
			a.escrever("",0);
			a.escrever("   public void getString(){",0);
			  a.escrever("",0);					
			for(int i=0;i<regConvertido.length;i++){ 
				a.escrever("      System.out.println("+'\"'+ regConvertido[i].getTipo() +" " + regConvertido[i].getColuna()+"="+'\"'+"+ this."+ regConvertido[i].getColuna() +");",0);					
			}
			a.escrever("   }",0);

		
			a.escrever("}  // class",0);
			a.fechar();
			geracao_ok = true;
		}//try
		catch (Exception e) {
			System.out.println("Erro:" + e.getMessage());
			geracao_ok = false;
		}//catch
	
	}//construtor
	
	public boolean arquivo_gerado(){
		return this.geracao_ok;
	}
	

	
}//classe
