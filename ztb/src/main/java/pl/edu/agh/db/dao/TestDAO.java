package pl.edu.agh.db.dao;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface TestDAO {
//  @SqlUpdate("create table something (id int primary key, name varchar(100))")
//  void createSomethingTable();
//
//  @SqlUpdate("insert into something (id, name) values (:id, :name)")
//  void insert(@Bind("id") int id, @Bind("name") String name);

  @SqlQuery("select name from areas where id = :id")
  String findAreaById(@Bind("id") int id);
}
