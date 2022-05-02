package com.proyecto.pack.repository;

import com.proyecto.pack.entity.Pack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PackRepository extends JpaRepository<Pack,Long> {

    List<Pack>findByRestauranteId(int restauranteId);
}
