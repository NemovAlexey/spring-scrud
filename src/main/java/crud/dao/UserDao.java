package crud.dao;

import crud.model.User;

import java.util.List;

public interface UserDao {
    List<User> index();
    User show(int id);
}
