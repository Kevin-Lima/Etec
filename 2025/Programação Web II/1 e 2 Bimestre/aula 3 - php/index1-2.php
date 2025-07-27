<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>

<?php
    for($i = 1; $i <= 10; $i = $i + 1){
    //1 2 3 4 5 6 7 8 9 10
        for($x = 0; $x <= 10; $x = $x + 1){
            $resultado = $i * $x;
            echo $i . " X " . $x . " = " . $resultado . "<br>";
        }
        echo "<br>";
    }
?> 

</body>
</html>