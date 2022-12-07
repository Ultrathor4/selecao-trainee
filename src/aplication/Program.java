package aplication;

import java.util.Scanner;
import db.DB;
import model.dao.DaoFactory;
import model.dao.UserDao;
import model.entities.User;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Digite 1 para efetuar login no sistema ou 2 para se cadastrar:");
		int opcao = sc.nextInt();

		if (opcao == 1) {

			System.out.println("ENTRE COM OS DADOS PARA EFETUAR LOGIN");
			System.out.print("Nome de usuário:  ");
			String nomeUsuario = sc.next();
			System.out.print("Senha:  ");
			String senha = sc.next();

			User objUser = new User(nomeUsuario, senha);
			UserDao objUserDao = DaoFactory.createUserDao();
			objUserDao.systemLogin(objUser);
			DB.closeConnection();

		}

		if (opcao == 2) {
			System.out.println("CADASTRO: ");
			System.out.print("Insira um cpf:  ");
			Integer cpf = sc.nextInt();
			System.out.print("Insira um nome de usuário:  ");
			String nomeUsuario = sc.next();
			System.out.print("Insira um e-mail:  ");
			String email = sc.next();
			System.out.print("Insira uma senha:  ");
			String senha = sc.next();

			User objUser = new User(cpf, nomeUsuario, email, senha);
			UserDao objUserDao = DaoFactory.createUserDao();
			objUserDao.insertUser(objUser);
			DB.closeConnection();

		}

		sc.close();

	}
}
