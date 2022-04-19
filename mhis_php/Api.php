<?php
session_start();
$servername = "localhost";
$username = "root";
$password = "";
$database = "mhis_db";
 
 
$conn = new mysqli($servername, $username, $password, $database);
 
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 

$doctors = array(); 

$sql = "SELECT d_name, office, d_email FROM doctor ORDER BY office;";

$stmt = $conn->prepare($sql);
 
$stmt->execute();
 
$stmt->bind_result($d_name, $office, $d_email);
 
while($stmt->fetch()){
 
 $temp = [
 'd_name'=>$d_name,
 'office'=>$office,
 'd_email'=>$d_email
 ];
 
 array_push($doctors, $temp);
}
 
echo json_encode($doctors);
