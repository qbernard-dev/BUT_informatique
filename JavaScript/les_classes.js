// SEANCE 2, PDF SUR TEAMS

var unePersonne = {
	prenom: "John",
  nom: "Deuff",
  profession: "Humoriste",
  ouvrages: {livre1: "L'oeuf au riz", livre2: "Quoi de n'Oeuf ?"}
};

//console.log(Object.values(unePersonne)[0]);

let compteur = 0;
for (let valeur in unePersonne) compteur++;
//console.log(`il y a ${compteur} dans la classe unePersonne`);

//console.log(Object.values(unePersonne));

//console.log(Object.keys(unePersonne.ouvrages));

//console.log(unePersonne.profession);

//for (let item in unePersonne) console.log(item)
	//for (let livre in unePersonne.ouvrages) console.log(livre);
  