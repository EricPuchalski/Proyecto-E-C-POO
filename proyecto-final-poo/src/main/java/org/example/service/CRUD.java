package org.example.service;

import org.example.dao.exceptions.NonexistentEntityException;

import java.util.List;

public interface CRUD <T>{
    T save(T t);

    T upDate(T t) throws Exception;

    T findOne(String cuit);
    List<T> findAll();

    void delete(String cuit) throws NonexistentEntityException;
}
