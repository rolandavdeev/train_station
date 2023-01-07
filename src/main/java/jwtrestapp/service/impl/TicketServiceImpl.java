package jwtrestapp.service.impl;

import jwtrestapp.model.Ticket;
import jwtrestapp.model.Train;
import jwtrestapp.repository.TicketRepository;
import jwtrestapp.service.TicketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class TicketServiceImpl implements TicketService {

    @Lazy
    @Autowired
    private final TicketRepository ticketRepository;

    @Lazy
    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public List<Ticket> getAll() {
        return this.ticketRepository.findAll();
    }

    @Override
    public Ticket createTicket(Ticket ticket) {
        return this.ticketRepository.createTicket(ticket);
    }

    @Override
    public void deleteTicketByNo(String ticketNo) {
        this.ticketRepository.deleteTicketByNo(ticketNo);
    }
}
