package web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.List;


@Controller
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars")
    public String printCars(ModelMap model) {
        List<Car> cars = carService.getCars(Integer.MAX_VALUE);
        model.addAttribute("cars", cars); // добавляем в модель список объектов Car
        return "cars";
    }

    @PostMapping(value = "/cars/add")
    public String addCar(@RequestParam("model") String model, @RequestParam("series") int series,
                         @RequestParam("color") String color) {
        carService.addCar(new Car(model, series, color));
        return "redirect:/cars";
    }

    @PostMapping("/cars/edit")
    public String editCar(@RequestParam("id") Long id, ModelMap modelMap) {
        Car car = carService.getCarById(id);
        modelMap.addAttribute("car", car);
        return "edit";
    }

    @PostMapping("/cars/update")
    public String updateCar(@ModelAttribute("car") Car car, @RequestParam("id") Long id) {
        carService.updateCar(id, car);
        return "redirect:/cars";
    }

    @PostMapping("/cars/remove")
    public String removeCar(@RequestParam("id") Long id) {
        carService.removeCar(id);
        System.out.println(id);
        return "redirect:/cars";
    }

}
