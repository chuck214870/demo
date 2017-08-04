package com.example.demo;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GreetingController {
    @Autowired
    private GreetRepository greetRepository;
	
	@GetMapping("/greeting")
	public String greetingForm(Model model){
		model.addAttribute("greeting", new Greeting());
		return "greeting";
	}
	
	@PostMapping("/greeting")
    //@PostMapping("/addthis/greeting")
    public String greetingSubmit(@Valid Greeting greeting, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "greeting";
        }
        greetRepository.save(greeting);

        return "result";
    }

}
