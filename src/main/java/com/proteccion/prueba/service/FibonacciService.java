package com.proteccion.prueba.service;

import com.proteccion.prueba.entities.FibonacciEntity;

import java.util.List;

public interface FibonacciService {
  List<Integer> generateFibonacciSeries(int x, int y, int n);
  void saveFibonacciSeries(String executionTime, List<Integer> series);
  List<FibonacciEntity> getAllFibonacciSeries();
}

