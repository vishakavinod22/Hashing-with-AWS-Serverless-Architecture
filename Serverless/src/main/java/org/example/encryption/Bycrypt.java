package org.example.encryption;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class Bycrypt {

    //https://www.geeksforgeeks.org/cryptographic-hash-function-in-java/
    public String bcryptAlgorithm(String input)
    {
        return BCrypt.hashpw(input, BCrypt.gensalt());
    }
}
