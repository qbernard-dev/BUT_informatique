// EXERCICE 2 SUR LA SEANCE 2 SUR TEAMS 

class Rectangle {
	constructor(long, lar){
  	this._longueur = long;
    this._largeur = lar;
  }
  
  get longueur() {return this._longueur}
  get largeur() {return this._largeur}
  
  set longueur(long) {this._longueur = long}
  set largeur(lar) {this._largeur = lar}
  
  calcPerimetre(){
  	return `le périmètre est de ${this._longueur*2 + this._largeur*2}`
  }
  
  estCarre(){ 
  	return this._longueur === this._largeur 
  }
  
  toString() { 
  	return `Rectangle de longueur ${this._longueur} cm et de largeur ${this._largeur}`
  }
  
  get aire() {
  	return this._longueur * this._largeur
  }
  
  static comparerRectangle(r1, r2) {
  	if(r1.calcPerimetre() > r2.calcPerimetre()){
    	return "Le Rectangle 1 à un plus grand périmètre que le Rectangle 2"
    } else {
    	return "Le Rectangle 2 à un plus grand périmètre que le Rectangle 1"
    }
  }
}

let r1 = new Rectangle(50,40);
console.log(r1.toString());
console.log(r1.calcPerimetre()); 
console.log(`L'aire est de ${r1.aire} cm²`); 
console.log(`Est-ce un carré ? ${r1.estCarre() ? 'Oui' : 'Non'}`);

let r2 = new Rectangle(50,50);
console.log(`Est-ce un carré ? ${r2.estCarre() ? 'Oui' : 'Non'}`);

console.log(Rectangle.comparerRectangle(r1, r2));