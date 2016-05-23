
Utilizando arquivo input.txt
----------------------------

```bash

mvn package install

cat input.txt | \
    mvn exec:java  -Dexec.mainClass=br.eng.augusteiner.poo.cadturmas.AppCadastroTurmas
```

