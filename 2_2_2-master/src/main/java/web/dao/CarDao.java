package web.dao;

import web.model.Car;

import java.util.List;

public interface CarDao {

    List<Car> getListCarFilled();

    List<String> getsubList(String count);

    void addCar(Car car);

    void updateCar(Long id, Car car);
    void removeCar(Long id);
    Car getCarById(Long id);

    List<Car> getCars(int count); // Получить список первых count машин

}
