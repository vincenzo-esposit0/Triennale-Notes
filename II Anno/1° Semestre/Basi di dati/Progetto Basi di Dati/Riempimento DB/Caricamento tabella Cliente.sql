load data infile 'C:\Users\giuse\Desktop\Cliente.csv'
into table centroestetico.cliente
fields terminated by ';'
lines terminated by '\n'
(ID,Nome,Cognome,Età,Sesso)