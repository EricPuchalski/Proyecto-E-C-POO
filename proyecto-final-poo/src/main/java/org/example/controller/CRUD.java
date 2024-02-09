package org.example.controller;

import org.example.dao.exceptions.NonexistentEntityException;

import java.util.List;

public interface CRUD <T>{
    T create(T t);
    T findOne(String id);
    List<T> findAll();
    T upDate(T t) throws Exception;
    void delete(String id) throws NonexistentEntityException;
}
