player1 = input("Enter player1")
player2 = input("enter player2")
player1_choice = input("enter the player1 choice")
player2_choice = input("enter the player2 choice")
if player1_choice == player2_choice:
    print("Tie")
elif player1_choice =='rock':
      if player2_choice == 'scissors':
         print("rock win")
      else:
          print("paper win")
elif player1_choice =='scissors':
      if player2_choice == 'paper':
         print("scissors win")
      else:
          print("rocks win")
elif player1_choice == 'paper':
      if player2_choice == 'rock':
         print("paper win")
      else :
         print("scissors win")
else :
    print("invalid input")


