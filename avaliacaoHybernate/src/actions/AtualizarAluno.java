package actions;

import java.util.Calendar;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.AlunoModel;

public class AtualizarAluno {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		AlunoModel aluno = new AlunoModel();
		
		System.out.println("Informe o id:");
		Long id = scan.nextLong();
		scan.nextLine();
		aluno.setId(id);
		
		System.out.println("Nome: ");
		String nome = scan.nextLine();
		aluno.setNome(nome);
		
		System.out.println("Email: ");
		String email = scan.nextLine();
		aluno.setEmail(email);
		
		System.out.println("CPF: ");
		String cpf = scan.nextLine();
		aluno.setCpf(cpf);
		
		System.out.println("Data Nascimento: ");
		aluno.setDataNascimento(Calendar.getInstance());
		
		System.out.println("Naturalidade: ");
		String naturalidade = scan.nextLine();
		aluno.setCpf(cpf);
		
		System.out.println("Endereço: ");
		String endereco = scan.nextLine();
		aluno.setEndereco(endereco);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
		
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		manager.merge(aluno);
		
		manager.getTransaction().commit();
		
		System.out.println("Aluno atualizado, ID: " + aluno.getId());
		
		manager.close();
		factory.close();
		
	}
}
