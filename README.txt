Relación de los proyectos:
	PruebaArchivoJson: Es el Java Application para probar el buen formato de los campos
	EntregarArchivo: Es el servicio web con un método GET que recibe el archivo Ruta.json y devuelve el mismo archivo en formato application/json	
		El link para probarlo con la extensión REST de Firefox es: http://127.0.0.1:8080/EntregarArchivo-0.1/api/consultar
	RecibirArchivo: Es el servicio web con un método POST que recibe los datos de tipo application/json y devuelve un análisis de la cantidad y el buen formato de los campos recibidos.
		El link para probarlo con la extensión REST de Firefox es: http://127.0.0.1:8080/RecibirArchivo-0.1/api/recibir
		Es necesario crear un Header Content-type application/json para que los datos puedan ser recibidos

		