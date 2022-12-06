package object;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Bill {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private LocalDate date_of_creation;

    private Float cost_wto_taxes;

    private Float cost_wt_taxes;

    @ManyToOne
    private Client client;

    @ManyToMany
    private List<Products> productByBillList;

    public Bill(){

    }

    public void setId(String id) {
        this.id = id;
        //this.id = String.valueOf(new StringBuilder("B").append(id));
    }

    public String getId() {
        return id;
    }

    public LocalDate getDate_of_creation() {
        return date_of_creation;
    }

    public void setDate_of_creation(LocalDate date_of_creation) {
        this.date_of_creation = date_of_creation;
    }

    public Float getCost_wto_taxes() {
        return cost_wto_taxes;
    }

    public void setCost_wto_taxes(Float cost_wto_taxes) {
        this.cost_wto_taxes = cost_wto_taxes;
    }

    public Float getCost_wt_taxes() {
        return cost_wt_taxes;
    }

    public void setCost_wt_taxes(Float cost_wt_taxes) {
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
