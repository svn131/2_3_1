package web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;
import java.util.List;




@Controller
public class CarController {

    private  final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars")
    public String printWelcome(@RequestParam(value = "count", defaultValue = "5") String count, ModelMap model) {
        List<String> messages = carService.getsubList(Car.getListCarFilled(),count);
        model.addAttribute("messages", messages);
            System.out.println(Car.getListCarFilled().size());
        return "cars";
    }
}
