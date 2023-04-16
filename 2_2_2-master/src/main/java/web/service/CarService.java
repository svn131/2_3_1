package web.service;

import org.springframework.ui.ModelMap;
import web.model.Car;

import java.util.List;

public interface CarService {
    List<Car> getListCarFilled();

    List<String> getsubList(String count);

    void addCar(Car car);



    public Car getCarById(Long id) ;




   void updateCar(Long id, Car car) ;


    void removeCar(Long id) ;

    List<Car> getCars(int parseInt);
}
