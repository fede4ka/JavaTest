package JavaSpringTest.contoller;

import JavaSpringTest.repos.PurchaseRepo;
import JavaSpringTest.repos.UserRepo;
import JavaSpringTest.model.Item;
import JavaSpringTest.model.Purchase;
import JavaSpringTest.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import java.util.stream.Collectors;

@Controller
@Api( tags = {"Контроллер статистики бд"})
@SwaggerDefinition(tags = {
        @Tag(name = "Контроллер статистики бд", description = "Контроллер обслуживающий статистику дб, т.е. /stats")
})
public class DBStatsController {
    @Autowired
    private PurchaseRepo pRepo;
    @Autowired
    private UserRepo userRepo;
    @ApiOperation(value = "Посмотреть статистику бд")
    @GetMapping("/stats")
    public String Userpage(Model model)
    {   //per week
        List<Purchase> lw = pRepo.lastweek();
        model.addAttribute("lw", lw);
        //most frequent item per month
//        List<Purchase> lm = pRepo.lastMonth();
//        String mfi = lm
//                        .stream()
//                        .flatMap(x -> x.getItems().stream())
//                        .map(Item::getName)
//                        .collect(Collectors.groupingBy(w -> w, Collectors.counting()))
//                        .entrySet()
//                        .stream()
//                        .max(Map.Entry.comparingByValue())
//                        .map(Map.Entry::getKey)
//                        .orElse("Ничего не продали.");;
        String mfi = Optional.ofNullable(pRepo.mpipermonth()).orElse("Ничего не продали");
        model.addAttribute("mfi", mfi);
        //most purchases per half year
//        List<Purchase> hy = pRepo.lastHalfYear();
//        int id = hy.stream()
//                    .map(Purchase::getU_id)
//                    .collect(Collectors.groupingBy(w -> w, Collectors.counting()))
//                    .entrySet()
//                    .stream()
//                    .max(Map.Entry.comparingByValue())
//                    .map(Map.Entry::getKey)
//                    .orElse(0);
//        if (id==0) {model.addAttribute("namelastname", "Никто ничего не купил, вбей уже данные в таблицу!");}
//        else {
//        User buratino = userRepo.findById(id).orElse(new User());
//       String namelastname = buratino.getInfo().getName() +" " + buratino.getInfo().getLastname();

        String namelastname = Optional.ofNullable(pRepo.buratino()).orElse("Такого пользователя нет");
        model.addAttribute("namelastname", namelastname);
        //18yo users
//        List<User> users18 = userRepo.findAll()
//                                    .stream()
//                                    .filter(user -> user.getPurchases().size()>0)
//                                    .filter(user -> user.getInfo().getAge()==18).collect(Collectors.toList());
        //most frequent item of 18yo users
//        String mfi18 = users18.stream()
//                                .flatMap(x -> x.getPurchases().stream())
//                                .flatMap(x->x.getItems().stream())
//                                .map(Item::getName)
//                                .collect(Collectors.groupingBy(w -> w, Collectors.counting()))
//                                .entrySet()
//                                .stream()
//                                .max(Map.Entry.comparingByValue())
//                                .map(Map.Entry::getKey)
//                                 .orElse("Такого пользователя нет.");
        String mfi18 = Optional.ofNullable(pRepo.mfi18yo()).orElse("Ничего не купили");
        model.addAttribute("mfi18", mfi18);
       return "stats";
    }
}


