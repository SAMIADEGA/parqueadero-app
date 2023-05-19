package co.edu.iudigital.parqueadero.parqueaderoapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.iudigital.parqueadero.parqueaderoapp.domain.Vehiculo;
import co.edu.iudigital.parqueadero.parqueaderoapp.repository.VehiculoRepository;

@Service
public class VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    public void registerVehiculo(Vehiculo vehiculo) {
        vehiculoRepository.save(vehiculo);
    }

    public List<Vehiculo> getVehiculos() {
        List<Vehiculo> vehiculo = (List<Vehiculo>) vehiculoRepository.findAll();
        return vehiculo;
    }

    public Optional<Vehiculo> gVehOptional(int id_vehiculo) {
        Optional<Vehiculo> gVehById = vehiculoRepository.findById(id_vehiculo);
        return gVehById;
    }

    public Optional<Vehiculo> gVehPlaca(String placa) {
        Optional<Vehiculo> gVeByPlaca = VehiculoRepository.findByPlaca(placa);
        return gVeByPlaca;
    }

    public void delVehiculo(int id_vehiculo) {
        vehiculoRepository.deleteById(id_vehiculo);
    }
}
