package com.pinapp.challenge.repository;

import com.pinapp.challenge.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query(value = "SELECT AVG(TIMESTAMPDIFF(YEAR, c.fecha_nacimiento, CURDATE())) AS edad_promedio " +
            "FROM clientes c", nativeQuery = true)
    int getEdadPromedio();

    @Query(value = "SELECT STDDEV_POP(TIMESTAMPDIFF(YEAR, c.fecha_nacimiento, CURDATE())) AS desviacion_estandar " +
            "FROM clientes c", nativeQuery = true)
    double getDesviacionEstandar();
}
