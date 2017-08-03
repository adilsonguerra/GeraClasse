package com.warsys.util;

public class TrataChrEspecial{

	public TrataChrEspecial(){		
	}
	
	public String trataTodos(String s){
		
		if (s==null){
			s=" ";
			return s;
		}
		
		try{
			s=s.trim();
			s=s.toUpperCase();
			s=s.replace('Ã','A'); 
			s=s.replace('Á','A');
			s=s.replace('À','A'); 
			s=s.replace('Â','A');
			s=s.replace('Ä','A');

			s=s.replace('É','E');
			s=s.replace('È','E'); 
			s=s.replace('Ê','E');
			s=s.replace('Ë','E');

			s=s.replace('Í','I');
			s=s.replace('Ì','I'); 
			s=s.replace('Î','I');
			s=s.replace('Ï','I');

			s=s.replace('Ò','O');
			s=s.replace('Ó','O'); 
			s=s.replace('Ô','O');
			s=s.replace('Ö','O');		
			s=s.replace('Õ','O');


			s=s.replace('Ù','U');
			s=s.replace('Ú','U'); 
			s=s.replace('Û','U');
			s=s.replace('Ü','U');		

			s=s.replace('Ç','C');

			//Retira qualquer outro caracter especial
			for(int i=0;i<s.length();i++){
				if (!((s.charAt(i)>=65 && s.charAt(i)<=90)||(s.charAt(i)>=48 && s.charAt(i)<=57))){
					s=s.replace(s.charAt(i),' ');
				}//if
			}//for		
		}//try
		catch (Exception e) {
			System.out.println("Erro:" + e.getMessage());
		}
		return s;
	}

  //Trata somente apóstrofos,aspas duplas e carry returns. Trocando por um espaço
	public String trata_aa(String s){
		
		if (s==null){
			s=" ";
			return s;
		}
		
		try{
			s=s.trim();
			s=s.replace('\'',' '); 
			s=s.replace('\"',' '); 
			s=s.replace('\r',' '); 
			s=s.replace('\f',' '); 

		}//try
		catch (Exception e) {
			System.out.println("Erro:" + e.getMessage());
		}
		return s;
	}

}//end class
