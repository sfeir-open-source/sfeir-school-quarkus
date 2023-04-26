import com.sfeir.kart.pojo.Vehicle;
import com.sfeir.kart.service.VehicleService;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path(ApiRegistration.REST_API + ApiRegistration.REST_VEHICLE)
@ApplicationScoped
public class VehicleWs {

    @Inject
    VehicleService vehicleService;

    @GET
    @Path(ApiRegistration.REST_RANDOM)
    public Uni<Vehicle> random() {
        return vehicleService.random();
    }

    @GET
    @Path("{name}")
    public Uni<Vehicle> findByName(@PathParam("name") Long id) {
        return vehicleService.findByName(id);
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<Response> create(@Valid Vehicle vehicle) {
        vehicleService.create(vehicle);
        return Uni.createFrom().item(Response.ok().build());
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(@PathParam("id") Long id, Vehicle vehicle) {
        vehicleService.update(id, vehicle);
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") Long id) {
        vehicleService.deleteById(id);
    }

    @GET
    public Uni<List<Vehicle>> findAll() {
        return vehicleService.findAll();
    }
}
