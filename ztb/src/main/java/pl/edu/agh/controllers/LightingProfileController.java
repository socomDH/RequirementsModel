package pl.edu.agh.controllers;

import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.edu.agh.dao.LightingProfileDAO;
import pl.edu.agh.model.IdResponse;
import pl.edu.agh.model.LightingProfile;

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
    public IdResponse createLightingProfile(@PathParam("name") String name, 
            @PathParam("value") double value) {
        dao.createLightingProfile(name, value);
        long id = dao.findLightingProfileId(name, value);
        return new IdResponse(id);
    }
    
    @DELETE
    @Path("/delete/{name}/{value}")
    public IdResponse deleteLightingProfile(@PathParam("name") String name, 
            @PathParam("value") double value) {
        long id = dao.findLightingProfileId(name, value);
        dao.deleteLightingProfile(id);
        return new IdResponse(id);
    }
    
    @PUT
    @Path("/update/{id}/{name}/{value}")
    public IdResponse updateLightingProfile(@PathParam("id") long id, 
            @PathParam("name") String name, @PathParam("value") double value) {
         LightingProfile profile = new LightingProfile(id, name, value);
         dao.updateLightingProfile(profile);
         return new IdResponse(profile.getId());
    }
    
}
