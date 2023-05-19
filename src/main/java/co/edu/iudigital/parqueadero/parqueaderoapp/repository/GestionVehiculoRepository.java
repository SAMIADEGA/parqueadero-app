package co.edu.iudigital.parqueadero.parqueaderoapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.iudigital.parqueadero.parqueaderoapp.domain.GestionVehiculo;

@Repository
public interface GestionVehiculoRepository extends CrudRepository<GestionVehiculo, Integer> {

}
