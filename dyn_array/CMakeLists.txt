cmake_minimum_required(VERSION 3.0)
project(dyn_array)

enable_testing()

set(CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -g -std=c11")

add_subdirectory(src)
add_subdirectory(test)
