(:La siguiente consulta te devuelve los equipos ordenados según el 
número de titulos:)

for $x in doc("./xml/ligaPredefinida.xml")//Equipo
	order by $x/titulos descending
	return $x[@nombre]