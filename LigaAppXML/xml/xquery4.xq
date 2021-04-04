(:La siguiente consulta te devuelve los equipos españoles:)

for $x in doc("./xml/ligaPredefinida.xml")//Equipo
	where ($x/@pais="España")
	return $x[@nombre]