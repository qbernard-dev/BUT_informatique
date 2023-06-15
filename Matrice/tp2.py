# Exercice 1

def absolue(x) :
    if x < 0 :
        x = -x
    return x

def fact(x) :
    if x == 0 :
        return 0
    elif x == 1 :
        return 1
    else :
        return x*fact(x-1)

def factIT(x) :
    res = 1
    if x == 0 :
        return 0
    elif x == 1 :
        return 1
    else :
        for i in range(x) :
            res += res*i
        return res

def puissanceIT(x,n) :
    tmp = x
    if n == 0 :
        return 1
    else :
        for i in range(n-1) :
            x = x * tmp
        return x

def puissance(x,n) :
    if n == 0:
        return 1
    if n == 1 :
        return x
    else :
        return x * puissance(x,n-1) 

# Exercice 2

def transpose(A) :
    p = len(A)
    n = len(A[0])
    B = [[0 for i in range(p)] for j in range(n)]
    for i in range(p) :
        for j in range(p) :
            B[i][j] = A[j][i]
    return B

def diagonale(A) :
    p = len(A)
    n = len(A[0])
    B = [[0 for i in range(p)] for j in range(n)]
    if p >= n :
        for i in range(n) :
            B[i][i] = A[i][i]
    else :
        for i in range(p) :
            B[i][i] = A[i][i]
    return B

def trace(A) :
    res = 0
    n = len(A)
    for i in range(n) :
        res += A[i][i]
    return res 

def valeurmax(A) :
    max = A[0][0]
    val_i = 0
    val_j = 0
    p = len(A)
    n = len(A[0])
    for i in range(p) :
        for j in range(n) :
            val = A[i][j]
            if val > max:
                max = val
                val_i = i
                val_j = j
    return {"val":max, "i":val_i, "j":val_j}

def produitscalaire(A,B) :
    res = 0
    l = len(A)
    for i in range(l) :
        res += A[i]*B[i][0]
    return res 
