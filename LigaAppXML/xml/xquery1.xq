(:La siguiente consulta te devuelve los equipos ordenados según el 
número de titulos:)

for $x in doc("ligaPredefinida.xml")//Equipo
	order by $x/titulos descending
	return $x[@nombre]