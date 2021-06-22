package com.hanoi.heat.idrive.service.user;

import com.hanoi.heat.idrive.model.User;
import com.hanoi.heat.idrive.service.IGeneralService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService extends IGeneralService<User> {
    Optional<User> findByUsername(String username);
}
