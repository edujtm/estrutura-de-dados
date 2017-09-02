#include <iostream>
#include "headers/ListaCandidatos.h"

using namespace std;

int main(){

  ListaCandidatos* lista = new ListaCandidatos();
  cout << "lista de " << lista->tamanho() << " candidatos: " << lista->toString()<< endl;
  Candidato fonfec("FONFEC Sophie 13");
  lista->adicioneComoHead(fonfec);
  cout << "lista de " << lista->tamanho() << " candidatos: " << lista->toString()<< endl;
  Candidato hady("HADY Jacques 7");
  lista->adicioneComoHead(hady);
  cout << "lista de " << lista->tamanho() << " candidatos: " << lista->toString()<< endl;

  delete lista;
}

