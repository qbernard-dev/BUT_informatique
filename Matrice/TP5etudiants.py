import matplotlib.pyplot as plt
from random import*

# nombre d'itérations :
nbpoints=10000

#point de départ :
p=(0,0)

f1 = [[0.5,-0.5],[0.5,0.5]]
f2 = [[-0.5,-0.5],[0.5,-0.5]]
"""
Question 1
f1 :
0.5x + (-0.5)y  = 0
0.5x + 0.5y = 0

f2 :
-0.5x + (-0.5)y = 1
0.5x + (-0.5)y = 0
"""
def transformation1(p):
    c = [0,0]
    c[0] = f1[0][0]*p[0] + f1[0][1]*p[1]
    c[1] = f1[1][0]*p[0] + f1[1][1]*p[1]
    return c
     

def transformation2(p):
    c = [0,0]
    c[0] = f2[0][0]*p[0] + f2[0][1]*p[1] + 1
    c[1] = f2[1][0]*p[0] + f2[1][1]*p[1]
    return c

def transforme(p):
    # Choix aléatoire (avec équiprobabilité) entre les 2 transformations de fonctions
    tirage=random()
    if tirage <1/2 :
        x, y = transformation1(p)
    else :
        x , y = transformation2(p)
    return x , y

def construction(p, nbpoints):
    x = [p[0]]
    y = [p[1]]
    for i in range(nbpoints):
        p = transforme(p)
        x.append(p[0])
        y.append(p[1])
    
# Représentation graphique
    plt.plot(x, y, 'o')
    plt.title('Dragon de Heighway')
    plt.show()
    
construction(p,nbpoints)
