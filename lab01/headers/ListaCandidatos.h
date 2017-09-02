//
// Created by eduardo on 28/07/17.
//

#ifndef LABESTRUTURASDADOS_LISTACANDIDATOS_H
#define LABESTRUTURASDADOS_LISTACANDIDATOS_H


#include "candidato.h"
#include "NoCandidato.h"
#include <fstream>
#include <iostream>

class ListaCandidatos {

public:
    NoCandidato * head;
    int size;

    ListaCandidatos() : head {nullptr}, size { 0 } {}

    ListaCandidatos(const std::string & filename) : head{nullptr}, size{0} {
        std::ifstream file(filename);

        std::string dados;
        std::getline(file, dados);
        std::cout << "Criacao da lista de candidatos " << dados << std::endl;
        while(std::getline(file, dados)) {
            Candidato * candidato = new Candidato(dados);
            this->adicioneComoHead(*candidato);
        }
    }

    void concatena(ListaCandidatos & l) {
        NoCandidato * it = head;
        if (this->head == nullptr) {
            this->head = l.head;
            return;
        }
        while (it->next != nullptr) {
            it = it->next;
        }
        it->next = l.head;
        this->size += l.size;
    }

    void filtrarCandidatos(int nota) {
        NoCandidato *  it = head;
        while (it != nullptr) {
            if (it->conteudo->nota < nota) {
                this->remover(it->conteudo->nome, it->conteudo->sobrenome);
            }
            it = it->next;
        }

    }

    bool remover(std::string nome, std::string sobrenome){
        NoCandidato * cand = head, * itemAchado;
        if (head == nullptr) {
            return false;
        }

        if (cand->conteudo->igual(nome, sobrenome)) {
            head = cand->next;
            delete cand;
            size--;
            return true;
        }

        while (cand->next != nullptr) {
            if (cand->next->conteudo->igual(nome, sobrenome)) {
                itemAchado = cand->next;
                cand->next = cand->next->next;
                delete itemAchado;
                size--;
                return true;
            }
            cand = cand->next;
        }
        return false;
    }

    void adicioneComoHead(Candidato & c) {
        NoCandidato * aux = new NoCandidato(c, head);
        head = aux;
        size++;
    }

    bool estaVazia() {
        return head == nullptr;
    }

    int tamanho() const {
        return size;
    }

    std::string toString() {
        if (head != nullptr) {
           return head->toString();
        } else {
            return "";
        }
    }


};


#endif //LABESTRUTURASDADOS_LISTACANDIDATOS_H
