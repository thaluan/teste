package model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class UtilJPA {

	private static EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("banco");

	private UtilJPA() {
		super();
	}
	
	public static EntityManager obterEntityManager()
	{
		return fabrica.createEntityManager();
	}

}
