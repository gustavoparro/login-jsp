package com.gustavoparro.ecommerce_jsp.repositories;

import com.gustavoparro.ecommerce_jsp.models.AppUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class AppUserRepositoryTest {

    private final AppUserRepository appUserRepository = new AppUserRepository();

    @Test
    public void authenticateUser() {
        Optional<AppUser> optionalAppUser = appUserRepository.authenticateUser(
                new AppUser(null, null, "gustavo@gmail.com", "123456"));

        Assertions.assertTrue(optionalAppUser.isPresent());
    }

}
