<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
   
<%
   String dta = (String)request.getParameter("dataArquivo");
   String tipo = (String)request.getParameter("tipoOcor");
   
   System.out.println ("tipo="+tipo); 
   System.out.println ("dta="+dta);
%>

<HTML>
<link rel="stylesheet" href="../prova_zero.css" type="text/css">
   
<script language="javascript">
   
   function enviar(){
      frmForm1.action ="/prova_zero/parsearchive?tipoOcor=<%=tipo%>&data_ocorrencia=<%=dta%>";
      frmForm1.submit();
   }  
   
</script>
<HEAD>
<TITLE></TITLE>
</HEAD>
<BODY class=fundo4 onload="javascript:enviar();">
   <FORM name=frmForm1 action="" method=post>  
   </FORM>
</BODY>
</HTML>
