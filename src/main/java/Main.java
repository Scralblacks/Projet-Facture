import object.Bill;
import object.Client;
import object.Products;

import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Bill bill = new Bill(LocalDate.now(), 40000.30, 40400.30,
                new Client("Jean Martin", "1 rue du Moulin", "60124", "Sinistrose-les-Mines", "01 20 90 56 91", "jean.martin@gmail.com")
                );

    }

}
