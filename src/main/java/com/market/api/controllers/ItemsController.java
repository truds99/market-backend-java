package com.market.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.market.api.dtos.ItemDTO;
import com.market.api.models.ItemModel;
import com.market.api.services.ItemService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;


@RestController
@RequestMapping("/items")
public class ItemsController {

    final ItemService itemService;

    ItemsController(ItemService itemService) {
        this.itemService = itemService;
    }
    
    @GetMapping()
    public ResponseEntity<Object> getItems() {
        return ResponseEntity.status(HttpStatus.OK).body(itemService.getItems());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getItemsById(@PathVariable("id") Long id) {
        Optional<ItemModel> item = itemService.getItemsById(id);

        if (!item.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("item not found");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(item.get());
        }
    }

    @PostMapping()
    public ResponseEntity<Object> postItem(@RequestBody @Valid ItemDTO body) {
        Optional<ItemModel> item = itemService.postItem(body);

        if (!item.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("item already registered");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(item.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateItem(@PathVariable("id") Long id, @RequestBody @Valid ItemDTO body) {
        Optional<ItemModel> item = itemService.updateItem(id, body);

        if (!item.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("item not found");
        }

        return ResponseEntity.status(HttpStatus.OK).body(item.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteItem(@PathVariable("id") Long id) {
        itemService.deleteItem(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
