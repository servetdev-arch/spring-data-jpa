package com.servet.spring_data_jpa_rerun.dto;

public class DtoEmployee {

    private String firstName;

    private String lastName;

    public DtoEmployee() {
    }

    public DtoEmployee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
