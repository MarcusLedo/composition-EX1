package entities;
import entities.enums.WorkerLevel;
import java.util.List;
import java.util.ArrayList;

public class Worker {
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	private Department department;
	private List<Contract> contract = new ArrayList<>();
	
	public Worker() {
		
	}

	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Contract> getContract() {
		return contract;
	}
	
	public void addContract(Contract contract) {
		this.contract.add(contract);
	}
	
	public double income(int year, int month) {
		double income = baseSalary;
		for(Contract x : contract) 
			if(x.getDate().getYear() == year && x.getDate().getMonthValue() == month) 
				income += x.totalValue();
			
		return income;
	}
}
