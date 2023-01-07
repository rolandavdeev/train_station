package jwtrestapp.service.impl;

import jwtrestapp.model.Ticket;
import jwtrestapp.model.Train;
import jwtrestapp.repository.TrainRepository;
import jwtrestapp.repository.UserRepository;
import jwtrestapp.service.TrainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TrainServiceImpl implements TrainService {
    private final TrainRepository trainRepository;

    @Lazy
    @Autowired
    public TrainServiceImpl(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    @Override
    public List<Train> getAll() {
        return this.trainRepository.findAll();
    }

    @Override
    public void deleteTrainByNo(String trainNo) {
        this.trainRepository.deleteByTrainNo(trainNo);
    }

    @Override
    public void addTrain(Train train) {
        this.trainRepository.save(train);
    }
}
