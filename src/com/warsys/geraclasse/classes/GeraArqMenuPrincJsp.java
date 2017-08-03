package com.warsys.geraclasse.classes;

import com.warsys.geraclasse.bean.Registros;

public class GeraArqMenuPrincJsp {
   
   boolean geracao_ok = false;
   
   public GeraArqMenuPrincJsp(String nomeJsp,String nomeEmpSist, Registros[] regConvertido){

         boolean temCampoData = false;
         String aux="";
         char chave = ' ';
         System.out.println("----------------------------------------------------");
         System.out.println("Estou no GeraArqMenuPrincJsp, recebi o parametro->"+nomeJsp);
         System.out.println("Valor na variavel GeraClasse.nomeBean->"+GeraClasse.nomeBean);

         try{
            Arquivo a = new Arquivo(GeraClasse.nomeBean);
            a.criar(nomeJsp);

            a.escrever("",0);
            
            boolean flag =false;

            //Loop para para colocar os "@ page import"
            
            for(int i=0;i<regConvertido.length;i++){
               
               //System.out.println("criarConsultaJsp->"+regConvertido[i].getRepositorio());
               System.out.println("coluna->"+regConvertido[i].getColuna());
               
               
               if (!regConvertido[i].getRepositorio().equals("null")){
                  System.out.println("entrou no 1 if");
                  flag =true;
                  String classeRep=GeraClasse.plm(regConvertido[i].getRepositorio().toLowerCase());               
                  a.escrever("<%@ page import="+'\"'+"com.warsys."+nomeEmpSist+".bean."+classeRep+'\"'+"%>",0);
                  a.escrever("<%@ page import="+'\"'+"com.warsys."+nomeEmpSist+".db."+classeRep+"DB"+'\"'+"%>",0);
               }
            
            }

            
            
            //Para criar somente uma vez a linha <%@ page import="java.sql.SQLException"%>"
            if (flag==true){
               a.escrever("<%@ page import="+'\"'+"java.sql.SQLException"+'\"'+"%>",0);
               a.escrever("",0);
               a.escrever("<%",0);
            }


            //Loop para para colocar instancias das classes
            for(int i=0;i<regConvertido.length;i++){           
               if (!regConvertido[i].getRepositorio().equals("null")){  
                  flag=true;
                  String classeRep=GeraClasse.plm(regConvertido[i].getRepositorio().toLowerCase());
                  a.escrever("   "+classeRep+"DB db"+classeRep+" = new "+classeRep+"DB();",0);
                  a.escrever("   "+classeRep+"[] "+classeRep.toLowerCase()+" = ("+classeRep+"[])db"+classeRep+".get"+classeRep+"s(); ",0);
               }
            }

            if (flag==true){
               a.escrever("%>",0);
            }
            
            flag=false;
            
            a.escrever("<script language="+'\"'+"JavaScript"+'\"'+">",0);
            a.escrever("",0);

            a.escrever("function cmdLogin_onclick(opcao) ",0);
            a.escrever("{",0);
            
            a.escrever("   if (",1);
            aux="";
            for(int i=0;i<regConvertido.length;i++){
               if(regConvertido[i].getChave().equals("S")){               
                     if(aux !=""){
                        a.escrever(aux,1);   
                     }
                     aux = "frmForm1."+regConvertido[i].getColuna().toLowerCase()+".value=="+'\"'+""+'\"'+"||";
               }
            }
            a.escrever(aux.substring(0,aux.length()-2),1);           
            a.escrever("){",0);
            a.escrever("      if (confirm ("+'\"'+"Você não especificou o registro. Deseja trazer todos?"+'\"'+")) {",0);
            a.escrever("         window.status = "+'\"'+"Aguarde processamento..."+'\"'+";",0);
            a.escrever("         frmForm1.action =opcao;",0);
            a.escrever("         frmForm1.submit();",0);
            a.escrever("         window.status = "+'\"'+""+'\"'+";",0);
            a.escrever("      } ",0);
            a.escrever("      else { ",0);
            a.escrever("         return false;",0);
            a.escrever("      }",0);
            a.escrever("   }else{",0);
            a.escrever("   if (",1);
            aux="";
            for(int i=0;i<regConvertido.length;i++){
               if(regConvertido[i].getChave().equals("S")){               
                     if(aux !=""){
                        a.escrever(aux,1);   
                     }
                     aux = "frmForm1."+regConvertido[i].getColuna().toLowerCase()+".value=="+'\"'+""+'\"'+"||";
               }
            }
            a.escrever(aux.substring(0,aux.length()-2),1);  
            a.escrever("){",0);
            a.escrever("         if (confirm ("+'\"'+"Você não especificou o registro. Deseja trazer todos?"+'\"'+")) {",0);
            a.escrever("            window.status = "+'\"'+"Aguarde processamento..."+'\"'+";",0);
            a.escrever("            frmForm1.action =opcao;",0);
            a.escrever("            frmForm1.submit();",0);
            a.escrever("            window.status = "+'\"'+""+'\"'+";",0);
            a.escrever("         }else {",0);
            a.escrever("            return false;",0);
            a.escrever("         }//else",0);
            a.escrever("       }",0);
            a.escrever("       window.status = "+'\"'+"Aguarde processamento..."+'\"'+";",0);
            a.escrever("       frmForm1.action =opcao;",0);
            a.escrever("       frmForm1.submit();",0);
            a.escrever("       window.status = "+'\"'+""+'\"'+";",0);
            a.escrever("   }",0);   
            a.escrever("",0);    
            a.escrever("}//function",0);
            a.escrever("",0);
            a.escrever("</script>",0);
            a.escrever("",0);
            a.escrever("<HTML>",0);
            a.escrever("<link rel="+'\"'+"stylesheet"+'\"'+" href="+'\"'+"../pstats.css"+'\"'+" type="+'\"'+"text/css"+'\"'+">",0);
            a.escrever("<HEAD><TITLE>Consulta </TITLE></HEAD>",0);
            a.escrever("<BODY class=fundo4 topmargin=0>",0);
            a.escrever("",0);
            a.escrever("<FORM name=frmForm1 action="+'\"'+""+'\"'+" method=post>",0); 
            a.escrever("",0);      
         
            a.escrever("    <table width="+'\"'+"100%"+'\"'+">",0);
            a.escrever("    <tr>",0);
            
            a.escrever("    <td  style="+'\"'+"FONT-WEIGHT:bold; FONT-SIZE:14;FONT-STYLE: normal; COLOR:#EA915B ; FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif"+'\"'+" nowrap=0 align=center width="+'\"'+"100%"+'\"'+">"+GeraClasse.nomeBean.toUpperCase()+"</td>",0);
            a.escrever("    </tr>",0);
            a.escrever("    </table>",0);
            a.escrever("",0);
            a.escrever("    <table >",0);
            a.escrever("    <tr>",0);
                     
            //Botão novo
            a.escrever("        <td><IMG style="+'\"'+"CURSOR: hand"+'\"'+" border=0 SRC="+'\"'+"../imagens/btn_consultar.bmp"+'\"'+" onclick="+'\"'+"return cmdLogin_onclick('../Con"+GeraClasse.nomeBean+"')"+'\"'+" onMouseOver="+'\"'+"document.images[0].src='../imagens/btn_consultar_on.bmp'"+'\"'+" onMouseOut="+'\"'+"document.images[0].src='../imagens/btn_consultar.bmp'"+'\"'+"></td>",0);
            a.escrever("        <td><IMG style="+'\"'+"CURSOR: hand"+'\"'+" border=0 SRC="+'\"'+"../imagens/btn_incluir.bmp"+'\"'+"onclick="+'\"'+" return cmdLogin_onclick('../Inc"+GeraClasse.nomeBean+"')"+'\"'+" onMouseOver="+'\"'+"document.images[1].src='../imagens/btn_incluir_on.bmp'"+'\"'+" onMouseOut="+'\"'+"document.images[1].src='../imagens/btn_incluir.bmp'"+'\"'+"></td>",0);
         
            a.escrever("      <td nowrap=0 align="+'\"'+"right"+'\"'+" width="+'\"'+"100%"+'\"'+" class=aviso >(*) Preenchimento obrigatório</td>",0);
            a.escrever("   </tr>",0);
            a.escrever("   </table>",0);
            a.escrever("   <BR>",0);
            a.escrever("   <table>",0);
         // a.escrever("      <tr>",0); 

            
            for(int i=0;i<regConvertido.length;i++){

               if(regConvertido[i].getObrigatorio().equals("S")){  
                     chave = '*';
               }else{
                     chave = ' ';
               }
               
               //Quebra linha a cada 4 campos

               if (i%4==0 && i>0){
                  a.escrever("      </tr>",0);
                  a.escrever("   </table>",0);

               }

               if (i%4==0){
                  a.escrever("   <table>",0);
                  a.escrever("      <tr>",0);
               }
               
               
               //String nomeLabel=(""+regConvertido[i].getNomeColuna()!=""?regConvertido[i].getColuna():GeraClasse.plm(regConvertido[i].getNomeColuna()));
             
               String nomeLabel;
                              
               if (regConvertido[i].getNomeColuna()==null){
                  nomeLabel=regConvertido[i].getColuna();
               }else{
                  nomeLabel=regConvertido[i].getNomeColuna();
               }
         
               
               if(!regConvertido[i].getRepositorio().equals("null")){

                  String ClsRep = regConvertido[i].getRepositorio()+"";
                  String cod = regConvertido[i].getChaveRepos()+"";
                  String desc = regConvertido[i].getTabRepos()+"";
               
                  a.escrever("         <td class=tituloLabel nowrap=0>"+chave+nomeLabel+":<BR>",0);
                  a.escrever("         <SELECT  NAME="+'\"'+regConvertido[i].getColuna().toLowerCase()+'\"'+" class=combo>",0);
                  a.escrever("         <% for(int i=0;i<"+ClsRep.toLowerCase()+".length;i++){ %> ",0);
                  a.escrever("            <option value="+'\"'+"<%="+ClsRep.toLowerCase()+"[i].get"+GeraClasse.plm(cod)+"()%>"+'\"'+"><%="+ClsRep.toLowerCase()+"[i].get"+GeraClasse.plm(desc)+"()%>",0);
                  a.escrever("         <%}%>",0);
                  a.escrever("         <option value="+'\"'+""+'\"'+" SELECTED>",0);
                  a.escrever("         </SELECT>",0);                         
                  a.escrever("         </td>",0);
               
               
               }else{
                  if(regConvertido[i].getTipo().equals("String")){
                  
                     int tam=Integer.parseInt(regConvertido[i].getPrecisao());                
                     tam=tam<60?tam:60;

                     a.escrever("         <td class=tituloLabel nowrap=0>"+chave+nomeLabel+":<BR>",0);
                     a.escrever("         <INPUT TYPE="+'\"'+"text"+'\"'+" NAME="+'\"'+regConvertido[i].getColuna().toLowerCase()+'\"'+" size="+'\"'+""+tam+""+'\"'+" border="+'\"'+"3"+'\"'+" class="+'\"'+"favoritosEsq"+'\"'+" value="+'\"'+""+'\"'+">",0);
                     a.escrever("         </td>",0);
                  }else{if(regConvertido[i].getTipo().equals("java.sql.Date")){
                           a.escrever("         <td class=tituloLabel nowrap=0>"+chave+nomeLabel+":<BR>",0);
                           a.escrever("         <INPUT TYPE="+'\"'+"text"+'\"'+" NAME="+'\"'+regConvertido[i].getColuna().toLowerCase()+'\"'+" size="+'\"'+""+regConvertido[i].getTamanho()+""+'\"'+" border="+'\"'+"3"+'\"'+" class="+'\"'+"favoritosCen"+'\"'+" value="+'\"'+""+'\"'+">",0);
                           a.escrever("         </td>",0);
                       }else{
                           //Limita os campos numéricos em 13
                           int tam=Integer.parseInt(regConvertido[i].getPrecisao());
                           tam=tam<60?tam:60;
                           a.escrever("         <td class=tituloLabel nowrap=0>"+chave+nomeLabel+":<BR>",0);
                           if(regConvertido[i].getTipo().equals("String")){ 
                              a.escrever("      <INPUT TYPE="+'\"'+"text"+'\"'+" NAME="+'\"'+regConvertido[i].getColuna().toLowerCase()+'\"'+" size="+'\"'+""+tam+""+'\"'+" border="+'\"'+"3"+'\"'+" class="+'\"'+"favoritosEsq"+'\"'+" value="+'\"'+""+'\"'+">",0);
                           }else{
                              a.escrever("      <INPUT TYPE="+'\"'+"text"+'\"'+" NAME="+'\"'+regConvertido[i].getColuna().toLowerCase()+'\"'+" size="+'\"'+""+tam+""+'\"'+" border="+'\"'+"3"+'\"'+" class="+'\"'+"favoritosDir"+'\"'+" value="+'\"'+""+'\"'+">",0);                      
                           }
                           a.escrever("         </td>",0);                   
                       }//(Date)
                  }//(String) 
               }//else
               
               nomeLabel=null;
            }//for

            a.escrever("      </tr>",0);
            a.escrever("   </table>",0);
            a.escrever("   <HR noshade=0>",0);
            a.escrever("    <BR>",0);
            a.escrever("",0);
            a.escrever("</FORM>",0);
            a.escrever("</TBODY>",0);
            a.escrever("</TABLE>",0);
            a.escrever("</TD>",0);
            a.escrever("</TR>",0);
            a.escrever("</TABLE>",0);     
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
