for $x in doc("ligaConsultas.xml")/Liga/Equipo
where ($x/@pais="Francia")
return $x/entrenador
