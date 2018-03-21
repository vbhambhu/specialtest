package com.example.specialtest;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    ElementRepository elementRepository;

    @ResponseBody
    @RequestMapping(value = "/get/elements", method = RequestMethod.GET)
    public List<Element> getElements() {
        return elementRepository.findAll();
    }


}
