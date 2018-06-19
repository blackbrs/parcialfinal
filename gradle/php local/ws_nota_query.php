<?php
$codmateria=$_REQUEST['codmateria'];
$carnet=$_REQUEST['carnet'];
$ciclo=$_REQUEST['ciclo'];
$servidor="localhost";
$usuario="root";
$password="";
$conexion=mysql_connect($servidor,$usuario,$password) or
die ("Problemas en la conexion");
$baseDatos="carnet";
mysql_select_db($baseDatos,$conexion) 
  or  die("Problemas en la selección de la base de datos");
 $registros=mysql_query("SELECT * FROM NOTA WHERE carnet='".$carnet."' AND codmateria='".$codmateria."' AND ciclo='".$ciclo."'",$conexion) or
  die("Problemas en el select:".mysql_error());
 $filas=array();
while ($reg=mysql_fetch_assoc($registros))
{
 $filas[]=$reg;
}
echo json_encode($filas);
mysql_close($conexion);
?>
