Bank.class: Bank.java Account.class User.class Admin.class
	javac -g Bank.java

Account.class: Account.java
	javac -g Account.java

User.class: User.java
	javac -g User.java

Admin.class: Admin.java
	javac -g Admin.java

clean:
	rm *.class
run: Bank.class
	java Bank

runUser: User.class
	java User

runAccount: Account.class
	java Account

runAdmin: Admin.class
	java Admin

debugUser: User.class
	jdb User
debugAccount: Account.class
	jdb Account
debugAdmin: Admin.class
	jdb Admin

debug: Bank.class
	jdb Bank

