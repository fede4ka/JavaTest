
package JavaSpringTest.contoller;

import JavaSpringTest.repos.PurchaseRepo;
import JavaSpringTest.repos.UserRepo;
import JavaSpringTest.model.Purchase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import JavaSpringTest.model.Item;
import java.util.Date;
import java.util.stream.Collectors;

@RestController
@Api( tags = {"Контроллер поступающих заказов"})
@SwaggerDefinition(tags = {
		@Tag(name = "Контроллер статистики бд", description = "Контролер поступающих заказов")
})
public class PurchaseController {
	@Autowired
	private PurchaseRepo PRepo;
	@Autowired
	private UserRepo userRepo;
	Date date = new Date();
	@ApiOperation(value = "Здесь обрабатываются поступающие покупки")
	@PostMapping(path="/addpurchase",consumes = { "application/xml;charset=UTF-8" })
	public String customerInformation(@RequestBody Purchase purchase)
	{
		if (PRepo.existsBypid(purchase.getP_id()))
		{return "Покупка с полем pid=" + purchase.getP_id()+ " " + "уже существует!";}
		else if(!userRepo.existsById(purchase.getU_id()))
		{return "Пользователя с id" + purchase.getU_id()+ " " + "не существует!";}
		else
			purchase.setPdate(date);
				PRepo.save(purchase);
		return "Покупка сохранена в базе :" +" "+ purchase.getItems().stream().map(Item::toString).collect(Collectors.toList());
	}
}

