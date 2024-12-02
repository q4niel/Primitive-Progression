import os

def isDirEmpty(dir:str) -> bool:
    return len(os.listdir(dir)) == 0