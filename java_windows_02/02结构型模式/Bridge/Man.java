public class Man extends Person{
	public Man(){
		setType("����");
	}
	
	public void dress(){
		Clothing clothing = getClothing();
		clothing.personDressCloth(this);
	}
	
	
	
	
}