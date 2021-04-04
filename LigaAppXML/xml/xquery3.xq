(:La siguiente consulta te devuelve los entrenadores 
de los equipos franceses:)

for $x in doc("ligaPredefinida.xml")/Liga/Equipo
	where ($x/@pais="Francia")
	return $x/entrenador
