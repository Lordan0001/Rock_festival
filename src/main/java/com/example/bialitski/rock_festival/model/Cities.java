package com.example.bialitski.rock_festival.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="cities")

public class Cities {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false)
    private Long id;

    @Column(nullable=false,unique = true)//add ref in db!!! to usr username
    private String userOfTicket;

    @Column(nullable=false)
    private String city;

    @Column(nullable=false)
    private String ticketPoint;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserOfTicket() {
        return userOfTicket;
    }

    public void setUserOfTicket(String userOfTicket) {
        this.userOfTicket = userOfTicket;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTicketPoint() {
        return ticketPoint;
    }

    public void setTicketPoint(String ticketPoint) {
        this.ticketPoint = ticketPoint;
    }
}
