package com.example.demo.controllers;

import com.example.demo.entities.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class MyController {

    private List<Product> products = Arrays.asList(
            new Product("Товар 1", 10, "/product1.jpg"),
            new Product("Товар 2", 20, "/product2.jpg"),
            new Product("Товар 3", 30, "/product3.jpg"),
            new Product("Товар 4", 40, "/product4.jpg")
    );

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("products", products);
        return "index";
    }

    @GetMapping("/product/{name}")
    public String productDetails(@PathVariable String name, Model model) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                model.addAttribute("product", product);
                return "product-details";
            }
        }
        return "product-not-found";
    }

    @PostMapping("/submit-comment")
    public String submitComment(@RequestParam String comment) {
        System.out.println("Полученный комментарий: " + comment);

        return "redirect:/";
    }


}