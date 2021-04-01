(:La siguiente consulta te devuelve los equipos ordenados según el 
número de titulos:)

(:for $x in doc("ligaConsultas.xml")//Equipo
order by $x/titulos
return $x/@nombre :)


for $x in doc("ligaConsultas.xml")//Equipo
	order by $x/titulos descending
	return $x[@nombre]