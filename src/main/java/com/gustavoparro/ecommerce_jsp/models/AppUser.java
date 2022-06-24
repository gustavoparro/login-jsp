package com.gustavoparro.ecommerce_jsp.models;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AppUser {

    @EqualsAndHashCode.Include
    private Long id;

    private String name;

    private String email;

    private String password;

}
