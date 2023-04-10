package web.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Car {

    private String model;
    private int series;
    private String color;
    private static List<Car> carsList = new ArrayList<>();


    public Car() {
    }

    public Car(String model, int series, String color) {
        this.model = model;
        this.series = series;
        this.color = color;
    }

    public static List<Car> getListCarFilled(){
        Car car1 = new Car("Toyota", 2021, "Red");
        carsList.add(car1);

        Car car2 = new Car("Honda", 2020, "Blue");
        carsList.add(car2);

        Car car3 = new Car("BMW", 2019, "Black");
        carsList.add(car3);

        Car car4 = new Car("Ford", 2018, "White");
        carsList.add(car4);

        Car car5 = new Car("Mazda", 2017, "Silver");
        carsList.add(car5);

         return carsList;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }





    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car car)) return false;
        return getSeries() == car.getSeries() && Objects.equals(getModel(), car.getModel()) && Objects.equals(getColor(), car.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getModel(), getSeries(), getColor());
    }
}

