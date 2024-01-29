package org.example.util;

import dao.CarrierRepository;
import dao.CustomerRepository;
import dao.EmployeeRepository;
import dao.OrderRepository;
import dao.ProductCategoryRepository;
import dao.ProductRepository;
import dao.SectorRepository;
import dao.SupplierRepository;
import dao.TrackingRepository;
import dao.WarehouseRepository;



public class LoadData {
    public static void loadData() throws Exception{
        CustomerRepository customerDao = new CustomerRepository();
        customerDao.upLoad();
        ProductCategoryRepository productCategoryRepository = new  ProductCategoryRepository();
        productCategoryRepository.upload();
        SupplierRepository supplierRepository = new SupplierRepository();
        supplierRepository.upLoad();
        SectorRepository sectorRepository = new SectorRepository();
        sectorRepository.upLoad();
        WarehouseRepository warehouseRepository = new WarehouseRepository();
        warehouseRepository.upLoad();
//        EmployeeRepository employeeRepository= new EmployeeRepository();
//        employeeRepository.upLoad();
        ProductRepository productRepository = new ProductRepository();
        productRepository.upLoad();
        CarrierRepository carrierRepository = new CarrierRepository();
        carrierRepository.upLoad();
        OrderRepository orderRepository = new OrderRepository();
        orderRepository.upload();

    }
}
