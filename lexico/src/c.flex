package lexico.src;

import java_cup.runtime.*;

%%

%{
    private CToken createToken(String name, String value) {
        return new CToken(name, value, yyline, yycolumn);
    }
%}

%public
%class LexicalAnalyzer
%type CToken
%line
%column

inteiro = 0|[0-9][0-9]*
brancos = [\n | \t | \r]
ID = [_|a-z|A-Z][a-z|A-Z|0-9|_]*
SOMA = "+"
SUBTRACAO = "-"
MULTIPLICACAO = "*"
DIVISAO = "/"
IGUAL = "="
smatches = ["\\s*\\w*\\(\"\\w*\"\\)\\s*"]

program = "program"

%%

{inteiro}   { return createToken("inteiro", yytext()); }
{brancos}   {/**/}
{ID}        { return createToken("ID", yytext()); }
{SOMA}        { return createToken("SOMA", yytext()); }
{SUBTRACAO}        { return createToken("SUBTRACAO", yytext()); }
{MULTIPLICACAO}        { return createToken("MULTIPLICACAO", yytext()); }
{DIVISAO}        { return createToken("DIVISAO", yytext()); }
{IGUAL}        { return createToken("IGUAL", yytext()); }
"scanf"         { return createToken("scanf", yytext()); }
"%"         { return createToken("porcentagem", ""); }
"&"         { return createToken("ecomercial", ""); }
";"         { return createToken("pontoevirgula", ""); }
","         { return createToken("virgula", ""); }
"("         { return createToken("parenteseesquerdo", ""); }
")"         { return createToken("parentesedireito", ""); }
"{"         { return createToken("chaveesquerda", ""); }
"}"         { return createToken("chavedireita", ""); }
":"         { return createToken("doispontos", ""); }
{smatches}  { /**/ }
{program}   { return createToken(yytext(), ""); }
. { throw new RuntimeException("Caractere inválido " + yytext() + " na linha " + yyline + ", na coluna " + yycolumn); }