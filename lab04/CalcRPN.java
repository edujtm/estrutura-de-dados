import java.io.*;

public class CalcRPN {

	// --- Atributos ---
    
    private class Operacao {
        
        private char code;
        private Double a, b;
        
        public Operacao(char code , Double a, Double b) {
            this.code = code;
            this.a = a;
            this.b = b;
        }
        
        public Operacao(Double a) {
        	this.code = 'e';
            this.a = a;
        }

        @Override
        public String toString() {
        	if (this.code == 'e') {
        		return Double.toString(a);
        	} else {
        		return Character.toString(this.code);
        	}
        }
    }
    
    private Pilha<Double> aPilha;
    private Pilha<Operacao> hist;
    
    // --- Construtor ---

    public CalcRPN() {
    	try {
        	aPilha = new Pilha<>();
       		hist = new Pilha<>();
    	} catch (Exception e) {
	        throw new Error("a ser completado");
	    }
    }
    
    // --- Métodos ---

    public void mais() {
        try {
            Double op1 = aPilha.desempilha();
            Double op2 = aPilha.desempilha();
            Operacao op = new Operacao('+', op2, op1);
            hist.empilha(op);
            Double resultado = op1 + op2;
            aPilha.empilha(resultado);
        } catch (Error e) {
            throw new Error("Erro ao fazer operacao de soma");
        }
    }
    
    public void menos() {
        try {
            Double op1 = aPilha.desempilha();
            Double op2 = aPilha.desempilha();
            Operacao op = new Operacao('-', op2, op1);
            hist.empilha(op);
            Double resultado = op2 - op1;
            aPilha.empilha(resultado);
        } catch (Error e) {
            throw new Error("Erro ao fazer operacao de subtracao");
        }
    }
    
    public void vezes() {
        try {
            Double op1 = aPilha.desempilha();
            Double op2 = aPilha.desempilha();
            Operacao op = new Operacao('*', op2, op1);
            hist.empilha(op);
            Double resultado = op1 * op2;
            aPilha.empilha(resultado);
        } catch (Error e) {
            throw new Error("Erro ao fazer operacao de multiplicacao+");
        }
    }
    
    public void dividido() {
    	try {
    		Double op1 = aPilha.desempilha();
    		Double op2 = aPilha.desempilha();
    		Operacao op = new Operacao('/', op2, op1);
    		hist.empilha(op);
    		Double resultado = op2 / op1;
    		aPilha.empilha(resultado);
    	} catch (Error e) {
        	throw new Error("Erro ao fazer operacao de divisao");
        }
    }
    
    public Double resultado() {
    	try {
    		return aPilha.topo();
    	} catch (Error e) {
        	throw new Error("a pilha está vazia");
    	}
    }

    public void cancela() {
    	Operacao ultima = hist.desempilha();
    	switch (ultima.code) {
    		case 'e':
    			aPilha.desempilha();
    			break;
    		case '+':
    			aPilha.desempilha();
    			aPilha.empilha(ultima.a);
    			aPilha.empilha(ultima.b);
    			break;
    		case '-':
    			aPilha.desempilha();
    			aPilha.empilha(ultima.a);
    			aPilha.empilha(ultima.b);
    			break;
    		case '*':
    			aPilha.desempilha();
    			aPilha.empilha(ultima.a);
    			aPilha.empilha(ultima.b);
    			break;
    		case '/':
    			aPilha.desempilha();
    			aPilha.empilha(ultima.a);
    			aPilha.empilha(ultima.b);
    			break;
    		}
    }
    
    public void exec(String cmd) {
    	try {
    		Double valor = Double.parseDouble(cmd);
    		Operacao op = new Operacao(valor);
    		hist.empilha(op);
    		aPilha.empilha(valor);
    	} catch (NumberFormatException e) {
    		switch (cmd) {
    			case "+":
    				mais();
    				break;
    			case "-":
    				menos();
    				break;
    			case "*":
    				vezes();
    				break;
    			case "/":
    				dividido();
    				break;
    			case "clear":
    				aPilha.reinicialize();
    				hist.reinicialize();
    				break;
    			case "hist":
    				System.out.println("Historico = " + hist);
    				break;
    			case "undo":
    				cancela();
    				System.out.println("Historico = " + hist);
    				break;
    			default:
    				throw new Error("A operacao nao é suportada pelo programa");
    		}
    	} catch (NullPointerException e) {
    		throw new Error("A string passada não foi inicializada (null)");
    	} 
    }

    // --- Testes ---

    static void interfaceUsuario() throws IOException {
		CalcRPN calc = new CalcRPN();
		String line;
		BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));
		while((line = reader.readLine()) != null) {
			if (line.isEmpty()) {
				continue;
			} else if (line.equals("quit")) {
				break;
			}
			for (String s : line.split(" ")) { 
				calc.exec(s);
			}
			System.out.println("Pilha = " + calc.aPilha.toStringInverse());
		}

		System.out.println("Até logo");
	}

    private static void test() {
		CalcRPN calc = new CalcRPN() ;
		System.out.print("3 2 + = ");
		calc.aPilha.empilha(3.0);
		calc.aPilha.empilha(2.0);
		calc.mais();
		System.out.println(calc.resultado());
		calc = new CalcRPN();
		System.out.print("3 2 - = ");
		calc.aPilha.empilha(3.0);
		calc.aPilha.empilha(2.0);
		calc.menos();
		System.out.println(calc.resultado());
		calc = new CalcRPN();
		System.out.print("3 2 * = ");
		calc.aPilha.empilha(3.0);
		calc.aPilha.empilha(2.0);
		calc.vezes();
		System.out.println(calc.resultado());calc = new CalcRPN();
		System.out.print("3 2 / = ");
		calc.aPilha.empilha(3.0);
		calc.aPilha.empilha(2.0);
		calc.dividido();
		System.out.println(calc.resultado());
		calc = new CalcRPN();
		System.out.print("1 2 + 3 4 - / 10 3 - * = ");
		calc.aPilha.empilha(1.0);
		calc.aPilha.empilha(2.0);
		calc.mais();
		calc.aPilha.empilha(3.0);
		calc.aPilha.empilha(4.0);
		calc.menos();
		calc.dividido();
		calc.aPilha.empilha(10.0);
		calc.aPilha.empilha(3.0);
		calc.menos();
		calc.vezes();
		System.out.println(calc.resultado());
	}

	public static void testeOperacao() {
		Operacao[] op = new Operacao[9];
		op[0] = new Operacao(16.0);
		op[1] = new Operacao(8.0);
		op[2] = new Operacao(4.0);
		op[3] = new Operacao(2.0);
		op[4] = new Operacao(1.0);
		op[5] = new Operacao('+', 2.0, 1.0);
		op[6] = new Operacao('-', 4.0, 3.0);
		op[7] = new Operacao('*', 8.0, 1.0);
		op[8] = new Operacao('/', 16.0, 8.0);
		for (int i=0; i<op.length; i++)
			System.out.print(op[i] + " ");
		System.out.println();
	}

	public static void main (String[] args) throws IOException {
		interfaceUsuario();
	}
}