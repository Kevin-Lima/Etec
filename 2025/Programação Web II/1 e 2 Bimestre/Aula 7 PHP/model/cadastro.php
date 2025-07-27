<?php
require_once("banco.php");

class Cadastro extends Banco{
    private $nome;
    private $telefone;
    private $origem;
    private $data_contato;
    private $observacao;

    public function setNome($string){
        $this->nome = $sring;
    }

    public function setTelefone($string){
        $this->telefone = $sring;
    }

    public function setOrigem($string){
        $this->origem = $sring;
    }

    public function setData_contato($string){
        $this->data_contato = $sring;
    }

    public function setObservacao($string){
        $this->observacao = $sring;
    }

    public function getNome($string){
        return $this->nome;
    }

    public function getTelefone($string){
        return $this->telefone;
    }

    public function getOrigem($string){
        return $this->origem;
    }

    public function getData_contato($string){
        return $this->data_contato;
    }

    public function getObservacao($string){
        return $this->observacao;
    }

    public function incluir(){
        return $this->setAgendamentos($this->getNome(),$this->getTelefone(), $this->getOrigem(), $this->getData_contato(), $this->getObservacao());
    }
}
?>