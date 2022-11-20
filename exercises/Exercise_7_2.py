import math

last = None

def eval_loop():
    global last
    user = input() 
    
    if user == "done":
        return last
    
    print(eval(user))
    last = user
    eval_loop()


eval_loop()