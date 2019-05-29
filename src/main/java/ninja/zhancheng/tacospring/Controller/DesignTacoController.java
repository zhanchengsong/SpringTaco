package ninja.zhancheng.tacospring.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import ninja.zhancheng.tacospring.Data.IngredientRepository;
import ninja.zhancheng.tacospring.Domain.Ingredient;
import ninja.zhancheng.tacospring.Domain.Ingredient.Type;

import ninja.zhancheng.tacospring.Domain.Taco;


@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {

	private final IngredientRepository ingredientRepository;
	@Autowired
	public DesignTacoController(IngredientRepository ingredientRepo) {
		this.ingredientRepository = ingredientRepo;
	}

	@GetMapping
	public String showDesignForm(Model model) {
		List<Ingredient> ingredients = new ArrayList<>();
		ingredientRepository.findAll().forEach(i -> ingredients.add(i));

		Type[] types = Ingredient.Type.values();
		for (Type type : types) {
			model.addAttribute(type.toString().toLowerCase(),
					filterByType(ingredients, type));
		}

		model.addAttribute("design", new Taco());

		return "design";
	}

	@PostMapping
	public String processDesign(@Valid Taco design, Errors errors) {
		if (errors.hasErrors()) {
			return "design";
		}

		// Save the taco design...
		// We'll do this in chapter 3
		log.info("Processing design: " + design);

		return "redirect:/orders/current";
	}

	private List<Ingredient> filterByType(
			List<Ingredient> ingredients, Type type) {
		return ingredients
				.stream()
				.filter(x -> x.getType().equals(type))
				.collect(Collectors.toList());
	}

}