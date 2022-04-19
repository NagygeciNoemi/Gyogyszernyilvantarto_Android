<?php
require "DataBase.php";
$db = new DataBase();
if (isset($_POST['username']) && isset($_POST['p_password'])) {
    if ($db->dbConnect()) {
        if ($db->logIn("patient", $_POST['username'], $_POST['p_password'])) {
            echo "Login Success";
        } else echo "Username or Password wrong";
    } else echo "Error: Database connection";
} else echo "All fields are required";
?>