import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class datos {

	/**
	 * cat u.data | cut -f1,2,3 | tr "\\t" ","
	 * @throws IOException 
	 * id usuario, id pelicula, puntuacion y tiempo.
	 * id usuario, id asignatura, puntuacion y tiempo
	 */
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("datos/u.data"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("datos/movies.csv"));
		
		String line;
		while((line = br.readLine()) != null) {
			String[] values = line.split("\\t", -1);
			bw.write(values[0] + "," + values[1] + "," + values[2] + "\n");
		}
		
		br.close();
		bw.close();

	}

}