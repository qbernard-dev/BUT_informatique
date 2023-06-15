import numpy as np
import numpy.linalg as alg

A = [[-1, -2, -3], [5, 3, 6], [-8, 2, -1]]
A1 = [[-1, -2, -3, 1, 0, 0], [5, 3, 6, 0, 1, 0], [-8, 2, -1, 0, 0, 1]]
A2 = [[1,2,3,-1,0,0],[0,-7,-9,5,1,0],[0,18,23,-8,0,1]]

print(alg.det(A))


def inverse(A):
    res = alg.det(A)
    if (res != 0):
        print(alg.inv(A))
    else:
        print("Impossible d'inversé la matrice")


def diviseL1(A):
    j = 0
    coef = A[0][0]
    for i in range(0, len(A[0])):
        A[j][i] = A[j][i] / coef


def diviseL2(A):
    diviseL1(A1)
    coef = A[1][0]
    for i in range(0, len(A[1])):
        A[1][i] = A[1][i] - coef*A[0][i]


def diviseL3(A) :
    diviseL2(A1)
    coef = abs(A[2][0])
    for i in range(0, len(A[2])):
        A[2][i] = A[2][i] + coef*A[0][i]

#Question 3 
def a(A) :
    coef = A[1][1]
    for i in range(0, len(A[0])):
        A[1][i] = A[1][i] / coef

def b(A) : 
    for i in range(0, len(A[0])):
        coef = A[0][i]
        A[0][i] = A[0][i] - coef*A[1][i]
    print(A)
A2 = a(A2)
b(A2)

