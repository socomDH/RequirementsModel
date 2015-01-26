package pl.edu.agh.resources;

import com.google.common.base.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import pl.edu.agh.db.dao.TestDAO;

@Path("/resource")
@Produces(MediaType.APPLICATION_JSON)
public class Resource {
    private static final Logger LOGGER = LoggerFactory.getLogger(Resource.class);
    private final TestDAO dao;

    public Resource(TestDAO dao) {
        this.dao = dao;
    }
    
    @GET
    public String sayHello(@QueryParam("id") Optional<Integer> id) {
        return dao.findAreaById(id.get());
    }

}
