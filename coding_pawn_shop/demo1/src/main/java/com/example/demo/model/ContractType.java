package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "contract_type")
public class ContractType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public ContractType(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ContractType() {
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