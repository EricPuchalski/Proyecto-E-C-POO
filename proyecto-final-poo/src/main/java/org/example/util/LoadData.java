package org.example.util;

import org.example.dao.CarrierRepository;
import org.example.dao.CustomerRepository;
import org.example.dao.EmployeeRepository;
import org.example.dao.OrderRepository;
import org.example.dao.ProductCategoryRepository;
import org.example.dao.ProductRepository;
import org.example.dao.SectorRepository;
import org.example.dao.SupplierRepository;
import org.example.dao.TrackingRepository;
import org.example.dao.WarehouseRepository;



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

    }
}
