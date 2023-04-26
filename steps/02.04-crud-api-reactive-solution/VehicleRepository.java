import com.sfeir.kart.pojo.Vehicle;
import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class VehicleRepository implements PanacheRepository<Vehicle> {

        public Uni<List<Vehicle>> findAllVehicle() {
            return findAll().list();
        }

        public Uni<Vehicle> createVehicle(Vehicle vehicle) {
            return persist(vehicle);
        }

        public Uni<Vehicle> findVehicleById(Long id) {
            return findById(id);
        }


        public Uni<Boolean> deleteVehicleById(Long id) {
            return deleteById(id);
        }

        public void updateVehicle(Long id,Vehicle vehicle) {
            Vehicle toUpdate = findById(id).await().indefinitely();
            toUpdate.name = vehicle.name;
            toUpdate.speed = vehicle.speed;
            toUpdate.acceleration = vehicle.acceleration;
        }


}
