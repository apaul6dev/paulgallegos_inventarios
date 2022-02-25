# paulgallegos_inventarios

Esta aplicacion fue desarrollada con spring boot y usado postgres como base de datos

#end points para descargar reportes csv

http://localhost:8090/tiendas/transacciones

http://localhost:8090/tiendas/montoVendio

#Obtener lista de productos 

http://localhost:8090/productos

actualizar el stockel stock 
put: 
http://localhost:8090/productos/actualizarStock/1/1

#Agregar productos a la tienda

http://localhost:8090/tiendas/setproductos

{
    "tienda":{
        "idTienda": 1,
        "nombre":"Tia"
        },
    "productos":[
         {
        "cod": "cod10",
        "name": "name10",
        "price": 0.11,
        "stock": 10
        },
        {
        "cod": "cod13",
        "name": "name13",
        "price": 0.11,
        "stock": 11
        }
    ]
}


#Obtener lista de clientes

http://localhost:8090/clientes/

#Guardar cliente

Post: 
http://localhost:8090/clientes



#Modificar cliente

Put:
http://localhost:8090/clientes

#Eliminar cliente
Delete:
http://localhost:8090/clientes/7

# agregar pedido 
post: 
http://localhost:8090/pedidos/

{
    "cliente":{
        "idCliente":2
    },
    "fecha":"10-02-2022 22:22:22",
    "pedidoDetalle":[
        {
            "cantidad":10,
            "tiendaProducto":{
                "tienda": {"idTienda":2},
                "producto":{"idProducto":6}
            }
        }
    ]

}











