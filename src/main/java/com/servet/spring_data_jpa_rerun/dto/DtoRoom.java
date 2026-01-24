package com.servet.spring_data_jpa_rerun.dto;

public class DtoRoom {

    private Long id;

    private String name;

    public DtoRoom() {
    }

    public DtoRoom(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
