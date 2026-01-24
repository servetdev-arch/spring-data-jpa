package com.servet.spring_data_jpa_rerun.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DtoHome {

    private Long id;

    private BigDecimal price;

    private List<DtoRoom> rooms = new ArrayList<>();

    public DtoHome() {
    }

    public DtoHome(Long id, BigDecimal price, List<DtoRoom> rooms) {
        this.id = id;
        this.price = price;
        this.rooms = rooms;
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

    public List<DtoRoom> getRooms() {
        return rooms;
    }

    public void setRooms(List<DtoRoom> rooms) {
        this.rooms = rooms;
    }
}
