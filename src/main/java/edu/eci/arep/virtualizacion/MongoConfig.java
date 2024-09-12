/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.eci.arep.virtualizacion;

import com.mongodb.client.*;
import org.springframework.context.annotation.*;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 *
 * @author camil
 */

@Configuration
@Profile("!roundrobin")
public class MongoConfig {
    
    @Bean
    public MongoClient mongoClient(){
        return MongoClients.create("mongodb://admin:camilo123@mongodb:27017");
    }
    
    @Bean
    public MongoTemplate mongoTemplate(){
        return new MongoTemplate(mongoClient(),"logdb");
    }
    
}
