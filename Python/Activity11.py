fruits = { 
    "apple":10,
    "banana":20,
    "grapes":40,
    "mango":40
}

fruit_to_be_checked = input ("name of the fruit:").lower()
if(fruit_to_be_checked in fruits):
    print("fruit is available")
else:
    print("fruit is not available")