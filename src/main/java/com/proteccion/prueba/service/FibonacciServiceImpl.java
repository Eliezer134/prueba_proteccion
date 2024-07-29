package com.proteccion.prueba.service;

import com.proteccion.prueba.entities.FibonacciEntity;
import com.proteccion.prueba.repository.FibonacciRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    List<Integer> result = new ArrayList<>(series.subList(series.size() - n, series.size()));
    result.sort((a, b) -> b - a);

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

