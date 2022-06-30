package actions;

import java.util.Calendar;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.AlunoModel;

public class BuscarPorId {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Calendar calend = Calendar.getInstance();
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
		
		EntityManager manager = factory.createEntityManager();
		
		System.out.println("Informe o id: ");
		Long id = scan.nextLong();
		
		AlunoModel aluno = manager.find(AlunoModel.class, id);
		
		System.out.println(aluno.getId() + ", " + aluno.getNome() + ", " + aluno.getCpf() + ", " + aluno.getEmail() + ", " + aluno.getDataNascimento() + ", " + aluno.getNaturalidade() + ", " + aluno.getEndereco());
		
		manager.close();		
	}
}