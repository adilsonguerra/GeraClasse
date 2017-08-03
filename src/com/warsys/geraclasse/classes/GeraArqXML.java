package com.warsys.geraclasse.classes;

import com.warsys.geraclasse.bean.Registros;


public class GeraArqXML {
	
	boolean geracao_ok = false;
	
	public GeraArqXML(Registros[] regConvertido){
		
		try{
			Arquivo arqXml = new Arquivo("dataentryXML");
			arqXml.criar(GeraClasse.nomeTabela+".xml");
				
			arqXml.escrever("<?xml version="+'\"'+"1.0"+'\"'+"?>",0);
			arqXml.escrever("",0);
			arqXml.escrever("<contexto>",0);					
			arqXml.escrever("   <!--"+GeraClasse.nomeTabela+"-->",0);					
			arqXml.escrever("   <tabela nometab="+'\"'+GeraClasse.nomeTabela+'\"'+">",0);
			arqXml.escrever("      <!--Nomes das variaveis-->",0);					
			arqXml.escrever("      <nomeBean>"+GeraClasse.nomeBean+"</nomeBean>",0);
			arqXml.escrever("      <nomeDB>"+GeraClasse.nomeDB+"</nomeDB>",0);
			arqXml.escrever("      <nomeDAO>"+GeraClasse.nomeDAO+"</nomeDAO>",0);
			arqXml.escrever("      <nomeServletAtualizacao>"+GeraClasse.nomeServletAtualizacao+"</nomeServletAtualizacao>",0);
			arqXml.escrever("      <nomeServletConsulta>"+GeraClasse.nomeServletConsulta+"</nomeServletConsulta>",0);
			arqXml.escrever("      <nomeServletExclusao>"+GeraClasse.nomeServletExclusao+"</nomeServletExclusao>",0);
			arqXml.escrever("      <nomeServletInclusao>"+GeraClasse.nomeServletInclusao+"</nomeServletInclusao>",0);
			arqXml.escrever("      <nomeConsultaHtml>"+GeraClasse.nomeConsultaHtml+"</nomeConsultaHtml>",0);
			arqXml.escrever("      <nomeGrid_Detalhe>"+GeraClasse.nomeGrid_Detalhe+"</nomeGrid_Detalhe>",0);
			arqXml.escrever("      <nomeGrid_Campos>"+GeraClasse.nomeGrid_Campos+"</nomeGrid_Campos>",0);
			arqXml.escrever("      <!--Nomes dos arquivos-->",0);
			arqXml.escrever("      <nomeArquivoBean>"+GeraClasse.nomeArquivoBean+"</nomeArquivoBean>",0);
			arqXml.escrever("      <nomeArquivoDAO>"+GeraClasse.nomeArquivoDAO+"</nomeArquivoDAO>",0);
			arqXml.escrever("      <nomeArquivoDB>"+GeraClasse.nomeArquivoDB+"</nomeArquivoDB>",0);
			arqXml.escrever("      <nomeArquivoServletAtualizacao>"+GeraClasse.nomeArquivoServletAtualizacao+"</nomeArquivoServletAtualizacao>",0);
			arqXml.escrever("      <nomeArquivoServletConsulta>"+GeraClasse.nomeArquivoServletConsulta+"</nomeArquivoServletConsulta>",0);
			arqXml.escrever("      <nomeArquivoServletExclusao>"+GeraClasse.nomeArquivoServletExclusao+"</nomeArquivoServletExclusao>",0);
			arqXml.escrever("      <nomeArquivoServletInclusao>"+GeraClasse.nomeArquivoServletInclusao+"</nomeArquivoServletInclusao>",0);	
			arqXml.escrever("      <nomeArquivoConsultaHtml>"+GeraClasse.nomeArquivoConsultaHtml+"</nomeArquivoConsultaHtml>",0);
			
			arqXml.escrever("      <nomeArquivoMenuPrincJsp>"+GeraClasse.nomeArquivoMenuPrincJsp+"</nomeArquivoMenuPrincJsp>",0);
			arqXml.escrever("      <nomeArquivoMenu_princJsp>"+GeraClasse.nomeArquivoMenu_princJsp+"</nomeArquivoMenu_princJsp>",0);
			
			arqXml.escrever("      <nomeArquivoGrid_Detalhe>"+GeraClasse.nomeArquivoGrid_Detalhe+"</nomeArquivoGrid_Detalhe>",0);
			arqXml.escrever("      <nomeArquivoGrid_Campos>"+GeraClasse.nomeArquivoGrid_Campos+"</nomeArquivoGrid_Campos>",0);
			arqXml.escrever("      <nomeArquivoBuildFile>"+GeraClasse.nomeArquivoBuildFile+"</nomeArquivoBuildFile>",0);
			arqXml.escrever("      <nomeArquivoWebXmlFile>"+GeraClasse.nomeArquivoWebXmlFile+"</nomeArquivoWebXmlFile>",0);
				
			for(int i=0;i<regConvertido.length;i++){
				
				String auxIni = regConvertido[i].getIni()==""?null:regConvertido[i].getIni();
				
				arqXml.escrever("      <!--"+regConvertido[i].getColuna()+"-->",0);					
				arqXml.escrever("      <coluna nomecol="+'\"'+regConvertido[i].getColuna()+'\"'+">",0);
				arqXml.escrever("         <tipo>"+regConvertido[i].getTipo()+"</tipo>",0);
				arqXml.escrever("         <tamanho>"+regConvertido[i].getTamanho()+"</tamanho>",0);
				arqXml.escrever("         <precisao>"+regConvertido[i].getPrecisao()+"</precisao>",0);
				arqXml.escrever("         <obrigatorio>"+regConvertido[i].getObrigatorio()+"</obrigatorio>",0);
				arqXml.escrever("         <chave>"+regConvertido[i].getChave()+"</chave>",0);
				arqXml.escrever("         <ini>"+auxIni+"</ini>",0);
				arqXml.escrever("         <aliascoluna>"+regConvertido[i].getNomeColuna()+"</aliascoluna> <!--nome do label-->",0);
				arqXml.escrever("         <repositorio>"+regConvertido[i].getRepositorio()+"</repositorio> <!--nome da tabela-->",0);
				arqXml.escrever("         <tabrepos>"+regConvertido[i].getTabRepos()+"</tabrepos> <!--nome da col desc-->",0);
				arqXml.escrever("         <chaverepos>"+regConvertido[i].getChaveRepos()+"</chaverepos> <!--nome da col chave-->",0);					
				arqXml.escrever("      </coluna>",0);
			 }
	
			 arqXml.escrever("   </tabela>",0);
			 arqXml.escrever("</contexto>",0);
				
			 arqXml.fechar();
			 //Aqui termina a construção do XML
			 
			 geracao_ok = true;
			 			 
		}//try
		catch(Exception e) {
			System.out.println("Arquivo XML não foi gerado! Erro:"+e);
			geracao_ok = false;
		}//catch

	}//método
	
	public boolean arquivo_gerado(){
		return this.geracao_ok;
	}
	
}//classe
