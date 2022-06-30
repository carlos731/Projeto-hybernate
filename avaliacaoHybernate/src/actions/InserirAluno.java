package actions;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.AlunoModel;

public class InserirAluno {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		
		List<AlunoModel> alunos = new ArrayList<AlunoModel>();
		AlunoModel aluno = new AlunoModel();
		
		System.out.println("Nome: ");
		String nome = scan.nextLine();
		
		System.out.println("Email: ");
		String email = scan.nextLine();
		aluno.setEmail(email);
		
		System.out.println("CPF: ");
		String cpf = scan.nextLine();
		aluno.setCpf(cpf);
		
		System.out.println("Data Nascimento: ");
		
		System.out.println("Ano: ");
		int ano = cal.get(Calendar.YEAR);
		
		System.out.println("Mês: ");
		int mes = cal.get(Calendar.MONTH);
		
		System.out.println("Dia: ");
		int dia =cal.get(Calendar.DAY_OF_MONTH);
		
		System.out.println("Naturalidade: ");
		String naturalidade = scan.nextLine();
		
		System.out.println("Endereço: ");
		String endereco = scan.nextLine();
		
		aluno.setNome("Carlos");
		aluno.setEmail("carlos@gmail.com");
		aluno.setCpf("06369408700");
		aluno.setDataNascimento(Calendar.getInstance());
		aluno.setNaturalidade("Brasileira");
		aluno.setEndereco("Rua 5");
		
		alunos.add(aluno);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
		
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(aluno);
		manager.getTransaction().commit();
		
		System.out.println("Tarefa inserida, ID: "+ aluno.getId());
		
		manager.close();
		factory.close();
	}
}