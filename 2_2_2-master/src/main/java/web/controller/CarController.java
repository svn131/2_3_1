package web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.CarService;

import javax.validation.Valid;
import java.util.List;


@Controller
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/users")
    public String printCars(ModelMap model) {
        List<User> users = carService.getCars(Integer.MAX_VALUE);
        model.addAttribute("users", users); // добавляем в модель список объектов Car
        return "users";
    }

    @PostMapping(value = "/users/add")
    public String addCar(@RequestParam("model") String model, @RequestParam("series") int series,
                         @RequestParam("color") String color) {
        carService.addCar(new User(model, series, color));
        return "redirect:/users";
    }

    @PostMapping("/users/edit")
    public String editCar(@RequestParam("id") Long id, ModelMap modelMap) {
        User user = carService.getCarById(id);
        modelMap.addAttribute("user", user);
        return "edit";
    }


    @PostMapping("/users/update")
    public String updateCar(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, @RequestParam("id") Long id) {
        if (bindingResult.hasErrors()) {
            // Если есть ошибки валидации, возвращаем страницу с формой редактирования с сообщениями об ошибках
            return "edit-car";
        }
        carService.updateCar(id, user);
        return "redirect:/users";
    }

    @PostMapping("/users/remove")
    public String removeCar(@RequestParam("id") Long id) {
        carService.removeCar(id);
        System.out.println(id);
        return "redirect:/users";
    }

}