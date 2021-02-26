

INSERT INTO parametros (id,inicio, fin)
VALUES (1,'1','36');

INSERT INTO tea (id,valor, tasa)
VALUES (1,'99.90%', '99.90'),(2,'95.90%', '95.90'),(3,'99.00%','99.00');

INSERT INTO cliente (id, documento)
VALUES (1, '44444444'),(2,'55555555');

INSERT INTO tarjeta(id, valor)
VALUES (1,'CLASICA'),(2,'ORO'),(3,'BLACK');

INSERT INTO usuario_tarjeta(id, id_usuario, id_tarjeta)
VALUES (1,1,1),(2,1,3),(3,2,2),(4,2,1)