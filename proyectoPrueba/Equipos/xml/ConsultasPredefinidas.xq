for $x in doc("liga.xml")//Equipo
order by $x/titulos
return $x/@nombre 