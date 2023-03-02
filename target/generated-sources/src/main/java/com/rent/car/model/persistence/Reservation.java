package com.rent.car.model.persistence;
//Generated by Customized Hibernate Tools by Indra :)


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Reservation generated by hbm2java
 */
@Entity
@Table(name="reservation"
    ,schema="car_rental"
)
public class Reservation  implements java.io.Serializable {


     private Long reservationid;
     private Car car;
     private Customer customer;
     private Date startdate;
     private Date enddate;
     private Double reservationprice;
     private Double finalprice;
     private Double penaltyprice;

    public Reservation() {
    }

	
    public Reservation(Car car, Customer customer, Date startdate, Double reservationprice) {
        this.car = car;
        this.customer = customer;
        this.startdate = startdate;
        this.reservationprice = reservationprice;
    }
    public Reservation(Car car, Customer customer, Date startdate, Date enddate, Double reservationprice, Double finalprice, Double penaltyprice) {
       this.car = car;
       this.customer = customer;
       this.startdate = startdate;
       this.enddate = enddate;
       this.reservationprice = reservationprice;
       this.finalprice = finalprice;
       this.penaltyprice = penaltyprice;
    }
   
     @SequenceGenerator(name="com.rent.car.model.persistence.ReservationIdGenerator", sequenceName="reservation_id_seq")@Id @GeneratedValue(strategy=SEQUENCE, generator="com.rent.car.model.persistence.ReservationIdGenerator")

    
    @Column(name="reservationid", unique=true, nullable=false)
    public Long getReservationid() {
        return this.reservationid;
    }
    
    public void setReservationid(Long reservationid) {
        this.reservationid = reservationid;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="carid", nullable=false)
    public Car getCar() {
        return this.car;
    }
    
    public void setCar(Car car) {
        this.car = car;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="customerid", nullable=false)
    public Customer getCustomer() {
        return this.customer;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="startdate", nullable=false, length=13)
    public Date getStartdate() {
        return this.startdate;
    }
    
    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="enddate", length=13)
    public Date getEnddate() {
        return this.enddate;
    }
    
    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    
    @Column(name="reservationprice", nullable=false, precision=0, scale=0)
    public Double getReservationprice() {
        return this.reservationprice;
    }
    
    public void setReservationprice(Double reservationprice) {
        this.reservationprice = reservationprice;
    }

    
    @Column(name="finalprice", precision=0, scale=0)
    public Double getFinalprice() {
        return this.finalprice;
    }
    
    public void setFinalprice(Double finalprice) {
        this.finalprice = finalprice;
    }

    
    @Column(name="penaltyprice", precision=0, scale=0)
    public Double getPenaltyprice() {
        return this.penaltyprice;
    }
    
    public void setPenaltyprice(Double penaltyprice) {
        this.penaltyprice = penaltyprice;
    }




}


