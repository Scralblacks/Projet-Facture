package servlet;

import dao.ClientDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/clients/delete")
public class ClientDeleteServlet extends HttpServlet {

    public static final String URL = "/clients/delete";

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        getServletContext()
//                .getRequestDispatcher("/WEB-INF/del-game.jsp")
//                .forward(req, resp);
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        ClientDAO clientDao = new ClientDAO();

        System.out.println(Long.parseLong(req.getParameter("idClient")));

        clientDao.delete(Long.parseLong(req.getParameter("idClient")));

        resp.sendRedirect(ListClientServlet.URL);
    }
}
