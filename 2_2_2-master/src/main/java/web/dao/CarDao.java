package web.dao;

import web.model.Car;

import java.util.List;

public interface CarDao {
    void add(Car car);

    List<Car> getListCarFilled();

    List<String> getsubList(List<Car> cars, String count);
}
