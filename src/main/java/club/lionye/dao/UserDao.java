package club.lionye.dao;

import club.lionye.entity.User;

public interface UserDao {

    User queryByuserName(String username);

}