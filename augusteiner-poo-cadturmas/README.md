
Utilizando arquivo input.txt
----------------------------

```bash

mvn clean install

cat input.txt | \
    mvn exec:java  -Dexec.mainClass=br.eng.augusteiner.poo.cadturmas.AppCadastroTurmas

```

