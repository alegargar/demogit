Demo de proyecto con Git en el que se llevarán a cabo una serie de commits de manera que refleje el trabajo real a la hora de programar y llevar un control de tu código.

En este proyecto he creado una clase llamada MaquinaExpendedora con unos cuantos métodos y una clase de Test en las que iré creando métodos para probar la funcionalidad implementada, que en este caso es la de sacar galletas de la máquina expendedora.

El objetivo de la creación de este proyecto es aprender a manejarse con los commits y aprender a trabajar en distintas ramas y a resolver conflictos.

-

### Provocación y resolución de un conflicto con git.

* Lo primero que hice fue crearme una rama nueva llamada feature y automaticamente moverme a ella

```java
$ git checkout -b feature
Switched to a new branch 'feature'
```

* Seguidamente hice un cambio en un comentario e hice commit

```java
$ git commit -m "comentario en la clase principal modificado"
[feature 2f98c43] comentario en la clase principal modificado
 1 file changed, 1 insertion(+), 1 deletion(-)
```

* Hice checkout a la rama master e hice un cambio tocando la misma linea que había tocado anteriormente en la otra rama

```java
$ git checkout master
Switched to branch 'master'
Your branch is up-to-date with 'origin/master'.

$ git commit -m "cambio en comentario en clase principal"
[master 8f85df1] cambio en comentario en clase principal
 1 file changed, 1 insertion(+), 1 deletion(-)
```

* Ahora intenté hacer un merge (fusión) con la rama feature de la siguiente manera y seguidamente me dio el conflicto:

```java
$ git merge feature
Auto-merging src/main/java/org/alemurrod/MaquinaExpendedora.java
CONFLICT (content): Merge conflict in src/main/java/org/alemurrod/MaquinaExpendedora.java
Automatic merge failed; fix conflicts and then commit the result.
```

* Lo que nos toca ahora es arreglar el conflicto, git no sabe con que archivo quedarse, por eso nos toca decidir a nosotros. Hay muchas maneras de hacerlo, podemos ir directamente al archivo y modificarlo y arreglarlo nosotros y también podríamos usar algunos comandos para hacer merge los cuales les dice a git como tiene que actuar en caso de conflicto. Yo primero aborté el merge anterior y volvi a realizar los pasos anteriores para crear el conflicto de nuevo, sin embargo, ahora utilizé el comando siguiente:

```java
$ git merge -s recursive -X ours feature
Merge made by the 'recursive' strategy. 
```

* El comando anterior le dice a git que cuando encuentre un conflicto se quede con lo que haya en el archivo de la rama en la que estemos en ese momento (ours = nuestr@). En este caso lo hice desde la rama master, entonces se quedaron los cambios de la rama master en la parte donde había conflicto.

by: Alejandro Murillo Rodríguez.
