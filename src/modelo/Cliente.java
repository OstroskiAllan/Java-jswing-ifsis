/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;

/**
Entidade: cliente
id int PK AI
nome varchar(100) not null
tipocliente int(1) not null (Pessoa física ou Pessoa Jurídica)
cpfcnpj varchar(15) not null
telefone varchar(20)
email varchar(100)
observacao text
datacadastro datetime default current_timestamp
 * @author Ostroski
 */
public class Cliente {
    private Integer id;
    private String nome;
    private Integer tipoCliente;
    private String cpfCnpj;
    private String telefone;
    private String email;
    private String observacao;
    private Date dataCadastro;

    public Cliente() {
    }

    public Cliente(Integer id, String nome, Integer TipoCliente, String cpfCnpj, String telefone, String email, String observacao, Date dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.tipoCliente = TipoCliente;
        this.cpfCnpj = cpfCnpj;
        this.telefone = telefone;
        this.email = email;
        this.observacao = observacao;
        this.dataCadastro = dataCadastro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(Integer tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    
    
}
