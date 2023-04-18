package web.service;

import web.model.User;

import java.util.List;

public interface CarService {
    List<User> getListCarFilled();

    List<String> getsubList(String count);

    void addCar(User user);



    public User getCarById(Long id) ;




   void updateCar(Long id, User user) ;


    void removeCar(Long id) ;

    List<User> getCars(int parseInt);
}
