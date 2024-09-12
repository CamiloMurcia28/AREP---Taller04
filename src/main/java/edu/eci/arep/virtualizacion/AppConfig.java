/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.eci.arep.virtualizacion;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author camil
 */
@Configuration
public class AppConfig {
    
    @Bean
    @ConfigurationProperties(prefix = "spring.data.mongodb")
    public MongoProperties mongoProperties(){
        return new MongoProperties();
    }
}
