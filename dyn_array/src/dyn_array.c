#include <stdlib.h>

#include "dyn_array.h"

#define DYN_ARRAY_CHUNK_SIZE 10

/*
 * Construye un nuevo arreglo dinámico con DYN_ARRAY_CHUNK_SIZE entradas,
 * la casilla 0 del arreglo almacena el tamaño actual. Con el fin de controlar
 * el uso del tamaño y el crecimiento del arreglo esta estructura sólo debe ser
 * leía y modificada a través de los procedimientos definidos en dyn_array.h
 *
 * Retorna el puntero al arreglo.
 */
void **dynarr_new()
{
    void **arr = (void **)calloc(DYN_ARRAY_CHUNK_SIZE + 1, sizeof(void *));

    size_t* size = (size_t *)malloc(sizeof(size_t));
    *size = DYN_ARRAY_CHUNK_SIZE;
    arr[0] = size;

    return arr;
}

/*
 * Libera la memoria asignada al arreglo dinámico apuntado por arr
 *
 * Retorna NULL. Ej:
 *
 * void **my_arr = dynarr_new();
 * ...
 * my_arr = dynarr_destroy(my_arr); // libera la memoria y asigna NULL al puntero
 */
void **dynarr_destroy(void **arr)
{
    free(arr[0]); // libera el tamaño
    arr[0] = NULL;

    free(arr); // libera el arreglo

    return NULL;
}

/*
 * Almacena un valor en el arreglo dinámico. El arreglo crecerá de acuerdo al
 * parámetro index.
 */
void **dynarr_set(void **arr, size_t index, void* data)
{
    size_t size = *((size_t *)arr[0]);

    if (index >= size) {
        size_t new_size = ((index + 1) % DYN_ARRAY_CHUNK_SIZE == 0) ?
                          index :
                          (index + DYN_ARRAY_CHUNK_SIZE - (index % DYN_ARRAY_CHUNK_SIZE));
        arr = (void **)realloc(arr, (new_size + 1) * sizeof(void *));
        for (size_t i = index + 1; i <= new_size; i++) {
            *(arr + i) = NULL;
        }

        *((size_t *)arr[0]) = new_size;
    }

    arr[index + 1] = data;

    return arr;
}

/*
 * Recupera un valor almacenado en el arreglo dinámico.
 * Si el parámetro index es mayor que el tamaño actual del arreglo, la función retornará
 * NULL, pues index estaría referenciando a una casilla que aún no ha sido escrita.
 */
void* dynarr_get(void **arr, size_t index)
{
    size_t size = *((size_t *)arr[0]);

    return (index >= size) ? NULL : arr[index + 1];
}