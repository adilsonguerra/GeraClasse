package com.warsys.geraclasse.classes;

import com.warsys.geraclasse.bean.Registros;

public class GeraArqBuildPrjFile {
   
   boolean geracao_ok = false;
   
   public GeraArqBuildPrjFile(String nomeEmpSist){
	   
	   String tomcatHome = System.getenv().get("CATALINA_HOME");

         try{            
            String empresa =  nomeEmpSist.replace('.','/');
            Arquivo a = new Arquivo("");
            a.criar("build_prj.xml");

            a.escrever("<?xml version="+ '\"'+"1.0"+ '\"'+" encoding="+ '\"'+"iso-8859-1"+ '\"'+" ?>",0);
            a.escrever("<!-- Careega toda a estrutura para o tomcat -->",0);
            a.escrever("<project default="+ '\"'+"carrega_tomcat"+ '\"'+" basedir="+ '\"'+"."+ '\"'+" >",0);
            a.escrever("",0);
            a.escrever("   <property name="+ '\"'+"app.home"+ '\"'+" value="+ '\"'+"C:/"+empresa+ '\"'+" />",0);
            a.escrever("   <property name="+ '\"'+"app.name"+ '\"'+" value="+ '\"'+nomeEmpSist.substring(nomeEmpSist.lastIndexOf(".")+1) + '\"'+" />",0);
            a.escrever("   <property name="+ '\"'+"tomcat.home"+ '\"'+" value="+ '\"'+ tomcatHome + '\"'+" />",0);
            a.escrever("   <property name="+ '\"'+"deploy.home"+ '\"'+" value="+ '\"'+"${tomcat.home}/webapps/${app.name}"+ '\"'+" />",0);
            a.escrever("",0);  
            a.escrever("   <target name="+ '\"'+"carrega_tomcat"+ '\"'+">",0);
            a.escrever("      <delete dir="+ '\"'+"${deploy.home}"+ '\"'+"/>",0);
            a.escrever("      <copy todir="+ '\"'+"${deploy.home}"+ '\"'+">  <fileset dir ="+ '\"'+"."+ '\"' +"/> </copy>",0);        
            a.escrever("      <!--<move file="+ '\"'+"${deploy.home}/WEB-INF/web.xml_"+ GeraClasse.nomeBean + '\"'+" tofile="+ '\"'+"${deploy.home}/WEB-INF/web.xml"+ '\"'+"/>-->",0);
            a.escrever("      <delete file="+ '\"'+"${deploy.home}/build_prj.xml"+ '\"'+"/>",0);         
            a.escrever("      <copy todir="+ '\"'+"${deploy.home}/WEB-INF/classes"+ '\"'+">  <fileset dir ="+ '\"'+"${app.home}/build/classes"+ '\"'+"/> </copy>",0);
            a.escrever("   </target>",0);
            a.escrever("</project>",0);
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