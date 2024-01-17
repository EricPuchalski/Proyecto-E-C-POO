package org.example.service;

import dao.exceptions.NonexistentEntityException;

import java.util.List;

public interface CRUD <T>{
    void save(T t);

    void upDate(T t) throws Exception;

    T findOne(String cuit);
    List<T> findAll();

    void delete(String cuit) throws NonexistentEntityException;
}
