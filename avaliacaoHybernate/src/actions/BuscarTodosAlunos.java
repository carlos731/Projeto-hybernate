package actions;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.AlunoModel;

public class BuscarTodosAlunos {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
		
		EntityManager manager = factory.createEntityManager();
		
		String sql = "SELECT u FROM alunos";
		
		Query query = manager.createQuery(sql);
		
		//query.setParameter();
		
		List<AlunoModel> listaAlunos = query.getResultList();
		
		for(AlunoModel t : listaAlunos) {
			System.out.println(t.getNome() + ", " + t.getEmail() + ", " + t.getCpf() + ", " + t.getDataNascimento() + ", " + t.getNaturalidade() + ", " + t.getEndereco());
		}
		
		manager.close();
		factory.close();
	}
}
