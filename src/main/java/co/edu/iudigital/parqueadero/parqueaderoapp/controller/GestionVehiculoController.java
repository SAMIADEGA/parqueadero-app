package co.edu.iudigital.parqueadero.parqueaderoapp.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.edu.iudigital.parqueadero.parqueaderoapp.domain.GestionVehiculo;
import co.edu.iudigital.parqueadero.parqueaderoapp.services.GestionVehiculoService;

@RestController
@RequestMapping("/gestionar")
@CrossOrigin("*")
public class GestionVehiculoController {

    @Autowired
    private GestionVehiculoService gestionVehiculoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveGestion(@RequestBody GestionVehiculo gestionVehiculo) {
        gestionVehiculoService.registerGestionVehiculo(gestionVehiculo);
    }

    @GetMapping
    public List<GestionVehiculo> gettingListGestion() {
        List<GestionVehiculo> gestVehiculo = new ArrayList<>();
        return gestVehiculo;
    }

    @GetMapping("/{id_registro}")
    public Optional<GestionVehiculo> gettingGestionId(@PathVariable int id_registro) {
        return gestionVehiculoService.gOptional(id_registro);
    }

    @PutMapping("/{fechaIngreso}")
    @ResponseStatus(HttpStatus.CREATED)
    public void actfechaIngresoVehiculo(@PathVariable("fechaIngreso") LocalDateTime fechaIngreso,
            @RequestBody GestionVehiculo gestionVehiculo) {
        gestionVehiculoService.actfechaIngreso(gestionVehiculo);
    }

    @PutMapping("/{fechaSalida}")
    @ResponseStatus(HttpStatus.CREATED)
    public void actfechaSalidaVehiculo(@PathVariable("fechaSalida") LocalDateTime fechaSalida,
            @RequestBody GestionVehiculo gestionVehiculo) {
        gestionVehiculoService.actfechaSalida(gestionVehiculo);

    }

}
