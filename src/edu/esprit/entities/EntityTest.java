package edu.esprit.entities;

public class EntityTest {
	
	private int id;
	
	public EntityTest(int id) {
		super();
		this.id= id;
	}
	
	public EntityTest() {}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "EntityTest [id=" + id + "]";
	}

	
	
	
}

}
