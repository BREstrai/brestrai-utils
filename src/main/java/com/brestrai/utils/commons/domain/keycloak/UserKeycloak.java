package com.brestrai.utils.commons.domain.keycloak;

public record UserKeycloak(
        String username,
        String email,
        String firstName,
        String lastName,
        String password,
        String cpf
) {
}
