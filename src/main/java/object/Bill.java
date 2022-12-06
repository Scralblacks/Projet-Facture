package object;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Bill {
    @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date_of_creation;

    private double cost_wto_taxes;

    private double cost_wt_taxes;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Client client;

    @ManyToMany
    @JoinTable(name = "billproduct", joinColumns = @JoinColumn(name = "id_Bill", referencedColumnName="ID"),
            inverseJoinColumns = @JoinColumn(name = "id_Product", referencedColumnName="ID"))
    private List<Products> productByBillList;

    public Bill(){

    }

    public Bill(LocalDate date_of_creation, double cost_wto_taxes, double cost_wt_taxes, Client client, List<Products> productByBillList){
        this.date_of_creation = date_of_creation;
        this.cost_wto_taxes = cost_wto_taxes;
        this.cost_wt_taxes = cost_wt_taxes;
        this.client = client;
        this.productByBillList = productByBillList;
    }

    public Bill(LocalDate date_of_creation, double cost_wto_taxes, double cost_wt_taxes, Client client){
        this.date_of_creation = date_of_creation;
        this.cost_wto_taxes = cost_wto_taxes;
        this.cost_wt_taxes = cost_wt_taxes;
        this.client = client;
    }

    public Bill(LocalDate date_of_creation, double cost_wto_taxes, double cost_wt_taxes){
        this.date_of_creation = date_of_creation;
        this.cost_wto_taxes = cost_wto_taxes;
        this.cost_wt_taxes = cost_wt_taxes;
    }

    public void setId(Long id) {
        this.id = id;
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
}
