package jwtrestapp.repository;

import jwtrestapp.model.Ticket;
import jwtrestapp.model.Train;
import jwtrestapp.model.WagonType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
@Slf4j
public class TicketRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Ticket createTicket(Ticket ticket)
    {
        String sql = "INSERT INTO tickets " + "(ticket_no, train_no, passenger_fullname, dispatch_place, income_place, dispatch_time, income_time, wagon_no, seat_no,wagon_type,whiteness,price) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator()
        {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection)
                    throws SQLException
            {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                int id = 1;
                ps.setString(id++, ticket.getTicketNo());
                ps.setString(id++, ticket.getTrainNo());
                ps.setString(id++, ticket.getPassengerFullname());
                ps.setString(id++, ticket.getDispatchPlace());
                ps.setString(id++, ticket.getIncomePlace());
                ps.setDate(id++, new java.sql.Date(ticket.getDispatchTime().getTime()));
                ps.setDate(id++, new java.sql.Date(ticket.getIncomeTime().getTime()));
                ps.setInt(id++, ticket.getWagonNo());
                ps.setInt(id++, ticket.getSeatNo());
                ps.setString(id++, ticket.getWagonType().toString());
                ps.setBoolean(id++, ticket.getWhiteness());
                ps.setInt(id++, ticket.getPrice());
                return ps;
            }
        }, holder);

        log.info("genereatedTicket = " + ticket.toString());
        return ticket;
    }

    public void deleteTicketByNo(String ticketNo) {
        String sql = "DELETE FROM tickets WHERE ticket_no=?";
        jdbcTemplate.update(sql, ticketNo);

        log.info("deletedTicket = " + ticketNo);
    }

    public List<Ticket> findAll() {
        String sql = "SELECT * FROM tickets";
        List<Ticket> ticketList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Ticket.class));

        return ticketList;
    }
}