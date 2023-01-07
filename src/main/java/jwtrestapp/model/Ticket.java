package jwtrestapp.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "tickets")
@Data
public class Ticket extends BaseEntity {
    @Column(name = "passenger_fullname")
    private String passengerFullname;

    @Column(name = "ticket_no")
    private String ticketNo;

    @Column(name = "train_no")
    private String trainNo;

    @Column(name = "dispatch_place")
    private String dispatchPlace;

    @Column(name = "income_place")
    private String incomePlace;

    @Column(name = "dispatch_time")
    private Date dispatchTime;

    @Column(name = "income_time")
    private Date incomeTime;

    @Column(name = "wagon_no")
    private Integer wagonNo;

    @Column(name = "seat_no")
    private Integer seatNo;

    @Column(name = "wagon_type")
    private String wagonType;

    @Column(name = "whiteness")
    private Boolean whiteness;

    @Column(name = "price")
    private Integer price;
}
