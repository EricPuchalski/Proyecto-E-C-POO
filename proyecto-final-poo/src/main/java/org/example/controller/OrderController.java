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

    public void createOrder(Order order, Warehouse warehouseOrig, Warehouse warehouseDest, String cuitCustomer, String cuitCarrier) {
        Customer orderCustomer = customerController.findOne(cuitCustomer);
        Carrier orderCarrier = carrierController.findOne(cuitCarrier);
        order.setWarehouseOrig(warehouseOrig);
        order.setWarehouseDest(warehouseDest);
        order.setCustomer(orderCustomer);
        order.setCarrier(orderCarrier);
        order.setOrderStart(LocalDate.now());
        order.setOrderStatus(order.getWarehouseOrig().getSectors().get(0).getDescription());
        this.create(order);
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

    public void processOrder(String orderNumber, String cuitEmpleado) {
        orderService.processOrder(orderNumber, cuitEmpleado);
    }

    public void completeOrder(String orderNumber) {
        orderService.completeOrder(orderNumber);
    }

    public void sendOrderToDispatch(String orderNumber) {
        orderService.sendOrderToDispatch(orderNumber);
    }

    public void dispatchOrder(String orderNumber) {
        orderService.dispatchOrder(orderNumber);
    }

    public void orderTransit(String orderNumber) {
        orderService.orderTransit(orderNumber);
    }

    public void sendToDelivery(String orderNumber, String cuitEmployeeReceiv) {
        orderService.sendToDelivery(orderNumber, cuitEmployeeReceiv);
    }
    
   public void deliverOrder(String orderNumber, String cuitEmployee) {
    orderService.deliverOrder(orderNumber, cuitEmployee);
}

    public List<Order> findAllOrdersByCustomer(Long idCustomer) {
        return orderService.findAllOrdersByCustomers(idCustomer);
    }
        public List<Order> findAllOrdersByWarehouseOrig(Long idWarehouse) {
        return orderService.findAllOrdersByWarehouseOrig(idWarehouse);
    }
}
