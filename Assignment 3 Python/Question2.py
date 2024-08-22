# Given two large vectors v1, v2 of size 106, write Python functions using NumPy that:
# a. Compute the dot product of these vectors using vectorized operations.
# b. Compute the same dot product using a scalar (element-wise) approach in a loop.
# c. Measure and compare the execution time of both approaches, explaining why vectorized
# computation is typically more efficient.

import numpy as np
import time

def dot_product_vectorized(v1, v2):
    return np.dot(v1, v2)

def dot_product_scalar(v1, v2):
    dot_product = 0
    for i in range(len(v1)):
        dot_product += v1[i] * v2[i]
    return dot_product

def measure_execution_time():
    size = 10**6  
    v1 = np.random.randint(0,100,size)
    v2 = np.random.randint(0,100,size)

    start_time = time.time()
    result_vectorized = dot_product_vectorized(v1, v2)
    time_vectorized = time.time() - start_time

    start_time = time.time()
    result_scalar = dot_product_scalar(v1, v2)
    time_scalar = time.time() - start_time

    print(f"Dot product using vector multiplication: {result_vectorized}")
    print(f"Dot product using scalar multiplication: {result_scalar}")
    print(f"Time using vector multiplication: {time_vectorized:.5f} seconds")
    print(f"Time using scalar multiplication: {time_scalar:.5f} seconds")

measure_execution_time()
