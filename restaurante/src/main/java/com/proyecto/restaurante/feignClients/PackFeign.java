package com.proyecto.restaurante.feignClients;

import com.proyecto.restaurante.modelo.Pack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "pack", url = "http://localhost:8002/v1/pack")
public interface PackFeign {

    @GetMapping("/allPack/{idRestaurante}")
    List<Pack>getPacks(@PathVariable("idRestaurante") Long idRestaurante);

    @PostMapping
    Pack savePack(@RequestBody Pack pack);
}
