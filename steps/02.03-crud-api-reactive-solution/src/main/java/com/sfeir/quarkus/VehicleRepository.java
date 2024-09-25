package com.sfeir.quarkus;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.smallrye.mutiny.Uni;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
@WithSession
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

  public Uni<Vehicle> updateVehicle(Long id, Vehicle vehicle) {
    return findById(id)
      .onItem().ifNotNull().transformToUni(toUpdate -> {
        toUpdate.name = vehicle.name;
        toUpdate.speed = vehicle.speed;
        toUpdate.acceleration = vehicle.acceleration;
        return persist(toUpdate);
      });
  }
}

