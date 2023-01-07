package jwtrestapp.service;

import jwtrestapp.model.Ticket;
import jwtrestapp.model.Train;

import java.util.List;

public interface TicketService {

    List<Ticket> getAll();

    Ticket createTicket(Ticket ticket);

    void deleteTicketByNo(String ticketNo);
}
