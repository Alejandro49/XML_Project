(:La siguiente consulta devuelve el presidente del Real Madrid:)

(:for $x in doc("ligaConsultas.xml")/Liga/Equipo
return if ($x/@nombre="Real Madrid")
then <presidente> {data($x/presidente)}</presidente>:)

for $x in doc("ligaConsultas.xml")/Liga/Equipo
	where ($x/@nombre="Real Madrid")
	return <presidente> {data($x/presidente)}</presidente>