public class Test{

	public static void main(String[] args){
	
		Employer pm = new ProjectManager("��Ŀ����");
		Employer pa = new ProjectAssistant("��Ŀ����");
		Employer programmer1 = new Programmer("����Աһ");
		Employer programmer2 = new Programmer("����Ա��");
		
		pm.add(pa);	// Ϊ��Ŀ���������Ŀ����
		
		pm.add(programmer1);
		pm.add(programmer2);	// Ϊ��Ŀ������ӳ���Ա
		
		
		List ems = pm.getEmployers();
		for(Employer em : ems){
			System.out.println(em.getName());
		}
	}
}