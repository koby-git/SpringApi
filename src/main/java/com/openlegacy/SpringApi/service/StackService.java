package com.openlegacy.SpringApi.service;


import com.openlegacy.SpringApi.controller.StackRepository;
import com.openlegacy.SpringApi.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StackService {

    @Autowired
    StackRepository stackRepository;

    public List<Item> getItemsList() {
        return stackRepository.findAll();
    }

    public Item getByItemNo(Integer ItemNo) {
        return stackRepository.getOne(ItemNo);
    }

    public Boolean withdrawalItems(Item item, Integer quantity) {
        item.setItemAmount(item.getItemAmount() - quantity);
        if( stackRepository.save(item)!=null) {
            return true;
        }else {
            return false;
        }
    }

    public Boolean depositItems(Item item, Integer quantity) {
        item.setItemAmount(item.getItemAmount() + quantity);
        if(stackRepository.save(item)!=null) {
            return true;
        }else {
            return false;
        }

    }

    public Boolean addItem(Item item) {
        stackRepository.save(item);
        if (stackRepository.save(item) != null) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean deleteItem(Item item){
        try {
            stackRepository.delete(item);
            return true;
        }catch (IllegalArgumentException e){
            return false;
        }

    }
}
