package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class DiceController {

    private List<Integer> numbers = new ArrayList<>();

    private List<Integer> rollDice(int n) {
        return Arrays.asList(new Integer[n]).stream().map(i -> (int) (Math.random() * 6 + 1)).collect(Collectors.toList());
    }

    @GetMapping("/roll-dice")
    public String index() {
        numbers = rollDice(6);
        return "dice";
    }

    @GetMapping("/roll-dice/{n}")
    public String guess(@PathVariable int n, Model model) {
        model.addAttribute("numbers", numbers);
        model.addAttribute("guess", n);
        return "guess";
    }

}
