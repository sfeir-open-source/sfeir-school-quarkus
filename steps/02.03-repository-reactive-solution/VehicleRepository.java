import com.sfeir.kart.pojo.Vehicle;
import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class VehicleRepository implements PanacheRepository<Vehicle> {

        public Uni<List<Vehicle>> findAllVehicle() {
            return findAll().list();
        }

        public Uni<Vehicle> findVehicleById(Long id) {
            return find("id",id).firstResult();
        }

        public void deleteVehicleById(Long id) {
            delete("id",id);
        }


}
