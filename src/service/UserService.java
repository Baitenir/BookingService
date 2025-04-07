package service;

import models.Management;
import models.User;

public interface UserService {
    String pay(int id, Management management, User user);
    String deposit(User user, Management management);
}
