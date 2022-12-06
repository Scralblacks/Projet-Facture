package object;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;

@Entity
public class Vat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;

    @OneToMany(mappedBy = "vat")
    private List<Products> productsList;

    public void setProductsList(List<Products> productsList) {
        this.productsList = productsList;
    }

    public Vat(){

    }

    public Vat(double amount, List<Products> productsList) {
        this.amount = amount;
        this.productsList = productsList;
    }

    public Vat(double amount) {
        this.amount = amount;
    }

    public List<Products> getProductsList() {
        return productsList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
