# Import the time module for using sleep function
import time

# Prompt the user to insert their card
print("Please insert your CARD")
# Wait for 5 seconds to simulate card processing
time.sleep(5)

# Set the correct PIN and initial balance
password = 1234
balance = 5000

# Ask the user to enter their PIN
print("New user default pin is 1234 ")
pin = int(input("Enter your pin: "))

# Check if the entered PIN is correct
if pin == password:
    # Main ATM operation loop
    while True:
        # Display the menu options
        print("""
1 == Balance
2 == Withdraw balance
3 == Deposit balance
4 == Pin Change
5 == Exit
""")
        try:
            # Get the user's choice
            option = int(input("Please enter your choice: "))
            
            if option == 1:
                # Display current balance
                print(f"Your current balance is {balance}")
                print("============================================================================")
                print("============================================================================")
                print("============================================================================")
                print("============================================================================")
            elif option == 2:
                # Handle withdrawal
                withdraw_amount = int(input("Please enter withdraw amount: "))
                if withdraw_amount <= balance:
                    balance = balance - withdraw_amount
                    print(f"{withdraw_amount} is debited from your account")
                    print(f"Your updated balance is {balance}")
                    print("============================================================================")
                    print("============================================================================")
                    print("============================================================================")
                else:
                    print("Insufficient funds")
                    print("============================================================================")
                    print("============================================================================")
                    print("============================================================================")
            elif option == 3:
                # Handle deposit
                deposit_amount = int(input("Please enter deposit amount: "))
                balance = balance + deposit_amount
                print(f"{deposit_amount} is credited to your account")
                print(f"Your updated balance is {balance}")
                print("============================================================================")
                print("============================================================================")
                print("============================================================================")

            elif option == 4:
                p = int(input("Enter your Current pin: "))
                if p == password:
                    new_pin = int(input("Enter your new pin: "))
                    confirm_pin = int(input("Confirm your new pin: "))
                    if new_pin == confirm_pin:
                        password = new_pin
                        print("Pin changed successfully")
                        print("============================================================================")
                        print("============================================================================")
                        print("============================================================================")



            elif option == 5:
                # Exit the program
                print("Thank you for using our ATM. Goodbye!")
                break
            else:
                # Handle invalid menu options
                print("Invalid option. Please try again.")
        except ValueError:
            # Handle non-integer inputs
            print("Please enter a valid option")
else:
    # Handle incorrect PIN
    print("Wrong pin")
    print("Please try again.")
    exit();