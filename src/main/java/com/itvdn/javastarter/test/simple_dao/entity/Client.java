package com.itvdn.javastarter.test.simple_dao.entity;

import java.util.List;

/**
 * Created by Asus on 31.01.2018.
 */
public class  Client {

    private long id;
    private String name;
    private int age;
    private List<String> phone;     // в таблице phone хранить колонку с id юзера
    private List<Car> cars;          // отдельно таблицу с id клиентами и id машинами
    private String street;          //в бд будет id street


    public Client() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public List<String> getPhone() {
        return phone;
    }

    public void setPhone(List<String> phone) {
        this.phone = phone;
    }

//    public String getAllPhones(List<String> phone, int index){
//        String PH = null;
//        for (int i = 0; i< phone.size(); i++){
//            PH = phone.get(index);
//        }
//        return PH;
//    }
}
