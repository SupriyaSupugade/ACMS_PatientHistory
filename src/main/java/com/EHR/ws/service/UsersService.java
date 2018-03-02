/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EHR.ws.service;

import com.EHR.ws.shared.dto.UserDTO;

/**
 *
 * @author Supriya
 */
public interface UsersService {
    UserDTO createUser(UserDTO user);
    //UserDTO getUser(String id);
    UserDTO getUserByUserName(String userName);
}
