package com.duoc.rabbitMQ.controller;

import com.duoc.rabbitMQ.dto.GuiaDespachoMensaje;
import com.duoc.rabbitMQ.service.ProductorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producir")
@RequiredArgsConstructor
public class ProductorController {

    private final ProductorService productorService;

    @PostMapping("/exito")
    public ResponseEntity<String> producirExito(@RequestBody GuiaDespachoMensaje mensaje) {
        productorService.enviarExito(mensaje.guiaId(), mensaje.numeroGuia());
        return ResponseEntity.ok("Mensaje de exito publicado en guiaQueue");
    }

    @PostMapping("/error")
    public ResponseEntity<String> producirError(@RequestBody GuiaDespachoMensaje mensaje) {
        productorService.enviarError(mensaje.guiaId(), mensaje.numeroGuia(), mensaje.detalle());
        return ResponseEntity.ok("Mensaje de error publicado en guiaErrorQueue");
    }
}