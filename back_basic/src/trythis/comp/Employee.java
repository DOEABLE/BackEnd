package trythis.comp;

public class Employee {
		private final int id;
		/**
		 * final 필드: id를 final로 선언하면, 이 필드는 객체가 생성될 때 한 번만 초기화할 수 있으며,
		 *이후에는 값을 변경할 수 없습니다. 이는 id가 변하지 않음을 보장합니다.
		 * 생성자 초기화: id는 생성자에서 초기화되며, 이 값은 생성된 객체의 생애 동안 불변입니다.
		 */

		private final String name;

		private int salary;

		public Employee(int id, String name, int salary) {
				this.id = id;
				this.name = name;
				this.salary = salary;
		}

		public int getId() {
				return id;
		}

		public String getName() {
				return name;
		}

		public int getSalary() {
				return salary;
		}

		public void setSalary(int salary) {
				this.salary = salary;
		}

		public int raiseSalary(int percent) {
				return this.salary * percent;
		}

		public double getAnnualSalary() {
				return this.salary * 12;

		}

		public String toString() {
				return "Employee[id=%d, name = %s, \n salary=%d]의 연봉은 %.0f 월급 인상 분은 %d".formatted(getId(), getName(),
						getSalary(), getAnnualSalary(), raiseSalary((int)(id * 10 * 0.01)));
		}
}
