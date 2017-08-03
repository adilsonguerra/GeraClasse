

<HTML>
<script language="JavaScript">
	function vai(url,janela){
		window.open('html/apresentacao.html','grid','status=no');
		open(url,janela);
	}
</script>

<TITLE> Opções </TITLE>
<link rel="stylesheet" href="dataentry.css" type="text/css">
<BODY bgColor=#FCF0E9 text=#408080 >


<BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>
<TABLE>

<tr align=left>
   <%// verifica o acesso à entrada de dados (cód 229)
   if(lista_func!=null && lista_func.get("229")!=null){%>
	<td  class="menu_campos"nowrap=0><a href="javascript:vai('menu_proj_index_tabelas.jsp','menu')"><FONT SIZE=2 FACE=arial>ENTRADA DE DADOS</FONT></td>
   <%}%>
<tr align=left>
   <%// verifica o acesso à não conformidades (cód 228)
   if(lista_func!=null && lista_func.get("228")!=null){%>
   <td  class="menu_campos"nowrap=0><a href="javascript:vai('menu_proj_index_nconf.jsp','menu')"><FONT SIZE=2 FACE=arial>NÃO CONFORMIDADES</FONT></td>
   <%}%>
</tr>

</TABLE>
</BODY>
</HTML>
