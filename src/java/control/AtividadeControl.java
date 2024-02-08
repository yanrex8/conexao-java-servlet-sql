/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import data.AtividadeData;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.AtividadeModel;

/**
 *
 * @author Yan Ribon
 */
@WebServlet(name = "AtividadeControl", urlPatterns =
{
    "/AtividadeControl"
})
public class AtividadeControl extends HttpServlet
{

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AtividadeControl</title>");
            out.println("<link rel=\"stylesheet\" href=\"css/estilos.css\"/>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Operação realizada na servlet AtividadeControl em " + request.getContextPath() + "</h1>");

            String acao;
            int id;
            String yan;
            String ribon;
            float nota;

            try
            {
                acao = request.getParameter("acao");
            }
            catch (Exception e)
            {
                acao = "incluir";
            }

            try
            {
                id = Integer.parseInt(request.getParameter("id"));
            }
            catch (Exception e)
            {
                id = 0;
            }

            try
            {
                yan = request.getParameter("yan");
            }
            catch (Exception e)
            {
                yan = "";
            }

            try
            {
                ribon = request.getParameter("ribon");
            }
            catch (Exception e)
            {
                ribon = "";
            }

            try
            {
                nota = Float.parseFloat(request.getParameter("acao"));
            }
            catch (Exception e)
            {
                nota = 0;
            }

            AtividadeModel obj = new AtividadeModel(id, yan, ribon, nota);

            try
            {
                AtividadeData DAO = new AtividadeData();

                if (acao.equals("incluir"))
                {
                    if (DAO.incluir(obj))
                    {
                        out.println("<h3 style='color:#66FF99'>Salvo com sucesso</h3>");
                    }
                    else
                    {
                        out.println("<h3 style='color:red'>Erro ao salvar</h3>");
                    }
                }

                if (acao.equals("atualizar"))
                {
                    if (DAO.atualizar(obj))
                    {
                        out.println("<h3 style='color:#66FF99'>Atualizado com sucesso</h3>");
                    }
                    else
                    {
                        out.println("<h3 style='color:red'>Erro ao atualizar</h3>");
                    }
                }

                if (acao.equals("excluir"))
                {
                    if (DAO.excluir(id))
                    {
                        out.println("<h3 style='color:#66FF99'>Excluído com sucesso</h3>");
                    }
                    else
                    {
                        out.println("<h3 style='color:red'>Erro ao excluir</h3>");
                    }
                }

                if (acao.equals("editar"))
                {
                    obj = DAO.obter(id);
                    request.setAttribute("objAtividade", obj);
                    RequestDispatcher rq = request.getRequestDispatcher("CRUDAtividade.jsp");
                    rq.forward(request, response);
                }

            }
            catch (Exception e)
            {
                System.out.println("Erro: " + e.getMessage());
                out.println("<p>Erro: " + e.getMessage() + "</p>");
                e.printStackTrace(System.out);
            }

            out.println("</body>");
            out.println("</html>");
        }
        catch (Exception e)
        {
            System.out.println("Erro: " + e.getMessage());
            e.printStackTrace(System.out);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
