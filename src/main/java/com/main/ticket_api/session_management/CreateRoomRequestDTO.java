package com.main.ticket_api.session_management;

public class CreateRoomRequestDTO {


    private Integer chairCapacity;
    private String name;

    public void setChairCapacity(Integer chairCapacity, String name) {
        this.chairCapacity = chairCapacity;
        this.name = name;
    }

    public Integer getChairCapacity() {
        return chairCapacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

