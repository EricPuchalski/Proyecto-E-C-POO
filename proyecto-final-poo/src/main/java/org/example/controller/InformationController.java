package org.example.controller;

import org.example.service.InformationService;

public class InformationController {
    private InformationService informationService;

    public InformationController(InformationService informationService) {
        this.informationService = informationService;
    }

    public int obtenerCantidadPedidosPorSucursal(String codigoSucursal) {
        return informationService.obtenerCantidadPedidosPorSucursal(codigoSucursal);
    }

    public int contarPedidosEnEstadoPendiente() {
        return informationService.contarPedidosEnEstadoPendiente();
    }
    public int obtenerHistorialDeUnCliente(String cuit){
       return informationService.obtenerHistorialDeUnCliente(cuit);
    }
}