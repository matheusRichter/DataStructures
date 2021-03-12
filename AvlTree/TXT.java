import java.io.*;
import java.util.*;

public class TXT {
    FileReader file; // classe do java que lê um arquivo

    // construtor da classe TXT
    public TXT(String path) throws FileNotFoundException {
        this.file = new FileReader(path);
    }

    // função que lê o arquivo
    public String read() throws IOException {
        String texto = ""; // variavel que recebe o texto do arquivo
        int i;
        while ((i=file.read()) != -1)
            texto += ((char) i);
        return texto;
    }
}