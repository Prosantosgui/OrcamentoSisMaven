package br.com.mirante.orcamentosis;

import java.time.LocalDateTime;

public class Conta {
	private float saldo;
	String numero;
	String agencia;
	String hashSenha;
	LocalDateTime dataAbertura;
	
	private float getSaldo() {
		return saldo;
	}
	private void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	private String getNumero() {
		return numero;
	}
	private void setNumero(String numero) {
		this.numero = numero;
	}
	private String getAgencia() {
		return agencia;
	}
	private void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	private String getHashSenha() {
		return hashSenha;
	}
	private void setHashSenha(String hashSenha) {
		this.hashSenha = hashSenha;
	}
	private LocalDateTime getDataAbertura() {
		return dataAbertura;
	}
	private void setDataAbertura(LocalDateTime dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	
	public Conta(String numero, String agencia) {
		this.numero = numero;
		this.agencia = agencia;
		this.dataAbertura = LocalDateTime.now();
	}
	

}

