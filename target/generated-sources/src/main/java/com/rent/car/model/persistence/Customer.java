package com.rent.car.model.persistence;
//Generated by Customized Hibernate Tools by Indra :)


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Customer generated by hbm2java
 */
@Entity
@Table(name="customer"
    ,schema="car_rental"
)
public class Customer  implements java.io.Serializable {


     private Long customerid;
     private Long pointsaccumulated;
     private Set<Reservation> reservations = new HashSet<Reservation>(0);

    public Customer() {
    }

	
    public Customer(Long customerid, Long pointsaccumulated) {
        this.customerid = customerid;
        this.pointsaccumulated = pointsaccumulated;
    }
    public Customer(Long customerid, Long pointsaccumulated, Set<Reservation> reservations) {
       this.customerid = customerid;
       this.pointsaccumulated = pointsaccumulated;
       this.reservations = reservations;
    }
   
     @Id 

    
    @Column(name="customerid", unique=true, nullable=false)
    public Long getCustomerid() {
        return this.customerid;
    }
    
    public void setCustomerid(Long customerid) {
        this.customerid = customerid;
    }

    
    @Column(name="pointsaccumulated", nullable=false)
    public Long getPointsaccumulated() {
        return this.pointsaccumulated;
    }
    
    public void setPointsaccumulated(Long pointsaccumulated) {
        this.pointsaccumulated = pointsaccumulated;
    }

		@OneToMany(fetch=FetchType.LAZY, mappedBy="customer")
	
    public Set<Reservation> getReservations() {
        return this.reservations;
    }
    
    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }




}

