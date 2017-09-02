#include <iostream>
#include "headers/ListaCandidatos.h"


using namespace std;

int main(){

  ListaCandidatos* lista = new ListaCandidatos();
  Candidato fonfec("FONFEC Sophie 13");
  lista->adicioneComoHead(fonfec);
  cout << "Numero de nos da lista: " << lista->tamanho() << endl;
  Candidato hady("HADY Jacques 7");
  lista->adicioneComoHead(hady);
  Candidato zappa("ZAPPA Frank 2");
  lista->adicioneComoHead(zappa);
  cout << "Numero de nos da lista: " << lista->tamanho() << endl;

  delete lista;
}
