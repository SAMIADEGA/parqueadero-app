package co.edu.iudigital.parqueadero.parqueaderoapp.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.iudigital.parqueadero.parqueaderoapp.domain.GestionVehiculo;
import co.edu.iudigital.parqueadero.parqueaderoapp.repository.GestionVehiculoRepository;

@Service
public class GestionVehiculoService {

    @Autowired
    private GestionVehiculoRepository gestionVehiculoRepository;

    public void registerGestionVehiculo(GestionVehiculo gestionVehiculo) {
        gestionVehiculoRepository.save(gestionVehiculo);
    }

    public List<GestionVehiculo> getGestionaVehiculos() {
        List<GestionVehiculo> gVehiculos = (List<GestionVehiculo>) gestionVehiculoRepository.findAll();
        return gVehiculos;
    }

    public Optional<GestionVehiculo> gOptional(int id_registro) {
        Optional<GestionVehiculo> gById = gestionVehiculoRepository.findById(id_registro);
        return gById;
    }

    public void actfechaIngreso(GestionVehiculo gestionVehiculo) {
        LocalDateTime fechaIngresoTime = LocalDateTime.now();
        gestionVehiculo.setFechaIngreso(fechaIngresoTime);
        gestionVehiculoRepository.save(gestionVehiculo);
    }

    public void actfechaSalida(GestionVehiculo gestionVehiculo) {
        LocalDateTime fechaSalidaTime = LocalDateTime.now();
        gestionVehiculo.setFechaSalida(fechaSalidaTime);
        gestionVehiculoRepository.save(gestionVehiculo);
    }
}
