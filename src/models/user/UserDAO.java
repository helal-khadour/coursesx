package models.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utils.*;


public class UserDAO {
    protected ArrayList<UserModel> data;

    public UserDAO() {
        this.data = new ArrayList<>();
    }

    public ArrayList<UserModel> getData() {
        return this.data;
    }

    public boolean retrieveAllUsers() {
        this.data.clear();
        String query = "select * from users";
        ResultSet result = BasicDB.retrieve(query);

        try {
            if (!result.next())
                return false;
            do {
                UserModel temp = new UserModel();
                temp.setName(result.getString(2));
                temp.setEmail(result.getString(4));
                temp.setPassword(result.getString(5));
                temp.setInstructor(result.getBoolean(3));
                this.data.add(temp);
            } while (result.next());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean retrieveUser(String email, String password) {
        this.data.clear();
        String query = "select * from users where email = '" + email + "' and password = '" + password + "'";
        ResultSet result = BasicDB.retrieve(query);

        try {
            if (!result.next())
                return false;
            UserModel temp = new UserModel();
            temp.setName(result.getString(2));
            temp.setEmail(result.getString(4));
            temp.setPassword(result.getString(5));
            temp.setInstructor(result.getBoolean(3));
            this.data.add(temp);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void add(UserModel user) {
        this.data.clear();
        String query = "insert into users (name, email, password, is_instructor) values( '" +
                user.getName() + "','" + user.getEmail() + "','" + user.getPassword() + "'," + user.isInstructor() + ")";
        int rows = BasicDB.manipulate(query);
        this.data.add(user);
    }


    public void delete(String name) {
        String query = "delete from users where name= '" + name + "'";
        int rows = BasicDB.manipulate(query);
    }


}
