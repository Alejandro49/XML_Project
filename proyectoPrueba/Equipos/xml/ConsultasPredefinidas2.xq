for $x in doc("liga.xml")/Liga/Equipo
return if ($x/@nombre="Real Madrid")
then <presidente> {data($x/presidente)}</presidente>
