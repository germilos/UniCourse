/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.milos.univesitycourse.dao;

import org.milos.univesitycourse.domain.Admin;

/**
 *
 * @author Milos
 */
public interface IAdminDAO {
    public Admin getAdmin(Admin admin) throws Exception;
}
