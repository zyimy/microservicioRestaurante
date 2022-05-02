package com.proyecto.pack.service;

import com.proyecto.pack.entity.Pack;
import com.proyecto.pack.repository.PackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackService {

    @Autowired
    private PackRepository packRepository;

    public Pack savePack(Pack pack){
        return  packRepository.save(pack);
    }

    public List<Pack>listapack(int restauranteId){
        return packRepository.findByRestauranteId(restauranteId);
    }
}
