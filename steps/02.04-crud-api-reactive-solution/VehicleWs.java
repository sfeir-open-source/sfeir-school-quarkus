import com.sfeir.kart.pojo.Vehicle;
import com.sfeir.kart.service.VehicleService;
import io.quarkus.hibernate.reactive.panache.common.runtime.ReactiveTransactional;
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
    @Path("{id}")
    public Uni<Vehicle> findById(@PathParam("id") Long id) {
        return vehicleService.findById(id);
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ReactiveTransactional
    public Uni<Response> create(@Valid Vehicle vehicle) {
        vehicleService.create(vehicle);
        return Uni.createFrom().item(Response.ok().build());
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ReactiveTransactional
    public void update(@PathParam("id") Long id, Vehicle vehicle) {
        vehicleService.update(id, vehicle);
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ReactiveTransactional
    public Uni<Response> delete(@PathParam("id") Long id) {
        return vehicleService.deleteById(id).replaceWith(Response.noContent().build());
    }

    @GET
    public Uni<List<Vehicle>> findAll() {
        return vehicleService.findAll();
    }
}
