package com.main.ticket_api.session_management;

import jakarta.persistence.*;

@Entity
public class Room {


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(unique = true, nullable = false)
    private String name;

    public int getChairs_capacity() {
        return chairs_capacity;
    }

    public void setChairs_capacity(int chairs_capacity) {
        this.chairs_capacity = chairs_capacity;
    }

    public int getId() {
        return id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int chairs_capacity;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    private Status status;

    public enum Status{
        FREE,
        OCCUPIED,
    }

}
