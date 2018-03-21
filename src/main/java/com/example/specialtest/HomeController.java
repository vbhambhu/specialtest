package com.example.specialtest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.UUID;

@Controller
public class HomeController {

    @Autowired
    ElementRepository elementRepository;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model, Element element){
        model.addAttribute("elements", elementRepository.findAll());
        return "home";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String createElement(Element element){
        element.setId(UUID.randomUUID());
        elementRepository.save(element);
        return "redirect:/create/diagram";
    }

    @RequestMapping(value = "/create/diagram", method = RequestMethod.GET)
    public String home(Model model, Diagram diagram){
        model.addAttribute("elements", elementRepository.findAll());
        return "diagram";
    }

    @RequestMapping(value = "/create/diagram", method = RequestMethod.POST)
    public String create(Diagram diagram, @RequestParam(name = "element_id") UUID id){

        diagram.setId(UUID.randomUUID());

        Element element = elementRepository.getOne(id);
        element.setDiagram(diagram);

        elementRepository.save(element);
        return "redirect:/get/elements";
    }

}
