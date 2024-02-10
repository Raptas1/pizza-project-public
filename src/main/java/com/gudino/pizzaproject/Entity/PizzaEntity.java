package com.gudino.pizzaproject.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Table("Pizza")
public class PizzaEntity {
    @Id
    private int id;

    @Column("name")
    private String name;

    public PizzaEntity() {

    }

    public PizzaEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public PizzaEntity(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
