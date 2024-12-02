import os

def upper(dir:str, index:int) -> str:
    for i in range(0, index):
        dir = os.path.dirname(dir)
    return dir