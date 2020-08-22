package com.edineva.calculator2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class Calculator2Controller {
     @Autowired
     private Calculator2 calculator;

     @RequestMapping("/sum")
     String sum(@RequestParam("a") Integer a, 
                @RequestParam("b") Integer b) {
          return String.valueOf(calculator.sum(a, b));
     }
}
