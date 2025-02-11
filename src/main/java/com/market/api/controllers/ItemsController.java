package com.market.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;


@RestController
@RequestMapping("/items")
public class ItemsController {
    
    @GetMapping()
    public String getItems() {
        return "list";
    }

    @GetMapping("/{id}")
    public String getItemsById(@PathVariable("id") Long id) {
        return "list " + id;
    }

    @PostMapping()
    public String postItem(@RequestBody String body) {
        return body;
    }

    @PutMapping("/{id}")
    public String updateItem(@PathVariable("id") Long id, @RequestBody String body) {
        return body;
    }

    @DeleteMapping("/{id}")
    public String deleteItem(@PathVariable("id") Long id) {
        return "deleted";
    }
}
