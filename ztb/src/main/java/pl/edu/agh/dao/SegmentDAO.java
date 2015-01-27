package pl.edu.agh.dao;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

/**
 *
 * @author Karol
 */
public interface SegmentDAO {

    @SqlUpdate("INSERT INTO segments (area_id, location_id, lighting_profile_id) VALUES (:areaId, :locationId, :lightingProfileId)")
    void createSegment(@Bind("areaId") long areaId, @Bind("locationId") long locationId,
            @Bind("lightingProfileId") long lightingProfileId);
    
    @SqlQuery("SELECT id FROM segments where location_id = :locationId")
    long findSegmentIdByLocationId(@Bind("locationId") long locationId);
    
    @SqlQuery("SELECT area_id FROM segments where id = :segmentId")
    long getAreaId(@Bind("segmentId") long segmentId);
    
    @SqlQuery("SELECT lighting_profile_id FROM segments where id = :segmentId")
    long getLightingProfileId(@Bind("segmentId") long segmentId);
    
    @SqlUpdate("DELETE FROM segments where id = :segmentId")
    void deleteSegment(@Bind("segmentId") long segmentId);
}
