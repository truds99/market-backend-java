package com.market.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.market.api.dtos.ItemDTO;
import com.market.api.models.ItemModel;
import com.market.api.repositories.ItemRepository;

import jakarta.validation.Valid;

@Service
public class ItemService {
    final ItemRepository itemRepository;

    ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<ItemModel> getItems() {
        return itemRepository.findAll();
    }

    public Optional<ItemModel> getItemsById(Long id) {
        Optional<ItemModel> item = itemRepository.findById(id);

        if (!item.isPresent()) {
            return Optional.empty();
        } else {
            return item;
        }
    }

    public ItemModel postItem(ItemDTO body) {
        ItemModel item = new ItemModel(body);
        itemRepository.save(item);

        return item;
    }

    public Optional<ItemModel> updateItem(Long id, ItemDTO body) {
        Optional<ItemModel> item = itemRepository.findById(id);

        if (!item.isPresent()) {
            return Optional.empty();
        }

        ItemModel newItem = new ItemModel(body);
        newItem.setId(id);
        itemRepository.save(newItem);
        return Optional.of(newItem);
    }

    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}
