import dao.BillDAO;
import dao.ClientDAO;
import dao.ProductsDAO;
import dao.VatDAO;

import object.Bill;
import object.Client;
import object.Products;
import object.Vat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        VatDAO vatDAO = new VatDAO();
        ProductsDAO productsDAO = new ProductsDAO();
        BillDAO billDAO = new BillDAO();
        ClientDAO clientDAO = new ClientDAO();
        List<Bill> listBillJeanMartin = new ArrayList<>();

        vatDAO.create(new Vat(0));
        vatDAO.create(new Vat(0.022));
        vatDAO.create(new Vat(0.055));
        vatDAO.create(new Vat(0.1));
        vatDAO.create(new Vat(0.2));

        Products lait = new Products("Lait", 1.24, vatDAO.findById(Long.valueOf(3L)).get());
        Bill bill1 = new Bill(LocalDate.now(), 1240L, (1240 * 1.055));
        Client jeanMartin = new Client("Jean Martin", "1 rue du Moublin", "48925", "Sinistrose-les-Mines", "03 59 48 16 32" , "jean.martin@email.fr");

        bill1.setClient(jeanMartin);
        listBillJeanMartin.add(bill1);
        jeanMartin.setBillList(listBillJeanMartin);

        productsDAO.create(lait);
        billDAO.create(bill1);





    }

}
