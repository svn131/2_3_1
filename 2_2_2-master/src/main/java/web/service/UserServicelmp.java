package web.service;

import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServicelmp implements UserService {

    private final UserDao userDao;

    public UserServicelmp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getListCarFilled() {
        return userDao.getListUserFilled();
    }

    @Override
    public List<String> getsubList( String count) {
        return userDao.getsubList(count);
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public User getUserById(Long id) {
       return userDao.getUserById(id);
    }

    @Override
    public void updateUser(Long id, User user) {
    userDao.updateUser(id, user);
    }

    @Override
   public void removeUser(Long id) {
       userDao.removeUser(id);
    }

    @Override
    public List<User> getUsers(int parseInt) {
        return userDao.getUsers(parseInt);
    }


}

//    @Override
//    public void addCar(String model, int series, String color) {
//        carDao.addCar(model, series, color);
//    }
//}

//
//    @PersistenceContext
//    private EntityManager entityManager;


//
//    @Override
//    public List<Car> getListCarFilled() {
//        List<Car> cars = entityManager
//                .createQuery("SELECT c FROM Car c", Car.class)
//                .getResultList();
//        return cars;
//    }

//    @Override
//    public List<String> getsubList(List<Car> cars, String count) {
//        int i = Integer.valueOf(count);
//        List<String> messages = new ArrayList<>();
//        List<Car> subCarsList;
//        if (cars.size() >= i) {
//            subCarsList = cars.subList(0, i);
//        } else {
//            subCarsList = cars;
//        }
//        for (Car car : subCarsList) {
//            messages.add(car.getModel() + " " + car.getSeries() + " " + car.getColor());
//        }
//        return messages;
//    }




//


























































//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.stereotype.Service;
//import web.model.Car;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import javax.persistence.EntityManager;
//
//@Service
//public class CarServicelmp implements CarService {
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//    List<Car> carsList = new ArrayList<>();
//    @Autowired
//    private LocalContainerEntityManagerFactoryBean entityManager;
//
//    @Override
//    public List<Car> getListCarFilled() {
//        List<Car> carsList = entityManager.createQuery("SELECT c FROM Car c", Car.class).getResultList();
//        return carsList;
//    }
//
//
//
////    @Override
////    public List<Car> getListCarFilled() {
////
////        carsList = jdbcTemplate.query("SELECT * FROM car", (rs, rowNum) ->
////                new Car(rs.getString("model"), rs.getInt("series"), rs.getString("color")));
////
////        return carsList;
////    }
//
//
//
//    @Override
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
//
//}
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