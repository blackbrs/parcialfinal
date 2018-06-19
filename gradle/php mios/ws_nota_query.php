<?php
$codmateria=$_REQUEST['codmateria'];
$carnet=$_REQUEST['carnet'];
$ciclo=$_REQUEST['ciclo'];
$servidor="localhost";
$usuario="id6224239_guille";
$baseDatos="id6224239_ca14080";
$password="kuroimato";
$conexion=mysqli_connect($servidor,$usuario,$password,$baseDatos) or
die ("Problemas en la conexion");
$db_select_db = mysqli_select_db($conexion,$baseDatos);
if (!$db_select_db) {
 die("Problemas en la seleccion de la base de datos " . mysqli_error($connection));
}
//mysqli_select_db($baseDatos,$conexion)
// or die("Problemas en la seleccion de la base de datos");
$registros=mysqli_query($conexion,"SELECT * FROM NOTA WHERE carnet='".$carnet."' AND
codmateria='".$codmateria."' AND ciclo='".$ciclo."'") or
 die("Problemas en el select:".mysql_error());
$filas=array();
while ($reg=mysqli_fetch_assoc($registros))
{
$filas[]=$reg;
}
echo json_encode($filas);
mysqli_close($conexion);
?>