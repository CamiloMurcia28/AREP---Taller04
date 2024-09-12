/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.eci.arep.virtualizacion.RoundRobin;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author camil
 */

@Controller
public class WebController {

    @GetMapping("/")
    public String index() {
        System.out.println("index");
        System.out.println("/classes/index.html");
        return "index.html";
    }
}
