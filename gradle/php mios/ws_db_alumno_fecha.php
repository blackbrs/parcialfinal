<?php
//error_reporting(E_ALL ^ E_DEPRECATED);
$year=$_REQUEST['year'];
$month=$_REQUEST['month'];
$day=$_REQUEST['day'];
$servidor="localhost";
$usuario="id6224239_guille";
$baseDatos="id6224239_ca14080";
$password="kuroimato";
$conexion=mysqli_connect($servidor,$usuario,$password,$baseDatos)
or
die ("Problemas en la conexion");
$registros=mysqli_query($conexion,"Select * from ALUMNO where
fecha_modificado>'".$year."-".$month."-".$day."'") or
 die("Problemas en el select:".mysqli_error($conexion));
 $filas=array();
while ($reg=mysqli_fetch_assoc($registros))
{
$filas[]=$reg;
}
echo json_encode($filas);
mysqli_close($conexion);
?>