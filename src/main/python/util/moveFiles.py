from typing import List
import shutil

def moveFiles(srcDir:str, dstDir:str, files:List[str]) -> None:
    for file in files:
        shutil.move(f"{srcDir}/{file}", f"{dstDir}/{file}")
    return