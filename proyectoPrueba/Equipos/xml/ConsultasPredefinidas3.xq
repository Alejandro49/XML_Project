for $x in doc("liga.xml")/Liga/Equipo
where ($x/@pais="Francia")
return $x/entrenador
