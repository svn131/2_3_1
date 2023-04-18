package web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;

import javax.validation.Valid;
import java.util.List;


@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public String printUsers(ModelMap model) {
        List<User> users = userService.getUsers(Integer.MAX_VALUE);
        model.addAttribute("users", users); // добавляем в модель список объектов Car
        return "users";
    }

    @PostMapping(value = "/users/add")
    public String addUser(@RequestParam("name") String model, @RequestParam("age") int series,
                          @RequestParam("city") String color) {
        userService.addUser(new User(model, series, color));
        return "redirect:/users";
    }

    @PostMapping("/users/edit")
    public String editUser(@RequestParam("id") Long id, ModelMap modelMap) {
        User user = userService.getUserById(id);
        modelMap.addAttribute("user", user);
        return "edit";
    }


    @PostMapping("/users/update")
    public String updateUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, @RequestParam("id") Long id) {
        if (bindingResult.hasErrors()) {
            return "edit-user";
        }
        userService.updateUser(id, user);
        return "redirect:/users";
    }

    @PostMapping("/users/remove")
    public String removeUser(@RequestParam("id") Long id) {
        userService.removeUser(id);
        System.out.println(id);
        return "redirect:/users";
    }

}