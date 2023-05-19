package co.edu.iudigital.parqueadero.parqueaderoapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.edu.iudigital.parqueadero.parqueaderoapp.domain.EstadoVehiculo;
import co.edu.iudigital.parqueadero.parqueaderoapp.services.EstadoVehiculoService;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/estado-vehiculo")
@CrossOrigin("*")
public class EstadoVehiculoController {

    @Autowired
    private EstadoVehiculoService estadoVehiculoService;
    
    @GetMapping
     public List<EstadoVehiculo> obtenerEstadoVeh(){
        List<EstadoVehiculo> estadoVeh = new ArrayList<>();
        return estadoVeh;
    }
    
     @GetMapping("/{id_estatus}")
    public Optional<EstadoVehiculo> obtEstadoVehi(@PathVariable int id_estatus){
        return estadoVehiculoService.gEsVehOptional(id_estatus);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void regEstVehiculo(@RequestBody EstadoVehiculo estadoVehiculo) {
        estadoVehiculoService.regEstVehiculo(estadoVehiculo);
    }

    @PutMapping("/{estado}")
    @ResponseStatus(HttpStatus.CREATED)
    public void actEstVehiculo(@PathVariable("estado") String estado, @RequestBody EstadoVehiculo estadoVehiculo) {
        estadoVehiculoService.updEstadoVeh(estadoVehiculo);
    }

}
