class Persion{
	String name;
	int age;
	String address;
	static int i;	// ��̬��Ա����������ֱ������������ 
	Persion(){
	}
	Persion(String name, int age){
		this.name = name;	// ���ﲻ��ʡ��this
		this.age = age;
		System.out.println("���������Ĺ��캯��");
	}
	Persion(String name, int age, String address){
		this(name, age); // ��this������������ʱ��Ӧ���ڵ�һ��
		this.address = address;
		System.out.println("���������Ĺ��캯��");
	}
	void talk(){
		System.out.println("My name is " + name); // this.name ʡ����this
	}
}