(:La siguiente consulta devuelve el presidente del Real Madrid:)

for $x in doc("./xml/ligaPredefinida.xml")/Liga/Equipo
	where ($x/@nombre="Real Madrid")
	return <presidente> {data($x/presidente)}</presidente>