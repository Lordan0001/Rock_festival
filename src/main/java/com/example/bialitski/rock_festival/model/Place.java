package com.example.bialitski.rock_festival.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="place")
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable=false)
    private Long id;


    @Column(nullable=false,unique = true)//это главный для ticketPoint
    private String ticketPlace;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTicketPlace() {
        return ticketPlace;
    }

    public void setTicketPlace(String ticketPlace) {
        this.ticketPlace = ticketPlace;
    }
}
