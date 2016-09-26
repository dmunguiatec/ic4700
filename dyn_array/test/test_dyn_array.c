
#include <stdarg.h>
#include <stddef.h>
#include <setjmp.h>
#include <cmocka.h>

#include "dyn_array.h"

static void test_dyn_array_constructor(void **state)
{
    void **arr = dynarr_new();
    assert_non_null(arr);

    arr = dynarr_destroy(arr);
    assert_null(arr);
}

static void test_dyn_array_set_lower_bound(void **state)
{
    int val = -1;
    void **arr = dynarr_new();
    arr = dynarr_set(arr, 0, &val);
    arr = dynarr_destroy(arr);
}

static void test_dyn_array_set_upper_bound(void **state)
{
    int val = -1;
    void **arr = dynarr_new();
    arr = dynarr_set(arr, 9, &val);
    arr = dynarr_destroy(arr);
}

static void test_dyn_array_set_grows_lower_bound(void **state)
{
    int val = -1;
    void **arr = dynarr_new();
    arr = dynarr_set(arr, 10, &val);
    arr = dynarr_destroy(arr);
}

static void test_dyn_array_set_grows_large_index(void **state)
{
    int val = -1;
    void **arr = dynarr_new();
    arr = dynarr_set(arr, 1024, &val);
    arr = dynarr_destroy(arr);
}

static void test_dyn_array_get_lower_bound(void **state)
{
    int val = -1;
    void **arr = dynarr_new();
    arr = dynarr_set(arr, 0, &val);

    int *pval = dynarr_get(arr, 0);
    assert_int_equal(val, *pval);

    arr = dynarr_destroy(arr);
}

static void test_dyn_array_get_upper_bound(void **state)
{
    int val = -1;
    void **arr = dynarr_new();
    arr = dynarr_set(arr, 9, &val);

    int *pval = dynarr_get(arr, 9);
    assert_int_equal(val, *pval);

    arr = dynarr_destroy(arr);
}

static void test_dyn_array_get_grows_lower_bound(void **state)
{
    int val = -1;
    void **arr = dynarr_new();
    arr = dynarr_set(arr, 10, &val);

    int *pval = dynarr_get(arr, 10);
    assert_int_equal(val, *pval);

    arr = dynarr_destroy(arr);
}

static void test_dyn_array_get_grows_large_index(void **state)
{
    int val = -1;
    void **arr = dynarr_new();
    arr = dynarr_set(arr, 1024, &val);

    int *pval = dynarr_get(arr, 1024);
    assert_int_equal(val, *pval);

    arr = dynarr_destroy(arr);
}

static void test_dyn_array_get_large_unassigned(void **state)
{
    void **arr = dynarr_new();
    int *pval = dynarr_get(arr, 1024 * 10);

    assert_null(pval);

    arr = dynarr_destroy(arr);
}

static void test_dyn_array_get_lower_unassigned(void **state)
{
    void **arr = dynarr_new();
    int *pval = dynarr_get(arr, 2);

    assert_null(pval);

    arr = dynarr_destroy(arr);
}

int main(void)
{
    const struct CMUnitTest tests[] = {
            cmocka_unit_test(test_dyn_array_constructor),
            cmocka_unit_test(test_dyn_array_set_lower_bound),
            cmocka_unit_test(test_dyn_array_set_upper_bound),
            cmocka_unit_test(test_dyn_array_set_grows_lower_bound),
            cmocka_unit_test(test_dyn_array_set_grows_large_index),
            cmocka_unit_test(test_dyn_array_get_lower_bound),
            cmocka_unit_test(test_dyn_array_get_upper_bound),
            cmocka_unit_test(test_dyn_array_get_grows_lower_bound),
            cmocka_unit_test(test_dyn_array_get_grows_large_index),
            cmocka_unit_test(test_dyn_array_get_large_unassigned),
            cmocka_unit_test(test_dyn_array_get_lower_unassigned)
    };

    return cmocka_run_group_tests(tests, NULL, NULL);
}