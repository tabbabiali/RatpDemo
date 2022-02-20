Les technologies utilisés dans ce projet:
    - Compose pour le build de UI
    - Unidirectional Data Flow : le UI envoie un event au viewmodel via la 
      fonction(appViewModel.updateFormItem) et ce dernier renvoie la data au screen via 
      (appViewModel.resultState)
    - La lib Truth pour le check en test unitaire
Ce qui manque à faire
    - Ameliorer le style
    - Test UI
    - Dans le cas où limit a une grande valeur l'app crash, la pagination peut être une solution

Note:
   C'est la prmière fois que j'utilise Compose donc c'est sûr qu'il y aura des choses à amelirer