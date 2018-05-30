/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaFactory {

    private static JpaFactory instance;
    private EntityManagerFactory emf;

    private JpaFactory() {
        emf = Persistence.createEntityManagerFactory("PU");
    }

    public static JpaFactory getInstanance() {
        if (instance==null) {
            instance = new JpaFactory();
        }
        return instance;
    }

    public static EntityManager getEntityManager() {
        return getInstanance().emf.createEntityManager();
    }



}
