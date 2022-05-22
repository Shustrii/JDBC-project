package com.itvdn.javastarter.test.simple_dao;

import com.itvdn.javastarter.test.simple_dao.dao.CarDAO;
import com.itvdn.javastarter.test.simple_dao.dao.ClientDAO;
import com.itvdn.javastarter.test.simple_dao.dao.impl.DAOFactory;
import com.itvdn.javastarter.test.simple_dao.dao.IDAOFactory;
import com.itvdn.javastarter.test.simple_dao.entity.Car;
import com.itvdn.javastarter.test.simple_dao.entity.Client;

import java.util.ArrayList;
import java.util.List;

public class  Main {

    public static void main(String[] args) {
        IDAOFactory factory = DAOFactory.getInstance();

        ClientDAO clientDAO = factory.getClientDAO();

//        Client client = new Client();
//        client.setAge(10);
//        client.setName("J");
//        client.setStreet("HU");
//
//        clientDAO.add(client);

        Client client1 = new Client();
        client1.setAge(14);
        client1.setName("K");
        client1.setStreet("UK");
        List<String> phones = new ArrayList<>();
        phones.add("001122");
        phones.add("7713344");
        client1.setPhone(phones);

        clientDAO.add(client1);



//        CarDAO carDAO = factory.getCarDAO();
//
//        carDAO.updatePrice(70000, 9);
//
//                carDAO.remove("Chevrolet");

//        System.out.println(car.getId() + " " + car.getMark()
//                    + " " + car.getModel() + " " + car.getPrice());

//       Car car = new Car();
//       car.setMark("AUDI");
//       car.setModel("A8");
//       car.setPrice(150_000);
//       carDAO.add(car);

//        Car car2 = new Car();
//        car2.setMark("Mersedes");
//        car2.setModel("S500");
//        car2.setPrice(160_000);
//        carDAO.add(car);


//        List<Car> cars = carDAO.getAll();
//        for (Car car : cars) {
//            System.out.println(car.getId() + " " + car.getPrice() + " " + car.getMark() + " " + car.getModel());
//        }

//        Car car1 = carDAO.getById(9);
//        System.out.println(car1.getId() + " " + car1.getPrice() + " " + car1.getMark() + " " + car1.getModel());

    }

}
