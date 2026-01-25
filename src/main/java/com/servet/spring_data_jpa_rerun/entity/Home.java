package com.servet.spring_data_jpa_rerun.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "home")
public class Home {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "price")
    private BigDecimal price;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "home_id")
    private List<Room> room = new ArrayList<>();


    public Home() {
    }

    public Home(Long id, BigDecimal price, List<Room> room) {
        this.id = id;
        this.price = price;
        this.room = room;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<Room> getRoom() {
        return room;
    }

    public void setRooms(List<Room> room) {
        this.room = room;
    }
}
