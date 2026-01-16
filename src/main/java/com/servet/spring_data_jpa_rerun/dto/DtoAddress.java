package com.servet.spring_data_jpa_rerun.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class DtoAddress {

    private Long id;

    private String description;

    private DtoCustomer customer;

    public DtoAddress() {
    }

    public DtoAddress(Long id, String description, DtoCustomer customer) {
        this.id = id;
        this.description = description;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DtoCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(DtoCustomer customer) {
        this.customer = customer;
    }
}
