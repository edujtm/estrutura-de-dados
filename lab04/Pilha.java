import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Pilha<X> {

	private LinkedList<X> conteudo;

	public Pilha() {
			conteudo = new LinkedList<>();
	}	
	
	public boolean estaVazia() {
		return conteudo.isEmpty();
	}

	public void empilha(X x) {
		conteudo.add(x);
	}

	public X desempilha() throws Error {
		try {
			return conteudo.removeLast();
		} catch (NoSuchElementException e) {
			throw new Error("A lista esta vazia. Impossivel retornar valor.");
		}
	}

	public X topo() throws Error {
		try {
			return conteudo.getLast();
		} catch (NoSuchElementException e) {
			throw new Error("A lista esta vazia. Impossivel retornar valor.");
		}
	}

	@Override
	public String toString() {
		return conteudo.toString();
	}

	private static void test1() {
		Pilha<Double> aPilha = new Pilha<Double>();
		aPilha.empilha(1.1);
		aPilha.empilha(2.1);
		aPilha.empilha(3.1);
		aPilha.empilha(4.1);
		aPilha.empilha(5.1);
		double valor = 0.0;
		valor = aPilha.topo();
		System.out.println("topo pilha = " + valor);
		valor = aPilha.desempilha();
		System.out.println("topo pilha = " + valor);
		valor = aPilha.desempilha();
		System.out.println("topo pilha = " + valor);
		valor = aPilha.desempilha();
		System.out.println("topo pilha = " + valor);
		valor = aPilha.topo();
		System.out.println("topo pilha = " + valor);
		valor = aPilha.desempilha();
		System.out.println("topo pilha = " + valor);
	}

	private static void test2() {
		Pilha<Double> aPilha = new Pilha<Double>();
		System.out.println(aPilha);
		aPilha.empilha(1.1);
		System.out.println(aPilha);
		aPilha.empilha(2.1);
		System.out.println(aPilha);
		aPilha.empilha(3.1);
		System.out.println(aPilha);
		double valor = 0.0;
		valor = aPilha.desempilha();
		System.out.println("topo pilha = " + valor );
		System.out.println(aPilha);
		valor = aPilha.desempilha();
		System.out.println("topo pilha = " + valor );
		System.out.println(aPilha);
		valor = aPilha.desempilha();
		System.out.println("topo pilha = " + valor );
		System.out.println(aPilha);
	}

	public static void main(String[] args) {
		test2();
	}
}