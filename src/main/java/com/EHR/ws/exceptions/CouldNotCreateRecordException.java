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
public class CouldNotCreateRecordException extends RuntimeException{

    private static final long serialVersionUID = -8824856362988024706L;
    
    public CouldNotCreateRecordException(String message)
    {
        super(message);
    }
}