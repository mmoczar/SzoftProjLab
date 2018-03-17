import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Szkeleton {
	public static int melyseg = 0;
	
	public static String kiir(String tipus, String osztaly, String fuggveny) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if (tipus == ">" || tipus == "?") melyseg++;
		System.out.print(tipus);
		for (int i=0; i<melyseg; i++)
			System.out.print("   ");
		if (tipus == ">") System.out.print("->");
		if (tipus == "<") System.out.print("<-");
		if (tipus != "?") System.out.println("["+osztaly+"]."+fuggveny);
		if (tipus == "<") melyseg--;
		if (tipus == "?")
			return br.readLine();
		else return "";
	}
}
