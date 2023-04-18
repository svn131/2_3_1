package web.dao;

import web.model.User;

import java.util.List;

public interface CarDao {

    List<User> getListCarFilled();

    List<String> getsubList(String count);

    void addCar(User user);

    void updateCar(Long id, User user);
    void removeCar(Long id);
    User getCarById(Long id);

    List<User> getCars(int count); // Получить список первых count машин

}
