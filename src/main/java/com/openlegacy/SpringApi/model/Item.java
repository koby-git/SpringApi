package com.openlegacy.SpringApi.model;


import javax.persistence.*;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itemNo;

    private String itemName;

    private Long itemInventoryCode;
    private Integer itemAmount;


    public Item() {
    }

    public Item(String itemName, long itemInventoryCode, int itemAmount) {
        this.itemName = itemName;
        this.itemInventoryCode = itemInventoryCode;
        this.itemAmount = itemAmount;
    }

    public Integer getItemNo() {
        return itemNo;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Long getItemInventoryCode() {
        return itemInventoryCode;
    }

    public void setItemInventoryCode(Long itemInventoryCode) {
        this.itemInventoryCode = itemInventoryCode;
    }

    public Integer getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(Integer itemAmount) {
        this.itemAmount = itemAmount;
    }
}
