package com.example.demo.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Cartitem {
    private Long id;
    private Integer quantity;
    private Long cartid;
    private Long productid;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "QUANTITY")
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "CARTID")
    public Long getCartid() {
        return cartid;
    }

    public void setCartid(Long cartid) {
        this.cartid = cartid;
    }

    @Basic
    @Column(name = "PRODUCTID")
    public Long getProductid() {
        return productid;
    }

    public void setProductid(Long productid) {
        this.productid = productid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cartitem cartitem = (Cartitem) o;
        return Objects.equals(id, cartitem.id) && Objects.equals(quantity, cartitem.quantity) && Objects.equals(cartid, cartitem.cartid) && Objects.equals(productid, cartitem.productid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity, cartid, productid);
    }
}
