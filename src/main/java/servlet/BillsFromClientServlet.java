package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/clients/bills")
public class BillsFromClientServlet extends HttpServlet {

    public static final String URL = "/clients/bills";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("COUCOU !");

        System.out.println(req.getParameter("idClient"));

        req.setAttribute("idClient", req.getParameter("idClient"));

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/bill_client-list.jsp");
        rd.forward(req, resp);

    }
}
