package web.dao;

import web.model.Car;

import java.util.List;

public interface CarDao {
    void add(Car car);

    List<Car> getListCarFilled();

    List<String> getsubList(String count);

    void addCar(Car car);
}
