package web.service;


import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;


@Service
public class CarServicelmp implements CarService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    List<Car> carsList = new ArrayList<>();
    @Override
    public List<Car> getListCarFilled() {

        carsList = jdbcTemplate.query("SELECT * FROM car", (rs, rowNum) ->
                new Car(rs.getString("model"), rs.getInt("series"), rs.getString("color")));

        return carsList;
    }



    @Override
    public List<String> getsubList(List<Car> cars, String count) {
        int i = Integer.valueOf(count);
        List<Car> subcarsList;
        List<String> messages = new ArrayList<>();
        if (cars.size() >= i) {
            subcarsList = cars.subList(0, i);
        } else {
            subcarsList = cars;
        }
        for (Car car : subcarsList) {
            messages.add(car.getModel() + " " + car.getSeries() + " " + car.getColor());
        }
        return messages;
    }

}
//    @Override
//    public List<Car> getListCarFilled() {
//        List<Car> carsList = new ArrayList<>();
//
//        Car car1 = new Car("Toyota", 2021, "Red");
//        carsList.add(car1);
//
//        Car car2 = new Car("Honda", 2020, "Blue");
//        carsList.add(car2);
//
//        Car car3 = new Car("BMW", 2019, "Black");
//        carsList.add(car3);
//
//        Car car4 = new Car("Ford", 2018, "White");
//        carsList.add(car4);
//
//        Car car5 = new Car("Mazda", 2017, "Silver");
//        carsList.add(car5);
//
//        return carsList;
//    }


//@Service
//public class CarServicelmp implements CarService {
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    @Override
//    public List<Car> getListCarFilled() {
//        List<Car> carsList = jdbcTemplate.query("SELECT * FROM cars", (rs, rowNum) ->
//                new Car(rs.getString("model"), rs.getInt("year"), rs.getString("color")));
//
//        return carsList;
//    }
//
//
//
//        @Override
//    public List<String> getsubList(List<Car> cars, String count) {
//        int i = Integer.valueOf(count);
//        List<Car> subcarsList;
//        List<String> messages = new ArrayList<>();
//        if (cars.size() >= i) {
//            subcarsList = cars.subList(0, i);
//        } else {
//            subcarsList = cars;
//        }
//        for (Car car : subcarsList) {
//            messages.add(car.getModel() + " " + car.getSeries() + " " + car.getColor());
//        }
//        return messages;
//    }