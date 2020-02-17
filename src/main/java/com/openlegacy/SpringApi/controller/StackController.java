package com.openlegacy.SpringApi.controller;

import com.openlegacy.SpringApi.model.Item;
import com.openlegacy.SpringApi.service.StackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;

@RestController
@RequestMapping("/api/stack")
@CrossOrigin
public class StackController {

    @Autowired
    StackService stackService;

    //get list of items in stack
    @GetMapping("")
    public List<Item> getItemsList(){
        return stackService.getItemsList();
    }

    //get item by number
    @GetMapping("/getByItemNo/{itemNo}")
    public Item getItemById(@PathVariable int itemNo){
        return stackService.getByItemNo(itemNo);
    }

    //add item to the stack
    @PostMapping("/add-item")
    public Boolean addItem(@RequestBody Item item, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            try {
                throw new ValidationException("validate error");
            } catch (ValidationException e) {
                e.printStackTrace();
            }
        }
        return stackService.addItem(item);
    }

    //delete item from stack
    @DeleteMapping(value = "delete/{itemNo}")
    public Boolean deleteByItemNo(@PathVariable int itemNo){
        return stackService.deleteItem(itemNo);
    }

    //withdrawal amount of items from stack
    @PutMapping("/withdrawal/{itemNo}/{itemAmount}")
    public Boolean withdrawalItem(@PathVariable int itemNo,@PathVariable int itemAmount){
        return stackService.withdrawalItems(itemNo,itemAmount);
    }

    //deposit amount of items to stack
    @PutMapping("/deposit/{itemNo}/{itemAmount}")
    public Boolean depositItem(@PathVariable int itemNo,@PathVariable int itemAmount){
        return stackService.depositItems(itemNo,itemAmount);
    }
}
