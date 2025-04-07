package service;

import models.Management;

public interface ManagementService {
    String register(Management management);
    String login(Management management);
}
