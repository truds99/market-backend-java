package com.market.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.market.api.models.ItemModel;

@Repository
public interface ItemRepository extends JpaRepository<ItemModel, Long> {
    boolean existsByName(String name);
}
