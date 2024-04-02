package org.ecommerce.sandhya.application.model.dao;

import org.ecommerce.sandhya.application.model.LocalUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LocalUserDao extends CrudRepository<LocalUser, Long> {

    Optional<LocalUser> findByUsername(String username);
    Optional<LocalUser> findByEmail(String email);
}
