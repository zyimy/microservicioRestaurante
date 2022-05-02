package com.proyecto.pack.controller;

import com.proyecto.pack.entity.Pack;
import com.proyecto.pack.service.PackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pack")
@CrossOrigin("*")
public class PackController {

    @Autowired
    private PackService packService;

    @PostMapping
    public ResponseEntity<Pack>save(@RequestBody Pack pack){
        Pack pack1 = packService.savePack(pack);
        return ResponseEntity.ok(pack1);
    }

    @GetMapping("/allPack/{idRestaurante}")
    public ResponseEntity<List<Pack>>listaPack(@PathVariable("idRestaurante") int idRestaurante){
        List<Pack>lista = packService.listapack(idRestaurante);

        if (lista.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(lista);
        }
    }

}
