package jwtrestapp.service;

import jwtrestapp.model.Train;

import java.util.List;

public interface TrainService {

    List<Train> getAll();

    void deleteTrainByNo(String trainNo);

    void addTrain(Train train);
}
