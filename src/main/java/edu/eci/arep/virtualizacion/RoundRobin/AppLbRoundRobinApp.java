/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.eci.arep.virtualizacion.RoundRobin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
/**
 *
 * @author camil
 */


@SpringBootApplication
@ComponentScan(
        basePackages = {"edu.eci.arep.virtualizacion.RoundRobin"},
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = edu.eci.arep.virtualizacion.RoundRobin.LoadBalancerController.class),
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = edu.eci.arep.virtualizacion.RoundRobin.WebController.class)
        },
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = edu.eci.arep.virtualizacion.controller.LogController.class)
        }
)
public class AppLbRoundRobinApp {
    public static void main(String[] args) {
        SpringApplication.run(AppLbRoundRobinApp.class, args);
    }
}
