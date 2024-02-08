<%-- 
    Document   : CRUDAtividade
    Created on : 4 de dez. de 2023, 09:02:35
    Author     : Yan Ribon
--%>

<%@page import="data.AtividadeData"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.AtividadeModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/estilos.css"/>
        <title>CRUD Banco de Dados</title>
    </head>
    <body>
        <h1>CRUD Banco de Dados - Prova 04/12/2023</h1>
        <%
            AtividadeModel obj = (AtividadeModel) request.getAttribute("objAtividade");
            if (obj == null)
            {
                obj = new AtividadeModel();
            }
        %>

        <form name="form1" action="AtividadeControl" method="POST">
            <label for="id">ID: <%=obj.getId()%></label>
            <input type="hidden" name="id" value="<%=obj.getId()%>">
            <br>
            <%if (obj.getId() == 0)
                {%>
            <input type="hidden" name="acao" value="incluir">
            <%}
            else
            {%>
            <input type="hidden" name="acao" value="atualizar"><%----------------------------------------------------------%>
            <%}%>
            <label for="yan">Yan</label>
            <input type="text" name="yan" value="<%=obj.getYan()%>" required>
            <br>
            <label for="ribon">Ribon</label>
            <input type="text" name="ribon" value="<%=obj.getRibon()%>" required>
            <br>
            <label for="nota">Nota</label>
            <input type="text" name="nota" value="<%=obj.getNota()%>" required>
            <br>
            <%if (obj.getId() == 0)
                {%>
            <input type="submit" value="Cadastrar">
            <%}
            else
            {%>
            <input type="submit" value="Atualizar">
            <input type="reset" value="Limpar">
            <%}%>
        </form>
        <h3>Listagem</h3>
        <%
            try
            {
                ArrayList<AtividadeModel> listaDados = new ArrayList<>();
                AtividadeData DAO = new AtividadeData();
                listaDados = DAO.listar();
                for (AtividadeModel a : listaDados)
                {
                    out.println("<p>" + a.getYan() + " " + a.getRibon() + " <a href='AtividadeControl?id=" + a.getId() + "&acao=editar'>Editar</a>"
                            + " <a href='AtividadeControl?id=" + a.getId() + "&acao=excluir'>Excluir</a>");
                }
            }
            catch (Exception e)
            {
                out.println("<h3 style=color:'red'>Erro: " + e.getMessage() + "</h3>");
                e.printStackTrace(System.out);
            }
        %>
    </body>
</html>
