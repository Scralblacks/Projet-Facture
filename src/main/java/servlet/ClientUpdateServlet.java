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
import java.time.LocalDate;

@WebServlet(urlPatterns = "/clients/update")
public class ClientUpdateServlet extends HttpServlet {

    public static final String URL = "/clients/update";
    public static ClientDAO ClientDao = new ClientDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("client", ClientDao.findById(Long.parseLong(req.getParameter("idClient"))).get());
        req.setAttribute("idClient", req.getParameter("idClient"));

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/client-edit.jsp");
        rd.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Client updatedClient = ClientDao.findById(Long.parseLong(req.getParameter("idClient"))).get();

        updatedClient.setName(req.getParameter("name"));
        updatedClient.setAddress(req.getParameter("address"));
        updatedClient.setTown(req.getParameter("town"));
        updatedClient.setZip_code(req.getParameter("zip_code"));
        updatedClient.setPhone_number(req.getParameter("phone_number"));
        updatedClient.setEmail(req.getParameter("email"));

        ClientDao.update(updatedClient);

        resp.sendRedirect(ListClientServlet.URL);
    }
}
