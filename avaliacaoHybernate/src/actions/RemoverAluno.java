package actions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.AlunoModel;

public class RemoverAluno {
	public static void main(String[] args) {
		AlunoModel aluno = new AlunoModel();
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
		
		EntityManager manager = factory.createEntityManager();
		
		aluno.setId(1L);
		aluno = manager.find(AlunoModel.class, 1L);
		
		manager.getTransaction().begin();
		manager.remove(aluno);
		manager.getTransaction().commit();
		
		System.out.println("Aluno Excluido!");
	}
}