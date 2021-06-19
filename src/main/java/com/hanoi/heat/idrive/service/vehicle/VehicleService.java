package com.hanoi.heat.idrive.service.vehicle;

import com.hanoi.heat.idrive.model.Location;
import com.hanoi.heat.idrive.model.Vehicle;
import com.hanoi.heat.idrive.model.VehicleType;
import com.hanoi.heat.idrive.service.IGeneralService;
import org.springframework.data.jpa.repository.Query;

public interface VehicleService extends IGeneralService<Vehicle> {
    Iterable<Vehicle> findVehicleByLocation(Location location);
    Iterable<Vehicle> findVehicleByVehicleType(VehicleType vehicleType);
    Iterable<Vehicle> findVehicleByLocationAndVehicleType(Location location, VehicleType vehicleType);
}
