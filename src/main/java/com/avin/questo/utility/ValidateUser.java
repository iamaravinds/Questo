package com.avin.questo.utility;

import com.avin.questo.model.UserDetails;

public class ValidateUser {

    public Boolean validateFirstName(String name) {
        if (name == null)
            return false;
        return true;
    }

    public Boolean validateEmail(String email) {
        if (email == null)
            return false;
        return true;
    }

    public Boolean validatepass(String password) {
        if (password == null)
            return false;
        return true;
    }

    public Boolean validateUser(UserDetails userDetails) {
        Boolean result = false;
        if (this.validateFirstName(userDetails.getFirstName()) == false)
            return false;

        if (this.validateEmail(userDetails.getEmail()) == false)
            return false;

        if (this.validatepass(userDetails.getPassword()) == false)
            return false;

        return true;
    }
}
