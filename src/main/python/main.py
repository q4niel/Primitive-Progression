import os
from util import *

def main() -> None:
    projDir:str = upper(os.path.abspath(__file__), 2)

    makeDirs (
        f"{projDir}/generated/data/minecraft",
        ["recipe", "advancement/recipes/combat", "advancement/recipes/tools"]
    )

    moveFiles (
        f"{projDir}/generated/data/primitive/recipe",
        f"{projDir}/generated/data/minecraft/recipe",
        [
            "wooden_pickaxe.json",
            "wooden_shovel.json",
            "wooden_axe.json",
            "wooden_sword.json",
            "wooden_hoe.json",
            "stone_pickaxe.json",
            "stone_shovel.json",
            "stone_axe.json",
            "stone_sword.json",
            "stone_hoe.json"
        ]
    )

    moveFiles (
        f"{projDir}/generated/data/primitive/advancement/recipes/combat",
        f"{projDir}/generated/data/minecraft/advancement/recipes/combat",
        ["wooden_sword.json", "stone_sword.json"]
    )

    moveFiles (
        f"{projDir}/generated/data/primitive/advancement/recipes/tools",
        f"{projDir}/generated/data/minecraft/advancement/recipes/tools",
        [
            "wooden_pickaxe.json",
            "wooden_shovel.json",
            "wooden_axe.json",
            "wooden_hoe.json",
            "stone_pickaxe.json",
            "stone_shovel.json",
            "stone_axe.json",
            "stone_hoe.json"
        ]
    )

    cleanDirTree(f"{projDir}/generated/data/primitive")

    return

if __name__ == "__main__": main()