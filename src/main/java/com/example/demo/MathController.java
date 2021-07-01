package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    @GetMapping("/math/calculate")
    public int calculate(@RequestParam String operation, @RequestParam int x, @RequestParam int y) {
        switch (operation) {
            case "add":
                return x + y;
            case "subtract":
                return x - y;
            case "multiply":
                return x * y;
            case "divide":
                return x / y;
            default:
                return 0;
        }

    }
}
