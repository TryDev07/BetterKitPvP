package nl.trydev07.betterkitpvp.handlers.oop;

import java.util.HashSet;
import java.util.Set;

/* TryDev07 created on 02/01/2020
 * Project:  BetterKitPvP
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */
public class OOPKit<T> {

    private String name;
    private Integer price;
    private T kitBind;
    private Set<T> ItemStack = new HashSet<T>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<T> getItemStack() {
        return ItemStack;
    }

    public void setItemStack(Set<T> itemStack) {
        ItemStack = itemStack;
    }

    public T getKitBind() {
        return kitBind;
    }

    public void setKitBind(T kitBind) {
        this.kitBind = kitBind;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
