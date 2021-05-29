# RMI

Hay dos proyectos, uno en el que se usó el registro Naming de Java llamado `RMI_with_Naming` y otro usando un 
registro propio local en el puerto 3232 llamado `RMI_with_Registry`. Ambos fueron probados en ambiente Linux con Java11.

Para correr el de Naming se debe correr primero un proceso con `start rmiregistry` (Windows) o `rmiregistry`(Linux) en la carpeta src.

Luego en ambos se debe correr cliente y servidor a la vez.
