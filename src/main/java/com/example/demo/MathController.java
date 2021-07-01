package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/math")
public class MathController {

    @GetMapping("/calculate")
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

    @RequestMapping("/volume/{length}/{width}/{height}")
    public int volume(@PathVariable int length, @PathVariable int width, @PathVariable int height) {
        return length * width * height;
    }
}
