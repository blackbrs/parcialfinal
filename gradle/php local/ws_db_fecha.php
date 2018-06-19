<?php
$year=$_REQUEST['year'];
$month=$_REQUEST['month'];
$day=$_REQUEST['day'];

$servidor="localhost";
$usuario="root";
$password="";
$conexion=mysql_connect($servidor,$usuario,$password) or
die ("Problemas en la conexion");
$baseDatos="carnet";
mysql_select_db($baseDatos,$conexion) 
  or  die("Problemas en la selección de la base de datos");
 $registros=mysql_query("Select * from ALUMNO where fecha_modificado>'".$year."-".$month."-".$day."'",$conexion) or
  die("Problemas en el select:".mysql_error());
 $filas=array();
while ($reg=mysql_fetch_assoc($registros))
{
 $filas[]=$reg;
}
echo json_encode($filas);
mysql_close($conexion);
?>
