INSERT INTO public.tienda (nombre) VALUES('Tia');
INSERT INTO public.tienda (nombre) VALUES('Super Maxi');
INSERT INTO public.tienda (nombre) VALUES('Super Stock');
INSERT INTO public.tienda (nombre) VALUES('La Mega');

INSERT INTO public.producto (cod, "name", price, stock) VALUES('cod1', 'name1', 0.15, 20);
INSERT INTO public.producto (cod, "name", price, stock) VALUES('cod2', 'name2', 0.25, 10);
INSERT INTO public.producto (cod, "name", price, stock) VALUES('cod3', 'name3', 0.35, 20);
INSERT INTO public.producto (cod, "name", price, stock) VALUES('cod4', 'name4', 0.45, 30);
INSERT INTO public.producto (cod, "name", price, stock) VALUES('cod5', 'name5', 0.55, 40);
INSERT INTO public.producto (cod, "name", price, stock) VALUES('cod6', 'name6', 0.65, 20);
INSERT INTO public.producto (cod, "name", price, stock) VALUES('cod7', 'name7', 0.75, 5);
INSERT INTO public.producto (cod, "name", price, stock) VALUES('cod8', 'name8', 0.85, 11);
INSERT INTO public.producto (cod, "name", price, stock) VALUES('cod9', 'name9', 0.95, 12);
INSERT INTO public.producto (cod, "name", price, stock) VALUES('cod10', 'name10', 0.15, 5);

INSERT INTO public.tienda_producto (id_producto, id_tienda) VALUES(1, 1);
INSERT INTO public.tienda_producto (id_producto, id_tienda) VALUES(2, 1);
INSERT INTO public.tienda_producto (id_producto, id_tienda) VALUES(3, 1);
INSERT INTO public.tienda_producto (id_producto, id_tienda) VALUES(4, 2);
INSERT INTO public.tienda_producto (id_producto, id_tienda) VALUES(5, 2);
INSERT INTO public.tienda_producto (id_producto, id_tienda) VALUES(6, 2);
INSERT INTO public.tienda_producto (id_producto, id_tienda) VALUES(7, 3);
INSERT INTO public.tienda_producto (id_producto, id_tienda) VALUES(8, 3);
INSERT INTO public.tienda_producto (id_producto, id_tienda) VALUES(9, 3);
INSERT INTO public.tienda_producto (id_producto, id_tienda) VALUES(10, 4);
