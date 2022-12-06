package object;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ref_nbr;

    private LocalDate date_of_creation;

    private double cost_wto_taxes;

    private double cost_wt_taxes;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Client client;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Products> productByBillList;


    public Bill(){

    }

    public Bill(LocalDate date_of_creation, double cost_wto_taxes, double cost_wt_taxes, Client client, List<Products> productByBillList){
        this.ref_nbr = "B" + this.id;
        this.date_of_creation = date_of_creation;
        this.cost_wto_taxes = cost_wto_taxes;
        this.cost_wt_taxes = cost_wt_taxes;
        this.client = client;
        this.productByBillList = productByBillList;
    }

    public Bill(LocalDate date_of_creation, double cost_wto_taxes, double cost_wt_taxes, Client client){
        this.ref_nbr = "B" + this.id;
        this.date_of_creation = date_of_creation;
        this.cost_wto_taxes = cost_wto_taxes;
        this.cost_wt_taxes = cost_wt_taxes;
        this.client = client;
    }

    public void setId(Long id) {
        this.id = id;
        //this.id = String.valueOf(new StringBuilder("B").append(id));
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate_of_creation() {
        return date_of_creation;
    }

    public void setDate_of_creation(LocalDate date_of_creation) {
        this.date_of_creation = date_of_creation;
    }

    public double getCost_wto_taxes() {
        return cost_wto_taxes;
    }

    public void setCost_wto_taxes(double cost_wto_taxes) {
        this.cost_wto_taxes = cost_wto_taxes;
    }

    public double getCost_wt_taxes() {
        return cost_wt_taxes;
    }

    public void setCost_wt_taxes(double cost_wt_taxes) {
        this.cost_wt_taxes = cost_wt_taxes;
    }

    public void setProductList(List<Products> productByBillList) {
        this.productByBillList = productByBillList;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setProductByBillList(List<Products> productByBillList) {
        this.productByBillList = productByBillList;
    }

    public List<Products> getProductByBillList() {
        return productByBillList;
    }

    public String getRef_nbr() {
        return ref_nbr;
    }

    public void setRef_nbr(String ref_nbr) {
        this.ref_nbr = ref_nbr;
    }
}
