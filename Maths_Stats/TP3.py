import numpy as np
import matplotlib.pyplot as plt

Regions=['Bretagne','Normandie','Hauts de France','Grand Est',
         'Ile de France','Nouvelle-Aquitaine',
         'Pays de la Loire','Centre-Val de Loire',
         'Bourgogne-Franche-Comté','Auvergne-Rhône-Alpes',
         'Occitanie','Provence-Alpes-Côte d Azur', 'Corse']
Chomage=np.array([7.9,9.4,11.7,9.3,8.1,8.8,
                  7.8,8.8,8.3,8.1,11,10.8,9.9])
NbRues=np.array([1392599,768736,345789,656479,602482,
                 721430,1099086,341955,608049,733372,
                 676271,217089,90076])

def Moyenne(Serie):
    N=len(Serie)
    return sum(Serie)/N

def Variance(X):
    N=X.shape[0]
    Xm=sum(X)/N
    return sum((X-Xm)*(X-Xm))/N

x = np.arange(start=0, stop=10000, step=100)
y = np.random.rand(len(x))
y = x*y

# Affichage
plt.plot(x, y, 'ro', markersize=10)
plt.grid(True)
plt.title("Affichage de macron")
plt.show()

def Covar(Serie1,Serie2) :
    s1 = Moyenne(Serie1)
    s2 = Moyenne(Serie2)
    moy = 0
    for i in range(Serie1) :
        moy = Serie1[i] + Serie2[i]
    moy = moy * (1/i)
    covar = moy - s1 * s2
    print(covar)
