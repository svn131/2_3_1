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
    public List<String> getsubList(String count) {
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

