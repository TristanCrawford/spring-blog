package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StringTransformController {

    @GetMapping("/string/reverse/{string}")
    @ResponseBody
    public String reverse(@PathVariable String string) {
        return new StringBuilder(string).reverse().toString();
    }

    @GetMapping("/string/caps/{string}")
    @ResponseBody
    public String caps(@PathVariable String string) {
        return string.toUpperCase();
    }

    @GetMapping("/string/both/{string}")
    @ResponseBody
    public String both(@PathVariable String string) {
        return new StringBuilder(string).reverse().toString().toUpperCase();
    }
}
