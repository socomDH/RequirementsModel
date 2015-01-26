package pl.edu.agh.dao;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface LightingProfileDAO {

  @SqlUpdate("INSERT INTO lighting_profiles (name, value) VALUES (:name, :value)")
  long createLightingProfile(@Bind("name") String name, @Bind("value") double value);
    
}
