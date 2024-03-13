/*
AUTOR: Mario Ventura
CURSO: 2021/2022
ASIGNATURA: Programación II
PROGRAMA: Resolver sistema de ecuaciones lineal mediante matrices
PROFESOR: Juan Montes de Oca
*/

package clases.problemamatrices;

//CLASE PARA CREAR MATRICES

import java.io.Serializable;

public class Matriz implements Serializable {
    
    //----> ATRIBUTOS
    int filas;          //Filas de la matriz
    int columnas;       //Columnas de la matriz   
    float[][] matriz;   //Array bidimensional
    
    //----> MÉTODOS
    //Constructores
    public Matriz() {
        
    }
    public Matriz(int f, int c) {
        filas = f;
        columnas = c;
        //Dar dimensión al array bidimensional
        matriz = new float[f][c];
    }
    
    //Getters
    public int getNumFilas() {
        return filas;
    }
    public int getNumColumnas() {
        return columnas;
    }
    public float getValorEn(int f, int c) {
        return matriz[f][c];
    }
    
    //Setters
    public void setFilas(int f) {
        filas = f;
    }
    public void setColumnas(int c) {
        columnas = c;
    } 
    public void setValorEn(float valor, int f, int c) {
        matriz[f][c] = valor;
    }
    
    //toString()
    @Override
    public String toString() {
        //String al que se le dara valor al iterar
        String s = "";
        //Iteracion de filas y columnas
        for(int i=0; i<filas; i++) {
            for(int j=0; j<columnas; j++) {
                System.out.print("["+matriz[i][j]+"] ");
            }
            System.out.println("");
        }
        //Retorno
        return s;
    }
    
    //Inicializar matriz
    public void inicializar() {
        //Inicializar a 0 en un primer momento
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = 0;
            }
        }
    }
    
    //Longitud en bytes de un objeto matriz
    public int getLongitudObjetoMatriz() {
        // float = 32 bits = 4 bytes
        // En una matriz hay nxm floats
        int numElementos = filas*columnas;
        
        //Cada elemento son 4 bytes
        return (4*(numElementos));
    }
    //---> Fin de la clase matriz
}