package JavaSpringTest.contoller;

import JavaSpringTest.model.Role;
import JavaSpringTest.model.User;
import JavaSpringTest.repos.UserRepo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
@Api( tags = {"Контроллер отвечающий за регистрацию"})
@SwaggerDefinition(tags = {
        @Tag(name = "Контроллер отвечающий за регистрацию", description = "Контроллер обслуживающий регистрацию")
})
public class RegistrationController {
    @Autowired
    private UserRepo userRepo;

    @ApiOperation(value = "Операция отвечающая за регистрацию")
    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }
    @ApiOperation(value = "Операция отвечающая за регистрацию")
    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        User userFromDb = userRepo.findByUsername(user.getUsername());

        if (userFromDb != null) {
            model.put("message", "Такой пользователь уже существует!");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);

        return "redirect:/login";
    }
}
