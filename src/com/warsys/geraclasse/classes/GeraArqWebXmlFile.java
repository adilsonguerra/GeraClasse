package com.warsys.geraclasse.classes;

import com.warsys.geraclasse.bean.Registros;

public class GeraArqWebXmlFile {
   
   boolean geracao_ok = false;
   
   public GeraArqWebXmlFile(String nomeWebXmlFile,String nomeEmpSist, Registros[] regConvertido){

         try{
            Arquivo a = new Arquivo(GeraClasse.nomeBean);
            a.criar(nomeWebXmlFile + "_"+ GeraClasse.nomeBean);
            a.escrever("<?xml version="+ '\"'+"1.0"+ '\"'+" encoding="+ '\"'+"ISO-8859-1"+ '\"'+"?>",0);
            a.escrever("",0);
            a.escrever("<!DOCTYPE web-app",0);
            a.escrever("    PUBLIC "+ '\"'+"-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"+ '\"'+"",0);
            a.escrever("    "+ '\"'+"http://java.sun.com/dtd/web-app_2_3.dtd"+ '\"'+">",0);
            a.escrever("",0);
            a.escrever("<web-app>",0);
            a.escrever("",0);
            a.escrever("   <context-param>",0);
            a.escrever("      <param-name>contexto</param-name>",0);
            a.escrever("      <param-value>Coloque aqui o nome do contexto</param-value>",0);
            a.escrever("      <description></description>",0);
            a.escrever("   </context-param>",0);
            a.escrever("   <context-param>",0);
            a.escrever("      <param-name>qtdLinhasPg</param-name>",0);
            a.escrever("      <param-value>20</param-value>",0);
            a.escrever("      <description>Qtd de linha mostradas no grid</description>",0);
            a.escrever("   </context-param>",0);
            a.escrever("",0);
            a.escrever("<!--"+GeraClasse.nomeBean+"-->",0);                 
            a.escrever("   <servlet>",0);
            a.escrever("      <servlet-name>Insere"+GeraClasse.nomeBean+"</servlet-name>",0);
            a.escrever("      <servlet-class>com.warsys."+nomeEmpSist+".servlets.Insere"+GeraClasse.nomeBean+"Servlet</servlet-class>",0);
            a.escrever("   </servlet>",0);
            a.escrever("   <servlet>",0);
            a.escrever("      <servlet-name>Exclui"+GeraClasse.nomeBean+"</servlet-name>",0);
            a.escrever("      <servlet-class>com.warsys."+nomeEmpSist+".servlets.Exclui"+GeraClasse.nomeBean+"Servlet</servlet-class>",0);
            a.escrever("   </servlet>",0);
            a.escrever("   <servlet>",0);
            a.escrever("      <servlet-name>Atualiza"+GeraClasse.nomeBean+"</servlet-name>",0);
            a.escrever("      <servlet-class>com.warsys."+nomeEmpSist+".servlets.Atualiza"+GeraClasse.nomeBean+"Servlet</servlet-class>",0);
            a.escrever("   </servlet>",0);
            a.escrever("   <servlet>",0);
            a.escrever("      <servlet-name>Consulta"+GeraClasse.nomeBean+"</servlet-name>",0);
            a.escrever("      <servlet-class>com.warsys."+nomeEmpSist+".servlets.Consulta"+GeraClasse.nomeBean+"Servlet</servlet-class>",0);
            a.escrever("   </servlet>",0);
            a.escrever("",0);
            a.escrever("<!--"+GeraClasse.nomeBean+"-->",0);
            a.escrever("   <servlet-mapping>",0);
            a.escrever("      <servlet-name>Insere"+GeraClasse.nomeBean+"</servlet-name>",0);
            a.escrever("      <url-pattern>/Inc"+GeraClasse.nomeBean+"</url-pattern>",0);
            a.escrever("   </servlet-mapping>",0);
            a.escrever("   <servlet-mapping>",0);
            a.escrever("      <servlet-name>Exclui"+GeraClasse.nomeBean+"</servlet-name>",0);
            a.escrever("      <url-pattern>/Exc"+GeraClasse.nomeBean+"</url-pattern>",0);
            a.escrever("   </servlet-mapping>",0);
            a.escrever("   <servlet-mapping>",0);
            a.escrever("      <servlet-name>Atualiza"+GeraClasse.nomeBean+"</servlet-name>",0);
            a.escrever("      <url-pattern>/Atu"+GeraClasse.nomeBean+"</url-pattern>",0);
            a.escrever("   </servlet-mapping>",0);
            a.escrever("   <servlet-mapping>",0);
            a.escrever("      <servlet-name>Consulta"+GeraClasse.nomeBean+"</servlet-name>",0);
            a.escrever("      <url-pattern>/Con"+GeraClasse.nomeBean+"</url-pattern>",0);
            a.escrever("   </servlet-mapping>",0);
            a.escrever("",0);
            a.escrever("</web-app>",0);
            a.escrever("",0);
            a.fechar();

            geracao_ok = true;
      }//try
      catch (Exception e) {
         System.out.println("Erro:" + e.getMessage());
         geracao_ok = false;
      }
   }//construtor

   public boolean arquivo_gerado(){
      return this.geracao_ok;
   }

}//classe