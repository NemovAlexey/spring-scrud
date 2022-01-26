package crud.dao;

import crud.model.User;

import java.util.List;

public interface UserDao {
    List<User> allUsers();
    User getUser(long id);
    void save(User user);
    void update(long id, User user);
    void delete(long id);
}
