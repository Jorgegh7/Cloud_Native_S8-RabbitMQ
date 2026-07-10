package com.duoc.rabbitMQ.controller;

import com.duoc.rabbitMQ.service.ConsumidorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumir")
@RequiredArgsConstructor
public class ConsumidorController {

    private final ConsumidorService consumidorService;

    @PostMapping
    public ResponseEntity<String> consumir() {
        String resultado = consumidorService.consumirYGuardar();
        return ResponseEntity.ok(resultado);
    }
}