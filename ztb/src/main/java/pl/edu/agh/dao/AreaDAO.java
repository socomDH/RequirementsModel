package pl.edu.agh.dao;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface AreaDAO {
  @SqlUpdate("INSERT INTO areas (name) VALUES (:name)")
  void createArea(@Bind("name") String name);
  
  @SqlQuery("SELECT id FROM areas where name = :name")
  long findAreaId(@Bind("name") String name);
}
