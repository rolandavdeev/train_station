package jwtrestapp.rest;

import jwtrestapp.JwtAppDemoApplication;
import jwtrestapp.dto.TicketDeleteDto;
import jwtrestapp.dto.TicketDto;
import jwtrestapp.model.Ticket;
import jwtrestapp.model.Train;
import jwtrestapp.service.TicketService;
import jwtrestapp.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@CrossOrigin(origins = JwtAppDemoApplication.ALLOWED_HOST,allowCredentials = "true")
@RestController
@RequestMapping(value = "/api/tickets/")
public class TicketRestController {
    private final TicketService ticketService;

    @Lazy
    @Autowired
    public TicketRestController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("list")
    public ResponseEntity<List<Ticket>> getAll(){
        List<Ticket> tickets = ticketService.getAll();
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    @PutMapping("create")
    public ResponseEntity<Void> createTicket(@RequestBody TicketDto ticketDto) {
        try {
            Ticket ticket = ticketService.createTicket(ticketDto.toTicket());
        } catch (ParseException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("delete/{ticketNo}")
    public ResponseEntity<String> deleteTicket(@PathVariable String ticketNo){
        ticketService.deleteTicketByNo(ticketNo);
        return new ResponseEntity<>(ticketNo, HttpStatus.OK);
    }

}
