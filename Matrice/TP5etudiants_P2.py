import matplotlib.pyplot as plt
from random import*

from numpy import transpose

# nombre d'itérations :
nbpoints=10000000

#point de départ :
p=(0,0)

f1 = [[0,0],[0,0.16]]
f2 = [[0.85,0.04],[-0.04,0.85]]
f3 = [[0.2,-0.26],[0.23,0.22]]
f4 = [[-0.15,0.28],[0.26,0.24]]

def transformation1(p):
    c = [0,0]
    c[0] = f1[0][0]*p[0] + f1[0][1]*p[1]
    c[1] = f1[1][0]*p[0] + f1[1][1]*p[1] 
    return c
     
def transformation2(p):
    c = [0,0]
    c[0] = f2[0][0]*p[0] + f2[0][1]*p[1] 
    c[1] = f2[1][0]*p[0] + f2[1][1]*p[1] + 1.6
    return c

def transformation3(p):
    c = [0,0]
    c[0] = f3[0][0]*p[0] + f3[0][1]*p[1] 
    c[1] = f3[1][0]*p[0] + f3[1][1]*p[1] + 1.6
    return c

def transformation4(p):
    c = [0,0]
    c[0] = f4[0][0]*p[0] + f4[0][1]*p[1] 
    c[1] = f4[1][0]*p[0] + f4[1][1]*p[1] + 0.44
    return c

def transforme(p):
    # Choix aléatoire (avec équiprobabilité) entre les 2 transformations de fonctions
    tirage=random()
    if tirage <1/4 :
        x, y = transformation1(p)
    elif tirage < 2/4 :
        x,y = transformation2(p)
    elif tirage < 3/4 :
        x,y = transformation3(p)
    else :
        x , y = transformation4(p)
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
