/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.rest.services;

import org.glassfish.jersey.server.ResourceConfig;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.media.multipart.MultiPartFeature;

import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

/**
 *
 * @author adsi1261718
 */
@ApplicationPath("api")
public class ApplicationConfig extends ResourceConfig {

    public ApplicationConfig() {
        packages("co.edu.sena.adsi.rest.auth;co.edu.sena.adsi.rest.services");
        register(RolesAllowedDynamicFeature.class);
        register(MultiPartFeature.class);

    }

}
