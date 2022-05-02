package com.proyecto.restaurante.controller;

import com.proyecto.restaurante.entity.Restaurante;
import com.proyecto.restaurante.modelo.Pack;
import com.proyecto.restaurante.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/listaPacks/{idRestaurante}")
    public ResponseEntity<List<Pack>>listaPack(@PathVariable("idRestaurante") Long idRestaurante){
         List<Pack>lista = restauranteService.listaPacks(idRestaurante);
         try {
             return ResponseEntity.ok(lista);
         }catch (NullPointerException e){
             return ResponseEntity.noContent().build();
         }

    }

    @PostMapping("/savePack/{idRestaurante}")
    public ResponseEntity<Pack>ingresarPack(@RequestBody Pack pack,@PathVariable("idRestaurante") int idRestaurante){
        Pack pack1 = restauranteService.guardarPack(pack,idRestaurante);
        return ResponseEntity.ok(pack1);
    }
}
