package pl.edu.agh.dao;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface LightingProfileDAO {

  @SqlUpdate("INSERT INTO lighting_profiles (name, value) VALUES (:name, :value)")
  void createLightingProfile(@Bind("name") String name, @Bind("value") double value);
  
  @SqlUpdate("DELETE FROM lighting_profiles WHERE id = :id")
  void deleteLightingProfile(@Bind("id") long id);
  
  @SqlQuery("SELECT id FROM lighting_profiles WHERE name = :name AND value = :value")
  long findLightingProfileId(@Bind("name") String name, @Bind("value") double value);
  
}
