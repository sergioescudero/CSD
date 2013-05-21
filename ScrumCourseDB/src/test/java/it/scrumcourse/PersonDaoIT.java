package it.scrumcourse;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import scrumcourse.dao.PersonDao;
import scrumcourse.entity.Car;
import scrumcourse.entity.Person;

public class PersonDaoIT extends BaseIT {

	private PersonDao dao;

	@Before
	public void setDao() {
		dao = new PersonDao(em);
	}

	@After
	public void limpiarBD() throws Exception{
		
		transactor.perform(new UnitOfWork() {
			@Override
			public void work() throws Exception {
				dao.deleteAll();
			}
		});
	}
	
	@Test
	public void newUserNoTrx() {
		Person p = new Person();
		p.setName("name");
		p.setEmail("mail");
		dao.insert(p);
		dao.insert(p);
		assertEquals(0, dao.count());
	}

	@Test
	public void newUserTrx() {
		em.getTransaction().begin();
		Person p = new Person();
		p.setName("name2");
		p.setEmail("mail2");
		dao.insert(p);
		assertEquals(1, dao.count());
		em.getTransaction().commit();
		assertEquals(1, dao.count());
	}

	@Test
	public void newUserTrxUnitOfWork() throws Exception {
		transactor.perform(new UnitOfWork() {
			@Override
			public void work() throws Exception {
				Person p = new Person();
				p.setName("name3");
				p.setEmail("mail3");
				dao.insert(p);
				assertEquals(1, dao.count());
			}
		});
		assertEquals(1, dao.count());
	}

	@Test
	public void testFind() throws Exception {
		transactor.perform(new UnitOfWork() {
			@Override
			public void work() throws Exception {
				Person.Builder b = new Person.Builder();
				Person p = b.name("name3").email("mail3").build();
				dao.insert(p);
				p = dao.findByEmail("mail3");
				assertEquals("name3", p.getName());
			}
			
		});
		
		transactor.perform(new UnitOfWork() {
			@Override
			public void work() throws Exception {
				Person p = dao.findByEmail("mail3");
				assertEquals("name3", p.getName());
			}
			
		});

	}
	
	@Test
	public void testUpdate() throws Exception{
		transactor.perform(new UnitOfWork(){
			@Override
			public void work() throws Exception{

				Person.Builder b = new Person.Builder();
				Person p = b.name("name3").email("mail3").build();
				dao.insert(p);
				p = dao.findByEmail("mail3");
				p.setName("Pepico");
				dao.update(p);
				p = dao.findByEmail("mail3");
				assertEquals("Pepico", p.getName());
			}
		});
	}
}