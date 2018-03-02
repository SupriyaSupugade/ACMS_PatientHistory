/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EHR.ws.service.impl;

import com.EHR.ws.exceptions.CouldNotCreateRecordException;
import com.EHR.ws.io.dao.DAO;
import com.EHR.ws.io.dao.impl.MySQLDAO;
import com.EHR.ws.service.UsersService;
import com.EHR.ws.shared.dto.UserDTO;
import com.EHR.ws.ui.model.response.ErrorMessages;
import com.EHR.ws.utils.UserProfileUtils;

/**
 *
 * @author Supriya
 */
public class UsersServiceImpl implements UsersService {

    DAO database;

    public UsersServiceImpl() {
        this.database = new MySQLDAO();
    }

    UserProfileUtils userProfileUtils = new UserProfileUtils();

    public UserDTO createUser(UserDTO user) {
        UserDTO returnValue = null;

        // Validate the required fields
        userProfileUtils.validateRequiredFields(user);

        // Check if user already exists
        UserDTO existingUser = this.getUserByUserName(user.getEmail());
        if (existingUser != null) {
            throw new CouldNotCreateRecordException(ErrorMessages.RECORD_ALREADY_EXISTS.name());
        }

        // Generate secure public user id 
        String userId = userProfileUtils.generateUserId(30);
        user.setUserId(userId);
        
        // Generate salt 
        String salt = userProfileUtils.getSalt(30);
        // Generate secure password 
        String encryptedPassword = userProfileUtils.generateSecurePassword(user.getPassword(), salt);
        user.setSalt(salt);
        user.setEncryptedPassword(encryptedPassword);
        
        // Record data into a database 
        returnValue = this.saveUser(user);

        return returnValue;
    }

    private UserDTO saveUser(UserDTO user) {
        UserDTO returnValue = null;
        // Connect to database 
        try {
            this.database.openConnection();
            returnValue = this.database.saveUser(user);
        } finally {
            this.database.closeConnection();
        }

        return returnValue;
    }
    @Override
    public UserDTO getUserByUserName(String userName) {
        UserDTO userDto = null;

        if (userName == null || userName.isEmpty()) {
            return userDto;
        }

        // Connect to database 
        try {
            this.database.openConnection();
            userDto = this.database.getUserByUserName(userName);
        } finally {
            this.database.closeConnection();
        }

        return userDto;
    }

}
