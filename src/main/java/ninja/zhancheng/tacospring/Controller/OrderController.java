package ninja.zhancheng.tacospring.Controller;

import javax.validation.Valid;


import ninja.zhancheng.tacospring.Data.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.extern.slf4j.Slf4j;
import ninja.zhancheng.tacospring.Domain.Order;
import ninja.zhancheng.tacospring.Domain.Taco;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	private OrderRepository orderRepo;
	@GetMapping("/current")
	public String orderForm(Model model) {
		model.addAttribute("order", new Order());
		return "orderForm";
	}
	@PostMapping
	public String processOrder(@Valid Order order, Errors errors, SessionStatus sessionStatus) {
		if (errors.hasErrors()) {
			return "orderForm";
		}

		orderRepo.save(order);
		sessionStatus.setComplete();
		log.info("Order submitted: " + order);
		return "redirect:/";
	}

}