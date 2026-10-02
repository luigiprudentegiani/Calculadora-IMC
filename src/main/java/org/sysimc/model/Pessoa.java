package org.sysimc.model;

public class Pessoa {
    private String nome;
    private float peso;
    private float altura;
    private float imc;

    public Pessoa(String nome, float peso, float altura, float imc) {
        this.nome = nome;
        this.peso = peso;
        this.altura = altura;
        this.imc = imc;
    }

    public Pessoa() {
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getImc() {
        return imc;
    }

    public void setImc(float imc) {
        this.imc = imc;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
    public float calcularIMC(){
        this.imc = this.peso / (this.altura * this.altura);
        return this.imc;
    }

    public String classificacaoIMC() {
        if (this.imc < 18.5) {
            return "Abaixo do peso!";
        } else if (this.imc >= 18.5 && this.imc < 25) {
            return "Peso normal!";
        } else if (this.imc >= 25 && this.imc < 29.9) {
            return "Sobrepeso!";
        } else if (this.imc >= 30 && this.imc < 34.9) {
            return "Obesidade Grau 1!";
        } else if (this.imc >= 35 && this.imc < 39.9) {
            return "Obesidade Grau 2!";
        } else {
            return "Obesidade Grau 3!";
        }
    }
}

