package jwtrestapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jwtrestapp.model.Ticket;
import jwtrestapp.model.WagonType;
import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TicketDto {
    private String passengerFullname;
    private String ticketNo;
    private String trainNo;
    private String dispatchPlace;
    private String incomePlace;
    private String dispatchTime;
    private String incomeTime;
    private Integer wagonNo;
    private Integer seatNo;
    private String wagonType;
    private Boolean whiteness;

    public Ticket toTicket() throws ParseException {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Ticket ticket = new Ticket();
        ticket.setPassengerFullname(passengerFullname);
        ticket.setTicketNo(ticketNo);
        ticket.setTrainNo(trainNo);
        ticket.setDispatchPlace(dispatchPlace);
        ticket.setIncomePlace(incomePlace);
        ticket.setDispatchTime(parser.parse(dispatchTime));
        ticket.setIncomeTime(parser.parse(incomeTime));
        ticket.setWagonNo(wagonNo);

        WagonType _wagonType = WagonType.find(wagonType);
        if(seatNo < 1 || seatNo > _wagonType.getPlaces())
            throw new IllegalArgumentException("Incorrect place number");

        ticket.setSeatNo(seatNo);
        ticket.setWagonType(_wagonType.getName());
        ticket.setWhiteness(whiteness);
        ticket.setPrice(_wagonType.getPrice());
        return ticket;
    }
}
