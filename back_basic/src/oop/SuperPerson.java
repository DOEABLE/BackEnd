package oop;

import java.util.Objects;

public class SuperPerson {
		public static void main(String[] args) {
				Person hong = new Person("Hong", 32);
				System.out.println(hong);
				Person kim = new Person("dohee", 29);
				System.out.println(kim);
		}
}

class Person {
		private final String name;//final은 더이상 상속할 수 없는 const같은 것.
		private int age;

		public Person(String name, int age) {
				this.name = name;
				this.age = age;
		}

		//make getter(읽기) setter
		public String getName() {
				return name;
		}

		public int getAge() {
				return age;
		}

		public void setAge(int age) {
				this.age = age;
		}

		@Override
		public boolean equals(Object obj) {
				if (this == obj)
						return true;
				if (obj == null || getClass() != obj.getClass())
						return false;
				Person person = (Person)obj;
				return age == person.age && Objects.equals(name, person.name);
		}

		@Override
		public int hashCode() {
				return Objects.hash(name, age);
		}

		@Override
		public String toString() {
				return "Person{name='" + name + '\'' + ", age=" + age + '}';
		}

}
