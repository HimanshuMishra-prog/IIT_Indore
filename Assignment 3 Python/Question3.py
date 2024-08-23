# Write a Python script that performs the following tasks on two large matrices A and B
# (e.g., 1000 × 1000):
# a. Using vectorised operations, perform element-wise operations (addition, subtraction,
# multiplication, division) between the matrices.
# b. Use broadcasting to perform operations between a matrix and a vector (e.g., adding
# a vector to each row or column of a matrix).
# c. Implement custom operations that combine vectorized operations and broadcasting
# (e.g., scaling each matrix row by a different scalar).*/

import numpy as np

def matrixOperations():
    size = 1000
    A = np.random.randint(0,100, (size, size))
    B = np.random.randint(0,100, (size, size))
    print(f"The first matrix is: {A}")
    print(f"The second matrix is: {B}")
    addition = A + B
    subtraction = A - B
    multiplication = A * B
    division = A / (B + 1e-10)
    print(f"Addition of A and B: {addition}")
    print(f"Subtraction of A and B: {subtraction}")
    print(f"Multiplication of A and B: {multiplication}")
    print(f"Division of A and B: {division}")
    vector = np.random.randint(0,100,size)
    matrix_row_broadcast = A + vector
    columnVector = np.random.randint(0,100,(size, 1))
    matrix_col_broadcast = A + columnVector
    print(f"Matrix-row broadcast shape: {matrix_row_broadcast}")
    print(f"Matrix-column broadcast shape: {matrix_col_broadcast}")
    row_scalars = np.random.randint(0,100,size)
    matrix_scaled_rows = A * row_scalars[:, np.newaxis]
    print(f"Matrix scaled by rows shape: {matrix_scaled_rows}")

matrixOperations()
