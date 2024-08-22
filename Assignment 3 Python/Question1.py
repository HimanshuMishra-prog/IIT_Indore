# Generate a random 2D array (A) using Numpy, write a function that:
# a. Calculate the minimum, maximum, median, mean, and standard deviation of A.
# b. Computes the mean and variance of A along the first dimension. Perform normalization
# and standardization to A using the computed statistics. The normalization
# and standardization for a vector X are formulated as follows:
# Xnormalized =
# X − Xmin
# Xmax − Xmin
# ; Xstandardized =
# X − μ
# σ

import numpy as np

def analyze_and_transform(m, n):
    array = np.random.randint(0,10,size = (m, n))
    minimum = np.min(array)
    maximum = np.max(array)
    median = np.median(array)
    mean = np.mean(array)
    std_dev = np.std(array)
    print(f"Minimum: {minimum}")
    print(f"Maximum: {maximum}")
    print(f"Median: {median}")
    print(f"Mean: {mean}")
    print(f"Standard Deviation: {std_dev}")
    mean_first_dim = np.mean(array, axis=0)
    var_first_dim = np.var(array, axis=0)
    min_first_dim = np.min(array, axis=0)
    max_first_dim = np.max(array, axis=0)

    normalized = (array - min_first_dim) / (max_first_dim - min_first_dim)
    standardized = (array - mean_first_dim) / np.sqrt(var_first_dim)
    print("\n Our random array is:\n", array)
    print("\nOur array after normalisation is:\n", normalized)
    print("\nOur array after standardization is:\n", standardized)


m, n = 6 , 6 
analyze_and_transform(m, n)
