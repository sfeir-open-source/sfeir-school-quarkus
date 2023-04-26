import com.sfeir.kart.pojo.Vehicle;
import com.sfeir.kart.repository.VehicleRepository;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

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

    public Uni<Vehicle> findByName(Long id) {
        return vehicleRepository.findVehicleById(id);
    }

    public void deleteById(Long id) {
        vehicleRepository.deleteVehicleById(id);
    }


    public void create(Vehicle vehicle) {
        vehicleRepository.createVehicle(vehicle);
    }

    public void update(Long id, Vehicle vehicle) {
        Vehicle toUpdate = vehicleRepository.findVehicleById(id).await().indefinitely();
        toUpdate.name = vehicle.name;
        toUpdate.speed = vehicle.speed;
        toUpdate.acceleration = vehicle.acceleration;
    }



}
