package com.openlegacy.SpringApi.controller;

import com.openlegacy.SpringApi.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StackRepository extends JpaRepository<Item,Integer> {

}
