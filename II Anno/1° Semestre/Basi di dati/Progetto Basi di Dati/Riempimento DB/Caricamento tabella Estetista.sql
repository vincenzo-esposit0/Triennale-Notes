load data infile 'C:\Users\giuse\Desktop\Estetista.csv'
into table centroestetico.estetista
fields terminated by ';'
lines terminated by '\n'
(CodiceFiscale,Nome,Cognome,Età,Orario_inizio_turno,Orario_fine_turno,Stipendio,Tipo_contratto,DataAssunzione,OreStraordinarie,OreTotali,GiorniDiLavoro,Specializzazione,Numero Macchinari,Ore_di_Utilizzo,Tipologia)