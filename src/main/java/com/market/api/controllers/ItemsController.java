package com.market.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.market.api.dtos.ItemDTO;
import com.market.api.models.ItemModel;
import com.market.api.repositories.ItemRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;


@RestController
@RequestMapping("/items")
public class ItemsController {

    final ItemRepository itemRepository;

    ItemsController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }
    
    @GetMapping()
    public List<ItemModel> getItems() {
        return itemRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ItemModel> getItemsById(@PathVariable("id") Long id) {
        Optional<ItemModel> item = itemRepository.findById(id);

        if (!item.isPresent()) {
            return Optional.empty();
        } else {
            return Optional.of(item.get());
        }
    }

    @PostMapping()
    public void postItem(@RequestBody @Valid ItemDTO body) {
        ItemModel item = new ItemModel(body);
        itemRepository.save(item);
    }

    @PutMapping("/{id}")
    public String updateItem(@PathVariable("id") Long id, @RequestBody String body) {
        return body;
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable("id") Long id) {
        itemRepository.deleteById(id);
    }
}
