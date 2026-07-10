package com.duoc.rabbitMQ.dto;

public record GuiaDespachoMensaje(
        Long guiaId,
        String numeroGuia,
        String estado,
        String detalle
) {
}