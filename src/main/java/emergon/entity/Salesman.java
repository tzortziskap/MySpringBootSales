/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author tzortziskapellas
 */
@Entity
@Table(name = "salesman")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Salesman.findAll", query = "SELECT s FROM Salesman s"),
    @NamedQuery(name = "Salesman.findByScode", query = "SELECT s FROM Salesman s WHERE s.scode = :scode"),
    @NamedQuery(name = "Salesman.findBySname", query = "SELECT s FROM Salesman s WHERE s.sname = :sname"),
    @NamedQuery(name = "Salesman.findByScity", query = "SELECT s FROM Salesman s WHERE s.scity = :scity"),
    @NamedQuery(name = "Salesman.findByScomm", query = "SELECT s FROM Salesman s WHERE s.scomm = :scomm")})
public class Salesman implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Scode")
    private Integer scode;
    @Basic(optional = false)
    @Column(name = "Sname")
    private String sname;
    @Column(name = "Scity")
    private String scity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Scomm")
    private BigDecimal scomm;
    @OneToMany(mappedBy = "salesman")
    private Collection<Family> familyCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "smcode")
    private Collection<Sales> salesCollection;

    public Salesman() {
    }

    public Salesman(Integer scode) {
        this.scode = scode;
    }

    public Salesman(Integer scode, String sname) {
        this.scode = scode;
        this.sname = sname;
    }

    public Integer getScode() {
        return scode;
    }

    public void setScode(Integer scode) {
        this.scode = scode;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getScity() {
        return scity;
    }

    public void setScity(String scity) {
        this.scity = scity;
    }

    public BigDecimal getScomm() {
        return scomm;
    }

    public void setScomm(BigDecimal scomm) {
        this.scomm = scomm;
    }

    @XmlTransient
    public Collection<Family> getFamilyCollection() {
        return familyCollection;
    }

    public void setFamilyCollection(Collection<Family> familyCollection) {
        this.familyCollection = familyCollection;
    }

    @XmlTransient
    public Collection<Sales> getSalesCollection() {
        return salesCollection;
    }

    public void setSalesCollection(Collection<Sales> salesCollection) {
        this.salesCollection = salesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (scode != null ? scode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salesman)) {
            return false;
        }
        Salesman other = (Salesman) object;
        if ((this.scode == null && other.scode != null) || (this.scode != null && !this.scode.equals(other.scode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "emergon.entity.Salesman[ scode=" + scode + " ]";
    }
    
}
