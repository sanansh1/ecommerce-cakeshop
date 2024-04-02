package org.ecommerce.sandhya.application.service;

import org.ecommerce.sandhya.application.api.RegistrationBody;
import org.ecommerce.sandhya.application.exception.UserExistsException;
import org.ecommerce.sandhya.application.model.LocalUser;
import org.ecommerce.sandhya.application.model.dao.LocalUserDao;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private LocalUserDao localUserDao;

    public UserService(LocalUserDao dao){
        localUserDao=dao;
    }
    public void registerUser(RegistrationBody registrationBody) throws UserExistsException {
        System.out.println(registrationBody.getUsername());
        LocalUser user = new LocalUser();
        if(localUserDao.findByEmail(registrationBody.getEmail()).isPresent()|| localUserDao.findByUsername(registrationBody.getUsername()).isPresent()){
            throw new UserExistsException();
        }
        user.setUsername(registrationBody.getUsername());
        user.setEmail(registrationBody.getEmail());
        user.setFirstname(registrationBody.getFirstname());
        user.setLastname(registrationBody.getLastname());
        //encrypt password
        user.setPassword(registrationBody.getPassword());
        localUserDao.save(user);
    }
}
