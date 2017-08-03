package com.warsys.geraclasse.classes;

import com.warsys.geraclasse.bean.Registros;

public class GeraArqGrid_Detalhe {
   
   boolean geracao_ok = false;
   
   public GeraArqGrid_Detalhe(String nomeJsp,String nomeEmpSist, Registros[] regConvertido){

         boolean temCampoData = false;
         String aux="";
         try{
            Arquivo a = new Arquivo(GeraClasse.nomeBean);
            a.criar(nomeJsp);
            a.escrever("",0);
            a.escrever("<%@ page import="+'\"'+"com.warsys."+nomeEmpSist+".bean."+GeraClasse.nomeBean+""+'\"'+"%>",0);
            a.escrever("<%@ page import="+'\"'+"com.warsys."+nomeEmpSist+".db."+GeraClasse.nomeDB+""+'\"'+"%>",0);
            a.escrever("<%@ page import="+'\"'+"java.sql.SQLException"+'\"'+"%>",0);
            a.escrever("",0);
            a.escrever("<%",0);
            a.escrever("",0);
            a.escrever("   "+GeraClasse.nomeBean+"[] "+GeraClasse.plmi(GeraClasse.nomeBean)+" = ("+GeraClasse.nomeBean+"[])session.getAttribute("+'\"'+""+GeraClasse.plmi(GeraClasse.nomeBean)+"s"+'\"'+"); ",0);
            a.escrever("   String paginas = (String)session.getAttribute("+'\"'+"totalPg"+'\"'+"); ",0);
            a.escrever("   String qtdLinhasPg = (String)session.getAttribute("+'\"'+"qtdLinhasPg"+'\"'+");",0);
            a.escrever("   String qtdPgRodape = (String)session.getAttribute("+'\"'+"qtdPgRodape"+'\"'+");",0);
            a.escrever("   String pagAtual = (String)request.getParameter("+'\"'+"pgAtual"+'\"'+");",0);
            a.escrever("    String Erro = (String)session.getAttribute("+'\"'+"Erro"+'\"'+");",0);
            a.escrever("",0); 
            a.escrever("   if (Erro!=null){",0);
            a.escrever("    %>",0);
            a.escrever("      <script language="+'\"'+"JavaScript"+'\"'+">",0);
            a.escrever("      mensagem(<%=Erro%>);",0);
            a.escrever("      </script>",0);
            a.escrever("   <%",0);
            a.escrever("   }",0);
            a.escrever("   ",0);
            a.escrever("   if (pagAtual==null){",0);
            a.escrever("      pagAtual = "+'\"'+"1"+'\"'+";",0);  
            a.escrever("   }",0);
            a.escrever("",0); 
            a.escrever("   //Converte para Integer",0);
            a.escrever("   int ipaginas =Integer.parseInt(paginas);",0); 
            a.escrever("   int iqtdLinhasPg = Integer.parseInt(qtdLinhasPg);",0);
            a.escrever("   int iqtdRodapePg = Integer.parseInt(qtdPgRodape);",0);            
            a.escrever("   int ipagAtual = Integer.parseInt(pagAtual);",0);
            a.escrever("",0);
            a.escrever("   int regIni = (ipagAtual*iqtdLinhasPg)-iqtdLinhasPg;",0);
            a.escrever("   int regFim = regIni+iqtdLinhasPg-1;",0);
            a.escrever("",0);
            a.escrever("",0);
            a.escrever("   if (regFim>"+GeraClasse.plmi(GeraClasse.nomeBean)+".length-1){",0);
            a.escrever("      regFim="+GeraClasse.plmi(GeraClasse.nomeBean)+".length-1;",0);  
            a.escrever("   }",0);
            a.escrever("%>",0);
            a.escrever("",0);
            a.escrever("<TABLE cellSpacing=0 cellPadding=0  border=0>",0);
            a.escrever("<TR>",0);
            a.escrever("<TD class=Fundo3 height=10>",0);
            a.escrever("<TABLE cellSpacing=1 cellPadding=2 border=0>",0);
            a.escrever("<TBODY>",0);
            a.escrever(" <tr>",0);  
            a.escrever("    <td nowrap=0 align="+'\"'+"center"+'\"'+" size="+'\"'+"<%= Long.toString("+GeraClasse.plmi(GeraClasse.nomeBean)+".length).length() + "+'\"'+"0"+'\"'+" %>"+'\"'+"class=QuadroConsulta></td>",0);
            
            for(int i=0;i<regConvertido.length;i++){
               
               String nomeLabel;
                              
               if (regConvertido[i].getNomeColuna()==null){
                  nomeLabel=regConvertido[i].getColuna();
               }else{
                  nomeLabel=regConvertido[i].getNomeColuna();
               }
         
               if(regConvertido[i].getTipo().equals("String")){
                     a.escrever("    <td nowrap=0 align="+'\"'+"center"+'\"'+" size="+'\"'+""+regConvertido[i].getTamanho()+""+'\"'+" class=QuadroConsulta>"+nomeLabel+"</td>",0);
               }else{if(regConvertido[i].getTipo().equals("java.sql.Date")){
                           a.escrever("    <td nowrap=0 align="+'\"'+"center"+'\"'+" size=10 class=QuadroConsulta>"+nomeLabel+"</td>",0);
                     }else{
                           a.escrever("    <td nowrap=0 align="+'\"'+"center"+'\"'+" size="+'\"'+""+regConvertido[i].getTamanho()+""+'\"'+" class=QuadroConsulta>"+nomeLabel+"</td>",0);
                      }
                }                
            }                       
            a.escrever(" </tr>",0); 
            a.escrever(" <%",0);

            a.escrever("//variável que define sequencia de id do GIF indicador",0);
            a.escrever("int idimg = 0;",0);

            a.escrever(" for(int i=regIni;i<=regFim;i++){",0);

            for(int i=0;i<regConvertido.length;i++){            
               if(regConvertido[i].getTipo().equals("float") || regConvertido[i].getTipo().equals("double")){
                  a.escrever("   "+"String"+" c"+GeraClasse.plm(regConvertido[i].getColuna())+" = String.valueOf("+GeraClasse.plmi(GeraClasse.nomeBean)+"[i].get"+GeraClasse.plm(regConvertido[i].getColuna())+"()).replace('.',',');",0);                 
               }else{ 
                  if(regConvertido[i].getTipo().equals("java.sql.Date")){
                     a.escrever("   String c"+GeraClasse.plm(regConvertido[i].getColuna())+" = "+ '\"'+'\"'+";",0);
                     a.escrever("    if ("+GeraClasse.plmi(GeraClasse.nomeBean)+"[i].get"+GeraClasse.plm(regConvertido[i].getColuna())+"()!=null){",0);
                     a.escrever("      c"+GeraClasse.plm(regConvertido[i].getColuna())+" = "+ '\"'+'\"'+'+'+GeraClasse.plmi(GeraClasse.nomeBean)+"[i].get"+GeraClasse.plm(regConvertido[i].getColuna())+"();",0);
                     a.escrever("      c"+GeraClasse.plm(regConvertido[i].getColuna())+" = c"+GeraClasse.plm(regConvertido[i].getColuna())+".substring(8,10)+'/'+c"+GeraClasse.plm(regConvertido[i].getColuna())+".substring(5,7)+'/'+c"+GeraClasse.plm(regConvertido[i].getColuna())+".substring(0,4);",0);
                     a.escrever("    }",0);
                   }else{ 
                     a.escrever("   "+regConvertido[i].getTipo()+" c"+GeraClasse.plm(regConvertido[i].getColuna())+" = "+GeraClasse.plmi(GeraClasse.nomeBean)+"[i].get"+GeraClasse.plm(regConvertido[i].getColuna())+"();",0);
                  }
               }
            }           
            a.escrever(" %>",0);
            a.escrever(" <tr style="+'\"'+"CURSOR: hand"+'\"'+" bgColor=#FFFFFF onmousemove="+'\"'+"bgColor='#FFECD9'"+'\"'+" onmouseout="+'\"'+"bgColor='#FFFFFF'"+'\"'+" onclick="+'\"'+"CarregaCampos(<%=idimg%>,",0);
            
            for(int i=0;i<regConvertido.length;i++){           
               if(i==regConvertido.length -1){
                  a.escrever(" '<%=c"+GeraClasse.plm(regConvertido[i].getColuna())+"%>'",1);
               }else{
                  a.escrever(" '<%=c"+GeraClasse.plm(regConvertido[i].getColuna())+"%>',",0);
               }     
            }              
            a.escrever(")"+'\"'+">",0);
            
            a.escrever(" <td nowrap class=ordem align="+'\"'+"center"+'\"'+" size="+'\"'+"<%= Long.toString("+GeraClasse.plmi(GeraClasse.nomeBean)+".length).length() + "+'\"'+"0"+'\"'+" %>"+'\"'+"><IMG border=0 SRC=imagens/arrowbr.gif><%=i+1%>",0);
            a.escrever(" </td>",0);
            
            for(int i=0;i<regConvertido.length;i++){                                         

               if(regConvertido[i].getTipo().equals("String")){
                  a.escrever("   <td class=textogrid nowrap align='left'  size='"+regConvertido[i].getTamanho()+"'><%=c"+GeraClasse.plm(regConvertido[i].getColuna())+"%></a></td>",0);           
               }else{if(regConvertido[i].getTipo().equals("java.sql.Date")){
                        a.escrever("   <td class=textogrid nowrap align='center'  size=10 ><%=c"+GeraClasse.plm(regConvertido[i].getColuna())+"%></a></td>",0);              
                     }else{
                        a.escrever("   <td class=textogrid nowrap align='right'  size='"+regConvertido[i].getTamanho()+"'><%=c"+GeraClasse.plm(regConvertido[i].getColuna())+"%></a></td>",0);
                      }
                }          
            }        
            
            a.escrever("<% if (idimg < iqtdLinhasPg){",0);
            a.escrever("    idimg++;",0);
            a.escrever("   }else{",0);
            a.escrever("     idimg=0;",0);
            a.escrever("   }",0);
            a.escrever(" }%>",0);

            a.escrever("",0);
            a.escrever("</FORM>",0);
            a.escrever(" <TR>",0);
            a.escrever("    <TD class=QuadroConsulta align=left colSpan=100% height=17>Páginas:",0);
            a.escrever("        <% if (ipagAtual>=2){%>",0);
            a.escrever("        <A href="+'\"'+"Grid_Campos"+GeraClasse.nomeBean+".jsp?pgAtual=<%=Integer.parseInt("+'\"'+"0"+'\"'+"+ 1)%>"+'\"'+"><IMG border=0 SRC="+'\"'+"imagens/arrowl.gif"+'\"'+"></A>&nbsp;...",0);
            a.escrever("        <%}",0);
            a.escrever("         int tp = Integer.parseInt("+'\"'+"0"+'\"'+"+ paginas);",0);
            a.escrever("           int qtdFilaPg = iqtdRodapePg;",0);
            a.escrever("         int pgini = 1;",0);
            a.escrever("         if (tp < qtdFilaPg){",0);
            a.escrever("            qtdFilaPg = tp;",0);
            a.escrever("         }",0);
            a.escrever("",0);       
            a.escrever("         if (ipagAtual < qtdFilaPg){",0);
            a.escrever("            pgini = 1;",0);
            a.escrever("            tp = qtdFilaPg;",0);
            a.escrever("         }else{if (Integer.parseInt("+'\"'+"0"+'\"'+"+ paginas) > ipagAtual){",0);
            a.escrever("                  tp = ipagAtual+1;",0);
            a.escrever("                  pgini = ipagAtual-qtdFilaPg+1;",0);
            a.escrever("               } else {",0);
            a.escrever("                     tp = ipagAtual;",0);
            a.escrever("                     pgini = ipagAtual-qtdFilaPg+1;",0);
            a.escrever("                 }",0);
            a.escrever("         }",0);
            a.escrever("",0);       
            a.escrever("         for(int i=pgini;i<=tp;i++){",0);
            a.escrever("           if (ipagAtual==i){%>",0);
            a.escrever("            <A class=pagAtiva href="+'\"'+"Grid_Campos"+GeraClasse.nomeBean+".jsp?pgAtual=<%=i%>"+'\"'+"><%=i%></A>",0);
            a.escrever("         <%} else{%>",0);
            a.escrever("            <A class=pagDisp href="+'\"'+"Grid_Campos"+GeraClasse.nomeBean+".jsp?pgAtual=<%=i%>"+'\"'+"><%=i%></A>",0);
            a.escrever("          <%}",0);
            a.escrever("         }",0);
            a.escrever("         if (qtdFilaPg < Integer.parseInt("+'\"'+"0"+'\"'+"+ paginas)){%>",0);
            a.escrever("         ...&nbsp;<A href="+'\"'+"Grid_Campos"+GeraClasse.nomeBean+".jsp?pgAtual=<%=Integer.parseInt("+'\"'+"0"+'\"'+"+ paginas)%>"+'\"'+"><IMG border=0 SRC="+'\"'+"imagens/arrowr.gif"+'\"'+"></A>",0);
            a.escrever("         <%}%>&nbsp;&nbsp;(<%="+GeraClasse.plmi(GeraClasse.nomeBean)+".length%>&nbsp;registros&nbsp;&nbsp;&nbsp;<%=Integer.parseInt("+'\"'+"0"+'\"'+"+ paginas)%>&nbsp;páginas)",0);          
            a.escrever("   </TD>",0);
            a.escrever(" </TR>",0);
            a.escrever("</TBODY>",0);
            a.escrever("</TABLE>",0);
            a.escrever("</TD>",0);
            a.escrever("</TR>",0);
            a.escrever("</TABLE>",0);     
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