<?php
$codmateria=$_REQUEST['codmateria'];
$carnet=$_REQUEST['carnet'];
$ciclo=$_REQUEST['ciclo'];
$notafinal=$_REQUEST['notafinal'];
$servidor="localhost";
$usuario="id6224239_guille";
$baseDatos="id6224239_ca14080";
$password="kuroimato";
$respuesta=array('resultado'=>0);
json_encode($respuesta);
$conexion=mysqli_connect($servidor,$usuario,$password,$baseDatos) or
die ("Problemas en la conexion");
$query = "UPDATE NOTA SET notafinal=".$notafinal." WHERE carnet='".$carnet."' AND
codmateria='".$codmateria."' AND ciclo='".$ciclo."'";
$resultado = mysqli_query($conexion,$query) or die(mysqli_error($conexion));
//Si la respuesta es correcta enviamos 1 y sino enviamos 0
if(mysqli_affected_rows($conexion) == 1)
 $respuesta=array('resultado'=>1);
echo json_encode($respuesta);
mysqli_close($conexion);
?>