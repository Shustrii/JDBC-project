package com.itvdn.javastarter.test.simple_dao.dao.impl;

import com.itvdn.javastarter.test.conection.MyConnection;
import com.itvdn.javastarter.test.simple_dao.dao.ClientDAO;
import com.itvdn.javastarter.test.simple_dao.entity.Client;

import java.sql.*;
import java.util.List;

public class ClientJDBCDao implements ClientDAO {
    @Override
    public void add(Client client) {

        Connection connection = MyConnection.getConnection();


        PreparedStatement statement;

        try {

            int streetId = getStreetId(client.getStreet(), connection);
            boolean isClient = getName(client.getName(), connection);

            if (streetId == -1) {
                statement = connection.prepareStatement("INSERT INTO street(street_name) VALUES (?)");
                statement.setString(1, client.getStreet());
                statement.execute();
                statement = connection.prepareStatement("SELECT MAX(street_id) FROM street");
                ResultSet rs = statement.executeQuery();
                rs.next();
                streetId = rs.getInt(1);
            }
            if (!isClient){
                statement = connection.prepareStatement("INSERT INTO client(name, age, street_id) VALUES (?, ?, ?)");

                statement.setString(1, client.getName());
                statement.setInt(2, client.getAge());
                statement.setInt(3, streetId);
                //statement.set

                statement.execute();
                statement = connection.prepareStatement("SELECT MAX(id) FROM client");
                ResultSet resultSet = statement.executeQuery();
                resultSet.next();


                List<String> phones = client.getPhone();
                for (String p : phones){
                    statement = connection.prepareStatement("INSERT INTO phone (phone) VALUES (?)");
                    statement.setString(1, p);
                    statement.execute();
                }


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Client> getAll() {
        return null;
    }

    @Override
    public Client getById(int id) {
        return null;
    }

    @Override
    public void updateNameAndAge(String name, int age) {

    }

    @Override
    public void remove(String name) {

    }



    private int getStreetId(String streetName, Connection connection) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT street_id FROM street WHERE street_name = ? ");
            preparedStatement.setString(1, streetName);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    private boolean getName(String nameOfCl, Connection connection){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT name FROM client WHERE name = ?");
            preparedStatement.setString(1, nameOfCl);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                return true;
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

}
