
public class BankAccount {
	int accountNumber;
	String customerName,transactions = "";
	double interestRate;
	private double balance;
		
	public BankAccount(int accountNumber,String customerName){  
		   this.accountNumber=accountNumber;  
		   this.customerName=customerName;  
		   balance = 0.0;  
		  }  
	
	public void deposit(double amount) {
		balance = balance + amount;
		System.out.println("======================");
		System.out.println("Request To Deposit");
		System.out.printf("Account : %d\n",accountNumber);
		System.out.printf("Name : %s\n",customerName);
		System.out.printf("Deposit : %.2f\n",amount);
		System.out.printf("Balance : %.2f\n",balance);
		System.out.println("======================");
		transactions = transactions + "D";
	}
	
	public void withdraw(double amount){
		if(amount<=balance) {
			balance = balance - amount;
			System.out.println("======================");
			System.out.println("Request To Withdraw");
			System.out.printf("Account : %d\n",accountNumber);
			System.out.printf("Name : %s\n",customerName);
			System.out.printf("Withdraw : %.2f\n",amount);
			System.out.printf("Balance : %.2f\n",balance);
			System.out.println("======================");
			transactions = transactions + "W";
		}
		else {
			System.out.println("======================");
			System.out.println("Request To Withdraw");
			System.out.println("Not enough balance");
			System.out.printf("Account : %d\n",accountNumber);
			System.out.printf("Name : %s\n",customerName);
			System.out.printf("Balance : %.2f\n",balance);
			System.out.println("======================");
			transactions = transactions + "W";
		}
	}
	
	public double getBalance() {
		return balance;
	}
	
	public String getTransactions() {
		return transactions;
	}
	
	public void addInterest(double InterestRate){
		InterestRate = InterestRate*0.85;
		balance = balance+((balance*InterestRate*90)/36500);
		System.out.println("======================");
		System.out.println("Show Balance with Interest Rate");
		System.out.printf("Account : %d\n",accountNumber);
		System.out.printf("Name : %s\n",customerName);
		System.out.printf("Interest Rate : %.2f%% \n",InterestRate);
		System.out.printf("Balance : %.2f\n",balance);
		System.out.println("======================");
	}	
}
