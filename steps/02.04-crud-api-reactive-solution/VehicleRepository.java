import com.sfeir.kart.pojo.Vehicle;
import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.PersistenceContext;
import javax.transaction.TransactionScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@PersistenceContext
public class VehicleRepository implements PanacheRepository<Vehicle> {

        public Uni<List<Vehicle>> findAllVehicle() {
            return findAll().list();
        }

        @Transactional
        public void createVehicle(Vehicle vehicle) {
            persist(vehicle);
        }

        public Uni<Vehicle> findVehicleById(Long id) {
            return findById(id);
        }

        @Transactional
        public void deleteVehicleById(Long id) {
            deleteById(id);
        }


}
