package co.edu.sena.adsi.rest.auth;


import co.edu.sena.adsi.jpa.entities.Rol;
import co.edu.sena.adsi.jpa.entities.Users;
import co.edu.sena.adsi.jpa.sessions.UsersFacade;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jwt.JWTClaimsSet;
import java.io.IOException;
import java.security.Principal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Priority;
import javax.ejb.EJB;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;
import org.joda.time.DateTime;

/**
 *
 * @author Why?
 */
@Provider
@Priority(Priorities.AUTHENTICATION)
public class SecurityFilter implements ContainerRequestFilter, ContainerResponseFilter {

    @EJB
    private UsersFacade usersEJB;

    private static final String EXPIRE_ERROR_MSG = "Token has expired",
            JWT_ERROR_MSG = "Unable to parse JWT",
            JWT_INVALID_MSG = "Invalid JWT token";

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        SecurityContext originalContext = requestContext.getSecurityContext();
        String authHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

        String url = requestContext.getUriInfo().getPath();
        String typeRequest = requestContext.getMethod();
        System.out.println(typeRequest + ": " + url);

        if (authHeader == null || authHeader.isEmpty()
                || !authHeader.startsWith("Bearer ") || authHeader.split(" ").length != 2) {
            Authorizer authorizer = new Authorizer(new ArrayList<Rol>(), "",
                    originalContext.isSecure());
            requestContext.setSecurityContext(authorizer);
        } else {
            JWTClaimsSet claimSet;
            try {
                claimSet = (JWTClaimsSet) AuthUtils.decodeToken(authHeader);
            } catch (ParseException e) {
                throw new IOException(JWT_ERROR_MSG);
            } catch (JOSEException e) {
                throw new IOException(JWT_INVALID_MSG);
            }

            // ensure that the token is not expired
            if (new DateTime(claimSet.getExpirationTime()).isBefore(DateTime.now())) {
                throw new IOException(EXPIRE_ERROR_MSG);
            } else {
                Users user = usersEJB.find(Integer.parseInt(claimSet.getSubject()));
                Authorizer authorizer = new Authorizer(user.getRolList(), user.getNumDocument(),
                        originalContext.isSecure());
                requestContext.setSecurityContext(authorizer);
            }
        }

    }

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext response) {
        response.getHeaders().putSingle("Access-Control-Allow-Origin", "*");
        response.getHeaders().putSingle("Access-Control-Allow-Methods", "OPTIONS, GET, POST, PUT, DELETE");
        response.getHeaders().putSingle("Access-Control-Allow-Headers", "Content-Type, Authorization, x-xsrf-token");
    }

    public static class Authorizer implements SecurityContext {

        List<Rol> roles;
        String username;
        boolean isSecure;

        public Authorizer(List<Rol> roles, String username, boolean isSecure) {
            this.roles = roles;
            this.username = username;
            this.isSecure = isSecure;
        }

        @Override
        public Principal getUserPrincipal() {
            return new User(username);
        }

        @Override
        public boolean isUserInRole(String role) {
            for (Rol role1 : roles) {
                if(role1.getId().equals(role)){
                   return true;
                }
            }
             return false;
        }

        @Override
        public boolean isSecure() {
            return isSecure;
        }

        @Override
        public String getAuthenticationScheme() {
            return "JWT Authentication";
        }
    }

    public static class User implements Principal {

        String name;

        public User(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }
}
