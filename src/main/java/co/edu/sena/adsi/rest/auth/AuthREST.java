package co.edu.sena.adsi.rest.auth;



import co.edu.sena.adsi.jpa.entities.Users;
import co.edu.sena.adsi.jpa.sessions.UsersFacade;
import co.edu.sena.adsi.rest.auth.DigestUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nimbusds.jose.JOSEException;
import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 *
 * @author Why?
  */
@Path("auth")
public class AuthREST {

    public static final String CLIENT_ID_KEY = "client_id", REDIRECT_URI_KEY = "redirect_uri",
            CLIENT_SECRET = "client_secret", CODE_KEY = "code", GRANT_TYPE_KEY = "grant_type",
            AUTH_CODE = "authorization_code";

    public static final String NOT_FOUND_MSG = "El Usuario no existe", LOGING_ERROR_MSG = "Usuario y/o password, no coinciden",
            USUARIO_NO_VALIDADO = "Usuario no verificado por el administrador.";

    @EJB
    private UsersFacade usersEJB;

    @POST
    @PermitAll
    @Path("login")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response login(Users user, @Context final HttpServletRequest request) throws JOSEException {
        final Users foundUser;
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        //foundUser = usersEJB.findUsersByNumDocument(user.getNumdocument())//
        foundUser = usersEJB.findUsersByEmail(user.getEmail());
        
        user.setPassword(DigestUtil.cifrarPassword(user.getPassword()));
        if (foundUser == null) {
            return Response.status(Status.UNAUTHORIZED).entity(gson.toJson(NOT_FOUND_MSG)).build();
        } else if (user.getPassword().equals(foundUser.getPassword())) {
            if (foundUser.isActive()) {
                System.out.println("ok");
                final Token token = AuthUtils.createToken(request.getRemoteHost(), foundUser);
                System.out.println(gson.toJson(token));
                return Response.ok().entity(gson.toJson(token)).build();
            } else {
                return Response.status(Status.UNAUTHORIZED).entity(gson.toJson(USUARIO_NO_VALIDADO)).build();
            }
        }
        return Response.status(Status.UNAUTHORIZED).entity(gson.toJson(LOGING_ERROR_MSG)).build();
    }
}
