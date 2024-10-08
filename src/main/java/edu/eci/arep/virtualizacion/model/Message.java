/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.eci.arep.virtualizacion.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author camil
 */
@Document
public class Message {
    @Id
    private String id;
    private String message;
    private LocalDateTime timestamp;
    
    @JsonCreator
    public Message(@JsonProperty("message") String message, @JsonProperty("timestamp") LocalDateTime timestamp ){
        this.message = message;
        this.timestamp = timestamp;
    }
    
    public Message(){ 
    }
    
    public String getMessage(){
        return message;
    }
    
    public void setMessage(String message){
        this.message = message;
    }
    
    public LocalDateTime getDate(){
        return this.timestamp;
    }
    
    public void setDate(LocalDateTime timestamp){
        this.timestamp = timestamp;
    }
    
    public String getId(){
        return this.id;
    }
    
    public void setId(String id){
        this.id = id;
    }
}
