package com.ipartek.formacion.utilidades;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;

import com.ipartek.formacion.controller.listener.AppListener;
import com.ipartek.formacion.modelo.dao.ProductoDAO;

public class Archivo {
	
	private final static Logger LOG = Logger.getLogger(AppListener.class);
	private static Archivo INSTANCE;
	
	private Archivo() {

	}
	
public synchronized static Archivo getInstance() {
		
		if (INSTANCE == null) {
			INSTANCE = new Archivo();
		}
		
		return INSTANCE;
	}

	public void escribir(String input, String path) {
		BufferedWriter bw;
		String ruta = path, texto = input;
		try {
			System.out.println("evento escribir");
			bw = new BufferedWriter(new FileWriter(ruta, true));
			bw.write(texto);
			bw.close();
		} catch (IOException e) {
			LOG.error("IOException");
		} catch (Exception e) {
			LOG.error("Exception");
		}
	}

	public void sobreescribir(String input, String path) {
		BufferedWriter bw;
		String ruta = path, texto = input;
		try {
			System.out.println("evento sobreescribir");
			bw = new BufferedWriter(new FileWriter(ruta));
			bw.write(texto);
			bw.close();
		} catch (IOException e) {
			LOG.error("IOException");
		} catch (Exception e) {
			LOG.error("Exception");
		}
	}

	public String leer(String path) {
		BufferedReader br;
		String ruta = path, linea = "", lectura = "";
		try {
			System.out.println("evento leer");
			br = new BufferedReader(new FileReader(ruta));
			while ((linea = br.readLine()) != null) {
				lectura += linea + "\r\n";
			}
			br.close();
		} catch (FileNotFoundException e) {
			LOG.error("FileNotFoundException");
		} catch (Exception e) {
			LOG.error("Exception");
		}
		return lectura;
	}
	
	public String leerLinea(String path) {
		BufferedReader br;
		String ruta = path, linea = "", lectura = "";
		try {
			System.out.println("evento leer");
			br = new BufferedReader(new FileReader(ruta));
			if ((linea = br.readLine()) != null) {
				lectura = linea;
			}
			br.close();
		} catch (FileNotFoundException e) {
			LOG.error("FileNotFoundException");
		} catch (Exception e) {
			LOG.error("Exception");
		}
		return lectura;
	}


}
