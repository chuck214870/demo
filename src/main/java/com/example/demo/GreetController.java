package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/greet")
public class GreetController {
    @Autowired
    private GreetRepository greetRepository;

    @GetMapping(path="/add")
    public @ResponseBody String addNewGreet(@RequestParam String content)
            {
                //note: this expects you to know that you would add "?content=bob" in the url on browser... so "/greet/add?content=bob"
                Greeting g = new Greeting();
                g.setContent(content);
                greetRepository.save(g);
                return "Saved";
            }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Greeting> getAllUsers()
    {
        return greetRepository.findAll();
    }
}
