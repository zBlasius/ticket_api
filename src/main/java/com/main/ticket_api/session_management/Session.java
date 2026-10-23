package com.main.ticket_api.session_management;

import jakarta.persistence.*;

import java.sql.Timestamp;

public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Movie getMovie() {
        return movie;
    }

    public Integer getId() {
        return id;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Timestamp getIn_session_date() {
        return in_session_date;
    }

    public void setIn_session_date(Timestamp in_session_date) {
        this.in_session_date = in_session_date;
    }

    public Timestamp getFrom_time() {
        return from_time;
    }

    public void setFrom_time(Timestamp from_time) {
        this.from_time = from_time;
    }

    public Timestamp getTo_time() {
        return to_time;
    }

    public void setTo_time(Timestamp to_time) {
        this.to_time = to_time;
    }

    @JoinColumn(name = "movie_id", nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Movie movie;

    @JoinColumn(name = "room_id", nullable = false, unique = true)
    @ManyToOne(cascade = CascadeType.ALL)
    private Room room;

    private Timestamp in_session_date;

    private Timestamp from_time;

    private Timestamp to_time;

    private enum Status {
        FULL,
        AVAILABLE,
        IN_SESSION,
        DONE
    }


}
