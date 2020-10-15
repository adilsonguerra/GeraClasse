package com.warsys.geraclasse.classes;

import com.warsys.geraclasse.bean.Registros;

public class GeraArqGrid_Campos {
   
   boolean geracao_ok = false;
   
   public GeraArqGrid_Campos(String nomeJsp,String nomeEmpSist, Registros[] regConvertido){

         boolean temCampoData = false;
         String aux="";
         char chave=' ';
         try{
            Arquivo a = new Arquivo(GeraClasse.nomeBean);
            a.criar(nomeJsp);
            
            boolean flag =false;

            //Loop para para colocar os "@ page import"
            
            for(int i=0;i<regConvertido.length;i++){
               
               //System.out.println("criarConsultaJsp->"+regConvertido[i].getRepositorio());
               System.out.println("coluna->"+regConvertido[i].getColuna());
               
               if (!regConvertido[i].getRepositorio().equals("null")){
                  flag =true;
                  String classeRep=GeraClasse.plm((regConvertido[i].getRepositorio().toLowerCase()));               
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
                  String classeRep=GeraClasse.plm((regConvertido[i].getRepositorio().toLowerCase()));
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
            a.escrever("",0);
            a.escrever("function mensagem(mg){",0);
            a.escrever("   alert(mg);",0);   
            a.escrever("}",0);
            a.escrever("",0);
            a.escrever("function CarregaCampos(idImag,",0);
            
            aux="";
            for(int i=0;i<regConvertido.length;i++){           
               if(aux !=""){
                  a.escrever(aux,0);   
               }
               aux = "  C_"+regConvertido[i].getColuna().toUpperCase()+",";
            }
            
            if(aux !=""){
            	a.escrever(aux.substring(0,aux.length()-1),0);
            }           

            a.escrever("   ){",0);

         for(int i=0;i<regConvertido.length;i++){
               //if(regConvertido[i].getTipo()=="java.sql.Date"){
                  //a.escrever(" frmForm1."+regConvertido[i].getColuna().toLowerCase()+".value = C_"+regConvertido[i].getColuna().toUpperCase()+".substring(8,10)+'/'+ C_"+regConvertido[i].getColuna().toUpperCase()+".substring(5,7)+'/'+ C_"+regConvertido[i].getColuna().toUpperCase()+".substring(0,4) ;",0);
               //}else{
                  a.escrever("   frmForm1."+regConvertido[i].getColuna().toLowerCase()+".value = C_"+regConvertido[i].getColuna().toUpperCase()+";",0);
               //}
            }           
            a.escrever("",0); 
            a.escrever("    //habilita o gif que marca a linha selecionada",0);
            a.escrever("    var qtd = document.images.length;",0);
            //a.escrever("    caminho = location.protocol+"+'\"'+"//"+'\"'+"+location.host+"+'\"'+"/"+GeraClasse.nomeBean.toLowerCase()+"/"+'\"'+";",0);
            a.escrever("    caminho = location.protocol+"+'\"'+"//"+'\"'+"+location.host+"+'\"'+"/"+ nomeEmpSist +"/imagens/"+'\"'+";",0);
            a.escrever("",0); 
            a.escrever("//Ignorar os gifs de 0 a 3 pois correspondem aos botões",0);
            a.escrever("num_gif=4;",0);
            a.escrever("idImag=idImag+num_gif;",0);
            a.escrever("",0);
            a.escrever("//Limpa os gifs",0);
            a.escrever("    for(i=num_gif;i < qtd;i++){",0);
            a.escrever("",0); 
            a.escrever("      if (document.images[i].src.toLowerCase()==caminho+"+'\"'+"arrowrmenu.gif"+'\"'+"){",0);
            a.escrever("         document.images[i].src="+'\"'+"imagens/arrowbr.gif"+'\"'+";",0);
            a.escrever("      }",0);
            a.escrever("    }",0);  
            a.escrever("",0);
            a.escrever("   if (qtd>=num_gif){",0);
            a.escrever("      document.images[idImag].src="+'\"'+"imagens/arrowrmenu.gif"+'\"'+";",0);
            a.escrever("   }",0);
               
            a.escrever("}",0);
            a.escrever("",0);
         
            a.escrever("function cmdLogin_onclick(opcao)",0); 
            a.escrever("{",0);
            a.escrever("",0); 

            a.escrever("   if ((",1);
            aux="";
            for(int i=0;i<regConvertido.length;i++){
               if(regConvertido[i].getChave().equals("S")){               
                     if(aux !=""){
                        a.escrever(aux,1);   
                     }
                     aux = "frmForm1."+regConvertido[i].getColuna().toLowerCase()+".value=="+'\"'+""+'\"'+"||";
               }
            }
            
            if(aux !=""){
            	a.escrever(aux.substring(0,aux.length()-2),1);
            }
            
            a.escrever(") && opcao != "+'\"'+"consultar"+'\"'+"){",0);
            a.escrever("      alert("+'\"'+"É necessário selecionar o registro!"+'\"'+");",0);
            a.escrever("      return false;",0);
            a.escrever("   }",0);
            a.escrever("   else",0);
            a.escrever("   {",0);
            a.escrever("      switch (opcao){",0);
            a.escrever("        case ("+'\"'+"excluir"+'\"'+"):",0);
            a.escrever("        {",0);
            
            a.escrever("   if (confirm ("+'\"'+"Você tem certeza que deseja excluir este registo ?"+'\"'+")) {",0);
            a.escrever("      window.status = "+'\"'+"Aguarde processamento..."+'\"'+";",0);
            a.escrever("      frmForm1.action ='Exc"+GeraClasse.nomeBean+"';",0);
            a.escrever("      frmForm1.submit();",0);
            a.escrever("      window.status = "+'\"'+""+'\"'+";",0);
            a.escrever("   }",0);
            a.escrever("   else {",0);
            a.escrever("      return false;",0);
            a.escrever("   }",0);
                        
            a.escrever("         break;",0);
            a.escrever("        }//case",0);
            a.escrever("        case ("+'\"'+"consultar"+'\"'+"):",0);
            a.escrever("        {",0);
            a.escrever("",0);
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
                
            if(aux !=""){
            	a.escrever(aux.substring(0,aux.length()-2),1); 
            }
            
            a.escrever("){",0);
            a.escrever("         if (confirm ("+'\"'+"Você não especificou o registro. Deseja trazer todos?"+'\"'+")) {",0);        
            a.escrever("            window.status = "+'\"'+"Aguarde processamento..."+'\"'+";",0);
            a.escrever("            frmForm1.action ='Con"+GeraClasse.nomeBean+"';",0);
            a.escrever("            frmForm1.submit();",0);
            a.escrever("            window.status = "+'\"'+""+'\"'+";",0);
            a.escrever("            }",0); 
            a.escrever("         else {",0); 
            a.escrever("            return false;",0);
            a.escrever("         }",0); 
            
            a.escrever("    } else {",0);
            a.escrever("       window.status = "+'\"'+"Aguarde processamento..."+'\"'+";",0);
            a.escrever("       frmForm1.action ='Con"+GeraClasse.nomeBean+"';",0);
            a.escrever("       frmForm1.submit();",0);
            a.escrever("       window.status = "+'\"'+""+'\"'+";",0);
            a.escrever("    }",0);  
            
            a.escrever("",0);       
            a.escrever("         break;",0);
            a.escrever("        }//case",0);
            a.escrever("        case ("+'\"'+"incluir"+'\"'+"):",0);
            a.escrever("        {",0);
            a.escrever("         window.status = "+'\"'+"Aguarde processamento..."+'\"'+";",0);
            a.escrever("         frmForm1.action ='Inc"+GeraClasse.nomeBean+"';",0);
            a.escrever("         frmForm1.submit();",0);
            a.escrever("         window.status = "+'\"'+""+'\"'+";",0);
            a.escrever("         break;",0);
            a.escrever("        }//case",0);
            a.escrever("        case ("+'\"'+"atualizar"+'\"'+"):",0);
            a.escrever("        {",0);
            a.escrever("         window.status = "+'\"'+"Aguarde processamento..."+'\"'+";",0);
            a.escrever("         frmForm1.action ='Atu"+GeraClasse.nomeBean+"';",0);
            a.escrever("         frmForm1.submit();",0);
            a.escrever("         window.status = "+'\"'+""+'\"'+";",0);
            a.escrever("         break;",0);
            a.escrever("        }//case",0);
            a.escrever("",0);
            a.escrever("      }//switch",0);
            a.escrever("   }//else",0);
            a.escrever("}//function",0);
            a.escrever("",0);
            
            for(int i=0;i<regConvertido.length;i++){
               a.escrever("function "+regConvertido[i].getColuna().toLowerCase()+"_onfocus(){",0);
               a.escrever("   frmForm1."+regConvertido[i].getColuna().toLowerCase()+".select(); ",0);
               a.escrever("}",0);
               a.escrever("",0);
            }           
            
            a.escrever("",0);
            a.escrever("",0);
            a.escrever("</script>",0);
            a.escrever("",0);
            a.escrever("<HTML>",0);
            a.escrever("<link rel="+'\"'+"stylesheet"+'\"'+" href="+'\"'+"pstats.css"+'\"'+" type="+'\"'+"text/css"+'\"'+">",0);
            a.escrever("<HEAD><TITLE>Grid de Campos</TITLE></HEAD>",0);
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
   
            a.escrever("        <td><IMG style="+'\"'+"CURSOR: hand"+'\"'+" border=0 SRC="+'\"'+"imagens/btn_consultar.bmp"+'\"'+"onclick="+'\"'+"return cmdLogin_onclick('consultar')"+'\"'+" onMouseOver="+'\"'+"document.images[0].src='imagens/btn_consultar_on.bmp'"+'\"'+" onMouseOut="+'\"'+"document.images[0].src='imagens/btn_consultar.bmp'"+'\"'+"></td>",0);
            a.escrever("        <td><IMG style="+'\"'+"CURSOR: hand"+'\"'+" border=0 SRC="+'\"'+"imagens/btn_excluir.bmp"+'\"'+"onclick="+'\"'+"return cmdLogin_onclick('excluir')"+'\"'+" onMouseOver="+'\"'+"document.images[1].src='imagens/btn_excluir_on.bmp'"+'\"'+" onMouseOut="+'\"'+"document.images[1].src='imagens/btn_excluir.bmp'"+'\"'+"></td>",0);
            a.escrever("        <td><IMG style="+'\"'+"CURSOR: hand"+'\"'+" border=0 SRC="+'\"'+"imagens/btn_atualizar.bmp"+'\"'+"onclick="+'\"'+"return cmdLogin_onclick('atualizar')"+'\"'+" onMouseOver="+'\"'+"document.images[2].src='imagens/btn_atualizar_on.bmp'"+'\"'+" onMouseOut="+'\"'+"document.images[2].src='imagens/btn_atualizar.bmp'"+'\"'+"></td>",0);
            a.escrever("        <td><IMG style="+'\"'+"CURSOR: hand"+'\"'+" border=0 SRC="+'\"'+"imagens/btn_incluir.bmp"+'\"'+"onclick="+'\"'+"return cmdLogin_onclick('incluir')"+'\"'+" onMouseOver="+'\"'+"document.images[3].src='imagens/btn_incluir_on.bmp'"+'\"'+" onMouseOut="+'\"'+"document.images[3].src='imagens/btn_incluir.bmp'"+'\"'+"></td>",0);
         
            a.escrever("   </tr>",0);
            a.escrever("   </table>",0);
            a.escrever("   <BR>",0);
            a.escrever("   <table>",0);
            a.escrever("      <tr>",0); 
            
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
               
               String nomeLabel;
               
               //Verifica se há nome para o label senão pega o nome da coluna.
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
               
                  if(regConvertido[i].getTipo()=="String"){
   
                     int tam=Integer.parseInt(regConvertido[i].getTamanho());
                     tam=tam<60?tam:60;
   
                     a.escrever("      <td class=tituloLabel nowrap=0>"+chave+GeraClasse.plm(nomeLabel)+":<BR>",0);
                     a.escrever("      <INPUT TYPE="+'\"'+"text"+'\"'+" NAME="+'\"'+regConvertido[i].getColuna().toLowerCase()+'\"'+" size="+'\"'+""+tam+""+'\"'+" border="+'\"'+"3"+'\"'+" class="+'\"'+"favoritosEsq"+'\"'+" value="+'\"'+""+'\"'+">",0);
                     a.escrever("      </td>",0);
                  }else{if(regConvertido[i].getTipo().equals("java.sql.Date")){
                           a.escrever("      <td class=tituloLabel nowrap=0>"+chave+GeraClasse.plm(nomeLabel)+":<BR>",0);
                           a.escrever("      <INPUT TYPE="+'\"'+"text"+'\"'+" NAME="+'\"'+regConvertido[i].getColuna().toLowerCase()+'\"'+" size="+'\"'+""+regConvertido[i].getTamanho()+""+'\"'+" border="+'\"'+"3"+'\"'+" class="+'\"'+"favoritosCen"+'\"'+" value="+'\"'+""+'\"'+">",0);
                           a.escrever("      </td>",0);
                       }else{
                           int tam=Integer.parseInt(regConvertido[i].getPrecisao());
                           tam=tam<60?tam:60;
   
                           if (Integer.parseInt(regConvertido[i].getPrecisao())<=13){
                              tam=Integer.parseInt(regConvertido[i].getPrecisao());
                            }
                           a.escrever("      <td class=tituloLabel nowrap=0>"+chave+GeraClasse.plm(nomeLabel)+":<BR>",0);
                           if(regConvertido[i].getTipo().equals("String")){ 
                              a.escrever("      <INPUT TYPE="+'\"'+"text"+'\"'+" NAME="+'\"'+regConvertido[i].getColuna().toLowerCase()+'\"'+" size="+'\"'+""+tam+""+'\"'+" border="+'\"'+"3"+'\"'+" class="+'\"'+"favoritosEsq"+'\"'+" value="+'\"'+""+'\"'+">",0);
                           }else{
                              a.escrever("      <INPUT TYPE="+'\"'+"text"+'\"'+" NAME="+'\"'+regConvertido[i].getColuna().toLowerCase()+'\"'+" size="+'\"'+""+tam+""+'\"'+" border="+'\"'+"3"+'\"'+" class="+'\"'+"favoritosDir"+'\"'+" value="+'\"'+""+'\"'+">",0);                      
                           }
                           a.escrever("      </td>",0);  
                                            
                       }//(Date)
                  }//(String) 
               }//else
               nomeLabel=null;

            }//for
            
            a.escrever("      </tr>",0);
            a.escrever("   </table>",0);
            a.escrever("   <HR noshade=0 width=100%>",0);
            a.escrever("<link rel="+'\"'+"stylesheet"+'\"'+" href="+'\"'+"../pstats.css"+'\"'+" type="+'\"'+"text/css"+'\"'+">",0);
            a.escrever("    <%@ include file="+'\"'+"/jsp/Grid_Detalhe"+GeraClasse.nomeBean+".jsp"+'\"'+"%>",0);
            a.escrever("</BODY>",0);
            a.escrever("</HTML>",0);
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
}
