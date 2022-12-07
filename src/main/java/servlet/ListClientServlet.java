package servlet;

import dao.ClientDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import object.Client;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/clients")
public class ListClientServlet extends HttpServlet {
    public static final String URL = "/clients";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ClientDAO clientDAO = new ClientDAO();

        List<Client> listClient = clientDAO.findAll();

        req.setAttribute("clients", listClient);

        System.out.println(listClient);

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/client-list.jsp");
        rd.forward(req, resp);

    }
}

