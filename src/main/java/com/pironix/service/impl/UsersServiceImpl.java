package com.pironix.service.impl;

import com.pironix.model.Users;
import com.pironix.repository.UserRepository;
import com.pironix.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

/**
 * Created by ibrahim
 *
 * @author ibrahim KARAYEL
 * @version 1.0
 * @since 9/3/2016.
 */
@Service
@Transactional
public class UsersServiceImpl implements UsersService {

    @Autowired
    protected UserRepository userRepository;

    @Override
    public Users saveUser(Users users) {
        return userRepository.save(users);
    }

    @Override
    public Boolean deleteUser(int id) {
        Users user = userRepository.findOne(id);
        if (user != null) {
            userRepository.delete(user);
            return true;
        }
        return false;
    }

    @Override
    public Users editUser(Users users) {
        return userRepository.save(users);
    }

    @Override
    public Users findUsers(int id) {
        return userRepository.findOne(id);
    }

    @Override
    public Users findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Users findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Collection<Users> getAllUsers() {
        Iterable<Users> itr = userRepository.findAll();
        return (Collection<Users>) itr;
    }
}
