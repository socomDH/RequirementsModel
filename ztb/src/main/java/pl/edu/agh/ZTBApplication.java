package pl.edu.agh;

import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;
import pl.edu.agh.db.dao.TestDAO;
import pl.edu.agh.resources.Resource;

public class ZTBApplication extends Application<ZTBApplicationConfiguration> {

    public static void main(String[] args) throws Exception {
        new ZTBApplication().run(args);
    }

    @Override
    public String getName() {
        return "ztb";
    }

    @Override
    public void initialize(Bootstrap<ZTBApplicationConfiguration> bootstrap) {
    }

    @Override
    public void run(ZTBApplicationConfiguration config, Environment env) throws ClassNotFoundException {
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(env, config.getDataSourceFactory(), "postgresql");
        final TestDAO dao = jdbi.onDemand(TestDAO.class);
//        env.jersey().register(new UserResource(dao));
        env.jersey().register(new Resource(dao));
    }
}
