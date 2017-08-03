package com.warsys.util;

import java.text.ParseException;
import java.text.DecimalFormat;

////////////////////////////////////////////////////////////////////
// Esta classe retorna o n�mero, tratando os "." e "," independente 
// da configura��o regional do servidor.                             
// Passando uma String, retorna um float.
// Passando um float, retorna uma String.
////////////////////////////////////////////////////////////////////

public class TrataPontoDecimal{
   
   private int precisao=2;
   private boolean separador=true;
   
	public TrataPontoDecimal(){		
	}
	
   public float trataDec(String s,int precisao,boolean separador){
      this.precisao=precisao;
      this.separador=separador;
      return trataDec(s);
   }
   
   public String trataDec(float f,int precisao,boolean separador){
      this.precisao=precisao;
      this.separador=separador;
      return trataDec(f);
   }

   public float trataDec(String s,int precisao){
      this.precisao=precisao;
      return trataDec(s);
   }
   
   public String trataDec(float f,int precisao){
      this.precisao=precisao;
      return trataDec(f);
   }

	public float trataDec(String s){
	  
		float r=0;
		
		if (s==null){
			return r;
		}
		
      String aux="";
      if(precisao>0){
         for(int i=0;i<precisao;i++){
           if (i==0){
               aux= aux +".0";
           }else{
               aux= aux +"0";
           } 
         }
		}
		
		
		DecimalFormat df = new DecimalFormat("#,###,###,###,##0"+aux);
      
      if (!separador){
         df.applyPattern("############0"+aux);
      }
         
   	    try{
	   	    //O "malabarismo abaixo foi necess�rio, pois n�o foi permitido alterar a 
	   	    //configura��o regional do  servidor para o sistema portugu�s"
	   	    
	   	    //Para descobrir o ponto decimal que est� sendo utilizado
	   		float p = (1F/2F);// 0.5 ou 0,5h
	   			
			if (df.format(p).substring(1,2).equals(".")){
				//Tratamento para o sistema Americano
				//Troca as divis�es de milhar por x
				String s1 = s.replace('.','x');
	
				//Troca o ponto decimal(,)  por (.)
				String s2 = s1.replace(',','.');
	
	            //Troca o x  por (,)
				String s3 =s2.replace('x',',');
				
				//String no formato Americano sendo convertido para float
				r = df.parse(s3).floatValue();
	
			} else{	
			   //Tratamento para o sistema Portugu�s
				r = df.parse(s).floatValue();
			}

		}//try
		catch (Exception e) {
			System.out.println("Erro:" + e.getMessage());
		}
		return r;
	}

	public String trataDec(float fAux){
		
		String s="0";
		
		try{
			
         String aux="";
         
         if(precisao>0){
            for(int i=0;i<precisao;i++){
              if (i==0){
                  aux= aux +".0";
              }else{
                  aux= aux +"0";
              } 
            }
         }
         
         DecimalFormat df = new DecimalFormat("#,###,###,###,##0"+aux);
         
         if (!separador){
            df.applyPattern("############0"+aux);
         }
		   //Para descobrir o ponto decimal que est� sendo utilizado
			float p = (1F/2F);// 0.5 ou 0,5
         
         System.out.println ("p="+df.format(p).substring(1,2));
            
			if ((precisao>0) && (df.format(p).substring(1,2).equals(".") ) ){
				//Tratamento para o sistema Americano
            float f = fAux;
				String s1 = df.format(f).replace('.','x');	
				String s2 = s1.replace(',','.');
				s = s2.replace('x',',');
			} else{
            //Tratamento para o sistema Portugu�s          
            if (precisao>0){
               float f = fAux;
               s = df.format(f);
            }else{
               long f =(long)fAux;
               s = df.format(f);
            }
			}

		}//try
		catch (Exception e) {
			System.out.println("Erro:" + e.getMessage());
		}
		return s;
	}

}//end class
