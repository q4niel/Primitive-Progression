from typing import List
import os

def makeDirs(parent:str, children:List[str]) -> None:
    for child in children:
        os.makedirs(f"{parent}/{child}", exist_ok = True)
    return