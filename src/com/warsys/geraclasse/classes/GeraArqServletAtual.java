package com.warsys.geraclasse.classes;

import com.warsys.geraclasse.bean.Registros;

public class GeraArqServletAtual {
	
	boolean geracao_ok = false;
	
	public GeraArqServletAtual(String nomeClasse,String nomeEmpSist, Registros[] regConvertido){
		
			boolean temCampoData = false;
			try{
				java.text.SimpleDateFormat dfcnv = new java.text.SimpleDateFormat("dd/MM/yyyy"); 
				java.util.Date dateNow =new java.util.Date();
				String hoje =dfcnv.format(dateNow);

				Arquivo a = new Arquivo(GeraClasse.nomeBean);
				a.criar(nomeClasse);

				a.escrever("",0);
				a.escrever("/*******************************/",0);
				a.escrever("/*Autor: Adilson Guerra        */",0);
				a.escrever("/*Data : "+hoje+"             */",0);
				a.escrever("/*******************************/",0);
				a.escrever("",0);
				a.escrever("package com.warsys."+nomeEmpSist+".servlets;",0);
				a.escrever("",0);
				a.escrever("import javax.servlet.*;",0);
				a.escrever("import javax.servlet.http.*;",0);
				a.escrever("import java.io.*;",0);
				a.escrever("import java.util.*;",0);
				a.escrever("import java.sql.*;",0);
				a.escrever("import java.text.ParseException;",0);
				a.escrever("import com.warsys."+nomeEmpSist+".bean."+GeraClasse.nomeBean+";",0);
				a.escrever("import com.warsys."+nomeEmpSist+".db."+GeraClasse.nomeDB+";",0);
				a.escrever("  ",0);
				a.escrever("public class "+GeraClasse.nomeServletAtualizacao+" extends HttpServlet {",0);
				a.escrever("",0);
				a.escrever("  protected void doGet(HttpServletRequest request,HttpServletResponse response)",0);
				a.escrever("                        throws ServletException, IOException {",0);
				a.escrever("	  doAction(request,response);",0);
				a.escrever("  }",0);
				a.escrever("  protected void doPost(HttpServletRequest request,HttpServletResponse response)",0);
				a.escrever("                        throws ServletException, IOException {",0);
				a.escrever("	  doAction(request,response);",0);
				a.escrever("  }",0);
				a.escrever("",0);
				a.escrever("  protected void doAction(HttpServletRequest request,",0);
				a.escrever("                          HttpServletResponse response)",0);
				a.escrever("                          throws ServletException, IOException {",0);
				
				a.escrever("",0);
				a.escrever("  System.out.println("+'\"'+"Entrou no "+GeraClasse.nomeServletAtualizacao+"..."+'\"'+");",0);
				a.escrever("",0);

				a.escrever("   "+GeraClasse.nomeBean+"[] "+GeraClasse.plmi(GeraClasse.nomeBean)+"s=null;",0);
				a.escrever("",0);

				for(int i=0;i<regConvertido.length;i++){
					if(regConvertido[i].getTipo().equals("java.sql.Date")){
						temCampoData = true;
                  		a.escrever("   String "+ regConvertido[i].getColuna() + "Aux="+'\"' +'\"'+";",0);
						a.escrever("   "+regConvertido[i].getTipo() + " "+ regConvertido[i].getColuna() + "="+ regConvertido[i].getIni() +";",0);
					}else{
						a.escrever("   "+regConvertido[i].getTipo() + " "+ regConvertido[i].getColuna() + "="+ regConvertido[i].getIni() +";",0);            
					}
            }

				a.escrever("",0);
				a.escrever("   // pega parâmetros do request",0);
				
				if (temCampoData==true){
					a.escrever("   try{",0);
				}
				for(int i=0;i<regConvertido.length;i++){
					if(regConvertido[i].getTipo().equals("String")){
                  		a.escrever("      "+regConvertido[i].getColuna()+"="+"request.getParameter("+'\"'+ regConvertido[i].getColuna()+'\"'+");",0);
					}else{if(regConvertido[i].getTipo().equals("int")){
								a.escrever("      "+regConvertido[i].getColuna()+"= Integer.parseInt(request.getParameter("+'\"'+ regConvertido[i].getColuna()+'\"'+"));",0);
						  }else{if(regConvertido[i].getTipo().equals("float")){
								    a.escrever("      "+regConvertido[i].getColuna()+"= Float.parseFloat(request.getParameter("+'\"'+ regConvertido[i].getColuna()+'\"'+").replace(',','.'));",0);						  
								 }else{if(regConvertido[i].getTipo().equals("double")){ 
									      a.escrever("      "+regConvertido[i].getColuna()+"= Double.parseDouble(request.getParameter("+'\"'+ regConvertido[i].getColuna()+'\"'+").replace(',','.'));",0);
										}else{if(regConvertido[i].getTipo().equals("short")){
									           a.escrever("      "+regConvertido[i].getColuna()+"= Short.parseShort(request.getParameter("+'\"'+ regConvertido[i].getColuna()+'\"'+"));",0);
											  }else{if(regConvertido[i].getTipo().equals("long")){
								 					    a.escrever("      "+regConvertido[i].getColuna()+"= Long.parseLong(request.getParameter("+'\"'+ regConvertido[i].getColuna()+'\"'+").replace(',','.'));",0);
										          }else{if(regConvertido[i].getTipo().equals("java.math.BigDecimal")){
								 					         a.escrever("      "+regConvertido[i].getColuna()+"= new java.math.BigDecimal(request.getParameter("+'\"'+ regConvertido[i].getColuna()+'\"'+"));",0);
															}else{if(regConvertido[i].getTipo().equals("boolean")){
								 					              a.escrever("      "+regConvertido[i].getColuna()+"= new Boolean(request.getParameter("+'\"'+ regConvertido[i].getColuna()+'\"'+"));",0);
															     }else{if(regConvertido[i].getTipo().equals("java.sql.Date")){
																			 a.escrever("      java.text.SimpleDateFormat df"+regConvertido[i].getColuna()+" = new java.text.SimpleDateFormat("+'\"'+"dd/MM/yyyy"+'\"'+"); ",0);
																			 a.escrever("      if(request.getParameter("+'\"'+""+regConvertido[i].getColuna()+""+'\"'+").equals("+'\"'+""+'\"'+")){",0);
																			 a.escrever("   	   "+regConvertido[i].getColuna()+"=null;",0);
																			 a.escrever("      }else{",0);
																			 a.escrever("          "+regConvertido[i].getColuna()+"Aux = request.getParameter("+'\"'+""+regConvertido[i].getColuna()+""+'\"'+"); ",0);
																			 a.escrever("          "+regConvertido[i].getColuna()+" = new java.sql.Date(df"+regConvertido[i].getColuna()+".parse("+regConvertido[i].getColuna()+"Aux).getTime());",0);
																			 a.escrever("      }",0);	
																		 }else{if(regConvertido[i].getTipo().equals("java.sql.Time")){
																					a.escrever("      java.text.SimpleDateFormat df"+regConvertido[i].getColuna()+" = new java.text.SimpleDateFormat("+'\"'+"H:m:s"+'\"'+"); ",0);
																					a.escrever("      if(request.getParameter("+'\"'+""+regConvertido[i].getColuna()+""+'\"'+").equals("+'\"'+""+'\"'+")){",0);
																					a.escrever("   	   "+regConvertido[i].getColuna()+"=null;",0);
																					a.escrever("      }else{",0);
																					a.escrever("          "+regConvertido[i].getColuna()+"Aux = request.getParameter("+'\"'+""+regConvertido[i].getColuna()+""+'\"'+"); ",0);
																					a.escrever("      "+regConvertido[i].getColuna()+" = new java.sql.Time(df"+regConvertido[i].getColuna()+".parse("+regConvertido[i].getColuna()+"Aux).getTime());",0);
																					a.escrever("      }",0);	
																		      }else{if(regConvertido[i].getTipo().equals("java.sql.Timestamp")){	
																						 a.escrever("      java.text.SimpleDateFormat df"+regConvertido[i].getColuna()+" = new java.text.SimpleDateFormat("+'\"'+"dd/MM/yyyy h:m:s"+'\"'+"); ",0);
																						 a.escrever("      if(request.getParameter("+'\"'+""+regConvertido[i].getColuna()+""+'\"'+").equals("+'\"'+""+'\"'+")){",0);
																					 	 a.escrever("   	   "+regConvertido[i].getColuna()+"=null;",0);
																						 a.escrever("      }else{",0);
																						 a.escrever("          "+regConvertido[i].getColuna()+"Aux = request.getParameter("+'\"'+""+regConvertido[i].getColuna()+""+'\"'+"); ",0);
																						 a.escrever("      "+regConvertido[i].getColuna()+" = new java.sql.Timestamp(df"+regConvertido[i].getColuna()+".parse("+regConvertido[i].getColuna()+"Aux).getTime());",0);
																						 a.escrever("      }",0);	
																	              }else{if(regConvertido[i].getTipo().equals("byte")){
																								 a.escrever("      "+regConvertido[i].getColuna()+"= Byte.parseByte(request.getParameter("+'\"'+ regConvertido[i].getColuna()+'\"'+"));",0);											 
																							 }//(byte)
																					  }//(Timestamp)
																	         }//(Time)
																	    }//(Date)
																  }//(boolean)
															}//(BigDecimal)
													 }//(long)
											  }//(short)
										}//(double)
								 }//(float)
						  }//(int)
					}//(String)
					a.escrever("   System.out.println("+'\"'+regConvertido[i].getColuna()+"->"+'\"'+"+"+regConvertido[i].getColuna()+");",0);
					a.escrever("",0);
            }//for
            
				if (temCampoData){
					a.escrever("   }catch (ParseException e) {",0);
					a.escrever("     System.out.println(" +'\"'+"Ocorreu um erro ao converter a data !"+'\"'+"+  e.getMessage());",0);	
					a.escrever("",0);
					a.escrever("   	// acerta tipo MIME para a resposta",0);
					a.escrever("   	response.setContentType("+'\"'+"text/html"+'\"'+");",0);
					a.escrever("",0);
					a.escrever("   	PrintWriter out = response.getWriter();",0);
					a.escrever("",0);
               
               a.escrever("      out.println(MontaPgErro(\"Ocorreu um erro de conversão! Verifique se dado digitado está correto.\",e.getMessage()));",0);					
					
					a.escrever("	   out.close();",0);
					a.escrever("",0);
					a.escrever("      RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(" +'\"'+""+'\"'+");",0);
					a.escrever("      dispatcher.forward(request,response);",0);
					a.escrever("   }",0);
					a.escrever("   catch (Exception e) {",0);
					a.escrever("     System.out.println(" +'\"'+"Ocorreu um erro de conversão ao altualizar !"+'\"'+"+  e.getMessage());",0);	
					a.escrever("",0);
					a.escrever("   	// acerta tipo MIME para a resposta",0);
					a.escrever("   	response.setContentType("+'\"'+"text/html"+'\"'+");",0);
					a.escrever("",0);
					a.escrever("   	PrintWriter out = response.getWriter();",0);
					a.escrever("",0);

               a.escrever("      out.println(MontaPgErro(\"Ocorreu um erro de conversão! Verifique se dado digitado está correto.\",e.getMessage()));",0);              

					a.escrever("	   out.close();",0);
					a.escrever("",0);
					a.escrever("      RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(" +'\"'+""+'\"'+");",0);
					a.escrever("      dispatcher.forward(request,response);",0);

					a.escrever("   }",0);
				
				}
				a.escrever("",0);
				a.escrever("   "+GeraClasse.nomeBean+" b = new "+GeraClasse.nomeBean+"(",1);

				for(int i=0;i<regConvertido.length;i++){
					
					if(i==regConvertido.length -1){
						a.escrever(regConvertido[i].getColuna().toLowerCase()+");",0);
					}else{
						a.escrever(regConvertido[i].getColuna().toLowerCase()+",",1);
					}		
				}		

				a.escrever("   "+GeraClasse.nomeDB+" db = new "+GeraClasse.nomeDB+"();",0);
				a.escrever("",0);
				a.escrever("   String totalPg = "+'\"'+"1"+'\"'+"; //página inicial",0);
				a.escrever("   String qtdLinhasPg = "+'\"'+"10"+'\"'+";",0);
				a.escrever("   String contexto = "+'\"'+""+'\"'+";",0);
				a.escrever("",0);
				a.escrever("   System.out.println("+'\"'+"Estou no "+GeraClasse.nomeServletAtualizacao+'\"'+");",0);
				a.escrever("",0);
				a.escrever("   ServletConfig config = getServletConfig();",0);
				a.escrever("   ServletContext ctx = config.getServletContext();",0);
				a.escrever("",0);
				a.escrever("   if (ctx.getInitParameter("+'\"'+"qtdLinhasPg"+'\"'+")!= null){",0);
				a.escrever("      qtdLinhasPg = ctx.getInitParameter("+'\"'+"qtdLinhasPg"+'\"'+");",0);
				a.escrever("   }",0);
				a.escrever("",0);
				a.escrever("   if (ctx.getInitParameter("+'\"'+"contexto"+'\"'+")!= null){",0);
				a.escrever("      contexto = ctx.getInitParameter("+'\"'+"contexto"+'\"'+");",0);
				a.escrever("   }",0);
				a.escrever("",0);
				a.escrever("   HttpSession session = request.getSession();",0);
				a.escrever("",0);
				a.escrever("   try{",0);
				a.escrever("	   db.atualizar(b);",0);
				a.escrever("	   "+GeraClasse.plmi(GeraClasse.nomeBean)+"s = db.get"+GeraClasse.nomeBean+"s();",0);		 
				a.escrever("",0);
				a.escrever("	if (java.lang.Math.round("+GeraClasse.plmi(GeraClasse.nomeBean)+"s.length%Integer.parseInt(qtdLinhasPg))>0){",0);
				a.escrever("	   	totalPg = "+'\"'+""+'\"'+"+(java.lang.Math.round("+GeraClasse.plmi(GeraClasse.nomeBean)+"s.length/Integer.parseInt(qtdLinhasPg)+1));",0);
				a.escrever("   	} else {",0);
			   a.escrever("   		totalPg = "+'\"'+""+'\"'+"+(java.lang.Math.round("+GeraClasse.plmi(GeraClasse.nomeBean)+"s.length/Integer.parseInt(qtdLinhasPg)));",0);
				a.escrever("	   }",0);
				a.escrever("",0);	
				a.escrever("	   session.setAttribute(" +'\"'+"totalPg" +'\"'+",totalPg);",0);
				a.escrever("	   session.setAttribute(" +'\"'+"qtdLinhasPg" +'\"'+",qtdLinhasPg);",0);
				a.escrever("	   session.setAttribute(" +'\"'+""+GeraClasse.plmi(GeraClasse.nomeBean)+"s" +'\"'+","+GeraClasse.plmi(GeraClasse.nomeBean)+"s);",0); 
			   a.escrever("",0);
				a.escrever("",0);
				
				a.escrever("   }catch (NumberFormatException e) {",0);
				a.escrever("     System.out.println(" +'\"'+"Ocorreu um erro ao atualizar o registro !"+'\"'+"+  e.getMessage());",0);	
				a.escrever("",0);
				a.escrever("   	// acerta tipo MIME para a resposta",0);
				a.escrever("   	response.setContentType("+'\"'+"text/html"+'\"'+");",0);
				a.escrever("",0);
				a.escrever("   	PrintWriter out = response.getWriter();",0);
				a.escrever("",0);

            a.escrever("      out.println(MontaPgErro(\"Ocorreu um erro de conversão! Verifique se dado digitado está correto.\",e.getMessage()));",0);              

				a.escrever("	   out.close();",0);
				a.escrever("",0);
				a.escrever("   RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(" +'\"'+""+'\"'+");",0);
				a.escrever("   dispatcher.forward(request,response);",0);
				
				a.escrever("   } catch (SQLException e){",0);
				a.escrever("   	 System.out.println(" +'\"'+"Ocorreu um erro ao atualizar registro!" +'\"'+"+  e.getMessage());",0);
				a.escrever("",0);
		 		a.escrever("   	 // acerta tipo MIME para a resposta",0);
		 		a.escrever("   	 response.setContentType("+'\"'+"text/html"+'\"'+");",0);
				a.escrever("",0);
		 		a.escrever("   	 PrintWriter out = response.getWriter();",0);
				a.escrever("",0);
            
            a.escrever("      out.println(MontaPgErro(\"Ocorreu um erro de conversão! Verifique se dado digitado está correto.\",e.getMessage()));",0);              

				a.escrever("	   out.close();",0);				
				a.escrever("   }",0);
				a.escrever("",0);
				a.escrever("   System.out.println("+'\"'+"...saiu do "+GeraClasse.nomeServletConsulta+'\"'+");",0);
				a.escrever("",0);
				a.escrever("   RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(" +'\"'+"/jsp/Grid_Campos"+GeraClasse.nomeBean+".jsp" +'\"'+");",0);
				a.escrever("   dispatcher.forward(request,response);",0);	
				a.escrever("   }//doAction",0);

				
            a.escrever("",0);          
            a.escrever("   private String MontaPgErro(String msg1,String msg2){",0);
            a.escrever("",0);
            a.escrever("   String pgHtml="+'\"'+""+'\"'+";",0);
            a.escrever("",0);
            a.escrever("         pgHtml=pgHtml+"+'\"'+"<HTML>"+'\"'+";",0);
            a.escrever("         pgHtml=pgHtml+"+'\"'+"<script language='JavaScript'>"+'\"'+";",0);
            a.escrever("         pgHtml=pgHtml+"+'\"'+"function voltar(){"+'\"'+";",0);
            a.escrever("         pgHtml=pgHtml+"+'\"'+"   history.back();"+'\"'+";",0);
            a.escrever("         pgHtml=pgHtml+"+'\"'+"}"+'\"'+";",0);
            a.escrever("         pgHtml=pgHtml+"+'\"'+"</script>"+'\"'+";",0);
            a.escrever("         pgHtml=pgHtml+"+'\"'+"<TITLE> ERRO </TITLE>"+'\"'+";",0);
            a.escrever("         pgHtml=pgHtml+"+'\"'+"<BODY bgColor=#FCF0E9 text=#FF3300 >"+'\"'+";",0);
            a.escrever("         pgHtml=pgHtml+"+'\"'+"<TABLE align=center width=100%>"+'\"'+";",0);
            a.escrever("         pgHtml=pgHtml+"+'\"'+"  <tr><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR></tr>"+'\"'+";",0);
            a.escrever("         pgHtml=pgHtml+"+'\"'+"  <tr align=center >"+'\"'+";",0);
            a.escrever("         pgHtml=pgHtml+"+'\"'+"     <td nowrap=0><FONT SIZE=5 FACE=arial>"+'\"'+"+msg1+"+'\"'+"</FONT></td>"+'\"'+";",0);
            a.escrever("         pgHtml=pgHtml+"+'\"'+"   </tr> "+'\"'+";",0);
            a.escrever("         pgHtml=pgHtml+"+'\"'+"  <tr align=center >"+'\"'+";",0);
            a.escrever("         pgHtml=pgHtml+"+'\"'+"     <td nowrap=0><FONT SIZE=3 FACE=arial>"+'\"'+"+msg2+"+'\"'+"</FONT></td>"+'\"'+";",0);
            a.escrever("         pgHtml=pgHtml+"+'\"'+"   </tr> "+'\"'+";",0);
            a.escrever("         pgHtml=pgHtml+"+'\"'+"<TABLE align=center>"+'\"'+";",0);
            a.escrever("         pgHtml=pgHtml+"+'\"'+"  <tr>"+'\"'+";",0);
            a.escrever("         pgHtml=pgHtml+"+'\"'+"    <td><IMG style='CURSOR: hand' border=0 SRC='imagens/btnretornar.gif' onclick= 'voltar()' onMouseOver="+'\"'+"+'\\\"'+"+'\"'+"document.images[0].src='imagens/btnretornar_on.gif\'"+'\"'+"+'\\\"'+"+'\"'+" onMouseOut="+'\"'+"+'\\\"'+"+'\"'+"document.images[0].src='imagens/btnretornar.gif\'"+'\"'+"+'\\\"'+"+'\"'+"></td>\";",0);
            a.escrever("         pgHtml=pgHtml+"+'\"'+"   </tr>  <BR>  <BR>"+'\"'+";",0);
            a.escrever("         pgHtml=pgHtml+"+'\"'+"</TABLE>"+'\"'+";",0);
            a.escrever("         pgHtml=pgHtml+"+'\"'+"  <tr></tr>"+'\"'+";",0);
            a.escrever("         pgHtml=pgHtml+"+'\"'+"</TABLE>"+'\"'+";",0);
            a.escrever("         pgHtml=pgHtml+"+'\"'+"</BODY>"+'\"'+";",0);
            a.escrever("         pgHtml=pgHtml+"+'\"'+"</HTML>"+'\"'+";",0);
            a.escrever("         ",0);
            a.escrever("         return pgHtml;",0);
            a.escrever("",0);
            a.escrever("   }//MontaPgErro",0);
            a.escrever("",0);       
            a.escrever("}  // class",0);     
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