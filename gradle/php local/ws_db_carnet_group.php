<?php
$carnet=$_REQUEST['carnet'];
$servidor="localhost";
$usuario="root";
$baseDatos="carnet";
$password="";
$conexion=mysql_connect($servidor,$usuario,$password) or
die ("Problemas en la conexion");
mysql_select_db($baseDatos,$conexion) 
  or  die("Problemas en la selección de la base de datos");
   $registros=mysql_query("SELECT CARNET,AVG(NOTAFINAL) AS PROMEDIO FROM NOTA WHERE CARNET='".$carnet."' group by carnet",$conexion) or
  die("Problemas en el select:".mysql_error());
 $filas=array();
while ($reg=mysql_fetch_assoc($registros))
{
 $filas[]=$reg;
}
echo json_encode($filas);
mysql_close($conexion);
?>
