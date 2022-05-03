package com.proyecto.restaurante.controller;

import com.proyecto.restaurante.entity.Restaurante;
import com.proyecto.restaurante.modelo.Pack;
import com.proyecto.restaurante.service.RestauranteService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/restaurante")
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteService;

    @PostMapping
    public ResponseEntity<Restaurante>save(@RequestBody Restaurante restaurante){
        Restaurante restaurante1 = restauranteService.saveRestaurante(restaurante);
       return ResponseEntity.ok(restaurante);
    }

    @CircuitBreaker(name = "packsCB", fallbackMethod = "fallBackGetPacks")
    @GetMapping("/listaPacks/{idRestaurante}")
    public ResponseEntity<List<Pack>>listaPack(@PathVariable("idRestaurante") Long idRestaurante){
         List<Pack>lista = restauranteService.listaPacks(idRestaurante);
         try {
             return ResponseEntity.ok(lista);
         }catch (NullPointerException e){
             return ResponseEntity.noContent().build();
         }

    }

    @CircuitBreaker(name = "packsCB", fallbackMethod = "fallBackSavePack")
    @PostMapping("/savePack/{idRestaurante}")
    public ResponseEntity<Pack>ingresarPack(@RequestBody Pack pack,@PathVariable("idRestaurante") Long idRestaurante){
        Pack pack1 = restauranteService.guardarPack(pack,idRestaurante);
        return ResponseEntity.ok(pack);
    }



    private ResponseEntity<List<Pack>> fallBackGetPacks(@PathVariable("idRestaurante") Long idRestaurante, RuntimeException e) {
        return new ResponseEntity("El usuario" + idRestaurante + " tiene los coches en el trailer", HttpStatus.OK);

    }


    private ResponseEntity<Pack> fallBackSavePack(@PathVariable("idRestaurante") Long idRestaurante, @RequestBody Pack pack,
                                                RuntimeException e) {
        return new ResponseEntity("El usuario" + idRestaurante + " No  tiene dinero para coches", HttpStatus.OK);

    }
}
