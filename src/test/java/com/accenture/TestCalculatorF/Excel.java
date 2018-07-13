package com.accenture.TestCalculatorF;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

 
public class Excel {
 
	
	static String nombreArchivo = "dataAppium.xlsx";
	static String rutaArchivo = "C:\\Users\\danny.rojas\\Desktop\\Retos\\3-AppiumSelenium\\" + nombreArchivo;
	String hoja = "Hoja1";
		
		
		public static List<Dato> lectura(){
		List<Dato>datos = new ArrayList<Dato>();
		
			//ArrayList<Dato> datos = new ArrayList<>();
 
		try  {
			FileInputStream file = new FileInputStream(new File(rutaArchivo));
			// leer archivo excel
			XSSFWorkbook worbook = new XSSFWorkbook(file);
			//obtener la hoja que se va leer
			XSSFSheet sheet = worbook.getSheetAt(0);
			//obtener todas las filas de la hoja excel
			Iterator<Row> rowIterator = sheet.iterator();
 
			Row row;
			
			Dato info =null;
			// se recorre cada fila hasta el final
			while (rowIterator.hasNext()) {
				row = rowIterator.next();
				//se obtiene las celdas por fila
				Iterator<Cell> cellIterator = row.cellIterator();
				Cell cell;
				int count=0;
				info =  new Dato();
				
				//se recorre cada celda
				while (cellIterator.hasNext()) {
					cell = cellIterator.next();
					switch(count) {
					case 0:{
						info.setNumber1((int)cell.getNumericCellValue());
						//System.out.println(info.getNumber1());
						break;
					}case 1:{
						info.setOperator(cell.getStringCellValue());
						//System.out.println(info.getOperator());
						break;
					}case 2:{
						info.setNumber2((int)cell.getNumericCellValue());
						//System.out.println(info.getNumber2());
						 break;
					}
				}
					count++;
					
					
					// se obtiene la celda en específico y se la imprimir
				}
				System.out.println();
				datos.add(info);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return datos;
	}
		
//		public static void main(String a[]) {
//			List<Dato> datos = new Excel().lectura();
//			System.out.println(datos.size());
//			for(Dato dato : new Excel().lectura()) {
//				System.out.println(dato);
//			}
//			System.out.println("hola mama");
//		}
	}

