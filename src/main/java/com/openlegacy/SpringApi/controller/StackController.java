package com.openlegacy.SpringApi.controller;

import com.openlegacy.SpringApi.model.Item;
import com.openlegacy.SpringApi.service.StackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StackController {


    @Autowired
    StackService stackService;

    @GetMapping("/")
    public List<Item> getItemsList(){
        return stackService.getItemsList();
    }

    @PostMapping("/")
    public Boolean getItemsList(@RequestBody Item item){
        return stackService.addItem(item);
    }

    @DeleteMapping("/")
    public Boolean deleteItem(@RequestBody Item item){
        return stackService.deleteItem(item);
    }

    @PutMapping("/")
    public Boolean withdrawalItem(@RequestBody Item item,@PathVariable int quantity){
        return stackService.withdrawalItems(item,quantity);
    }





}
