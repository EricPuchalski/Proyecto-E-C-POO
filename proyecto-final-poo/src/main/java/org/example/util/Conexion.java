/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ericp
 */
public class Conexion {
    private static final String PERSISTENCE_UNIT_NAME = "lde_pu";
    private static EntityManagerFactory emf;
    private static EntityManager em;

    public Conexion() {
        Conexion.connect();
    }
    
    

    public static  void connect(){
        if (em==null){
            Conexion.emf= Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            Conexion.em = Conexion.emf.createEntityManager();
        }
    }

    public static EntityManagerFactory getEmf() {
        return emf;
    }

    public static void setEmf(EntityManagerFactory emf) {
        Conexion.emf = emf;
    }

    public static EntityManager getEm() {
        return em;
    }

    public static void setEm(EntityManager em) {
        Conexion.em = em;
    }
    
    
   
  
}
