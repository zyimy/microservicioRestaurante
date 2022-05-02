package com.proyecto.restaurante.feignClients;

import com.proyecto.restaurante.modelo.Pack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//, url = "http://localhost:8002/v1/pack"
@FeignClient(name = "pack", url = "http://localhost:8002/v1/pack")
public interface PackFeign {

    @GetMapping("/allPack/{idRestaurante}")
    List<Pack>getPacks(@PathVariable("idRestaurante") Long idRestaurante);

    @PostMapping
    Pack savePack(@RequestBody Pack pack);
}
