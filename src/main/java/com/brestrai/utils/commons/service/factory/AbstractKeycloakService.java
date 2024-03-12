package com.brestrai.utils.commons.service.factory;

import com.brestrai.utils.commons.domain.keycloak.UserKeycloak;
import com.brestrai.utils.commons.service.AbstractService;
import jakarta.ws.rs.core.Response;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public abstract class AbstractKeycloakService extends AbstractService {

    public abstract String getServerUrl();

    public abstract String getRealm();

    public abstract String getClientId();

    public abstract String getUsername();

    public abstract String getPassword();


    private Keycloak getKeycloakInstance() {

        return KeycloakBuilder.builder()
                .serverUrl(getServerUrl())
                .realm(getRealm())
                .clientId(getClientId())
                .username(getUsername())
                .password(getPassword())
                .build();
    }

    public Response createUser(UserKeycloak userKeycloak) {

        Keycloak keycloak = getKeycloakInstance();

        UserRepresentation userRepresentation = new UserRepresentation();

        userRepresentation.setUsername(userKeycloak.username());
        userRepresentation.setEmail(userKeycloak.email());
        userRepresentation.setFirstName(userKeycloak.firstName());
        userRepresentation.setLastName(userKeycloak.lastName());
        userRepresentation.setEmailVerified(false);
        userRepresentation.setEnabled(true);

        CredentialRepresentation credentialRepresentation = new CredentialRepresentation();
        credentialRepresentation.setType(CredentialRepresentation.PASSWORD);
        credentialRepresentation.setValue(userKeycloak.password());

        userRepresentation.setCredentials(Collections.singletonList(credentialRepresentation));

        return keycloak.realm(getRealm()).users().create(userRepresentation);
    }
}
