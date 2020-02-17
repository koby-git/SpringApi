package com.openlegacy.SpringApi.repository;

import com.openlegacy.SpringApi.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// stack repository for CURD operation
@Repository
public interface StackRepository extends JpaRepository<Item,Integer> {

}
