package org.example.service;

import org.example.dao.InformationRepository;

public class InformationService {
    private InformationRepository informationRepository;

    public InformationService(InformationRepository informationRepository) {
        this.informationRepository = informationRepository;
    }

    public int getNumberOfOrdersByBranch(String branchCode) {
        return informationRepository.getNumberOfOrdersByBranch(branchCode);
    }

    public int countOrdersInPendingStatus() {
        return informationRepository.countOrdersInPendingStatus();
    }

    public int getCustomerOrderHistory(Long id) {
        return informationRepository.getCustomerOrderHistory(id);
    }

    public void showOrderStatus() {
        informationRepository.showOrderStatus();
    }
}
//package org.example.service;
//
//import org.example.repository.InformeRepository;
//
//public class InformationService {
//    private InformeRepository informeRepository;
//
//    public InformationService(InformeRepository informeRepository) {
//        this.informeRepository = informeRepository;
//    }
//
//    public int obtenerCantidadPedidosPorSucursal(String codigoSucursal) {
//        return informeRepository.obtenerCantidadPedidosPorSucursal(codigoSucursal);
//    }
//
//    public int contarPedidosEnEstadoPendiente() {
//        return informeRepository.contarPedidosEnEstadoPendiente();
//    }
//
//    public int obtenerHistorialDeUnCliente(String cuit){
//       return  informeRepository.obtenerHistorialDeUnCliente(cuit);
//    }
//
//
//    public void mostrarEstadoDePedidos(){
//
//    }
//}
