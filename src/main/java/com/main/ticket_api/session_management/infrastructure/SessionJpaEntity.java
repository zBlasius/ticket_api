package com.main.ticket_api.session_management.infrastructure;

import com.main.ticket_api.session_management.domain.Movie;
import com.main.ticket_api.session_management.domain.Room;
import com.main.ticket_api.session_management.domain.Session;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "Session")
public class SessionJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "movie_id", nullable = false)
    @ManyToOne
    private MovieJpaEntity movie;

    @JoinColumn(name = "room_id", nullable = false)
    @ManyToOne
    private RoomJpaEntity room;

    @Column(nullable = false)
    private LocalDateTime inSessionDate;

    @Column(nullable = false)
    private LocalDateTime fromTime;

    @Column(nullable = false)
    private LocalDateTime toTime;

    private Session.Status status;

    private SessionJpaEntity(Integer id, MovieJpaEntity movie, RoomJpaEntity room, Session.Status status, LocalDateTime inSessionDate, LocalDateTime fromTime, LocalDateTime toTime) {
        this.id = id;
        this.movie = movie;
        this.room = room;
        this.status = status;
        this.inSessionDate = inSessionDate;
        this.fromTime = fromTime;
        this.toTime = toTime;
    }

    public static SessionJpaEntity fromDomain(Session session, MovieJpaEntity movie, RoomJpaEntity room, Session.Status status) {
        return new SessionJpaEntity(session.getId(), movie, room, session.getStatus(), session.getInSessionDate(), session.getFromTime(), session.getToTime());
        // use this method in order to save information in database when necessary
    }


    public Session toDomain() {
        return new Session(id, movie.toDomain(), room.toDomain(), inSessionDate, fromTime, toTime, status);
        // use this method to return to domain Room. Notice that RoomJpaEntity and Room are two different things

    }
}
