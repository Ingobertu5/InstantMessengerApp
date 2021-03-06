package com.example.simon.instantmessengerapp.core;

import com.example.simon.instantmessengerapp.core.rest.services.UserRestClientImpl;
import com.example.simon.instantmessengerapp.model.interfaces.User;
import com.example.simon.instantmessengerapp.model.classes.UserImpl;

//import com.google.common.hash.Hashing;


/**
 * Created by simon on 22.03.18.
 */

public class UserAuthenticator {
    private UserRestClientImpl urci;

    public UserAuthenticator() {
        urci = new UserRestClientImpl();
    }

    public boolean authenticateUser(String username, String password) {
        User user = urci.getTheUserByName(username);
        if (user == null) {
            return false;
        } else {
            String hashedPassword ="";// Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString(); TODO: Hashing!!
           if (user.getPassword().equals(hashedPassword)) {
               return true;
            } else {
               return false;
            }
        }
    }

    public boolean doesUserExist(String name) {
        User user = urci.getTheUserByName(name);

        return user != null;
    }
}
