package web.service;

import web.model.Car;
import java.util.List;

public interface CarService {

    List<Car> getTheNumberOfCars(List<Car> cars, Integer i) ;



    List<String> getsubList(List<Car> cars, String count);

}
