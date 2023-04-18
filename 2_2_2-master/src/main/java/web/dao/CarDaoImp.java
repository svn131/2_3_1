package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;


@Transactional(readOnly = true)
@Repository
public class CarDaoImp implements  CarDao{

    @PersistenceContext
    private EntityManager entityManager;

//    public CarDaoImp(EntityManager entityManager) {
//        this.entityManager=entityManager;
//    }




    @Override
    public List<User> getListCarFilled() {
        List<User> users = entityManager
                .createQuery("SELECT c FROM User c", User.class)
                .getResultList();
        return users;
    }

    @Override
    public List<String> getsubList(String count) {
        List<User> users = getListCarFilled();
        int i = Integer.valueOf(count);
        List<String> messages = new ArrayList<>();
        List<User> subCarsList;
        subCarsList = users;
        for (User user : subCarsList) {
            messages.add(user.getModel() + " " + user.getSeries() + " " + user.getColor());
        }
        return messages;
    }

    @Override
    @Transactional
    public void addCar(User user) {
        entityManager.persist(user);
        List<User> users = getListCarFilled();
    }

    @Override
    @Transactional
    public void updateCar(Long id, User user) {
        User existingUser = entityManager.find(User.class, id);
        if (existingUser != null) {
            existingUser.setModel(user.getModel());
            existingUser.setSeries(user.getSeries());
            existingUser.setColor(user.getColor());
            entityManager.merge(existingUser);
        }
    }

    @Override
    @Transactional
    public void removeCar(Long id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }

    @Override
    @Transactional
    public User getCarById(Long id) {
        return entityManager.find(User.class, id);
    }



    @Override
    public List<User> getCars(int count) {
        return entityManager.createQuery("SELECT c FROM User c", User.class)
                .setMaxResults(count)
                .getResultList();
    }

}
