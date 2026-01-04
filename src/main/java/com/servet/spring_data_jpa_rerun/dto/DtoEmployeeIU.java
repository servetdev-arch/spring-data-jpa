package com.servet.spring_data_jpa_rerun.dto;

import java.time.LocalDate;

public class DtoEmployeeIU {

    private String firstName;

    private String lastName;

    private LocalDate birthDate;

    private String salary;

    public DtoEmployeeIU() {
    }

    public DtoEmployeeIU(String firstName, String lastName, LocalDate birthDate, String salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.salary = salary;
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
