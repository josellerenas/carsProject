package com.example.demo.api;

import com.example.demo.model.Vehicle;
import com.example.demo.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/vehicles/api")
@RestController
public class VehicleController {

    VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public boolean insertVehicle(@RequestBody Vehicle newVehicle) {
        return vehicleService.insertVehicle(newVehicle);
    }

    @GetMapping
    public List<Vehicle> selectAllVehicles() {
        return vehicleService.selectAllVehicles();
    }

    @GetMapping(path = "{id}")
    public Vehicle selectVehicleById(@PathVariable("id") int id) {
        return vehicleService.selectVehicleById(id)
                .orElse(null);
    }

    @PutMapping(path = "{id}")
    public boolean updateVehicle(@PathVariable("id") int id, @RequestBody Vehicle vehicleToBeUpdated) {
        return vehicleService.updateVehicle(id, vehicleToBeUpdated);
    }

    @DeleteMapping(path = "{id}")
    public boolean deleteVehicle(@PathVariable("id") int id) {
        return vehicleService.deleteVehicle(id);
    }

}
