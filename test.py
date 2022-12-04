# procedurally generate random heightmap 300x300
# Save as "heightmap.png"
# Run with python3
# perlin noise code from https://gist.github.com/pvigier/6b6bfbaaa584ed5a0f3d
# https://stackoverflow.com/questions/42147776/how-to-generate-2d-perlin-noise-with-numpy
# https://stackoverflow.com/questions/42147776/how-to-generate-2d-perlin-noise-with-numpy/42149261#42149261


import numpy as np
import matplotlib.pyplot as plt
import matplotlib.cm as cm
from PIL import Image

def perlin(x, y, seed=0):
    # permutation table
    np.random.seed(seed)
    p = np.arange(256, dtype=int)
    np.random.shuffle(p)
    p = np.stack([p, p]).flatten()

    # coordinates of the top-left
    xi = x.astype(int)
    yi = y.astype(int)

    # internal coordinates
    xf = x - xi
    yf = y - yi

    # fade factors
    u = fade(xf)
    v = fade(yf)

    # noise components
    n00 = gradient(p[p[xi] + yi], xf, yf)
    n01 = gradient(p[p[xi] + yi + 1], xf, yf - 1)
    n11 = gradient(p[p[xi + 1] + yi + 1], xf - 1, yf - 1)
    n10 = gradient(p[p[xi + 1] + yi], xf - 1, yf)

    # combine noises
    x1 = lerp(n00, n10, u)
    x2 = lerp(n01, n11, u) # FIX1: I was using n10 instead of n01
    return lerp(x1, x2, v) # FIX2: I also had to reverse x1 and x2 here

def fade(t):
    return 6 * t**5 - 15 * t**4 + 10 * t**3

def lerp(a, b, x):
    return a + x * (b - a)

def gradient(h, x, y):
    vectors = np.stack([np.cos(h), np.sin(h)], axis=1)
    return np.sum(vectors * np.stack([x, y], axis=1), axis=1)

def generate_perlin_noise_2d(shape, res, seed=0):
    # create base grid
    x = np.linspace(0, 1, res[0])
    y = np.linspace(0, 1, res[1])
    x_grid, y_grid = np.meshgrid(x, y)

    # rescale repetitions of the base grid
    x = np.linspace(0, shape[0], res[0])
    y = np.linspace(0, shape[1], res[1])
    x_grid, y_grid = np.meshgrid(x, y)

    return perlin(x_grid, y_grid, seed)

def main():
    shape = (300, 300)
    res = (300, 300)
    seed = 0
    noise = generate_perlin_noise_2d(shape, res, seed)
    plt.imshow(noise, cmap=cm.gray)
    plt.show()
    im = Image.fromarray(noise)
    im.save("heightmap.png")

if __name__ == '__main__':
    main()

