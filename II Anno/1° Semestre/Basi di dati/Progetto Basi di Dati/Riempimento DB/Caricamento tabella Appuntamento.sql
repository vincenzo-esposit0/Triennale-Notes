load data infile 'C:\Users\giuse\Desktop\Appuntamento.csv'
into table centroestetico.apputamento
fields terminated by ';'
lines terminated by '\n'
(ID,Data,Ora,Durata,Tipo,Descrizione,CD_Estetista,ID_Cliente,ID_Sala,ID_Macchinario)


