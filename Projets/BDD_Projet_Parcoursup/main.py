import numpy as np
import pandas as pd
import sklearn
from sklearn.linear_model import LinearRegression


# méthode utilitaire
def centreduire(t):
    t = np.array(t, dtype=np.float64)
    (n, p) = t.shape
    res = np.zeros((n, p))
    tmoy = np.mean(t, axis=0)
    tecart = np.std(t, axis=0)
    for j in range(p):
        res[:, j] = (t[:, j] - tmoy[j]) / tecart[j]
    return res

dataFrame = pd.DataFrame(pd.read_csv("export.csv", sep = ';',))

# drop colonne 0,2,3
dataFrame = dataFrame.drop(dataFrame.columns[[0, 2, 3]], axis=1)
dataFrame.dropna()

array = np.array(dataFrame)[:, 1:]

array_reduit = centreduire(array)

cov = np.cov(array_reduit, rowvar=False)
# x dois prendre colonne 0 et 1
X = cov[:, [0,1]]
Y = cov[:,2]

print("X:", X, '\n')
print("Y:", Y, '\n')

linearRegression = LinearRegression()
linearRegression.fit(X, Y)
a = linearRegression.coef_
b = 0

y_pred = a*X+b
print("Résultat y_pred", y_pred)
