
OP15,8,7,1:
insert into centroestetico.macchinario (ID,Marca,Modello,Nome,Descrizione,Tipologia,Antivecchiamento,Dimagrimento)
values ();

OP14:
select macchinario.nome,macchinario.Marca,macchinario.modello,macchinario.Tipologia,macchinario.Ore_di_Utilizzo 
from macchinario
where macchinario.Ore_di_Utilizzo >= "1000";

OP13:
SELECT Nome,sum(durata)as Ore
FROM (centroestetico.Sala RIGHT OUTER join centroestetico.appuntamento on sala.ID=appuntamento.ID_Sala)
group by ID_Sala
order by nome;

OP11:
UPDATE estetista
SET tipo_contratto = 'Determinato' 
WHERE CodiceFiscale like "DBMDXC70C60B512B";

OP10:
select *
from macchinario
where CD_estetista like "DBMDXC70C60B512B";

OP9:
select CodiceFiscale,nome,cognome,max(Ore_di_Utilizzo)
from estetista

OP6:
select Tipo, count(ID)
from Appuntamento
group by Tipo

OP5:



