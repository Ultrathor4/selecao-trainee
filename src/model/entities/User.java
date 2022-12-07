package model.entities;

public class User {

	private Integer id, cpf;
	private String nomeUsuario, email, senha;
	
	public User(String nomeUsuario, String senha) {
		this.nomeUsuario = nomeUsuario;
		this.senha = senha;
	}
	
	public User(Integer cpf, String nomeUsuario, String email, String senha) {
		this.cpf = cpf;
		this.nomeUsuario = nomeUsuario;
		this.email = email;
		this.senha = senha;
	}
	
	public User(Integer id, Integer cpf, String nomeUsuario, String email, String senha) {
		this.id = id;
		this.cpf = cpf;
		this.nomeUsuario = nomeUsuario;
		this.email = email;
		this.senha = senha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
		

}
