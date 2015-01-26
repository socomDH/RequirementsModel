package pl.edu.agh.dao;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface AreaDAO {
//  @SqlUpdate("create table something (id int primary key, name varchar(100))")
//  void createSomethingTable();
//
//  @SqlUpdate("insert into something (id, name) values (:id, :name)")
//  void insert(@Bind("id") int id, @Bind("name") String name);

  @SqlUpdate("INSERT INTO areas (name) VALUES (:name)")
  long createArea(@Bind("name") String name);
}
