package crud.dao;

import crud.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    private static long USERS_COUNT;
    private final List<User> users;

    {
        users = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            users.add(new User(++USERS_COUNT, "Aleksei" + i,
                    "Nemov" + i, "nemov" + i + "@mail.ru"));
        }
    }

    @Override
    public List<User> index() {
        return users;
    }

    @Override
    public User show(int id) {
        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    @Override
    public void save(User user) {
        user.setId(++USERS_COUNT);
        users.add(user);
    }

    @Override
    public void update(int id, User user) {
        User userToUpdate = show(id);
        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setLastName(user.getLastName());
        userToUpdate.setEmail(user.getEmail());
    }

    @Override
    public void delete(int id) {
        users.removeIf(u -> u.getId() == id);
    }

}
