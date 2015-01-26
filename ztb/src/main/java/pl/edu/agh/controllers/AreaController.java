package pl.edu.agh.controllers;

import com.google.common.base.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import pl.edu.agh.dao.AreaDAO;
import pl.edu.agh.model.IdResponse;

@Path("/area")
@Produces(MediaType.APPLICATION_JSON)
public class AreaController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AreaController.class);
    private final AreaDAO dao;

    public AreaController(AreaDAO dao) {
        this.dao = dao;
    }
    
    @PUT
    @Path("/create/{name}")
    public IdResponse createArea(@PathParam("name") String name) {
        dao.createArea(name);
        long id = dao.findAreaId(name);
        return new IdResponse(id);
    }

}
