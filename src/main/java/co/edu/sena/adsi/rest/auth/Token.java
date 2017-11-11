package co.edu.sena.adsi.rest.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Why?
 */
public class Token {

    String token;

    public Token(@JsonProperty("token") String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
