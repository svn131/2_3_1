package web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String printCars(@RequestParam(value = "count", defaultValue = "5") String count, ModelMap model) {
        List<String> messages = carService.getsubList(count);
        model.addAttribute("messages", messages);
        return "cars";
    }

    @PostMapping(value = "/cars/add")
    public String addCar(@RequestParam("model") String model, @RequestParam("series") int series,
                         @RequestParam("color") String color, ModelMap modelMap) {
        carService.addCar(new Car(model, series, color));
        return "redirect:/cars";
    }

}
