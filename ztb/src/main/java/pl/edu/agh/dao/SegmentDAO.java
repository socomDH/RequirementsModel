/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.agh.dao;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

/**
 *
 * @author Karol
 */
public interface SegmentDAO {

    @SqlUpdate("INSERT INTO segments (area_id, location_id) VALUES (:areaId, :locationId)")
    void createSegment(@Bind("areaId") long areaId, @Bind("locationId") long locationId);
    
    @SqlQuery("SELECT id FROM segments where location_id = :locationId")
    long findSegmentIdByLocationId(@Bind("locationId") long locationId);
    
    @SqlQuery("SELECT area_id FROM segments where segment_id = :segmentId")
    long getAreaId(@Bind("segmentId") long segmentId);
    
    @SqlQuery("SELECT lighting_profile_id FROM segments where segment_id = :segmentId")
    long getLightingProfileId(@Bind("segmentId") long segmentId);
}
