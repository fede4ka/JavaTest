package JavaSpringTest.contoller;

import JavaSpringTest.repos.UserRepo;
import JavaSpringTest.model.Purchase;
import JavaSpringTest.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
@Api( tags = {"Контроллер авторизации"})
@SwaggerDefinition(tags = {
        @Tag(name = "Контроллер логина", description = "Контроллер обслуживающий авторизацию")})
public class UserpageController {
    @Autowired
    private UserRepo userRepo;
    @ApiOperation(value = "Страница пользователя")
    @GetMapping("/userpage")
    public String Userpage(Model model)
    { UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = userDetails.getUsername();
        User user = userRepo.findByUsername(name);
        List<Purchase> purch = user.getPurchases();
        model.addAttribute("pur", purch);
        return "userpage";
    }
}
