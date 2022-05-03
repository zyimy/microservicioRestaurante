package com.proyecto.restaurante.feignClients;

import com.proyecto.restaurante.modelo.Pack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(name = "pack/pack")
public interface PackFeign {

    @GetMapping("/allPack/{idRestaurante}")
    List<Pack>getPacks(@PathVariable("idRestaurante") Long idRestaurante);

    @PostMapping("/save")
    Pack savePack(@RequestBody Pack pack);
}
