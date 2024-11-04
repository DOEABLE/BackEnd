package trythis;

public class Account {
		private String id;
		private String name;
		private int balance = 0;

		public Account() {

		}

		public Account(String id, String name) {
				this.id = id;
				this.name = name;
		}

		public Account(String id, String name, int balance) {
				this.id = id;
				this.name = name;
				this.balance = balance;
		}

		public String getId() {
				return id;
		}

		public void setId(String id) {
				this.id = id;
		}

		public String getName() {
				return name;
		}

		public void setName(String name) {
				this.name = name;
		}

		public int getBalance() {
				return balance;
		}

		public void setBalance(int balance) {
				this.balance = balance;
		}

		public int deposit(int amount) {
				return this.balance += amount;
		}

		public int withdraw(int amount) {
				if (amount <= this.balance) {
						return this.balance -= amount;
				} else {
						System.out.println("잔액초과.");
						return balance;
				}
		}

		public String toString() {
				return "Account[id=%s,name=%s, balance=%d]".formatted(this.id, this.name, this.balance);
		}
}
