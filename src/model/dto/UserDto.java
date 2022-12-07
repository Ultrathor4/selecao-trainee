package model.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import db.DB;
import db.DbException;
import model.dao.UserDao;
import model.entities.User;

public class UserDto implements UserDao {

	private Connection conn;

	public UserDto(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void systemLogin(User objUser) {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement(
					"SELECT nomeusuario, senha FROM usuarioeverymind.usuario WHERE nomeUsuario = ? AND senha = ? ");
			st.setString(1, objUser.getNomeUsuario());
			st.setString(2, objUser.getSenha());
			rs = st.executeQuery();
			if (rs.next()) {
				System.out.println("Login efetuado com sucesso!");
			} else {
				throw new DbException("Usuário ou senha não encontados!");
			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {

		}

	}

	@Override
	public void insertUser(User objUser) {
		PreparedStatement st = null;

		try {

			st = conn.prepareStatement(
					"INSERT INTO usuarioeverymind.usuario (cpf, nomeusuario, email, senha) VALUES (?, ?, ?, ?)");
			st.setInt(1, objUser.getCpf());
			st.setString(2, objUser.getNomeUsuario());
			st.setString(3, objUser.getEmail());
			st.setString(4, objUser.getSenha());

			int rowsAfected = st.executeUpdate();

			if (rowsAfected > 0) {
				System.out.println("Cadastro realizado com sucesso!");
			} else {
				throw new DbException("Não foi possível realizar o cadastro!");
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

}
