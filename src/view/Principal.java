package view;

import java.util.concurrent.Semaphore;

import controller.ThreadFormula1;

public class Principal {
	    public static void main(String[] args) {
	        Semaphore semaforo = new Semaphore(5);
	        ThreadFormula1[][] carros = new ThreadFormula1[7][2];

	        for (int i = 0; i < 7; i++) {
	            for (int j = 0; j < 2; j++) {
	                carros[i][j] = new ThreadFormula1("Equipe " + (i + 1), j + 1, semaforo);
	                carros[i][j].start();
	            }
	        }

	        try {
	            for (int i = 0; i < 7; i++) {
	                for (int j = 0; j < 2; j++) {
	                    carros[i][j].join();
	                }
	            }
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        System.out.println("Grid de largada:");
	        for (int i = 0; i < 7; i++) {
	            for (int j = 0; j < 2; j++) {
	                double[] tempos = carros[i][j].getTempos();
	                double melhorVolta = tempos[0];
	                for (int k = 1; k < 3; k++) {
	                    if (tempos[k] < melhorVolta) {
	                        melhorVolta = tempos[k];
	                    }
	                }
	                System.out.println("Equipe: " + carros[i][j].equipe + ", Carro: " + carros[i][j].numeroCarro + ", Melhor tempo: " + melhorVolta);
	            }
	        }
	    }
	}


