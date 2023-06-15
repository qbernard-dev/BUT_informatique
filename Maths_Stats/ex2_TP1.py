from array import array
from multiprocessing.dummy import Array
import numpy as np
import numpy.random as rd
import matplotlib.pyplot as plt

def tirage_de() :
    return rd.randint(1,7)

def tirage_des(N) :
    return [rd.randint(1,7) for x in range(N)]

Serie100 = tirage_des(100)

def Moyenne(Serie) : 
    sum = 0
    for x in range(len(Serie)) : 
        sum += Serie[x]
    return sum/len(Serie)
    
print(Moyenne(Serie100))

def Variance(Serie) :
    sum = 0
    for x in range(len(Serie)) : 
        sum += Serie[x]**2
    return (1/len(Serie)*sum)-(Moyenne(Serie)**2.0)

print(Variance(Serie100))

def effectif(Serie, Val) : 
    sum = 0
    for x in range(len(Serie)) :
        if(Serie[x] == Val) :
            sum += 1
    return sum

print(effectif(Serie100,5))

X = np.array(Serie100)
Vals = [1,2,3,4,5,6,7]
plt.hist(X,Vals,histtype='bar',align='left',rwidth=0.1)