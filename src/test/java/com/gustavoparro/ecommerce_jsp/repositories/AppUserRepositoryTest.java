package com.gustavoparro.ecommerce_jsp.repositories;

import com.gustavoparro.ecommerce_jsp.models.AppUser;
import org.jasypt.util.password.BasicPasswordEncryptor;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppUserRepositoryTest {

    private final AppUserRepository appUserRepository = new AppUserRepository();
    private final BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();

    @Test
    public void authenticateUser() {
        Optional<AppUser> optionalAppUser = appUserRepository.findUserByEmail("gustavo@gmail.com");

        assertTrue(optionalAppUser.isPresent());
        assertTrue(passwordEncryptor.checkPassword("123456", optionalAppUser.get().getPassword()));
    }

}
