package com.horsacode.littletest.threads.java_threads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import com.horsacode.littletest.threads.java_threads.model.Hilos;
import com.horsacode.littletest.threads.java_threads.repo.IHilosRepo;
import com.horsacode.littletest.threads.java_threads.runnables.Task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaThreadsApplication implements CommandLineRunner {

	@Autowired
	private IHilosRepo repo;

	private static Logger log = LoggerFactory.getLogger(JavaThreadsApplication.class);

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(JavaThreadsApplication.class);
		app.run(args);
	}

	@Override
	public void run(String... args) throws InterruptedException {

		List<Thread> listaHilos = new ArrayList<>();
		int contadorHilos = 0;
		int foliosSimultaneos;
		while (!Thread.interrupted()) {
			Optional<Hilos> hilos = repo.findById(1);
			if(hilos.isPresent()){
				foliosSimultaneos = hilos.get().getFoliosSimultaneos();
				log.info("Numero de foliosSimultaneos: {}", foliosSimultaneos);
			}else{
				log.warn("No se logro obtener el numero de folios simultaneos");
				break;
			}

			if(contadorHilos <= foliosSimultaneos){
				int hilosFaltantes = foliosSimultaneos - contadorHilos;
				for(int i = 0; i < hilosFaltantes; i++){
					Runnable task = new Task(1000000000L + i);
					Thread worker = new Thread(task);
					worker.setName("folio: " + String.valueOf(i));
					worker.start();
					listaHilos.add(worker);
					contadorHilos++;
				}
			}

			for(Iterator<Thread> iterator = listaHilos.iterator(); iterator.hasNext();){
				Thread hiloActual = iterator.next();
				if(!hiloActual.isAlive()){
					log.info("Hilo {} terminado", hiloActual.getName());
					iterator.remove();
					contadorHilos--;
				}
			}

			log.info("Existen {} hilos activos.", contadorHilos);

			Thread.sleep(10000);
		}
	}

}
