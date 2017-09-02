//
// Created by eduardo on 28/07/17.
//

#ifndef LABESTRUTURASDADOS_CANDIDATO_H
#define LABESTRUTURASDADOS_CANDIDATO_H

#include <string>
#include <sstream>
#include <utility>


class Candidato {

public:
    std::string nome;
    std::string sobrenome;
    double nota;

    // Construtor com tres parametros: n = nome do candidato, s = sobrenome, nota = nota do candidato
    Candidato(std::string n, std::string s, const double nota)
            : nome {std::move(n)}, sobrenome {std::move(s)}, nota{ nota } {}

    //Construtor de copia
    Candidato(Candidato & rhs) :
            nome { rhs.nome }, sobrenome { rhs.sobrenome }, nota {rhs.nota} {}


    Candidato(const std::string & linha) {
        std::stringstream stream(linha);
        stream >> sobrenome >> nome >> nota;
    }

    std::string toString() {
        std::stringstream stream;
        stream << sobrenome << " " << nome << " " << nota;
        return stream.str();
    }

    bool igual(const std::string & n, const std::string & s) {
        return nome == n && sobrenome == s;
    }

    bool operator==(Candidato & rhs) {
         return nome == rhs.nome && sobrenome == rhs.sobrenome;
    }
};


#endif //LABESTRUTURASDADOS_CANDIDATO_H

