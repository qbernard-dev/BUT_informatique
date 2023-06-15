drop schema if exists distribill cascade;
create schema distribill;
set schema 'distribill';

CREATE TABLE fournisseur (
  nofour  CHAR(3),
  nomf    VARCHAR(20) NOT NULL,
  ville   VARCHAR(20) NOT NULL,
  CONSTRAINT fournisseur_pk PRIMARY KEY(nofour)
);

INSERT INTO fournisseur VALUES('F1','Bourhis','Paris');
INSERT INTO fournisseur VALUES('F2','Bourhis','Paris');
INSERT INTO fournisseur VALUES('F3','Collet','Reims');
INSERT INTO fournisseur VALUES('F4','Bossuet','Dijon');
INSERT INTO fournisseur VALUES('F5','Mercier','Riec');
INSERT INTO fournisseur VALUES('F6','Tanguy','Lannion');

create table produit(
  noproduit CHAR(3) primary key,
  nomp      VARCHAR(20) NOT NULL,
  origine   VARCHAR(20) NOT NULL,
  couleur   VARCHAR(20) NOT NULL
);


INSERT INTO produit(noproduit,nomp,couleur,origine) 
	VALUES('P1','Cassis','Rouge','Dijon');
INSERT INTO produit(noproduit,nomp,couleur,origine) 
	VALUES('P2','Champagne','Blanc','Reims');
INSERT INTO produit(noproduit,nomp,couleur,origine) VALUES
  ('P3','Huitre','Vert','Riec'),
	('P4','Moutarde','Jaune','Dijon'),
	('P5','Salade','Vert','Nice'),
	('P6','Cornichon','Vert','Dijon'),
	('P7','Muscadet','Blanc','Nantes');


create table fourniture(
  nofour      char(3),
  noproduit   char(3),
  quantite    INTEGER NOT NULL,
  constraint fourniture_pk primary key(nofour, noproduit)
);

INSERT INTO fourniture VALUES ('F1','P1',1);
INSERT INTO fourniture VALUES ('F1','P4',1);
INSERT INTO fourniture VALUES ('F1','P5',8);
INSERT INTO fourniture VALUES ('F1','P6',2);
INSERT INTO fourniture VALUES ('F2','P2',1);
INSERT INTO fourniture VALUES ('F2','P4',1);
INSERT INTO fourniture VALUES ('F3','P2',5);
INSERT INTO fourniture VALUES ('F3','P4',1);
INSERT INTO fourniture VALUES ('F4','P4',2);
INSERT INTO fourniture VALUES ('F4','P5',7);
INSERT INTO fourniture VALUES ('F4','P6',3);
INSERT INTO fourniture VALUES ('F5','P3',10);

/*
INSERT INTO fourniture VALUES ('F1','P1',2); -- pb de clé : normal
INSERT INTO fourniture VALUES ('F12','P1',2); -- pas de pb : pas normal, il manque une FK
*/

/* 
delete from fourniture where nofour = 'F12';
*/
alter table fourniture
  add constraint fourniture_fk_fournisseur
  foreign key(nofour) references fournisseur(nofour);
  
alter table fourniture
  add constraint fourniture_fk_produit
  foreign key(noproduit) references produit(noproduit);
);

/*Q4
Ca ne marche pas
*/

/*Q5 add un nuplet*/
INSERT INTO fourniture VALUES ('F12','P1',2);

/*EXERCICE 2*/
/* Q1 */
select nomp from produit;

/*Q2*/
select * from produit where origine = 'Dijon';

/*Q3*/
select nomp from produit where origine = 'Dijon';

/*Q4*/
select distinct nofour from fourniture where quantite != 0 ;

/*Q5*/
select nofour from fournisseur except select nofour from fourniture ;

/*Q6*/
select nofour from fourniture where noproduit = 'P6' ;

/*Q7*/
select nofour from fourniture where noproduit != 'P6' ; 

/*Q8*/
select nofour from fournisseur except select nofour from fourniture where noproduit = 'P6' ;

/*Q9*/
select nofour from fourniture except select nofour from fourniture where noproduit = 'P6' ;

/*Q10*/
select nofour from fourniture except select nofour from fourniture where noproduit != 'P6' ;

/*Q11*/
select distinct nofour from fourniture where noproduit in ('P4','P6') ;

/*Q12*/
select distinct nofour from fourniture where noproduit = 'P4' intersect select distinct nofour from fourniture where noproduit = 'P6' ;

/*Q13*/
select distinct nofour from fourniture where noproduit != 'P4' and noproduit != 'P6' ;

/*Q14*/
select distinct nomf, nofour from fourniture natural join fournisseur where noproduit = 'P6' ;

/*Q15*/
select nofour, nomf from fourniture natural join fournisseur except select nofour, nomf from fourniture natural join fournisseur where noproduit = 'P4' or  noproduit = 'P6' ;

/*Q16*/
select distinct nofour, nomf, ville from fourniture natural join produit natural join fournisseur where ville = origine ;

/*Q17*/
select distinct p1.noproduit,p2.noproduit from produit p1 inner join produit p2 on p1.couleur = p2.couleur where p1.noproduit < p2.noproduit ;

/*Q18*/
select distinct p1.noproduit,p2.noproduit from produit p1 inner join produit p2 on p1.couleur = p2.couleur where p1.couleur = 'Vert' and  p1.noproduit < p2.noproduit ;

/*Q19*/
select distinct nofour from produit natural join fourniture where couleur = 'Vert' or couleur = 'Rouge' ;

/*Q20*/
select distinct nofour from produit natural join fourniture where couleur = 'Vert' intersect select distinct nofour from produit natural join fourniture where couleur = 'Rouge' ;

with frouge  as (select nofour, couleur from fourniture natural join produit where couleur = 'Rouge'), fvert as ( select nofour, couleur from fourniture natural join produit where couleur = 'Vert') select distinct fvert.nofour from fvert inner join frouge on fvert.no four = frouge.nofour ;
/*Q21*/
select distinct nomf, nofour from fourniture natural join fournisseur natural join produit where couleur != 'Vert' ;

/*Q22*/
select distinct nomf, nofour from fourniture natural join fournisseur natural join produit except select distinct nomf, nofour from fourniture natural join fournisseur natural join produit where couleur != 'Vert' ;

/*Q23*/
select distinct nomf, nofour from fourniture natural join fournisseur natural join produit except select distinct nomf, nofour from fourniture natural join fournisseur natural join produit where couleur != 'Vert' intersect select distinct nomf, nofour from fourniture natural join fournisseur natural join produit where couleur != 'Jaune' ;
