package com.example.demo.entity;

import java.util.List;


public class RoleMenu {
    private int menuId;
    private int roleId;
    private String menuName;
    private String menuAddr;
    private int menuSts;
    private int menuSort;
    private String menuImg;
    private List<Menu> children;

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuAddr() {
        return menuAddr;
    }

    public void setMenuAddr(String menuAddr) {
        this.menuAddr = menuAddr;
    }

    public int getMenuSts() {
        return menuSts;
    }

    public void setMenuSts(int menuSts) {
        this.menuSts = menuSts;
    }

    public int getMenuSort() {
        return menuSort;
    }

    public void setMenuSort(int menuSort) {
        this.menuSort = menuSort;
    }

    public String getMenuImg() {
        return menuImg;
    }

    public void setMenuImg(String menuImg) {
        this.menuImg = menuImg;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }
}
