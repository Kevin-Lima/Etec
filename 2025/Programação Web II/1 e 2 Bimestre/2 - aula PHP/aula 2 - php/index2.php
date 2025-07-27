<?php
    $x = 10;
    $y = 20;

    $z = 1;


    if ($z == 1) {
        // Adição
        $total = $x + $y;  
        echo $total;
    } elseif ($z == 2) {
        // Subtração
        $total = $x - $y;
        echo $total;
    } elseif ($z == 3) {
        // Multiplicação
        $total = $x * $y;  
        echo $total;
    } else {
        // Divisão
        $total = $x / $y;
        echo $total;
    }
?>