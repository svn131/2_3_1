package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.Car;

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
    public void add(Car car) {

    }

    @Override
    public List<Car> getListCarFilled() {
        List<Car> cars = entityManager
                .createQuery("SELECT c FROM Car c", Car.class)
                .getResultList();
        return cars;
    }

    @Override
    public List<String> getsubList(String count) {
        List<Car> cars = getListCarFilled();
        int i = Integer.valueOf(count);
        List<String> messages = new ArrayList<>();
        List<Car> subCarsList;
        subCarsList = cars;
        for (Car car : subCarsList) {
            messages.add(car.getModel() + " " + car.getSeries() + " " + car.getColor());
        }
        return messages;
    }

    @Override
    @Transactional
    public void addCar(Car car) {
        entityManager.persist(car);
        List<Car> cars = getListCarFilled();
    }





}
