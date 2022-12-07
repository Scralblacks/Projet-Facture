package object;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ref_num;

    private LocalDate date_of_creation;

    @Column(columnDefinition = "DECIMAL(19,2)")
    private double cost_wto_taxes;

    @Column(columnDefinition = "DECIMAL(19,2)")
    private double cost_wt_taxes;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH})
    private Client client;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    @JoinTable(name = "billproduct", joinColumns = @JoinColumn(name = "id_Bill", referencedColumnName="ID"),
            inverseJoinColumns = @JoinColumn(name = "id_Product", referencedColumnName="ID"))
    private List<Product> productByBillList;

    public Bill(){

    }

    public Bill(LocalDate date_of_creation, double cost_wto_taxes, double cost_wt_taxes, Client client, List<Product> productByBillList){
        this.ref_num = "B" + this.getId();
        this.date_of_creation = date_of_creation;
        this.cost_wto_taxes = cost_wto_taxes;
        this.cost_wt_taxes = cost_wt_taxes;
        this.client = client;
        this.productByBillList = productByBillList;
    }

    public Bill(LocalDate date_of_creation, double cost_wto_taxes, double cost_wt_taxes, Client client){
        this.ref_num = "B" + this.getId();
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

    public void setProductList(List<Product> productByBillList) {
        this.productByBillList = productByBillList;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setProductByBillList(List<Product> productByBillList) {
        this.productByBillList = productByBillList;
    }

    public List<Product> getProductByBillList() {
        return productByBillList;
    }

    public String getRef_num() {
        return ref_num;
    }

    public void setRef_num(String ref_num) {
        this.ref_num = ref_num;
    }
}
