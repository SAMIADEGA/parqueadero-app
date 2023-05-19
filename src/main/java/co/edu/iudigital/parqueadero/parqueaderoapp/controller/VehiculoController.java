package co.edu.iudigital.parqueadero.parqueaderoapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.edu.iudigital.parqueadero.parqueaderoapp.domain.Vehiculo;
import co.edu.iudigital.parqueadero.parqueaderoapp.services.VehiculoService;

@RestController
@RequestMapping("/vehiculo")
@CrossOrigin("*")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;
    private List<Vehiculo> traerVehiculo;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void creaVehiculo(@RequestBody Vehiculo vehiculo) {
        vehiculoService.registerVehiculo(vehiculo);
    }

    @GetMapping
    public List<Vehiculo> traerVehiculo() { 
        List<Vehiculo> vList = new ArrayList<>();
        return traerVehiculo;
    }

} 

     
