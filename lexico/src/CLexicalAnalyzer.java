import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CLexicalAnalyzer {
    public static void main(String[] args) throws IOException {
        String path = new File("").getAbsolutePath() + "\\lexico\\src\\program.c";
        LexicalAnalyzer lexer = new LexicalAnalyzer(new FileReader(path));

        // CToken token;

        // while ((token = lexer.yylex()) != null) {
        //     System.out.println("<" + token.name + ", " + token.value + "> (" + token.line + " - " + token.column + ")");
        // }
        Parser parser = new Parser(lexer);
        parser.parse();
    }
}
