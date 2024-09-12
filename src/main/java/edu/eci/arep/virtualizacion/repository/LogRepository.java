/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.eci.arep.virtualizacion.repository;

import edu.eci.arep.virtualizacion.model.Message;
import java.util.*;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author camil
 */
public interface LogRepository extends MongoRepository<Message, String>{
    List<Message> findTop10ByOrderByTimestampDesc();
}
