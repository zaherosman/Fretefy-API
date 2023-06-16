package com.zaher.APIRegioes.controller;

import com.zaher.APIRegioes.domain.RegiaoDto;
import com.zaher.APIRegioes.model.Regiao;
import com.zaher.APIRegioes.service.RegiaoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/regiao")
public class RegiaoController {

    @Autowired
    private RegiaoService service;

    @PostMapping
    public ResponseEntity<RegiaoDto> insertRegiao(@RequestBody RegiaoDto dto){
        dto = this.service.insertRegiao(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getRegiaoId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<RegiaoDto> updateRegiao(@PathVariable Integer id, @RequestBody RegiaoDto regiao){
        return ResponseEntity.ok().body(service.update(id, regiao));
    }

    @GetMapping("/allRegiao")
    public ResponseEntity<List<RegiaoDto>> getAllUsers(){
        return ResponseEntity.ok(this.service.getAllRegiao());
    }

}
