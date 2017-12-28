package com.example.springcustomannotationsample.service;


import java.util.List;
import java.util.Optional;

public class GenericDAO<E> {
    private Class<E> entityClass;
    public GenericDAO(Class<E> entityClass){
        this.entityClass = entityClass;
    }

    public List<E> findAll(){
        return null;
    }

    public Optional<E> persist(E toPersist){
        return null;
    }
}
