package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/bills/products")
public class ProductsFromBillServlet extends HttpServlet {

    public static final String URL = "/bills/products";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("idBill", req.getParameter("idBill"));

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/product_bill-list.jsp");
        rd.forward(req, resp);
    }
}
