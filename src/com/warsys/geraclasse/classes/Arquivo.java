package com.warsys.geraclasse.classes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Arquivo{
	File arquivo,pasta;
	FileWriter fw;
	String nomeArq;
	String nomePasta;

	public Arquivo (String nomePasta){
      //this.nomePasta = "/GeraClasse/Arquivos_gerados";
       this.nomePasta = "./Arquivos_gerados";
	}

	public void criar (String nomeArq){
		this.nomeArq = nomeArq;
		try{
			pasta = new File(nomePasta);
			pasta.mkdirs();
			arquivo = new File(pasta + "/"+ nomeArq );
			arquivo.createNewFile(); //Cria o arquivo, fisicamente, no disco.
		   fw = new FileWriter(arquivo);
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
	}

	public void escrever (String linha, int cr){
		try{
			if (cr==0){
			fw.write(linha + '\r');
			} else{
				fw.write(linha);
			}
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
	
	public void fechar (){
		try{
			fw.close();
			System.out.println("Arquivo gerado->"+nomeArq);
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
	}

}
