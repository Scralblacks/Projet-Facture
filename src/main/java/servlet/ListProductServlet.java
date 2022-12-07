package servlet;

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

@WebServlet(urlPatterns = "/products")
public class ListProductServlet extends HttpServlet {
    public static final String URL = "/products";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ProductDAO ProductDAO = new ProductDAO();
        VatDAO vatDAO = new VatDAO();

        List<Product> listProduct = ProductDAO.findAll();
        List<Vat> listVat = vatDAO.findAll();

        req.setAttribute("products", listProduct);
        req.setAttribute("vats", listVat);

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/product-list.jsp");
        rd.forward(req, resp);

    }
}

