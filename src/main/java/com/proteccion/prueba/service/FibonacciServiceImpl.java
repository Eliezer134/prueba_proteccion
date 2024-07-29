package com.proteccion.prueba.service;

import com.proteccion.prueba.entities.FibonacciEntity;
import com.proteccion.prueba.repository.FibonacciRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class FibonacciServiceImpl implements FibonacciService {

  @Autowired
  private FibonacciRepository fibonacciRepository;


  @Override
  public List<Integer> generateFibonacciSeries(int x, int y, int n) {
    List<Integer> series = new ArrayList<>();
    series.add(x);
    series.add(y);

    for (int i = 2; i < n + 2; i++) {
      int next = series.get(i - 1) + series.get(i - 2);
      series.add(next);
    }

    // Obtener solo los números requeridos de la serie generada
    List<Integer> result = new ArrayList<>(series.subList(2, n + 2));

    // Invertir la lista para tener los números en orden descendente
    Collections.reverse(result);

    return result;
  }

  @Override
  public void saveFibonacciSeries(String executionTime, List<Integer> series) {
    FibonacciEntity fibonacciEntity = new FibonacciEntity();
    fibonacciEntity.setExecutionTime(executionTime);
    fibonacciEntity.setSeries(series);
    fibonacciRepository.save(fibonacciEntity);
  }

  @Override
  public List<FibonacciEntity> getAllFibonacciSeries() {
    return fibonacciRepository.findAll();
  }
}

