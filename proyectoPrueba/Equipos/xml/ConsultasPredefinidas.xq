for $x in doc("ligaConsultas.xml")//Equipo
order by $x/titulos
return $x/@nombre 