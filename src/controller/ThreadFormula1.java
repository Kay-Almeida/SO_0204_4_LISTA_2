package controller;

import java.util.concurrent.Semaphore;

public class ThreadFormula1 extends Thread {
	    public String equipe;
	    public int numeroCarro;
	    private Semaphore semaforo;
	    private double[] tempos;
	    private int voltasCompletas;

	    public ThreadFormula1(String equipe, int numeroCarro, Semaphore semaforo) {
	        this.equipe = equipe;
	        this.numeroCarro = numeroCarro;
	        this.semaforo = semaforo;
	        this.tempos = new double[3];
	        this.voltasCompletas = 0;
	    }

	    public void run() {
	        try {
	            for (int volta = 0; volta < 3; volta++) {
	                semaforo.acquire();
	                System.out.println("Carro da equipe " + equipe + ", número " + numeroCarro + " iniciando volta " + (volta + 1));
	                double tempoVolta = Math.random() * 100; 
	                System.out.println("Tempo de volta: " + tempoVolta + " segundos");
	                tempos[volta] = tempoVolta;
	                sleep((long) tempoVolta); 
	                System.out.println("Carro da equipe " + equipe + ", número " + numeroCarro + " completou volta " + (volta + 1));
	                semaforo.release();

	                voltasCompletas++;
	            }
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }

	    public double[] getTempos() {
	        return tempos;
	    }

	    public int getVoltasCompletas() {
	        return voltasCompletas;
	    }
	}


