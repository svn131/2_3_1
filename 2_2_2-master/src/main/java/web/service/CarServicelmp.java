package web.service;


import org.springframework.stereotype.Service;
import web.model.Car;
import java.util.ArrayList;
import java.util.List;


@Service
public class CarServicelmp implements CarService {


    @Override
    public  List<Car> getTheNumberOfCars(List<Car> cars, Integer i) {
        if (cars.size() >= i) {
            return cars.subList(0, i);
        } else {
            return cars;
        }
    }

    @Override
    public  List<String> getsubList(List<Car> cars, String count) {
        List<String> messages = new ArrayList<>();
        List<Car> subcarsList = getTheNumberOfCars(cars, Integer.valueOf(count));
        for (Car car : subcarsList) {
            messages.add(car.getModel() + " " + car.getSeries() + " " + car.getColor());
        }
        return messages;
    }


}
