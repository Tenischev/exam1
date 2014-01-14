package com.example.exam1;

/**
 * Created with IntelliJ IDEA.
 * User: kris13
 * Date: 14.01.14
 * Time: 16:30
 * To change this template use File | Settings | File Templates.
 */
public class ClientItem {
    public String mark;
    public String color;
    public String sign;
    public String telephone;
    public String time;
    public String box;

    public ClientItem(String mark,String color,String sign,String telephone,String time,String box){
        this.color = color;
        this.mark = mark;
        this.sign = sign;
        this.telephone = telephone;
        this.time = time;
        this.box = box;
    }

    @Override
    public String toString(){
        return mark + " " + color + " " + time + " " + box;
    }

    public String getCar(){
        return mark + " " + color;
    }
    public String getTime(){
        return time;
    }
    public String getBox(){
        return box;
    }
}
