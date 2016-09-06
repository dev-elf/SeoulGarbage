package com.dev_elf.seoul.seoulgarbage.models;

/**
 * Created by dnay2 on 2016-09-06.
 */
public class MenuItem {

    private String menuName;
    private int menuImg;

    public MenuItem(String menuName, int menuImg) {
        this.menuName = menuName;
        this.menuImg = menuImg;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getMenuImg() {
        return menuImg;
    }
}
