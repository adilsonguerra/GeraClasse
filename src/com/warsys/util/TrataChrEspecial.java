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
			s=s.replace('�','A'); 
			s=s.replace('�','A');
			s=s.replace('�','A'); 
			s=s.replace('�','A');
			s=s.replace('�','A');

			s=s.replace('�','E');
			s=s.replace('�','E'); 
			s=s.replace('�','E');
			s=s.replace('�','E');

			s=s.replace('�','I');
			s=s.replace('�','I'); 
			s=s.replace('�','I');
			s=s.replace('�','I');

			s=s.replace('�','O');
			s=s.replace('�','O'); 
			s=s.replace('�','O');
			s=s.replace('�','O');		
			s=s.replace('�','O');


			s=s.replace('�','U');
			s=s.replace('�','U'); 
			s=s.replace('�','U');
			s=s.replace('�','U');		

			s=s.replace('�','C');

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

  //Trata somente ap�strofos,aspas duplas e carry returns. Trocando por um espa�o
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
