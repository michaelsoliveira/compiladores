package src;

import java.io.File;

public class GeneratorC {
    public static void main(String[] args) {
        File sourceCode = new File(new File("").getAbsolutePath() + "\\c.lex");
        try {
            jflex.Main.generate(new String[] { sourceCode.getPath() });
        } catch (Exception e) {
            System.err.println("Erro ao gerar analisador léxico com JFlex: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
