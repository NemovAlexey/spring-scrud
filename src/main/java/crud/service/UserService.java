package crud.service;

import crud.model.User;

import java.util.List;

public interface UserService {
    List<User> index();
    User show(int id);
}