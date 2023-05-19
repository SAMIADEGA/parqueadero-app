package co.edu.iudigital.parqueadero.parqueaderoapp.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.iudigital.parqueadero.parqueaderoapp.domain.Vehiculo;

@Repository
public interface VehiculoRepository extends CrudRepository<Vehiculo, Integer> {

    static Optional<Vehiculo> findByPlaca(String placa) {
        return null;
    }
}
