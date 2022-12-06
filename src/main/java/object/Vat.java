package object;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;

@Entity
public class Vat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Float amount;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "vat")
    private List<Products> productsList;

    public void setProductsList(List<Products> productsList) {
        this.productsList = productsList;
    }

    public Vat(){

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

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }
}
