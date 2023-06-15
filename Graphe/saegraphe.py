# Initialisation
n = 8 # Taille de l'échiquier
solutions = 0 # Nombre de solutions trouvées
solutions_list = [] # Liste des échiquiers solutions
board = [0] * n # Tableau représentant l'échiquier initialisé avec des zéros

# Fonction de vérification si une reine peut être placée sur la case (row, col)
def isSafe(board, row, col):
    for i in range(row):
        # Vérifie si une reine est déjà placée sur la même colonne ou diagonale
        if board[i] == col or board[i] - i == col - row or board[i] + i == col + row:
            return False
    return True

# Fonction de recherche de solutions
def search(board, row):
    global solutions # Utilise la variable solutions définie en dehors de la fonction
    if row == n:
        solutions = solutions + 1 # Une nouvelle solution a été trouvée
        solutions_list.append(board[:]) # Ajoute une copie de l'échiquier solution à la liste des échiquiers solutions
    else:
        for col in range(n):
            if isSafe(board, row, col):
                board[row] = col # Place une reine sur la case (row, col)
                search(board, row+1) # Recherche la solution pour la ligne suivante
                board[row] = 0 # Retire la reine de la case (row, col) pour la recherche de la solution suivante

# Appel de la fonction de recherche de solutions
search(board, 0)

# Affichage du nombre de solutions trouvées
print("Le nombre de solutions est", solutions)

# Affichage des échiquiers solutions
for solution in solutions_list:
    print("Solution:")
    for row in range(n):
        line = ""
        for col in range(n):
            if solution[row] == col:
                line += "Q "
            else:
                line += ". "
        print(line)
    print("\n")
