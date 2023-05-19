package co.edu.iudigital.parqueadero.parqueaderoapp.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.iudigital.parqueadero.parqueaderoapp.domain.EstadoVehiculo;
import co.edu.iudigital.parqueadero.parqueaderoapp.repository.EstadoVehiculoRepository;

@Service
public class EstadoVehiculoService {

    @Autowired
    private EstadoVehiculoRepository eVehiculoRepository;

    public void regEstVehiculo(EstadoVehiculo estadoVehiculo) {
        eVehiculoRepository.save(estadoVehiculo);
    }

    public Optional<EstadoVehiculo> gEsVehOptional(int id_estatus) {
        Optional<EstadoVehiculo> gEVehById = eVehiculoRepository.findById(id_estatus);
        return gEVehById;
    }

    public void updEstadoVeh(EstadoVehiculo estadoVehiculo) {
        LocalDateTime estadoUpd = LocalDateTime.now();
        estadoVehiculo.setFechaActual(estadoUpd);
        eVehiculoRepository.save(estadoVehiculo);
    }
}
