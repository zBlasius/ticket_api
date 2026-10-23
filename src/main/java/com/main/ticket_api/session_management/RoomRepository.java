package com.main.ticket_api.session_management;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends CrudRepository<Room, Integer> {

    @Override
    List<Room> findAll();

    Room findAllById(Integer id);

    Boolean existsByName(String name);
}
