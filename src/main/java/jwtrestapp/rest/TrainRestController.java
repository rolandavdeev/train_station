package jwtrestapp.rest;

import jwtrestapp.JwtAppDemoApplication;
import jwtrestapp.dto.UserDto;
import jwtrestapp.model.Status;
import jwtrestapp.model.Train;
import jwtrestapp.model.User;
import jwtrestapp.service.TrainService;
import jwtrestapp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;
import java.util.List;


@CrossOrigin(origins = JwtAppDemoApplication.ALLOWED_HOST, allowCredentials = "true")
@RestController
@RequestMapping(value = "/api/trains/")
@Slf4j
public class TrainRestController {
    private final TrainService trainService;

    @Lazy
    @Autowired
    public TrainRestController(TrainService trainService) {
        this.trainService = trainService;
    }

    @GetMapping("schedule")
    public ResponseEntity<List<Train>> getSchedule(){
        log.info("Sending schedule");
        List<Train> trains = trainService.getAll();

        return new ResponseEntity<>(trains, HttpStatus.OK);
    }

    @PutMapping("add")
    public ResponseEntity<Void> addTrain(@RequestBody Train train){
        train.setCreated(new Date());
        train.setStatus(Status.ACTIVE);
        trainService.addTrain(train);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ExceptionHandler({ SQLIntegrityConstraintViolationException.class })
    public ResponseEntity<String> handleDuplicateKey() {
        return new ResponseEntity<String>("Потяг з таким номером вже існує", new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
