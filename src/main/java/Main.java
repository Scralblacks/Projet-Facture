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

        // Bloc initialisation
        VatDAO vatDAO = new VatDAO();
        ProductsDAO productsDAO = new ProductsDAO();
        BillDAO billDAO = new BillDAO();
        ClientDAO clientDAO = new ClientDAO();
        List<Products> listProductsBill1 = new ArrayList<>();
        List<Products> listProductsBill2 = new ArrayList<>();
        List<Products> listProductsBill3 = new ArrayList<>();
        List<Bill> listBillJeanMartin = new ArrayList<>();
        List<Bill> listBillJeanneMartin = new ArrayList<>();
        List<Bill> listBillLait = new ArrayList<>();
        List<Bill> listBillChocolat = new ArrayList<>();

        // Bloc add Vat
        vatDAO.create(new Vat(0));
        vatDAO.create(new Vat(0.022));
        vatDAO.create(new Vat(0.055));
        vatDAO.create(new Vat(0.1));
        vatDAO.create(new Vat(0.2));

        //Bloc creating objects
        Products lait = new Products("Lait", 1.24, vatDAO.findById(Long.valueOf(3L)).get());
        Products chocolat = new Products("Chocolat", 2.48, vatDAO.findById(Long.valueOf(3L)).get());
        Bill bill1 = new Bill(LocalDate.now(), 1240L, (1240 * 1.055));
        Bill bill2 = new Bill(LocalDate.now(), 1240L, (1240 * 1.055));
        Bill bill3 = new Bill(LocalDate.now(), 2480, (2480 * 1.055));
        Client jeanMartin = new Client("Jean Martin", "1 rue du Moublin", "48925", "Sinistrose-les-Mines", "03 59 48 16 32" , "jean.martin@email.fr");
        Client jeanneMartin = new Client("Jeanne Martin", "1 rue du Moublin", "48925", "Sinistrose-les-Mines", "03 59 50 16 32" , "jeanne.martin@email.fr");

        //Bloc completing variable

        listBillJeanMartin.add(bill1);
        listBillJeanMartin.add(bill3);

        listBillJeanneMartin.add(bill2);

        listProductsBill1.add(lait);
        listProductsBill1.add(chocolat);

        listProductsBill2.add(lait);

        listProductsBill3.add(chocolat);

        listBillLait.add(bill1);
        listBillLait.add(bill2);

        listBillChocolat.add(bill3);

        //Bloc completing objects
        jeanMartin.setBillList(listBillJeanMartin);
        bill1.setClient(jeanMartin);
        bill1.setProductByBillList(listProductsBill1);

        jeanneMartin.setBillList(listBillJeanneMartin);
        bill2.setClient(jeanneMartin);
        bill2.setProductByBillList(listProductsBill2);

        bill3.setClient(jeanMartin);
        bill3.setProductByBillList(listProductsBill3);

        //Bloc send objects

        clientDAO.create(jeanMartin);
        clientDAO.create(jeanneMartin);

//        productsDAO.create(lait);
//        productsDAO.create(chocolat);
//
//        billDAO.create(bill1);
//        billDAO.create(bill2);
//        billDAO.create(bill3);

    }

}
