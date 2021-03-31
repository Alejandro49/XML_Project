for $x in doc("ligaConsultas.xml")/Liga/Equipo
return if ($x/@nombre="Real Madrid")
then <presidente> {data($x/presidente)}</presidente>
