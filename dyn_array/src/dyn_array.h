#ifndef DYN_ARRAY_DYN_ARRAY_H
#define DYN_ARRAY_DYN_ARRAY_H

extern void **dynarr_new();
extern void **dynarr_destroy(void **arr);
extern void **dynarr_set(void **arr, size_t index, void* data);
extern void *dynarr_get(void **arr, size_t index);

#endif //DYN_ARRAY_DYN_ARRAY_H
