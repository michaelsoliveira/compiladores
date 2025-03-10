package lexico.src;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CLexicalAnalyzer {
    public static void main(String[] args) throws IOException {
        LexicalAnalyzer lexicalAnalizer = new LexicalAnalyzer(new FileReader(new File("").getAbsolutePath() + "\\lexico\\src\\program.c"));

        CToken token;

        while ((token = lexicalAnalizer.yylex()) != null) {
            System.out.println("<" + token.name + ", " + token.value + "> (" + token.line + " - " + token.column + ")");
        }
    }
}
