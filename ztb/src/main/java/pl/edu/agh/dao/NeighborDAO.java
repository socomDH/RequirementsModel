package pl.edu.agh.dao;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface NeighborDAO {
    @SqlUpdate("INSERT INTO neighbors (segment1_id, segment2_id) values (:segment1_id, :segment2_id)")
    void createNeighbor(@Bind("segment1_id") long segment1_id, @Bind("segment2_id") long segment2_id);
    
    @SqlQuery("SELECT id FROM neighbors where segment1_id = :segment1_id and segment2_id = :segment2_id")
    long findNeighborId(@Bind("segment1_id") long segment1_id, @Bind("segment2_id") long segment2_id);
    
    @SqlUpdate("DELETE FROM neighbors where segment1_id = :segmentId OR segment2_id = :segmentId")
    void deleteNeighbor(@Bind("segmentId") long segmentId);
}
