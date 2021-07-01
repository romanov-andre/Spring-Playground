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

    @PostMapping("/area")
    public int getArea(@RequestParam String type, @RequestParam(required = false) int radius, @RequestParam int width, @RequestParam int height) {
        switch(type) {
            case "circle":
                return (int)(Math.PI * Math.pow(radius, 2));
            case "rectangle":
                return width * height;
            default:
                return 0;
        }
    };
}
