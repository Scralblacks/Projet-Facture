package servlet;

import dao.BillDAO;
import dao.BillProductDAO;
import dao.ProductDAO;
import dao.VatDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import object.Product;
import object.Vat;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/products/bills")
public class BillsFromProductServlet extends HttpServlet {

    public static final String URL = "/products/bills";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BillDAO billDAO = new BillDAO();
        ProductDAO productDAO = new ProductDAO();
        BillProductDAO billProductDAO = new BillProductDAO();

        req.setAttribute("idProduct", req.getParameter("idProduct"));
        req.setAttribute("bills", billDAO.findAll());

        System.out.println(req.getParameter("idProduct"));

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/bill_product-list.jsp");
        rd.forward(req, resp);
    }
}
