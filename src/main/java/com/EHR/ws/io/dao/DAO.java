/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EHR.ws.io.dao;

import com.EHR.ws.shared.dto.UserDTO;

/**
 *
 * @author Supriya
 */
public interface DAO {
    void openConnection();
    UserDTO getUserByUserName(String userName);
    UserDTO saveUser(UserDTO user);
    void closeConnection();
}
