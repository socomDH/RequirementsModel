/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.agh.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.edu.agh.dao.SegmentDAO;
import pl.edu.agh.model.IdResponse;

/**
 *
 * @author Karol
 */
@Path("/segment")
public class SegmentController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SegmentController.class);
    private final SegmentDAO dao;
    
    public SegmentController(SegmentDAO dao){
        this.dao = dao;
    }
    
    @PUT
    @Path("/create/{areaId}/{locationId}")
    public IdResponse createSegment(@PathParam("areaId") long areaId, @PathParam("locationId") long locationId){
        dao.createSegment(areaId, locationId);
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
    
}
