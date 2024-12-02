import os
from .isDirEmpty import isDirEmpty

def cleanDirTree(tree:str) -> None:
    for root, dirs, files in os.walk(tree):
        for dir in dirs:
            if isDirEmpty(f"{root}/{dir}"):
                os.rmdir(f"{root}/{dir}")
    return