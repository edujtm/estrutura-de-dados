//
// Created by eduardo on 28/07/17.
//

#ifndef LABESTRUTURASDADOS_NOCANDIDATO_H
#define LABESTRUTURASDADOS_NOCANDIDATO_H

#include "candidato.h"

class NoCandidato {

public:
    Candidato * conteudo;
    NoCandidato * next;

    NoCandidato(Candidato & c, NoCandidato * n) : conteudo { &c }, next { n } {};

    std::string toString() {
        NoCandidato * aux = this;
        std::stringstream stream;
        stream << "";
        if (conteudo != nullptr) {
            stream << conteudo->toString();
            while (aux->next != nullptr) {
                stream << " -> " << aux->next->conteudo->toString();
                aux = aux->next;
            }
            stream << " -> 0";
        }
        return stream.str();
    }
};


#endif //LABESTRUTURASDADOS_NOCANDIDATO_H
