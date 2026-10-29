package com.main.ticket_api.session_management.web;

import java.sql.Timestamp;

public class CreateSessionRequestDTO {

    private Timestamp from_time;
    private Timestamp to_time;
    private Integer room_id;
    private Integer movie_id;

    public Timestamp getIn_session_date() {
        return in_session_date;
    }

    public void setIn_session_date(Timestamp in_session_date) {
        this.in_session_date = in_session_date;
    }

    public Integer getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Integer movie_id) {
        this.movie_id = movie_id;
    }

    public Integer getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Integer room_id) {
        this.room_id = room_id;
    }

    public Timestamp getTo_time() {
        return to_time;
    }

    public void setTo_time(Timestamp to_time) {
        this.to_time = to_time;
    }

    public Timestamp getFrom_time() {
        return from_time;
    }

    public void setFrom_time(Timestamp from_time) {
        this.from_time = from_time;
    }

    private Timestamp in_session_date;

}
