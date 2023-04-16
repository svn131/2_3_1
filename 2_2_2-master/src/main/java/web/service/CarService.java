package web.service;

import web.model.Car;

import java.util.List;

public interface CarService {
    List<Car> getListCarFilled();

    List<String> getsubList(String count);

    void addCar(Car car);
}
