package servlet;

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

@WebServlet(urlPatterns = "/bills/products")
public class ProductsFromBillServlet extends HttpServlet {

    public static final String URL = "/bills/products";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ProductDAO productDAO = new ProductDAO();
        BillProductDAO billProductDAO = new BillProductDAO();

        req.setAttribute("idBill", req.getParameter("idBill"));
        req.setAttribute("products", productDAO.findAll());
        req.setAttribute("billProduct", billProductDAO.findAll());

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/product_bill-list.jsp");
        rd.forward(req, resp);
    }
}
