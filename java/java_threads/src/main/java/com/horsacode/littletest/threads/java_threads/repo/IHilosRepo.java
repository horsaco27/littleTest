package com.horsacode.littletest.threads.java_threads.repo;

import com.horsacode.littletest.threads.java_threads.model.Hilos;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IHilosRepo extends JpaRepository<Hilos, Integer> {
    
}
