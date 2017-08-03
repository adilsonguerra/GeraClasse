package com.warsys.geraclasse.classes;

import com.warsys.geraclasse.bean.Registros;

public class GeraArqMenu_princJsp {

   boolean geracao_ok = false;
   
   public GeraArqMenu_princJsp(String nomeJsp,String nomeEmpSist, Registros[] regConvertido){
         
         System.out.println("----------------------------------------------------");
         System.out.println("Estou no GeraArqMenu_princJsp, recebi o parametro->"+nomeJsp);
         System.out.println("Valor na variavel GeraClasse.nomeBean->"+GeraClasse.nomeBean);

         try{
            Arquivo a = new Arquivo(GeraClasse.nomeBean);
            a.criar(nomeJsp);

            a.escrever("",0);
            a.escrever("<!DOCTYPE HTML PUBLIC "+'\"'+"-//W3C//DTD HTML 4.0 Transitional//EN"+'\"'+">",0);
            a.escrever("<HTML>",0);
            a.escrever("<link rel="+'\"'+"stylesheet"+'\"'+" href="+'\"'+"../folha.css"+'\"'+" type="+'\"'+"text/css"+'\"'+">",0);
            a.escrever("<script> language="+'\"'+"javascript"+'\"'+"",0);
            a.escrever("	function icone(num){",0);	
            a.escrever("		 var qtd = document.images.length;",0);
            a.escrever("		 for(i=3;i<qtd;i++){document.images[i].src="+'\"'+"imagens/arrowbr.gif"+'\"'+"};",0);
            a.escrever("		 document.images[num].src="+'\"'+"imagens/arrowr.gif"+'\"'+";",0);
            a.escrever("	}",0);
            a.escrever("</script>",0);
            a.escrever("<script language="+'\"'+"JavaScript"+'\"'+">",0);
            a.escrever("   function vai(url,janela){",0);
            a.escrever("      window.open('html/apresentacao.html','grid','status=no');",0);
            a.escrever("      open(url,janela);",0);
            a.escrever("   }",0);
            a.escrever("</script>",0);
            a.escrever("<BODY>",0);
            a.escrever("<BR>",0);
            a.escrever("<BR>",0);
            a.escrever("<table align="+'\"'+"center"+'\"'+" ></tr><FONT SIZE=2 COLOR="+'\"'+"#9da1c9"+'\"'+" FACE="+'\"'+"Verdana, Arial"+'\"'+"><B>TABELAS</B></FONT><tr></table>",0);
            a.escrever("<table align="+'\"'+"center"+'\"'+" class="+'\"'+"contorno"+'\"'+">",0);
            a.escrever("<BR>",0);
            a.escrever("<tr>",0);
            a.escrever("<td>",0);
            a.escrever("	<table  align="+'\"'+"center"+'\"'+" cellspacing=2>",0);
            a.escrever("	<tr>",0);
            a.escrever("         <td background="+'\"'+"../imagens/menudgd_ai.bmp"+'\"'+" class="+'\"'+"menu_princ2"+'\"'+"  width="+'\"'+"20"+'\"'+" nowrap align="+'\"'+"center"+'\"'+" >",0);
            a.escrever("         <a href="+'\"'+"Consultar" + GeraClasse.nomeBean + ".jsp"+'\"'+" target="+'\"'+"grid"+'\"'+">" + GeraClasse.nomeBean + "</td>",0);
            a.escrever(" 	</table>",0);
            a.escrever("</td>",0);
            a.escrever("</tr>",0);
            a.escrever("</table>",0);
            a.escrever("<BR>",0);
            a.escrever("<BR>",0);
            a.escrever("<BR>",0);
            a.escrever("</BODY>",0);
            a.escrever("</HTML>",0);
               
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
