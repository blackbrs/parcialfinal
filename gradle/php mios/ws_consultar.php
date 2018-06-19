<?php
$codmateria=$_REQUEST['codmateria'];
$servidor="localhost";
$usuario="id6224239_guille";
$baseDatos="id6224239_ca14080";
$password="kuroimato";
$conexion=mysqli_connect($servidor,$usuario,$password,$baseDatos) or
die ("Problemas en la conexion");
$db_select_db = mysqli_select_db($conexion,$baseDatos);
if (!$db_select_db) {
 die("Problemas en la seleccion de la base de datos " . mysqli_error($conexion));
}
$registros=mysqli_query($conexion," SELECT * FROM MATERIA WHERE codmateria= '".$codmateria."' ") or
 die("Problemas en el select:".mysqli_error($conexion));
$filas=array();
$reg=mysqli_fetch_assoc($registros);
echo json_encode($reg);
mysqli_close($conexion);
?>