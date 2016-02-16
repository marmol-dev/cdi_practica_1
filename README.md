# cdi_practica_1

## 1. Introducción a los hilos java

### 1.1   Examina  las  dos  formas  que  provee  Java  para  crear  un  hilo:  la  clase Thread y  la  interfaz Runnable
(Sin respuesta)


### 1.2   Utiliza ambas formas para crear un programa que cree y ejecute un hilo que imprima en pantalla un mensaje como Hello world, I’m a java thread.

####¿Hay alguna diferencia de funcionamiento entre ambas formas? ¿A nivel de diseño, cuál te parece preferible, y por qué?

No hay diferencias observables de funcionamiento.
A nivel de diseño nos parece preferible runnable porque permite herencia de otras clases, mientras que en Thread estas obligado a heredar de esta clase (java no permite herencia multiple) a pesar de que la sintaxis es mas simple.

### 1.3   Modifica tu programa para que el hilo tarde aproximadamente un segundo en mostrar el mensaje. ¿Qué método usarás para ello?
Usamos el método estático `sleep` de la clase `Thread`. 

### 1.4   Cuando arrancas un hilo desde el programa principal, ¿cuántos hilos hay activos? Saca una lista de los hilos activos por pantalla.
Hay 5 hilos activos:
ID: 4, Name: Signal Dispatcher
ID: 2, Name: Reference Handler
ID: 1, Name: main
ID: 8, Name: Thread-0
ID: 3, Name: Finalizer



## 2. Creación de múltiples hilos

##1. Escribe un programa en Java que mediante parámetros de línea de commando reciba cuantos hilos se debe crear. El programa creará y ejecutará el número de hilos indicado. Cada hilo debe imprimir en pantalla un mensaje como Hello, I’m thread number X , y después de un segundo, un mensaje como Bye, this was thread number X , siendo X el valor de un contador que se va incrementando con el número de hilos creados.

##2. Queremos ahora medir el tiempo que tardan en ejecutarse todos los hilos que se crean. Copia y modifica el programa anterior para que muestre este tiempo. Asegúrate de quitar cualquier código que implemente esperas en el hilo, que pudieras haber añadido anteriormente, para medir realmente sólo el tiempo de ejecución de los hilos.

##3. ¿Cómo debemos hacer para asegurarnos de que la medida de tiempo sea fiable? Es decir, que realmente se mide el tiempo desde que se arranca el primer hilo hasta que todos los hilos hayan finalizado. ¿Qué errores de medida de tiempo pueden ocurrir, si no nos aseguramos de que todos los hilos han acabado?
Utilizando em metodo join en cada hilo.
Que se ejecute el codigo del main antes de que termine el ultimo hilo.



