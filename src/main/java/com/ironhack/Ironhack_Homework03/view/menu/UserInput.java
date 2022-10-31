package com.ironhack.Ironhack_Homework03.view.menu;

public class UserInput {

    private String order;
    private Integer id;

    //region Sets and gets

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    //endregion

    public UserInput(String order, Integer id) {
        this.order = order;
        this.id = id;
    }

    public UserInput() {
    }
}
