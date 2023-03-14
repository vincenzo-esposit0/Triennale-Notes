load data infile 'C:\Users\giuse\Desktop\Macchinario.csv'
into table centroestetico.macchinario
fields terminated by ';'
lines terminated by '\n'
(ID,Nome,Marca,Modello,Descrizione,Tipologia,Antivecchiamento,Dimagrimento,CD_estetista,ID_Sala,Ore_di_Utilizzo)