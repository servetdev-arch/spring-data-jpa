package com.servet.spring_data_jpa_rerun.dto;


import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class DtoCustomer {
    private Long id;
    private String name;

    private DtoAddress address;

    public DtoCustomer() {
    }

    public DtoCustomer(Long id, String name, DtoAddress address) {
        this.id = id;
        this.name = name;
        this.address = address;
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

    public DtoAddress getAddress() {
        return address;
    }

    public void setAddress(DtoAddress address) {
        this.address = address;
    }
}
