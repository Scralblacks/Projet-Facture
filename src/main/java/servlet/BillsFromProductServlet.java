package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/products/bills")
public class BillsFromProductServlet extends HttpServlet {

    public static final String URL = "/products/bills";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("idProduct", req.getParameter("idProduct"));

        System.out.println(req.getParameter("idProduct"));

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/bill_product-list.jsp");
        rd.forward(req, resp);
    }
}
