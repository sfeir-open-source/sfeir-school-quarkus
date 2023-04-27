import com.sfeir.kart.pojo.Vehicle;
import com.sfeir.kart.service.VehicleService;
import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.quarkus.hibernate.reactive.panache.common.runtime.ReactiveTransactional;
import io.smallrye.mutiny.Uni;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
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
    @WithTransaction
    public Uni<Response> create(@Valid Vehicle vehicle) {
        vehicleService.create(vehicle);
        return Uni.createFrom().item(Response.ok().build());
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @WithTransaction
    public Uni<Response> update(@PathParam("id") Long id, Vehicle vehicle) {
        vehicleService.update(id, vehicle);
        return Uni.createFrom().item(Response.ok().build());
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @WithTransaction
    public Uni<Response> delete(@PathParam("id") Long id) {
        return vehicleService.deleteById(id).replaceWith(Response.noContent().build());
    }

    @GET
    public Uni<List<Vehicle>> findAll() {
        return vehicleService.findAll();
    }
}
