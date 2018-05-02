/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.milos.univesitycourse.service;

import org.milos.univesitycourse.domain.Admin;

/**
 *
 * @author Milos
 */
public interface IAdminService {
    public Admin login(Admin admin) throws Exception;
}
