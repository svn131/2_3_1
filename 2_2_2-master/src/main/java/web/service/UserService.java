package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getListCarFilled();

    List<String> getsubList(String count);

    void addUser(User user);



    public User getUserById(Long id) ;




   void updateUser(Long id, User user) ;


    void removeUser(Long id) ;

    List<User> getUsers(int parseInt);
}