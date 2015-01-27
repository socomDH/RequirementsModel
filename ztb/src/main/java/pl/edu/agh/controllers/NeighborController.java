package pl.edu.agh.controllers;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import pl.edu.agh.dao.NeighborDAO;
import pl.edu.agh.model.IdResponse;

@Path("/neighbor")
@Produces(MediaType.APPLICATION_JSON)
public class NeighborController {
    private final NeighborDAO dao;

    public NeighborController(NeighborDAO dao) {
        this.dao = dao;
    }
    
    @PUT
    @Path("/create/{segment1_id}/{segment2_id}")
    public IdResponse createNeighbor(@PathParam("segment1_id") long segment1_id,
            @PathParam("segment2_id") long segment2_id) {
        dao.createNeighbor(segment1_id, segment2_id);
        long id = dao.findNeighborId(segment1_id, segment2_id);
        return new IdResponse(id);
    }
}
