package org.example.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import org.example.model.OrderLine;
import org.example.model.Order;
import org.example.service.OrderService;

import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JTable;
import org.example.model.Carrier;
import org.example.model.Customer;
import org.example.model.Warehouse;

public class OrderController implements CRUD<Order> {

    private final OrderService orderService;
    private CustomerController customerController;
    private CarrierController carrierController;
    private WarehouseController warehouseController;

    public OrderController() {
        this.orderService = new OrderService();
        this.customerController = new CustomerController();
        this.carrierController = new CarrierController();
        this.warehouseController = new WarehouseController();
    }

    public List<String> returnCuitsCustomerCarrier(JTable tblCustomers, JTable tblCarriers) {
        List<String> cuits = new ArrayList<>();
        if (tblCustomers.getRowCount() > 0 && tblCustomers.getSelectedRow() != -1
                && tblCarriers.getRowCount() > 0 && tblCarriers.getSelectedRow() != -1) {
            String idCliente = String.valueOf(tblCustomers.getValueAt(tblCustomers.getSelectedRow(), 3));
            String idTransportista = String.valueOf(tblCarriers.getValueAt(tblCarriers.getSelectedRow(), 2));
            cuits.add(idCliente);
            cuits.add(idTransportista);
        }
        return cuits;
    }

    public Order createOrder(Order order, Warehouse warehouseOrig, Warehouse warehouseDest, String cuitCustomer, String cuitCarrier) {
    return orderService.createOrder(order, warehouseOrig, warehouseDest, cuitCustomer, cuitCarrier);
    }
    public boolean informOrderPosition(String cuitCarrier, String orderNumber, double latitud, double longitud) throws Exception {
        return orderService.informOrderPosition(cuitCarrier, orderNumber, latitud, longitud);
    }


    public Order findOneByOrderNumber(String orderNumber) {
        return orderService.findOne(orderNumber);
    }

    @Override
    public List<Order> findAll() {
        return orderService.findAll();
    }

    @Override
    public Order upDate(Order t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Order create(Order t) {
        return orderService.save(t);
    }

    @Override
    public Order findOne(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<Order> findAllOrdersByNumber(String orderNumber) {
        return orderService.findAllOrdersByNumber(orderNumber);
    }

    public Order processOrder(String orderNumber, String cuitEmpleado) {
        return orderService.processOrder(orderNumber, cuitEmpleado);
    }

    public Order completeOrder(String orderNumber) {
       return orderService.completeOrder(orderNumber);
    }

    public Order sendOrderToDispatch(String orderNumber) {
       return orderService.sendOrderToDispatch(orderNumber);
    }

    public Order dispatchOrder(String orderNumber) {
       return orderService.dispatchOrder(orderNumber);
    }

    public Order orderTransit(String orderNumber) {
       return orderService.orderTransit(orderNumber);
    }

    public Order sendToDelivery(String orderNumber, String cuitEmployeeReceiv) {
       return orderService.sendToDelivery(orderNumber, cuitEmployeeReceiv);
    }
    
   public Order deliverOrder(String orderNumber) {
   return orderService.deliverOrder(orderNumber);
}

    public List<Order> findAllOrdersByCustomer(Long idCustomer) {
        return orderService.findAllOrdersByCustomers(idCustomer);
    }
        public List<Order> findAllOrdersByWarehouseOrig(Long idWarehouse) {
        return orderService.findAllOrdersByWarehouseOrig(idWarehouse);
    }
        public List<Order> findAllUndeliveredOrders() {
    return orderService.findAllUndeliveredOrders();
}
}
