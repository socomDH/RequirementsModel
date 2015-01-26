package pl.edu.agh.controllers;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.edu.agh.dao.LightingProfileDAO;
import pl.edu.agh.model.IdResponse;

@Path("/lighting_profile")
@Produces(MediaType.APPLICATION_JSON)
public class LightingProfileController {
    
    private static final Logger LOGGER = 
            LoggerFactory.getLogger(LightingProfileController.class);
    private final LightingProfileDAO dao;

    public LightingProfileController(LightingProfileDAO dao) {
        this.dao = dao;
    }
    
    @PUT
    @Path("/create/{name}/{value}")
    public IdResponse createArea(@PathParam("name") String name, 
            @PathParam("value") double value) {
        return new IdResponse(dao.createLightingProfile(name, value));
    }
    
}
