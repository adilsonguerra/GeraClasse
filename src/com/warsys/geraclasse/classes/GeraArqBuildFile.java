package com.warsys.geraclasse.classes;

import com.warsys.geraclasse.bean.Registros;

public class GeraArqBuildFile {
   
   boolean geracao_ok = false;
   
   public GeraArqBuildFile(String nomeBuildFile,String nomeEmpSist){

         try{            
            String empresa =  nomeEmpSist.replace('.','/');
            Arquivo a = new Arquivo("");
            a.criar(nomeBuildFile);

			a.escrever("<?xml version="+ '\"'+"1.0"+ '\"'+" encoding="+ '\"'+"iso-8859-1"+ '\"'+" ?>",0);
            a.escrever("",0);
            a.escrever("<project default="+ '\"'+"carrega_arqs"+ '\"'+" basedir="+ '\"'+"."+ '\"'+" >",0);
            a.escrever("",0);
            a.escrever("   <property name="+ '\"'+"app.home"+ '\"'+" value="+ '\"'+ "C:/"+ empresa + '\"'+" />",0);
            a.escrever("",0);
            a.escrever("   <target name="+ '\"'+"monta_pastas"+'\"'+">",0);
            a.escrever("      <mkdir dir="+ '\"'+"${app.home}/src/com/warsys/base"+ '\"'+"/>",0);
            a.escrever("      <mkdir dir="+ '\"'+"${app.home}/src/com/warsys/"+empresa+"/bean"+ '\"'+"/>",0);
            a.escrever("      <mkdir dir="+ '\"'+"${app.home}/src/com/warsys/"+empresa+"/dao"+ '\"'+"/>",0);
            a.escrever("      <mkdir dir="+ '\"'+"${app.home}/src/com/warsys/"+empresa+"/db"+ '\"'+"/>",0);
            a.escrever("      <mkdir dir="+ '\"'+"${app.home}/src/com/warsys/"+empresa+"/servlets"+ '\"'+"/>",0);
            a.escrever("      <mkdir dir="+ '\"'+"${app.home}/src/com/warsys/util"+ '\"'+"/>",0);
            a.escrever("      <mkdir dir="+ '\"'+"${app.home}/WebContent"+ '\"'+"/>",0);
            a.escrever("      <mkdir dir="+ '\"'+"${app.home}/WebContent/html"+ '\"'+"/>",0);
            a.escrever("      <mkdir dir="+ '\"'+"${app.home}/WebContent/imagens"+ '\"'+"/>",0);
            a.escrever("      <mkdir dir="+ '\"'+"${app.home}/WebContent/jsp"+ '\"'+"/>",0);
            a.escrever("      <mkdir dir="+ '\"'+"${app.home}/WebContent/META-INF"+ '\"'+"/>",0);
            a.escrever("      <mkdir dir="+ '\"'+"${app.home}/WebContent/WEB-INF"+ '\"'+"/>",0);
            a.escrever("      <mkdir dir="+ '\"'+"${app.home}/WebContent/WEB-INF/classes"+ '\"'+"/>",0);
            a.escrever("   </target>",0);
            
            a.escrever("",0);
            
            a.escrever("   <target name="+ '\"'+"carrega_arqs"+ '\"'+" depends="+ '\"'+"monta_pastas"+ '\"'+">",0);       
            
            a.escrever("   <move todir="+'\"'+"${app.home}/src/com/warsys/base"+'\"'+">",0);
            a.escrever("      <fileset dir="+'\"'+"."+'\"'+"><filename name="+'\"'+"BaseDAO.java"+'\"'+"/></fileset>",0);
            a.escrever("   </move>",0);            

            a.escrever("   <move todir="+'\"'+"${app.home}/src/com/warsys/"+empresa+"/dao"+'\"'+">",0);
            a.escrever("      <fileset dir="+'\"'+"."+'\"'+"><filename name="+'\"'+"*DAO.java"+'\"'+"/></fileset>",0);
            a.escrever("   </move>",0);            

            a.escrever("   <move todir="+'\"'+"${app.home}/src/com/warsys/"+empresa+"/db"+'\"'+">",0);
            a.escrever("      <fileset dir="+'\"'+"."+'\"'+"><filename name="+'\"'+"*DB.java"+'\"'+"/></fileset>",0);
            a.escrever("   </move>",0);            

            a.escrever("   <move todir="+'\"'+"${app.home}/src/com/warsys/"+empresa+"/servlets"+'\"'+">",0);
            a.escrever("      <fileset dir="+'\"'+"."+'\"'+"><filename name="+'\"'+"*Servlet.java"+'\"'+"/></fileset>",0);
            a.escrever("   </move>",0);            

            a.escrever("   <move todir="+'\"'+"${app.home}/src/com/warsys/"+empresa+"/bean"+'\"'+">",0);
            a.escrever("      <fileset dir="+'\"'+"."+'\"'+"><filename name="+'\"'+"*.java"+'\"'+"/></fileset>",0);
            a.escrever("   </move>",0);            

            a.escrever("   <move todir="+'\"'+"${app.home}/WebContent/WEB-INF"+'\"'+">",0);
            a.escrever("      <fileset dir="+'\"'+"."+'\"'+"><filename name="+'\"'+"web.xml*"+'\"'+"/></fileset>",0);
            a.escrever("   </move>",0);  
            
            a.escrever("   <move file="+'\"'+"${app.home}/WebContent/WEB-INF/web.xml_"+ GeraClasse.nomeBean +'\"'+ " tofile="+'\"'+"${app.home}/WebContent/WEB-INF/web.xml"+'\"'+"/>",0);

            a.escrever("   <move todir="+'\"'+"${app.home}/WebContent/jsp"+'\"'+">",0);
            a.escrever("      <fileset dir="+'\"'+"."+'\"'+"><filename name="+'\"'+"*.jsp"+'\"'+"/></fileset>",0);
            a.escrever("   </move>",0);            

            a.escrever("   <copy todir="+'\"'+"${app.home}/WebContent/"+'\"'+">",0);
            a.escrever("      <fileset dir="+'\"'+"${app.home}/WebContent/jsp"+'\"'+"><filename name="+'\"'+"Grid_Campos"+GeraClasse.nomeBean+".jsp"+'\"'+"/></fileset>",0);
            a.escrever("   </copy>",0);            
           
            a.escrever("   <copy todir="+'\"'+"${app.home}/WebContent/jsp"+'\"'+">",0);
            a.escrever("      <fileset dir="+'\"'+"../TEMPLATE/jsp"+'\"'+"><filename name="+'\"'+"*.jsp"+'\"'+"/></fileset>",0);
            a.escrever("   </copy>",0);            

            a.escrever("   <copy todir="+'\"'+"${app.home}/WebContent/imagens"+'\"'+">",0);
            a.escrever("      <fileset dir="+'\"'+"../TEMPLATE/imagens"+'\"'+"><filename name="+'\"'+"*.*"+'\"'+"/></fileset>",0);
            a.escrever("   </copy>",0);            

            a.escrever("   <copy todir="+'\"'+"${app.home}/WebContent/html"+'\"'+">",0);
            a.escrever("      <fileset dir="+'\"'+"../TEMPLATE/html"+'\"'+"><filename name="+'\"'+"*.*"+'\"'+"/></fileset>",0);
            a.escrever("   </copy>",0);            

            a.escrever("   <copy todir="+'\"'+"${app.home}/src/com/warsys/util"+'\"'+">",0);
            a.escrever("      <fileset dir="+'\"'+"../src/com/warsys/util"+'\"'+"><filename name="+'\"'+"*.*"+'\"'+"/></fileset>",0);
            a.escrever("   </copy>",0);            
            
            a.escrever("   <copy todir="+'\"'+"${app.home}/WebContent"+'\"'+">",0);
            a.escrever("      <fileset dir="+'\"'+"../TEMPLATE/css"+'\"'+"><filename name="+'\"'+"*.*"+'\"'+"/></fileset>",0);
            a.escrever("   </copy>",0);            

            a.escrever("   <copy todir="+'\"'+"${app.home}/WebContent/META-INF"+'\"'+">",0);
            a.escrever("      <fileset dir="+'\"'+"../TEMPLATE/META-INF"+'\"'+"><filename name="+'\"'+"*.*"+'\"'+"/></fileset>",0);
            a.escrever("   </copy>",0);            

            a.escrever("   <copy todir="+'\"'+"${app.home}/src/com/warsys/base"+'\"'+">",0);
            a.escrever("      <fileset dir="+'\"'+"../src/com/warsys/base"+'\"'+"><filename name="+'\"'+"*.*"+'\"'+"/></fileset>",0);
            a.escrever("   </copy>",0);            
           
            a.escrever("   <move todir="+'\"'+"${app.home}/WebContent"+'\"'+">",0);
            a.escrever("      <fileset dir="+'\"'+"${app.home}/WebContent/jsp"+'\"'+"><filename name="+'\"'+"index.jsp"+'\"'+"/></fileset>",0);
            a.escrever("   </move>",0);            

            a.escrever("   <move todir="+'\"'+"${app.home}/WebContent"+'\"'+">",0);
            a.escrever("      <fileset dir="+'\"'+"."+'\"'+"><filename name="+'\"'+"build_prj.xml"+'\"'+"/></fileset>",0);
            a.escrever("   </move>",0);            
           
            a.escrever("</target>",0);
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