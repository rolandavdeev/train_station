package jwtrestapp.security.jwt;

import jwtrestapp.model.User;
import jwtrestapp.model.Status;

public final class JwtUserFactory {

    public JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return new JwtUser(
                user.getId(),
                user.getUsername(),
                user.getFirstName(),
                user.getLastName(),
                user.getPassword(),
                user.getStatus().equals(Status.ACTIVE)
        );
    }
}
