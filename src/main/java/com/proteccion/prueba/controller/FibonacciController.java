package com.proteccion.prueba.controller;

import com.proteccion.prueba.entities.FibonacciEntity;
import com.proteccion.prueba.service.FibonacciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FibonacciController {

  private final FibonacciService fibonacciService;

  @Autowired
  public FibonacciController(FibonacciService fibonacciService) {
    this.fibonacciService = fibonacciService;
  }

  @PostMapping("/fibonacci")
  public List<Integer> getFibonacciSeries(@RequestBody String time) {
    String[] timeParts = time.split(":");
    int x = Character.getNumericValue(timeParts[1].charAt(0));
    int y = Character.getNumericValue(timeParts[1].charAt(1));
    int n = Integer.parseInt(timeParts[2]);

    List<Integer> series = fibonacciService.generateFibonacciSeries(x, y, n);

    // Guardar en la base de datos
    String executionTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    fibonacciService.saveFibonacciSeries(executionTime, series);

    return series;
  }

  @GetMapping("/fibonacci")
  public List<FibonacciEntity> getFibonacciSeries() {
    return fibonacciService.getAllFibonacciSeries();
  }
}