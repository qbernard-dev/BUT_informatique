class Graphe(object):

    def __init__(self, graphe_dict=None):
        """ initialise un objet graphe.
	    Si aucun dictionnaire n'est
	    créé ou donné, on en utilisera un 
	    vide
        """
        if graphe_dict == None:
            graphe_dict = dict()
        self._graphe_dict = graphe_dict

    def aretes(self, sommet):
        """ retourne une liste de toutes les aretes d'un sommet"""
        return self._graphe_dict[sommet]

    def all_sommets(self):
        """ retourne tous les sommets du graphe """
        self.__iter__
        obj = []
        for a in self._graphe_dict:
            obj.append(a)
        return set(obj)

    def all_aretes(self):
        """ retourne toutes les aretes du graphe """
        obj = []
        for a in self.all_sommets():
            for b in self._graphe_dict[a]:
                obj.append(set([a,b]))
        return obj
    
    def add_sommet(self, sommet):
        """ Si le "sommet" n'set pas déjà présent
	dans le graphe, on rajoute au dictionnaire 
	une clé "sommet" avec une liste vide pour valeur. 
	Sinon on ne fait rien.
        """
        if not(sommet in self._graphe_dict):
            self._graphe_dict[sommet] = []

    def add_arete(self, arete):
        """ l'arete est de  type set, tuple ou list;
            Entre deux sommets il peut y avoir plus
	    d'une arete (multi-graphe)
        """
        for i in range(1,len(arete)):
            self._graphe_dict[arete[0]] = arete[i]

    def __list_aretes(self):
        """ Methode privée pour récupérer les aretes. 
	    Une arete est un ensemble (set)
            avec un (boucle) ou deux sommets.
        """
        obj = []
        for a in self.all_sommets():
            for b in self._graphe_dict[a]:
                obj.append(set([a,b]))
        return obj

    
    def __iter__(self):
        self._iter_obj = iter(self._graphe_dict)
        return self._iter_obj

    def __next__(self):
        """ Pour itérer sur les sommets du graphe """
        return next(self._iter_obj)

    def __str__(self):
        res = "sommets: "
        for k in self._graphe_dict.keys():
            res += str(k) + " "
        res += "\naretes: "
        for arete in self.__list_aretes():
            res += str(arete) + " "
        return res

    # trouver chaines
    def trouve_chaine(self, sommet_dep, sommet_arr, chain=None):
        """ Trouve une chaine entre deux sommets """
        if chain is None:
            chain = []
        chain = chain + [sommet_dep]
        if sommet_dep == sommet_arr:
            return chain
        if not(sommet_dep in self._graphe_dict):
            return None
        for sommet in self._graphe_dict[sommet_dep]:
            if sommet not in chain:
                newchain = self.trouve_chaine(sommet, sommet_arr, chain)
                if newchain: return newchain
        return None

    def trouve_tous_chemins(self, sommet_dep, sommet_arr, chem=[]):
        """ Trouve tous les chemins entre deux sommets """
        chem = chem + [sommet_dep]
        if sommet_dep == sommet_arr:
            return [chem]
        if not(sommet_dep in self._graphe_dict):
            return []
        chemins = []
        for sommet in self._graphe_dict[sommet_dep]:
            if sommet not in chem:
                nouveaux_chemins = self.trouve_tous_chemins(sommet, sommet_arr, chem)
                for c in nouveaux_chemins: chemins.append(c)
        return chemins

    # tp 7/8

    def est_connexe(self, sommet):
        """Programme pour savoir si le graphe est connexe"""
        A = [sommet]
        B = [sommet]
        c = {sommet: 0}
        while A:
            d = A.pop(0)
            for e in self._graphe_dict[d]:
                if e not in B:
                    B.append(e)
                    A.append(e)
                    c[e] = c[d] + 1

        return len(B) == len(self._graphe_dict)

    def est_connexeDFS(self, sommet):
        """ Programme pour savoir si le graphe est connexeDFS"""
        A = [sommet]
        B = [sommet]
        c = {sommet: 0}
        while A:
            d = A.pop()
            for e in self._graphe_dict[d]:
                if e not in B:
                    B.append(e)
                    A.append(e)
                    c[e] = c[d] + 1

        return len(B) == len(self._graphe_dict)

    def cheminProfondeur(self, sommet, sommetDestination):
        """Programme du parcour en profondeur"""
        pile = [sommet]
        visite = [sommet]
        distance = {sommet: 0}
        arbre = {sommet: None}
        while pile:
            sommet = pile.pop()
            for voisin in self._graphe_dict[sommet]:
                if voisin not in visite:
                    visite.append(voisin)
                    pile.append(voisin)
                    distance[voisin] = distance[sommet] + 1
                    arbre[voisin] = sommet
            if(sommet == sommetDestination):
                return True
        return False

    def cheminLargeur(self, sommet,sommetDestination):
        """Programme du parcour en largeur"""
        file = [sommet]
        visite = [sommet]
        distance = {sommet: 0}
        arbre = {sommet: None}
        while file:
            sommet = file.pop(0)
            for voisin in self._graphe_dict[sommet]:
                if voisin not in visite:
                    visite.append(voisin)
                    file.append(voisin)
                    distance[voisin] = distance[sommet] + 1
                    arbre[voisin] = sommet
            if(sommet == sommetDestination):
                return True
        return False  

    def cycle(self, sommet):
        """Programme du cycle"""
        file = [sommet]
        visite = [sommet]
        distance = {sommet: 0}
        arbre = {sommet: None}
        while file:
            sommet = file.pop(0)
            for voisin in self._graphe_dict[sommet]:
                if voisin not in visite:
                    visite.append(voisin)
                    file.append(voisin)
                    distance[voisin] = distance[sommet] + 1
                    arbre[voisin] = sommet
                else:
                    return True
        return False