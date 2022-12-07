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

@WebServlet(urlPatterns = "/bills/client")
public class ClientFromBillServlet extends HttpServlet {

    public static final String URL = "/bills/client";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ClientDAO clientDAO = new ClientDAO();

        req.setAttribute("client", clientDAO.findById(Long.parseLong(req.getParameter("idClient"))).get());

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/client_bill.jsp");
        rd.forward(req, resp);

    }
}
