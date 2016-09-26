include_directories ("${PROJECT_SOURCE_DIR}/src")

add_executable(test_dyn_array test_dyn_array.c)
add_dependencies(test_dyn_array test_dyn_array)

add_test(test_dyn_array test_dyn_array)
add_test(test_dyn_array_valgrind valgrind
        --error-exitcode=1 --read-var-info=yes
        --leak-check=full --show-leak-kinds=all
        --verbose ./test_dyn_array)

target_link_libraries(test_dyn_array dyn_array cmocka)