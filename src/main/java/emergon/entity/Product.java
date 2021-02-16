/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tzortziskapellas
 */
@Entity
@Table(name = "product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findByPcode", query = "SELECT p FROM Product p WHERE p.pcode = :pcode"),
    @NamedQuery(name = "Product.findByPdescr", query = "SELECT p FROM Product p WHERE p.pdescr = :pdescr"),
    @NamedQuery(name = "Product.findByPprice", query = "SELECT p FROM Product p WHERE p.pprice = :pprice")})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Pcode")
    private Integer pcode;
    @Basic(optional = false)
    @Column(name = "Pdescr")
    private String pdescr;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Pprice")
    private BigDecimal pprice;

    public Product() {
    }

    public Product(Integer pcode) {
        this.pcode = pcode;
    }

    public Product(Integer pcode, String pdescr) {
        this.pcode = pcode;
        this.pdescr = pdescr;
    }

    public Integer getPcode() {
        return pcode;
    }

    public void setPcode(Integer pcode) {
        this.pcode = pcode;
    }

    public String getPdescr() {
        return pdescr;
    }

    public void setPdescr(String pdescr) {
        this.pdescr = pdescr;
    }

    public BigDecimal getPprice() {
        return pprice;
    }

    public void setPprice(BigDecimal pprice) {
        this.pprice = pprice;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pcode != null ? pcode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.pcode == null && other.pcode != null) || (this.pcode != null && !this.pcode.equals(other.pcode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "emergon.entity.Product[ pcode=" + pcode + " ]";
    }
    
}
