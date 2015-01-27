/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.agh.controllers;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.edu.agh.dao.SegmentDAO;
import pl.edu.agh.model.IdResponse;

/**
 *
 * @author Karol
 */
@Path("/segment")
@Produces(MediaType.APPLICATION_JSON)
public class SegmentController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SegmentController.class);
    private final SegmentDAO dao;
    
    public SegmentController(SegmentDAO dao){
        this.dao = dao;
    }
    
    @PUT
    @Path("/create/{areaId}/{locationId}/{lightingProfileId}")
    public IdResponse createSegment(@PathParam("areaId") long areaId, @PathParam("locationId") long locationId,
            @PathParam("lightingProfileId") long lightingProfileId){
        dao.createSegment(areaId, locationId, lightingProfileId);
        long id = dao.findSegmentIdByLocationId(locationId);        
        return new IdResponse(id);
    }
    
    @GET
    @Path("/get/areaId/{segmentId}")
    public IdResponse getAreaId(@PathParam("segmentId") long segmentId){
       long id = dao.getAreaId(segmentId);
       return new IdResponse(id);
    }
    
    @GET
    @Path("/get/lightingProfileId/{segmentId}")
    public IdResponse getLightingProfileId(@PathParam("segmentId") long segmentId){
       long id = dao.getLightingProfileId(segmentId);
       return new IdResponse(id);
    }
    
    @DELETE
    @Path("delete/{segmentId}")
    public void deleteSegment(@PathParam("segmentId") long segmentId) {
        dao.deleteSegment(segmentId);
    }
    
}
