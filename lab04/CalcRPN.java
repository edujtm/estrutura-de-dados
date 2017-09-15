import java.io.*;

public class CalcRPN {
    
    private class Operacao {
        
        private char code;
        private Double a, b;
        
        public Operacao(char code , Double a, Double b) {
            this.code = code;
            this.a = a;
            this.b = b;
        }
        
        public Operacao(Double a) {
            this.a = a;
        }
    }
    
    private Pilha<Double> aPilha;
    private Pilha<Operacao> hist;
    
    public CalcRPN() throws Error {
        aPilha = new Pilha<>();
        hist = new Pilha<>();
        throw new Error("a ser completado");
    }
    
    public void mais() throws Error {
        try {
            op1 = aPilha.desempilha();
            op2 = aPilha.desempilha();
            Double resultado = op1 + op2;
            aPilha.empilha(resultado);
        } catch (Error e) {
            throw new Error("Erro ao fazer operacao de soma");
        }
    }
    
    public void menos() throws Error {
        try {
            op1 = aPilha.desempilha();
            op2 = aPilha.desempilha();
            Double resultado = op2 - op1;
            aPilha.empilha(resultado);
        } catch (Error e) {
            throw new Error("Erro ao fazer operacao de subtracao");
        }
    }
    
    public void vezes() throws Error {
        try {
            op1 = aPilha.desempilha();
            op2 = aPilha.desempilha();
            Double resultado = op1 * op2;
            aPilha.empilha(resultado);
        } catch (Error e) {
            throw new Error("Erro ao fazer operacao de multiplicacao+");
        }
    }
    
    public void dividido() {
        throw new Error("a ser completado");
    }
    
    public Double resultado() {
        throw new Error("a ser completado");
    }
    
    public void exec(String cmd) {
        throw new Error("a ser completado");
    }
}