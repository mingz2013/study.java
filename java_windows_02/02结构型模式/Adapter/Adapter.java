public class Adapter implements Target{
	// ���뱻������
	private Adaptee adaptee;
	
	public Adapter(Adaptee adaptee){
		this.adaptee = adaptee;
	}
	
	public void adapteeMethod(){
		adaptee.adapteeMethod();
	}
	public void adapterMethod(){
		System.out.println("Adapter method");
	}
}

/*
public class Adapter extends Adaptee implements Target{

	public void adapteeMethod(){
		adaptee.adapteeMethod();
	}
	
	public void adapterMethod(){
		System.out.println("Adapter method");
	}
}
*/