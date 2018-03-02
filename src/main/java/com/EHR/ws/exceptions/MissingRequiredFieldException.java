/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EHR.ws.exceptions;

/**
 *
 * @author Supriya
 */
public class MissingRequiredFieldException  extends RuntimeException{

    private static final long serialVersionUID = -1405803135979300122L;
    
    public MissingRequiredFieldException(String message)
    {
        super(message);
    }
    
}