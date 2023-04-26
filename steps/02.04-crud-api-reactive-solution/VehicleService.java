import com.sfeir.kart.pojo.Vehicle;
import com.sfeir.kart.repository.VehicleRepository;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Random;

@ApplicationScoped
public class VehicleService {

    @Inject
    VehicleRepository vehicleRepository;

    public Uni<Vehicle> random() {
        return vehicleRepository.findAllVehicle().map(vehicles -> vehicles.get(new Random().nextInt(vehicles.size())));
    }

    public Uni<List<Vehicle>> findAll() {
        return vehicleRepository.findAllVehicle();
    }

    public Uni<Vehicle> findById(Long id) {
        return vehicleRepository.findVehicleById(id);
    }

    public Uni<Boolean> deleteById(Long id) {
        return vehicleRepository.deleteVehicleById(id);
    }


    public Uni<Vehicle> create(Vehicle vehicle) {
        return vehicleRepository.createVehicle(vehicle);
    }

    public void update(Long id, Vehicle vehicle) {
        vehicleRepository.updateVehicle(id, vehicle);
    }



}
