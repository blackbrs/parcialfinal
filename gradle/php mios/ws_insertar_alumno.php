<?php
$carnet=$_REQUEST['carnet'];
$nombre=$_REQUEST['nombre'];
$apellido=$_REQUEST['apellido'];
$sexo=$_REQUEST['sexo'];
$matganadas=$_REQUEST['matganadas'];
$servidor="localhost";
$usuario="id6224239_guille";
$baseDatos="id6224239_ca14080";
$password="kuroimato";
$respuesta=array('resultado'=>0);
json_encode($respuesta);
$conexion=mysqli_connect($servidor,$usuario,$password,$baseDatos);
$query = "INSERT INTO ALUMNO VALUES('".$carnet."','".$nombre."','".$apellido."','".$sexo."',".$matganadas.");";
$resultado = mysqli_query($conexion,$query) or die(mysqli_error($conexion));
//Si la respuesta es correcta enviamos 1 y sino enviamos 0
if(mysqli_affected_rows($conexion) == 1) $respuesta=array('resultado'=>1);
echo json_encode($respuesta);
mysqli_close($conexion);
?>