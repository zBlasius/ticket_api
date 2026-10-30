package com.main.ticket_api.session_management.domain;

import java.time.LocalDateTime;

public class Session {
    private final Integer id;
    private final Movie movie;
    private final Room room;
    private final LocalDateTime inSessionDate;
    private final LocalDateTime fromTime;
    private final LocalDateTime toTime;
    private final Status status;

    public Session(Integer id, Movie movie, Room room, LocalDateTime inSessionDate, LocalDateTime fromTime, LocalDateTime toTime, Status status) {
        this.id = id;
        this.movie = movie;
        this.room = room;
        this.inSessionDate = inSessionDate;
        this.fromTime = fromTime;
        this.toTime = toTime;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public Movie getMovie() {
        return movie;
    }

    public Room getRoom() {
        return room;
    }

    public LocalDateTime getInSessionDate() {
        return inSessionDate;
    }

    public LocalDateTime getFromTime() {
        return fromTime;
    }

    public LocalDateTime getToTime() {
        return toTime;
    }

    public Status getStatus() {
        return status;
    }

    public enum Status {
        FULL,
        AVAILABLE,
        IN_SESSION,
        DONE
    }
}
