<%@ //page import="com.comgas.dataentry.bean.UsuarioComgas"%>
<%@ page import="java.sql.SQLException"%>
<%@ page contentType = "application/vnd.ms-excel"%>
<% //UsuarioComgas[] usuario = (UsuarioComgas[])session.getAttribute("usuarios");%>
<table border=1>
</tr>
<td align=center bgcolor=#FFFFCC width=350><FONT COLOR=#0000A0><B>Nome Usuário</B></FONT></td>
<td align=center bgcolor=#FFFFCC><FONT COLOR=#0000A0><B>Ramal</B></FONT></td>
<td align=center bgcolor=#FFFFCC><FONT COLOR=#0000A0><B>C.Custo</B></FONT></td>
<td align=center bgcolor=#FFFFCC><FONT COLOR=#0000A0><B>Status</B></FONT></td>
</tr>
<%//for(int i=0;i<usuario.length;i++){%>
</tr>
<td align=left><%=usuario[i].getNomeusuario()%></td> 
<td align=left><%=usuario[i].getRamal()%></td> 
<td align=left><%=usuario[i].getCcusto()%></td> 
<td align=left><%=usuario[i].getStatus()%></td> 
</tr>
<%//}%>
