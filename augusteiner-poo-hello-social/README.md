
How To
======

Pré-requesitos
--------------

Arquivo twitter4j.properties ([link da documentação](http://twitter4j.org/en/configuration.html#fileconfiguration)),
contendo as chaves geradas/configuradas pelo twitter em [apps.twitter.com](https://apps.twitter.com)

Executando
----------

```bash

mvn clean install

mvn exec:java \
    -Dexec.mainClass=br.eng.augusteiner.poo.hello.social.JTweet \
    -Dexec.args="--status <StatusAqui>"
```
