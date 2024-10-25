package Actividad1;

import java.io.IOException;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class TextFile {
	public static void main(String[] args) throws IOException {
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Escriba el nombre del archivo o directorio: ");
		// crear objeto Path con base en la entrada del usuario
		Path ruta = Paths.get(sc.nextLine());
		if (Files.exists(ruta)) {
			//mostar información de archivo (o directorio)
			System.out.printf("%n%s existe%n",ruta.getFileName());
			System.out.printf("%s un directorio%n", Files.isDirectory(ruta)? "Es" : "No es");
			System.out.printf("%s una ruta absoluta%n",ruta.isAbsolute()? "Es" : "No es");
			System.out.printf("Fecha de ultima modificacion: %s%n", Files.getLastModifiedTime(ruta));
			System.out.printf("Tamanio: %s%n", Files.size(ruta));
			System.out.printf("Ruta: %s%n", ruta);
			System.out.printf("Ruta absoluta: %s%n",ruta.toAbsolutePath());
			if (Files.isDirectory(ruta)) {
				System.out.printf("%nContenido del directorio:%n");
				
				//Objeto para iterar en el contenido de un directorio
				DirectoryStream<Path> flujoDirectorio=Files.newDirectoryStream(ruta);
				
				for (Path p: flujoDirectorio) {
					System.out.println(p);
				}
			}
		}
		else {
			System.out.printf("%s no exite%n", ruta);
		}
	}
}
