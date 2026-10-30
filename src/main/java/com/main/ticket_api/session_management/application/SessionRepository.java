package com.main.ticket_api.session_management.application;

import com.main.ticket_api.session_management.domain.Session;

import java.util.List;

public interface SessionRepository
{
    List<Session> findAll();

}
