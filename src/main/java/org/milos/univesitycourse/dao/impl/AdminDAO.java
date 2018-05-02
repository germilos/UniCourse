/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.milos.univesitycourse.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import org.milos.univesitycourse.dao.IAdminDAO;
import org.milos.univesitycourse.domain.Admin;
import org.milos.univesitycourse.listeners.EMF;

/**
 *
 * @author Milos
 */
public class AdminDAO implements IAdminDAO {

    private EntityManager em;

    @Override
    public Admin getAdmin(Admin admin) throws Exception {
        em = EMF.createEntityManager();
        List<Admin> foundAdmin = em.createQuery("SELECT a FROM Admin a WHERE a.username = :username AND a.password = :password")
                .setParameter("username", admin.getUsername())
                .setParameter("password", admin.getPassword()).getResultList();
        try {
            if (!foundAdmin.isEmpty()) {
                return foundAdmin.get(0);
            } else {
                throw new Exception("Admin not found!");
            }
        } catch (Exception e) {
            throw e;
        } finally {
            em.close();
        }
    }
}
