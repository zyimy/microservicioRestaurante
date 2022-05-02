package com.proyecto.restaurante.service;

import com.proyecto.restaurante.entity.Restaurante;
import com.proyecto.restaurante.feignClients.PackFeign;
import com.proyecto.restaurante.modelo.Pack;
import com.proyecto.restaurante.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.PackedColorModel;
import java.util.ArrayList;
import java.util.List;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private PackFeign packFeign;


    public Restaurante saveRestaurante(Restaurante restaurante){
            return restauranteRepository.save(restaurante);
    }

    public List<Pack>listaPacks(Long idRestaurante){
        //Restaurante restaurante = restauranteRepository.findById(idRestaurante).orElse(null);

            List<Pack>listas = packFeign.getPacks(idRestaurante);
            return listas;

    }

    public Pack guardarPack(Pack pack, int idRestaurante){
        pack.setRestauranteId(idRestaurante);
        return packFeign.savePack(pack);
    }


}
