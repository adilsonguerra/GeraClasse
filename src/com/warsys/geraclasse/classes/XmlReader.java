package com.warsys.geraclasse.classes;

import java.util.*;
import com.warsys.geraclasse.bean.Registros;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class XmlReader {

  // caminho (path) do arquivo XML
  private String xmlPathname;
  // construtor que seta o caminho do XML
  public XmlReader(String caminho) {
    xmlPathname = caminho;
    System.out.println("Dentro do xlmReader caminho="+caminho);
  }
  
  // le o XML carregando os dados dos Registros em um Vector.
  // retorna o vector contendo os Registros no XML.
  public Vector lerRegistros(String nomeTabela) throws Exception {
  	
	System.out.println("Lendo as colunas da tabela "+nomeTabela +"...");
	
	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();
    Document doc = db.parse( xmlPathname );

    Element elem = doc.getDocumentElement();
    // pega todos os elementos tabela do XML
    NodeList nlTab = elem.getElementsByTagName( "tabela" );

	Vector vRegistros = new Vector();
    System.out.println("Colocou no vetor as colunas que foram lidas...");
    // percorre cada elemento "tabela" encontrado
    for(int i=0;i<nlTab.getLength();i++) {
	   Element tagTabela = (Element) nlTab.item(i);

		// só pega se for a tabela passada no parametro
	   if(tagTabela.getAttribute("nometab").equals(nomeTabela)){
         
		   // pega todos os elementos "coluna" da tabela XML
		   NodeList nlCol = tagTabela.getElementsByTagName( "coluna" );
		   
         
		   // percorre cada elemento tabela encontrado
		   for( int j=0; j<nlCol.getLength(); j++ ) {
			  Element tagColuna = (Element) nlCol.item(j);  
			  
			  //NÃO APAGAR-> usar para debugar
//			  System.out.println("---Dados retirados do XML---");
//			  System.out.println("nomecol="+tagColuna.getAttribute("nomecol"));
//			  System.out.println("tipo="+getChildTagValue( tagColuna, "tipo"));
//			  System.out.println("tamanho="+getChildTagValue( tagColuna, "tamanho"));
//			  System.out.println("precisao="+getChildTagValue( tagColuna, "precisao" ));
//			  System.out.println("obrigatorio="+getChildTagValue( tagColuna, "obrigatorio"));
//			  System.out.println("chave="+getChildTagValue( tagColuna, "chave"));
//			  System.out.println("ini="+getChildTagValue( tagColuna, "ini"));
//			  System.out.println("aliascoluna="+getChildTagValue( tagColuna, "aliascoluna"));
//			  System.out.println("repositorio="+getChildTagValue( tagColuna, "repositorio"));
//			  System.out.println("tabrepos="+getChildTagValue( tagColuna, "tabrepos"));
//			  System.out.println("chaverepos="+getChildTagValue( tagColuna, "chaverepos"));
//			  System.out.println("");
        
			  String coluna = tagColuna.getAttribute("nomecol");  
			  String tipo = getChildTagValue( tagColuna, "tipo" );
			  String tamanho = getChildTagValue( tagColuna, "tamanho" );
			  String precisao = getChildTagValue( tagColuna, "precisao" );
			  String obrigatorio = getChildTagValue( tagColuna, "obrigatorio" );
			  String chave = getChildTagValue( tagColuna, "chave" );
			  String ini = getChildTagValue( tagColuna, "ini" );
			  String aliasColuna = getChildTagValue( tagColuna, "aliascoluna" );
			  String repositorio = getChildTagValue( tagColuna, "repositorio" );
			  String tabRepos = getChildTagValue( tagColuna, "tabrepos" );
			  String chaveRepos = getChildTagValue( tagColuna, "chaverepos" );
			  
			  //NÃO APAGAR-> usar para debugar
//			  System.out.println("---Dados retirados das variaveis carregadas---");
//			  System.out.println("coluna="+coluna);
//			  System.out.println("tipo="+tipo);
//			  System.out.println("tamanho="+tamanho);
//			  System.out.println("precisao="+precisao);
//			  System.out.println("obrigatorio="+obrigatorio);
//			  System.out.println("chave="+chave);
//			  System.out.println("ini="+ini);
//			  System.out.println("aliasColuna="+aliasColuna);
//			  System.out.println("repositorio="+repositorio);
//			  System.out.println("tabRepos="+tabRepos);
//			  System.out.println("chaveRepos="+chaveRepos);
// 			  System.out.println("");
			 
			  // cria uma nova instancia da classe Registros com os dados do xml
			  Registros registros = new Registros(coluna,tipo,tamanho,precisao,obrigatorio,chave,ini,aliasColuna,repositorio,tabRepos,chaveRepos);
			  
			  //NÃO APAGAR-> usar para debugar
//			  System.out.println("---Dados retirados do Bean carregado---");			  
//			  System.out.println("coluna="+registros.getColuna());
//			  System.out.println("tipo="+registros.getTipo());
//			  System.out.println("tamanho="+registros.getTamanho());
//			  System.out.println("precisao="+registros.getPrecisao());
//			  System.out.println("obrigatorio="+registros.getObrigatorio());
//			  System.out.println("chave="+registros.getChave());
//			  System.out.println("ini="+registros.getIni());
//			  System.out.println("aliasColuna="+registros.getNomeColuna());
//			  System.out.println("repositorio="+registros.getRepositorio());
//			  System.out.println("tabRepos="+registros.getTabRepos());
//			  System.out.println("chaveRepos="+registros.getChaveRepos());
//			  System.out.println("");
			  
			  // adiciona o Registro na coleção de Registros
			  vRegistros.addElement( registros );
		   }//for

       }//if    
    }//for

    return vRegistros;
  }//lerRegistros
  
  // retorna o vector contendo as Tabelas no XML.
  public String[] lerTabelas() throws Exception {
	
	System.out.println("lendo a relação de tabelas no XML...");
	
	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	DocumentBuilder db = dbf.newDocumentBuilder();
	Document doc = db.parse( xmlPathname );

	Element elem = doc.getDocumentElement();
	// pega todos os elementos tabela do XML
	NodeList nlContexto = elem.getElementsByTagName("tabela");
	String tabela;
	Vector vTabelas = new Vector();
	// percorre cada elemento "tabela" encontrado
	System.out.println("Qtd de tabelas->"+nlContexto.getLength());
	for(int i=0;i<nlContexto.getLength();i++) {
	   Element tagContexto = (Element)nlContexto.item(i);
	   tabela = tagContexto.getAttribute("nometab");  
	   // adiciona a tabela  no array de tabelas
	   vTabelas.addElement(tabela);    
	}//for
	String[] tabelas = new String[vTabelas.size()];
	vTabelas.copyInto(tabelas);
	System.out.println("Carregou o vetor com "+tabelas.length+" tabelas");
	return tabelas;
  }//lerTabelas

  // le o XML carregando os dados dos Registros em um Vector.
  // retorna o vector contendo os Registros no XML.
  public Hashtable lerVariaveis(String nomeTabela) throws Exception {
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();
    Document doc = db.parse( xmlPathname );
    Element elem = doc.getDocumentElement();
    // pega todos os elementos tabela do XML
    NodeList nlTab = elem.getElementsByTagName("tabela");

    Hashtable hVariaveis = new Hashtable();
    System.out.println("entrou no Hashtable="+nlTab.getLength());
    // percorre cada elemento "tabela" encontrado
    for(int i=0;i<nlTab.getLength();i++) {
	   Element tagTabela = (Element) nlTab.item(i);
       System.out.println("entrou no for="+i);
	   // só pega se for a tabela passada no parametro
	   if(tagTabela.getAttribute("nometab").equals(nomeTabela)){
		   String nomeBean = getChildTagValue( tagTabela, "nomeBean" );
			hVariaveis.put("nomeBean",nomeBean );
		   String nomeDAO = getChildTagValue( tagTabela, "nomeDAO" );
		   hVariaveis.put("nomeDAO",nomeDAO );
		   String nomeDB = getChildTagValue( tagTabela, "nomeDB" );
		   hVariaveis.put("nomeDB",nomeDB );
		   String nomeServletAtualizacao = getChildTagValue( tagTabela,"nomeServletAtualizacao" );
		   hVariaveis.put("nomeServletAtualizacao",nomeServletAtualizacao );
		   String nomeServletConsulta = getChildTagValue( tagTabela,"nomeServletConsulta" );
		   hVariaveis.put("nomeServletConsulta",nomeServletConsulta );
			String nomeServletExclusao = getChildTagValue( tagTabela,"nomeServletExclusao" );
		   hVariaveis.put("nomeServletExclusao",nomeServletExclusao );
			String nomeServletInclusao = getChildTagValue( tagTabela,"nomeServletInclusao" );
		   hVariaveis.put("nomeServletInclusao",nomeServletInclusao );
			String nomeConsultaHtml = getChildTagValue( tagTabela,"nomeConsultaHtml" );
		   hVariaveis.put("nomeConsultaHtml",nomeConsultaHtml );
			String nomeGrid_Detalhe = getChildTagValue( tagTabela,"nomeGrid_Detalhe" );
		   hVariaveis.put("nomeGrid_Detalhe",nomeGrid_Detalhe );
			String nomeGrid_Campos = getChildTagValue( tagTabela,"nomeGrid_Campos" );
		   hVariaveis.put("nomeGrid_Campos",nomeGrid_Campos );
			String nomeArquivoBean = getChildTagValue( tagTabela,"nomeArquivoBean" );
		   hVariaveis.put("nomeArquivoBean",nomeArquivoBean );
			String nomeArquivoDAO = getChildTagValue( tagTabela,"nomeArquivoDAO" );
		   hVariaveis.put("nomeArquivoDAO",nomeArquivoDAO );
			String nomeArquivoDB = getChildTagValue( tagTabela,"nomeArquivoDB" );
		   hVariaveis.put("nomeArquivoDB",nomeArquivoDB );
			String nomeArquivoServletAtualizacao = getChildTagValue( tagTabela,"nomeArquivoServletAtualizacao");
		   hVariaveis.put("nomeArquivoServletAtualizacao",nomeArquivoServletAtualizacao );
			String nomeArquivoServletConsulta = getChildTagValue( tagTabela,"nomeArquivoServletConsulta");
		   hVariaveis.put("nomeArquivoServletConsulta",nomeArquivoServletConsulta );
			String nomeArquivoServletExclusao = getChildTagValue( tagTabela,"nomeArquivoServletExclusao");
		   hVariaveis.put("nomeArquivoServletExclusao",nomeArquivoServletExclusao );
			String nomeArquivoServletInclusao = getChildTagValue( tagTabela,"nomeArquivoServletInclusao");
		   hVariaveis.put("nomeArquivoServletInclusao",nomeArquivoServletInclusao );
			String nomeArquivoConsultaHtml = getChildTagValue( tagTabela,"nomeArquivoConsultaHtml");
		   hVariaveis.put("nomeArquivoConsultaHtml",nomeArquivoConsultaHtml );
		   
		   String nomeArquivoMenuPrincJsp = getChildTagValue( tagTabela,"nomeArquivoMenuPrincJsp");
		   hVariaveis.put("nomeArquivoMenuPrincJsp",nomeArquivoMenuPrincJsp );
		   
		   String nomeArquivoMenu_princJsp = getChildTagValue( tagTabela,"nomeArquivoMenu_princJsp");
		   hVariaveis.put("nomeArquivoMenu_princJsp",nomeArquivoMenu_princJsp );
		   
			String nomeArquivoGrid_Detalhe = getChildTagValue( tagTabela,"nomeArquivoGrid_Detalhe");
		   hVariaveis.put("nomeArquivoGrid_Detalhe",nomeArquivoGrid_Detalhe );
			String nomeArquivoGrid_Campos = getChildTagValue( tagTabela,"nomeArquivoGrid_Campos");
		   hVariaveis.put("nomeArquivoGrid_Campos",nomeArquivoGrid_Campos );
			String nomeArquivoBuildFile = getChildTagValue(tagTabela,"nomeArquivoBuildFile");
		   hVariaveis.put("nomeArquivoBuildFile",nomeArquivoBuildFile);
			String nomeArquivoWebXmlFile = getChildTagValue(tagTabela,"nomeArquivoWebXmlFile");
		   hVariaveis.put("nomeArquivoWebXmlFile",nomeArquivoWebXmlFile);
		 }//if    
    }//for
    return hVariaveis;
  }//lerVariaveis

  // este método lê e retorna o conteúdo (texto) de uma tag (elemento)
  // filho da tag informada como parâmetro. A tag filho a ser pesquisada
  // é a tag informada pelo nome (string)
  private String getChildTagValue( Element elem, String tagName ) throws Exception {
    NodeList children = elem.getElementsByTagName(tagName);
    if(children == null) return null;
    Element child = (Element) children.item(0);
    if(child == null) return null;
		return child.getFirstChild().getNodeValue();
  }
}