package com.school.sptech;

public class Biblioteca {

    private String nome;
    private Double multaDiaria;
    private Integer qtdLivros;
    private Boolean ativa;

    public Biblioteca(String nome, Double multaDiaria) {
        setNome(nome);
        this.multaDiaria = multaDiaria;
        this.qtdLivros = 0;
        this.ativa = true;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getMultaDiaria(){
        return multaDiaria;
    }

    public Boolean getAtiva() {
        return ativa;
    }

    public Integer getQtdLivros() {
        return qtdLivros;
    }

    public void registrarLivro(Integer quantidade){
        if (quantidade != null && quantidade > 0 && getAtiva() == true) {
            this.qtdLivros = quantidade;
        }
    }

    public Integer emprestar(Integer quantidade) {
        if (quantidade != null && getAtiva() == true && quantidade > 0
                && quantidade <= getQtdLivros()) {
            Integer livros = getQtdLivros();
            this.qtdLivros = livros - quantidade;
        } else {
            return null;
        }
        return quantidade;
    }

    public Integer devolver(Integer quantidade){
        if (quantidade != null && quantidade > 0
                && getAtiva() == true) {
            Integer livros = getQtdLivros();
            this.qtdLivros = livros + quantidade;
        } else {
            return null;
        }
        return quantidade;
    }

    public Integer desativar() {
        if(getAtiva() == false) {
            return null;
        } else {
            this.ativa = false;
            int qnt = getQtdLivros();
            this.qtdLivros = 0;
            return qnt;
        }
    }

    public void transferir(Biblioteca destino, Integer quantidade) {
        if(getAtiva() == true && destino.getAtiva() == true
        && quantidade > 0 && quantidade <= getQtdLivros()) {
            Integer livros = destino.getQtdLivros();
            Integer livrosProprios = getQtdLivros();
            destino.qtdLivros = livros + quantidade;
            this.qtdLivros = livrosProprios - quantidade;
        }
    }

    public Boolean reajustarMulta(Double percentual){
        if(percentual != null && percentual > 0) {
            double multa = getMultaDiaria();
            this.multaDiaria = multa + (multa * percentual);
            return true;
        } else {
            return false;
        }
    }

}
