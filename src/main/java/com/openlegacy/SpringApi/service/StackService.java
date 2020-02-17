package com.openlegacy.SpringApi.service;


import com.openlegacy.SpringApi.repository.StackRepository;
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

    public Boolean withdrawalItems(int itemNo, Integer quantity) {
        Item item = stackRepository.getOne(itemNo);
        item.setItemAmount(item.getItemAmount() - quantity);
        if( stackRepository.save(item)!=null) {
            return true;
        }else {
            return false;
        }
    }

    public Boolean depositItems(int itemNo, Integer quantity) {
        Item item = stackRepository.getOne(itemNo);
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

    public Boolean deleteItem(int itemNo){
        try {
            stackRepository.deleteById(itemNo);
            return true;
        }catch (IllegalArgumentException e){
            return false;
        }

    }
}
