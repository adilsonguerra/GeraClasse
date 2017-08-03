package com.warsys.util;

public class TrataException extends Exception {
	private Exception exception;
	
	public TrataException(Exception e, String mensagem){
		super(mensagem);
		this.exception = e;
		e.printStackTrace();
		this.printStackTrace();
	}
	public TrataException(String mensagem){
			super(mensagem);		
		}
	
	public static void print (Exception e, String mensagem){
		System.out.println("==============Exception===============");
		System.out.println(mensagem);
		System.out.println("PrintStackTrace: ");
		e.printStackTrace();
		System.out.println("============End Exception=============");
	}

	public void print(){
		System.out.println("==============Exception===============");
		System.out.println(getMessage());
		System.out.println("PrintStackTrace: ");
		exception.printStackTrace();
		System.out.println("============End Exception=============");

	}
	
}
