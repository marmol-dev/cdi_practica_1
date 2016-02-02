# cdi_practica_1

## 1. Introducción a los hilos java

### 1.1   Examina  las  dos  formas  que  provee  Java  para  crear  un  hilo:  la  clase Thread y  la  interfaz Runnable
-


### 1.2   Utiliza ambas formas para crear un programa que cree y ejecute un hilo que imprima en pantalla un mensaje como Hello world, I’m a java thread.

####¿Hay alguna diferencia de funcionamiento entre ambas formas? ¿A nivel de diseño, cuál te parece preferible, y por qué?

No hay diferencias observables de funcionamiento.
A nivel de diseño nos parece preferible runnable porque permite herencia de otras clases, mientras que en Thread estas obligado a heredar de esta clase (java no permite herencia multiple) a pesar de que la sintaxis es mas simple.  
