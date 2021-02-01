package com.example.demo.entity;

import java.util.List;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.entity
 * @ClassName: Menu
 * @Description: java类作用描述
 * @Author: 李佳阳
 * @CreateDate: 2020/3/8 16:41
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/8 16:41
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Menu {
    private int menuId;
    private String menuName;
    private String menuAddr;
    private int menuSts;
    private int menuSort;
    private String menuImg;
    private List<Menu> children;

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
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

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
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
}
